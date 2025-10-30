package com.list;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ListMod.MODID);
    
    public static final RegistryObject<CreativeModeTab> LIST_TAB = 
        CREATIVE_MODE_TABS.register("list", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.list"))
            .icon(() -> new ItemStack(ModItems.INDUSTRIAL_OSMIUM_CREDIT.get()))
            .build());
}