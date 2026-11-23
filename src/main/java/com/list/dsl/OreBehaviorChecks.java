package com.list.dsl;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.world.level.EmptyBlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

import java.util.concurrent.CompletableFuture;

/** Datagen checks inspect the actual registered blocks, not merely generated JSON. */
public final class OreBehaviorChecks implements DataProvider {
    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        int fallingCount = 0;
        int bedrockCount = 0;
        for (OreDsl.Definition definition : OreDsl.definitions()) {
            String id = definition.id();
            Block block = definition.block().get();
            boolean shouldFall = id.startsWith("gravel_") || id.startsWith("sand_") || id.startsWith("red_sand_");
            if (shouldFall != (block instanceof FallingBlock)) {
                throw new IllegalStateException("Incorrect gravity type for ore: " + id);
            }
            if (shouldFall) fallingCount++;
            if (id.startsWith("bedrock_")) {
                if (block.defaultBlockState().getDestroySpeed(EmptyBlockGetter.INSTANCE, BlockPos.ZERO) != -1.0F
                        || block.getExplosionResistance() < Blocks.BEDROCK.getExplosionResistance()
                        || !block.getLootTable().equals(BuiltInLootTables.EMPTY)) {
                    throw new IllegalStateException("Bedrock ore is breakable or has loot: " + id);
                }
                bedrockCount++;
            }
        }
        if (fallingCount == 0 || bedrockCount == 0) {
            throw new IllegalStateException("Expected both falling and protected bedrock ores");
        }
        LogUtils.getLogger().info("Verified {} native FallingBlock ores and {} protected bedrock ores", fallingCount, bedrockCount);
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public String getName() {
        return "List ore gravity and bedrock behavior checks";
    }
}
