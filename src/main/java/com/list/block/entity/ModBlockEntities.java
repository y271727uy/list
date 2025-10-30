package com.list.block.entity;

import com.list.ListMod;
import com.list.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ListMod.MODID);

    public static final RegistryObject<BlockEntityType<FishPondCoreBlockEntity>> FISH_POND_CORE_BE =
            BLOCK_ENTITIES.register("fishpond_core_be", () ->
                    BlockEntityType.Builder.of(FishPondCoreBlockEntity::new,
                            ModBlocks.FISHPOND_CORE.get()).build(null));
}