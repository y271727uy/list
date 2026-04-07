package com.list.fish_group.pool;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;
import java.util.List;

public record FishPoolDefinition(
        ResourceLocation id,
        Environment environment,
        int maxFishCount,
        @Nullable ResourceLocation fishKing,
        WeatherRequirement weatherRequirement,
        List<FishPoolLootEntryDefinition> outputs
) {
    public FishPoolDefinition {
        maxFishCount = Mth.clamp(maxFishCount, 5, 8);
        weatherRequirement = weatherRequirement == null ? WeatherRequirement.ANY : weatherRequirement;
        outputs = List.copyOf(outputs);
        if (outputs.isEmpty()) {
            throw new IllegalArgumentException("Fish pool definition must contain at least one output: " + id);
        }
    }

    public boolean matches(ServerLevel level) {
        return this.weatherRequirement.matches(level);
    }

    public enum Environment {
        OCEAN,
        RIVER
    }

    public enum WeatherRequirement {
        ANY {
            @Override
            public boolean matches(ServerLevel level) {
                return true;
            }
        },
        CLEAR {
            @Override
            public boolean matches(ServerLevel level) {
                return !level.isRaining() && !level.isThundering();
            }
        },
        RAIN {
            @Override
            public boolean matches(ServerLevel level) {
                return level.isRaining() && !level.isThundering();
            }
        },
        THUNDER {
            @Override
            public boolean matches(ServerLevel level) {
                return level.isThundering();
            }
        };

        public abstract boolean matches(ServerLevel level);
    }
}


