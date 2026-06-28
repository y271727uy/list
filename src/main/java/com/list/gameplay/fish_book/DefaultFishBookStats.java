package com.list.gameplay.fish_book;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.LinkedHashSet;
import java.util.Set;

public final class DefaultFishBookStats implements FishBookStats {
    private static final String UNLOCKED_ITEMS_KEY = "unlocked_fish_book_items";
    private final Set<ResourceLocation> unlockedItems = new LinkedHashSet<>();

    @Override
    public boolean unlock(Item item) {
        ResourceLocation key = FishBookStats.key(item);
        return key != null && this.unlockedItems.add(key);
    }

    @Override
    public boolean isUnlocked(Item item) {
        ResourceLocation key = FishBookStats.key(item);
        return key != null && this.unlockedItems.contains(key);
    }

    @Override
    public Set<ResourceLocation> unlockedItems() {
        return Set.copyOf(this.unlockedItems);
    }

    @Override
    public void copyFrom(FishBookStats other) {
        this.unlockedItems.clear();
        this.unlockedItems.addAll(other.unlockedItems());
    }

    @Override
    public void saveNBTData(CompoundTag tag) {
        ListTag list = new ListTag();
        this.unlockedItems.stream()
                .map(ResourceLocation::toString)
                .map(StringTag::valueOf)
                .forEach(list::add);
        tag.put(UNLOCKED_ITEMS_KEY, list);
    }

    @Override
    public void loadNBTData(CompoundTag tag) {
        this.unlockedItems.clear();
        ListTag list = tag.getList(UNLOCKED_ITEMS_KEY, Tag.TAG_STRING);
        for (int i = 0; i < list.size(); i++) {
            ResourceLocation id = ResourceLocation.tryParse(list.getString(i));
            if (id != null) {
                this.unlockedItems.add(id);
            }
        }
    }
}
