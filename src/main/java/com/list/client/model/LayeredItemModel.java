package com.list.client.model;

import com.list.ListMod;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.geometry.IGeometryBakingContext;
import net.minecraftforge.client.model.geometry.IGeometryLoader;
import net.minecraftforge.client.model.geometry.IUnbakedGeometry;
import net.minecraftforge.client.model.generators.CustomLoaderBuilder;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.util.function.Function;

/**
 * 双层图层覆盖模型 (A + B 模式)
 * <p>
 * 基础模型A + 覆盖层模型B，B覆盖在A之上，支持每层独立调色。
 * 参考GTM的 CustomItemRendererWrapperModel 和 TextureOverrideModel 实现。
 * <p>
 * JSON结构:
 * <pre>
 * {
 *   "loader": "list:layered_item",
 *   "base_model": { ... },       // 基础层A (BlockModel)
 *   "overlay_model": { ... }     // 覆盖层B (BlockModel)
 * }
 * </pre>
 * <p>
 * 数据生成用法:
 * <pre>
 * provider.getBuilder("my_item")
 *     .customLoader(LayeredModelBuilder::begin)
 *     .baseModel(provider.getBuilder("base").parent(...).texture(...))
 *     .overlayModel(provider.getBuilder("overlay").parent(...).texture(...))
 *     .end()
 * </pre>
 */
public class LayeredItemModel implements IUnbakedGeometry<LayeredItemModel> {

    public static final ResourceLocation ID = ListMod.rl("layered_item");

    private final BlockModel baseModel;
    private final BlockModel overlayModel;

    public LayeredItemModel(BlockModel baseModel, BlockModel overlayModel) {
        this.baseModel = baseModel;
        this.overlayModel = overlayModel;
    }

    @Override
    public BakedModel bake(IGeometryBakingContext context, ModelBaker baker,
                           Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelState,
                           ItemOverrides overrides, ResourceLocation modelLocation) {
        // 烘焙基础模型A
        BakedModel bakedBase = baseModel.bake(baker, baseModel, spriteGetter, modelState, modelLocation, context.isGui3d());
        // 烘焙覆盖层模型B
        BakedModel bakedOverlay = overlayModel.bake(baker, overlayModel, spriteGetter, modelState, modelLocation, context.isGui3d());

        return new LayeredBakedModel(bakedBase, bakedOverlay);
    }

    @Override
    public void resolveParents(Function<ResourceLocation, UnbakedModel> modelGetter, IGeometryBakingContext context) {
        baseModel.resolveParents(modelGetter);
        overlayModel.resolveParents(modelGetter);
    }

    // ======== JSON Loader ========

    public static final class Loader implements IGeometryLoader<LayeredItemModel> {

        public static final Loader INSTANCE = new Loader();

        private Loader() {}

        @Override
        public LayeredItemModel read(JsonObject json, JsonDeserializationContext context) throws JsonParseException {
            JsonObject baseJson = json.getAsJsonObject("base_model");
            JsonObject overlayJson = json.getAsJsonObject("overlay_model");

            if (baseJson == null) {
                throw new JsonParseException("Missing 'base_model' in layered_item model");
            }
            if (overlayJson == null) {
                throw new JsonParseException("Missing 'overlay_model' in layered_item model");
            }

            BlockModel baseModel = context.deserialize(baseJson, BlockModel.class);
            BlockModel overlayModel = context.deserialize(overlayJson, BlockModel.class);

            return new LayeredItemModel(baseModel, overlayModel);
        }
    }

    // ======== DataGen Builder ========

    public static final class Builder<T extends ModelBuilder<T>> extends CustomLoaderBuilder<T> {

        private ModelBuilder<?> baseModel;
        private ModelBuilder<?> overlayModel;

        public Builder(T parent, ExistingFileHelper existingFileHelper) {
            super(ID, parent, existingFileHelper);
        }

        public static <T extends ModelBuilder<T>> Builder<T> begin(T parent, ExistingFileHelper existingFileHelper) {
            return new Builder<>(parent, existingFileHelper);
        }

        public Builder<T> baseModel(ModelBuilder<?> model) {
            this.baseModel = model;
            return this;
        }

        public Builder<T> overlayModel(ModelBuilder<?> model) {
            this.overlayModel = model;
            return this;
        }

        @Override
        public JsonObject toJson(JsonObject json) {
            json = super.toJson(json);
            if (baseModel != null) {
                json.add("base_model", baseModel.toJson());
            }
            if (overlayModel != null) {
                json.add("overlay_model", overlayModel.toJson());
            }
            return json;
        }
    }
}
