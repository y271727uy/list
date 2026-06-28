package com.list.block.crop;

import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

/**
 * Common base for fruit-bearing leaves.
 *
 * <p>Stage meanings:</p>
 * <ul>
 *   <li>{@link #NORMAL}: leaf only</li>
 *   <li>{@link #FLOWERING}: flowered leaf</li>
 *   <li>{@link #FRUITING}: fruit is ready</li>
 * </ul>
 *
 * <p>The default behavior is:</p>
 * <ul>
 *   <li>randomly tick from normal -> flowering -> fruiting</li>
 *   <li>fruiting leaves may naturally drop fruit back to normal</li>
 *   <li>right click on fruiting leaves harvests the fruit and resets to normal</li>
 * </ul>
 */
public abstract class CommonFruitLeaves extends LeavesBlock {

    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 2);
    public static final int NORMAL = 0;
    public static final int FLOWERING = 1;
    public static final int FRUITING = 2;

    protected CommonFruitLeaves(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any().setValue(STAGE, NORMAL));
    }

    protected abstract Supplier<? extends Item> getFruitItem();

    protected int getMinStage() {
        return NORMAL;
    }

    protected int getMaxStage() {
        return FRUITING;
    }

    protected int getDefaultStage() {
        return NORMAL;
    }

    protected float getFlowerChance(Level level, BlockPos pos, BlockState state, RandomSource random) {
        return 0.03F;
    }

    protected float getFruitChance(Level level, BlockPos pos, BlockState state, RandomSource random) {
        return 0.02F;
    }

    protected float getNaturalDropChance(Level level, BlockPos pos, BlockState state, RandomSource random) {
        return 0.01F;
    }

    protected boolean canHarvest(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return getStage(state) == FRUITING;
    }

    protected void onHarvest(BlockState oldState, BlockState newState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
    }

    public final int clampStage(int stage) {
        return Math.max(getMinStage(), Math.min(getMaxStage(), stage));
    }

    public final int nextStage(int stage) {
        return stage >= getMaxStage() ? getMinStage() : stage + 1;
    }

    public final int getStage(BlockState state) {
        return state.getValue(STAGE);
    }

    public final BlockState withStage(BlockState state, int stage) {
        return state.setValue(STAGE, clampStage(stage));
    }

    public final BlockState getStateForStage(int stage) {
        return defaultBlockState().setValue(STAGE, clampStage(stage));
    }

    public final BlockState cycleStage(BlockState state) {
        return withStage(state, nextStage(getStage(state)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STAGE);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT) && (state.getValue(STAGE) != NORMAL || super.isRandomlyTicking(state));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(PERSISTENT)) {
            super.randomTick(state, level, pos, random);
            return;
        }

        if (!decaying(state)) {
            int stage = state.getValue(STAGE);
            if (stage == NORMAL) {
                if (random.nextFloat() < getFlowerChance(level, pos, state, random)) {
                    level.setBlockAndUpdate(pos, state.setValue(STAGE, FLOWERING));
                    return;
                }
            } else if (stage == FLOWERING) {
                if (random.nextFloat() < getFruitChance(level, pos, state, random)) {
                    level.setBlockAndUpdate(pos, state.setValue(STAGE, FRUITING));
                    return;
                }
            } else if (stage == FRUITING) {
                if (random.nextFloat() < getNaturalDropChance(level, pos, state, random)) {
                    dropFruit(level, pos, state);
                    return;
                }
            }
        }

        super.randomTick(state, level, pos, random);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!canHarvest(state, level, pos, player, hand, hit)) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide) {
            BlockState newState = state.setValue(STAGE, NORMAL);
            giveFruit(level, pos, player);
            level.setBlock(pos, newState, Block.UPDATE_ALL);
            onHarvest(state, newState, level, pos, player, hand, hit);
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    protected void dropFruit(ServerLevel level, BlockPos pos, BlockState state) {
        popResource(level, pos, new ItemStack(getFruitItem().get()));
        level.setBlock(pos, state.setValue(STAGE, NORMAL), Block.UPDATE_ALL);
    }

    protected void giveFruit(Level level, BlockPos pos, Player player) {
        ItemStack fruitStack = new ItemStack(getFruitItem().get());
        if (!player.addItem(fruitStack)) {
            popResource(level, pos, fruitStack);
        }
    }

    protected String getStageName(int stage) {
        return switch (clampStage(stage)) {
            case FLOWERING -> "flowering";
            case FRUITING -> "fruiting";
            default -> "normal";
        };
    }

    protected ConfiguredModel[] buildModel(RegistrateBlockstateProvider provider, String name, BlockState state) {
        String modelName = name + "_" + getStageName(state.getValue(STAGE));
        return ConfiguredModel.builder()
                .modelFile(provider.models().withExistingParent(modelName, "block/leaves")
                        .texture("all", "block/" + modelName))
                .build();
    }

    public void buildLeavesModel(DataGenContext<Block, ? extends CommonFruitLeaves> ctx, RegistrateBlockstateProvider provider, String name) {
        provider.getVariantBuilder(ctx.get())
                .forAllStatesExcept(state -> buildModel(provider, name, state),
                        LeavesBlock.DISTANCE, LeavesBlock.PERSISTENT, LeavesBlock.WATERLOGGED);
    }

    public void buildLoot(RegistrateBlockLootTables provider, Block block, Block sapling) {
        Item fruit = getFruitItem().get();
        var leaves = LootItem.lootTableItem(block)
                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))).or(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(Tags.Items.SHEARS))));
        var fruits = LootItem.lootTableItem(fruit)
                .when(LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(block)
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(STAGE, FRUITING)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 1));
        var saplings = LootItem.lootTableItem(sapling)
                .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                        1 / 20f, 1 / 16f, 1 / 12f, 1 / 10f));
        var drops = AlternativesEntry.alternatives(leaves, fruits, saplings);
        provider.add(block, LootTable.lootTable().withPool(LootPool.lootPool()
                .add(drops)
                .when(ExplosionCondition.survivesExplosion())));
    }
}
