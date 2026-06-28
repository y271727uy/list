package com.list.block.crop.rice;

import com.list.block.crop.CommonDoubleCrop;
import com.list.all.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class UplandRiceBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    public static final BooleanProperty SUPPORTING = BooleanProperty.create("supporting");

    public UplandRiceBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(AGE, 0).setValue(SUPPORTING, false));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CommonDoubleCrop.shapeForAge(state, this.getAgeProperty(), CommonDoubleCrop.STANDARD_4_STAGE_SHAPES);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, SUPPORTING);
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return false;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(CommonDoubleCrop.PLANTABLE_ON);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState().setValue(AGE, 0).setValue(SUPPORTING, false);
        return state.canSurvive(context.getLevel(), context.getClickedPos()) ? state : null;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        this.grow(state, level, pos, random);
    }

    private void grow(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos.above(), 0) >= 6) {
            int age = CommonDoubleCrop.getAge(state, this.getAgeProperty());
            if (age <= this.getMaxAge()) {
                float chance = 10.0F;
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int) (25.0F / chance) + 1) == 0)) {
                    if (age == this.getMaxAge()) {
                        UplandRicePaniclesBlock upper = (UplandRicePaniclesBlock) ModBlocks.UPLAND_RICE_PANICLES.get();
                        if (upper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                            level.setBlockAndUpdate(pos.above(), upper.defaultBlockState());
                            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
                        }
                    } else {
                        level.setBlock(pos, CommonDoubleCrop.withAge(state, this.getAgeProperty(), age + 1), 2);
                        net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
                    }
                }
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        if (!CommonDoubleCrop.isMaxAge(state, this.getAgeProperty(), this.getMaxAge())) {
            return true;
        }

        BlockState upperState = level.getBlockState(pos.above());
        if (upperState.getBlock() instanceof UplandRicePaniclesBlock) {
            return !((UplandRicePaniclesBlock) upperState.getBlock()).isMaxAge(upperState);
        }

        UplandRicePaniclesBlock upper = (UplandRicePaniclesBlock) ModBlocks.UPLAND_RICE_PANICLES.get();
        return upper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above());
    }

    protected int getBonemealAgeIncrease(Level level) {
        return CommonDoubleCrop.getBonemealAgeIncrease(level);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockState top = level.getBlockState(pos.above());
        UplandRicePaniclesBlock upper = (UplandRicePaniclesBlock) ModBlocks.UPLAND_RICE_PANICLES.get();
        int ageGrowth = CommonDoubleCrop.clampAge(CommonDoubleCrop.getAge(state, this.getAgeProperty()) + this.getBonemealAgeIncrease(level), 7);
        if (ageGrowth <= this.getMaxAge()) {
            level.setBlockAndUpdate(pos, CommonDoubleCrop.withAge(state, this.getAgeProperty(), ageGrowth));
        } else {
            if (top.getBlock() == upper) {
                BonemealableBlock growable = (BonemealableBlock) top.getBlock();
                if (growable.isValidBonemealTarget(level, pos.above(), top, false)) {
                    growable.performBonemeal(level, level.random, pos.above(), top);
                }
            } else {
                int remainingGrowth = ageGrowth - this.getMaxAge() - 1;
                if (upper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                    level.setBlockAndUpdate(pos, CommonDoubleCrop.withAge(state, this.getAgeProperty(), this.getMaxAge()));
                    level.setBlock(pos.above(), upper.defaultBlockState().setValue(UplandRicePaniclesBlock.RICE_AGE, remainingGrowth), 2);
                }
            }
        }
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 3;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(ModBlocks.UPLAND_RICE.get().asItem());
    }


    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        BlockState updatedState = super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        if (!updatedState.isAir() && facing == Direction.UP) {
            return updatedState.setValue(SUPPORTING, isSupportingRiceUpper(facingState));
        }
        return updatedState;
    }

    public boolean isSupportingRiceUpper(BlockState topState) {
        return topState.getBlock() == ModBlocks.UPLAND_RICE_PANICLES.get();
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }
}

