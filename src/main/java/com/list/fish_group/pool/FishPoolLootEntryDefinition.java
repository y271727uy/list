package com.list.fish_group.pool;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

public record FishPoolLootEntryDefinition(
        @Nullable ResourceLocation itemId,
        @Nullable ResourceLocation tagId,
        int weight,
        int minCount,
        int maxCount,
        @Nullable String nbt
) {
    public FishPoolLootEntryDefinition {
        if (itemId == null && tagId == null) {
            throw new IllegalArgumentException("Fish pool loot output must define either an item or a tag");
        }
        if (tagId != null) {
            itemId = null;
        }
        weight = Math.max(1, weight);
        minCount = Math.max(1, minCount);
        maxCount = Math.max(minCount, maxCount);
        if (nbt != null && nbt.isBlank()) {
            nbt = null;
        }
    }

    public static FishPoolLootEntryDefinition item(String itemId, int weight, int minCount, int maxCount) {
        return new FishPoolLootEntryDefinition(parse(itemId, "item"), null, weight, minCount, maxCount, null);
    }

    public static FishPoolLootEntryDefinition item(String itemId, int weight) {
        return item(itemId, weight, 1, 1);
    }

    public static FishPoolLootEntryDefinition tag(String tagId, int weight, int minCount, int maxCount) {
        return new FishPoolLootEntryDefinition(null, parse(tagId, "tag"), weight, minCount, maxCount, null);
    }

    public static FishPoolLootEntryDefinition tag(String tagId, int weight) {
        return tag(tagId, weight, 1, 1);
    }

    public FishPoolLootEntryDefinition withNbt(String nbt) {
        return new FishPoolLootEntryDefinition(this.itemId, this.tagId, this.weight, this.minCount, this.maxCount, nbt);
    }

    public boolean usesTag() {
        return this.tagId != null;
    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        json.addProperty("item", this.itemId == null ? "" : this.itemId.toString());
        json.addProperty("tag", this.tagId == null ? "" : this.tagId.toString());
        json.addProperty("weight", this.weight);

        JsonObject count = new JsonObject();
        count.addProperty("min", Mth.clamp(this.minCount, 1, Integer.MAX_VALUE));
        count.addProperty("max", Mth.clamp(this.maxCount, this.minCount, Integer.MAX_VALUE));
        json.add("count", count);

        if (this.nbt != null) {
            json.addProperty("nbt", this.nbt);
        }
        return json;
    }

    private static ResourceLocation parse(String id, String type) {
        ResourceLocation parsed = ResourceLocation.tryParse(id);
        if (parsed == null) {
            throw new IllegalArgumentException("Invalid fish pool loot " + type + " id: " + id);
        }
        return parsed;
    }
}

