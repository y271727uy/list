package com.list.gameplay.fish_book;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkHooks;

public final class FishBookMenuProvider implements MenuProvider {
    private static final Component TITLE = Component.translatable("screen.list.fish_book");

    @Override
    public Component getDisplayName() {
        return TITLE;
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
        return new FishBookMenu(null, containerId, inventory);
    }

    public static void open(ServerPlayer player) {
        FishBookUnlocks.scanInventory(player);
        NetworkHooks.openScreen(player, new FishBookMenuProvider(), buffer -> {
            var statsOptional = player.getCapability(FishBookStatsProvider.FISH_BOOK_STATS).resolve();
            var stats = statsOptional.orElse(null);
            buffer.writeVarInt(FishBookManager.INSTANCE.entries().size());
            for (FishBookEntry entry : FishBookManager.INSTANCE.entries()) {
                entry.write(buffer, stats != null && stats.isUnlocked(entry.item()));
            }
        });
    }
}
