package com.list.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class CommonBerryCrop extends BushBlock implements BonemealableBlock {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	private static final VoxelShape[] DEFAULT_SHAPES = new VoxelShape[]{
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 5.0D, 14.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 9.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D)
	};

	protected CommonBerryCrop(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
	}

	protected VoxelShape[] getShapes() {
		return DEFAULT_SHAPES;
	}

	protected Item getBerryItem() {
		return this.asItem();
	}

	protected SoundEvent getHarvestSound() {
		return SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES;
	}

	protected int getHarvestCount(RandomSource random) {
		return 1 + random.nextInt(2);
	}

	protected int getMaxAge() {
		return 3;
	}

	protected boolean mayGrowOn(BlockState state, BlockGetter level, BlockPos pos) {
		return state.is(Blocks.DIRT)
				|| state.is(Blocks.GRASS_BLOCK)
				|| state.is(Blocks.COARSE_DIRT)
				|| state.is(Blocks.PODZOL)
				|| state.is(Blocks.FARMLAND);
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public BlockState getStateForAge(int age) {
		return this.defaultBlockState().setValue(this.getAgeProperty(), age);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return this.getShapes()[state.getValue(this.getAgeProperty())];
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return this.getShape(state, level, pos, context);
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
		return this.getShape(state, level, pos, CollisionContext.empty());
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState state) {
		return true;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		BlockState belowState = level.getBlockState(pos.below());
		return this.mayGrowOn(belowState, level, pos.below()) && super.canSurvive(state, level, pos);
	}

	@Override
	protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
		return this.mayGrowOn(state, level, pos);
	}

	@Override
	public boolean isRandomlyTicking(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (level.getRawBrightness(pos, 0) >= 9) {
			int age = state.getValue(this.getAgeProperty());
			if (age < this.getMaxAge() && random.nextInt(5) == 0) {
				level.setBlock(pos, state.setValue(this.getAgeProperty(), age + 1), 2);
			}
		}
	}

	@Override
	public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
		return true;
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
		return state.getValue(this.getAgeProperty()) < this.getMaxAge();
	}

	protected int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.random, 1, 2);
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		int age = state.getValue(this.getAgeProperty());
		int newAge = Math.min(age + this.getBonemealAgeIncrease(level), this.getMaxAge());
		level.setBlockAndUpdate(pos, state.setValue(this.getAgeProperty(), newAge));
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		int age = state.getValue(this.getAgeProperty());
		if (age >= this.getMaxAge()) {
			int amount = this.getHarvestCount(level.random);
			popResource(level, pos, new ItemStack(this.getBerryItem(), amount));
			level.playSound(null, pos, this.getHarvestSound(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
			level.setBlock(pos, state.setValue(this.getAgeProperty(), 1), 2);
			return InteractionResult.SUCCESS;
		}

		if (player.getItemInHand(hand).is(Items.BONE_MEAL)) {
			return InteractionResult.PASS;
		}

		return InteractionResult.PASS;
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (!state.canSurvive(level, currentPos)) {
			level.scheduleTick(currentPos, this, 1);
		}

		return state;
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
		return new ItemStack(this.getBerryItem());
	}

	@Override
	public PushReaction getPistonPushReaction(BlockState state) {
		return PushReaction.DESTROY;
	}

	@Override
	public SoundType getSoundType(BlockState state) {
		return SoundType.GRASS;
	}
}
