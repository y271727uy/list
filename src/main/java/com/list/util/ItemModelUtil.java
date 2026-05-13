package com.list.util;

import com.list.ListMod;
import com.list.client.model.LayeredItemModel;
import com.list.item.EggItem;
import com.list.item.JellyItem;
import com.list.item.LayeredItem;
import com.list.item.MooncakeItem;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;

public class ItemModelUtil {
    public static final ResourceLocation TEMPLATE_EGG = ListMod.rl("item/template_egg");
    public static final ResourceLocation TEMPLATE_LAYERED_BASE = ListMod.rl("item/template_layered_base");
    public static final ResourceLocation TEMPLATE_LAYERED_OVERLAY = ListMod.rl("item/template_layered_overlay");

    public static void eggItemModel(DataGenContext<Item, EggItem> ctx, RegistrateItemModelProvider provider) {
        provider.getBuilder(provider.name(ctx::get)).parent(new ModelFile.UncheckedModelFile(TEMPLATE_EGG));
    }

    /**
     * 为双层图层物品生成模型 (A + B 模式)
     * <p>
     * 基础层A和覆盖层B都使用各自模型里的 layer0 纹理，
     * 由 LayeredItemModel / LayeredBakedModel 在运行时合并并区分 tintIndex。
     *
     * @param baseTexture    基础层A纹理路径 (如 "item/my_item_base")
     * @param overlayTexture 覆盖层B纹理路径 (如 "item/my_item_overlay")
     */
    public static void layeredItemModel(DataGenContext<Item, LayeredItem> ctx, RegistrateItemModelProvider provider,
                                         String baseTexture, String overlayTexture) {
        var baseModel = provider.getBuilder(provider.name(ctx::get) + "_base")
                .parent(new ModelFile.UncheckedModelFile(TEMPLATE_LAYERED_BASE))
                .texture("layer0", baseTexture);

        var overlayModel = provider.getBuilder(provider.name(ctx::get) + "_overlay")
                .parent(new ModelFile.UncheckedModelFile(TEMPLATE_LAYERED_OVERLAY))
                .texture("layer0", overlayTexture);

        provider.getBuilder(provider.name(ctx::get))
                .customLoader(LayeredItemModel.Builder::begin)
                .baseModel(baseModel)
                .overlayModel(overlayModel)
                .end();
    }

    /**
     * 简化版：自动根据物品名称生成纹理路径
     * 基础层: item/{name}_base, 覆盖层: item/{name}_overlay
     */
    public static void layeredItemModel(DataGenContext<Item, LayeredItem> ctx, RegistrateItemModelProvider provider) {
        String name = provider.name(ctx::get);
        layeredItemModel(ctx, provider,
                ListMod.MODID + ":item/" + name + "_base",
                ListMod.MODID + ":item/" + name + "_overlay");
    }

    /**
     * 月饼专用模型生成器
     * <p>
     * 基础层A: baseTexture (月饼皮，不调色)
     * 覆盖层B: fillingTexture (月饼馅，tintIndex=1调色)
     * <p>
     * 这里直接生成一个原生的 item/generated 多层模型，和 EggItem 的颜色注册方式更接近：
     * layer0 负责基础层，layer1 负责馅料层。
     *
     * @param baseTexture    基础层纹理路径 (如 "list:item/food/mooncake/mooncake_base")
     * @param fillingTexture 覆盖层纹理路径 (如 "list:item/food/mooncake/xxx_filling")
     */
    public static void mooncakeModel(DataGenContext<Item, MooncakeItem> ctx, RegistrateItemModelProvider provider,
                                      String baseTexture, String fillingTexture) {
        provider.getBuilder(provider.name(ctx::get))
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", baseTexture)
                .texture("layer1", fillingTexture);
    }

    /**
     * 果冻专用模型生成器
     * <p>
     * 基础层A: jelly_base (不调色)
     * 覆盖层B: jelly (tintIndex=1 调色)
     * <p>
     * 美术约定：上层纹理尽量保持灰度层次，颜色由 tint 常量控制；选色时可按
     * “应用XYZ色彩空间原理”来理解为保持主色相、用明度组织通透感。
     */
    public static void jellyModel(DataGenContext<Item, JellyItem> ctx, RegistrateItemModelProvider provider,
                                  String baseTexture, String jellyTexture) {
        provider.getBuilder(provider.name(ctx::get))
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", baseTexture)
                .texture("layer1", jellyTexture);
    }
}
