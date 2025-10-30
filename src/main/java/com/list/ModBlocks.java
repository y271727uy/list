package com.list;

import com.list.block.custom.FishPondCoreBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, ListMod.MODID);
    
    // 温室加热炉
    public static final RegistryObject<Block> GREENHOUSE_FURNACE = 
        BLOCKS.register("greenhouse_furnace", () -> new com.list.block.custom.GreenhouseFurnaceBlock());
    
    public static final RegistryObject<Block> FISHPOND_CORE = 
        BLOCKS.register("fishpond_core", FishPondCoreBlock::new);
}