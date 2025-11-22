package com.list.block;

import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class StrawMushroomBlock extends BushBlock {

    public StrawMushroomBlock(Properties properties) {
        super(properties
            .strength(0.0F)
            .sound(SoundType.GRASS)
            .noCollission()
            .instabreak()
            .lightLevel(state -> 0)
            .noOcclusion()
        );
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }
}