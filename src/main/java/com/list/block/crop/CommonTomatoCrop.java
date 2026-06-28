package com.list.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public abstract class CommonTomatoCrop extends CommonPlantCrop
{
    public static final IntegerProperty VINE_AGE = BlockStateProperties.AGE_3;
    public static final BooleanProperty ROPELOGGED = BooleanProperty.create("ropelogged");
    private static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

	protected CommonTomatoCrop(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0).setValue(ROPELOGGED, false));
    }

    protected abstract Block getCropBlock();

    protected abstract Block getCropOnRopeBlock();

    protected abstract Block getReplacementRopeBlock();

    protected abstract ItemLike getSeedItem();

    protected abstract ItemLike getHarvestItem();

    protected abstract ItemLike getBonusHarvestItem();

    protected abstract SoundEvent getHarvestSound();

    protected abstract boolean isClimbableRope(BlockState stateAbove);

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(this.getAgeProperty());
        boolean isMature = age == getMaxAge();
        if (!isMature && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (isMature) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(this.getHarvestItem(), quantity));

            if (level.random.nextFloat() < 0.05) {
                popResource(level, pos, new ItemStack(this.getBonusHarvestItem()));
            }

            level.playSound(null, pos, this.getHarvestSound(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(this.getAgeProperty(), 0), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.use(state, level, pos, player, hand, hit);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
            if (state.getValue(ROPELOGGED)) {
                this.destroyAndPlaceRope(level, pos);
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;

        // TODO: Remove this conversion, as well as the ropelogged state, in future versions.
        if (state.is(this.getCropBlock()) && state.getValue(ROPELOGGED)) {
            level.setBlockAndUpdate(pos, this.getCropOnRopeBlock().defaultBlockState().setValue(VINE_AGE, this.getAge(state)));
            return;
        }

        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                float speed = 5;
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int) (25.0F / speed) + 1) == 0)) {
                    level.setBlock(pos, state.setValue(this.getAgeProperty(), age + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
                }
            }
            this.climbRopeAbove(level, pos);
        }
    }

    @Override
    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return VINE_AGE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.getSeedItem();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VINE_AGE, ROPELOGGED);
    }


    public void climbRopeAbove(ServerLevel level, BlockPos pos) {
        BlockPos posAbove = pos.above();
        BlockState stateAbove = level.getBlockState(posAbove);
        if (this.isClimbableRope(stateAbove)) {
            int vineHeight = 1;
            while (level.getBlockState(pos.below(vineHeight)).is(this)) {
                vineHeight++;
            }
            if (vineHeight < 3) {
                level.setBlockAndUpdate(posAbove, this.getCropOnRopeBlock().defaultBlockState());
            }
        }
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 2;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        if (!this.isMaxAge(state)) {
            return true;
        }

        BlockPos.MutableBlockPos mutablePos = pos.mutable();
        for (int height = 0; height < 2; height++) {
            mutablePos.move(Direction.UP);
            BlockState nextState = level.getBlockState(mutablePos);
            if (this.isClimbableRope(nextState)) {
                return true;
            }
            if (nextState.is(this.getCropOnRopeBlock())) {
                if (!isMaxAge(nextState)) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        // TODO: Remove this conversion, as well as the ropelogged state, in future versions. //反正我不删
        if (state.is(this.getCropBlock()) && state.getValue(ROPELOGGED)) {
            level.setBlockAndUpdate(pos, this.getCropOnRopeBlock().defaultBlockState().setValue(VINE_AGE, this.getAge(state)));
            return;
        }
        int newAge = this.getAge(state) + this.getBonemealAgeIncrease(level);
        if (newAge <= this.getMaxAge()) {
            level.setBlockAndUpdate(pos, state.setValue(this.getAgeProperty(), newAge));
            if (random.nextFloat() < 0.3F) {
                this.climbRopeAbove(level, pos);
            }
        } else {
            BlockState aboveState = level.getBlockState(pos.above());
            if (this.isClimbableRope(level.getBlockState(pos.above()))) {
                this.climbRopeAbove(level, pos);
            } else if (aboveState.is(this.getCropOnRopeBlock()) && this.isValidBonemealTarget(level, pos, aboveState, false)) {
                performBonemeal(level, random, pos.above(), aboveState);
            }
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (belowState.is(this.getCropBlock()) || belowState.is(this.getCropOnRopeBlock())) {
            return hasGoodCropConditions(level, pos);
        }

        return super.canSurvive(state, level, pos);
    }

    public boolean hasGoodCropConditions(LevelReader level, BlockPos pos) {
        return level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (!state.canSurvive(level, currentPos)) {
            level.scheduleTick(currentPos, this, 1);
        }

        return state;
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        boolean isRopelogged = state.getValue(ROPELOGGED);
        super.playerDestroy(level, player, pos, state, blockEntity, stack);

        if (isRopelogged) {
            this.destroyAndPlaceRope(level, pos);
        }
    }

    protected void destroyAndPlaceRope(Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, this.getReplacementRopeBlock().defaultBlockState());
    }
}
