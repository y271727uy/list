package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
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
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

import java.util.function.Supplier;

/**
 * 双层的可重复采摘六阶段作物（age 0~5），如上古水果。
 * 下半格是真正的作物（生长、采摘、掉落都在下半格）；长到 tallFromAge 起在上方补一个上半格，两格 age 同步。
 * 采摘回退到 tallFromAge 以下时上半格会被移除；上方被挡住时不会长到 tallFromAge。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~5，16x32（下半格取下半张，上半格取上半张）。
 */
public class CommonTallRegrowCrop extends CommonSixStageRegrowCrop {

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
	private static final VoxelShape UPPER_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D);

	private final int tallFromAge;

	/** @param tallFromAge 从这个 age 起变成两格高 */
	public CommonTallRegrowCrop(Properties properties, Supplier<? extends ItemLike> produce, int harvestResetAge, int tallFromAge) {
		super(properties, produce, harvestResetAge);
		this.tallFromAge = tallFromAge;
		this.registerDefaultState(this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER));
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

	/** 按下半格的 age 补上 / 同步 / 移除上半格 */
	private void syncUpper(Level level, BlockPos lowerPos) {
		BlockState lower = level.getBlockState(lowerPos);
		if (!lower.is(this) || isUpper(lower)) {
			return;
		}
		BlockPos upperPos = lowerPos.above();
		BlockState above = level.getBlockState(upperPos);
		boolean hasUpper = above.is(this) && isUpper(above);
		int age = this.getAge(lower);
		if (age >= this.tallFromAge) {
			if (hasUpper || above.isAir()) {
				level.setBlock(upperPos, lower.setValue(HALF, DoubleBlockHalf.UPPER), Block.UPDATE_ALL);
			}
		} else if (hasUpper) {
			level.setBlock(upperPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
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

	/** 点上半格也算点下半格；采摘后同步上半格 */
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		BlockPos lowerPos = isUpper(state) ? pos.below() : pos;
		BlockState lower = level.getBlockState(lowerPos);
		if (!lower.is(this)) {
			return InteractionResult.PASS;
		}
		InteractionResult result = super.use(lower, level, lowerPos, player, hand, hit);
		if (!level.isClientSide && result.consumesAction()) {
			this.syncUpper(level, lowerPos);
		}
		return result;
	}

	@Override
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		if (isUpper(state)) {
			BlockState below = level.getBlockState(pos.below());
			return below.is(this) && !isUpper(below);
		}
		return super.canSurvive(state, level, pos);
	}

	/** 两格互相依存：下半格没了上半格消失；上半格被破坏时连带破坏下半格（由下半格掉落） */
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
		if (isUpper(state) && facing == Direction.DOWN && !(facingState.is(this) && !isUpper(facingState))) {
			return Blocks.AIR.defaultBlockState();
		}
		return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
	}

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
		return isUpper(state) ? UPPER_SHAPE : super.getShape(state, level, pos, context);
	}

	// ---------- 数据生成 ----------

	/** blockstate：下半格 / 上半格分别套 tall_cross_lower / tall_cross_upper 模板，共用同一张 16x32 贴图 */
	public static void tallBlockstate(DataGenContext<Block, ? extends CommonTallRegrowCrop> ctx, RegistrateBlockstateProvider provider) {
		String name = ctx.getName();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			boolean upper = isUpper(state);
			String texture = "block/crop/grow/" + name + "/" + name + "_stage" + state.getValue(AGE_5);
			ModelFile model = provider.models()
				.withExistingParent(texture + (upper ? "_upper" : "_lower"), provider.modLoc(upper ? "block/crop/tall_cross_upper" : "block/crop/tall_cross_lower"))
				.texture("cross", provider.modLoc(texture))
				.renderType("cutout");
			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	/** 掉落（只在下半格）：始终掉 1 个种子；成熟时额外掉 1~2 个产物 */
	public static void tallLoot(RegistrateBlockLootTables lt, CommonTallRegrowCrop block) {
		LootItemBlockStatePropertyCondition.Builder lower = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
			.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HALF, DoubleBlockHalf.LOWER));
		LootItemBlockStatePropertyCondition.Builder matureLower = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
			.setProperties(StatePropertiesPredicate.Builder.properties()
				.hasProperty(HALF, DoubleBlockHalf.LOWER)
				.hasProperty(AGE_5, SIX_STAGE_MAX_AGE));
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().when(lower).add(LootItem.lootTableItem(block.asItem())))
			.withPool(LootPool.lootPool().when(matureLower)
				.add(LootItem.lootTableItem(block.getProduce())
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
