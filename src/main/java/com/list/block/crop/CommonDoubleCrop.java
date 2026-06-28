package com.list.block.crop;

import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class CommonDoubleCrop {
	public static final TagKey<Block> PLANTABLE_ON = BlockTags.create(new ResourceLocation("list", "plantable_on"));
	public static final VoxelShape[] STANDARD_4_STAGE_SHAPES = new VoxelShape[]{
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D),
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D)
	};

	private CommonDoubleCrop() {
	}

	public static int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.random, 1, 4);
	}

	public static boolean isMaxAge(BlockState state, IntegerProperty ageProperty, int maxAge) {
		return state.getValue(ageProperty) >= maxAge;
	}

	public static int getAge(BlockState state, IntegerProperty ageProperty) {
		return state.getValue(ageProperty);
	}

	public static BlockState withAge(BlockState state, IntegerProperty ageProperty, int age) {
		return state.setValue(ageProperty, age);
	}

	public static VoxelShape shapeForAge(BlockState state, IntegerProperty ageProperty, VoxelShape[] shapes) {
		return shapes[state.getValue(ageProperty)];
	}

	public static int clampAge(int age, int maxAge) {
		return Math.min(age, maxAge);
	}
}

//双层作物