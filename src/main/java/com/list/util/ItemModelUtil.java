package com.list.util;

import com.list.ListMod;
import com.list.client.model.LayeredItemModel;
import com.list.item.util.EggItem;
import com.list.item.util.JellyItem;
import com.list.item.util.LayeredItem;
import com.list.item.util.MooncakeItem;
import com.list.item.util.SmokerFish;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.fml.ModList;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("unused")
public class ItemModelUtil {
    public static final ResourceLocation TEMPLATE_EGG = ListMod.rl("item/template_egg");
    public static final ResourceLocation TEMPLATE_LAYERED_BASE = ListMod.rl("item/template_layered_base");
    public static final ResourceLocation TEMPLATE_LAYERED_OVERLAY = ListMod.rl("item/template_layered_overlay");

    /**
     * 解析任意命名空间纹理，例如 `minecraft:item/cod` 或 `othermod:item/foo/bar`。
     */
    public static ResourceLocation texture(String textureId) {
        return ResourceLocation.parse(textureId);
    }

    public static ResourceLocation texture(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath(namespace, path);
    }

    /**
     * 安全选择纹理：候选纹理存在则使用候选，否则回退到 fallback。
     * <p>
     * 适合在 datagen / 注册阶段引用可选模组资源，避免缺资源导致流程报错。
     */
    public static ResourceLocation textureOrFallback(String textureId, ResourceLocation fallback) {
        return textureOrFallback(texture(textureId), fallback);
    }

    public static ResourceLocation textureOrFallback(ResourceLocation candidate, ResourceLocation fallback) {
        return textureExists(candidate) ? candidate : fallback;
    }

    public static ResourceLocation textureOrFallback(RegistrateItemModelProvider provider, String textureId, ResourceLocation fallback) {
        return textureOrFallback(provider, texture(textureId), fallback);
    }

    public static ResourceLocation textureOrFallback(RegistrateItemModelProvider provider, ResourceLocation candidate, ResourceLocation fallback) {
        if (isBuiltInTexture(candidate) || ModList.get().isLoaded(candidate.getNamespace())) {
            ensureTracked(provider, candidate);
            return candidate;
        }
        return fallback;
    }

    private static boolean isBuiltInTexture(ResourceLocation location) {
        if (ListMod.MODID.equals(location.getNamespace()) || "minecraft".equals(location.getNamespace())) {
            return true;
        }

        String resourcePath = "assets/" + location.getNamespace() + "/textures/" + location.getPath() + ".png";
        return ItemModelUtil.class.getClassLoader().getResource(resourcePath) != null;
    }

    private static boolean textureExists(ResourceLocation location) {
        if (isBuiltInTexture(location)) {
            return true;
        }

        return ModList.get().isLoaded(location.getNamespace());
    }

    private static Object resolveExistingFileHelper(RegistrateItemModelProvider provider) {
        try {
            Method getter = provider.getClass().getMethod("getExistingFileHelper");
            getter.setAccessible(true);
            return getter.invoke(provider);
        } catch (ReflectiveOperationException ignored) {
        }

        Class<?> type = provider.getClass();
        while (type != null) {
            try {
                Field field = type.getDeclaredField("existingFileHelper");
                field.setAccessible(true);
                return field.get(provider);
            } catch (ReflectiveOperationException ignored) {
                type = type.getSuperclass();
            }
        }
        return null;
    }

    private static void ensureTracked(RegistrateItemModelProvider provider, ResourceLocation location) {
        Object existingFileHelper = resolveExistingFileHelper(provider);
        if (existingFileHelper == null) {
            return;
        }

        for (Method method : existingFileHelper.getClass().getMethods()) {
            if (!method.getName().startsWith("track") || method.getParameterCount() < 1 || method.getParameterTypes()[0] != ResourceLocation.class) {
                continue;
            }

            Object[] args = new Object[method.getParameterCount()];
            args[0] = location;
            boolean supported = true;
            for (int i = 1; i < args.length; i++) {
                Class<?> parameterType = method.getParameterTypes()[i];
                if (parameterType == PackType.class) {
                    args[i] = PackType.CLIENT_RESOURCES;
                } else if (parameterType.isEnum()) {
                    args[i] = Enum.valueOf(parameterType.asSubclass(Enum.class), "CLIENT_RESOURCES");
                } else if (parameterType == String.class) {
                    args[i] = i == 2 ? ".png" : "textures";
                } else {
                    supported = false;
                    break;
                }
            }

            if (!supported) {
                continue;
            }

            try {
                method.setAccessible(true);
                method.invoke(existingFileHelper, args);
                return;
            } catch (ReflectiveOperationException ignored) {
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Boolean invokeExistingFileHelperExists(Object existingFileHelper, ResourceLocation location) {
        for (Method method : existingFileHelper.getClass().getMethods()) {
            if (!method.getName().equals("exists") || method.getParameterCount() < 2 || method.getParameterTypes()[0] != ResourceLocation.class) {
                continue;
            }

            Object[] args = new Object[method.getParameterCount()];
            args[0] = location;
            for (int i = 1; i < args.length; i++) {
                Class<?> parameterType = method.getParameterTypes()[i];
                if (parameterType == PackType.class) {
                    args[i] = PackType.CLIENT_RESOURCES;
                } else if (parameterType.isEnum()) {
                    Class<? extends Enum> enumType = (Class<? extends Enum>) parameterType;
                    args[i] = Enum.valueOf((Class) enumType, "CLIENT_RESOURCES");
                } else if (parameterType == String.class) {
                    args[i] = i == 2 ? ".png" : "textures";
                } else {
                    args = null;
                    break;
                }
            }

            if (args == null) {
                continue;
            }

            try {
                method.setAccessible(true);
                Object result = method.invoke(existingFileHelper, args);
                if (result instanceof Boolean booleanResult) {
                    return booleanResult;
                }
            } catch (ReflectiveOperationException ignored) {
            }
        }
        return null;
    }

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

        discard(provider.getBuilder(provider.name(ctx::get))
                .customLoader(LayeredItemModel.Builder::begin)
                .baseModel(baseModel)
                .overlayModel(overlayModel)
                .end());
    }

    /**
     * 自动按物品名生成双层图层模型。
     * <p>
     * 基础层: item/{name}_base
     * 覆盖层: item/{name}_overlay
     */
    @SuppressWarnings("unused")
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

    /**
     * 烟熏鱼模型生成器。
     * <p>
     * layer0 使用鱼底图并由 SmokerFish 的 tintIndex=0 上色，layer1 使用指定烟雾层。
     */
    public static void smokerFishModel(DataGenContext<Item, SmokerFish> ctx, RegistrateItemModelProvider provider,
                                       ResourceLocation fishTexture, SmokerFish.SmokeVariant smokeVariant) {
        smokerFishModel(ctx, provider, fishTexture, smokeVariant.textureLocation());
    }

    public static void smokerFishModel(DataGenContext<Item, SmokerFish> ctx, RegistrateItemModelProvider provider,
                                       ResourceLocation fishTexture, ResourceLocation smokeTexture) {
        discard(provider.getBuilder(provider.name(ctx::get))
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", fishTexture)
                .texture("layer1", smokeTexture));
    }

    private static void discard(Object value) {
    }
}
