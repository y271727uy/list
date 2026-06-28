package com.list.block.crop.rice;

import com.list.block.crop.CommonDoubleCrop;
import com.list.all.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UplandRicePaniclesBlock extends CropBlock {
    public static final IntegerProperty RICE_AGE = BlockStateProperties.AGE_3;

    public UplandRicePaniclesBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return RICE_AGE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CommonDoubleCrop.shapeForAge(state, this.getAgeProperty(), CommonDoubleCrop.STANDARD_4_STAGE_SHAPES);
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(RICE_AGE);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return CommonDoubleCrop.getBonemealAgeIncrease(level) / 3;
    }

    @Override
    protected net.minecraft.world.level.ItemLike getBaseSeedId() {
        return ModBlocks.UPLAND_RICE.get().asItem();
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ModBlocks.UPLAND_RICE.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState belowState = level.getBlockState(pos.below());
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos))
                && this.mayPlaceOn(belowState, level, pos)
                && CommonDoubleCrop.isMaxAge(belowState, UplandRiceBlock.AGE, 3);
    }
}

