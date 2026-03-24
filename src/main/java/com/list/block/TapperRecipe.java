package com.list.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Standalone recipe holder and helper utilities for Tapper.
 */
public class TapperRecipe {
    public final String input;
    public final String output;
    public final int time;

    public TapperRecipe(String input, String output, int time) {
        this.input = input;
        this.output = output;
        this.time = time;
    }

    public static final TapperRecipe[] RECIPES = new TapperRecipe[]{
            new TapperRecipe("meadow:pine_log", "minecraft:oak_log", 3000),
            new TapperRecipe("minecraft:oak_log", "minecraft:oak_log", 3000),
            new TapperRecipe("autumnity:maple_log", "minecraft:oak_log", 3000),
            new TapperRecipe("minecraft:birch_log", "cosmopolitan:birch_sap_block", 1500),
            new TapperRecipe("biomeswevegone:mahogany_log", "minecraft:oak_log", 3000)
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
        Block attached = level.getBlockState(attachedPos).getBlock();
        ResourceLocation key = ForgeRegistries.BLOCKS.getKey(attached);
        if (key == null) return null;
        String id = key.toString();
        for (TapperRecipe r : RECIPES) if (r.input.equals(id)) return r;
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

