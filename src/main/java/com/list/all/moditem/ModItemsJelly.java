package com.list.all.moditem;

import com.list.item.util.JellyItem;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;

import static com.list.ListMod.REGISTRATE;

public class ModItemsJelly {

    public static final ItemEntry<JellyItem> SLOE_BERRIES_JELLY = REGISTRATE
            .item("sloe_berries_jelly", p -> new JellyItem(p, 0xFF4B0082))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> MUSCADINE_GRAPES_JELLY = REGISTRATE
            .item("muscadine_grapes_jelly", p -> new JellyItem(p, 0xFF800080))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> MEMBRILLO_JELLY = REGISTRATE
            .item("membrillo_jelly", p -> new JellyItem(p, 0xFFFFA500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> OXYGRAPE_JELLY = REGISTRATE
            .item("oxygrape_jelly", p -> new JellyItem(p, 0xFFADD8E6))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> PEARLIPEARL_JELLY = REGISTRATE
            .item("pearlipearl_jelly", p -> new JellyItem(p, 0xFFD2B48C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> WARPED_LAUREL_JELLY = REGISTRATE
            .item("warped_laurel_jelly", p -> new JellyItem(p, 0xFF00CED1))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> ROSE_HIPS_JELLY = REGISTRATE
            .item("rose_hips_jelly", p -> new JellyItem(p, 0xFFB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> BLACK_OLIVE_FRUIT_JELLY = REGISTRATE
            .item("black_olive_fruit_jelly", p -> new JellyItem(p, 0xFF1B1B1B))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> LANTERN_FRUIT_JELLY = REGISTRATE
            .item("lantern_fruit_jelly", p -> new JellyItem(p, 0xFFFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> HIMEKAIDO_JELLY = REGISTRATE
            .item("himekaido_jelly", p -> new JellyItem(p, 0xFFFFAFAF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> LUCUMA_JELLY = REGISTRATE
            .item("lucuma_jelly", p -> new JellyItem(p, 0xFF9ACD32))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> HOARY_APPLE_JELLY = REGISTRATE
            .item("hoary_apple_jelly", p -> new JellyItem(p, 0xFF8B4513))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> SEA_GRAPE_JELLY = REGISTRATE
            .item("sea_grape_jelly", p -> new JellyItem(p, 0xFF003366))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> ARBUTUS_BERRIES_JELLY = REGISTRATE
            .item("arbutus_berries_jelly", p -> new JellyItem(p, 0xFFB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> WILDBERRY_JELLY = REGISTRATE
            .item("wildberry_jelly", p -> new JellyItem(p, 0xFFB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> GEARO_BERRY_JELLY = REGISTRATE
            .item("gearo_berry_jelly", p -> new JellyItem(p, 0xFF4B0082))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> BLACK_GRAPE_JELLY = REGISTRATE
            .item("black_grape_jelly", p -> new JellyItem(p, 0xFF2E0854))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> WARPED_GRAPE_JELLY = REGISTRATE
            .item("warped_grape_jelly", p -> new JellyItem(p, 0xFF1C8E75))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> CRIMSON_GRAPE_JELLY = REGISTRATE
            .item("crimson_grape_jelly", p -> new JellyItem(p, 0xFFDC143C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> LAPISBERRIES_JELLY = REGISTRATE
            .item("lapisberries_jelly", p -> new JellyItem(p, 0xFF0F52BA))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> SPONGEKIN_JELLY = REGISTRATE
            .item("spongekin_jelly", p -> new JellyItem(p, 0xFFBDB76B))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> STRAWBERRIES_JELLY = REGISTRATE
            .item("strawberries_jelly", p -> new JellyItem(p, 0xFFFF0000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> WHITE_STRAWBERRIES_JELLY = REGISTRATE
            .item("white_strawberries_jelly", p -> new JellyItem(p, 0xFFFFF8DC))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> STYGIAN_POMEGRANATE_JELLY = REGISTRATE
            .item("stygian_pomegranate_jelly", p -> new JellyItem(p, 0xFF87CEEB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> VILLAGE_LIME_JELLY = REGISTRATE
            .item("village_lime_jelly", p -> new JellyItem(p, 0xFF006400))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> THUNDER_FRUIT_JELLY = REGISTRATE
            .item("thunder_fruit_jelly", p -> new JellyItem(p, 0xFF8A2BE2))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> CLOUD_BERRIES_JELLY = REGISTRATE
            .item("cloud_berries_jelly", p -> new JellyItem(p, 0xFFFFA500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static final ItemEntry<JellyItem> CHERRY_JELLY = REGISTRATE
            .item("cherry_jelly", p -> new JellyItem(p, 0xFFFF0000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

    public static void register() {
    }
}
