package com.list.fish_group.entity;

import com.list.fish_group.util.LuaFishPool;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootTable;

public class FloatingBooksEntity extends FloatingDebrisEntity {
    public FloatingBooksEntity(EntityType<? extends FloatingBooksEntity> type, Level level) {
        super(type, level);
    }

    @Override
    public LootTable getLootTable(ServerLevel serverLevel) {
        return serverLevel.getServer().getLootData().getLootTable(LuaFishPool.of("gameplay/fishing_pools/floating_books"));
    }
}

