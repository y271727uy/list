package com.list.all;

import com.list.block.FishPondCoreBlock;
import com.list.block.GreenhouseFurnaceBlock;
import com.list.block.TreeCompostBlock;
import com.list.block.StrawMushroomBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockModelBuilder;

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
                ).texture("particle", provider.modLoc("block/tree_compost/tree_compost"));
                provider.horizontalBlock(ctx.get(), model);
            })
            .tag(BlockTags.MINEABLE_WITH_SHOVEL)
            .register();
    //草菇
    public static final BlockEntry<StrawMushroomBlock> STRAW_MUSHROOM = REGISTRATE
            .block("straw_mushroom", StrawMushroomBlock::new)
            .initialProperties(() -> Blocks.GRASS)
            .blockstate((ctx, provider) -> {
                BlockModelBuilder model = provider.models().cross(ctx.getName(), provider.modLoc("block/mushroom/straw_mushroom"));
                provider.simpleBlock(ctx.get(), model);
            })
            .item()
            .model((ctx, provider) -> {
                provider.generated(ctx::get, provider.modLoc("block/mushroom/straw_mushroom"));
            })
            .build()
            .register();

    public static void register() {
    }
}