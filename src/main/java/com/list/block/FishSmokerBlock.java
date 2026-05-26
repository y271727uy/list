package com.list.block;

import com.list.all.ModBlockEntities;
import com.list.all.ModMenus;
import com.list.block.entity.FishSmokerBlockEntity;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SmokerBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class FishSmokerBlock extends SmokerBlock {

    public FishSmokerBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new com.list.block.entity.FishSmokerBlockEntity(ModBlockEntities.FISH_SMOKER.get(), pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> net.minecraft.world.level.block.entity.BlockEntityTicker<T> getTicker(
            net.minecraft.world.level.Level level,
            BlockState state,
            BlockEntityType<T> blockEntityType
    ) {
        return createFurnaceTicker(level, blockEntityType, ModBlockEntities.FISH_SMOKER.get());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }
        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof FishSmokerBlockEntity fishSmokerBlockEntity && player instanceof ServerPlayer serverPlayer) {
            ModMenus.open(serverPlayer, fishSmokerBlockEntity, pos);
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }
}


