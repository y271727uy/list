package com.list.block.mushroom;

import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.item.context.BlockPlaceContext;
import java.util.Random;

public class SeaMushroomBlock extends MushroomBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SeaMushroomBlock(Properties properties) {
        super(properties, null);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }
    
    // 添加检查是否可以存活的方法，只允许在水中存活
    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        // 检查方块下方是否是水源方块
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);
        FluidState fluidState = level.getFluidState(pos);
        
        // 必须在水中且下方有固体方块支撑
        return fluidState.getType() == Fluids.WATER && belowState.isSolidRender(level, belowPos);
    }
    
    // 无视光线条件生长
    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return true; // 总是可以使用骨粉
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
    
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
    }
    
    // 移除了 @Override 注解，因为这个方法可能不是从父类继承的可重写方法
    public boolean growMushroom(ServerLevel level, BlockPos pos, BlockState state, Random random) {
        // 禁用自然生长
        return false;
    }
}