package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.PlantType;

import java.util.function.Supplier;

/**
 * 种在沙子上的五阶段作物（age 0~4），如菠萝。多个作物共用这一个类。
 * 种植判定沿用 Forge IPlantable：PlantType.DESERT 由沙子（含红沙）的 canSustainPlant 放行。
 * 种苗 = 方块自带的物品（贴图即 stage0）；产物通过构造参数传入。一次性收获。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~4
 */
public class CommonDesertCrop extends CommonPlantCrop {

	public static final int MAX_AGE = 4;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
		Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D),
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 6.0D, 13.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D)
	};

	private final Supplier<? extends ItemLike> produce;

	public CommonDesertCrop(Properties properties, Supplier<? extends ItemLike> produce) {
		super(properties);
		this.produce = produce;
	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.DESERT;
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	// 种苗即方块自带的物品
	@Override
	protected ItemLike getBaseSeedId() {
		return this.asItem();
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

	/** blockstate：每个 age 生成一个 cross 模型 */
	public static void blockstate(DataGenContext<Block, ? extends CommonDesertCrop> ctx, RegistrateBlockstateProvider provider) {
		String name = ctx.getName();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			String path = "block/crop/grow/" + name + "/" + name + "_stage" + state.getValue(AGE);
			return ConfiguredModel.builder()
				.modelFile(provider.models().cross(path, provider.modLoc(path)).renderType("cutout"))
				.build();
		});
	}

	/** 掉落：始终掉 1 个种苗（可重新种植）；成熟时额外掉 1 个产物 */
	public static void loot(RegistrateBlockLootTables lt, CommonDesertCrop block) {
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())))
			.withPool(LootPool.lootPool()
				.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
					.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AGE, MAX_AGE)))
				.add(LootItem.lootTableItem(block.produce.get())))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
