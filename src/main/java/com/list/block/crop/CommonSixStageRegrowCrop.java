package com.list.block.crop;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;

/**
 * 可重复采摘的六阶段作物（age 0~5），如上古水果。逻辑与数据生成沿用 CommonRegrowCrop。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~5
 */
public class CommonSixStageRegrowCrop extends CommonRegrowCrop {

	public static final int SIX_STAGE_MAX_AGE = 5;
	public static final IntegerProperty AGE_5 = IntegerProperty.create("age", 0, SIX_STAGE_MAX_AGE);

	public CommonSixStageRegrowCrop(Properties properties, Supplier<? extends ItemLike> produce, int harvestResetAge) {
		super(properties, produce, harvestResetAge);
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE_5;
	}

	@Override
	public int getMaxAge() {
		return SIX_STAGE_MAX_AGE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE_5);
	}
}
