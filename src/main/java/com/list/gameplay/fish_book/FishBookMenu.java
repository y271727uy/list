package com.list.gameplay.fish_book;

import com.list.all.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.List;

public final class FishBookMenu extends AbstractContainerMenu {
    private final List<FishBookEntry.Synced> entries;

    public FishBookMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory, FriendlyByteBuf buffer) {
        this(menuType, containerId, inventory, readEntries(buffer));
    }

    public FishBookMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory) {
        this(menuType, containerId, inventory, List.of());
    }

    private FishBookMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory, List<FishBookEntry.Synced> entries) {
        super(menuType == null ? ModMenus.FISH_BOOK.get() : menuType, containerId);
        this.entries = entries;
    }

    public List<FishBookEntry.Synced> entries() {
        return this.entries;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    private static List<FishBookEntry.Synced> readEntries(FriendlyByteBuf buffer) {
        int size = buffer.readVarInt();
        java.util.ArrayList<FishBookEntry.Synced> entries = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            entries.add(FishBookEntry.readSynced(buffer));
        }
        return List.copyOf(entries);
    }
}
