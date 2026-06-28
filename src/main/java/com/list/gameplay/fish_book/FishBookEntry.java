package com.list.gameplay.fish_book;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public record FishBookEntry(
        ResourceLocation id,
        Item item,
        int order,
        Range size,
        Range weight,
        List<ResourceLocation> seasonTags,
        List<ResourceLocation> weatherTags,
        List<String> time,
        List<String> diet,
        List<String> habits
) {
    public FishBookEntry {
        seasonTags = List.copyOf(seasonTags);
        weatherTags = List.copyOf(weatherTags);
        time = List.copyOf(time);
        diet = List.copyOf(diet);
        habits = List.copyOf(habits);
    }

    public ResourceLocation itemId() {
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(this.item);
        return itemId == null ? ResourceLocation.tryParse("minecraft:air") : itemId;
    }

    public boolean isValid() {
        return this.item != Items.AIR;
    }

    public void write(FriendlyByteBuf buffer, boolean unlocked) {
        buffer.writeResourceLocation(this.id);
        buffer.writeResourceLocation(this.itemId());
        buffer.writeVarInt(this.order);
        this.size.write(buffer);
        this.weight.write(buffer);
        writeIds(buffer, this.seasonTags);
        writeIds(buffer, this.weatherTags);
        writeStrings(buffer, this.time);
        writeStrings(buffer, this.diet);
        writeStrings(buffer, this.habits);
        buffer.writeBoolean(unlocked);
    }

    public static Synced readSynced(FriendlyByteBuf buffer) {
        ResourceLocation id = buffer.readResourceLocation();
        ResourceLocation itemId = buffer.readResourceLocation();
        Item item = ForgeRegistries.ITEMS.getValue(itemId);
        int order = buffer.readVarInt();
        Range size = Range.read(buffer);
        Range weight = Range.read(buffer);
        List<ResourceLocation> seasons = readIds(buffer);
        List<ResourceLocation> weather = readIds(buffer);
        List<String> time = readStrings(buffer);
        List<String> diet = readStrings(buffer);
        List<String> habits = readStrings(buffer);
        boolean unlocked = buffer.readBoolean();
        return new Synced(new FishBookEntry(id, item == null ? Items.AIR : item, order, size, weight, seasons, weather, time, diet, habits), unlocked);
    }

    private static void writeIds(FriendlyByteBuf buffer, List<ResourceLocation> ids) {
        buffer.writeVarInt(ids.size());
        ids.forEach(buffer::writeResourceLocation);
    }

    private static List<ResourceLocation> readIds(FriendlyByteBuf buffer) {
        int size = buffer.readVarInt();
        java.util.ArrayList<ResourceLocation> ids = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ids.add(buffer.readResourceLocation());
        }
        return List.copyOf(ids);
    }

    private static void writeStrings(FriendlyByteBuf buffer, List<String> values) {
        buffer.writeVarInt(values.size());
        values.forEach(buffer::writeUtf);
    }

    private static List<String> readStrings(FriendlyByteBuf buffer) {
        int size = buffer.readVarInt();
        java.util.ArrayList<String> values = new java.util.ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add(buffer.readUtf());
        }
        return List.copyOf(values);
    }

    public record Range(int min, int max) {
        public Range {
            max = Math.max(min, max);
        }

        public static Range unknown() {
            return new Range(0, 0);
        }

        public boolean known() {
            return this.min > 0 || this.max > 0;
        }

        public void write(FriendlyByteBuf buffer) {
            buffer.writeVarInt(this.min);
            buffer.writeVarInt(this.max);
        }

        public static Range read(FriendlyByteBuf buffer) {
            return new Range(buffer.readVarInt(), buffer.readVarInt());
        }
    }

    public record Synced(FishBookEntry entry, boolean unlocked) {
    }
}
