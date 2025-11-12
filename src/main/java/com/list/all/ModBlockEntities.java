package com.list.all;

import com.list.block.entity.FishPondCoreBlockEntity;
import com.list.block.entity.TreeCompostBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import static com.list.ListMod.REGISTRATE;

public class ModBlockEntities {
    public static final BlockEntityEntry<FishPondCoreBlockEntity> FISH_POND_CORE = REGISTRATE
        .blockEntity("fishpond_core", FishPondCoreBlockEntity::new)
        .validBlocks(ModBlocks.FISHPOND_CORE)
        .register();

    public static final BlockEntityEntry<TreeCompostBlockEntity> TREE_COMPOST = REGISTRATE
        .blockEntity("tree_compost", (BlockEntityType<TreeCompostBlockEntity> type, BlockPos pos, BlockState state) -> new TreeCompostBlockEntity(type, pos, state))
        .validBlocks(ModBlocks.TREE_COMPOST)
        .register();

    public static void register() {
    }
}