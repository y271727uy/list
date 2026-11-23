package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraftforge.client.model.generators.ConfiguredModel;

import java.util.function.Supplier;

/**
 * 通用八阶段作物（沿用原版 CropBlock 的 AGE_7），种子与产物分开，多个作物共用这一个类。
 * 种子 = 方块自带的物品（asItem），产物通过构造参数传入。
 * 贴图：block/crop/grow/<注册名>/<注册名>_stage0~7
 * 种植判定沿用 Forge IPlantable（PlantType.CROP）。
 */
public class CommonEightStageCrop extends CommonPlantCrop {

	private final Supplier<? extends ItemLike> produce;

	public CommonEightStageCrop(Properties properties, Supplier<? extends ItemLike> produce) {
		super(properties);
		this.produce = produce;
	}

	// 种子即方块自带的物品
	@Override
	protected ItemLike getBaseSeedId() {
		return this.asItem();
	}

	protected ItemLike getProduce() {
		return this.produce.get();
	}

	// ---------- 数据生成 ----------

	/** blockstate：每个 age 生成一个 cross 模型 */
	public static void blockstate(DataGenContext<Block, ? extends CommonEightStageCrop> ctx, RegistrateBlockstateProvider provider) {
		String name = ctx.getName();
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			String path = "block/crop/grow/" + name + "/" + name + "_stage" + state.getValue(AGE);
			return ConfiguredModel.builder()
				.modelFile(provider.models().cross(path, provider.modLoc(path)).renderType("cutout"))
				.build();
		});
	}

	/** 掉落（同农夫乐事卷心菜）：成熟掉产物，否则掉种子；成熟时额外按时运掉种子 */
	public static void loot(RegistrateBlockLootTables lt, CommonEightStageCrop block) {
		ItemLike seed = block.asItem();
		LootItemBlockStatePropertyCondition.Builder mature = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
			.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(AGE, MAX_AGE));
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().add(AlternativesEntry.alternatives(
				LootItem.lootTableItem(block.produce.get()).when(mature),
				LootItem.lootTableItem(seed))))
			.withPool(LootPool.lootPool().when(mature)
				.add(LootItem.lootTableItem(seed)
					.apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
