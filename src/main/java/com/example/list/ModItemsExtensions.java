package com.example.list;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModItemsExtensions {
    
    public static class GlowingItem extends Item {
        public GlowingItem(Properties properties) {
            super(properties);
        }
        
        @Override
        public boolean isFoil(ItemStack stack) {
            return true;
        }
    }
}