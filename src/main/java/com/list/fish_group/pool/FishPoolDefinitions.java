package com.list.fish_group.pool;

import com.list.ListMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;

public final class FishPoolDefinitions {
    private static final Map<ResourceLocation, FishPoolDefinition> DEFINITIONS = new LinkedHashMap<>();

    //混合鱼群 海洋
    public static final FishPoolDefinition OCEAN_FISH_POOL = ocean(
            "ocean_fish_pool",
            8,
            null,
            null,
            FishPoolLootEntryDefinition.item("minecraft:pufferfish", 40, 2, 3),
            FishPoolLootEntryDefinition.item("minecraft:tropical_fish", 60, 3, 5),
            FishPoolLootEntryDefinition.item("minecraft:enchanted_book", 1).withNbt("{StoredEnchantments:[{id:\"minecraft:mending\",lvl:1}]}")
    );
    //混合鱼群 河流
    public static final FishPoolDefinition RIVER_FISH_POOL = river(
            "river_fish_pool",
            6,
            null,
            null,
            FishPoolLootEntryDefinition.tag("list:fish_pool/river_catch", 120, 3, 5),
            FishPoolLootEntryDefinition.item("minecraft:enchanted_book", 1).withNbt("{StoredEnchantments:[{id:\"minecraft:mending\",lvl:1}]}")
    );
    //鲑鱼群
    public static final FishPoolDefinition SALMON_FISH_POOL = river(
            "salmon_fish_pool",
            6,
            null,
            null,
            FishPoolLootEntryDefinition.item("minecraft:salmon", 100, 1, 1)
    );

    private FishPoolDefinitions() {
    }

    public static FishPoolDefinition river(
            String path,
            int maxFishCount,
            @Nullable String fishKing,
            @Nullable FishPoolDefinition.WeatherRequirement weatherRequirement,
            FishPoolLootEntryDefinition... outputs
    ) {
        return register(path, FishPoolDefinition.Environment.RIVER, maxFishCount, fishKing, weatherRequirement, outputs);
    }

    public static FishPoolDefinition ocean(
            String path,
            int maxFishCount,
            @Nullable String fishKing,
            @Nullable FishPoolDefinition.WeatherRequirement weatherRequirement,
            FishPoolLootEntryDefinition... outputs
    ) {
        return register(path, FishPoolDefinition.Environment.OCEAN, maxFishCount, fishKing, weatherRequirement, outputs);
    }

    public static FishPoolDefinition register(
            String path,
            FishPoolDefinition.Environment environment,
            int maxFishCount,
            @Nullable String fishKing,
            @Nullable FishPoolDefinition.WeatherRequirement weatherRequirement,
            FishPoolLootEntryDefinition... outputs
    ) {
        return register(
                ListMod.rl(path),
                environment,
                maxFishCount,
                fishKing == null || fishKing.isBlank() ? null : ResourceLocation.tryParse(fishKing),
                weatherRequirement,
                outputs
        );
    }

    public static FishPoolDefinition register(
            ResourceLocation id,
            FishPoolDefinition.Environment environment,
            int maxFishCount,
            @Nullable ResourceLocation fishKing,
            @Nullable FishPoolDefinition.WeatherRequirement weatherRequirement,
            FishPoolLootEntryDefinition... outputs
    ) {
        FishPoolDefinition definition = new FishPoolDefinition(id, environment, maxFishCount, fishKing, weatherRequirement, List.of(outputs));
        FishPoolDefinition existing = DEFINITIONS.putIfAbsent(id, definition);
        if (existing != null) {
            throw new IllegalStateException("Duplicate fish pool definition: " + id);
        }
        return definition;
    }

    public static Optional<FishPoolDefinition> get(ResourceLocation id) {
        return Optional.ofNullable(DEFINITIONS.get(id));
    }

    public static List<FishPoolDefinition> getAll() {
        return List.copyOf(DEFINITIONS.values());
    }

    public static FishPoolDefinition getOrDefault(ResourceLocation id, FishPoolDefinition.Environment environment) {
        return get(id).orElseGet(() -> getDefault(environment));
    }

    public static FishPoolDefinition getDefault(FishPoolDefinition.Environment environment) {
        return DEFINITIONS.values()
                .stream()
                .filter(definition -> definition.environment() == environment)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No fish pool definition registered for environment: " + environment));
    }

    public static List<FishPoolDefinition> getAvailable(ServerLevel level, FishPoolDefinition.Environment environment) {
        return DEFINITIONS.values()
                .stream()
                .filter(definition -> definition.environment() == environment)
                .filter(definition -> definition.matches(level))
                .toList();
    }
}



