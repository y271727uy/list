package com.list.integration.kubejs.api;

import com.list.ListMod;
import com.list.item.util.EggItem;
import com.list.item.util.JellyItem;
import com.list.item.util.LayeredItem;
import com.list.item.util.MooncakeItem;
import com.list.item.util.SmokerFish;
import com.list.util.ItemModelUtil;
import com.list.util.ColorSpaceUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;

/**
 * KubeJS 侧可直接调用的特殊物品注册门面与颜色工具。
 * <p>
 * 设计目标：让脚本能直接调用封装好的注册方法，
 * 不需要自己拼实现类、模型和颜色注册。
 */
@SuppressWarnings("unused")
public final class ListKubeJsApi {

    private ListKubeJsApi() {
    }

    public static ItemEntry<EggItem> registerEgg(String name, int color) {
        return registerEgg(name, color, 1, 0.3F);
    }

    public static ItemEntry<EggItem> registerEgg(String name, int color, int nutrition, float saturationMod) {
        return ListMod.REGISTRATE
                .item(name, p -> new EggItem(p, color))
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturationMod)
                        .build()))
                .model(ItemModelUtil::eggItemModel)
                .register();
    }

    public static ItemEntry<MooncakeItem> registerMooncake(String name, int fillingColor) {
        return registerMooncake(name, fillingColor, 3, 0.4F,
                "list:item/food/mooncake/mooncake_base",
                "list:item/food/mooncake/mooncake_filling");
    }

    public static ItemEntry<MooncakeItem> registerMooncake(String name, int fillingColor, int nutrition, float saturationMod,
                                                           String baseTexture, String fillingTexture) {
        return ListMod.REGISTRATE
                .item(name, p -> new MooncakeItem(p, fillingColor))
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturationMod)
                        .build()))
                .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider, baseTexture, fillingTexture))
                .register();
    }

    public static ItemEntry<JellyItem> registerJelly(String name, int jellyColor) {
        return registerJelly(name, jellyColor, 2, 0.4F,
                "list:item/food/component/jelly_base",
                "list:item/food/component/jelly");
    }

    public static ItemEntry<JellyItem> registerJelly(String name, int jellyColor, int nutrition, float saturationMod,
                                                     String baseTexture, String jellyTexture) {
        return ListMod.REGISTRATE
                .item(name, p -> new JellyItem(p, jellyColor))
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturationMod)
                        .build()))
                .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider, baseTexture, jellyTexture))
                .register();
    }

    public static ItemEntry<LayeredItem> registerLayered(String name, int baseColor, int overlayColor) {
        return registerLayered(name, baseColor, overlayColor,
                ListMod.MODID + ":item/" + name + "_base",
                ListMod.MODID + ":item/" + name + "_overlay");
    }

    public static ItemEntry<LayeredItem> registerLayered(String name, int baseColor, int overlayColor,
                                                          String baseTexture, String overlayTexture) {
        return ListMod.REGISTRATE
                .item(name, p -> new LayeredItem(p, baseColor, overlayColor))
                .model((ctx, provider) -> ItemModelUtil.layeredItemModel(ctx, provider, baseTexture, overlayTexture))
                .register();
    }

    public static ItemEntry<SmokerFish> registerSmokerFish(String name, int fishColor,
                                                            ResourceLocation fishTexture,
                                                            SmokerFish.SmokeVariant smokeVariant) {
        return ListMod.REGISTRATE
                .item(name, p -> new SmokerFish(p, fishColor, smokeVariant))
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(5)
                        .saturationMod(0.6F)
                        .build()))
                .model((ctx, provider) -> ItemModelUtil.smokerFishModel(ctx, provider, fishTexture, smokeVariant))
                .register();
    }

    public static ItemEntry<SmokerFish> registerSmokerFish(String name, int fishColor,
                                                            String fishTexture,
                                                            String smokeTexture) {
        return registerSmokerFish(name, fishColor, rl(fishTexture), rl(smokeTexture));
    }

    public static ItemEntry<SmokerFish> registerSmokerFish(String name, int fishColor,
                                                            ResourceLocation fishTexture,
                                                            ResourceLocation smokeTexture) {
        return ListMod.REGISTRATE
                .item(name, p -> new SmokerFish(p, fishColor, smokeTexture))
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(5)
                        .saturationMod(0.6F)
                        .build()))
                .model((ctx, provider) -> ItemModelUtil.smokerFishModel(ctx, provider, fishTexture, smokeTexture))
                .register();
    }

    public static ResourceLocation rl(String path) {
        return ListMod.rl(path);
    }

    public static ResourceLocation rl(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }

    public static int opaque(int argb) {
        return ColorSpaceUtil.normalizeOpaque(argb);
    }

    public static int tintFromGray(int baseArgb, float grayLevel) {
        return ColorSpaceUtil.tintFromGray(baseArgb, grayLevel);
    }
}


