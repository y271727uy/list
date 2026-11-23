package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * 通用四阶段作物（age 0~3），多个作物共用这一个类。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~3
 * 种植判定沿用 Forge IPlantable：PlantType.CROP 由 FarmBlock#canSustainPlant 放行，无需自行判断耕地。
 */
public class CommonFourStageCrop extends CommonPlantCrop {

	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D),
		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
		Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)
	};

	// 产物；为 null 时产物即种子（如红洋葱），否则种子与产物分开（如豌豆 -> 豌豆荚）
	@Nullable
	private final Supplier<? extends ItemLike> produce;

	public CommonFourStageCrop(Properties properties) {
		this(properties, null);
	}

	public CommonFourStageCrop(Properties properties, @Nullable Supplier<? extends ItemLike> produce) {
		super(properties);
		this.produce = produce;
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	// 种子/产物即方块自带的物品
	@Override
	protected ItemLike getBaseSeedId() {
		return this.asItem();
	}

	// 原版是 2~5（对应 8 阶段），四阶段按比例减为 1~2
	@Override
	protected int getBonemealAgeIncrease(Level level) {
		return Mth.nextInt(level.random, 1, 2);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

	// ---------- 数据生成 ----------

	/** blockstate：每个 age 生成一个 crop 模型（井字，同原版胡萝卜） */
	public static void blockstate(DataGenContext<Block, ? extends CommonFourStageCrop> ctx, RegistrateBlockstateProvider provider) {
		stageBlockstate(ctx, provider, false);
	}

	/** blockstate：每个 age 生成一个 cross 模型（十字，同原版树苗） */
	public static void crossBlockstate(DataGenContext<Block, ? extends CommonFourStageCrop> ctx, RegistrateBlockstateProvider provider) {
		stageBlockstate(ctx, provider, true);
	}

	private static void stageBlockstate(DataGenContext<Block, ? extends CommonFourStageCrop> ctx, RegistrateBlockstateProvider provider, boolean cross) {
		String name = ctx.getName();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			String path = "block/crop/grow/" + name + "/" + name + "_stage" + state.getValue(AGE);
			return ConfiguredModel.builder()
				.modelFile((cross
					? provider.models().cross(path, provider.modLoc(path))
					: provider.models().crop(path, provider.modLoc(path))).renderType("cutout"))
				.build();
		});
	}

	/**
	 * 掉落：
	 * 产物即种子：任意阶段掉 1 个；成熟时额外按时运掉落（同原版胡萝卜）
	 * 种子与产物分开：成熟掉产物，否则掉种子；成熟时额外按时运掉种子（同原版小麦）
	 */
	public static void loot(RegistrateBlockLootTables lt, CommonFourStageCrop block) {
		ItemLike seed = block.getBaseSeedId();
		LootItemBlockStatePropertyCondition.Builder mature = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
			.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AGE, MAX_AGE));
		LootPool.Builder first = block.produce == null
			? LootPool.lootPool().add(LootItem.lootTableItem(seed))
			: LootPool.lootPool().add(AlternativesEntry.alternatives(
				LootItem.lootTableItem(block.produce.get()).when(mature),
				LootItem.lootTableItem(seed)));
		lt.add(block, LootTable.lootTable()
			.withPool(first)
			.withPool(LootPool.lootPool().when(mature)
				.add(LootItem.lootTableItem(seed)
					.apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
