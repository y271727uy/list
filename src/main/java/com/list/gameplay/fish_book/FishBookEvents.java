package com.list.gameplay.fish_book;

import com.list.ListMod;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ListMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class FishBookEvents {
    private FishBookEvents() {
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player
                && !event.getObject().getCapability(FishBookStatsProvider.FISH_BOOK_STATS).isPresent()) {
            event.addCapability(ListMod.rl("fish_book"), new FishBookStatsProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(FishBookStatsProvider.FISH_BOOK_STATS).ifPresent(oldStats ->
                event.getEntity().getCapability(FishBookStatsProvider.FISH_BOOK_STATS).ifPresent(newStats ->
                        newStats.copyFrom(oldStats)));
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            FishBookUnlocks.scanInventory(player);
        }
    }

    @SubscribeEvent
    public static void onItemPickup(EntityItemPickupEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            FishBookUnlocks.tryUnlock(player, event.getItem().getItem());
        }
    }

    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            FishBookUnlocks.tryUnlock(player, event.getCrafting());
        }
    }

    @SubscribeEvent
    public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            FishBookUnlocks.tryUnlock(player, event.getSmelting());
        }
    }

    @SubscribeEvent
    public static void onAddReloadListener(AddReloadListenerEvent event) {
        event.addListener(FishBookManager.INSTANCE);
        ListMod.LOGGER.info("Registered fish book reload listener");
    }
}
