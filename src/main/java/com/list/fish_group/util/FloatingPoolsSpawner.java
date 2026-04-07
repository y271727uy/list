package com.list.fish_group.util;

import com.list.fish_group.pool.FishPoolDefinition;
import com.list.fish_group.pool.FishPoolDefinitions;
import com.list.fish_group.entity.AbstractFishPoolEntity;
import com.list.fish_group.item.FishGroupRegistry;
import com.list.fish_group.entity.FloatingDebrisEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import org.joml.Vector3d;

import java.util.HashMap;
import java.util.Map;

public class FloatingPoolsSpawner {
    private static final int MAX_COUNT = 3;
    private static final int SPAWN_INTERVAL = 6000;
    private static final Map<ResourceKey<Level>, SpawnState> SPAWN_STATE_BY_DIMENSION = new HashMap<>();

    private static void attemptSpawn(ServerLevel level) {
        if (level.players().isEmpty()) return;
        RandomSource random = level.random;
        var player = level.players().get(random.nextInt(level.players().size()));
        ResourceKey<Level> dimension = level.dimension();
        SpawnState spawnState = SPAWN_STATE_BY_DIMENSION.get(dimension);

        if (spawnState == null || spawnState.lastValidSpawn() == null || (level.getGameTime() - spawnState.lastSpawnTime()) > 12000) {
            BlockPos lastValidSpawn = findValidSpawnPos(level, player.blockPosition());
            SPAWN_STATE_BY_DIMENSION.put(dimension, new SpawnState(lastValidSpawn, level.getGameTime()));
            spawnState = SPAWN_STATE_BY_DIMENSION.get(dimension);
        }

        BlockPos lastValidSpawn = spawnState.lastValidSpawn();
        if (lastValidSpawn == null) return;

        int spawnX = lastValidSpawn.getX();
        int spawnY = lastValidSpawn.getY();
        int spawnZ = lastValidSpawn.getZ();

        AABB area = new AABB(spawnX - 128, spawnY - 128, spawnZ - 128, spawnX + 128, spawnY + 128, spawnZ + 128);
        int totalCount = level.getEntitiesOfClass(FloatingDebrisEntity.class, area).size();

        var biome = level.getBiome(lastValidSpawn);
        if (totalCount >= MAX_COUNT) return;

        java.util.List<java.lang.Runnable> actions = new java.util.ArrayList<>();
        AABB smallArea = new AABB(spawnX - 50, spawnY - 50, spawnZ - 50, spawnX + 50, spawnY + 50, spawnZ + 50);

        if (level.getEntitiesOfClass(FloatingDebrisEntity.class, smallArea).size() < MAX_COUNT) {
            actions.add(() -> {
                FloatingDebrisEntity debris = new FloatingDebrisEntity(FishGroupRegistry.FLOATING_DEBRIS.get(), level);
                Vector3d spawnPos = new Vector3d(spawnX + 0.5, spawnY, spawnZ + 0.5);
                debris.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
                level.addFreshEntity(debris);
            });
        }

        if (biome.is(BiomeTags.IS_OCEAN)) {
            java.util.List<FishPoolDefinition> availablePools = FishPoolDefinitions.getAvailable(level, FishPoolDefinition.Environment.OCEAN);
            if (!availablePools.isEmpty()) {
                actions.add(() -> spawnFishPool(level, random, availablePools, spawnX, spawnY, spawnZ));
            }
        } else if (biome.is(BiomeTags.IS_RIVER)) {
            java.util.List<FishPoolDefinition> availablePools = FishPoolDefinitions.getAvailable(level, FishPoolDefinition.Environment.RIVER);
            if (!availablePools.isEmpty()) {
                actions.add(() -> spawnFishPool(level, random, availablePools, spawnX, spawnY, spawnZ));
            }
        }

        // floating books spawn removed (feature disabled)

        if (actions.isEmpty()) return;

        actions.get(random.nextInt(actions.size())).run();
    }

    private static BlockPos findValidSpawnPos(ServerLevel level, BlockPos center) {
        RandomSource random = level.random;
        for (int i = 0; i < 10; i++) {
            int offsetX = random.nextInt(100 * 2) - 100;
            int offsetZ = random.nextInt(100 * 2) - 100;
            BlockPos newPos = center.offset(offsetX, 0, offsetZ);
            var biome = level.getBiome(newPos);
            if (biome.is(BiomeTags.IS_RIVER) || biome.is(BiomeTags.IS_OCEAN)) {
                int spawnY = level.getHeight(Heightmap.Types.WORLD_SURFACE, newPos.getX(), newPos.getZ()) - 2;
                return new BlockPos(newPos.getX(), spawnY, newPos.getZ());
            }
        }
        return null;
    }

    private static void spawnFishPool(ServerLevel level, RandomSource random, java.util.List<FishPoolDefinition> availablePools, int spawnX, int spawnY, int spawnZ) {
        FishPoolDefinition definition = availablePools.get(random.nextInt(availablePools.size()));
        AbstractFishPoolEntity fishPool = FishGroupRegistry.getFishPoolRegistration(definition.id()).create(level);
        if (fishPool == null) {
            return;
        }
        fishPool.setFishPoolDefinition(definition.id());
        Vector3d spawnPos = new Vector3d(spawnX + 0.5, spawnY, spawnZ + 0.5);
        fishPool.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
        level.addFreshEntity(fishPool);
    }

    public static void tick(ServerLevel level) {
        if (level.getGameTime() % SPAWN_INTERVAL == 0) attemptSpawn(level);
    }

    private record SpawnState(BlockPos lastValidSpawn, long lastSpawnTime) {
    }
}

