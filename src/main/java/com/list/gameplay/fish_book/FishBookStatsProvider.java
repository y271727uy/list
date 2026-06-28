package com.list.gameplay.fish_book;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public final class FishBookStatsProvider implements ICapabilityProvider, INBTSerializable<Tag> {
    public static final Capability<FishBookStats> FISH_BOOK_STATS = CapabilityManager.get(new CapabilityToken<>() {
    });

    private FishBookStats stats;
    private final LazyOptional<FishBookStats> optional = LazyOptional.of(this::getOrCreateStats);

    private FishBookStats getOrCreateStats() {
        if (this.stats == null) {
            this.stats = new DefaultFishBookStats();
        }
        return this.stats;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == FISH_BOOK_STATS ? this.optional.cast() : LazyOptional.empty();
    }

    @Override
    public Tag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        this.getOrCreateStats().saveNBTData(tag);
        return tag;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        this.deserializeNBT((CompoundTag) nbt);
    }
    
    private void deserializeNBT(CompoundTag nbt) {
        this.getOrCreateStats().loadNBTData(nbt);
    }
}
