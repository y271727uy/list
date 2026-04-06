package com.list.fish_group.client.model.entity;

import com.list.ListMod;
import com.list.fish_group.entity.FloatingDebrisEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.Entity;

@SuppressWarnings("all")
public class FloatingBooksModel<T extends Entity> extends EntityModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ListMod.rl("floating_books"), "main");

    private final ModelPart book1;
    private final ModelPart book2;
    private final ModelPart lectern;
    private final float baseYBook1;
    private final float baseYBook2;
    private final float baseYLectern;

    public FloatingBooksModel(ModelPart root) {
        this.book1 = root.getChild("book_1");
        this.book2 = root.getChild("book_2");
        this.lectern = root.getChild("lectern");
        this.baseYBook1 = this.book1.y;
        this.baseYBook2 = this.book2.y;
        this.baseYLectern = this.lectern.y;
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        PartDefinition book1 = root.addOrReplaceChild("book_1", CubeListBuilder.create(), PartPose.offset(0.0F, 30.0F, 0.0F));
        book1.addOrReplaceChild("book_1_r1",
                CubeListBuilder.create().texOffs(0, 20).addBox(-8.0F, -3.0F, -1.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, 1.0F, -19.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition book2 = root.addOrReplaceChild("book_2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 30.0F, 15.0F, 0.0F, 0.6109F, 0.0F));
        book2.addOrReplaceChild("book_2_r1",
                CubeListBuilder.create().texOffs(0, 33).addBox(-8.0F, -3.0F, -1.0F, 9.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(14.0F, 1.0F, -3.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition lectern = root.addOrReplaceChild("lectern", CubeListBuilder.create(), PartPose.offset(0.0F, 30.0F, 0.0F));
        lectern.addOrReplaceChild("lectern_r1",
                CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -4.0F, -1.0F, 16.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(7.0F, 1.0F, -1.0F, 0.0F, -0.3927F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity instanceof FloatingDebrisEntity debrisEntity) {
            float time = ageInTicks * 0.1F;
            float sideDriftX = (float) Math.sin(time * 0.45F) * 0.2F;
            float sideDriftZ = (float) Math.cos(time * 0.45F) * 0.2F;

            book1.setPos(sideDriftX, baseYBook1 + (float) Math.sin(time + 0.5F) * 0.25F, sideDriftZ);
            book2.setPos(-sideDriftX, baseYBook2 + (float) Math.sin(time + 0.3F) * 0.35F, -sideDriftZ);
            lectern.setPos(sideDriftZ, baseYLectern + (float) Math.sin(time + 0.7F) * 0.3F, -sideDriftX);

            book1.xRot = (float) Math.cos(time * 0.8F) * 0.05F;
            book2.zRot = (float) Math.sin(time * 0.7F) * 0.07F;
            lectern.xRot = (float) Math.cos(time * 0.6F) * 0.06F;

            if (debrisEntity.getHurtTime() > 0) {
                float hurtProgress = 1.0F - (debrisEntity.getHurtTime() / 10.0F);
                float offset = (float) Math.sin(hurtProgress * Math.PI * 2.0F) * 0.5F;
                float offsetX = (float) Math.sin(hurtProgress * Math.PI * 2.0F) * 0.5F;
                float offsetZ = (float) Math.cos(hurtProgress * Math.PI * 2.0F) * 0.5F;
                book1.setPos(offsetX, baseYBook1 + offset, offsetZ);
                book2.setPos(-offsetX, baseYBook2 + offset, -offsetZ);
                lectern.setPos(offsetZ, baseYLectern + offset, offsetX);
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        book1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        book2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        lectern.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}



