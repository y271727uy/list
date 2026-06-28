package com.list.gameplay.fish_book;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

public interface FishBookStats {
    boolean unlock(Item item);

    boolean isUnlocked(Item item);

    Set<ResourceLocation> unlockedItems();

    void copyFrom(FishBookStats other);

    void saveNBTData(CompoundTag tag);

    void loadNBTData(CompoundTag tag);

    static ResourceLocation key(Item item) {
        return ForgeRegistries.ITEMS.getKey(item);
    }
}
