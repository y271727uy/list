package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/**
 * 通用瓜方块：可由瓜茎结出（StemGrownBlock），带水平朝向（齐瓜四面不同）。
 * 瓜茎直接用原版 StemBlock / AttachedStemBlock，模型与染色沿用原版西瓜茎；下方静态方法为瓜茎的数据生成与染色。
 */
public class CommonMelonBlock extends StemGrownBlock {

	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	private final Supplier<? extends Block> stem;
	private final Supplier<? extends Block> attachedStem;

	public CommonMelonBlock(Properties properties, Supplier<? extends Block> stem, Supplier<? extends Block> attachedStem) {
		super(properties);
		this.stem = stem;
		this.attachedStem = attachedStem;
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public StemBlock getStem() {
		return (StemBlock) this.stem.get();
	}

	@Override
	public AttachedStemBlock getAttachedStem() {
		return (AttachedStemBlock) this.attachedStem.get();
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
	}

	@Override
	public BlockState mirror(BlockState state, Mirror mirror) {
		return state.rotate(mirror.getRotation(state.getValue(FACING)));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	// ---------- 瓜茎染色（同原版西瓜茎） ----------

	public static int stemColor(BlockState state, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos, int tintIndex) {
		int age = state.getValue(StemBlock.AGE);
		return (age * 32) << 16 | (255 - age * 8) << 8 | age * 4;
	}

	public static int attachedStemColor(BlockState state, @Nullable BlockAndTintGetter level, @Nullable BlockPos pos, int tintIndex) {
		return 0xE0C71C;
	}

	// ---------- 瓜茎数据生成（模型沿用原版西瓜茎贴图） ----------

	public static void stemBlockstate(DataGenContext<Block, ? extends StemBlock> ctx, RegistrateBlockstateProvider provider) {
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			int age = state.getValue(StemBlock.AGE);
			ModelFile model = provider.models().withExistingParent("block/crop/melon_stem_stage" + age, provider.mcLoc("block/stem_growth" + age))
				.texture("stem", provider.mcLoc("block/melon_stem"))
				.renderType("cutout");
			return ConfiguredModel.builder().modelFile(model).build();
		});
	}

	public static void attachedStemBlockstate(DataGenContext<Block, ? extends AttachedStemBlock> ctx, RegistrateBlockstateProvider provider) {
		ModelFile model = provider.models().withExistingParent("block/crop/attached_melon_stem", provider.mcLoc("block/stem_fruit"))
			.texture("stem", provider.mcLoc("block/melon_stem"))
			.texture("upperstem", provider.mcLoc("block/attached_melon_stem"))
			.renderType("cutout");
		provider.getVariantBuilder(ctx.get()).forAllStates(state -> {
			int rotation = switch (state.getValue(AttachedStemBlock.FACING)) {
				case EAST -> 180;
				case NORTH -> 90;
				case SOUTH -> 270;
				default -> 0;
			};
			return ConfiguredModel.builder().modelFile(model).rotationY(rotation).build();
		});
	}

	/** 瓜茎掉落（同原版）：按生长阶段二项分布掉 0~3 个种子 */
	public static void stemLoot(RegistrateBlockLootTables lt, StemBlock block) {
		LootItem.Builder<?> seeds = LootItem.lootTableItem(block.asItem());
		for (int age = 0; age <= StemBlock.MAX_AGE; age++) {
			seeds.apply(SetItemCountFunction.setCount(BinomialDistributionGenerator.binomial(3, (age + 1) / 15.0F))
				.when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
					.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StemBlock.AGE, age))));
		}
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().add(seeds))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}

	/** 结果瓜茎掉落（同原版）：二项分布掉 0~3 个种子 */
	public static void attachedStemLoot(RegistrateBlockLootTables lt, AttachedStemBlock block, Supplier<? extends Block> stem) {
		lt.add(block, LootTable.lootTable()
			.withPool(LootPool.lootPool().add(LootItem.lootTableItem(stem.get().asItem())
				.apply(SetItemCountFunction.setCount(BinomialDistributionGenerator.binomial(3, 0.53333336F)))))
			.apply(ApplyExplosionDecay.explosionDecay()));
	}
}
