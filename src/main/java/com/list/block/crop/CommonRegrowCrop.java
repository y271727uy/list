package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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

import java.util.function.Supplier;

/**
 * 可重复采摘的七阶段作物（age 0~6），如草莓。多个作物共用这一个类。
 * 成熟后右键采摘产物，回退到 harvestResetAge（默认 age 1）继续生长。
 * 其他阶段数见子类（如 CommonSixStageRegrowCrop）。
 * 种子 = 方块自带的物品（asItem），产物通过构造参数传入。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~6
 * 种植判定沿用 Forge IPlantable（PlantType.CROP）。
 */
public class CommonRegrowCrop extends CommonPlantCrop {

	public static final int MAX_AGE = 6;
	public static final int HARVEST_RESET_AGE = 1;
	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D),
		Block.box(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 5.0D, 14.0D),
		Block.box(2.0D, 0.0D, 2.0D, 14.0D, 6.0D, 14.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 7.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 8.0D, 15.0D),
		Block.box(1.0D, 0.0D, 1.0D, 15.0D, 9.0D, 15.0D)
	};

	private final Supplier<? extends ItemLike> produce;
	private final int harvestResetAge;

	public CommonRegrowCrop(Properties properties, Supplier<? extends ItemLike> produce) {
		this(properties, produce, HARVEST_RESET_AGE);
	}

	/** @param harvestResetAge 采摘后回退到的 age */
	public CommonRegrowCrop(Properties properties, Supplier<? extends ItemLike> produce, int harvestResetAge) {
		super(properties);
		this.produce = produce;
		this.harvestResetAge = harvestResetAge;
	}

	protected ItemLike getProduce() {
		return this.produce.get();
	}

	@Override
	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	// 种子即方块自带的物品
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

	/** 成熟时右键采摘 1~2 个产物，回退到 harvestResetAge */
	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!this.isMaxAge(state)) {
			return InteractionResult.PASS;
		}
		if (!level.isClientSide) {
			popResource(level, pos, new ItemStack(this.produce.get(), 1 + level.random.nextInt(2)));
			level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
			level.setBlock(pos, this.getStateForAge(this.harvestResetAge), Block.UPDATE_CLIENTS);
		}
		return InteractionResult.sidedSuccess(level.isClientSide);
	}

	// ---------- 数据生成 ----------

	/** blockstate：每个 age 生成一个 cross 模型 */
	public static void blockstate(DataGenContext<Block, ? extends CommonRegrowCrop> ctx, RegistrateBlockstateProvider provider) {
		String name = ctx.getName();
		IntegerProperty age = ctx.get().getAgeProperty();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			String path = "block/crop/grow/" + name + "/" + name + "_stage" + state.getValue(age);
			return ConfiguredModel.builder()
				.modelFile(provider.models().cross(path, provider.modLoc(path)).renderType("cutout"))
				.build();
		});
	}

	/** 破坏掉落：始终掉 1 个种子；成熟时额外掉 1~2 个产物 */
	public static void loot(RegistrateBlockLootTables lt, CommonRegrowCrop block) {
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())))
			.withPool(LootPool.lootPool()
				.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
					.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(block.getAgeProperty(), block.getMaxAge())))
				.add(LootItem.lootTableItem(block.produce.get())
					.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
