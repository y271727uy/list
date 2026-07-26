package com.list.all;

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
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("block/crop/upland_rice_seeds")))
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
/*
    //树坑
    public static final BlockEntry<TreeCompostBlock> TREE_COMPOST = REGISTRATE
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
public static final BlockEntry<CommonBlock> BLACK_BEAUTY_MELON = REGISTRATE
        .block("black_beauty_melon", CommonBlock::new)
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
public static final BlockEntry<CommonBlock> GEM_MELON = REGISTRATE
        .block("gem_melon", CommonBlock::new)
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
public static final BlockEntry<CommonBlock> FROST_MELON = REGISTRATE
        .block("frost_melon", CommonBlock::new)
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
public static final BlockEntry<CommonBlock> QI_MELON = REGISTRATE
        .block("qi_melon", CommonBlock::new)
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
