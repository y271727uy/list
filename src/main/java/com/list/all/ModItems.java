package com.list.all;

import com.list.item.EggItem;
import com.list.item.GlowingItem;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static com.list.ListMod.REGISTRATE;

public class ModItems {

    public static final ItemEntry<Item> INDUSTRIAL_COPPER_CREDIT = REGISTRATE
        .item("industrial_copper_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_copper_credit")))
        .register();

    // 工业银币
    public static final ItemEntry<Item> INDUSTRIAL_SILVER_CREDIT = REGISTRATE
        .item("industrial_silver_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_silver_credit")))
        .register();

    // 工业金币
    public static final ItemEntry<Item> INDUSTRIAL_GOLD_CREDIT = REGISTRATE
        .item("industrial_gold_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_gold_credit")))
        .register();

    // 工业铂币
    public static final ItemEntry<Item> INDUSTRIAL_PLATINUM_CREDIT = REGISTRATE
        .item("industrial_platinum_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_platinum_credit")))
        .register();

    // 工业锇币
    public static final ItemEntry<Item> INDUSTRIAL_OSMIUM_CREDIT = REGISTRATE
        .item("industrial_osmium_credit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/industrial_osmium_credit")))
        .register();


    // 平平无奇的面包
    public static final ItemEntry<GlowingItem> JUST_BREAD =REGISTRATE
        .item("just_bread", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.mcLoc("item/bread")))
        .register();

    // 食物之星
    public static final ItemEntry<GlowingItem> FOOD_STAR =REGISTRATE
        .item("food_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/food_star")))
        .register();

    // 渔业之星
    public static final ItemEntry<GlowingItem> FISHERY_STAR =REGISTRATE
        .item("fishery_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/fishery_star")))
        .register();

    // 农夫之星
    public static final ItemEntry<GlowingItem> FARMING_STAR =REGISTRATE
        .item("farming_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/farming_star")))
        .register();

    // 林业之星
    public static final ItemEntry<GlowingItem> FORESTRY_STAR =REGISTRATE
        .item("forestry_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/forestry_star")))
        .register();

    // 财富之星
    public static final ItemEntry<GlowingItem> WEALTH_STAR =REGISTRATE
        .item("wealth_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/wealth_star")))
        .register();

    // 养殖之星
    public static final ItemEntry<GlowingItem> ANIMAL_HUSBANDRY_STAR =REGISTRATE
        .item("animal_husbandry_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/animal_husbandry_star")))
        .register();

    // Farmer's Ranch: Pastoral Serenade之星
    public static final ItemEntry<GlowingItem> FARMERS_RANCH_STAR =REGISTRATE
        .item("farmers_ranch_star", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/farmers_ranch_star")))
        .register();

     // 技术性屏蔽物品
    public static final ItemEntry<GlowingItem> BAD_ITEM = REGISTRATE
        .item("bad_item", GlowingItem::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.mcLoc("item/book")))
        .register();

    //皇帝蟹
    public static final ItemEntry<Item> EMPEROR_CRAB = REGISTRATE
            .item("emperor_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/emperor_crab")))
            .register();

    //面包蟹
    public static final ItemEntry<Item> JONAH_CRAB = REGISTRATE
            .item("jonah_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/jonah_crab")))
            .register();

    //梭子蟹
    public static final ItemEntry<Item> SWIMMING_CRAB = REGISTRATE
            .item("swimming_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/swimming_crab")))
            .register();

    //寄居蟹
    public static final ItemEntry<Item> HERMIT_CRAB = REGISTRATE
            .item("hermit_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/hermit_crab")))
            .register();

    //河虾
    public static final ItemEntry<Item> RIVER_SHRIMP = REGISTRATE
            .item("river_shrimp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/river_shrimp")))
            .register();

    //海螺
    public static final ItemEntry<Item> CONCH = REGISTRATE
            .item("conch", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/conch")))
            .register();

    //皇帝蟹卵
    public static final ItemEntry<Item> EMPEROR_CRAB_EGG = REGISTRATE
            .item("emperor_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/emperor_crab_egg")))
            .register();

    //面包蟹卵
    public static final ItemEntry<Item> JONAH_CRAB_EGG = REGISTRATE
            .item("jonah_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/jonah_crab_egg")))
            .register();

    //花蟹卵
    public static final ItemEntry<Item> PELAGIC_SWIMMING_CRAB_EGG = REGISTRATE
            .item("pelagic_swimming_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/pelagic_swimming_crab_egg")))
            .register();

    //珍宝蟹卵
    public static final ItemEntry<Item> DUNGENESS_CRAB_EGG = REGISTRATE
            .item("dungeness_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/dungeness_crab_egg")))
            .register();

    //梭子蟹卵
    public static final ItemEntry<Item> SWIMMING_CRAB_EGG = REGISTRATE
            .item("swimming_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/swimming_crab_egg")))
            .register();

    //寄居蟹卵
    public static final ItemEntry<Item> HERMIT_CRAB_EGG = REGISTRATE
            .item("hermit_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/hermit_crab_egg")))
            .register();

    //河蟹卵
    public static final ItemEntry<Item> RIVER_CRAB_EGG = REGISTRATE
            .item("river_crab_egg", Item::new)
             .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/river_crab_egg")))
            .register();

    //蓝龙虾卵
    public static final ItemEntry<Item> BLUE_LOBSTER_EGG = REGISTRATE
            .item("blue_lobster_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/blue_lobster_egg")))
            .register();

    //锦绣龙虾卵
    public static final ItemEntry<Item> MARBLED_LOBSTER_EGG = REGISTRATE
            .item("marbled_lobster_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/marbled_lobster_egg")))
            .register();

    //深海鳌虾卵
    public static final ItemEntry<Item> DEEP_SEA_STAG_SHRIMP_EGG = REGISTRATE
            .item("deep-sea_stag_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/deep-sea_stag_shrimp_egg")))
            .register();

    //基围虾卵
    public static final ItemEntry<Item> VANNAMEI_SHRIMP_EGG = REGISTRATE
            .item("vannamei_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/vannamei_shrimp_egg")))
            .register();

    //濑尿虾卵
    public static final ItemEntry<Item> MANTIS_SHRIMP_EGG = REGISTRATE
            .item("mantis_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/mantis_shrimp_egg")))
            .register();

    //河虾卵
    public static final ItemEntry<Item> RIVER_SHRIMP_EGG = REGISTRATE
            .item("river_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/river_shrimp_egg")))
            .register();

    public static final ItemEntry<EggItem> TEST_EGG = REGISTRATE
        .item("test_egg", p -> new EggItem(p, 0x55ffff))
        .model(ItemModelUtil::eggItemModel)
        .register();




    public static void register() {
    }
}
