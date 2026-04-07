package com.list.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.list.fish_group.pool.FishPoolDefinition;
import com.list.fish_group.pool.FishPoolDefinitions;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FishPoolLootTableProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;

    public FishPoolLootTableProvider(PackOutput output) {
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "fish_pool_loot_tables/gameplay/fishing_pools");
    }

    @Override
    public @Nonnull CompletableFuture<?> run(@Nonnull CachedOutput output) {
        return CompletableFuture.allOf(
                FishPoolDefinitions.getAll()
                        .stream()
                        .map(definition -> DataProvider.saveStable(output, serialize(definition), this.pathProvider.json(definition.id())))
                        .toArray(CompletableFuture[]::new)
        );
    }

    private JsonObject serialize(FishPoolDefinition definition) {
        JsonObject root = new JsonObject();
        if (definition.fishKing() != null) {
            root.addProperty("FishKing", definition.fishKing().toString());
        }
        if (definition.weatherRequirement() != FishPoolDefinition.WeatherRequirement.ANY) {
            root.addProperty("WeatherRequirement", definition.weatherRequirement().name());
        }
        JsonArray entries = new JsonArray();
        definition.outputs().forEach(output -> entries.add(output.toJson()));
        root.add("entries", entries);
        return root;
    }

    @Override
    public @Nonnull String getName() {
        return "Fish Pool Loot Tables";
    }
}


