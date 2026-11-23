package com.list.dsl;

import com.list.worldgen.OreKind;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;

import java.util.Locale;
import java.util.function.Supplier;

/** Shared exact hosts for gem and ordinary ores. Keeps existing registry IDs stable. */
public enum OreHost {
    STONE("", "", "", () -> Blocks.STONE, "stone", 0, 64, 3.0f, BiomeTags.IS_OVERWORLD, 4, 1),
    DEEPSLATE("deepslate_", "Deepslate ", "深层", () -> Blocks.DEEPSLATE, "deepslate", -64, -1, 4.5f, BiomeTags.IS_OVERWORLD, 4, 1),
    GRANITE("granite_", "Granite ", "花岗岩", () -> Blocks.GRANITE, "granite", -64, 64, 3.0f, BiomeTags.IS_OVERWORLD, 4, 1),
    DIORITE("diorite_", "Diorite ", "闪长岩", () -> Blocks.DIORITE, "diorite", -64, 64, 3.0f, BiomeTags.IS_OVERWORLD, 4, 1),
    ANDESITE("andesite_", "Andesite ", "安山岩", () -> Blocks.ANDESITE, "andesite", -64, 64, 3.0f, BiomeTags.IS_OVERWORLD, 4, 1),
    TUFF("tuff_", "Tuff ", "凝灰岩", () -> Blocks.TUFF, "tuff", -64, 0, 3.0f, BiomeTags.IS_OVERWORLD, 4, 1),
    CALCITE("calcite_", "Calcite ", "方解石", () -> Blocks.CALCITE, "calcite", -64, 256, 3.0f, BiomeTags.IS_OVERWORLD, 4, 1),
    NETHERRACK("netherrack_", "Nether ", "下界岩", () -> Blocks.NETHERRACK, "netherrack", 8, 120, 3.0f, BiomeTags.IS_NETHER, 6, 2),
    ENDSTONE("endstone_", "End Stone ", "末地石", () -> Blocks.END_STONE, "end_stone", 0, 96, 3.0f, BiomeTags.IS_END, 6, 2),
    SANDSTONE("sandstone_", "Sandstone ", "砂岩", () -> Blocks.SANDSTONE, "sandstone", -64, 256, 0.8f, BiomeTags.IS_OVERWORLD, 4, 1),
    GRAVEL("gravel_", "Gravel ", "沙砾", () -> Blocks.GRAVEL, "gravel", -64, 256, 0.6f, BiomeTags.IS_OVERWORLD, 4, 1),
    SAND("sand_", "Sand ", "沙子", () -> Blocks.SAND, "sand", -64, 256, 0.5f, BiomeTags.IS_OVERWORLD, 4, 1),
    RED_SAND("red_sand_", "Red Sand ", "红沙", () -> Blocks.RED_SAND, "red_sand", -64, 256, 0.5f, BiomeTags.IS_OVERWORLD, 4, 1),
    RED_SANDSTONE("red_sandstone_", "Red Sandstone ", "红砂岩", () -> Blocks.RED_SANDSTONE, "red_sandstone", -64, 256, 0.8f, BiomeTags.IS_OVERWORLD, 4, 1),
    BASALT("basalt_", "Basalt ", "玄武岩", () -> Blocks.BASALT, "basalt_side", 8, 120, 3.0f, BiomeTags.IS_NETHER, 6, 2),
    BLACKSTONE("blackstone_", "Blackstone ", "黑石", () -> Blocks.BLACKSTONE, "blackstone", 8, 120, 3.0f, BiomeTags.IS_NETHER, 6, 2),
    BEDROCK("bedrock_", "Bedrock ", "基岩", () -> Blocks.BEDROCK, "bedrock", 1, 4, -1.0f, BiomeTags.IS_OVERWORLD, 1, 1);

    public final String prefix, english, chinese, texture;
    public final Supplier<Block> block;
    public final int minY, maxY, size, attempts;
    public final float hardness;
    public final TagKey<Biome> biomes;

    OreHost(String prefix, String english, String chinese, Supplier<Block> block, String texture,
            int minY, int maxY, float hardness, TagKey<Biome> biomes, int size, int attempts) {
        this.prefix = prefix; this.english = english; this.chinese = chinese; this.block = block;
        this.texture = "minecraft:block/" + texture; this.minY = minY; this.maxY = maxY;
        this.hardness = hardness; this.biomes = biomes; this.size = size; this.attempts = attempts;
    }

    public BlockEntry<Block> register(String material, String englishName, String chineseName,
                                      String overlay, int color, Supplier<? extends ItemLike> drop) {
        return register(material, englishName, chineseName, overlay, color, drop, true);
    }

    public BlockEntry<Block> register(String material, String englishName, String chineseName,
                                      String overlay, int color, Supplier<? extends ItemLike> drop,
                                      boolean generates) {
        return register(material, englishName, chineseName, overlay, color, drop, generates, OreKind.ORE);
    }

    public String configKey() {
        return this == ENDSTONE ? "end_stone" : name().toLowerCase(Locale.ROOT);
    }

    public boolean matchesConfig(String value) {
        String normalized = value.strip().toLowerCase(Locale.ROOT);
        return normalized.equals(configKey()) || normalized.equals("minecraft:" + configKey())
                || normalized.equals(name().toLowerCase(Locale.ROOT))
                || (!chinese.isEmpty() && normalized.equals(chinese))
                || (this == STONE && (normalized.equals("石头") || normalized.equals("石")))
                || (this == DEEPSLATE && normalized.equals("深板岩"));
    }

    public BlockEntry<Block> register(String material, String englishName, String chineseName,
                                      String overlay, int color, Supplier<? extends ItemLike> drop,
                                      boolean generates, OreKind kind) {
        var ore = OreDsl.ore(prefix + material + "_ore")
                .managedGeneration(kind, material, this)
                .names(english + englishName + " Ore", chinese + chineseName + "矿石")
                .layeredModel(texture, overlay, color | 0xff000000)
                .propertiesFrom(block).drops(drop)
                .mineableWith(this == SAND || this == RED_SAND || this == GRAVEL
                        ? BlockTags.MINEABLE_WITH_SHOVEL : BlockTags.MINEABLE_WITH_PICKAXE);
        if (this == BEDROCK) ore.unbreakable();
        else ore.strength(hardness, 3.0f);
        if (this == SAND || this == RED_SAND || this == GRAVEL) ore.blockFactory(FallingBlock::new);
        if (generates) {
            if (this == BEDROCK) ore.protectedBedrockGeneration(attempts);
            else ore.replaceableBlocks(block).biomes(biomes).generation(size, attempts, minY, maxY);
        }
        return ore.register();
    }
}
