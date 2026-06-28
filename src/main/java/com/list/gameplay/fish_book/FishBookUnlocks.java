package com.list.gameplay.fish_book;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public final class FishBookUnlocks {
    private FishBookUnlocks() {
    }

    public static void tryUnlock(ServerPlayer player, ItemStack stack) {
        if (stack.isEmpty() || !FishBookManager.INSTANCE.isTracked(stack.getItem())) {
            return;
        }

        player.getCapability(FishBookStatsProvider.FISH_BOOK_STATS)
                .ifPresent(stats -> stats.unlock(stack.getItem()));
    }

    public static void scanInventory(ServerPlayer player) {
        for (ItemStack stack : player.getInventory().items) {
            tryUnlock(player, stack);
        }
        for (ItemStack stack : player.getInventory().offhand) {
            tryUnlock(player, stack);
        }
        for (ItemStack stack : player.getInventory().armor) {
            tryUnlock(player, stack);
        }
    }
}
