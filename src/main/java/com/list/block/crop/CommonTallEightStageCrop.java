package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import java.util.function.Supplier;

/**
 * 双层的八阶段作物（age 0~7），如水果玉米。一次性收获（打掉采集），不能反复采摘。
 * 下半格是真正的作物（生长、掉落都在下半格）；长到 tallFromAge 起在上方补一个上半格，两格 age 同步。
 * 上方被挡住时不会长到 tallFromAge；破坏任一格两格都会掉，掉落只算下半格一份。
 * 贴图：下半格 block/crop/grow/<注册名>/<注册名>_stage0~7；
 *      上半格 block/crop/grow/<注册名>/<注册名>_top_stage<tallFromAge>~7（均为 16x16）。
 */
public class CommonTallEightStageCrop extends CommonEightStageCrop {

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape LOWER_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
	private static final VoxelShape UPPER_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 14.0D, 15.0D);

	private final int tallFromAge;

	/** @param tallFromAge 从这个 age 起变成两格高（同时也是上半格贴图的起始编号） */
	public CommonTallEightStageCrop(Properties properties, Supplier<? extends ItemLike> produce, int tallFromAge) {
		super(properties, produce);
		this.tallFromAge = tallFromAge;
		this.registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER));
	}

	public int getTallFromAge() {
		return this.tallFromAge;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(HALF);
	}

	private static boolean isUpper(BlockState state) {
		return state.getValue(HALF) == DoubleBlockHalf.UPPER;
	}

	/** 上方是否能放上半格（空气，或已经是本作物的上半格） */
	private boolean hasRoomAbove(LevelReader level, BlockPos lowerPos) {
		BlockState above = level.getBlockState(lowerPos.above());
		return above.isAir() || (above.is(this) && isUpper(above));
	}

	/** 按下半格的 age 补上 / 同步上半格 */
	private void syncUpper(Level level, BlockPos lowerPos) {
		BlockState lower = level.getBlockState(lowerPos);
		if (!lower.is(this) || isUpper(lower) || this.getAge(lower) < this.tallFromAge) {
			return;
		}
		if (this.hasRoomAbove(level, lowerPos)) {
			level.setBlock(lowerPos.above(), lower.setValue(HALF, DoubleBlockHalf.UPPER), Block.UPDATE_ALL);
		}
	}

	@Override
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (isUpper(state)) {
			return;
		}
		if (this.getAge(state) + 1 >= this.tallFromAge && !this.hasRoomAbove(level, pos)) {
			return;
		}
		super.randomTick(state, level, pos, random);
		this.syncUpper(level, pos);
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
		BlockPos lowerPos = isUpper(state) ? pos.below() : pos;
		BlockState lower = level.getBlockState(lowerPos);
		if (!lower.is(this) || this.isMaxAge(lower)) {
			return false;
		}
		return this.getAge(lower) + 1 < this.tallFromAge || this.hasRoomAbove(level, lowerPos);
	}

	@Override
	public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
		BlockPos lowerPos = isUpper(state) ? pos.below() : pos;
		BlockState lower = level.getBlockState(lowerPos);
		int newAge = Math.min(this.getAge(lower) + this.getBonemealAgeIncrease(level), this.getMaxAge());
		if (newAge >= this.tallFromAge && !this.hasRoomAbove(level, lowerPos)) {
			newAge = this.tallFromAge - 1;
		}
		level.setBlock(lowerPos, this.getStateForAge(newAge), Block.UPDATE_CLIENTS);
		this.syncUpper(level, lowerPos);
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		if (isUpper(state)) {
			BlockState below = level.getBlockState(pos.below());
			return below.is(this) && !isUpper(below);
		}
		return super.canSurvive(state, level, pos);
	}

	/** 下半格没了上半格随之消失 */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (isUpper(state) && facing == Direction.DOWN && !(facingState.is(this) && !isUpper(facingState))) {
			return Blocks.AIR.defaultBlockState();
		}
		return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

	/** 破坏上半格时连带破坏下半格，由下半格掉落 */
	@Override
	public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
		if (!level.isClientSide && isUpper(state)) {
			BlockPos lowerPos = pos.below();
			if (level.getBlockState(lowerPos).is(this)) {
				level.destroyBlock(lowerPos, !player.isCreative(), player);
			}
		}
		super.playerWillDestroy(level, pos, state, player);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		if (isUpper(state)) {
			return UPPER_SHAPE;
		}
		return this.getAge(state) >= this.tallFromAge ? LOWER_SHAPE : super.getShape(state, level, pos, context);
	}

	// ---------- 数据生成 ----------

	/** blockstate：下半格 <名>_stage<age>，上半格 <名>_top_stage<age>（age 低于 tallFromAge 时上半格不会出现，借用第一张上半格贴图） */
	public static void tallBlockstate(DataGenContext<Block, ? extends CommonTallEightStageCrop> ctx, RegistrateBlockstateProvider provider) {
		String name = ctx.getName();
		int tallFrom = ctx.get().getTallFromAge();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			int age = state.getValue(AGE);
			String path = isUpper(state)
				? "block/crop/grow/" + name + "/" + name + "_top_stage" + Math.max(age, tallFrom)
				: "block/crop/grow/" + name + "/" + name + "_stage" + age;
			return ConfiguredModel.builder()
				.modelFile(provider.models().cross(path, provider.modLoc(path)).renderType("cutout"))
				.build();
		});
	}

	/** 掉落（只在下半格，同红叶卷心菜）：成熟掉产物，否则掉种子；成熟时额外按时运掉种子 */
	public static void tallLoot(RegistrateBlockLootTables lt, CommonTallEightStageCrop block) {
		ItemLike seed = block.asItem();
		LootItemBlockStatePropertyCondition.Builder lower = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
			.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HALF, DoubleBlockHalf.LOWER));
		LootItemBlockStatePropertyCondition.Builder matureLower = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
			.setProperties(StatePropertiesPredicate.Builder.properties()
				.hasProperty(HALF, DoubleBlockHalf.LOWER)
				.hasProperty(AGE, MAX_AGE));
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().when(lower).add(AlternativesEntry.alternatives(
				LootItem.lootTableItem(block.getProduce()).when(matureLower),
				LootItem.lootTableItem(seed))))
			.withPool(LootPool.lootPool().when(matureLower)
				.add(LootItem.lootTableItem(seed)
					.apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
