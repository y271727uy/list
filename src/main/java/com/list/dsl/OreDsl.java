package com.list.dsl;

import com.list.ListMod;
import com.list.worldgen.OreConfigFilter;
import com.list.worldgen.OreKind;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import static com.list.ListMod.REGISTRATE;

/** A declaration connects names, block/item models, loot and vanilla Feature.ORE datagen. */
public final class OreDsl {
    private static final Map<String, Definition> DEFINITIONS = new LinkedHashMap<>();

    private OreDsl() {}

    /** Call during mod construction, for example in ModBlockOre's static fields. */
    public static Definition ore(String id) {
        return new Definition(id);
    }

    public static List<Definition> definitions() {
        return List.copyOf(DEFINITIONS.values());
    }

    public static void bootstrapConfiguredFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
        for (Definition definition : definitions()) {
            if (!definition.generate) continue;
            if (definition.bedrockGeneration) {
                context.register(definition.configuredKey(), new ConfiguredFeature<>(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(definition.block.get()))));
                continue;
            }
            var targets = new ArrayList<OreConfiguration.TargetBlockState>();
            definition.replaceable.stream()
                    .map(tag -> OreConfiguration.target(new TagMatchTest(tag), definition.block.get().defaultBlockState()))
                    .forEach(targets::add);
            definition.replaceableBlocks.stream()
                    .map(block -> OreConfiguration.target(new BlockMatchTest(block.get()), definition.block.get().defaultBlockState()))
                    .forEach(targets::add);
            context.register(definition.configuredKey(), new ConfiguredFeature<>(Feature.ORE,
                    new OreConfiguration(targets, definition.veinSize)));
        }
    }

    public static void bootstrapPlacedFeatures(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);
        for (Definition definition : definitions()) {
            if (!definition.generate) continue;
            var placements = new ArrayList<PlacementModifier>();
            placements.add(new OreConfigFilter(resource(definition.family()), definition.base, definition.kind == OreKind.GEM));
            placements.add(CountPlacement.of(definition.countPerChunk));
            placements.add(RarityFilter.onAverageOnceEvery(2));
            placements.add(InSquarePlacement.spread());
            placements.add(HeightRangePlacement.uniform(
                    definition.bedrockGeneration ? VerticalAnchor.aboveBottom(definition.minY) : VerticalAnchor.absolute(definition.minY),
                    definition.bedrockGeneration ? VerticalAnchor.aboveBottom(definition.maxY) : VerticalAnchor.absolute(definition.maxY)));
            if (definition.bedrockGeneration) {
                placements.add(BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Blocks.BEDROCK)));
            }
            placements.add(BiomeFilter.biome());
            context.register(definition.placedKey(), new PlacedFeature(configured.getOrThrow(definition.configuredKey()), placements));
        }
    }

    public static void bootstrapBiomeModifiers(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placed = context.lookup(Registries.PLACED_FEATURE);
        for (Definition definition : definitions()) {
            if (!definition.generate) continue;
            context.register(definition.biomeModifierKey(), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                    biomes.getOrThrow(definition.biomes), HolderSet.direct(placed.getOrThrow(definition.placedKey())),
                    GenerationStep.Decoration.UNDERGROUND_ORES));
            if (definition.bedrockGeneration) {
                context.register(definition.biomeModifierKey("_nether"), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_NETHER), HolderSet.direct(placed.getOrThrow(definition.placedKey())),
                        GenerationStep.Decoration.UNDERGROUND_ORES));
            }
        }
    }

    public static final class Definition {
        private final String id;
        private OreKind kind = OreKind.ORE;
        private String family;
        private String base = "stone";
        private String englishName;
        private String chineseName;
        private ResourceLocation texture;
        private ResourceLocation overlay;
        private int overlayColor = -1;
        private Supplier<? extends ItemLike> drop;
        private int minDrops = 1;
        private int maxDrops = 1;
        private boolean fortune = true;
        private Supplier<? extends Block> propertiesFrom = () -> Blocks.STONE;
        private NonNullFunction<BlockBehaviour.Properties, Block> blockFactory = Block::new;
        private boolean unbreakable;
        private boolean bedrockGeneration;
        private TagKey<Block> toolTier = BlockTags.NEEDS_IRON_TOOL;
        private List<TagKey<Block>> miningTools = List.of(BlockTags.MINEABLE_WITH_PICKAXE);
        private float hardness = 3.0F;
        private float resistance = 3.0F;
        private boolean generate;
        private int veinSize;
        private int countPerChunk;
        private int minY;
        private int maxY;
        private List<TagKey<Block>> replaceable = List.of(BlockTags.STONE_ORE_REPLACEABLES, BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        private List<Supplier<? extends Block>> replaceableBlocks = List.of();
        private TagKey<Biome> biomes = BiomeTags.IS_OVERWORLD;
        private BlockEntry<Block> block;

        private Definition(String id) {
            if (id == null || !id.matches("[a-z0-9_][a-z0-9_./-]*")) throw new IllegalArgumentException("Invalid ore id: " + id);
            this.id = id;
        }

        /** Stable config identity, independent of the variant registry ID and runtime config. */
        public Definition managedGeneration(OreKind kind, String material, OreHost host) {
            mutable();
            this.kind = Objects.requireNonNull(kind);
            this.family = ListMod.rl(requireText(material) + "_ore").toString();
            this.base = Objects.requireNonNull(host).configKey();
            return this;
        }

        public Definition names(String englishName, String chineseName) {
            mutable();
            this.englishName = requireText(englishName);
            this.chineseName = requireText(chineseName);
            return this;
        }

        /** A complete ore texture. Unqualified paths use list:, qualified ids keep their namespace. */
        public Definition texture(String texture) {
            mutable();
            this.texture = resource(texture);
            this.overlay = null;
            return this;
        }

        /** Base stays untinted; a transparent overlay uses tint index 0 for both block and item. */
        public Definition layeredModel(String baseTexture, String overlayTexture, int color) {
            mutable();
            this.texture = resource(baseTexture);
            this.overlay = resource(overlayTexture);
            this.overlayColor = color;
            return this;
        }

        public Definition drops(Supplier<? extends ItemLike> drop) {
            return drops(drop, 1, 1);
        }

        /** Base count before Fortune; Silk Touch returns the block. Suppliers resolve during loot datagen. */
        public Definition drops(Supplier<? extends ItemLike> drop, int min, int max) {
            mutable();
            if (min < 1 || max < min || max > 64) throw new IllegalArgumentException("Drop count must be 1..64 with min <= max");
            this.drop = Objects.requireNonNull(drop);
            this.minDrops = min;
            this.maxDrops = max;
            return this;
        }

        public Definition fortune(boolean enabled) {
            mutable();
            this.fortune = enabled;
            return this;
        }

        public Definition propertiesFrom(Supplier<? extends Block> block) {
            mutable();
            this.propertiesFrom = Objects.requireNonNull(block);
            return this;
        }

        public Definition blockFactory(NonNullFunction<BlockBehaviour.Properties, Block> factory) {
            mutable();
            this.blockFactory = Objects.requireNonNull(factory);
            return this;
        }

        /** Vanilla bedrock-style mining/blast protection, no loot, and boss immunity tags. */
        public Definition unbreakable() {
            mutable();
            this.unbreakable = true;
            this.hardness = -1.0F;
            this.resistance = 3600000.0F;
            return this;
        }

        /** Single-block placement only, never a spreading ore vein. Relative anchors preserve the bottom layer. */
        public Definition protectedBedrockGeneration(int attempts) {
            generation(1, attempts, 1, 4);
            this.bedrockGeneration = true;
            this.biomes = BiomeTags.IS_OVERWORLD;
            this.replaceableBlocks = List.of(() -> Blocks.BEDROCK);
            this.replaceable = List.of();
            return this;
        }

        public Definition toolTier(TagKey<Block> toolTier) {
            mutable();
            this.toolTier = Objects.requireNonNull(toolTier);
            return this;
        }

        @SafeVarargs
        public final Definition mineableWith(TagKey<Block>... tags) {
            mutable();
            if (tags.length == 0) throw new IllegalArgumentException("At least one mining tool tag is required");
            this.miningTools = List.of(tags);
            return this;
        }

        public Definition strength(float hardness, float resistance) {
            mutable();
            if (!Float.isFinite(hardness) || !Float.isFinite(resistance) || hardness < 0 || resistance < 0) {
                throw new IllegalArgumentException("Ore strength must be finite and nonnegative");
            }
            this.hardness = hardness;
            this.resistance = resistance;
            return this;
        }

        /** Enables vanilla ore generation. Count = attempts per chunk, size = vanilla vein size. */
        public Definition generation(int veinSize, int countPerChunk, int minY, int maxY) {
            mutable();
            if (veinSize < 1 || veinSize > 64 || countPerChunk < 1 || countPerChunk > 256 || minY > maxY) {
                throw new IllegalArgumentException("Size must be 1..64, attempts 1..256, minY <= maxY");
            }
            if (minY < -2032 || maxY > 2031) throw new IllegalArgumentException("Y outside vanilla VerticalAnchor range");
            this.generate = true;
            this.veinSize = veinSize;
            this.countPerChunk = countPerChunk;
            this.minY = minY;
            this.maxY = maxY;
            return this;
        }

        @SafeVarargs
        public final Definition replaceable(TagKey<Block>... tags) {
            mutable();
            if (tags.length == 0) throw new IllegalArgumentException("At least one replaceable block tag is required");
            this.replaceable = List.of(tags);
            this.replaceableBlocks = List.of();
            return this;
        }

        /** Restrict generation to these exact host blocks instead of broad block tags. */
        @SafeVarargs
        public final Definition replaceableBlocks(Supplier<? extends Block>... blocks) {
            mutable();
            if (blocks.length == 0) throw new IllegalArgumentException("At least one replaceable block is required");
            this.replaceable = List.of();
            this.replaceableBlocks = List.of(blocks);
            return this;
        }

        public Definition biomes(TagKey<Biome> biomes) {
            mutable();
            this.biomes = Objects.requireNonNull(biomes);
            return this;
        }

        /** Omit generation() for an ore with no natural generation. Freeze the declaration after registering. */
        public BlockEntry<Block> register() {
            mutable();
            if (generate && replaceable.isEmpty() && replaceableBlocks.isEmpty()) {
                throw new IllegalStateException("Generated ore requires at least one replaceable host: " + id);
            }
            if (englishName == null || chineseName == null || texture == null || drop == null) {
                throw new IllegalStateException("Ore requires names, texture/model and drop supplier: " + id);
            }
            if (DEFINITIONS.containsKey(id)) throw new IllegalStateException("Duplicate ore id: " + id);
            var builder = REGISTRATE.listBLock(id, blockFactory)
                    .initialProperties(propertiesFrom::get)
                    .properties(properties -> {
                        properties.strength(hardness, resistance).requiresCorrectToolForDrops();
                        if (unbreakable) properties.noLootTable();
                        return properties;
                    })
                    .lang(englishName)
                    .tag(toolTier)
                    .blockstate((ctx, provider) -> {
                        var model = provider.models().cubeAll(ctx.getName(), texture);
                        if (overlay != null) {
                            model.renderType("minecraft:cutout_mipped");
                            model.texture("overlay", overlay);
                            model.element().cube("#all").end();
                            model.element().cube("#overlay")
                                    .from(-0.01F, -0.01F, -0.01F)
                                    .to(16.01F, 16.01F, 16.01F)
                                    .faces((direction, face) -> face.tintindex(0)).end();
                        }
                        provider.simpleBlock(ctx.get(), model);
                    })
                    .loot((tables, oreBlock) -> {
                        var dropItem = Objects.requireNonNull(drop.get(), "Missing ore drop for " + id).asItem();
                        if (dropItem == Items.AIR) throw new IllegalStateException("Ore drop must not be air: " + id);
                        var entry = LootItem.lootTableItem(dropItem)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)));
                        if (fortune) entry.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE));
                        tables.add(oreBlock, tables.createSilkTouchDispatchTable(oreBlock,
                                tables.applyExplosionDecay(oreBlock, entry)));
                    });
            for (TagKey<Block> miningTool : miningTools) builder.tag(miningTool);
            if (unbreakable) builder.tag(BlockTags.WITHER_IMMUNE, BlockTags.DRAGON_IMMUNE);
            if (overlay != null) builder.tint(overlayColor);
            block = builder.simpleItem().register();
            DEFINITIONS.put(id, this);
            return block;
        }

        public String id() { return id; }
        public OreKind kind() { return kind; }
        public String family() { return family != null ? family : ListMod.rl(id).toString(); }
        public String base() { return base; }
        public String englishName() { return englishName; }
        public String chineseName() { return chineseName; }

        public BlockEntry<Block> block() {
            if (block == null) throw new IllegalStateException("Ore has not been registered: " + id);
            return block;
        }

        private void mutable() {
            if (block != null) throw new IllegalStateException("Ore declaration is frozen after register(): " + id);
        }

        private ResourceKey<ConfiguredFeature<?, ?>> configuredKey() {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, ListMod.rl(id));
        }

        private ResourceKey<PlacedFeature> placedKey() {
            return ResourceKey.create(Registries.PLACED_FEATURE, ListMod.rl(id));
        }

        private ResourceKey<BiomeModifier> biomeModifierKey() {
            return biomeModifierKey("");
        }

        private ResourceKey<BiomeModifier> biomeModifierKey(String suffix) {
            return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ListMod.rl("add_" + id + suffix));
        }
    }

    private static String requireText(String text) {
        if (text == null || text.isBlank()) throw new IllegalArgumentException("Name must not be blank");
        return text;
    }

    @SuppressWarnings("removal")
    private static ResourceLocation resource(String location) {
        Objects.requireNonNull(location);
        return location.contains(":") ? new ResourceLocation(location) : ListMod.rl(location);
    }
}
