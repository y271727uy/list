package com.list.gameplay.fish_book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.list.ListMod;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public final class FishBookManager extends SimpleJsonResourceReloadListener {
    private static final Gson GSON = new GsonBuilder().create();
    public static final FishBookManager INSTANCE = new FishBookManager();

    private volatile List<FishBookEntry> entries = List.of();

    private FishBookManager() {
        super(GSON, "fish_book_entries");
    }

    @Override
    protected void apply(@Nonnull Map<ResourceLocation, JsonElement> jsonEntries, @Nonnull ResourceManager resourceManager, @Nonnull ProfilerFiller profiler) {
        java.util.ArrayList<FishBookEntry> parsedEntries = new java.util.ArrayList<>();
        jsonEntries.forEach((id, element) -> {
            try {
                FishBookEntry entry = parseEntry(id, GsonHelper.convertToJsonObject(element, "fish_book_entry"));
                if (entry.isValid()) {
                    parsedEntries.add(entry);
                }
            } catch (Exception exception) {
                ListMod.LOGGER.error("Failed to parse fish book entry {}", id, exception);
            }
        });
        parsedEntries.sort(Comparator
                .comparingInt(FishBookEntry::order)
                .thenComparing(entry -> entry.itemId().toString()));
        this.entries = List.copyOf(parsedEntries);
        ListMod.LOGGER.info("Loaded {} fish book entries", this.entries.size());
    }

    public List<FishBookEntry> entries() {
        return this.entries;
    }

    public boolean isTracked(Item item) {
        return this.entries.stream().anyMatch(entry -> entry.item() == item);
    }

    private FishBookEntry parseEntry(ResourceLocation id, JsonObject root) {
        ResourceLocation itemId = readResourceLocation(root, "item", id);
        Item item = itemId == null ? Items.AIR : ForgeRegistries.ITEMS.getValue(itemId);
        return new FishBookEntry(
                id,
                item == null ? Items.AIR : item,
                Math.max(0, GsonHelper.getAsInt(root, "order", Integer.MAX_VALUE)),
                readRange(root, "size"),
                readRange(root, "weight"),
                readResourceLocationList(root, "seasons", "season_tags", "seasonTags"),
                readResourceLocationList(root, "weather", "weather_tags", "weatherTags"),
                readStringList(root, "time", "times"),
                readStringList(root, "diet", "diets"),
                readStringList(root, "habits", "habit")
        );
    }

    private static FishBookEntry.Range readRange(JsonObject root, String key) {
        if (!root.has(key) || !root.get(key).isJsonObject()) {
            return FishBookEntry.Range.unknown();
        }
        JsonObject range = GsonHelper.getAsJsonObject(root, key);
        return new FishBookEntry.Range(
                Math.max(0, GsonHelper.getAsInt(range, "min", 0)),
                Math.max(0, GsonHelper.getAsInt(range, "max", 0))
        );
    }

    private static List<ResourceLocation> readResourceLocationList(JsonObject root, String... keys) {
        for (String key : keys) {
            if (!root.has(key)) {
                continue;
            }

            java.util.ArrayList<ResourceLocation> ids = new java.util.ArrayList<>();
            JsonElement element = root.get(key);
            if (element.isJsonArray()) {
                JsonArray array = GsonHelper.convertToJsonArray(element, key);
                for (JsonElement value : array) {
                    ResourceLocation id = ResourceLocation.tryParse(value.getAsString());
                    if (id != null) {
                        ids.add(id);
                    }
                }
            } else {
                ResourceLocation id = ResourceLocation.tryParse(GsonHelper.convertToString(element, key));
                if (id != null) {
                    ids.add(id);
                }
            }
            return List.copyOf(ids);
        }
        return List.of();
    }

    private static List<String> readStringList(JsonObject root, String... keys) {
        for (String key : keys) {
            if (!root.has(key)) {
                continue;
            }

            java.util.ArrayList<String> values = new java.util.ArrayList<>();
            JsonElement element = root.get(key);
            if (element.isJsonArray()) {
                JsonArray array = GsonHelper.convertToJsonArray(element, key);
                for (JsonElement value : array) {
                    String text = value.getAsString().trim();
                    if (!text.isBlank()) {
                        values.add(text);
                    }
                }
            } else {
                String text = GsonHelper.convertToString(element, key).trim();
                if (!text.isBlank()) {
                    values.add(text);
                }
            }
            return List.copyOf(values);
        }
        return List.of();
    }

    private static ResourceLocation readResourceLocation(JsonObject root, String key, ResourceLocation entryId) {
        String raw = GsonHelper.getAsString(root, key, "");
        ResourceLocation parsed = ResourceLocation.tryParse(raw);
        if (parsed == null) {
            throw new IllegalArgumentException("Fish book entry " + entryId + " has invalid " + key + ": " + raw);
        }
        return parsed;
    }
}
