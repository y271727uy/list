package com.list.all;

import com.list.block.FishPondCoreBlock;
import com.list.block.GreenhouseFurnaceBlock;
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


    public static void register() {
    }
}
