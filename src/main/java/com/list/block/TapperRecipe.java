package com.list.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Standalone recipe holder and helper utilities for Tapper.
 */
public class TapperRecipe {
    public final String input;
    public final String output;
    public final int time;
    public final String tool;

    public TapperRecipe(String input, String output, int time, String tool) {
        this.input = input;
        this.output = output;
        this.time = time;
        this.tool = tool;
    }

    public static final TapperRecipe[] RECIPES = new TapperRecipe[]{
            new TapperRecipe("meadow:pine_log", "list:tree_sap", 30, "minecraft:glass_bottle"),
            new TapperRecipe("minecraft:oak_log", "list:tree_sap", 3000, "minecraft:glass_bottle"),
            new TapperRecipe("autumnity:maple_log", "minecraft:oak_log", 3000, "minecraft:glass_bottle"),
            new TapperRecipe("minecraft:birch_log", "cosmopolitan:birch_sap_block", 1500, "minecraft:glass_bottle"),
            new TapperRecipe("biomeswevegone:mahogany_log", "minecraft:oak_log", 3000, "minecraft:glass_bottle")
    };

    public static TapperRecipe findAttachedRecipe(Level level, BlockPos pos, Direction facing) {
        BlockPos attachedPos = switch (facing) {
            case NORTH -> pos.south();
            case SOUTH -> pos.north();
            case EAST -> pos.west();
            case WEST -> pos.east();
            default -> null;
        };

        if (attachedPos == null) return null;
        BlockState attachedState = level.getBlockState(attachedPos);
        Block attached = attachedState.getBlock();
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(attached);
        String id = key == null ? null : key.toString();

        for (TapperRecipe r : RECIPES) {
            if (r.input == null) continue;
            // tag syntax: start with '#', e.g. "#minecraft:logs"
            if (r.input.startsWith("#")) {
                String tagStr = r.input.substring(1);
                ResourceLocation tagRl = ResourceLocation.tryParse(tagStr);
                if (tagRl == null) continue;
                TagKey<Block> tag = TagKey.create(ForgeRegistries.BLOCKS.getRegistryKey(), tagRl);
                if (attachedState.is(tag)) return r;
            } else {
                if (id != null && id.equals(r.input)) return r;
            }
        }
        return null;
    }

    public static ItemStack parseOutput(String outStr) {
        int count = 1;
        String s = outStr;
        if (s.contains("x ")) {
            String[] parts = s.split("x ", 2);
            try {
                count = Integer.parseInt(parts[0].trim());
                s = parts[1];
            } catch (NumberFormatException ignored) {
            }
        }
        ResourceLocation rl = ResourceLocation.tryParse(s);
        if (rl == null) return ItemStack.EMPTY;
        Item item = ForgeRegistries.ITEMS.getValue(rl);
        if (item == null) return ItemStack.EMPTY;
        return new ItemStack(item, count);
    }
}
