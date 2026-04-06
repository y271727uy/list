package com.list.fish_group.client.renderer.entity;

import com.list.ListMod;
import com.list.fish_group.client.model.entity.FloatingBooksModel;
import com.list.fish_group.entity.FloatingBooksEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.joml.Quaternionf;

public class FloatingBooksRenderer extends EntityRenderer<FloatingBooksEntity> {
    private static final ResourceLocation TEXTURE = ListMod.rl("textures/entity/floating_books.png");
    private final FloatingBooksModel<FloatingBooksEntity> model;

    public FloatingBooksRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new FloatingBooksModel<>(context.bakeLayer(FloatingBooksModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(FloatingBooksEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FloatingBooksEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        Quaternionf rotation = new Quaternionf().rotateY((float) Math.toRadians(entity.getRandomRotation()));
        poseStack.last().pose().rotate(rotation);
        float ageInTicks = entity.tickCount + partialTicks;
        model.setupAnim(entity, 0.0f, 0.0f, ageInTicks, entityYaw, 0.0f);
        int overlay = entity.getHurtTime() > 0 ? OverlayTexture.RED_OVERLAY_V : OverlayTexture.NO_OVERLAY;
        model.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityTranslucent(TEXTURE)), packedLight, overlay, 1.0f, 1.0f, 1.0f, 1.0f);
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}

