package com.list.all;

import com.list.ListMod;
import com.list.block.*;
import com.list.block.TapperBlock;
import com.list.block.common.CommonBlock;
import com.list.block.common.CommonCakeBlock;
import com.list.block.common.CommonPizzaBlock;
import com.list.block.common.CommonPlushieBlock;
import com.list.block.crop.mushroom.StrawMushroomBlock;
import com.list.block.crop.mushroom.SeaMushroomBlock;
import com.list.block.crop.mushroom.CaveMushroomBlock;
import com.list.block.crop.colony.SeaMushroomColonyBlock;
import com.list.block.crop.CommonEightStageCrop;
import com.list.block.crop.CommonBerryCrop;
import com.list.block.crop.CommonDesertCrop;
import com.list.block.crop.CommonTallEightStageCrop;
import com.list.block.crop.CommonEightStageRegrowCrop;
import com.list.block.crop.CommonMelonBlock;
import com.list.block.crop.CommonSixStageRegrowCrop;
import com.list.block.crop.CommonTallRegrowCrop;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.StemBlock;
import com.list.block.crop.CommonFourStageCrop;
import com.list.block.crop.CommonRegrowCrop;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import com.list.block.crop.rice.UplandRiceBlock;
import com.list.block.crop.rice.UplandRicePaniclesBlock;
import com.list.item.crop.UplandRiceSeedsItem;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import com.list.block.ForestryHybridizerBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.BlockModelBuilder;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

import static com.list.ListMod.REGISTRATE;

public class ModBlocks {

    private static final VoxelShape LARGE_MEAL_TRAY_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    private static final VoxelShape MUSHROOM_POT_PIE_SHAPE = Shapes.or(LARGE_MEAL_TRAY_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 6.0D, 14.0D));
    private static final VoxelShape OMURICE_SHAPE = Shapes.or(LARGE_MEAL_TRAY_SHAPE, Block.box(4.0D, 2.0D, 4.0D, 12.0D, 10.0D, 12.0D));
    private static final VoxelShape ROASTED_MUTTON_RACK_SHAPE = Shapes.or(LARGE_MEAL_TRAY_SHAPE, Block.box(2.0D, 2.0D, 2.0D, 14.0D, 10.0D, 14.0D));

    public static final BlockEntry<GreenhouseFurnaceBlock> GREENHOUSE_FURNACE = REGISTRATE
            .listBLock("greenhouse_furnace", GreenhouseFurnaceBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .item()
            .tooltips("12456", "7890123")
            .build()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/blast_furnace_top"),
                        provider.mcLoc("block/blast_furnace_top"),
                        provider.modLoc("block/greenhouse_furnace/greenhouse_furnace"),
                        provider.mcLoc("block/blast_furnace_side"),
                        provider.mcLoc("block/blast_furnace_side"),
                        provider.mcLoc("block/blast_furnace_side")
                ).texture("particle", provider.mcLoc("block/blast_furnace_top"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<com.list.block.FishSmokerBlock> FISHSMOKER = REGISTRATE
            .block("fish_smoker", com.list.block.FishSmokerBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                // 手工维护到 src/main/resources，datagen 不再生成 fish_smoker 的 blockstate/model。
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<FishPondCoreBlock> FISHPOND_CORE = REGISTRATE
            .block("fishpond_core", FishPondCoreBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone"),
                        provider.modLoc("block/fishpond/fishpond_face"),
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone")
                ).texture("particle", provider.mcLoc("block/smooth_stone"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();
//旱稻
    public static final BlockEntry<UplandRiceBlock> UPLAND_RICE = REGISTRATE
            .listBLock("upland_rice", UplandRiceBlock::new)
            .initialProperties(() -> Blocks.WHEAT)
            .properties(p -> p.noOcclusion().randomTicks())
            .item(UplandRiceSeedsItem::new)
            .lang("Upland Rice Seeds")
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/upland_rice_seeds")))
            .build()
            .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.get())
                    .partialState().with(UplandRiceBlock.AGE, 0).with(UplandRiceBlock.SUPPORTING, false)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage0"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 0).with(UplandRiceBlock.SUPPORTING, true)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage0"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 1).with(UplandRiceBlock.SUPPORTING, false)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage1"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 1).with(UplandRiceBlock.SUPPORTING, true)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage1"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 2).with(UplandRiceBlock.SUPPORTING, false)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage2"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 2).with(UplandRiceBlock.SUPPORTING, true)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage2"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 3).with(UplandRiceBlock.SUPPORTING, false)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_stage3"))).addModel()
                    .partialState().with(UplandRiceBlock.AGE, 3).with(UplandRiceBlock.SUPPORTING, true)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_supporting"))).addModel())
            .register();

    public static final BlockEntry<UplandRicePaniclesBlock> UPLAND_RICE_PANICLES = REGISTRATE
            .listBLock("upland_rice_panicles", UplandRicePaniclesBlock::new)
            .initialProperties(() -> Blocks.WHEAT)
            .properties(p -> p.noOcclusion().randomTicks())
            .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.get())
                    .partialState().with(UplandRicePaniclesBlock.RICE_AGE, 0)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_panicles_stage0"))).addModel()
                    .partialState().with(UplandRicePaniclesBlock.RICE_AGE, 1)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_panicles_stage1"))).addModel()
                    .partialState().with(UplandRicePaniclesBlock.RICE_AGE, 2)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_panicles_stage2"))).addModel()
                    .partialState().with(UplandRicePaniclesBlock.RICE_AGE, 3)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/crop/grow/upland_rice/rice_panicles_stage3"))).addModel())
            .register();

//红洋葱
    public static final BlockEntry<CommonFourStageCrop> RED_ONION = REGISTRATE
            .listBLock("red_onion", CommonFourStageCrop::new)
            .initialProperties(() -> Blocks.WHEAT)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/red_onion")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//切尔塔尔多洋葱
    public static final BlockEntry<CommonFourStageCrop> CIPOLLA_DI_CERTALDO = REGISTRATE
            .listBLock("cipolla_di_certaldo", CommonFourStageCrop::new)
            .initialProperties(() -> Blocks.WHEAT)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/cipolla_di_certaldo")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//辣根
    public static final BlockEntry<CommonFourStageCrop> HORSERADISH = REGISTRATE
            .listBLock("horseradish", CommonFourStageCrop::new)
            .initialProperties(() -> Blocks.WHEAT)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/horseradish")))
            .build()
            .blockstate(CommonFourStageCrop::crossBlockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//白萝卜
    public static final BlockEntry<CommonFourStageCrop> WHITE_RADISH = REGISTRATE
            .listBLock("white_raddish", CommonFourStageCrop::new)
            .initialProperties(() -> Blocks.WHEAT)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationMod(2.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/white_raddish")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

    // 根茎作物以收获物直接种植。
    public static final BlockEntry<CommonFourStageCrop> GREEN_RADISH =
            registerRootCrop("green_radish", "item/vegetable", Foods.CARROT);
    public static final BlockEntry<CommonFourStageCrop> ICE_CREAM_RADISH =
            registerRootCrop("ice_cream_radish", "item/vegetable", Foods.CARROT);
    public static final BlockEntry<CommonFourStageCrop> BLACK_CARROT =
            registerRootCrop("black_carrot", "item/food/gtfo/crop", Foods.CARROT);
    public static final BlockEntry<CommonFourStageCrop> JAUNE_DU_DOUBS =
            registerRootCrop("jaune_du_doubs", "item/food/gtfo/crop", Foods.CARROT);
    public static final BlockEntry<CommonFourStageCrop> RED_CARROT =
            registerRootCrop("red_carrot", "item/food/gtfo/crop", Foods.CARROT);
    public static final BlockEntry<CommonFourStageCrop> WHITE_CARROT =
            registerRootCrop("white_carrot", "item/food/gtfo/crop", Foods.CARROT);
    public static final BlockEntry<CommonFourStageCrop> YELLOW_CARROT =
            registerRootCrop("yellow_carrot", "item/food/gtfo/crop", Foods.CARROT);

    public static final BlockEntry<CommonFourStageCrop> ADIRONDACK_BLUE =
            registerRootCrop("adirondack_blue", "item/food/gtfo/crop", Foods.POTATO);
    public static final BlockEntry<CommonFourStageCrop> AMAROSA =
            registerRootCrop("amarosa", "item/food/gtfo/crop", Foods.POTATO);
    public static final BlockEntry<CommonFourStageCrop> BLACKBERRY_POTATO =
            registerRootCrop("blackberry_potato", "item/food/gtfo/crop", Foods.POTATO);
    public static final BlockEntry<CommonFourStageCrop> BLUE_BELLE =
            registerRootCrop("blue_belle", "item/food/gtfo/crop", Foods.POTATO);
    public static final BlockEntry<CommonFourStageCrop> PINTO_GOLD =
            registerRootCrop("pinto_gold", "item/food/gtfo/crop", Foods.POTATO);
    public static final BlockEntry<CommonFourStageCrop> RED_LA_SODA =
            registerRootCrop("red_la_soda", "item/food/gtfo/crop", Foods.POTATO);

    private static BlockEntry<CommonFourStageCrop> registerRootCrop(String name, String itemTextureFolder, FoodProperties food) {
        return REGISTRATE.listBLock(name, CommonFourStageCrop::new)
                .initialProperties(() -> Blocks.WHEAT)
                .item(ItemNameBlockItem::new)
                .properties(p -> p.food(food))
                .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc(itemTextureFolder + "/" + name)))
                .build()
                .blockstate(CommonFourStageCrop::blockstate)
                .loot(CommonFourStageCrop::loot)
                .register();
    }

    public static final BlockEntry<CommonFourStageCrop> AVALANCHE_BEETROOT = REGISTRATE
            .listBLock("avalanche_beetroot", p -> new CommonFourStageCrop(p, () -> ModItems.AVALANCHE_BEETROOT.get()))
            .initialProperties(() -> Blocks.BEETROOTS)
            .item("avalanche_beetroot_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/avalanche_beetroot_seeds")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

    // 吉萨棉（四阶段，成熟后破坏收获）
    public static final BlockEntry<CommonFourStageCrop> GIZA_COTTON = REGISTRATE
            .listBLock("giza_cotton", p -> new CommonFourStageCrop(p, () -> ModItems.GIZA_COTTON.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("giza_cotton_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/giza_cotton_seeds")))
            .build()
            .blockstate(CommonFourStageCrop::crossBlockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//豌豆（自带物品为种子豌豆，成熟掉豌豆荚）
    public static final BlockEntry<CommonFourStageCrop> PEA = REGISTRATE
            .listBLock("pea", p -> new CommonFourStageCrop(p, () -> ModItems.PEA_POD.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationMod(1.4f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pea")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//野生大豆（自带物品为种子野生大豆，成熟掉野生大豆荚）
    public static final BlockEntry<CommonFourStageCrop> GLYCINE_SOJA = REGISTRATE
            .listBLock("glycine_soja", p -> new CommonFourStageCrop(p, () -> ModItems.WILD_SOYBEAN_POD.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(2).saturationMod(1.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/glycine_soja")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//热那亚罗勒（四阶段，破坏采集；自带物品为种子，成熟掉热那亚罗勒叶）
    public static final BlockEntry<CommonFourStageCrop> GENOVESE_BASIL = REGISTRATE
            .listBLock("genovese_basil", p -> new CommonFourStageCrop(p, () -> ModItems.GENOVESE_BASIL_LEAF.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("genovese_basil_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/genovese_basil_seeds")))
            .build()
            .blockstate(CommonFourStageCrop::crossBlockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//牛至（四阶段，破坏采集；自带物品为种子，成熟掉牛至叶）
    public static final BlockEntry<CommonFourStageCrop> OREGANO = REGISTRATE
            .listBLock("oregano", p -> new CommonFourStageCrop(p, () -> ModItems.OREGANO_LEAF.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("oregano_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/oregano_seeds")))
            .build()
            .blockstate(CommonFourStageCrop::crossBlockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//东方草莓（七阶段可重复采摘；自带物品为种子，产物为 ModItems.ORIENTAL_STRAWBERRY）
    public static final BlockEntry<CommonRegrowCrop> ORIENTAL_STRAWBERRY = REGISTRATE
            .listBLock("oriental_strawberry", p -> new CommonRegrowCrop(p, () -> ModItems.ORIENTAL_STRAWBERRY.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("oriental_strawberry_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/oriental_strawberry_seeds")))
            .build()
            .blockstate(CommonRegrowCrop::blockstate)
            .loot(CommonRegrowCrop::loot)
            .register();

//凛冬草莓（七阶段可重复采摘；自带物品为种子，产物为 ModItems.HARSH_WINTER_STRAWBERRY）
    public static final BlockEntry<CommonRegrowCrop> HARSH_WINTER_STRAWBERRY = REGISTRATE
            .listBLock("harsh_winter_strawberry", p -> new CommonRegrowCrop(p, () -> ModItems.HARSH_WINTER_STRAWBERRY.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("harsh_winter_strawberry_seeds", ItemNameBlockItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/harsh_winter_strawberry_seeds")))
            .build()
            .blockstate(CommonRegrowCrop::blockstate)
            .loot(CommonRegrowCrop::loot)
            .register();

//北高丛蓝莓（浆果丛，直接用蓝莓种植，成熟右键采摘）
    public static final BlockEntry<CommonBerryCrop> NORTHERN_HIGHBUSH_BLUEBERRY = REGISTRATE
            .listBLock("northern_highbush_blueberry", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(1.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/northern_highbush_blueberry")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//美洲黑醋栗（浆果丛）
    public static final BlockEntry<CommonBerryCrop> AMERICAN_BLACK_CURRANT = REGISTRATE
            .listBLock("american_black_currant", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .tooltips("§7§oAmerican black currant is a common wild currant in North America.")
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/american_black_currant")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//罗瓦达红醋栗（浆果丛）
    public static final BlockEntry<CommonBerryCrop> ROVADA_RED_CURRANT = REGISTRATE
            .listBLock("rovada_red_currant", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .tooltips("§7§oKing of Red Currants!")
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/rovada_red_currant")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//凡尔赛白醋栗（浆果丛）
    public static final BlockEntry<CommonBerryCrop> VERSAILLES_WHITE_CURRANT = REGISTRATE
            .listBLock("versailles_white_currant", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .tooltips("§7§oThe aristocrat of currants")
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/versailles_white_currant")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//大果蔓越莓（浆果丛，直接用蔓越莓种植）
    public static final BlockEntry<CommonBerryCrop> LARGE_CRANBERRY = REGISTRATE
            .listBLock("large_cranberry", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(1.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/large_cranberry")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//越橘（浆果丛，直接用浆果种植）
    public static final BlockEntry<CommonBerryCrop> LINGONBERRY = REGISTRATE
            .listBLock("lingonberry", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(1.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/lingonberry")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//哈施贝格接骨木莓（浆果丛，直接用浆果种植）
    public static final BlockEntry<CommonBerryCrop> HASCHBERG_ELDERBERRY = REGISTRATE
            .listBLock("haschberg_elderberry", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(1.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/haschberg_elderberry")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//欧洲红树莓（浆果丛，直接用浆果种植）
    public static final BlockEntry<CommonBerryCrop> EUROPEAN_RED_RASPBERRY = REGISTRATE
            .listBLock("european_red_raspberry", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(1.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/european_red_raspberry")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//苏尔莫纳红蒜（自带物品为种子苏尔莫纳红蒜瓣，成熟掉整头蒜 ModItems.AGLIO_ROSSO_DI_SULMONA）
    public static final BlockEntry<CommonFourStageCrop> AGLIO_ROSSO_DI_SULMONA = REGISTRATE
            .listBLock("aglio_rosso_di_sulmona", p -> new CommonFourStageCrop(p, () -> ModItems.AGLIO_ROSSO_DI_SULMONA.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("aglio_rosso_di_sulmona_cloves", ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/aglio_rosso_di_sulmona_cloves")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//波莱西亚白蒜（自带物品为种子波莱西亚白蒜瓣，成熟掉整头蒜 ModItems.AGLIO_BIANCO_POLESANO）
    public static final BlockEntry<CommonFourStageCrop> AGLIO_BIANCO_POLESANO = REGISTRATE
            .listBLock("aglio_bianco_polesano", p -> new CommonFourStageCrop(p, () -> ModItems.AGLIO_BIANCO_POLESANO.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("aglio_bianco_polesano_cloves", ItemNameBlockItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(3).saturationMod(1.2f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/aglio_bianco_polesano_cloves")))
            .build()
            .blockstate(CommonFourStageCrop::blockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//上古水果（双层，六阶段可重复采摘：age 3 起两格高，采摘后回退到 age 2；自带物品为种子，产物为 ModItems.ANCIENT_FRUIT）
    public static final BlockEntry<CommonTallRegrowCrop> ANCIENT_FRUIT = REGISTRATE
            .listBLock("ancient_fruit", p -> new CommonTallRegrowCrop(p, () -> ModItems.ANCIENT_FRUIT.get(), 2, 3))
            .initialProperties(() -> Blocks.WHEAT)
            .item("ancient_fruit_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/ancient_fruit_seeds")))
            .build()
            .blockstate(CommonTallRegrowCrop::tallBlockstate)
            .loot(CommonTallRegrowCrop::tallLoot)
            .register();

//意大利长黄瓜（六阶段可重复采摘，采摘后回退到第 4 阶段 age 3；自带物品为种子，产物为 ModItems.CETRIOLO_IUNGO）
    public static final BlockEntry<CommonSixStageRegrowCrop> CETRIOLO_IUNGO = REGISTRATE
            .listBLock("cetriolo_iungo", p -> new CommonSixStageRegrowCrop(p, () -> ModItems.CETRIOLO_IUNGO.get(), 3))
            .initialProperties(() -> Blocks.WHEAT)
            .item("cetriolo_iungo_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/cetriolo_iungo_seeds")))
            .build()
            .blockstate(CommonRegrowCrop::blockstate)
            .loot(CommonRegrowCrop::loot)
            .register();

//意大利长黑茄（六阶段可重复采摘，采摘后回退到第 4 阶段 age 3；自带物品为种子，产物为 ModItems.ITALIAN_LONG_EGGPLANT）
    public static final BlockEntry<CommonSixStageRegrowCrop> ITALIAN_LONG_EGGPLANT = REGISTRATE
            .listBLock("italian_long_eggplant", p -> new CommonSixStageRegrowCrop(p, () -> ModItems.ITALIAN_LONG_EGGPLANT.get(), 3))
            .initialProperties(() -> Blocks.WHEAT)
            .item("italian_long_eggplant_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/italian_long_eggplant_seeds")))
            .build()
            .blockstate(CommonRegrowCrop::blockstate)
            .loot(CommonRegrowCrop::loot)
            .register();

//洋蓟（十字模型；自带物品为种子，成熟掉 ModItems.ARTICHOKES）
    public static final BlockEntry<CommonFourStageCrop> ARTICHOKES = REGISTRATE
            .listBLock("artichokes", p -> new CommonFourStageCrop(p, () -> ModItems.ARTICHOKES.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("artichokes_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/artichokes_seeds")))
            .build()
            .blockstate(CommonFourStageCrop::crossBlockstate)
            .loot(CommonFourStageCrop::loot)
            .register();

//黄油头生菜（八阶段；自带种子；产物为 ModItems.BUTTERHEAD_LETTUCE）
    public static final BlockEntry<CommonEightStageCrop> BUTTERHEAD_LETTUCE = REGISTRATE
            .listBLock("butterhead_lettuce", p -> new CommonEightStageCrop(p, () -> ModItems.BUTTERHEAD_LETTUCE.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("butterhead_lettuce_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/butterhead_lettuce_seeds")))
            .build()
            .blockstate(CommonEightStageCrop::blockstate)
            .loot(CommonEightStageCrop::loot)
            .register();

//牛排番茄（八阶段可重复采摘，采摘后回退到 age 4；自带物品为种子；产物为 ModItems.BEEFSTEAK_TOMATO）
    public static final BlockEntry<CommonEightStageRegrowCrop> BEEFSTEAK_TOMATO = REGISTRATE
            .listBLock("beefsteak_tomato", p -> new CommonEightStageRegrowCrop(p, () -> ModItems.BEEFSTEAK_TOMATO.get(), 4))
            .initialProperties(() -> Blocks.WHEAT)
            .item("beefsteak_tomato_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/beefsteak_tomato_seeds")))
            .build()
            .blockstate(CommonRegrowCrop::blockstate)
            .loot(CommonRegrowCrop::loot)
            .register();

    public static final BlockEntry<CommonEightStageRegrowCrop> GREEN_ZEBRA_TOMATO =
            registerTomatoCrop("green_zebra_tomato", () -> ModItems.GREEN_ZEBRA_TOMATO.get());
    public static final BlockEntry<CommonEightStageRegrowCrop> LEMON_BOY_TOMATO =
            registerTomatoCrop("lemon_boy_tomato", () -> ModItems.LEMON_BOY_TOMATO.get());
    public static final BlockEntry<CommonEightStageRegrowCrop> VALENCIA_TOMATO =
            registerTomatoCrop("valencia_tomato", () -> ModItems.VALENCIA_TOMATO.get());
    public static final BlockEntry<CommonEightStageRegrowCrop> BLACK_BEAUTY_TOMATO =
            registerTomatoCrop("black_beauty_tomato", () -> ModItems.BLACK_BEAUTY_TOMATO.get());
    public static final BlockEntry<CommonEightStageRegrowCrop> WHITE_BEAUTY_TOMATO =
            registerTomatoCrop("white_beauty_tomato", () -> ModItems.WHITE_BEAUTY_TOMATO.get());
    public static final BlockEntry<CommonEightStageRegrowCrop> PINK_BERKELEY_TIE_DYE_TOMATO =
            registerTomatoCrop("pink_berkeley_tie_dye_tomato", () -> ModItems.PINK_BERKELEY_TIE_DYE_TOMATO.get());
    public static final BlockEntry<CommonEightStageRegrowCrop> STRIPED_GERMAN_TOMATO =
            registerTomatoCrop("striped_german_tomato", () -> ModItems.STRIPED_GERMAN_TOMATO.get());

    private static BlockEntry<CommonEightStageRegrowCrop> registerTomatoCrop(String name, Supplier<Item> produce) {
        return REGISTRATE.listBLock(name, p -> new CommonEightStageRegrowCrop(p, produce, 4))
                .initialProperties(() -> Blocks.WHEAT)
                .item(name + "_seeds", ItemNameBlockItem::new)
                .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/" + ctx.getName())))
                .build()
                .blockstate(CommonRegrowCrop::blockstate)
                .loot(CommonRegrowCrop::loot)
                .register();
    }

//欧洲黑莓（浆果丛，直接用浆果种植）
    public static final BlockEntry<CommonBerryCrop> EUROPEAN_BLACKBERRY = REGISTRATE
            .listBLock("european_blackberry", CommonBerryCrop::new)
            .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
            .item(ItemNameBlockItem::new)
            .tooltips("§7§oA member of the Rubus fruticosus agg.", "§7§oIt is widespread across Britain and Ireland.")
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.5f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/european_blackberry")))
            .build()
            .blockstate(CommonBerryCrop::blockstate)
            .loot(CommonBerryCrop::loot)
            .register();

//红菠萝（种在沙子上；自带物品为菠萝苗，贴图即第一阶段；成熟掉 ModItems.RED_PINEAPPLE）
    public static final BlockEntry<CommonDesertCrop> RED_PINEAPPLE = REGISTRATE
            .listBLock("red_pineapple", p -> new CommonDesertCrop(p, () -> ModItems.RED_PINEAPPLE.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("red_pineapple_sapling", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/grow/red_pineapple/red_pineapple_stage0")))
            .build()
            .blockstate(CommonDesertCrop::blockstate)
            .loot(CommonDesertCrop::loot)
            .register();

//台湾菠萝（种在沙子上；自带物品为菠萝苗，贴图即第一阶段；成熟掉 ModItems.TAIWAN_GREEN_PINEAPPLE）
    public static final BlockEntry<CommonDesertCrop> TAIWAN_GREEN_PINEAPPLE = REGISTRATE
            .listBLock("taiwan_green_pineapple", p -> new CommonDesertCrop(p, () -> ModItems.TAIWAN_GREEN_PINEAPPLE.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("taiwan_green_pineapple_sapling", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/grow/taiwan_green_pineapple/taiwan_green_pineapple_stage0")))
            .build()
            .blockstate(CommonDesertCrop::blockstate)
            .loot(CommonDesertCrop::loot)
            .register();

//香水凤梨（种在沙子上；自带物品为凤梨苗，贴图即第一阶段；成熟掉 ModItems.PERFUME_PINEAPPLE）
    public static final BlockEntry<CommonDesertCrop> PERFUME_PINEAPPLE = REGISTRATE
            .listBLock("perfume_pineapple", p -> new CommonDesertCrop(p, () -> ModItems.PERFUME_PINEAPPLE.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("perfume_pineapple_sapling", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/grow/perfume_pineapple/perfume_pineapple_stage0")))
            .build()
            .blockstate(CommonDesertCrop::blockstate)
            .loot(CommonDesertCrop::loot)
            .register();

//水果玉米（双层八阶段，age 4 起两格高；一次性收获；自带物品为种子，成熟掉 ModItems.SWEET_CORN）
    public static final BlockEntry<CommonTallEightStageCrop> SWEET_CORN = REGISTRATE
            .listBLock("sweet_corn", p -> new CommonTallEightStageCrop(p, () -> ModItems.SWEET_CORN.get(), 4))
            .initialProperties(() -> Blocks.WHEAT)
            .item("sweet_corn_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/sweet_corn_seeds")))
            .build()
            .blockstate(CommonTallEightStageCrop::tallBlockstate)
            .loot(CommonTallEightStageCrop::tallLoot)
            .register();

//红叶卷心菜（八阶段；自带物品为种子；产物为 ModItems.RED_CABBAGE）
    public static final BlockEntry<CommonEightStageCrop> RED_CABBAGES = REGISTRATE
            .listBLock("red_cabbages", p -> new CommonEightStageCrop(p, () -> ModItems.RED_CABBAGE.get()))
            .initialProperties(() -> Blocks.WHEAT)
            .item("red_cabbage_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/red_cabbage_seeds")))
            .build()
            .blockstate(CommonEightStageCrop::blockstate)
            .loot(CommonEightStageCrop::loot)
            .register();
/*
    //树坑
    public static final BlockEntry<TreeCompostBlock> TREE_COMPOST = REGISTRATE
            .block("tree_compost", TreeCompostBlock::new)
            .initialProperties(() -> Blocks.DIRT)
            .simpleItem()   public static final BlockEntry<TreeCompostBlock> TREE_COMPOST = REGISTRATE
            .block("tree_compost", TreeCompostBlock::new)
            .initialProperties(() -> Blocks.DIRT)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/tree_compost"),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/rich_soil")
                ).texture("particle", provider.mcLoc("block/smooth_stone")); //modLoc("block/tree_compost/tree_compost"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .register();
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/tree_compost"),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/rich_soil"),
                        provider.modLoc("block/tree_compost/rich_soil")
                ).texture("particle", provider.mcLoc("block/smooth_stone")); //modLoc("block/tree_compost/tree_compost"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .register();
*/
    //林业温室（独立方块）
    public static final BlockEntry<ForestryGreenhouseBlock> FORESTRY_GREENHOUSE = REGISTRATE
            .block("forestry_greenhouse", ForestryGreenhouseBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/greenhouse_casing"),
                        provider.modLoc("block/greenhouse_casing"),
                        provider.modLoc("block/greenhouse_furnace/controller_front"),  //应该是正面
                        provider.modLoc("block/greenhouse_casing"),
                        provider.modLoc("block/greenhouse_furnace/controller_side"),
                        provider.modLoc("block/greenhouse_furnace/controller_side")
                ).texture("particle", provider.modLoc("block/greenhouse_casing"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    //林业杂交箱
    public static final BlockEntry<ForestryHybridizerBlock> FORESTRY_HYBRIDIZER = REGISTRATE
            .block("forestry_hybridizer", ForestryHybridizerBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                provider.horizontalBlock(
                        ctx.get(),
                        provider.models().getExistingFile(provider.modLoc("block/" + ctx.getName()))
                );
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();



    //树液采集
    public static final BlockEntry<TapperBlock> TAPPER = REGISTRATE
            .block("tapper", TapperBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.noOcclusion())
            .simpleItem()
            .blockstate((ctx, provider) -> {
                provider.horizontalBlock(
                        ctx.get(),
                        provider.models().getExistingFile(provider.modLoc("block/" + ctx.getName()))
                );
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();


    // Italian Delight pizzas (servings-based cakes)
    public static final BlockEntry<CommonPizzaBlock> PIZZA_PROSCIUTTO = REGISTRATE
            .block("pizza_prosciutto", ctx -> new CommonPizzaBlock(() -> ModItems.PIZZA_PROSCIUTTO_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/italian_delight/pizza_prosciutto")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<CommonPizzaBlock> PIZZA_FUNGHI = REGISTRATE
            .block("pizza_funghi", ctx -> new CommonPizzaBlock(() -> ModItems.PIZZA_FUNGHI_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/italian_delight/pizza_funghi")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<CommonPizzaBlock> PIZZA_MARGHERITA = REGISTRATE
            .block("pizza_margherita", ctx -> new CommonPizzaBlock(() -> ModItems.PIZZA_MARGHERITA_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/italian_delight/pizza_margherita")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<CommonPizzaBlock> PIZZA_DANTE = REGISTRATE
            .block("pizza_dante", ctx -> new CommonPizzaBlock(() -> ModItems.PIZZA_DANTE_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/italian_delight/pizza_dante")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<CommonPizzaBlock> PIZZA_DIAVOLA = REGISTRATE
            .block("pizza_diavola", ctx -> new CommonPizzaBlock(() -> ModItems.PIZZA_DIAVOLA_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/italian_delight/pizza_diavola")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();
//GTFO披萨
    public static final BlockEntry<CommonPizzaBlock> CHEESE_PIZZA = REGISTRATE
            .block("cheese_pizza", ctx -> new CommonPizzaBlock(() -> ModItems.CHEESE_PIZZA_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/food/gtfo/cheese_pizza")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

   public static final BlockEntry<CommonPizzaBlock> MINCE_MEAT_PIZZA = REGISTRATE
            .block("mince_meat_pizza", ctx -> new CommonPizzaBlock(() -> ModItems.MINCE_MEAT_PIZZA_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/food/gtfo/mince_meat_pizza")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

   public static final BlockEntry<CommonPizzaBlock> OLIVE_MUSHROOM_PIZZA = REGISTRATE
            .block("olive_mushroom_pizza", ctx -> new CommonPizzaBlock(() -> ModItems.OLIVE_MUSHROOM_PIZZA_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/food/gtfo/olive_mushroom_pizza")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();
//GTFO披萨结束
    public static final BlockEntry<CommonCakeBlock> BLACK_TEA_CAKE = REGISTRATE
            .block("black_tea_cake", ctx -> new CommonCakeBlock(() -> ModItems.BLACK_TEA_CAKE_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/cake/black_tea_cake")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<CommonCakeBlock> GREEN_TEA_CAKE = REGISTRATE
            .block("green_tea_cake", ctx -> new CommonCakeBlock(() -> ModItems.GREEN_TEA_CAKE_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/cake/green_tea_cake")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<CommonCakeBlock> YELLOW_TEA_CAKE = REGISTRATE
            .block("yellow_tea_cake", ctx -> new CommonCakeBlock(() -> ModItems.YELLOW_TEA_CAKE_SLICE.get(), BlockBehaviour.Properties.copy(Blocks.CAKE)))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/cake/yellow_tea_cake")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<Block> CORNUCOPIA_BLOCK = REGISTRATE
            .block("cornucopia_block", Block::new)
            .initialProperties(() -> Blocks.HAY_BLOCK)
            .properties(p -> p.sound(SoundType.WOOL).strength(0.5F).noOcclusion())
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/bountiful_harvest/cornucopia")))
            .build()
            .blockstate((ctx, provider) -> provider.simpleBlock(
                    ctx.get(),
                    provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/cornucopia_block"))
            ))
            .tag(BlockTags.MINEABLE_WITH_AXE)
            .register();

   

    public static final BlockEntry<FourStageFoodBlock> PECAN_PIE = REGISTRATE
            .block("pecan_pie", ctx -> new FourStageFoodBlock(
                    BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion(),
                    () -> ModItems.PECAN.get(),
                    BountifulHarvestBlockShapes.PIE_SHAPE,
                    true
            ))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/bountiful_harvest/pecan_pie")))
            .build()
            .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.get())
                    .partialState().with(ctx.get().getStageProperty(), 0)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/pecan_pie"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 1)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/pecan_pie_slice1"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 2)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/pecan_pie_slice2"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 3)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/pecan_pie_slice3"))).addModel())
            .register();

    public static final BlockEntry<RoastTurkeyBlock> ROAST_TURKEY_BLOCK = REGISTRATE
            .block("roast_turkey_block", ctx -> new RoastTurkeyBlock(
                    BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion(),
                    () -> ModItems.ROAST_TURKEY.get(),
                    BountifulHarvestBlockShapes.LOW_TRAY_SHAPE,
                    true
            ))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/bountiful_harvest/roast_turkey_block")))
            .build()
            .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.get())
                    .partialState().with(ctx.get().getStageProperty(), 0)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/roast_turkey_block_stage0"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 1)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/roast_turkey_block_stage1"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 2)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/roast_turkey_block_stage2"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 3)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/roast_turkey_block_stage3"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 4)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/roast_turkey_block_stage4"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 5)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/roast_turkey_block_leftover"))).addModel())
            .register();

    public static final BlockEntry<SweetPotatoCasseroleTrayBlock> SWEET_POTATO_CASSEROLE_BLOCK = REGISTRATE
            .block("sweet_potato_casserole_block", ctx -> new SweetPotatoCasseroleTrayBlock(
                    BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion(),
                    () -> ModItems.SWEET_POTATO_CASSEROLE.get(),
                    () -> ModItems.PAN.get(),
                    BountifulHarvestBlockShapes.LOW_TRAY_SHAPE,
                    true
            ))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/bountiful_harvest/sweet_potato_casserole_block")))
            .build()
            .blockstate((ctx, provider) -> provider.getVariantBuilder(ctx.get())
                    .partialState().with(ctx.get().getStageProperty(), 0)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/sweet_potato_casserole_block_stage0"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 1)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/sweet_potato_casserole_block_stage1"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 2)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/sweet_potato_casserole_block_stage2"))).addModel()
                    .partialState().with(ctx.get().getStageProperty(), 3)
                    .modelForState().modelFile(provider.models().getExistingFile(provider.modLoc("block/bountiful_harvest/sweet_potato_casserole_block_leftover"))).addModel())
            .register();


    public static final BlockEntry<FacingFiveStageFoodBlock> MUSHROOM_POT_PIE_BLOCK = REGISTRATE
            .block("mushroom_pot_pie_block", ctx -> new FacingFiveStageFoodBlock(
                    BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion(),
                    () -> ModItems.MUSHROOM_POT_PIE.get(),
                    MUSHROOM_POT_PIE_SHAPE,
                    LARGE_MEAL_TRAY_SHAPE,
                    true
            ))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/mushroom_pot_pie_block")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<FacingFiveStageFoodBlock> OMURICE_BLOCK = REGISTRATE
            .block("omurice_block", ctx -> new FacingFiveStageFoodBlock(
                    BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion(),
                    () -> ModItems.OMURICE.get(),
                    OMURICE_SHAPE,
                    LARGE_MEAL_TRAY_SHAPE,
                    true
            ))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/omurice_block")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();

    public static final BlockEntry<FacingFiveStageFoodBlock> ROASTED_MUTTON_RACK_BLOCK = REGISTRATE
            .block("roasted_mutton_rack_block", ctx -> new FacingFiveStageFoodBlock(
                    BlockBehaviour.Properties.copy(Blocks.CAKE).noOcclusion(),
                    () -> ModItems.ROASTED_MUTTON_RACK.get(),
                    ROASTED_MUTTON_RACK_SHAPE,
                    LARGE_MEAL_TRAY_SHAPE,
                    true
            ))
            .initialProperties(() -> Blocks.CAKE)
            .item()
            .model((ctx, prov) -> prov.getExistingFile(prov.modLoc("item/roasted_mutton_rack_block")))
            .build()
            .blockstate((ctx, prov) -> {})
            .register();


    //草菇
    public static final BlockEntry<StrawMushroomBlock> STRAW_MUSHROOM = REGISTRATE
            .block("straw_mushroom", StrawMushroomBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/mushroom/straw_mushroom")).renderType("cutout");
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/mushroom/straw_mushroom"));
            })
            .build()
            .register();

    //海蘑菇
    public static final BlockEntry<SeaMushroomBlock> SEA_MUSHROOM = REGISTRATE
            .block("sea_mushroom", SeaMushroomBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/mushroom/sea_mushroom")).renderType("cutout");
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/mushroom/sea_mushroom"));
            })
            .build()
            .register();

    //海蘑菇
    public static final BlockEntry<CaveMushroomBlock> CAVE_MUSHROOM = REGISTRATE
            .block("cave_mushroom", CaveMushroomBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/mushroom/cave_mushroom")).renderType("cutout");
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/mushroom/cave_mushroom"));
            })
            .build()
            .register();

    //草菇菌落
    public static final BlockEntry<StrawMushroomBlock> STRAW_MUSHROOM_COLONY = REGISTRATE
            .block("straw_mushroom_colony", StrawMushroomBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/colony/straw_mushroom_colony")).renderType("cutout");
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/colony/straw_mushroom_colony"));
            })
            .build()
            .register();

    //海蘑菇菌落
    public static final BlockEntry<SeaMushroomColonyBlock> SEA_MUSHROOM_COLONY = REGISTRATE
            .block("sea_mushroom_colony", SeaMushroomColonyBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/colony/sea_mushroom_colony")).renderType("cutout");
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/colony/sea_mushroom_colony"));
            })
            .build()
            .register();

    //洞穴菇菌落
    public static final BlockEntry<CaveMushroomBlock> CAVE_MUSHROOM_COLONY = REGISTRATE
            .block("cave_mushroom_colony", CaveMushroomBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/colony/cave_mushroom_colony")).renderType("cutout");
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/colony/cave_mushroom_colony"));
            })
            .build()
            .register();

    //含洞系列  Burrowed sand？
//有洞的粘土
    public static final BlockEntry<Block> BURROWED_CLAY = REGISTRATE
            .block("burrowed_clay", Block::new)
            .initialProperties(() -> Blocks.CLAY)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/clay"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_clay"),     //顶部 dowm
                        provider.mcLoc("block/clay"),    //北 north
                        provider.mcLoc("block/clay"),    //南 sorth
                        provider.mcLoc("block/clay"),    //西 west
                        provider.mcLoc("block/clay")     //东 east
                ).texture("particle", provider.mcLoc("block/clay"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();
   //有洞的繁茂洞穴粘土
    public static final BlockEntry<Block> BURROWED_LUSH_CAVES_CLAY = REGISTRATE
            .block("burrowed_lush_caves_clay", Block::new)
            .initialProperties(() -> Blocks.CLAY)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/clay"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_clay"),     //顶部 dowm
                        provider.mcLoc("block/clay"),    //北 north
                        provider.mcLoc("block/clay"),    //南 sorth
                        provider.mcLoc("block/clay"),    //西 west
                        provider.mcLoc("block/clay")     //东 east
                ).texture("particle", provider.mcLoc("block/clay"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();
    //有洞的沙子
    public static final BlockEntry<FallingBlock> BURROWED_SAND = REGISTRATE
            .block("burrowed_sand", FallingBlock::new)
            .initialProperties(() -> Blocks.SAND)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/sand"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_sand"),     //顶部 dowm
                        provider.mcLoc("block/sand"),    //北 north
                        provider.mcLoc("block/sand"),    //南 sorth
                        provider.mcLoc("block/sand"),    //西 west
                        provider.mcLoc("block/sand")     //东 east
                ).texture("particle", provider.mcLoc("block/sand"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();
    //有洞的河流沙子
    public static final BlockEntry<FallingBlock> BURROWED_RIVER_SAND = REGISTRATE
            .block("burrowed_river_sand", FallingBlock::new)
            .initialProperties(() -> Blocks.SAND)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/sand"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_sand"),     //顶部 dowm
                        provider.mcLoc("block/sand"),    //北 north
                        provider.mcLoc("block/sand"),    //南 sorth
                        provider.mcLoc("block/sand"),    //西 west
                        provider.mcLoc("block/sand")     //东 east
                ).texture("particle", provider.mcLoc("block/sand"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();
    //有洞的沙砾
    public static final BlockEntry<FallingBlock> BURROWED_GRAVEL = REGISTRATE
            .block("burrowed_gravel", FallingBlock::new)
            .initialProperties(() -> Blocks.GRAVEL)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/gravel"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_gravel"),     //顶部 dowm
                        provider.mcLoc("block/gravel"),    //北 north
                        provider.mcLoc("block/gravel"),    //南 sorth
                        provider.mcLoc("block/gravel"),    //西 west
                        provider.mcLoc("block/gravel")     //东 east
                ).texture("particle", provider.mcLoc("block/gravel"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();
    //有洞的河流沙砾
    public static final BlockEntry<FallingBlock> BURROWED_RIVER_GRAVEL = REGISTRATE
            .block("burrowed_river_gravel", FallingBlock::new)
            .initialProperties(() -> Blocks.GRAVEL)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/gravel"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_gravel"),     //顶部 dowm
                        provider.mcLoc("block/gravel"),    //北 north
                        provider.mcLoc("block/gravel"),    //南 sorth
                        provider.mcLoc("block/gravel"),    //西 west
                        provider.mcLoc("block/gravel")     //东 east
                ).texture("particle", provider.mcLoc("block/gravel"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();
    //有洞的泥土
    public static final BlockEntry<Block> BURROWED_DIRT = REGISTRATE
            .block("burrowed_dirt", Block::new)
            .initialProperties(() -> Blocks.DIRT)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/dirt"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_dirt"),     //顶部 dowm
                        provider.mcLoc("block/dirt"),    //北 north
                        provider.mcLoc("block/dirt"),    //南 sorth
                        provider.mcLoc("block/dirt"),    //西 west
                        provider.mcLoc("block/dirt")     //东 east
                ).texture("particle", provider.mcLoc("block/dirt"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();

    //有洞的泥巴
    public static final BlockEntry<Block> BURROWED_MUD = REGISTRATE
            .block("burrowed_mud", Block::new)
            .initialProperties(() -> Blocks.MUD)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/mud"),         //底部 up
                        provider.modLoc("block/sea_food_hole/burrowed_mud"),     //顶部 dowm
                        provider.mcLoc("block/mud"),    //北 north
                        provider.mcLoc("block/mud"),    //南 sorth
                        provider.mcLoc("block/mud"),    //西 west
                        provider.mcLoc("block/mud")     //东 east
                ).texture("particle", provider.mcLoc("block/mud"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            //.loot(NonNullBiConsumer.noop())
            //.loot((lt, block) -> {})
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();

    //温室外壳
    public static final BlockEntry<Block> GREENHOUSE_CASING = REGISTRATE
            .block("greenhouse_casing", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/greenhouse_casing"),         //底部 up
                        provider.modLoc("block/greenhouse_casing"),     //顶部 dowm
                        provider.modLoc("block/greenhouse_casing"),    //北 north
                        provider.modLoc("block/greenhouse_casing"),    //南 sorth
                        provider.modLoc("block/greenhouse_casing"),    //西 west
                        provider.modLoc("block/greenhouse_casing")     //东 east
                ).texture("particle", provider.modLoc("block/greenhouse_casing"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

//y271727uy玩偶
public static final BlockEntry<CommonPlushieBlock> Y271727UY_PLUSHIE = REGISTRATE
    .block("y271727uy_plushie", CommonPlushieBlock::new)
    .initialProperties(() -> Blocks.WHITE_WOOL)
    .properties(p -> p.noOcclusion())
    .blockstate((ctx, prov) -> {
        prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/y271727uy_plushie")));
    })
    .item()
    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/y271727uy_plushie")))
    .build()
    .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
    .register();

//DancingSnow玩偶
public static final BlockEntry<CommonPlushieBlock> DANCINGSNOW_PLUSHIE = REGISTRATE
    .block("dancingsnow_plushie", CommonPlushieBlock::new)
    .initialProperties(() -> Blocks.WHITE_WOOL)
    .properties(p -> p.noOcclusion())
    .blockstate((ctx, prov) -> {
        prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/dancingsnow_plushie")));
    })
    .item()
    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/dancingsnow_plushie")))
    .build()
    .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
    .register();

//zhuruoling玩偶
public static final BlockEntry<CommonPlushieBlock> ZHURUOLING_PLUSHIE = REGISTRATE
    .block("zhuruoling_plushie", CommonPlushieBlock::new)
    .initialProperties(() -> Blocks.WHITE_WOOL)
    .properties(p -> p.noOcclusion())
    .blockstate((ctx, prov) -> {
        prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/zhuruoling_plushie")));
    })
    .item()
    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/zhuruoling_plushie")))
    .build()
    .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
    .register();


//tedxenon玩偶
public static final BlockEntry<CommonPlushieBlock> TEDXENON_PLUSHIE = REGISTRATE
    .block("tedxenon_plushie", CommonPlushieBlock::new)
    .initialProperties(() -> Blocks.WHITE_WOOL)
    .properties(p -> p.noOcclusion())
    .blockstate((ctx, prov) -> {
        prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/tedxenon_plushie")));
    })
    .item()
    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/tedxenon_plushie")))
    .build()
    .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
    .register();

//HaoZ_DAHA玩偶
public static final BlockEntry<CommonPlushieBlock> HAOZ_DAHA_PLUSHIE = REGISTRATE
    .block("haoz_daha_plushie", CommonPlushieBlock::new)
    .initialProperties(() -> Blocks.WHITE_WOOL)
    .properties(p -> p.noOcclusion())
    .blockstate((ctx, prov) -> {
        prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/haoz_daha_plushie")));
    })
    .item()
    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/haoz_daha_plushie")))
    .build()
    .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
    .register();

    //思杰玩偶  群友分组非贡献者
    public static final BlockEntry<CommonPlushieBlock> SISISISIJIE_PLUSHIE = REGISTRATE
            .block("sisisisijie_plushie", CommonPlushieBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .properties(p -> p.noOcclusion())
            .blockstate((ctx, prov) -> {
                prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/sisisisijie_plushie")));
            })
            .item()
            .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/sisisisijie_plushie")))
            .build()
            .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
            .register();

//皮革嘎的与坠亩的十万美刀
public static final BlockEntry<PigPlushieBlock> PIG_PLUSHIE = REGISTRATE
    .block("pig_plushie", PigPlushieBlock::new)
    .initialProperties(() -> Blocks.WHITE_WOOL)
    .properties(p -> p.noOcclusion())
    .blockstate((ctx, prov) -> {
        prov.horizontalBlock(ctx.get(), prov.models().getExistingFile(prov.modLoc("block/plushie/pig_plushie")));
    })
    .item()
    .model((ctx, prov) -> prov.withExistingParent(ctx.getName(), prov.modLoc("block/plushie/pig_plushie")))
    .build()
    .loot((lt, block) -> lt.add(block, LootTable.lootTable()))
    .register();

//黑皮西瓜
public static final BlockEntry<CommonMelonBlock> BLACK_BEAUTY_MELON = REGISTRATE
        .block("black_beauty_melon", p -> new CommonMelonBlock(p, () -> ModBlocks.BLACK_BEAUTY_MELON_STEM.get(), () -> ModBlocks.ATTACHED_BLACK_BEAUTY_MELON_STEM.get()))
        .initialProperties(() -> Blocks.MELON)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/crop/melon/black_beauty_melon_top"),         //底部 up
                provider.modLoc("block/crop/melon/black_beauty_melon_top"),     //顶部 dowm
                provider.modLoc("block/crop/melon/black_beauty_melon_side"),    //北 north
                provider.modLoc("block/crop/melon/black_beauty_melon_side"),    //南 sorth
                provider.modLoc("block/crop/melon/black_beauty_melon_side"),    //西 west
                provider.modLoc("block/crop/melon/black_beauty_melon_side")     //东 east
            ).texture("particle", provider.modLoc("block/crop/melon/black_beauty_melon_side"));
             provider.horizontalBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

//宝石甜瓜
public static final BlockEntry<CommonMelonBlock> GEM_MELON = REGISTRATE
        .block("gem_melon", p -> new CommonMelonBlock(p, () -> ModBlocks.GEM_MELON_STEM.get(), () -> ModBlocks.ATTACHED_GEM_MELON_STEM.get()))
        .initialProperties(() -> Blocks.MELON)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/crop/melon/gem_melon_top"),         //底部 up
                provider.modLoc("block/crop/melon/gem_melon_top"),     //顶部 dowm
                provider.modLoc("block/crop/melon/gem_melon_side"),    //北 north
                provider.modLoc("block/crop/melon/gem_melon_side"),    //南 sorth
                provider.modLoc("block/crop/melon/gem_melon_side"),    //西 west
                provider.modLoc("block/crop/melon/gem_melon_side")     //东 east
            ).texture("particle", provider.modLoc("block/crop/melon/gem_melon_side"));
             provider.horizontalBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();   

//霜瓜
public static final BlockEntry<CommonMelonBlock> FROST_MELON = REGISTRATE
        .block("frost_melon", p -> new CommonMelonBlock(p, () -> ModBlocks.FROST_MELON_STEM.get(), () -> ModBlocks.ATTACHED_FROST_MELON_STEM.get()))
        .initialProperties(() -> Blocks.MELON)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/crop/melon/frost_melon_top"),         //底部 up
                provider.modLoc("block/crop/melon/frost_melon_top"),     //顶部 dowm
                provider.modLoc("block/crop/melon/frost_melon_side"),    //北 north
                provider.modLoc("block/crop/melon/frost_melon_side"),    //南 sorth
                provider.modLoc("block/crop/melon/frost_melon_side"),    //西 west
                provider.modLoc("block/crop/melon/frost_melon_side")     //东 east
            ).texture("particle", provider.modLoc("block/crop/melon/frost_melon_side"));
             provider.horizontalBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();   

//齐瓜
public static final BlockEntry<CommonMelonBlock> QI_MELON = REGISTRATE
        .block("qi_melon", p -> new CommonMelonBlock(p, () -> ModBlocks.QI_MELON_STEM.get(), () -> ModBlocks.ATTACHED_QI_MELON_STEM.get()))
        .initialProperties(() -> Blocks.MELON)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/crop/melon/qi_fruit_top"),         //底部 up
                provider.modLoc("block/crop/melon/qi_fruit_top"),     //顶部 dowm
                provider.modLoc("block/crop/melon/qi_fruit_front"),    //北 north
                provider.modLoc("block/crop/melon/qi_fruit_back"),    //南 sorth
                provider.modLoc("block/crop/melon/qi_fruit_side"),    //西 west
                provider.modLoc("block/crop/melon/qi_fruit_side_2")     //东 east
            ).texture("particle", provider.modLoc("block/crop/melon/qi_fruit_back"));
             provider.horizontalBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register(); 

//黑皮西瓜茎（原版西瓜茎模型；自带物品为黑皮西瓜种子）
    public static final BlockEntry<StemBlock> BLACK_BEAUTY_MELON_STEM = REGISTRATE
            .listBLock("black_beauty_melon_stem", p -> new StemBlock(ModBlocks.BLACK_BEAUTY_MELON.get(), () -> ModBlocks.BLACK_BEAUTY_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.MELON_STEM)
            .color(() -> () -> CommonMelonBlock::stemColor)
            .item("black_beauty_melon_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/black_beauty_melon_seeds")))
            .build()
            .blockstate(CommonMelonBlock::stemBlockstate)
            .loot(CommonMelonBlock::stemLoot)
            .register();

    public static final BlockEntry<AttachedStemBlock> ATTACHED_BLACK_BEAUTY_MELON_STEM = REGISTRATE
            .listBLock("attached_black_beauty_melon_stem", p -> new AttachedStemBlock(ModBlocks.BLACK_BEAUTY_MELON.get(), () -> ModBlocks.BLACK_BEAUTY_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.ATTACHED_MELON_STEM)
            .color(() -> () -> CommonMelonBlock::attachedStemColor)
            .blockstate(CommonMelonBlock::attachedStemBlockstate)
            .loot((lt, block) -> CommonMelonBlock.attachedStemLoot(lt, block, ModBlocks.BLACK_BEAUTY_MELON_STEM))
            .register();

//宝石甜瓜茎（原版西瓜茎模型；自带物品为宝石甜瓜种子）
    public static final BlockEntry<StemBlock> GEM_MELON_STEM = REGISTRATE
            .listBLock("gem_melon_stem", p -> new StemBlock(ModBlocks.GEM_MELON.get(), () -> ModBlocks.GEM_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.MELON_STEM)
            .color(() -> () -> CommonMelonBlock::stemColor)
            .item("gem_melon_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/gem_melon_seeds")))
            .build()
            .blockstate(CommonMelonBlock::stemBlockstate)
            .loot(CommonMelonBlock::stemLoot)
            .register();

    public static final BlockEntry<AttachedStemBlock> ATTACHED_GEM_MELON_STEM = REGISTRATE
            .listBLock("attached_gem_melon_stem", p -> new AttachedStemBlock(ModBlocks.GEM_MELON.get(), () -> ModBlocks.GEM_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.ATTACHED_MELON_STEM)
            .color(() -> () -> CommonMelonBlock::attachedStemColor)
            .blockstate(CommonMelonBlock::attachedStemBlockstate)
            .loot((lt, block) -> CommonMelonBlock.attachedStemLoot(lt, block, ModBlocks.GEM_MELON_STEM))
            .register();

//霜瓜茎（原版西瓜茎模型；自带物品为霜瓜种子）
    public static final BlockEntry<StemBlock> FROST_MELON_STEM = REGISTRATE
            .listBLock("frost_melon_stem", p -> new StemBlock(ModBlocks.FROST_MELON.get(), () -> ModBlocks.FROST_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.MELON_STEM)
            .color(() -> () -> CommonMelonBlock::stemColor)
            .item("frost_melon_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/frost_melon_seeds")))
            .build()
            .blockstate(CommonMelonBlock::stemBlockstate)
            .loot(CommonMelonBlock::stemLoot)
            .register();

    public static final BlockEntry<AttachedStemBlock> ATTACHED_FROST_MELON_STEM = REGISTRATE
            .listBLock("attached_frost_melon_stem", p -> new AttachedStemBlock(ModBlocks.FROST_MELON.get(), () -> ModBlocks.FROST_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.ATTACHED_MELON_STEM)
            .color(() -> () -> CommonMelonBlock::attachedStemColor)
            .blockstate(CommonMelonBlock::attachedStemBlockstate)
            .loot((lt, block) -> CommonMelonBlock.attachedStemLoot(lt, block, ModBlocks.FROST_MELON_STEM))
            .register();

//齐瓜茎（原版西瓜茎模型；自带物品为齐瓜种子）
    public static final BlockEntry<StemBlock> QI_MELON_STEM = REGISTRATE
            .listBLock("qi_melon_stem", p -> new StemBlock(ModBlocks.QI_MELON.get(), () -> ModBlocks.QI_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.MELON_STEM)
            .color(() -> () -> CommonMelonBlock::stemColor)
            .item("qi_melon_seeds", ItemNameBlockItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/seeds/qi_melon_seeds")))
            .build()
            .blockstate(CommonMelonBlock::stemBlockstate)
            .loot(CommonMelonBlock::stemLoot)
            .register();

    public static final BlockEntry<AttachedStemBlock> ATTACHED_QI_MELON_STEM = REGISTRATE
            .listBLock("attached_qi_melon_stem", p -> new AttachedStemBlock(ModBlocks.QI_MELON.get(), () -> ModBlocks.QI_MELON_STEM.asItem(), p))
            .initialProperties(() -> Blocks.ATTACHED_MELON_STEM)
            .color(() -> () -> CommonMelonBlock::attachedStemColor)
            .blockstate(CommonMelonBlock::attachedStemBlockstate)
            .loot((lt, block) -> CommonMelonBlock.attachedStemLoot(lt, block, ModBlocks.QI_MELON_STEM))
            .register();

//大型西瓜块侧边wan
public static final BlockEntry<CommonBlock> WATERMELON_BLOCK_SIDE = REGISTRATE
        .block("watermelon_block_side", CommonBlock::new)
        .initialProperties(() -> Blocks.MELON)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/decorate/watermelon_flesh"),         //底部 up
                provider.modLoc("block/decorate/watermelon_flesh"),     //顶部 dowm
                provider.modLoc("block/decorate/melon_side"),    //北 north
                provider.modLoc("block/decorate/watermelon_flesh"),    //南 sorth
                provider.modLoc("block/decorate/watermelon_flesh"),    //西 west
                provider.modLoc("block/decorate/watermelon_flesh")     //东 east
            ).texture("particle", provider.modLoc("block/decorate/melon_side"));
             provider.horizontalBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

    //大型西瓜块角边
    public static final BlockEntry<CommonBlock> WATERMELON_BLOCK_CORNER = REGISTRATE
            .block("watermelon_block_corner", CommonBlock::new)
            .initialProperties(() -> Blocks.MELON)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/decorate/watermelon_flesh"),         //底部 up
                        provider.modLoc("block/decorate/watermelon_flesh"),     //顶部 dowm
                        provider.modLoc("block/decorate/melon_side"),    //北 north
                        provider.modLoc("block/decorate/watermelon_flesh"),    //南 sorth
                        provider.modLoc("block/decorate/melon_side"),    //西 west
                        provider.modLoc("block/decorate/watermelon_flesh")     //东 east
                ).texture("particle", provider.modLoc("block/decorate/melon_side"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    //西瓜瓤块
    public static final BlockEntry<Block> WATERMELON_FLESH_BLOCK = REGISTRATE
            .block("watermelon_flesh_block", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/decorate/watermelon_flesh"),         //底部 up
                        provider.modLoc("block/decorate/watermelon_flesh"),     //顶部 dowm
                        provider.modLoc("block/decorate/watermelon_flesh"),    //北 north
                        provider.modLoc("block/decorate/watermelon_flesh"),    //南 sorth
                        provider.modLoc("block/decorate/watermelon_flesh"),    //西 west
                        provider.modLoc("block/decorate/watermelon_flesh")     //东 east
                ).texture("particle", provider.modLoc("block/decorate/watermelon_flesh"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

//固化沙子
    public static final BlockEntry<Block> CURING_SAND = REGISTRATE
            .block("curing_sand", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/tree_compost/curing_sand"),         //底部 up
                        provider.modLoc("block/tree_compost/curing_sand"),     //顶部 dowm
                        provider.modLoc("block/tree_compost/curing_sand"),    //北 north
                        provider.modLoc("block/tree_compost/curing_sand"),    //南 sorth
                        provider.modLoc("block/tree_compost/curing_sand"),    //西 west
                        provider.modLoc("block/tree_compost/curing_sand")     //东 east
                ).texture("particle", provider.modLoc("block/tree_compost/curing_sand"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> RED_GRANITE = REGISTRATE
            .block("red_granite", Block::new)
            .initialProperties(() -> Blocks.GRANITE)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models()
                    .cubeAll(ctx.getName(), provider.modLoc("block/gt/red_granite"))))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> BLACK_GRANITE = REGISTRATE
            .listBLock("black_granite", Block::new)
            .initialProperties(() -> Blocks.GRANITE)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models()
                    .cubeAll(ctx.getName(), provider.modLoc("block/gt/black_granite"))))
            .tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> QUARTZITE = registerAndesiteVariant("quartzite", 0xFFFFA6AD);
    public static final BlockEntry<Block> KIMBERLITE = registerAndesiteVariant("kimberlite", 0xFF835C3B);
    public static final BlockEntry<Block> BLUESCHIST = registerAndesiteVariant("blueschist", 0xFF3F7AB8);
    public static final BlockEntry<Block> GREENSCHIST = registerAndesiteVariant("greenschist", 0xFF49AB52);
    public static final BlockEntry<Block> KOMATIITE = registerAndesiteVariant("komatiite", 0xFFDBB747);
    public static final BlockEntry<Block> SLATE = registerAndesiteVariant("slate", 0xFF4F5861);
    public static final BlockEntry<Block> SHALE = registerAndesiteVariant("shale", 0xFF7A858E);

    private static BlockEntry<Block> registerAndesiteVariant(String name, int color) {
        return REGISTRATE.listBLock(name, Block::new)
                .initialProperties(() -> Blocks.ANDESITE)
                .tintedCube(ListMod.rl("block/gt/andesite_base"), color)
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .simpleItem()
                .register();
    }

//固化红沙
    public static final BlockEntry<Block> CURING_RED_SAND = REGISTRATE
            .block("curing_red_sand", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/tree_compost/curing_red_sand"),         //底部 up
                        provider.modLoc("block/tree_compost/curing_red_sand"),     //顶部 dowm
                        provider.modLoc("block/tree_compost/curing_red_sand"),    //北 north
                        provider.modLoc("block/tree_compost/curing_red_sand"),    //南 sorth
                        provider.modLoc("block/tree_compost/curing_red_sand"),    //西 west
                        provider.modLoc("block/tree_compost/curing_red_sand")     //东 east
                ).texture("particle", provider.modLoc("block/tree_compost/curing_red_sand"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();
        
//固化砾石
    public static final BlockEntry<Block> CURING_GRAVEL = REGISTRATE
            .block("curing_gravel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/tree_compost/curing_gravel"),         //底部 up
                        provider.modLoc("block/tree_compost/curing_gravel"),     //顶部 dowm
                        provider.modLoc("block/tree_compost/curing_gravel"),    //北 north
                        provider.modLoc("block/tree_compost/curing_gravel"),    //南 sorth
                        provider.modLoc("block/tree_compost/curing_gravel"),    //西 west
                        provider.modLoc("block/tree_compost/curing_gravel")     //东 east
                ).texture("particle", provider.modLoc("block/tree_compost/curing_gravel"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

public static final BlockEntry<Block> PECAN_BAG = REGISTRATE
            .block("pecan_bag", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/bountiful_harvest/rice_bag_bottom"),         //底部 up
                        provider.modLoc("block/bountiful_harvest/pecan_bag_top"),     //顶部 dowm
                        provider.modLoc("block/bountiful_harvest/rice_bag_side"),    //北 north
                        provider.modLoc("block/bountiful_harvest/rice_bag_side"),    //南 sorth
                        provider.modLoc("block/bountiful_harvest/rice_bag_side"),    //西 west
                        provider.modLoc("block/bountiful_harvest/rice_bag_side")     //东 east
                ).texture("particle", provider.modLoc("block/bountiful_harvest/rice_bag_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> ALLIUM_CRATE = REGISTRATE
            .block("allium_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/birch/bottom_birch"),         //底部 up
                        provider.modLoc("block/hoarding/crate/birch/allium_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/birch/allium_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/birch/allium_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/birch/allium_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/birch/allium_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/birch/allium_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> AZURE_BLUET_CRATE = REGISTRATE
            .block("azure_bluet_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/birch/bottom_birch"),         //底部 up
                        provider.modLoc("block/hoarding/crate/birch/azure_bluet_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/birch/azure_bluet_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/birch/azure_bluet_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/birch/azure_bluet_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/birch/azure_bluet_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/birch/azure_bluet_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BAKED_POTATO_CRATE = REGISTRATE
            .block("baked_potato_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/oak/bottom_oak"),         //底部 up
                        provider.modLoc("block/hoarding/crate/oak/baked_potato_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/oak/baked_potato_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/oak/baked_potato_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/oak/baked_potato_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/oak/baked_potato_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/oak/baked_potato_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BEEF_CRATE = REGISTRATE
            .block("beef_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/beef_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/beef_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/beef_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/beef_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/beef_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/beef_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BEETROOT_CRATE = REGISTRATE
            .block("beetroot_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/oak/bottom_oak"),         //底部 up
                        provider.modLoc("block/hoarding/crate/oak/beetroot_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/oak/beetroot_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/oak/beetroot_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/oak/beetroot_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/oak/beetroot_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/oak/beetroot_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BLACK_DYE_BUCKET = REGISTRATE
            .block("black_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bucket/bucket_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/bucket/black_dye_bucket_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //北 north
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //南 sorth
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //西 west
                        provider.modLoc("block/hoarding/bucket/bucket_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bucket/bucket_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BEETROOT_SEEDS_BAG = REGISTRATE
            .block("beetroot_seeds_bag", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/bag/seed_bag/beetroot_seeds_bag_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_side"),    //北 north
                        provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_side"),    //南 sorth
                        provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_side"),    //西 west
                        provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BLAZE_POWDER_BAG = REGISTRATE
            .block("blaze_powder_bag", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bag/sack/sack_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/bag/sack/blaze_powder_bag_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bag/sack/sack_side_tied"),    //北 north
                        provider.modLoc("block/hoarding/bag/sack/sack_side_tied"),    //南 sorth
                        provider.modLoc("block/hoarding/bag/sack/sack_side_tied"),    //西 west
                        provider.modLoc("block/hoarding/bag/sack/sack_side_tied")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bag/sack/sack_side_tied"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BLAZE_ROD_BUNDLE = REGISTRATE
            .block("blaze_rod_bundle", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/blaze_rod_bundle_end"),         //底部 up
                        provider.modLoc("block/hoarding/blaze_rod_bundle_end"),     //顶部 dowm
                        provider.modLoc("block/hoarding/blaze_rod_bundle_side"),    //北 north
                        provider.modLoc("block/hoarding/blaze_rod_bundle_side"),    //南 sorth
                        provider.modLoc("block/hoarding/blaze_rod_bundle_side"),    //西 west
                        provider.modLoc("block/hoarding/blaze_rod_bundle_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/blaze_rod_bundle_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BLUE_DYE_BUCKET = REGISTRATE
            .block("blue_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bucket/bucket_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/bucket/blue_dye_bucket_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //北 north
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //南 sorth
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //西 west
                        provider.modLoc("block/hoarding/bucket/bucket_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bucket/bucket_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BULE_ORCHID_CRATE = REGISTRATE
            .block("blue_orchid_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/birch/bottom_birch"),         //底部 up
                        provider.modLoc("block/hoarding/crate/birch/blue_orchid_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/birch/blue_orchid_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/birch/blue_orchid_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/birch/blue_orchid_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/birch/blue_orchid_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/birch/blue_orchid_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BONE_PILE = REGISTRATE
            .block("bone_pile", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bone_pile_end"),         //底部 up
                        provider.modLoc("block/hoarding/bone_pile_end"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bone_pile_side"),    //北 north
                        provider.modLoc("block/hoarding/bone_pile_side"),    //南 sorth
                        provider.modLoc("block/hoarding/bone_pile_side"),    //西 west
                        provider.modLoc("block/hoarding/bone_pile_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bone_pile_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BOOK_PILE = REGISTRATE
            .block("book_pile", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/book_pile_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/book_pile_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/book_pile_side_2"),    //北 north
                        provider.modLoc("block/hoarding/book_pile_side_2"),    //南 sorth
                        provider.modLoc("block/hoarding/book_pile_side"),    //西 west
                        provider.modLoc("block/hoarding/book_pile_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/book_pile_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BOTTLE_RACK = REGISTRATE
            .block("bottle_rack", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/rack/rack_top"),         //底部 up
                        provider.modLoc("block/hoarding/rack/rack_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/rack/bottle_rack_side"),    //北 north
                        provider.modLoc("block/hoarding/rack/bottle_rack_side"),    //南 sorth
                        provider.modLoc("block/hoarding/rack/bottle_rack_side"),    //西 west
                        provider.modLoc("block/hoarding/rack/bottle_rack_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/rack/bottle_rack_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BREAD_CRATE = REGISTRATE
            .block("bread_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/oak/bottom_oak"),         //底部 up
                        provider.modLoc("block/hoarding/crate/oak/bread_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/oak/bread_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/oak/bread_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/oak/bread_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/oak/bread_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/oak/bread_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BROWM_DYE_BUCKET = REGISTRATE
            .block("brown_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bucket/bucket_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/bucket/brown_dye_bucket_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //北 north
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //南 sorth
                        provider.modLoc("block/hoarding/bucket/bucket_side"),    //西 west
                        provider.modLoc("block/hoarding/bucket/bucket_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bucket/bucket_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> BROWN_MUSHROOM_CRATE = REGISTRATE
            .block("brown_mushroom_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/oak/bottom_oak"),         //底部 up
                        provider.modLoc("block/hoarding/crate/oak/brown_mushroom_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/oak/brown_mushroom_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/oak/brown_mushroom_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/oak/brown_mushroom_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/oak/brown_mushroom_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/oak/brown_mushroom_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

   public static final BlockEntry<Block> CACTUS_BUNDLE = REGISTRATE
        .block("cactus_bundle", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/cactus_bundle_end"),         //底部 up
                provider.modLoc("block/hoarding/cactus_bundle_end"),     //顶部 dowm
                provider.modLoc("block/hoarding/cactus_bundle_side"),    //北 north
                provider.modLoc("block/hoarding/cactus_bundle_side"),    //南 sorth
                provider.modLoc("block/hoarding/cactus_bundle_side"),    //西 west
                provider.modLoc("block/hoarding/cactus_bundle_side")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/cactus_bundle_side"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

    public static final BlockEntry<Block> CARROT_CRATE = REGISTRATE
            .block("carrot_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/oak/bottom_oak"),         //底部 up
                        provider.modLoc("block/hoarding/crate/oak/carrot_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/oak/carrot_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/oak/carrot_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/oak/carrot_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/oak/carrot_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/oak/carrot_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> CHICKEN_CRATE = REGISTRATE
            .block("chicken_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/chicken_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/chicken_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/chicken_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/chicken_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/chicken_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/chicken_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> CHORUS_FRUIT_CRATE = REGISTRATE
            .block("chorus_fruit_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/others/bottom_end_stone"),         //底部 up
                        provider.modLoc("block/hoarding/crate/others/chorus_fruit_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/others/chorus_fruit_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/others/chorus_fruit_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/others/chorus_fruit_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/others/chorus_fruit_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/others/chorus_fruit_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COCOA_BEANS_BAG = REGISTRATE
            .block("cocoa_beans_bag", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/bag/seed_bag/seed_bag_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/bag/sack/cocoa_beans_bag_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/bag/sack/sack_side"),    //北 north
                        provider.modLoc("block/hoarding/bag/sack/sack_side"),    //南 sorth
                        provider.modLoc("block/hoarding/bag/sack/sack_side"),    //西 west
                        provider.modLoc("block/hoarding/bag/sack/sack_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/bag/sack/sack_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COD_BARREL = REGISTRATE
            .block("cod_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/barrel/barrel_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/barrel/cod_barrel_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //北 north
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //南 sorth
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //西 west
                        provider.modLoc("block/hoarding/barrel/barrel_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/barrel/barrel_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_BEEF_CRATE = REGISTRATE
            .block("cooked_beef_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/cooked_beef_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/cooked_beef_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/cooked_beef_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/cooked_beef_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/cooked_beef_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/cooked_beef_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_CHICKEN_CRATE = REGISTRATE
            .block("cooked_chicken_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/cooked_chicken_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/cooked_chicken_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/cooked_chicken_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/cooked_chicken_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/cooked_chicken_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/cooked_chicken_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_COD_BARREL = REGISTRATE
            .block("cooked_cod_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/barrel/barrel_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/barrel/cooked_cod_barrel_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //北 north
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //南 sorth
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //西 west
                        provider.modLoc("block/hoarding/barrel/barrel_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/barrel/barrel_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_MUTTON_CRATE = REGISTRATE
            .block("cooked_mutton_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/cooked_mutton_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/cooked_mutton_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/cooked_mutton_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/cooked_mutton_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/cooked_mutton_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/cooked_mutton_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_PORKCHOP_CRATE = REGISTRATE
            .block("cooked_porkchop_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/cooked_porkchop_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/cooked_porkchop_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/cooked_porkchop_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/cooked_porkchop_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/cooked_porkchop_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/cooked_porkchop_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_RABBIT_CRATE = REGISTRATE
            .block("cooked_rabbit_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/crate/spruce/bottom_spruce"),         //底部 up
                        provider.modLoc("block/hoarding/crate/spruce/cooked_rabbit_crate_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/crate/spruce/cooked_rabbit_crate_side"),    //北 north
                        provider.modLoc("block/hoarding/crate/spruce/cooked_rabbit_crate_side"),    //南 sorth
                        provider.modLoc("block/hoarding/crate/spruce/cooked_rabbit_crate_side"),    //西 west
                        provider.modLoc("block/hoarding/crate/spruce/cooked_rabbit_crate_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/crate/spruce/cooked_rabbit_crate_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

    public static final BlockEntry<Block> COOKED_SALMON_BARREL = REGISTRATE
            .block("cooked_salmon_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.modLoc("block/hoarding/barrel/barrel_bottom"),         //底部 up
                        provider.modLoc("block/hoarding/barrel/cooked_salmon_barrel_top"),     //顶部 dowm
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //北 north
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //南 sorth
                        provider.modLoc("block/hoarding/barrel/barrel_side"),    //西 west
                        provider.modLoc("block/hoarding/barrel/barrel_side")     //东 east
                ).texture("particle", provider.modLoc("block/hoarding/barrel/barrel_side"));
                provider.simpleBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

public static final BlockEntry<Block> COOKIE_CRATE = REGISTRATE
        .block("cookie_crate", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/crate/oak/bottom_oak"),         //底部 up
                provider.modLoc("block/hoarding/crate/oak/cookie_crate_top"),     //顶部 dowm
                provider.modLoc("block/hoarding/crate/oak/cookie_crate_side"),    //北 north
                provider.modLoc("block/hoarding/crate/oak/cookie_crate_side"),    //南 sorth
                provider.modLoc("block/hoarding/crate/oak/cookie_crate_side"),    //西 west
                provider.modLoc("block/hoarding/crate/oak/cookie_crate_side")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/crate/oak/cookie_crate_side"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

public static final BlockEntry<Block> CORNFLOWER_CRATE = REGISTRATE
        .block("cornflower_crate", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/crate/birch/bottom_birch"),         //底部 up
                provider.modLoc("block/hoarding/crate/birch/cornflower_crate_top"),     //顶部 dowm
                provider.modLoc("block/hoarding/crate/birch/cornflower_crate_side"),    //北 north
                provider.modLoc("block/hoarding/crate/birch/cornflower_crate_side"),    //南 sorth
                provider.modLoc("block/hoarding/crate/birch/cornflower_crate_side"),    //西 west
                provider.modLoc("block/hoarding/crate/birch/cornflower_crate_side")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/crate/birch/cornflower_crate_side"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

public static final BlockEntry<Block> CRIMSON_FUNGUS_CRATE = REGISTRATE
        .block("crimson_fungus_crate", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/crate/others/bottom_crimson"),         //底部 up
                provider.modLoc("block/hoarding/crate/others/crimson_fungus_crate_top"),     //顶部 dowm
                provider.modLoc("block/hoarding/crate/others/crimson_fungus_crate_side"),    //北 north
                provider.modLoc("block/hoarding/crate/others/crimson_fungus_crate_side"),    //南 sorth
                provider.modLoc("block/hoarding/crate/others/crimson_fungus_crate_side"),    //西 west
                provider.modLoc("block/hoarding/crate/others/crimson_fungus_crate_side")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/crate/others/crimson_fungus_crate_side"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

public static final BlockEntry<Block> CYAN_DYE_BUCKET = REGISTRATE
        .block("cyan_dye_bucket", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/bucket/bucket_bottom"),         //底部 up
                provider.modLoc("block/hoarding/bucket/cyan_dye_bucket_top"),     //顶部 dowm
                provider.modLoc("block/hoarding/bucket/bucket_side"),    //北 north
                provider.modLoc("block/hoarding/bucket/bucket_side"),    //南 sorth
                provider.modLoc("block/hoarding/bucket/bucket_side"),    //西 west
                provider.modLoc("block/hoarding/bucket/bucket_side")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/bucket/bucket_side"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

    public static final BlockEntry<Block> DANDELION_CRATE = REGISTRATE
            .block("dandelion_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Dandelion Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.DANDELION))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LILY_CRATE = REGISTRATE
            .block("lily_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Lily Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.LILY_OF_THE_VALLEY))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> OXEYE_DAISY_CRATE = REGISTRATE
            .block("oxeye_daisy_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Oxeye Daisy Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.OXEYE_DAISY))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> POPPY_CRATE = REGISTRATE
            .block("poppy_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Poppy Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.POPPY))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ORANGE_TULIP_CRATE = REGISTRATE
            .block("orange_tulip_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Orange Tulip Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.ORANGE_TULIP))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> PINK_TULIP_CRATE = REGISTRATE
            .block("pink_tulip_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Pink Tulip Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.PINK_TULIP))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> RED_TULIP_CRATE = REGISTRATE
            .block("red_tulip_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Red Tulip Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.RED_TULIP))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> WHITE_TULIP_CRATE = REGISTRATE
            .block("white_tulip_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("White Tulip Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.WHITE_TULIP))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> TORCHFLOWER_CRATE = REGISTRATE
            .block("torchflower_crate", Block::new)
            .initialProperties(() -> Blocks.BIRCH_PLANKS)
            .lang("Torchflower Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("birch", "birch"))
            .recipe(storageRecipe(Items.TORCHFLOWER))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GOLDEN_APPLE_CRATE = REGISTRATE
            .block("golden_apple_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Golden Apple Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("oak", "oak"))
            .recipe(storageRecipe(Items.GOLDEN_APPLE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> POISONOUS_POTATO_CRATE = REGISTRATE
            .block("poisonous_potato_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Poisonous Potato Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("oak", "oak"))
            .recipe(storageRecipe(Items.POISONOUS_POTATO))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> RED_MUSHROOM_CRATE = REGISTRATE
            .block("red_mushroom_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Red Mushroom Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("oak", "oak"))
            .recipe(storageRecipe(Items.RED_MUSHROOM))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GOLDEN_CARROT_CRATE = REGISTRATE
            .block("golden_carrot_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Golden Carrot Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("oak", "oak"))
            .recipe(storageRecipe(Items.GOLDEN_CARROT))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SWEET_BERRIES_CRATE = REGISTRATE
            .block("sweet_berries_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Sweet Berries Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("oak", "oak"))
            .recipe(storageRecipe(Items.SWEET_BERRIES))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GLOW_BERRIES_CRATE = REGISTRATE
            .block("glow_berries_crate", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Glow Berries Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("oak", "oak"))
            .recipe(storageRecipe(Items.GLOW_BERRIES))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> MUTTON_CRATE = REGISTRATE
            .block("mutton_crate", Block::new)
            .initialProperties(() -> Blocks.SPRUCE_PLANKS)
            .lang("Mutton Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("spruce", "spruce"))
            .recipe(storageRecipe(Items.MUTTON))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> RABBIT_CRATE = REGISTRATE
            .block("rabbit_crate", Block::new)
            .initialProperties(() -> Blocks.SPRUCE_PLANKS)
            .lang("Rabbit Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("spruce", "spruce"))
            .recipe(storageRecipe(Items.RABBIT))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> RABBIT_FOOT_CRATE = REGISTRATE
            .block("rabbit_foot_crate", Block::new)
            .initialProperties(() -> Blocks.SPRUCE_PLANKS)
            .lang("Rabbit Foot Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("spruce", "spruce"))
            .recipe(storageRecipe(Items.RABBIT_FOOT))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> PORKCHOP_CRATE = REGISTRATE
            .block("porkchop_crate", Block::new)
            .initialProperties(() -> Blocks.SPRUCE_PLANKS)
            .lang("Porkchop Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("spruce", "spruce"))
            .recipe(storageRecipe(Items.PORKCHOP))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ENDER_EYE_CRATE = REGISTRATE
            .block("ender_eye_crate", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Ender Eye Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(crateModel("iron", "iron"))
            .recipe(storageRecipe(Items.ENDER_EYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ENDER_PEARL_CRATE = REGISTRATE
            .block("ender_pearl_crate", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Ender Pearl Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(crateModel("iron", "iron"))
            .recipe(storageRecipe(Items.ENDER_PEARL))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ROTTEN_FLESH_CRATE = REGISTRATE
            .block("rotten_flesh_crate", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Rotten Flesh Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(crateModel("iron", "iron"))
            .recipe(storageRecipe(Items.ROTTEN_FLESH))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SPIDER_EYE_CRATE = REGISTRATE
            .block("spider_eye_crate", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Spider Eye Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(crateModel("iron", "iron"))
            .recipe(storageRecipe(Items.SPIDER_EYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> FERMENTED_SPIDER_EYE_CRATE = REGISTRATE
            .block("fermented_spider_eye_crate", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Fermented Spider Eye Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(crateModel("iron", "iron"))
            .recipe(storageRecipe(Items.FERMENTED_SPIDER_EYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> WARPED_FUNGUS_CRATE = REGISTRATE
            .block("warped_fungus_crate", Block::new)
            .initialProperties(() -> Blocks.CRIMSON_PLANKS)
            .lang("Warped Fungus Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("others", "crimson"))
            .recipe(storageRecipe(Items.WARPED_FUNGUS))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> NETHER_WART_CRATE = REGISTRATE
            .block("nether_wart_crate", Block::new)
            .initialProperties(() -> Blocks.CRIMSON_PLANKS)
            .lang("Nether Wart Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("others", "crimson"))
            .recipe(storageRecipe(Items.NETHER_WART))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> WITHER_ROSE_CRATE = REGISTRATE
            .<Block>block("wither_rose_crate", properties -> new EffectBlock(properties, MobEffects.WITHER))
            .initialProperties(() -> Blocks.CRIMSON_PLANKS)
            .lang("Wither Rose Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(crateModel("others", "crimson"))
            .recipe(storageRecipe(Items.WITHER_ROSE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> POPPED_CHORUS_FRUIT_CRATE = REGISTRATE
            .block("popped_chorus_fruit_crate", Block::new)
            .initialProperties(() -> Blocks.END_STONE)
            .lang("Popped Chorus Fruit Crate")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(crateModel("others", "end_stone"))
            .recipe(storageRecipe(Items.POPPED_CHORUS_FRUIT))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> SALMON_BARREL = REGISTRATE
            .block("salmon_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Salmon Barrel")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(storageCube("barrel/barrel_side", "barrel/barrel_bottom", "barrel/"))
            .recipe(storageRecipe(Items.SALMON))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> INK_SAC_BARREL = REGISTRATE
            .block("ink_sac_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Ink Sac Barrel")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(storageCube("barrel/barrel_side", "barrel/barrel_bottom", "barrel/"))
            .recipe(storageRecipe(Items.INK_SAC))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GLOW_INK_SAC_BARREL = REGISTRATE
            .block("glow_ink_sac_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Glow Ink Sac Barrel")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(storageCube("barrel/barrel_side", "barrel/barrel_bottom", "barrel/"))
            .recipe(storageRecipe(Items.GLOW_INK_SAC))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> PUFFERFISH_BARREL = REGISTRATE
            .<Block>block("pufferfish_barrel", properties -> new EffectBlock(properties, MobEffects.POISON))
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Pufferfish Barrel")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(storageCube("barrel/barrel_side", "barrel/barrel_bottom", "barrel/"))
            .recipe(storageRecipe(Items.PUFFERFISH))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> TROPICAL_FISH_BARREL = REGISTRATE
            .block("tropical_fish_barrel", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Tropical Fish Barrel")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate(storageCube("barrel/barrel_side", "barrel/barrel_bottom", "barrel/"))
            .recipe(storageRecipe(Items.TROPICAL_FISH))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> WHITE_DYE_BUCKET = REGISTRATE
            .block("white_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("White Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.WHITE_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> ORANGE_DYE_BUCKET = REGISTRATE
            .block("orange_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Orange Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.ORANGE_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> MAGENTA_DYE_BUCKET = REGISTRATE
            .block("magenta_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Magenta Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.MAGENTA_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LIGHT_BLUE_DYE_BUCKET = REGISTRATE
            .block("light_blue_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Light Blue Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.LIGHT_BLUE_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> YELLOW_DYE_BUCKET = REGISTRATE
            .block("yellow_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Yellow Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.YELLOW_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LIME_DYE_BUCKET = REGISTRATE
            .block("lime_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Lime Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.LIME_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> PINK_DYE_BUCKET = REGISTRATE
            .block("pink_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Pink Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.PINK_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GRAY_DYE_BUCKET = REGISTRATE
            .block("gray_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Gray Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.GRAY_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> LIGHT_GRAY_DYE_BUCKET = REGISTRATE
            .block("light_gray_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Light Gray Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.LIGHT_GRAY_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> PURPLE_DYE_BUCKET = REGISTRATE
            .block("purple_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Purple Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.PURPLE_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> GREEN_DYE_BUCKET = REGISTRATE
            .block("green_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Green Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.GREEN_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> RED_DYE_BUCKET = REGISTRATE
            .block("red_dye_bucket", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .lang("Red Dye Bucket")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate(storageCube("bucket/bucket_side", "bucket/bucket_bottom", "bucket/"))
            .recipe(storageRecipe(Items.RED_DYE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> EGG_RACK = REGISTRATE
            .block("egg_rack", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Egg Rack")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models().cubeBottomTop(
                    ctx.getName(), storageTexture("rack/" + ctx.getName() + "_side"),
                    storageTexture("rack/rack_top"), storageTexture("rack/rack_top"))))
            .recipe(storageRecipe(Items.EGG))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> TURTLE_EGG_RACK = REGISTRATE
            .block("turtle_egg_rack", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .lang("Turtle Egg Rack")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_AXE)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models().cubeBottomTop(
                    ctx.getName(), storageTexture("rack/" + ctx.getName() + "_side"),
                    storageTexture("rack/rack_top"), storageTexture("rack/rack_top"))))
            .recipe(storageRecipe(Items.TURTLE_EGG))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> SUGAR_BAG = REGISTRATE
            .block("sugar_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Sugar Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/sack/", "sack"))
            .recipe(storageRecipe(Items.SUGAR))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> GUNPOWDER_BAG = REGISTRATE
            .block("gunpowder_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Gunpowder Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/sack/", "sack"))
            .recipe(storageRecipe(Items.GUNPOWDER))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> FEATHER_BAG = REGISTRATE
            .block("feather_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Feather Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/sack/", "sack"))
            .recipe(storageRecipe(Items.FEATHER))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> WHEAT_SEEDS_BAG = REGISTRATE
            .block("wheat_seeds_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Wheat Seeds Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/seed_bag/", "seed_bag"))
            .recipe(storageRecipe(Items.WHEAT_SEEDS))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> MELON_SEEDS_BAG = REGISTRATE
            .block("melon_seeds_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Melon Seeds Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/seed_bag/", "seed_bag"))
            .recipe(storageRecipe(Items.MELON_SEEDS))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> PUMPKIN_SEEDS_BAG = REGISTRATE
            .block("pumpkin_seeds_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Pumpkin Seeds Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/seed_bag/", "seed_bag"))
            .recipe(storageRecipe(Items.PUMPKIN_SEEDS))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> TORCHFLOWER_SEEDS_BAG = REGISTRATE
            .block("torchflower_seeds_bag", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Torchflower Seeds Bag")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate(storageBag("bag/seed_bag/", "seed_bag"))
            .recipe(storageRecipe(Items.TORCHFLOWER_SEEDS))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> FLINT_BLOCK = REGISTRATE
            .block("flint_block", Block::new)
            .initialProperties(() -> Blocks.COBBLESTONE)
            .lang("Flint Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(),
                    provider.models().cubeAll(ctx.getName(), storageTexture(ctx.getName()))))
            .recipe(storageRecipe(Items.FLINT))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> NETHER_STAR_BLOCK = REGISTRATE
            .block("nether_star_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .lang("Nether Star Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(),
                    provider.models().cubeAll(ctx.getName(), storageTexture(ctx.getName()))))
            .recipe(storageRecipe(Items.NETHER_STAR))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> LEATHER_BLOCK = REGISTRATE
            .block("leather_block", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Leather Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> provider.axisBlock(ctx.get(),
                    storageTexture(ctx.getName() + "_side"), storageTexture(ctx.getName() + "_end")))
            .recipe(storageRecipe(Items.LEATHER))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> SUGARCANE_BUNDLE = REGISTRATE
            .block("sugarcane_bundle", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.OAK_WOOD)
            .lang("Sugarcane Bundle")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> provider.axisBlock(ctx.get(),
                    storageTexture(ctx.getName() + "_side"), storageTexture(ctx.getName() + "_end")))
            .recipe(storageRecipe(Items.SUGAR_CANE))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> STICK_BUNDLE = REGISTRATE
            .block("stick_bundle", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.OAK_WOOD)
            .lang("Stick Bundle")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> provider.axisBlock(ctx.get(),
                    storageTexture(ctx.getName() + "_side"), storageTexture(ctx.getName() + "_end")))
            .recipe(storageRecipe(Items.STICK))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> GLISTERING_MELON = REGISTRATE
            .block("glistering_melon", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.MELON)
            .lang("Glistering Melon")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> provider.axisBlock(ctx.get(),
                    storageTexture(ctx.getName() + "_side"), storageTexture(ctx.getName() + "_end")))
            .recipe(storageRecipe(Items.GLISTERING_MELON_SLICE))
            .simpleItem()
            .register();

    public static final BlockEntry<RotatedPillarBlock> SPOOL = REGISTRATE
            .block("spool", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Spool")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> provider.axisBlock(ctx.get(),
                    storageTexture(ctx.getName() + "_side"), storageTexture(ctx.getName() + "_end")))
            .recipe(storageRecipe(Items.STRING))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> PAPER_STACK = REGISTRATE
            .block("paper_stack", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Paper Stack")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> facingStorageModel(ctx.get(), provider, ctx.getName(),
                    "paper_stack_front", "paper_stack_side", "paper_stack_top",
                    "paper_stack_top", "paper_stack_front"))
            .recipe(storageRecipe(Items.PAPER))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> SCUTE_BLOCK = REGISTRATE
            .block("scute_block", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Scute Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> facingStorageModel(ctx.get(), provider, ctx.getName(),
                    ctx.getName() + "_front", ctx.getName() + "_side", ctx.getName() + "_top",
                    ctx.getName() + "_bottom", ctx.getName() + "_back"))
            .recipe(storageRecipe(Items.SCUTE))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> PHANTOM_MEMBRANE_BLOCK = REGISTRATE
            .block("phantom_membrane_block", StorageFacingBlock::new)
            .initialProperties(() -> Blocks.WHITE_WOOL)
            .lang("Phantom Membrane Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> facingStorageModel(ctx.get(), provider, ctx.getName(),
                    ctx.getName() + "_front", ctx.getName() + "_side", ctx.getName() + "_top",
                    ctx.getName() + "_bottom", ctx.getName() + "_back"))
            .recipe(storageRecipe(Items.PHANTOM_MEMBRANE))
            .simpleItem()
            .register();

    public static final BlockEntry<Block> MAGMA_CREAM_BLOCK = REGISTRATE
            .block("magma_cream_block", Block::new)
            .initialProperties(() -> Blocks.SLIME_BLOCK)
            .properties(properties -> properties.strength(2.0F, 3.0F).lightLevel(state -> 10))
            .lang("Magma Cream Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .blockstate((ctx, provider) -> provider.simpleBlock(ctx.get(),
                    provider.models().getExistingFile(storageTexture("magma_cream_block"))))
            .recipe(storageRecipe(Items.MAGMA_CREAM))
            .simpleItem()
            .register();

    public static final BlockEntry<? extends Block> NAUTILUS_BLOCK = REGISTRATE
            .block("nautilus_block", NautilusBlock::new)
            .initialProperties(() -> Blocks.BONE_BLOCK)
            .lang("Nautilus Block")
            .tag(Tags.Blocks.STORAGE_BLOCKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((ctx, provider) -> provider.horizontalBlock(ctx.get(),
                    provider.models().getExistingFile(storageTexture("nautilus_shell_block"))))
            .recipe(storageRecipe(Items.NAUTILUS_SHELL))
            .item()
            .model((ctx, provider) -> provider.withExistingParent(ctx.getName(),
                    storageTexture("nautilus_shell_block")))
            .build()
            .register();

    private static ResourceLocation storageTexture(String texture) {
        return ListMod.rl("block/hoarding/" + texture);
    }

    private static NonNullBiConsumer<DataGenContext<Block, Block>, RegistrateBlockstateProvider> crateModel(
            String folder, String bottomMaterial) {
        String path = "crate/" + folder + "/";
        return (ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models().cubeBottomTop(
                ctx.getName(), storageTexture(path + ctx.getName() + "_side"),
                storageTexture(path + "bottom_" + bottomMaterial), storageTexture(path + ctx.getName() + "_top")));
    }

    private static NonNullBiConsumer<DataGenContext<Block, Block>, RegistrateBlockstateProvider> storageCube(
            String side, String bottom, String topFolder) {
        return (ctx, provider) -> provider.simpleBlock(ctx.get(), provider.models().cubeBottomTop(
                ctx.getName(), storageTexture(side), storageTexture(bottom),
                storageTexture(topFolder + ctx.getName() + "_top")));
    }

    private static NonNullBiConsumer<DataGenContext<Block, StorageFacingBlock>, RegistrateBlockstateProvider> storageBag(
            String folder, String texturePrefix) {
        return (ctx, provider) -> facingStorageModel(ctx.get(), provider, ctx.getName(),
                folder + texturePrefix + "_side", folder + texturePrefix + "_side_tied",
                folder + ctx.getName() + "_top", folder + texturePrefix + "_bottom",
                folder + texturePrefix + "_side");
    }

    private static void facingStorageModel(StorageFacingBlock block, RegistrateBlockstateProvider provider,
                                           String id, String front, String side, String top, String bottom, String back) {
        provider.horizontalBlock(block, provider.models().cube(id, storageTexture(bottom), storageTexture(top),
                storageTexture(front), storageTexture(back), storageTexture(side), storageTexture(side))
                .texture("particle", storageTexture(side)));
    }

    private static <T extends Block> NonNullBiConsumer<DataGenContext<Block, T>, RegistrateRecipeProvider> storageRecipe(
            Item source) {
        return (ctx, provider) -> {
            String id = ctx.getName();
            T block = ctx.get();
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block)
                    .define('#', source)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .unlockedBy("has_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(source))
                    .save(provider, ListMod.rl("storage/pack/" + id));
            RecipeCategory category = source.isEdible() ? RecipeCategory.FOOD : RecipeCategory.MISC;
            ShapelessRecipeBuilder.shapeless(category, source, 9)
                    .requires(block)
                    .unlockedBy("has_storage_block", InventoryChangeTrigger.TriggerInstance.hasItems(block))
                    .save(provider, ListMod.rl("storage/unpack/" + id));
        };
    }

    private static final class EffectBlock extends Block {
        private final MobEffect effect;

        private EffectBlock(Properties properties, MobEffect effect) {
            super(properties);
            this.effect = effect;
        }

        @Override
        public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
            if (!level.isClientSide && entity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(effect, 40));
            }
            super.stepOn(level, pos, state, entity);
        }
    }

    private static class StorageFacingBlock extends CommonBlock {
        private StorageFacingBlock(Properties properties) {
            super(properties);
        }

        @Override
        public SoundType getSoundType(BlockState state) {
            return soundType;
        }
    }

    private static final class NautilusBlock extends StorageFacingBlock {
        private static final VoxelShape SHAPE_X = Block.box(0, 0, 1, 16, 16, 15);
        private static final VoxelShape SHAPE_Z = Block.box(1, 0, 0, 15, 16, 16);

        private NautilusBlock(Properties properties) {
            super(properties);
        }

        @Override
        public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
            return state.getValue(FACING).getAxis() == Direction.Axis.X ? SHAPE_X : SHAPE_Z;
        }
    }

    public static void register() {
    }
}




/*
public static final BlockEntry<Block> _CRATE = REGISTRATE
        .block("", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/"),         //底部 up
                provider.modLoc("block/hoarding/"),     //顶部 dowm
                provider.modLoc("block/hoarding/"),    //北 north
                provider.modLoc("block/hoarding/"),    //南 sorth
                provider.modLoc("block/hoarding/"),    //西 west
                provider.modLoc("block/hoarding/")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();

public static final BlockEntry<Block> _CRATE = REGISTRATE
        .block("", Block::new)
        .initialProperties(() -> Blocks.OAK_PLANKS)
        .simpleItem()
        .blockstate((ctx, provider) -> {
            BlockModelBuilder model = provider.models().cube(
                ctx.getName(),
                provider.modLoc("block/hoarding/crate/birch/bottom_birch"),         //底部 up
                provider.modLoc("block/hoarding/crate/birch/_top"),     //顶部 dowm
                provider.modLoc("block/hoarding/crate/birch/_side"),    //北 north
                provider.modLoc("block/hoarding/crate/birch/_side"),    //南 sorth
                provider.modLoc("block/hoarding/crate/birch/_side"),    //西 west
                provider.modLoc("block/hoarding/crate/birch/_side")     //东 east
            ).texture("particle", provider.modLoc("block/hoarding/crate/birch/_side"));
             provider.simpleBlock(ctx.get(), model);
        })
        .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
        .register();


*/
