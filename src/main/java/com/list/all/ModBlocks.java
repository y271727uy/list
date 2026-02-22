package com.list.all;

import com.list.block.FishPondCoreBlock;
import com.list.block.GreenhouseFurnaceBlock;
import com.list.block.TreeCompostBlock;
import com.list.block.mushroom.StrawMushroomBlock;
import com.list.block.mushroom.SeaMushroomBlock;
import com.list.block.mushroom.CaveMushroomBlock;
import com.list.block.colony.SeaMushroomColonyBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraftforge.client.model.generators.BlockModelBuilder;

import static com.ibm.icu.impl.CurrencyData.provider;
import static com.list.ListMod.REGISTRATE;

public class ModBlocks {

    public static final BlockEntry<GreenhouseFurnaceBlock> GREENHOUSE_FURNACE = REGISTRATE
        .block("greenhouse_furnace", GreenhouseFurnaceBlock::new)
        .initialProperties(() -> Blocks.IRON_BLOCK)
        .simpleItem()
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

    //林业温室 我先借用下TreeCompostBlock吧
    public static final BlockEntry<TreeCompostBlock> FORESTRY_GREENHOUSE = REGISTRATE
            .block("forestry_greenhouse", TreeCompostBlock::new)
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
//测试
    //林业杂交箱
    /*
    public static final BlockEntry<FishPondCoreBlock> FORESTRY_HYBRIDIZER = REGISTRATE
            .block("forestry_hybridizer", FishPondCoreBlock::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .simpleItem()
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cube(
                        ctx.getName(),
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone"),  //应该是正面
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone"),
                        provider.mcLoc("block/smooth_stone")
                ).texture("particle", provider.mcLoc("block/smooth_stone"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL)
            .register();

public static final BlockEntry<FishPondCoreBlock> FORESTRY_HYBRIDIZER = REGISTRATE
        .block("forestry_hybridizer", FishPondCoreBlock::new)
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
*/
//林业杂交箱
public static final BlockEntry<FishPondCoreBlock> FORESTRY_HYBRIDIZER = REGISTRATE
        .block("forestry_hybridizer", FishPondCoreBlock::new)
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
            .model((ctx, provider)  -> {
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
        .initialProperties(() -> Blocks.OAK_PLANKS)
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
        .initialProperties(() -> Blocks.OAK_PLANKS)
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
        .initialProperties(() -> Blocks.OAK_PLANKS)
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
*/