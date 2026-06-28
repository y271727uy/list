package com.list.block;

import com.list.block.common.CommonPlushieBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static com.list.util.ShapeUtil.buildShapeForFacing;

public class PigPlushieBlock extends CommonPlushieBlock {

    private static final double[][] BOXES = new double[][]{
            {4.5, 0, 4.0, 6.5, 2.0, 6.0},
            {9.5, 0, 4.0, 11.5, 2.0, 6.0},
            {4.5, 0, 11.0, 6.5, 2.0, 13.0},
            {9.5, 0, 11.0, 11.5, 2.0, 13.0},
            {4.0, 2.0, 2.0, 12.0, 10.0, 15.0},
            {6.0, 3.0, 1.0, 10.0, 6.0, 2.0}
    };

    private static final VoxelShape SHAPE_NORTH = buildShapeForFacing(0, BOXES);
    private static final VoxelShape SHAPE_EAST = buildShapeForFacing(1, BOXES);
    private static final VoxelShape SHAPE_SOUTH = buildShapeForFacing(2, BOXES);
    private static final VoxelShape SHAPE_WEST = buildShapeForFacing(3, BOXES);

    public PigPlushieBlock(Properties properties) {
        super(properties);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }
}
