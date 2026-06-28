package com.list.all.moditem;

import com.list.item.util.MooncakeItem;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import static com.list.ListMod.REGISTRATE;

public class ModItemsMooncake {

    public static final ItemEntry<Item> BLACK_SESAME_RED_BEAN_PASTE_MOONCAKE = REGISTRATE
            .item("black_sesame_red_bean_paste_mooncake", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/mooncake/life_after/black_sesame_red_bean_paste_mooncake")))
            .register();

    public static final ItemEntry<Item> FIVE_KERNALS_HAM_MOONCAKE = REGISTRATE
            .item("five_kernals_ham_mooncake", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/mooncake/life_after/five_kernals_ham_mooncake")))
            .register();

    public static final ItemEntry<Item> SNOW_SKIN_COCONUT_MOONCAKE = REGISTRATE
            .item("snow_skin_coconut_mooncake", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/mooncake/life_after/snow_skin_coconut_mooncake")))
            .register();

     public static final ItemEntry<MooncakeItem> SLOE_BERRIES_MOONCAKE = REGISTRATE
             .item("sloe_berries_mooncake", p -> new MooncakeItem(p, 0xFF4B0082))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> MUSCADINE_GRAPES_MOONCAKE = REGISTRATE
             .item("muscadine_grapes_mooncake", p -> new MooncakeItem(p, 0xFF800080))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> MEMBRILLO_MOONCAKE = REGISTRATE
             .item("membrillo_mooncake", p -> new MooncakeItem(p, 0xFFFFA500))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> OXYGRAPE_MOONCAKE = REGISTRATE
             .item("oxygrape_mooncake", p -> new MooncakeItem(p, 0xFFADD8E6))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> PEARLIPEARL_MOONCAKE = REGISTRATE
             .item("pearlipearl_mooncake", p -> new MooncakeItem(p, 0xFFD2B48C))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> WARPED_LAUREL_MOONCAKE = REGISTRATE
             .item("warped_laurel_mooncake", p -> new MooncakeItem(p, 0xFF00CED1))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> ROSE_HIPS_MOONCAKE = REGISTRATE
             .item("rose_hips_mooncake", p -> new MooncakeItem(p, 0xFFB22222))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> BLACK_OLIVE_FRUIT_MOONCAKE = REGISTRATE
             .item("black_olive_fruit_mooncake", p -> new MooncakeItem(p, 0xFF1B1B1B))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> LANTERN_FRUIT_MOONCAKE = REGISTRATE
             .item("lantern_fruit_mooncake", p -> new MooncakeItem(p, 0xFFFFD700))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> HIMEKAIDO_MOONCAKE = REGISTRATE
             .item("himekaido_mooncake", p -> new MooncakeItem(p, 0xFFFFAFAF))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> LUCUMA_MOONCAKE = REGISTRATE
             .item("lucuma_mooncake", p -> new MooncakeItem(p, 0xFF9ACD32))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> HOARY_APPLE_MOONCAKE = REGISTRATE
             .item("hoary_apple_mooncake", p -> new MooncakeItem(p, 0xFF8B4513))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> SEA_GRAPE_MOONCAKE = REGISTRATE
             .item("sea_grape_mooncake", p -> new MooncakeItem(p, 0xFF003366))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> ARBUTUS_BERRIES_MOONCAKE = REGISTRATE
             .item("arbutus_berries_mooncake", p -> new MooncakeItem(p, 0xFFB22222))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> WILDBERRY_MOONCAKE = REGISTRATE
             .item("wildberry_mooncake", p -> new MooncakeItem(p, 0xFFB22222))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> GEARO_BERRY_MOONCAKE = REGISTRATE
             .item("gearo_berry_mooncake", p -> new MooncakeItem(p, 0xFF4B0082))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> BLACK_GRAPE_MOONCAKE = REGISTRATE
             .item("black_grape_mooncake", p -> new MooncakeItem(p, 0xFF2E0854))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> WARPED_GRAPE_MOONCAKE = REGISTRATE
             .item("warped_grape_mooncake", p -> new MooncakeItem(p, 0xFF1C8E75))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> CRIMSON_GRAPE_MOONCAKE = REGISTRATE
             .item("crimson_grape_mooncake", p -> new MooncakeItem(p, 0xFFDC143C))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> LAPISBERRIES_MOONCAKE = REGISTRATE
             .item("lapisberries_mooncake", p -> new MooncakeItem(p, 0xFF0F52BA))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> SPONGEKIN_MOONCAKE = REGISTRATE
             .item("spongekin_mooncake", p -> new MooncakeItem(p, 0xFFBDB76B))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> ROTBULB_MOONCAKE = REGISTRATE
             .item("rotbulb_mooncake", p -> new MooncakeItem(p, 0xFF8B004B))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

     public static final ItemEntry<MooncakeItem> UBE_MOONCAKE = REGISTRATE
             .item("ube_mooncake", p -> new MooncakeItem(p, 0xFFB19CD9))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> STARFRUIT_MOONCAKE = REGISTRATE
             .item("starfruit_mooncake", p -> new MooncakeItem(p, 0xFFFFD700))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> DURIAN_MOONCAKE = REGISTRATE
             .item("durian_mooncake", p -> new MooncakeItem(p, 0xFFF5DEB3))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> GREEN_POMELO_MOONCAKE = REGISTRATE
             .item("green_pomelo_mooncake", p -> new MooncakeItem(p, 0xFF90EE90))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> CANTALOUPE_MOONCAKE = REGISTRATE
             .item("cantaloupe_mooncake", p -> new MooncakeItem(p, 0xFFE6C87A))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PEAR_MOONCAKE = REGISTRATE
             .item("pear_mooncake", p -> new MooncakeItem(p, 0xFF00FF00))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> RASPBERRY_MOONCAKE = REGISTRATE
             .item("raspberry_mooncake", p -> new MooncakeItem(p, 0xFFE30B5D))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> BLACKCURRANT_MOONCAKE = REGISTRATE
             .item("blackcurrant_mooncake", p -> new MooncakeItem(p, 0xFF2E0854))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> GOOSEBERRY_MOONCAKE = REGISTRATE
             .item("gooseberry_mooncake", p -> new MooncakeItem(p, 0xFFADFF2F))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> CHERRY_MOONCAKE = REGISTRATE
             .item("cherry_mooncake", p -> new MooncakeItem(p, 0xFF990000))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> OLIVE_MOONCAKE = REGISTRATE
             .item("olive_mooncake", p -> new MooncakeItem(p, 0xFF808000))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PLUM_MOONCAKE = REGISTRATE
             .item("plum_mooncake", p -> new MooncakeItem(p, 0xFF8E4585))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> APRICOT_MOONCAKE = REGISTRATE
             .item("apricot_mooncake", p -> new MooncakeItem(p, 0xFFFFB347))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> GREEN_PLUM_MOONCAKE = REGISTRATE
             .item("green_plum_mooncake", p -> new MooncakeItem(p, 0xFF9ACD32))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> GREEN_GRAPE_MOONCAKE = REGISTRATE
             .item("green_grape_mooncake", p -> new MooncakeItem(p, 0xFF90EE90))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PASSION_FRUIT_MOONCAKE = REGISTRATE
             .item("passion_fruit_mooncake", p -> new MooncakeItem(p, 0xFF9370DB))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> DRAGON_FRUIT_MOONCAKE = REGISTRATE
             .item("dragon_fruit_mooncake", p -> new MooncakeItem(p, 0xFFFF69B4))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> RED_DRAGON_FRUIT_MOONCAKE = REGISTRATE
             .item("red_dragon_fruit_mooncake", p -> new MooncakeItem(p, 0xFFC71585))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> HOLLY_BERRY_MOONCAKE = REGISTRATE
             .item("holly_berry_mooncake", p -> new MooncakeItem(p, 0xFFFF0000))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> HAWTHORN_MOONCAKE = REGISTRATE
             .item("hawthorn_mooncake", p -> new MooncakeItem(p, 0xFFDC143C))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> POMEGRANATE_MOONCAKE = REGISTRATE
             .item("pomegranate_mooncake", p -> new MooncakeItem(p, 0xFFC21E56))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> FIG_MOONCAKE = REGISTRATE
             .item("fig_mooncake", p -> new MooncakeItem(p, 0xFF8B4513))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> AVOCADO_MOONCAKE = REGISTRATE
             .item("avocado_mooncake", p -> new MooncakeItem(p, 0xFF556B2F))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> GRAPEFRUIT_MOONCAKE = REGISTRATE
             .item("grapefruit_mooncake", p -> new MooncakeItem(p, 0xFFFF6347))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> LYCHEE_MOONCAKE = REGISTRATE
             .item("lychee_mooncake", p -> new MooncakeItem(p, 0xFFFF6347))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PAPAYA_MOONCAKE = REGISTRATE
             .item("papaya_mooncake", p -> new MooncakeItem(p, 0xFFFFA500))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> MANGOSTEEN_MOONCAKE = REGISTRATE
             .item("mangosteen_mooncake", p -> new MooncakeItem(p, 0xFF580F41))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> WAXBERRY_MOONCAKE = REGISTRATE
             .item("waxberry_mooncake", p -> new MooncakeItem(p, 0xFF800020))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> DATE_MOONCAKE = REGISTRATE
             .item("date_mooncake", p -> new MooncakeItem(p, 0xFF8B4513))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> BERGAMOT_MOONCAKE = REGISTRATE
             .item("bergamot_mooncake", p -> new MooncakeItem(p, 0xFFFFE4B5))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> JABUTICABA_MOONCAKE = REGISTRATE
             .item("jabuticaba_mooncake", p -> new MooncakeItem(p, 0xFF4B0082))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> KIWANO_MOONCAKE = REGISTRATE
             .item("kiwano_mooncake", p -> new MooncakeItem(p, 0xFFFF8C00))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> RAMBUTAN_MOONCAKE = REGISTRATE
             .item("rambutan_mooncake", p -> new MooncakeItem(p, 0xFFFF0000))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> KUMQUAT_MOONCAKE = REGISTRATE
             .item("kumquat_mooncake", p -> new MooncakeItem(p, 0xFFFFA500))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> BANANA_MOONCAKE = REGISTRATE
             .item("banana_mooncake", p -> new MooncakeItem(p, 0xFFFFFF00))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> ELDERBERRY_MOONCAKE = REGISTRATE
             .item("elderberry_mooncake", p -> new MooncakeItem(p, 0xFF191970))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> ALMOND_MOONCAKE = REGISTRATE
             .item("almond_mooncake", p -> new MooncakeItem(p, 0xFFD2B48C))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PISTACHIO_MOONCAKE = REGISTRATE
             .item("pistachio_mooncake", p -> new MooncakeItem(p, 0xFF93C572))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PINE_NUT_MOONCAKE = REGISTRATE
             .item("pine_nut_mooncake", p -> new MooncakeItem(p, 0xFFF5DEB3))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> CHESTNUT_MOONCAKE = REGISTRATE
             .item("chestnut_mooncake", p -> new MooncakeItem(p, 0xFF8B4513))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> CASHEW_MOONCAKE = REGISTRATE
             .item("cashew_mooncake", p -> new MooncakeItem(p, 0xFFF5DEB3))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> HAZELNUT_MOONCAKE = REGISTRATE
             .item("hazelnut_mooncake", p -> new MooncakeItem(p, 0xFF8B4513))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> WALNUT_MOONCAKE = REGISTRATE
             .item("walnut_mooncake", p -> new MooncakeItem(p, 0xFF8B4513))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> WHITE_GRAPE_MOONCAKE = REGISTRATE
             .item("white_grape_mooncake", p -> new MooncakeItem(p, 0xFFFAFAD2))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> RED_GRAPE_MOONCAKE = REGISTRATE
             .item("red_grape_mooncake", p -> new MooncakeItem(p, 0xFF800020))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> CITRON_MOONCAKE = REGISTRATE
             .item("citron_mooncake", p -> new MooncakeItem(p, 0xFFFFFF00))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> GREEN_APPLE_MOONCAKE = REGISTRATE
             .item("green_apple_mooncake", p -> new MooncakeItem(p, 0xFF7FFF00))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> KIWI_MOONCAKE = REGISTRATE
             .item("kiwi_mooncake", p -> new MooncakeItem(p, 0xFF9ACD32))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PERSIMMON_MOONCAKE = REGISTRATE
             .item("persimmon_mooncake", p -> new MooncakeItem(p, 0xFFFF6347))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> WHITE_STRAWBERRIES_MOONCAKE = REGISTRATE
             .item("white_strawberries_mooncake", p -> new MooncakeItem(p, 0xFFFFF5EE))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> STYGIAN_POMEGRANATE_MOONCAKE = REGISTRATE
             .item("stygian_pomegranate_mooncake", p -> new MooncakeItem(p, 0xFF00BFFF))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> VILLAGE_LIME_MOONCAKE = REGISTRATE
             .item("village_lime_mooncake", p -> new MooncakeItem(p, 0xFF006400))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> THUNDER_FRUIT_MOONCAKE = REGISTRATE
             .item("thunder_fruit_mooncake", p -> new MooncakeItem(p, 0xFF8A2BE2))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> CLOUD_BERRIES_MOONCAKE = REGISTRATE
             .item("cloud_berries_mooncake", p -> new MooncakeItem(p, 0xFFFFA500))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> BLACK_CHERRY_MOONCAKE = REGISTRATE
             .item("black_cherry_mooncake", p -> new MooncakeItem(p, 0xFFFF0000))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> LEMON_MOONCAKE = REGISTRATE
             .item("lemon_mooncake", p -> new MooncakeItem(p, 0xFFFFFF00))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static final ItemEntry<MooncakeItem> PEACH_MOONCAKE = REGISTRATE
             .item("peach_mooncake", p -> new MooncakeItem(p, 0xFFFFB6C1))
             .properties(p -> p.food(new FoodProperties.Builder()
                     .nutrition(3)
                     .saturationMod(0.4f)
                     .build()))
             .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                     "list:item/food/mooncake/mooncake_base",
                     "list:item/food/mooncake/mooncake_filling"))
             .register();

    public static void register() {
    }
}
