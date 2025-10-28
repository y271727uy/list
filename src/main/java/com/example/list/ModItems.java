package com.example.list;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, ListMod.MODID);
    
    // 工业铜币
    public static final RegistryObject<Item> INDUSTRIAL_COPPER_CREDIT = 
        ITEMS.register("industrial_copper_credit", () -> new Item(new Item.Properties()));
        
    // 工业银币
    public static final RegistryObject<Item> INDUSTRIAL_SILVER_CREDIT = 
        ITEMS.register("industrial_silver_credit", () -> new Item(new Item.Properties()));
        
    // 工业金币
    public static final RegistryObject<Item> INDUSTRIAL_GOLD_CREDIT = 
        ITEMS.register("industrial_gold_credit", () -> new Item(new Item.Properties()));
        
    // 工业铂币
    public static final RegistryObject<Item> INDUSTRIAL_PLATINUM_CREDIT = 
        ITEMS.register("industrial_platinum_credit", () -> new Item(new Item.Properties()));
        
    // 工业锇币
    public static final RegistryObject<Item> INDUSTRIAL_OSMIUM_CREDIT = 
        ITEMS.register("industrial_osmium_credit", () -> new Item(new Item.Properties()));

    // 平平无奇的面包
    public static final RegistryObject<Item> JUST_BREAD = 
        ITEMS.register("just_bread", () -> new ModItemsExtensions.GlowingItem(new Item.Properties().rarity(net.minecraft.world.item.Rarity.EPIC)));

    // 养殖塘控制器方块物品
    public static final RegistryObject<Item> FISHPOND_CORE = 
        ITEMS.register("fishpond_core", () -> new BlockItem(ModBlocks.FISHPOND_CORE.get(), new Item.Properties()));
}