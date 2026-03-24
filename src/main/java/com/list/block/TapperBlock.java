package com.list.block;

import com.list.all.ModBlockEntities;
import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class TapperBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public TapperBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    // Boxes derived from Blockbench model (from/to coordinates). We'll build the full shape by OR'ing these boxes.
    // If any box has zero thickness on an axis (from==to), add a tiny epsilon to ensure a valid AABB.
    private static final double EPS = 0.01D;
    private static final double[][] BOXES = new double[][]{
            {4.0, 0.0, 7.0, 12.0, 3.0, 15.0},
            {12.0, 0.0, 6.0, 13.0, 12.0, 16.0},
            {3.0, 0.0, 6.0, 4.0, 12.0, 16.0},
            {4.0, 0.0, 15.0, 12.0, 12.0, 16.0},
            {4.0, 0.0, 6.0, 12.0, 12.0, 7.0},
            {7.0, 13.0, 9.0, 9.0, 14.0, 11.0},
            {7.0, 14.0, 9.0, 9.0, 16.0, 16.0},
            {3.5, 12.0, 11.0, 3.5, 16.0, 13.0},
            {3.5, 16.02, 11.0, 12.5, 16.02, 13.0},
            {12.5, 12.0, 11.0, 12.5, 16.0, 13.0},
            {6.0, 13.0, 15.0, 10.0, 17.0, 16.0},
            {6.5, 16.01, 8.0, 9.5, 16.01, 11.0}
    };

    private static VoxelShape buildShapeForFacing(int k) {
        VoxelShape out = Shapes.empty();
        for (double[] b : BOXES) {
            double x1 = b[0], y1 = b[1], z1 = b[2], x2 = b[3], y2 = b[4], z2 = b[5];
            // ensure non-zero thickness
            if (Math.abs(x2 - x1) < 1e-6) x2 = x1 + EPS;
            if (Math.abs(y2 - y1) < 1e-6) y2 = y1 + EPS;
            if (Math.abs(z2 - z1) < 1e-6) z2 = z1 + EPS;
            double[] r = rotateBox(x1, y1, z1, x2, y2, z2, k);
            out = Shapes.or(out, Block.box(r[0], r[1], r[2], r[3], r[4], r[5]));
        }
        return out;
    }

    private static final VoxelShape SHAPE_NORTH = buildShapeForFacing(0);
    private static final VoxelShape SHAPE_EAST = buildShapeForFacing(1);
    private static final VoxelShape SHAPE_SOUTH = buildShapeForFacing(2);
    private static final VoxelShape SHAPE_WEST = buildShapeForFacing(3);

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new com.list.block.entity.TapperBlockEntity(ModBlockEntities.TAPPER.get(), pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof com.list.block.entity.TapperBlockEntity) {
            // no GUI for now
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    @SuppressWarnings("deprecation")
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> SHAPE_NORTH;
            case EAST -> SHAPE_EAST;
            case SOUTH -> SHAPE_SOUTH;
            case WEST -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    // rotateY removed — we build per-facing shapes directly from BOXES

    // rotate a single AABB by k*90 degrees clockwise around center (8, *, 8)
    private static double[] rotateBox(double x1, double y1, double z1, double x2, double y2, double z2, int k) {
        k = ((k % 4) + 4) % 4;
        double nx1 = x1, nz1 = z1, nx2 = x2, nz2 = z2;
        switch (k) {
            case 0:
                // no change
                break;
            case 1:
                // 90 deg: newX = 16 - z2; newZ = x1
                nx1 = 16.0D - z2;
                nx2 = 16.0D - z1;
                nz1 = x1;
                nz2 = x2;
                break;
            case 2:
                // 180 deg
                nx1 = 16.0D - x2;
                nx2 = 16.0D - x1;
                nz1 = 16.0D - z2;
                nz2 = 16.0D - z1;
                break;
            case 3:
                // 270 deg
                nx1 = z1;
                nx2 = z2;
                nz1 = 16.0D - x2;
                nz2 = 16.0D - x1;
                break;
        }
        return new double[]{nx1, y1, nz1, nx2, y2, nz2};
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide) {
            return null;
        }
        return createTickerHelper(
                blockEntityType,
                ModBlockEntities.TAPPER.get(),
                (l, p, s, be) -> be.tick(l, p, s)
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
}










