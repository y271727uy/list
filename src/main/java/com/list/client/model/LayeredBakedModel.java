package com.list.client.model;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraftforge.client.ChunkRenderTypeSet;
import net.minecraftforge.client.model.data.ModelData;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * 烘焙后的双层图层覆盖模型
 * <p>
 * 基础模型A (layer0, tintIndex=0) + 覆盖层模型B (layer0, tintIndex手动改为1)。
 * 覆盖层B的quad追加在A之后，实现B覆盖在A之上的效果。
 */
public class LayeredBakedModel extends BakedModelWrapper<BakedModel> {

    private static final int OVERLAY_TINT_INDEX = 1;
    private static final float OVERLAY_Z_OFFSET = 0.002F;

    private final BakedModel baseModel;
    private final BakedModel overlayModel;

    public LayeredBakedModel(BakedModel baseModel, BakedModel overlayModel) {
        super(baseModel);
        this.baseModel = baseModel;
        this.overlayModel = overlayModel;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side,
                                     RandomSource rand, ModelData extraData,
                                     @Nullable RenderType renderType) {
        List<BakedQuad> quads = new ArrayList<>(super.getQuads(state, side, rand, extraData, renderType));
        List<BakedQuad> overlayQuads = new ArrayList<>(overlayModel.getQuads(state, side, rand, extraData, renderType));
        for (BakedQuad quad : overlayQuads) {
            quads.add(remapTintIndex(quad, OVERLAY_TINT_INDEX));
        }
        return quads;
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, RandomSource rand) {
        List<BakedQuad> quads = new ArrayList<>(super.getQuads(state, side, rand));
        List<BakedQuad> overlayQuads = new ArrayList<>(overlayModel.getQuads(state, side, rand));
        for (BakedQuad quad : overlayQuads) {
            quads.add(remapTintIndex(quad, OVERLAY_TINT_INDEX));
        }
        return quads;
    }

    @Override
    public ChunkRenderTypeSet getRenderTypes(BlockState state, RandomSource rand, ModelData modelData) {
        return ChunkRenderTypeSet.union(
                baseModel.getRenderTypes(state, rand, modelData),
                overlayModel.getRenderTypes(state, rand, modelData)
        );
    }

    /**
     * 重新构造BakedQuad，将tintIndex改为指定值。
     * tintIndex是BakedQuad的独立字段，与vertex数据无关。
     */
    private static BakedQuad remapTintIndex(BakedQuad quad, int newTintIndex) {
        int[] vertices = quad.getVertices().clone();
        offsetQuadVertices(vertices, OVERLAY_Z_OFFSET);
        return new BakedQuad(vertices, newTintIndex, quad.getDirection(), quad.getSprite(), quad.isShade());
    }

    private static void offsetQuadVertices(int[] vertices, float zOffset) {
        for (int i = 0; i < 4; i++) {
            int vertex = i * 8;
            float z = Float.intBitsToFloat(vertices[vertex + 2]);
            vertices[vertex + 2] = Float.floatToRawIntBits(z + zOffset);
        }
    }

    @Override
    public TextureAtlasSprite getParticleIcon() {
        return baseModel.getParticleIcon();
    }

    public BakedModel getBaseModel() {
        return baseModel;
    }

    public BakedModel getOverlayModel() {
        return overlayModel;
    }
}
