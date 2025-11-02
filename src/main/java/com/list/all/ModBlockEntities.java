package com.list.all;

import com.list.block.entity.FishPondCoreBlockEntity;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.list.ListMod.REGISTRATE;

public class ModBlockEntities {
    public static final BlockEntityEntry<FishPondCoreBlockEntity> FISH_POND_CORE = REGISTRATE
        .blockEntity("fishpond_core", FishPondCoreBlockEntity::new)
        .validBlocks(ModBlocks.FISHPOND_CORE)
        .register();

    public static void register() {
    }
}
