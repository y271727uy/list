package com.list.fish_group;

import com.list.ListMod;
import com.list.fish_group.entity.FloatingDebrisEntity;
import com.list.fish_group.util.FloatingPoolsSpawner;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ListMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class FishGroupEvents {
    private FishGroupEvents() {
    }

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.level instanceof ServerLevel serverLevel) {
            FloatingPoolsSpawner.tick(serverLevel);
        }
    }

    @SubscribeEvent
    public static void onItemFished(ItemFishedEvent event) {
        if (event.getHookEntity() == null || event.getHookEntity().level().isClientSide()) {
            return;
        }

        var owner = event.getHookEntity().getPlayerOwner();
        if (owner == null) {
            return;
        }

        var hookPosition = event.getHookEntity().position();
        AABB hookBox = new AABB(
                hookPosition.x - 1.0D,
                hookPosition.y - 1.0D,
                hookPosition.z - 1.0D,
                hookPosition.x + 1.0D,
                hookPosition.y + 1.0D,
                hookPosition.z + 1.0D
        );

        event.getHookEntity().level().getEntitiesOfClass(FloatingDebrisEntity.class, hookBox)
                .stream()
                .findFirst()
                .ifPresent(entity -> entity.onFishHookInteract(owner));
    }


}


