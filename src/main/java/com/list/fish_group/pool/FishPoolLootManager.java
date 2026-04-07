package com.list.fish_group.pool;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.list.ListMod;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

public final class FishPoolLootManager extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = new GsonBuilder().create();
    public static final FishPoolLootManager INSTANCE = new FishPoolLootManager();

    private volatile Map<ResourceLocation, FishPoolLootTable> lootTables = Map.of();

    private FishPoolLootManager() {
        super(GSON, "fish_pool_loot_tables/gameplay/fishing_pools");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsonEntries, ResourceManager resourceManager, ProfilerFiller profiler) {
        java.util.Map<ResourceLocation, FishPoolLootTable> parsedTables = new java.util.HashMap<>();
        jsonEntries.forEach((id, element) -> {
            try {
                parsedTables.put(id, parseTable(id, GsonHelper.convertToJsonObject(element, "fish_pool_loot")));
            } catch (Exception exception) {
                ListMod.LOGGER.error("Failed to parse fish pool loot table {}", id, exception);
            }
        });
        this.lootTables = Map.copyOf(parsedTables);
        ListMod.LOGGER.info("Loaded {} fish pool loot tables", this.lootTables.size());
    }

    public ItemStack rollReward(ResourceLocation poolId, ServerLevel level, RandomSource random) {
        FishPoolLootTable lootTable = this.lootTables.get(poolId);
        if (lootTable == null) {
            return FishPoolDefinitions.get(poolId)
                    .map(this::fromDefinition)
                    .map(table -> table.roll(level, random))
                    .orElseGet(() -> {
                        ListMod.LOGGER.warn("Missing fish pool loot table for {}", poolId);
                        return ItemStack.EMPTY;
                    });
        }
        return lootTable.roll(level, random);
    }

    private FishPoolLootTable fromDefinition(FishPoolDefinition definition) {
        return new FishPoolLootTable(
                definition.outputs()
                        .stream()
                        .map(output -> new FishPoolLootEntry(output.itemId(), output.tagId(), output.usesTag(), output.weight(), new CountRange(output.minCount(), output.maxCount()), output.nbt()))
                        .toList()
        );
    }

    private FishPoolLootTable parseTable(ResourceLocation id, JsonObject root) {
        List<FishPoolLootEntry> entries = new ArrayList<>();

        if (root.has("entries")) {
            addEntries(id, GsonHelper.getAsJsonArray(root, "entries"), entries);
        }

        if (root.has("pools")) {
            JsonArray pools = GsonHelper.getAsJsonArray(root, "pools");
            for (JsonElement poolElement : pools) {
                JsonObject poolObject = GsonHelper.convertToJsonObject(poolElement, "pool");
                if (poolObject.has("entries")) {
                    addEntries(id, GsonHelper.getAsJsonArray(poolObject, "entries"), entries);
                }
            }
        }

        if (entries.isEmpty()) {
            throw new JsonParseException("Fish pool loot table " + id + " does not contain any entries");
        }

        return new FishPoolLootTable(List.copyOf(entries));
    }

    private void addEntries(ResourceLocation tableId, JsonArray jsonEntries, List<FishPoolLootEntry> parsedEntries) {
        for (JsonElement entryElement : jsonEntries) {
            JsonObject entryObject = GsonHelper.convertToJsonObject(entryElement, "entry");
            FishPoolLootEntry entry = parseEntry(tableId, entryObject);
            if (entry != null) {
                parsedEntries.add(entry);
            }
        }
    }

    @Nullable
    private FishPoolLootEntry parseEntry(ResourceLocation tableId, JsonObject entryObject) {
        String configuredTag = getNullableString(entryObject, "tag");
        String configuredItem = getNullableString(entryObject, "item");

        if ((configuredItem == null || configuredItem.isBlank()) && entryObject.has("name")) {
            configuredItem = getNullableString(entryObject, "name");
        }

        boolean useTag = configuredTag != null && !configuredTag.isBlank();
        ResourceLocation itemId = configuredItem == null || configuredItem.isBlank() ? null : parseResourceLocation(tableId, configuredItem, "item");
        ResourceLocation tagId = useTag ? parseResourceLocation(tableId, configuredTag, "tag") : null;
        CountRange countRange = parseCountRange(entryObject);
        String nbt = parseNbt(entryObject);
        int weight = Math.max(1, GsonHelper.getAsInt(entryObject, "weight", 1));

        if (useTag && tagId == null) {
            ListMod.LOGGER.warn("Fish pool loot table {} has an invalid tag entry: {}", tableId, configuredTag);
            return null;
        }
        if (!useTag && itemId == null) {
            ListMod.LOGGER.warn("Fish pool loot table {} has an entry without a valid item: {}", tableId, entryObject);
            return null;
        }

        return new FishPoolLootEntry(itemId, tagId, useTag, weight, countRange, nbt);
    }

    private CountRange parseCountRange(JsonObject entryObject) {
        if (entryObject.has("count")) {
            return readCount(entryObject.get("count"));
        }

        if (entryObject.has("functions")) {
            JsonArray functions = GsonHelper.getAsJsonArray(entryObject, "functions");
            for (JsonElement functionElement : functions) {
                JsonObject functionObject = GsonHelper.convertToJsonObject(functionElement, "function");
                String function = GsonHelper.getAsString(functionObject, "function", "");
                if ("minecraft:set_count".equals(function) && functionObject.has("count")) {
                    return readCount(functionObject.get("count"));
                }
            }
        }

        return new CountRange(1, 1);
    }

    private CountRange readCount(JsonElement countElement) {
        if (countElement.isJsonPrimitive()) {
            int count = Math.max(1, countElement.getAsInt());
            return new CountRange(count, count);
        }

        JsonObject countObject = GsonHelper.convertToJsonObject(countElement, "count");
        int min = Math.max(1, GsonHelper.getAsInt(countObject, "min", 1));
        int max = Math.max(min, GsonHelper.getAsInt(countObject, "max", min));
        return new CountRange(min, max);
    }

    @Nullable
    private String parseNbt(JsonObject entryObject) {
        String directNbt = getNullableString(entryObject, "nbt");
        if (directNbt != null && !directNbt.isBlank()) {
            return directNbt;
        }

        if (entryObject.has("functions")) {
            JsonArray functions = GsonHelper.getAsJsonArray(entryObject, "functions");
            for (JsonElement functionElement : functions) {
                JsonObject functionObject = GsonHelper.convertToJsonObject(functionElement, "function");
                String function = GsonHelper.getAsString(functionObject, "function", "");
                if ("minecraft:set_nbt".equals(function)) {
                    return getNullableString(functionObject, "tag");
                }
            }
        }

        return null;
    }

    @Nullable
    private ResourceLocation parseResourceLocation(ResourceLocation tableId, String rawId, String fieldName) {
        ResourceLocation parsedId = ResourceLocation.tryParse(rawId);
        if (parsedId == null) {
            ListMod.LOGGER.warn("Fish pool loot table {} has invalid {} id {}", tableId, fieldName, rawId);
        }
        return parsedId;
    }

    @Nullable
    private String getNullableString(JsonObject object, String memberName) {
        if (!object.has(memberName)) {
            return null;
        }
        String value = GsonHelper.getAsString(object, memberName, "");
        return value.trim();
    }

    private record FishPoolLootTable(List<FishPoolLootEntry> entries) {
        ItemStack roll(ServerLevel level, RandomSource random) {
            int totalWeight = this.entries.stream().mapToInt(FishPoolLootEntry::weight).sum();
            if (totalWeight <= 0) {
                return ItemStack.EMPTY;
            }

            int roll = random.nextInt(totalWeight);
            for (FishPoolLootEntry entry : this.entries) {
                roll -= entry.weight();
                if (roll < 0) {
                    return entry.createStack(level, random);
                }
            }
            return ItemStack.EMPTY;
        }
    }

    private record FishPoolLootEntry(
            @Nullable ResourceLocation itemId,
            @Nullable ResourceLocation tagId,
            boolean useTag,
            int weight,
            CountRange countRange,
            @Nullable String nbt
    ) {
        ItemStack createStack(ServerLevel level, RandomSource random) {
            Item item = this.resolveItem(level, random);
            if (item == null || item == Items.AIR) {
                return ItemStack.EMPTY;
            }

            ItemStack stack = new ItemStack(item, Mth.nextInt(random, this.countRange.min(), this.countRange.max()));
            if (this.nbt != null && !this.nbt.isBlank()) {
                try {
                    CompoundTag parsedTag = TagParser.parseTag(this.nbt);
                    stack.setTag(parsedTag);
                } catch (CommandSyntaxException exception) {
                    ListMod.LOGGER.warn("Failed to parse fish pool reward nbt {}", this.nbt, exception);
                }
            }
            return stack;
        }

        @Nullable
        private Item resolveItem(ServerLevel level, RandomSource random) {
            if (this.useTag) {
                if (this.tagId == null) {
                    return null;
                }
                Registry<Item> itemRegistry = level.registryAccess().registryOrThrow(Registries.ITEM);
                TagKey<Item> tagKey = TagKey.create(Registries.ITEM, this.tagId);
                List<Item> taggedItems = itemRegistry.getTag(tagKey)
                        .stream()
                        .flatMap(named -> named.stream().map(Holder::value))
                        .filter(item -> item != Items.AIR)
                        .toList();
                if (taggedItems.isEmpty()) {
                    ListMod.LOGGER.warn("Fish pool tag {} does not contain any items", this.tagId);
                    return null;
                }
                return taggedItems.get(random.nextInt(taggedItems.size()));
            }

            if (this.itemId == null) {
                return null;
            }
            return ForgeRegistries.ITEMS.getValue(this.itemId);
        }
    }

    private record CountRange(int min, int max) {
    }
}




