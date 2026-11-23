package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.client.model.generators.ConfiguredModel;
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

/**
 * 通用浆果丛（age 0~3，同原版甜浆果丛），直接用浆果种植，多个作物共用这一个类。
 * 成熟后右键采摘 1~2 个，回退到 age 1。可穿过（无碰撞箱）。种植判定沿用 BushBlock / Forge IPlantable。
 */
public class CommonBerryCrop extends BushBlock implements BonemealableBlock {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	private static final VoxelShape[] DEFAULT_SHAPES = new VoxelShape[]{
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 5.0D, 14.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 7.0D, 14.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 9.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 11.0D, 15.0D)
	};

	public CommonBerryCrop(BlockBehaviour.Properties properties) {
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

	// ---------- 数据生成 ----------

	/** blockstate：每个 age 生成一个 cross 模型，贴图 block/crop/grow/<注册名>/<注册名>_stage0~3 */
	public static void blockstate(DataGenContext<Block, ? extends CommonBerryCrop> ctx, RegistrateBlockstateProvider provider) {
		String name = ctx.getName();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			String path = "block/crop/grow/" + name + "/" + name + "_stage" + state.getValue(AGE);
			return ConfiguredModel.builder()
				.modelFile(provider.models().cross(path, provider.modLoc(path)).renderType("cutout"))
				.build();
		});
	}

	/** 破坏掉落：始终掉 1 个浆果（用于重新种植）；成熟时额外掉 1~2 个 */
	public static void loot(RegistrateBlockLootTables lt, CommonBerryCrop block) {
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.getBerryItem())))
			.withPool(LootPool.lootPool()
				.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
					.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AGE, 3)))
				.add(LootItem.lootTableItem(block.getBerryItem())
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
