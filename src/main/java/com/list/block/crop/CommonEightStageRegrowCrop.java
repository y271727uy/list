package com.list.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

/**
 * 可重复采摘的八阶段作物（age 0~7），如牛排番茄。逻辑与数据生成沿用 CommonRegrowCrop。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~7
 */
public class CommonEightStageRegrowCrop extends CommonRegrowCrop {

	public static final int EIGHT_STAGE_MAX_AGE = 7;
	public static final IntegerProperty AGE_7 = BlockStateProperties.AGE_7;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 2.0D, 13.0D),
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 10.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D)
	};

	public CommonEightStageRegrowCrop(Properties properties, Supplier<? extends ItemLike> produce, int harvestResetAge) {
		super(properties, produce, harvestResetAge);
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE_7;
	}

	@Override
	public int getMaxAge() {
		return EIGHT_STAGE_MAX_AGE;
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE_7);
	}
}
