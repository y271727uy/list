package com.list.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShapeUtil {

    public static VoxelShape buildShapeForFacing(int rotations, double[][] boxes) {
        VoxelShape shape = Shapes.empty();
        for (double[] box : boxes) {
            double[] rotated = rotateBox(box[0], box[1], box[2], box[3], box[4], box[5], rotations);
            shape = Shapes.or(shape, Block.box(rotated[0], rotated[1], rotated[2], rotated[3], rotated[4], rotated[5]));
        }
        return shape;
    }

    public static double[] rotateBox(double x1, double y1, double z1, double x2, double y2, double z2, int turns) {
        turns = ((turns % 4) + 4) % 4;
        double nx1 = x1;
        double nz1 = z1;
        double nx2 = x2;
        double nz2 = z2;
        switch (turns) {
            case 1 -> {
                nx1 = 16.0D - z2;
                nx2 = 16.0D - z1;
                nz1 = x1;
                nz2 = x2;
            }
            case 2 -> {
                nx1 = 16.0D - x2;
                nx2 = 16.0D - x1;
                nz1 = 16.0D - z2;
                nz2 = 16.0D - z1;
            }
            case 3 -> {
                nx1 = z1;
                nx2 = z2;
                nz1 = 16.0D - x2;
                nz2 = 16.0D - x1;
            }
        }
        return new double[]{nx1, y1, nz1, nx2, y2, nz2};
    }
}
