package com.list.all;

import com.list.all.moditem.ModItemsEgg;
import com.list.all.moditem.ModItemsJelly;
import com.list.all.moditem.ModItemsMooncake;
import com.list.all.moditem.ModItemsSmokerFish;
import com.list.gameplay.fish_book.FishBookItem;
import com.list.item.util.EggItem;
import com.list.item.util.JellyItem;
import com.list.item.util.MooncakeItem;
import com.list.item.util.SmokerFish;

import com.list.gameplay.fish_group.client.model.HaloModelBuilder;
import com.list.item.*;
import com.list.item.gag_item.fishy_lemon;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;

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
        

    // 铜GT币
    public static final ItemEntry<Item> COPPER_GT_CREDIT = REGISTRATE
            .item("copper_gt_credit", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/copper_gt_credit")))
            .register();

    // 白铜GT币
    public static final ItemEntry<Item> CUPRONICKEL_GT_CREDIT = REGISTRATE
            .item("cupronickel_gt_credit", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/cupronickel_gt_credit")))
            .register();

    // 银GT币
    public static final ItemEntry<Item> SILVER_GT_CREDIT = REGISTRATE
            .item("silver_gt_credit", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/silver_gt_credit")))
            .register();

    //GT币
    public static final ItemEntry<Item> GOLD_GT_CREDIT = REGISTRATE
            .item("gold_gt_credit", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/gold_gt_credit")))
            .register();

    public static final ItemEntry<Item> PLATINUM_GT_CREDIT = REGISTRATE
            .item("platinum_gt_credit", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/platinum_gt_credit")))
            .register();

    public static final ItemEntry<Item> OSMIUM_GT_CREDIT  = REGISTRATE
            .item("osmium_gt_credit", Item::new)
            .properties(p -> p.rarity(Rarity.RARE))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/osmium_gt_credit")))
            .register();

    public static final ItemEntry<Item> NAQUADAH_GT_CREDIT = REGISTRATE
            .item("naquadah_gt_credit", Item::new)
            .properties(p -> p.rarity(Rarity.RARE))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/naquadah_gt_credit")))
            .register();

    public static final ItemEntry<Item> NEUTRONIUM_GT_CREDIT = REGISTRATE
            .item("neutronium_gt_credit", Item::new)
            .properties(p -> p.rarity(Rarity.RARE))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/neutronium_gt_credit")))
            .register();

    public static final ItemEntry<Item> DOGE_COIN = REGISTRATE
            .item("doge_coin", Item::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/doge_coin")))
            .register();
//GT币结束

//执照
    // 铜
    public static final ItemEntry<Item> COPPER_CERTIFICATE = REGISTRATE
            .item("copper_certificate", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/copper_certificate")))
            .register();

    // 白铜
    public static final ItemEntry<Item> CUPRONICKEL_CERTIFICATE = REGISTRATE
            .item("cupronickel_certificate", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/cupronickel_certificate")))
            .register();

    // 银
    public static final ItemEntry<Item> SILVER_CERTIFICATE = REGISTRATE
            .item("silver_certificate", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/silver_certificate")))
            .register();

    public static final ItemEntry<Item> GOLD_CERTIFICATE = REGISTRATE
            .item("gold_certificate", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/gold_certificate")))
            .register();

    public static final ItemEntry<Item> PLATINUM_CERTIFICATE = REGISTRATE
            .item("platinum_certificate", Item::new)
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/platinum_certificate")))
            .register();

    public static final ItemEntry<Item> OSMIUM_CERTIFICATE  = REGISTRATE
            .item("osmium_certificate", Item::new)
            .properties(p -> p.rarity(Rarity.RARE))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/osmium_certificate")))
            .register();

    public static final ItemEntry<Item> NAQUADAH_CERTIFICATE = REGISTRATE
            .item("naquadah_certificate", Item::new)
            .properties(p -> p.rarity(Rarity.RARE))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/naquadah_certificate")))
            .register();

    public static final ItemEntry<Item> NEUTRONIUM_CERTIFICATE = REGISTRATE
            .item("neutronium_certificate", Item::new)
            .properties(p -> p.rarity(Rarity.RARE))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/neutronium_certificate")))
            .register();
//执照结束

    // 平平无奇的面包
    public static final ItemEntry<GlowingItem> JUST_BREAD = REGISTRATE
            .item("just_bread", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.mcLoc("item/bread")))
            .register();

    // 食物之星
    public static final ItemEntry<GlowingItem> FOOD_STAR = REGISTRATE
            .item("food_star", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/food_star")))
            .register();

    // 渔业之星
    public static final ItemEntry<GlowingItem> FISHERY_STAR = REGISTRATE
            .item("fishery_star", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/fishery_star")))
            .register();

    // 农夫之星
    public static final ItemEntry<GlowingItem> FARMING_STAR = REGISTRATE
            .item("farming_star", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/farming_star")))
            .register();

    // 林业之星
    public static final ItemEntry<GlowingItem> FORESTRY_STAR = REGISTRATE
            .item("forestry_star", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/forestry_star")))
            .register();

    // 财富之星
    public static final ItemEntry<GlowingItem> WEALTH_STAR = REGISTRATE
            .item("wealth_star", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/wealth_star")))
            .register();

    // 养殖之星
    public static final ItemEntry<GlowingItem> ANIMAL_HUSBANDRY_STAR = REGISTRATE
            .item("animal_husbandry_star", GlowingItem::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/animal_husbandry_star")))
            .register();

    // Farmer's Ranch: Pastoral Serenade之星
    public static final ItemEntry<GlowingItem> FARMERS_RANCH_STAR = REGISTRATE
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

    // 进度条
    public static final ItemEntry<GlowingItem> EQUALS = REGISTRATE
            .item("equals", GlowingItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider
            .modLoc("item/special_item/equals")))
            .register();

    // 凛冬币
    public static final ItemEntry<Item> HARSH_WINTER_CREDIT = REGISTRATE
            .item("harsh_winter_credit", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/credit/harsh_winter_credit")))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .register();

    //照抄
    public static final ItemEntry<FishBookItem> FISH_BOOK = REGISTRATE
            .item("fish_book", FishBookItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.mcLoc("item/book")))
            .register();

    public static final ItemEntry<EggItem> TEST_EGG = ModItemsEgg.TEST_EGG;

    //煎粉猫蛋蛋
    public static final ItemEntry<Item> COOK_ZHURUOLING_EGG = ModItemsEgg.COOK_ZHURUOLING_EGG;



    //粉猫蛋
    public static final ItemEntry<Item> ZHURUOLING_EGG = ModItemsEgg.ZHURUOLING_EGG;

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
    //花蟹
    public static final ItemEntry<Item> PELAGIC_SWIMMING_CRAB = REGISTRATE
            .item("pelagic_swimming_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/pelagic_swimming_crab")))
            .register();

    //珍宝蟹
    public static final ItemEntry<Item> DUNGENESS_CRAB = REGISTRATE
            .item("dungeness_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/dungeness_crab")))
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

    //河蟹
    public static final ItemEntry<Item> RIVER_CRAB = REGISTRATE
            .item("river_crab", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/river_crab")))
            .register();

    //深海鳌虾
    public static final ItemEntry<Item> DEEP_SEA_STAG_SHRIMP = REGISTRATE
            .item("deep-sea_stag_shrimp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/deep-sea_stag_shrimp")))
            .register();

    //基围虾
    public static final ItemEntry<Item> GREASYBACK_SHRIMP = REGISTRATE
            .item("greasyback_shrimp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/greasyback_shrimp")))
            .register();

    //濑尿虾
    public static final ItemEntry<Item> MANTIS_SHRIMP = REGISTRATE
            .item("mantis_shrimp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/crustacean/mantis_shrimp")))
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

    //草鱼
    public static final ItemEntry<Item> GRASS_CARP = REGISTRATE
            .item("grass_carp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/grass_carp")))
            .register();

    //蕨鱼
    public static final ItemEntry<Item> SINIPERCA_CHUATSI = REGISTRATE
            .item("siniperca_chuatsi", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/siniperca_chuatsi")))
            .register();
   
    //大黄鱼
    public static final ItemEntry<Item> LARGE_YELLOW_CROAKER = REGISTRATE
            .item("large_yellow_croaker", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/large_yellow_croaker")))
            .register();

    //银鲳鱼
    public static final ItemEntry<Item> SILVER_POMFRET = REGISTRATE
            .item("silver_pomfret", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/silver_pomfret")))
            .register();

    //多宝鱼
    public static final ItemEntry<Item> TURBOT = REGISTRATE
            .item("turbot", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/turbot")))
            .register();

    //红石斑鱼
    public static final ItemEntry<Item> RED_GROUPER = REGISTRATE
            .item("red_grouper", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/red_grouper")))
            .register();

    //鹦嘴鱼
    public static final ItemEntry<Item> PARROTFISH = REGISTRATE
            .item("parrotfish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/parrotfish")))
            .register();

     //苏眉鱼
    public static final ItemEntry<Item> CAMOUFLAGE_GROUPER = REGISTRATE
            .item("camouflage_grouper", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/camouflage_grouper")))
            .register();


    //锦鲤
    public static final ItemEntry<Item> KOI = REGISTRATE
            .item("koi", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/koi")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    //鸡鱼
    public static final ItemEntry<Item> THREADFIN_BREAM = REGISTRATE
            .item("threadfin_bream", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/threadfin_bream")))
            .register();

    //云斑海猪鱼
    public static final ItemEntry<Item> CHECKERBOARD_WRASSE = REGISTRATE
            .item("checkerboard_wrasse", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/checkerboard_wrasse")))
            .register();
/*
    //海鳗
    public static final ItemEntry<Item> MORAY_EEL = REGISTRATE
            .item("moray_eel", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/moray_eel")))
            .register();
*/

    //鲅鱼
    public static final ItemEntry<Item> SPANISH_MACKEREL = REGISTRATE
            .item("spanish_mackerel", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/spanish_mackerel")))
            .register();

    //条纹鲈鱼
    public static final ItemEntry<Item> STRIPED_BASS = REGISTRATE
            .item("striped_bass", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/striped_bass")))
            .register();

    //鳙鱼
    public static final ItemEntry<Item> BIGHEAD_CARP = REGISTRATE
            .item("bighead_carp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/bighead_carp")))
            .register();

    //鲥鱼
    public static final ItemEntry<Item> CHINESE_SHAD = REGISTRATE
            .item("chinese_shad", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/chinese_shad")))
            .register();

    //秋刀鱼
    public static final ItemEntry<Item> PACIFIC_SAURY = REGISTRATE
            .item("pacific_saury", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/pacific_saury")))
            .register();

    //火鼠鱼
    public static final ItemEntry<Item> FIRE_RAT_FISH = REGISTRATE
            .item("fire_rat_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/fire_rat_fish")))
            .register();

    //冰棘鱼
    public static final ItemEntry<Item> ICETHORN_FISH = REGISTRATE
            .item("icethorn_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/icethorn_fish")))
            .register();

    //蛇鱼
    public static final ItemEntry<Item> SNAKEHEAD_FISH = REGISTRATE
            .item("snakehead_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/snakehead_fish")))
            .register();

    //红鲷鱼
    public static final ItemEntry<Item> RED_SNAPPER = REGISTRATE
            .item("red_snapper", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/red_snapper")))
            .register();

    //魔鬼鱼
    public static final ItemEntry<Item> DEVIL_RAY = REGISTRATE
            .item("devil_ray", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/devil_ray")))
            .register();

    //长颌鲚
    public static final ItemEntry<Item> LONGJAW_COILIA = REGISTRATE
            .item("longjaw_coilia", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/longjaw_coilia")))
            .register();

    //小银鱼
    public static final ItemEntry<Item> SMALL_WHITEBAIT = REGISTRATE
            .item("small_whitebait", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/small_whitebait")))
            .register();

    //胭脂鱼
    public static final ItemEntry<Item> ROSY_BARB = REGISTRATE
            .item("rosy_barb", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/rosy_barb")))
            .register();

    //凤尾鱼
    public static final ItemEntry<Item> ANCHOVY = REGISTRATE
            .item("anchovy", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/anchovy")))
            .register();

    //马面鱼
    public static final ItemEntry<Item> HORSEFACE_FISH = REGISTRATE
            .item("horseface_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/horseface_fish")))
            .register();
/*
    //黄鳝
    public static final ItemEntry<Item> RICE_PADDY_EEL = REGISTRATE
            .item("rice_paddy_eel", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/rice_paddy_eel")))
            .register();
*/

    //鲽鱼
    public static final ItemEntry<Item> FLUKE = REGISTRATE
            .item("fluke", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/fluke")))
            .register();

    //乌青鱼
    public static final ItemEntry<Item> BLACK_AMUR_BREAM = REGISTRATE
            .item("black_amur_bream", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/black_amur_bream")))
            .register();

    //鳊鱼
    public static final ItemEntry<Item> BREAM = REGISTRATE
            .item("bream", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/bream")))
            .register();

    //沙丁鱼
    public static final ItemEntry<Item> SARDINE = REGISTRATE
            .item("sardine", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/sardine")))
            .register();

    //海鲈鱼
    public static final ItemEntry<Item> SEA_BASS = REGISTRATE
            .item("sea_bass", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/sea_bass")))
            .register();

    //红歌鲤
    public static final ItemEntry<Item> RED_SONG_CARP = REGISTRATE
            .item("red_song_carp", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/red_song_carp")))
            .register();

    //巴浪鱼
    public static final ItemEntry<Item> BARRACUDA = REGISTRATE
            .item("barracuda", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/barracuda")))
            .register();

    //三刀鱼
    public static final ItemEntry<Item> THREE_KNIFE_FISH = REGISTRATE
            .item("three_knife_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/three_knife_fish")))
            .register();

    //马头鱼
    public static final ItemEntry<Item> HORSEHEAD_FISH = REGISTRATE
            .item("horsehead_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/horsehead_fish")))
            .register();

    //花英斑
    public static final ItemEntry<Item> FLOWER_SPOTTED_GROUPER = REGISTRATE
            .item("flower_spotted_grouper", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/flower_spotted_grouper")))
            .register();

    //深海鲑鱼
    public static final ItemEntry<Item> DEEP_SEA_SALMON = REGISTRATE
            .item("deep_sea_salmon", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/deep_sea_salmon")))
            .register();

    //蓝飞鱼
    public static final ItemEntry<Item> BLUE_FLYING_FISH = REGISTRATE
            .item("blue_flying_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/blue_flying_fish")))
            .register();
/*
    //飞鱼
    public static final ItemEntry<Item> FLYING_FISH = REGISTRATE
            .item("flying_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/flying_fish")))
            .register();
*/

    //雨鱼
    public static final ItemEntry<Item> RAINFISH = REGISTRATE
            .item("rainfish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/rainfish")))
            .register();

    //白条鱼
    public static final ItemEntry<Item> WHITE_STRIPE_FISH = REGISTRATE
            .item("white_stripe_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/white_stripe_fish")))
            .register();
/*
    //赤魟
    public static final ItemEntry<Item> RED_STINGRAY = REGISTRATE
            .item("red_stingray", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/red_stingray")))
            .register();
*/

    //针鱼
    public static final ItemEntry<Item> NEEDLEFISH = REGISTRATE
            .item("needlefish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/needlefish")))
            .register();

    //龙利鱼
    public static final ItemEntry<Item> SOLE_FISH = REGISTRATE
            .item("sole_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/sole_fish")))
            .register();

    //青花鱼
    public static final ItemEntry<Item> CHUB_MACKEREL = REGISTRATE
            .item("chub_mackerel", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/chub_mackerel")))
            .register();

    //桂鱼
    public static final ItemEntry<Item> CHINESE_PERCH = REGISTRATE
            .item("chinese_perch", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/chinese_perch")))
            .register();
/*
    //带鱼
    public static final ItemEntry<Item> HAIRTAIL = REGISTRATE
            .item("hairtail", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/hairtail")))
            .register();

    //大马哈鱼
    public static final ItemEntry<Item> CHUM_SALMON = REGISTRATE
            .item("chum_salmon", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/chum_salmon")))
            .register();
/*
            //乌翅真鲨
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

            //血红龙
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

            //红海黄金鲽
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

            //紫海刺水母
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

            //皇冠狗头
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

            //花高头龙睛
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

            //线纹海马
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

            //黄尾蓝魔
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

    //秘鲁神仙
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

    //三间火箭
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

    //红剑
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .register();

    //吕宋棘海星
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();

    //红腹食人鲳
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.RARE))
            .register();
*/
/*
    //草鱼王
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    //
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter/fish/")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();
*/
/*
    //
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/")))
            .register();

    */

    //塔斯马尼亚巨型淡水龙虾
    public static final ItemEntry<Item> TASMANIAN_GIANT_FRESHWATER_CRAYFISH = REGISTRATE
            .item("tasmanian_giant_freshwater_crayfish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/tasmanian_giant_freshwater_crayfish")))
            .register(); 

    //小龙虾
    public static final ItemEntry<Item> CRAYFISH = REGISTRATE
            .item("crayfish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/crayfish")))
            .register();

//墨累河白刺鳌虾
    public static final ItemEntry<Item> EUASTACUS_ARMATUS = REGISTRATE
            .item("euastacus_armatus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/euastacus_armatus")))
            .register();

//墨累河白刺鳌虾
    public static final ItemEntry<Item> AUSTRALIA_CHERAX_QUADRICARINATUS = REGISTRATE
            .item("australia_cherax_quadricarinatus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/australia_cherax_quadricarinatus")))
            .register();

//马龙鳌虾
    public static final ItemEntry<Item> MARRON_CRAYFISH = REGISTRATE
            .item("marron_crayfish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/marron_crayfish")))
            .register();    

//东北鳌虾 蝲蛄
    public static final ItemEntry<Item> CAMBAROIDES_DAURICUS = REGISTRATE
            .item("cambaroides_dauricus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/reality/crustacean/cambaroides_dauricus")))
            .register();    
    

/*
    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    //卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();
*/




//龙虾卵5件套
/*
//小龙虾卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("crayfish_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

//塔斯马尼亚巨型淡水龙虾卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("tasmanian_giant_freshwater_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

//墨累河白刺鳌虾卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("euastacus_armatus_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

//马龙鳌虾卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("marron_crayfish_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

//东北鳌虾/蝲蛄卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("cambaroides_dauricus_egg", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

*/
// 小龙虾卵（Procambarus clarkii）
public static final ItemEntry<EggItem> CRAYFISH_EGG = ModItemsEgg.CRAYFISH_EGG;

    // 塔斯马尼亚巨型淡水龙虾卵（Astacopsis gouldi）
    public static final ItemEntry<EggItem> TASMANIAN_GIANT_FRESHWATER_EGG = ModItemsEgg.TASMANIAN_GIANT_FRESHWATER_EGG;

    // 墨累河白刺鳌虾卵（Euastacus armatus）
    public static final ItemEntry<EggItem> EUASTACUS_ARMATUS_EGG = ModItemsEgg.EUASTACUS_ARMATUS_EGG;

    // 马龙鳌虾卵（Marron，Cherax spp.）
    public static final ItemEntry<EggItem> MARRON_CRAYFISH_EGG = ModItemsEgg.MARRON_CRAYFISH_EGG;

    // 东北鳌虾/蝲蛄卵（Cambaroides dauricus）
    public static final ItemEntry<EggItem> CAMBAROIDES_DAURICUS_EGG = ModItemsEgg.CAMBAROIDES_DAURICUS_EGG;


/*
//卵
    public static final ItemEntry<EggItem>  = REGISTRATE
            .item("", p -> new EggItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();
*/
/*
// 春笋   //明日之后蔬菜
public static final ItemEntry<Item> SPRING_BAMBOO_SHOOT = REGISTRATE
        .item("spring_bamboo_shoot", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/spring_bamboo_shoot")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 毛笋
public static final ItemEntry<Item> HAIRY_BAMBOO_SHOOT = REGISTRATE
        .item("hairy_bamboo_shoot", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/hairy_bamboo_shoot")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 糯米
public static final ItemEntry<Item> GLUTINOUS_RICE = REGISTRATE
        .item("glutinous_rice", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/glutinous_rice")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 芝麻
public static final ItemEntry<Item> SESAME_SEED = REGISTRATE
        .item("sesame_seed", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/sesame_seed")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 油菜
public static final ItemEntry<Item> RAPESEED = REGISTRATE
        .item("rapeseed", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/rapeseed")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 菊花
public static final ItemEntry<Item> CHRYSANTHEMUM = REGISTRATE
        .item("chrysanthemum", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/chrysanthemum")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

*/
/*
    // 防风草
public static final ItemEntry<Item> PARSNIP = REGISTRATE
        .item("parsnip", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/parsnip")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

// 雪山药
public static final ItemEntry<Item> SNOW_YAM = REGISTRATE
        .item("snow_yam", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/snow_yam")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 白萝卜
public static final ItemEntry<Item> WHITE_RADISH = REGISTRATE
        .item("white_radish", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/white_radish")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 苋菜
public static final ItemEntry<Item> AMARANTH = REGISTRATE
        .item("amaranth", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/amaranth")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();


*/

    //红叶卷心菜
    public static final ItemEntry<Item> RED_CABBAGE = REGISTRATE
            .item("red_cabbage", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/red_cabbage")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();
/*

// 金皮西葫芦
public static final ItemEntry<Item> GOLDEN_ZUCCHINI = REGISTRATE
        .item("golden_zucchini", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/golden_zucchini")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 洋蓟
public static final ItemEntry<Item> ARTICHOKE = REGISTRATE
        .item("artichoke", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/artichoke")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 小白菜
public static final ItemEntry<Item> BOK_CHOY = REGISTRATE
        .item("bok_choy", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/bok_choy")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 山药
public static final ItemEntry<Item> YAM = REGISTRATE
        .item("yam", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/yam")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 霜瓜
public static final ItemEntry<Item> FROSTED_MELON = REGISTRATE
        .item("frosted_melon", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/frosted_melon")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 甘蓝菜
public static final ItemEntry<Item> CABBAGE = REGISTRATE
        .item("cabbage", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/cabbage")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 冬根
public static final ItemEntry<Item> WINTER_ROOT = REGISTRATE
        .item("winter_root", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/winter_root")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 齐瓜
public static final ItemEntry<Item> QI_GUAN = REGISTRATE
        .item("qi_guan", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/qi_guan")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 野山葵
public static final ItemEntry<Item> WILD_WASABI = REGISTRATE
        .item("wild_wasabi", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/wild_wasabi")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 山葵根
public static final ItemEntry<Item> WASABI_ROOT = REGISTRATE
        .item("wasabi_root", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/wasabi_root")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 胡罗巴
public static final ItemEntry<Item> HOROPPA = REGISTRATE
        .item("horoppa", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/horoppa")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 芥菜
public static final ItemEntry<Item> MUSTARD = REGISTRATE
        .item("mustard", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/mustard")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 牛至
public static final ItemEntry<Item> OREGANO = REGISTRATE
        .item("oregano", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/oregano")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 细香葱
public static final ItemEntry<Item> CHIVES = REGISTRATE
        .item("chives", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/chives")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 秋葵
public static final ItemEntry<Item> OKRA = REGISTRATE
        .item("okra", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/okra")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 百里香
public static final ItemEntry<Item> THYMUS = REGISTRATE
        .item("thymus", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/thymus")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 生菜
public static final ItemEntry<Item> LETTUCE = REGISTRATE
        .item("lettuce", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/lettuce")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 猫薄荷
public static final ItemEntry<Item> CATNIP = REGISTRATE
        .item("catnip", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/catnip")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 月桂叶
public static final ItemEntry<Item> BAY_LEAF = REGISTRATE
        .item("bay_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/bay_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 扁豆
public static final ItemEntry<Item> LENTIL = REGISTRATE
        .item("lentil", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/lentil")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 小茴香
public static final ItemEntry<Item> FENNEL = REGISTRATE
        .item("fennel", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/fennel")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 香菜
public static final ItemEntry<Item> CILANTRO = REGISTRATE
        .item("cilantro", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/cilantro")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 迷迭香
public static final ItemEntry<Item> ROSEMARY = REGISTRATE
        .item("rosemary", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/rosemary")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 莳萝
public static final ItemEntry<Item> DILL = REGISTRATE
        .item("dill", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/dill")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 芹菜
public static final ItemEntry<Item> CELERY = REGISTRATE
        .item("celery", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/celery")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 龙蒿
public static final ItemEntry<Item> TARRAGON = REGISTRATE
        .item("tarragon", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/tarragon")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 豆芽
public static final ItemEntry<Item> BEAN_SPROUT = REGISTRATE
        .item("bean_sprout", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/bean_sprout")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 芦荟
public static final ItemEntry<Item> ALOE = REGISTRATE
        .item("aloe", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/aloe")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 苦艾
public static final ItemEntry<Item> WORMWOOD = REGISTRATE
        .item("wormwood", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/wormwood")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 油菜花
public static final ItemEntry<Item> RAPESEED_FLOWER = REGISTRATE
        .item("rapeseed_flower", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/rapeseed_flower")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 紫苏叶
public static final ItemEntry<Item> PERILLA_LEAF = REGISTRATE
        .item("perilla_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/perilla_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 赤豆
public static final ItemEntry<Item> RED_BEAN = REGISTRATE
        .item("red_bean", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/red_bean")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 罗勒
public static final ItemEntry<Item> BASIL = REGISTRATE
        .item("basil", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/basil")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

*/

    //红洋葱
    public static final ItemEntry<Item> RED_ONION = REGISTRATE
            .item("red_onion", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/red_onion")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    public static final ItemEntry<Item> RED_ONION_SLICE = REGISTRATE
            .item("red_onion_slice", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/red_onion_slice")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.6f)
                    .build()))
            .register();

    //白萝卜
    public static final ItemEntry<Item> WHITE_RADISH = REGISTRATE
            .item("white_raddish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/white_raddish")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.2f)
                    .build()))
            .register();
/*
// 香花薄荷
public static final ItemEntry<Item> SPEARMINT = REGISTRATE
        .item("spearmint", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/spearmint")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 龙舌兰
public static final ItemEntry<Item> AGAVE = REGISTRATE
        .item("agave", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/agave")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 蓝龙舌兰
public static final ItemEntry<Item> BLUE_AGAVE = REGISTRATE
        .item("blue_agave", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/blue_agave")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 红腰豆（有毒）
public static final ItemEntry<Item> RED_KIDNEY_BEAN = REGISTRATE
        .item("red_kidney_bean", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/red_kidney_bean")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 海军豆
public static final ItemEntry<Item> NAVY_BEAN = REGISTRATE
        .item("navy_bean", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/navy_bean")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 紫山药
public static final ItemEntry<Item> PURPLE_YAM = REGISTRATE
        .item("purple_yam", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/purple_yam")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 洋甘草根
public static final ItemEntry<Item> LICORICE_ROOT = REGISTRATE
        .item("licorice_root", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/licorice_root")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 哈瓦那辣椒
public static final ItemEntry<Item> HAVANA_CHILI = REGISTRATE
        .item("havana_chili", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/havana_chili")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 荞麦
public static final ItemEntry<Item> BUCKWHEAT = REGISTRATE
        .item("buckwheat", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/buckwheat")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 芦笋
public static final ItemEntry<Item> ASPARAGUS = REGISTRATE
        .item("asparagus", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/asparagus")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 奶油南瓜
public static final ItemEntry<Item> CREAM_PUMPKIN = REGISTRATE
        .item("cream_pumpkin", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/cream_pumpkin")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 藜麦
public static final ItemEntry<Item> QUINOA = REGISTRATE
        .item("quinoa", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/quinoa")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 肉豆蔻
public static final ItemEntry<Item> NUTMEG = REGISTRATE
        .item("nutmeg", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/nutmeg")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 香草
public static final ItemEntry<Item> VANILLA = REGISTRATE
        .item("vanilla", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/vanilla")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 鼠尾草
public static final ItemEntry<Item> SAGE = REGISTRATE
        .item("sage", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/sage")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
*/
// 人参
public static final ItemEntry<Item> GINSENG = REGISTRATE
        .item("ginseng", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/ginseng")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
        
// 千层树叶
public static final ItemEntry<Item> LAYER_TREE_LEAF = REGISTRATE
        .item("layer_tree_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/layer_tree_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.1f)
                .build()))
        .register();

// 樟树叶
public static final ItemEntry<Item> CAMPHOR_LEAF = REGISTRATE
        .item("camphor_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/camphor_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.1f)
                .build()))
        .register();

// 桉树叶
public static final ItemEntry<Item> EUCALYPTUS_LEAF = REGISTRATE
        .item("eucalyptus_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/eucalyptus_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.1f)
                .build()))
        .register();

// 上古水果（星露谷水果，反正分不清了就这样吧）
public static final ItemEntry<Item> ANCIENT_FRUIT = REGISTRATE
        .item("ancient_fruit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/ancient_fruit")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 宝石甜莓
public static final ItemEntry<Item> GEMBERRY = REGISTRATE
        .item("gemberry", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/gemberry")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 水晶果
public static final ItemEntry<Item> CRYSTAL_FRUIT = REGISTRATE
        .item("crystal_fruit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/crystal_fruit")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 人心果
public static final ItemEntry<Item> HEART_FRUIT = REGISTRATE
        .item("heart_fruit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/heart_fruit")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
/*
// 罗汉橙
public static final ItemEntry<Item> LUOHAN_ORANGE = REGISTRATE
        .item("luohan_orange", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/luohan_orange")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 芭蕉
public static final ItemEntry<Item> BANANA = REGISTRATE
        .item("banana", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/banana")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 美洲大树莓
public static final ItemEntry<Item> AMERICAN_RASPBERRY = REGISTRATE
        .item("american_raspberry", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/american_raspberry")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
*/
// 菇娘果
public static final ItemEntry<Item> MUSHROOM_BERRY = REGISTRATE
        .item("mushroom_berry", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/mushroom_berry")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
/*
// 面包果
public static final ItemEntry<Item> BREADFRUIT = REGISTRATE
        .item("breadfruit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/breadfruit")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 香味浆果
public static final ItemEntry<Item> FRAGRANT_BERRY = REGISTRATE
        .item("fragrant_berry", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/fragrant_berry")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 香瓜
public static final ItemEntry<Item> MUSK_MELON = REGISTRATE
        .item("musk_melon", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/musk_melon")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 金丝甜瓜
public static final ItemEntry<Item> GOLDEN_MELON = REGISTRATE
        .item("golden_melon", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/golden_melon")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
*/


// 油桃
public static final ItemEntry<Item> NECTARINE = REGISTRATE
        .item("nectarine", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/nectarine")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 批量注册
public static final ItemEntry<Item> AGLIO_ROSSO_DI_SULMONA = REGISTRATE
        .item("aglio_rosso_di_sulmona", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/aglio_rosso_di_sulmona")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> AGLIO_ROSSO_DI_SULMONA_CLOVES = REGISTRATE
        .item("aglio_rosso_di_sulmona_cloves", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/aglio_rosso_di_sulmona_cloves")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> AGLIO_BIANCO_POLESANO = REGISTRATE
        .item("aglio_bianco_polesano", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/aglio_bianco_polesano")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> AGLIO_BIANCO_POLESANO_CLOVES = REGISTRATE
        .item("aglio_bianco_polesano_cloves", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/aglio_bianco_polesano_cloves")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> ARTICHOKES = REGISTRATE
        .item("artichokes", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/artichokes")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> BEEFSTEAK_TOMATO = REGISTRATE
        .listItem("beefsteak_tomato", Item::new)
        .tooltips(
            "§7§oEnormous tomato!"
        )
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/beefsteak_tomato")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> BEEFSTEAK_TOMATO_SLICE = REGISTRATE
        .item("beefsteak_tomato_slice", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/beefsteak_tomato_slice")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> BUTTERHEAD_LETTUCE = REGISTRATE
        .item("butterhead_lettuce", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/butterhead_lettuce")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> BUTTERHEAD_LETTUCE_LEAF = REGISTRATE
        .item("butterhead_lettuce_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/butterhead_lettuce_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> CAFONA_APRICOT = REGISTRATE
        .item("cafona_apricot", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/cafona_apricot")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> CETRIOLO_IUNGO = REGISTRATE
        .item("cetriolo_iungo", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/cetriolo_iungo")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> CEYLON_CINNAMON = REGISTRATE
        .item("ceylon_cinnamon", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/ceylon_cinnamon")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> CINNAMON_FRUIT = REGISTRATE
        .item("cinnamon_fruit", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/cinnamon_fruit")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> CIPOLLA_DI_CERTALDO = REGISTRATE
        .item("cipolla_di_certaldo", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/cipolla_di_certaldo")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> CORATION_OLIVE = REGISTRATE
        .item("coration_olive", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/coration_olive")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> OLIVE_SLICE = REGISTRATE
        .item("olive_slice", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/olive_slice")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.6f)
                .build()))
        .register();

public static final ItemEntry<Item> DEKOPON_ORANGE = REGISTRATE
        .item("dekopon_orange", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/dekopon_orange")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> FIANO_WHITE_GRAPE = REGISTRATE
        .item("fiano_white_grape", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/fiano_white_grape")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> GENOVESE_BASIL_LEAF = REGISTRATE
        .item("genovese_basil_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/genovese_basil_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> GROS_MICHEL_BANANA = REGISTRATE
        .item("gros_michel_banana", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/gros_michel_banana")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> HORSERADISH = REGISTRATE
        .item("horseradish", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/horseradish")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> ITALIAN_LONG_EGGPLANT = REGISTRATE
        .item("italian_long_eggplant", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/italian_long_eggplant")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> KENT_MANGO = REGISTRATE
        .item("kent_mango", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/kent_mango")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> MAGNUM_HOP = REGISTRATE
        .item("magnum_hop", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/magnum_hop")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> NEBBIOLO_GRAPE = REGISTRATE
        .item("nebbiolo_grape", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/nebbiolo_grape")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> OREGANO_LEAF = REGISTRATE
        .item("oregano_leaf", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/oregano_leaf")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> SWEET_CORN = REGISTRATE
        .item("sweet_corn", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/sweet_corn")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

public static final ItemEntry<Item> LONG_GRAIN_RICE = REGISTRATE
            .item("long_grain_rice", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/long_grain_rice")))
            .register();

public static final ItemEntry<Item> DWARF_COCONUT_FRUIT = REGISTRATE
            .listItem("dwarf_coconut_fruit", Item::new)
            .tooltips(
            "§7§oDwarf coconut is a dwarf variety relative to the tall coconut."
        )
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/dwarf_coconut_fruit")))
            .register();

public static final ItemEntry<Item> GIZA_COTTON = REGISTRATE
            .item("giza_cotton", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/giza_cotton")))
            .register();

/*

// 沙棘果
public static final ItemEntry<Item> SEA_BUCKTHORN = REGISTRATE
        .item("sea_buckthorn", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/sea_buckthorn")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 龙眼
public static final ItemEntry<Item> LONGAN = REGISTRATE
        .item("longan", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/longan")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 桑葚
public static final ItemEntry<Item> MULBERRY = REGISTRATE
        .item("mulberry", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/mulberry")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 冬枣
public static final ItemEntry<Item> WINTER_JUJUBE = REGISTRATE
        .item("winter_jujube", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/winter_jujube")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 84西瓜（明日之后 水果 真的很少）
public static final ItemEntry<Item> WATERMELON_84 = REGISTRATE
        .item("watermelon_84", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/watermelon_84")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
*/
/*
//空模板
public static final ItemEntry<Item>  = REGISTRATE
        .item("", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();
*/
//红菠萝
public static final ItemEntry<Item> RED_PINEAPPLE = REGISTRATE
        .item("red_pineapple", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/pineapple/red_pineapple")))
        .register();
/*
public static final ItemEntry<Item>  = REGISTRATE
        .item("", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/re/pineapple/")))
        .register();

*/
   //台湾菠萝
   public static final ItemEntry<Item> TAIWAN_GREEN_PINEAPPLE = REGISTRATE
        .item("taiwan_green_pineapple", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/pineapple/taiwan_green_pineapple")))
        .register();

    //香水凤梨
    public static final ItemEntry<Item> PERFUME_PINEAPPLE = REGISTRATE
        .item("perfume_pineapple", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/pineapple/perfume_pineapple")))
        .register();

    //水椰
    public static final ItemEntry<Item> NYPA = REGISTRATE
            .item("nypa", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/nypa")))
            .register();
            
   //巧克力柿
   public static final ItemEntry<Item> CHOCOLAT_PERSIMMON = REGISTRATE
        .item("chocolat_persimmon", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/persimmon/chocolat_persimmon")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//凛冬草莓
public static final ItemEntry<Item> HARSH_WINTER_STRAWBERRY = REGISTRATE
        .item("harsh_winter_strawberry", Item::new)
        .properties(p -> p.rarity(Rarity.EPIC))
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/high_crop/starry/harsh_winter_strawberry")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//黄桃
public static final ItemEntry<Item> YELLOW_PEACH = REGISTRATE
        .item("yellow_peach", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/yellow_peach")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//南洋红香蕉串
public static final ItemEntry<Item> RED_DACCA_BANANA_BUNCH = REGISTRATE
        .item("red_dacca_banana_bunch", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/banana/red_dacca_banana_bunch")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//南洋红香蕉
public static final ItemEntry<Item> RED_DACCA_BANANA = REGISTRATE
        .item("red_dacca_banana", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/banana/red_dacca_banana")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//爪哇蓝香蕉串
public static final ItemEntry<Item> BLUE_JAVA_BANANA_BUNCH = REGISTRATE
        .item("blue_java_banana_bunch", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/banana/blue_java_banana_bunch")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//爪哇蓝香蕉
public static final ItemEntry<Item> BLUE_JAVA_BANANA = REGISTRATE
        .item("blue_java_banana", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/banana/blue_java_banana")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//芭蕉串
public static final ItemEntry<Item> PLANTAIN_BUNCH = REGISTRATE
        .item("plantain_bunch", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/banana/plantain_bunch")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//芭蕉
public static final ItemEntry<Item> PLANTAIN = REGISTRATE
        .item("plantain", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/banana/plantain")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(2)
                .saturationMod(1.2f)
                .build()))
        .register();

//槟榔
public static final ItemEntry<Item> BETEL_NUT = REGISTRATE
        .item("betel_nut", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/betel_nut")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.1f)
                .build()))
        .register();

    // 草菇
    public static final ItemEntry<Item> STRAW_MUSHROOM = REGISTRATE
            .item("straw_mushroom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/mushroom/straw_mushroom")))
            .register();

    // 海蘑菇
    public static final ItemEntry<Item> SEA_MUSHROOM = REGISTRATE
            .item("sea_mushroom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/mushroom/sea_mushroom")))
            .register();

    // 洞穴菇
    public static final ItemEntry<Item> CAVE_MUSHROOM = REGISTRATE
            .item("cave_mushroom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/mushroom/cave_mushroom")))
            .register();

    // 草菇菌落
    public static final ItemEntry<Item> STRAW_MUSHROOM_COLONY = REGISTRATE
            .item("straw_mushroom_colony", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/colony/straw_mushroom_colony")))
            .register();

    // 海蘑菇菌落
    public static final ItemEntry<Item> SEA_MUSHROOM_COLONY = REGISTRATE
            .item("sea_mushroom_colony", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/colony/sea_mushroom_colony")))
            .register();

    // 洞穴菇菌落
    public static final ItemEntry<Item> CAVE_MUSHROOM_COLONY = REGISTRATE
            .item("cave_mushroom_colony", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/colony/cave_mushroom_colony")))
            .register();

    //红叶卷心菜叶
    public static final ItemEntry<Item> RED_CABBAGE_LEAF = REGISTRATE
            .item("red_cabbage_leaf", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cutting/red_cabbage_leaf")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //红菠萝切块
    public static final ItemEntry<Item> RED_PINEAPPLE_SLICE = REGISTRATE
            .item("red_pineapple_slice", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cutting/red_pineapple_slice")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

/*
    //
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

*/
// 煎鹅蛋
    public static final ItemEntry<Item> COOK_GOOSE_EGG =REGISTRATE.item("cook_goose_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_goose_egg")))
            .register();

    // 煎鸭蛋
    public static final ItemEntry<Item> COOK_DUCK_EGG = REGISTRATE.item("cook_duck_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_duck_egg")))
            .register();

    // 煎火鸡蛋
    public static final ItemEntry<Item> COOK_TURKEY_EGG = REGISTRATE.item("cook_turkey_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_turkey_egg")))
            .register();

// 煎黑金蛋
 public static final ItemEntry<Item> COOK_BLACK_GOOSE_EGG = REGISTRATE.item("cook_black_goose_egg", Item::new)
         .properties(p -> p.food(new FoodProperties.Builder()
                 .nutrition(2)
                 .saturationMod(0.8f)
                 .build()))
         .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_black_goose_egg")))
         .properties(p -> p.rarity(Rarity.EPIC))
         .register();

// 煎白玉蛋
 public static final ItemEntry<Item> COOK_WHITE_GOOSE_EGG = REGISTRATE.item("cook_white_goose_egg", Item::new)
         .properties(p -> p.food(new FoodProperties.Builder()
                 .nutrition(2)
                 .saturationMod(0.8f)
                 .build()))
         .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_white_goose_egg")))
         .properties(p -> p.rarity(Rarity.EPIC))
         .register();

    // 煎tortoise乌龟蛋
    public static final ItemEntry<Item> COOK_TORTOISE_EGG = REGISTRATE.item("cook_tortoise_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_tortoise_egg")))
            .register();

    // 煎alligator短吻鳄
    public static final ItemEntry<Item> COOK_ALLIGATOR_EGG = REGISTRATE.item("cook_alligator_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_alligator_egg")))
            .register();

    // 煎austro南方盗龙蛋
    public static final ItemEntry<Item> COOK_ASTRO_EGG = REGISTRATE.item("cook_astro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_astro_egg")))
            .register();

    // 煎barina巴里纳斯鳄蛋
    public static final ItemEntry<Item> COOK_BARINA_EGG = REGISTRATE.item("cook_barina_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_barina_egg")))
            .register();

    // 煎brachi蜿龙蛋
    public static final ItemEntry<Item> COOK_BRACHI_EGG = REGISTRATE.item("cook_brachi_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_brachi_egg")))
            .register();

    // 煎箭炮猎龙蛋
    public static final ItemEntry<Item> COOK_HWACHA_EGG = REGISTRATE.item("cook_hwacha_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_hwacha_egg")))
            .register();

    // 煎coty杯鼻龙蛋
    public static final ItemEntry<Item> COOK_COTY_EGG = REGISTRATE.item("cook_coty_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_coty_egg")))
            .register();

    // 煎kentro肯式龙蛋
    public static final ItemEntry<Item> COOK_KENTRO_EGG = REGISTRATE.item("cook_kentro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_kentro_egg")))
            .register();

    // 煎majunga玛君龙蛋
    public static final ItemEntry<Item> COOK_MAJUNGA_EGG = REGISTRATE.item("cook_majunga_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_majunga_egg")))
            .register();

    // 煎pachy肿头龙蛋
    public static final ItemEntry<Item> COOK_PACHY_EGG = REGISTRATE.item("cook_pachy_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_pachy_egg")))
            .register();

    // 煎raptro伶盗龙蛋
    public static final ItemEntry<Item> COOK_RAPTRO_EGG = REGISTRATE.item("cook_raptro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_raptro_egg")))
            .register();

    // 煎rex霸王龙蛋
    public static final ItemEntry<Item> COOK_REX_EGG = REGISTRATE.item("cook_rex_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_rex_egg")))
            .register();

    // 煎megala古巨蜥蛋
    public static final ItemEntry<Item> COOK_MEGALA_EGG = REGISTRATE.item("cook_megala_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_megala_egg")))
            .register();

    // 煎antarcto南极甲龙蛋
    public static final ItemEntry<Item> COOK_ANTARCTO_EGG = REGISTRATE.item("cook_antarcto_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_antarcto_egg")))
            .register();

    // 煎trike三角龙蛋
    public static final ItemEntry<Item> COOK_TRIKE_EGG = REGISTRATE.item("cook_trike_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_trike_egg")))
            .register();

    // 煎anuro蛙嘴龙蛋
    public static final ItemEntry<Item> COOK_ANURO_EGG = REGISTRATE.item("cook_anuro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_anuro_egg")))
            .register();

    // 煎ulugh乌鲁伯戈龙蛋
    public static final ItemEntry<Item> COOK_ULUGH_EGG = REGISTRATE.item("cook_ulugh_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_ulugh_egg")))
            .register();

    // 煎talpanas鼹鸭蛋
    public static final ItemEntry<Item> COOK_TALPANAS_EGG = REGISTRATE.item("cook_talpanas_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_talpanas_egg")))
            .register();
        
    // 煎grottoceratops_amlette蛋
    public static final ItemEntry<Item> GROTTOSCERATOPS_AMLETTE = REGISTRATE
    .item("grottoceratops_amlette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/grottoceratops_amlette")))
            .register();

     // 煎蛋
    public static final ItemEntry<Item> RELICHEIRUS_AMLETTE = REGISTRATE
    .item("relicheirus_amlette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/relicheirus_amlette")))
            .register();

    // 煎蛋
    public static final ItemEntry<Item> SUBTERRANODON_AMLETTEX = REGISTRATE
    .item("subterranodon_amlettex", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/subterranodon_amlettex")))
            .register();

// 煎蛋
    public static final ItemEntry<Item> TREMORSAURUS_AMLETTE = REGISTRATE
    .item("tremorsaurus_amlette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/tremorsaurus_amlette")))
            .register();

// 煎蛋
    public static final ItemEntry<Item> TREMORZILLA_AMLETTE_ANIM = REGISTRATE
    .item("tremorzilla_amlette_anim", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/tremorzilla_amlette_anim")))
            .register();           

// 煎蛋
    public static final ItemEntry<Item> VALLUMRAPTOR_AMLETTE = REGISTRATE
    .item("vallumraptor_amlette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/vallumraptor_amlette")))
            .register();    

// 煎蛋
    public static final ItemEntry<Item> ATLATITAN_AMLETTE = REGISTRATE
    .item("atlatitan_amlette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/atlatitan_amlette")))
            .register();    

// 煎永恒胚胎
    public static final ItemEntry<Item> AMMLET_FROM_EMBRYO = REGISTRATE
    .item("ammlet_from_embryo", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/ammlet_from_embryo")))
            .register();   


    // 蟹肉
    public static final ItemEntry<Item> CRAB_MEAT = REGISTRATE
            .item("crab_meat", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/meat/crab_meat")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            /*
            .recipe((ctx, provider) -> {
                CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(JONAH_CRAB), Ingredient.of(ForgeTags.TOOLS_KNIVES), ctx.get(), 2)
                        .addResultWithChance(ctx.get(), 0.5f,1)
                        .addResultWithChance(JONAH_CRAB_EGG.get(), 0.5f,1)
                        .build(provider, ctx.getId().withPrefix("cutting/"));
            })
            */
            .register();

    // 和牛肉
    public static final ItemEntry<Item> WAGYU_BEEF = REGISTRATE
            .item("wagyu_beef", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/meat/wagyu_beef")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    // 砗磲肉
    public static final ItemEntry<Item> GIANT_CLAM_MEAT = REGISTRATE
            .item("giant_clam_meat", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/meat/giant_clam_meat")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .register();



    //腊八蒜
    public static final ItemEntry<Item> LABA_GARLIC = REGISTRATE
            .item("laba_garlic", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/laba_garlic")))
            .register();

    //俄罗斯黑面包
    public static final ItemEntry<Item> RUSSIA_BLACK_BREAD = REGISTRATE
            .item("russia_black_bread", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/russia_black_bread")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //黑麦汉堡
    public static final ItemEntry<Item> BLACK_BURGER = REGISTRATE
            .item("black_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/black_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //黑麦汉堡底
    public static final ItemEntry<Item> BLACK_BURGER_BOTTOM = REGISTRATE
            .item("black_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/black_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //黑麦汉堡顶
    public static final ItemEntry<Item> BLACK_BURGER_TOP = REGISTRATE
            .item("black_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/black_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //大麦汉堡
    public static final ItemEntry<Item> BARLEY_BURGER = REGISTRATE
            .item("barley_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/barley_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //大麦汉堡底
    public static final ItemEntry<Item> BARLEY_BURGER_BOTTOM = REGISTRATE
            .item("barley_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/barley_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //大麦汉堡顶
    public static final ItemEntry<Item> BARLEY_BURGER_TOP = REGISTRATE
            .item("barley_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/barley_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

//木薯汉堡
    public static final ItemEntry<Item> CASSAVA_BURGER = REGISTRATE
            .item("cassava_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/cassava_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //木薯汉堡底
    public static final ItemEntry<Item> CASSAVA_BURGER_BOTTOM = REGISTRATE
            .item("cassava_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/cassava_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //木薯汉堡顶
    public static final ItemEntry<Item> CASSAVA_BURGER_TOP = REGISTRATE
            .item("cassava_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/cassava_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //玉米汉堡
    public static final ItemEntry<Item> CORN_BURGER = REGISTRATE
            .item("corn_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/corn_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //玉米汉堡底
    public static final ItemEntry<Item> CORN_BURGER_BOTTOM = REGISTRATE
            .item("corn_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/corn_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //玉米汉堡顶
    public static final ItemEntry<Item> CORN_BURGER_TOP = REGISTRATE
            .item("corn_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/corn_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //进化玉米汉堡
    public static final ItemEntry<Item> EVOLUTCORN_BURGER = REGISTRATE
            .item("evolutcorn_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/evolutcorn_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //进化玉米汉堡底
    public static final ItemEntry<Item> EVOLUTCORN_BURGER_BOTTOM = REGISTRATE
            .item("evolutcorn_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/evolutcorn_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //进化玉米汉堡顶
    public static final ItemEntry<Item> EVOLUTCORN_BURGER_TOP = REGISTRATE
            .item("evolutcorn_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/evolutcorn_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //瓦斯麦汉堡底
    public static final ItemEntry<Item> KWAT_WHEAT_BURGER_BOTTOM = REGISTRATE
            .item("kwat_wheat_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/kwat_wheat_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //瓦斯麦汉堡
    public static final ItemEntry<Item> KWAT_WHEAT_BURGER = REGISTRATE
            .item("kwat_wheat_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/kwat_wheat_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //瓦斯麦汉堡顶
    public static final ItemEntry<Item> KWAT_WHEAT_BURGER_TOP = REGISTRATE
            .item("kwat_wheat_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/kwat_wheat_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

/*
    //
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //
    public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();
*/

    //黑橡子
    //黑橡子汉堡
    public static final ItemEntry<Item> BLACK_OAK_BURGER = REGISTRATE
            .item("black_oak_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/black_oak_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //黑橡子
    //黑橡子汉堡底
    public static final ItemEntry<Item> BLACK_OAK_BURGER_BOTTOM = REGISTRATE
            .item("black_oak_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/black_oak_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //黑橡子汉堡顶
    public static final ItemEntry<Item> BLACK_OAK_BURGER_TOP = REGISTRATE
            .item("black_oak_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/black_oak_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //橡子汉堡
    public static final ItemEntry<Item> OAK_BURGER = REGISTRATE
            .item("oak_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/oak_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //橡子汉堡顶
    public static final ItemEntry<Item> OAK_BURGER_TOP = REGISTRATE
            .item("oak_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/oak_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //橡子汉堡底
    public static final ItemEntry<Item> OAK_BURGER_BOTTOM = REGISTRATE
            .item("oak_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/oak_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

   //红薯汉堡
    public static final ItemEntry<Item> SWEET_POTATO_BURGER = REGISTRATE
            .item("sweet_potato_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/sweet_potato_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //红薯汉堡底
    public static final ItemEntry<Item> SWEET_POTATO_BURGER_BOTTOM = REGISTRATE
            .item("sweet_potato_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/sweet_potato_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //红薯汉堡顶
    public static final ItemEntry<Item> SWEET_POTATO_BURGER_TOP = REGISTRATE
            .item("sweet_potato_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/sweet_potato_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

   //南瓜汉堡
    public static final ItemEntry<Item> PUMPKIN_BURGER = REGISTRATE
            .item("pumpkin_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/pumpkin_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //南瓜汉堡底
    public static final ItemEntry<Item> PUMPKIN_BURGER_BOTTOM = REGISTRATE
            .item("pumpkin_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/pumpkin_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //南瓜汉堡顶
    public static final ItemEntry<Item> PUMPKIN_BURGER_TOP = REGISTRATE
            .item("pumpkin_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/pumpkin_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

   //坚果汉堡
    public static final ItemEntry<Item> NUT_BURGER = REGISTRATE
            .item("nut_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/nut_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //坚果汉堡底
    public static final ItemEntry<Item> NUT_BURGER_BOTTOM = REGISTRATE
            .item("nut_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/nut_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //坚果汉堡顶
    public static final ItemEntry<Item> NUT_BURGER_TOP = REGISTRATE
            .item("nut_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/nut_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //恶魂汉堡
    public static final ItemEntry<Item> GHAST_BURGER = REGISTRATE
            .item("ghast_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/ghast_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //恶魂汉堡底
    public static final ItemEntry<Item> GHAST_BURGER_BOTTOM = REGISTRATE
            .item("ghast_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/ghast_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //恶魂汉堡顶
    public static final ItemEntry<Item> GHAST_BURGER_TOP = REGISTRATE
            .item("ghast_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/ghast_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //香蕉汉堡
    public static final ItemEntry<Item> BANANA_BURGER = REGISTRATE
            .item("banana_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/banana_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //香蕉汉堡底
    public static final ItemEntry<Item> BANANA_BURGER_BOTTOM = REGISTRATE
            .item("banana_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/banana_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //香蕉汉堡顶
    public static final ItemEntry<Item> BANANA_BURGER_TOP = REGISTRATE
            .item("banana_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/banana_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();


    //马铃薯汉堡
    public static final ItemEntry<Item> POTATO_BURGER = REGISTRATE
            .item("potato_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/potato_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //马铃薯汉堡底
    public static final ItemEntry<Item> POTATO_BURGER_BOTTOM = REGISTRATE
            .item("potato_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/potato_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //马铃薯汉堡顶
    public static final ItemEntry<Item> POTATO_BURGER_TOP = REGISTRATE
            .item("potato_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/potato_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();



    //晶格马铃薯汉堡
    public static final ItemEntry<Item> DIAMOND_LATTICE_POTATO_BURGER = REGISTRATE
            .item("diamond_lattice_potato_burger", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/diamond_lattice_potato_burger")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    //晶格马铃薯汉堡底
    public static final ItemEntry<Item> DIAMOND_LATTICE_POTATO_BURGER_BOTTOM = REGISTRATE
            .item("diamond_lattice_potato_burger_bottom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/diamond_lattice_potato_burger_bottom")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

     //晶格马铃薯汉堡顶
    public static final ItemEntry<Item> DIAMOND_LATTICE_POTATO_BURGER_TOP = REGISTRATE
            .item("diamond_lattice_potato_burger_top", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bread/diamond_lattice_potato_burger_top")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();


   //简并态汉堡
    public static final ItemEntry<Item> NEUTRONIUM_BURGER = REGISTRATE
            .item("neutronium_burger", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/bread/neutronium_burger"))
                    .customLoader(HaloModelBuilder::new))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(20)
                    .saturationMod(7.2f)
                    .build()))
            .register();

   //简并态汉堡底
    public static final ItemEntry<Item> NEUTRONIUM_BURGER_BOTTOM = REGISTRATE
            .item("neutronium_burger_bottom", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/bread/neutronium_burger_bottom"))
                    .customLoader(HaloModelBuilder::new))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    //简并态汉堡顶
    public static final ItemEntry<Item> NEUTRONIUM_BURGER_TOP = REGISTRATE
            .item("neutronium_burger_top", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/bread/neutronium_burger_top"))
                    .customLoader(HaloModelBuilder::new))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    //中子素黄油
    public static final ItemEntry<Item> NEUTRONIUM_BUTTER = REGISTRATE
            .item("neutronium_butter", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/neutronium_butter"))
                    .customLoader(HaloModelBuilder::new))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    //黑麦面团
    public static final ItemEntry<Item> RYE_DOUGH = REGISTRATE
            .item("rye_dough", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/dough/rye_dough")))
            .register();

    //大麦面团
    public static final ItemEntry<Item> BARLEY_DOUGH = REGISTRATE
            .item("barley_dough", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/dough/barley_dough")))
            .register();

    // 林业员茶饮
    public static final ItemEntry<DrinkItem> FORESTERS_TEA = REGISTRATE
            .item("foresters_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/foresters_tea")))
    .register();

    // 格雷科技员工茶饮
    public static final ItemEntry<DrinkItem> GREGTECH_EMPLOYEE_TEA = REGISTRATE
            .item("gregtech_employee_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/gregtech_employee_tea")))
    .register();

    // 实业家茶饮
    public static final ItemEntry<DrinkItem> INDUSTRIALIST_TEA = REGISTRATE
            .item("industrialist_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/industrialist_tea")))
    .register();

    // 高能物理学家茶饮
    public static final ItemEntry<DrinkItem> HIGH_ENERGY_PHYSICIST_TEA = REGISTRATE
            .item("high_energy_physicist_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/high_energy_physicist_tea")))
    .register();

    // 核工程师茶饮
    public static final ItemEntry<DrinkItem> NUCLEAR_ENGINEER_TEA = REGISTRATE
            .item("nuclear_engineer_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/nuclear_engineer_tea")))
    .register();

    // 热力工程师茶饮
    public static final ItemEntry<DrinkItem> THERMAL_ENGINEER_TEA = REGISTRATE
            .item("thermal_engineer_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/thermal_engineer_tea")))
    .register();

    // ECO实验室研究员茶饮
    public static final ItemEntry<DrinkItem> ECO_LAB_RESEARCHER_TEA = REGISTRATE
            .item("eco_lab_researcher_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/eco_lab_researcher_tea")))
    .register();

    // 工匠茶饮
    public static final ItemEntry<DrinkItem> TINKERS_TEA = REGISTRATE
            .item("tinkers_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/tinkers_tea")))
    .register();

    // 工程师茶饮
    public static final ItemEntry<DrinkItem> ENGINEERS_TEA = REGISTRATE
            .item("engineers_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/theme_tea/engineers_tea")))
    .register();

    // 水母苏打饮
    public static final ItemEntry<DrinkItem> JELLYFISH_SODA = REGISTRATE
            .item("jellyfish_soda", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider
                            .modLoc("item/food/drink/jellyfish_soda")))
            .register();
           
    // 树星茶饮
    public static final ItemEntry<DrinkItem> TREESTAR_TEA = REGISTRATE
            .item("treestar_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider
                            .modLoc("item/food/drink/treestar_tea")))
            .register();

    // 三叶虾意面
    public static final ItemEntry<BowlReturnFoodItem> PASTA_WITH_TRILOCARIS_TAIL = REGISTRATE
            .item("pasta_with_trilocaris_tail", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/pasta_with_trilocaris_tail")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(15)
                    .saturationMod(3.2f)
                    .build()))
            .register();


    // 三脚鱼汤
    public static final ItemEntry<BowlReturnFoodItem> TRIPODFISH_SOUP = REGISTRATE
            .item("tripodfish_soup", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/tripodfish_soup")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    // 铀汤
    public static final ItemEntry<BowlReturnFoodItem> URANIUM_SOUP = REGISTRATE
            .item("uranium_soup", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/uranium_soup")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> CHICKEN_CURRY = REGISTRATE
            .item("chicken_curry", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/chicken_curry")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> COD_DELUXE = REGISTRATE
            .item("cod_deluxe", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/cod_deluxe")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<Item> COOKED_MUTTON_RACK = REGISTRATE
            .item("cooked_mutton_rack", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/cooked_mutton_rack")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(1.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> HEARTY_LUNCH = REGISTRATE
            .item("hearty_lunch", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/hearty_lunch")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(12)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> MUSHROOM_POT_PIE = REGISTRATE
            .item("mushroom_pot_pie", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/mushroom_pot_pie")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> OMURICE = REGISTRATE
            .item("omurice", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/omurice")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PASTA_WITH_MUSHROOM_SAUCE = REGISTRATE
            .item("pasta_with_mushroom_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/pasta_with_mushroom_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> POTATO_SOUP = REGISTRATE
            .item("potato_soup", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/potato_soup")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PUFFERFISH_BROTH = REGISTRATE
            .item("pufferfish_broth", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/pufferfish_broth")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<Item> RAW_MUTTON_RACK = REGISTRATE
            .item("raw_mutton_rack", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/raw_mutton_rack")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> RED_SOUP = REGISTRATE
            .item("red_soup", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/red_soup")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> RICE_PUDDING = REGISTRATE
            .item("rice_pudding", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/rice_pudding")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> ROASTED_MUTTON_RACK = REGISTRATE
            .item("roasted_mutton_rack", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/roasted_mutton_rack")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(12)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<DrinkItem> SWEET_BERRY_CUSTARD = REGISTRATE
            .item("sweet_berry_custard", DrinkItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/sweet_berry_custard")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> TOMATO_EGG_SOUP = REGISTRATE
            .item("tomato_egg_soup", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/dish/tomato_egg_soup")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();
//酱料类 返回碗
    public static final ItemEntry<BowlReturnFoodItem> SOUR_CREAM = REGISTRATE
            .item("sour_cream", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/food/sauce/sour_cream")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> ANCIENT_SAUCE = REGISTRATE
            .item("ancient_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/ancient_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> BBQ_SAUCE = REGISTRATE
            .item("bbq_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/bbq_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> BLAZE_SAUCE = REGISTRATE
            .item("blaze_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/blaze_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> LIME_SAUCE = REGISTRATE
            .item("lime_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/lime_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> MAYO_SAUCE = REGISTRATE
            .item("mayo_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/mayo_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PEPPER_SAUCE = REGISTRATE
            .item("pepper_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pepper_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PIZZA_SAUCE_ALFREDO = REGISTRATE
            .item("pizza_sauce_alfredo", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pizza_sauce_alfredo")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PIZZA_SAUCE_BLAZE = REGISTRATE
            .item("pizza_sauce_blaze", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pizza_sauce_blaze")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PIZZA_SAUCE_SEAFOOD = REGISTRATE
            .item("pizza_sauce_seafood", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pizza_sauce_seafood")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PIZZA_SAUCE_TOMATO = REGISTRATE
            .item("pizza_sauce_tomato", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pizza_sauce_tomato")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> PIZZA_SAUCE_TORCH = REGISTRATE
            .item("pizza_sauce_torch", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pizza_sauce_torch")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> POMEGRANATE_SAUCE = REGISTRATE
            .item("pomegranate_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/pomegranate_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> SEAFOOD_SAUCE = REGISTRATE
            .item("seafood_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/seafood_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> URCHIN_SAUCE = REGISTRATE
            .item("urchin_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/urchin_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> BECHAMEL_SAUCE = REGISTRATE
            .item("bechamel_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/bechamel_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> ESPAGNOLE_SAUCE = REGISTRATE
            .item("espagnole_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/espagnole_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> FRENCH_TOMATO_SAUCE = REGISTRATE
            .item("french_tomato_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/french_tomato_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> HOLLANDAISE_SAUCE = REGISTRATE
            .item("hollandaise_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/hollandaise_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<BowlReturnFoodItem> VELOUTE_SAUCE = REGISTRATE
            .item("veloute_sauce", BowlReturnFoodItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/veloute_sauce")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(3.2f)
                    .build()))
            .register();

    public static final ItemEntry<Item> TOMATO_PASTE = REGISTRATE
            .item("tomato_paste", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/sauce/tomato_paste")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(3.2f)
                    .build()))
            .register();

// Italian Delight pizzas
    // 1) RAW whole pizzas (unbaked)
    public static final ItemEntry<Item> PIZZA_PROSCIUTTO_RAW = REGISTRATE
            .item("pizza_prosciutto_raw", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/raw_pizza_al_prosciutto")))
            .register();

    public static final ItemEntry<Item> PIZZA_PROSCIUTTO_SLICE = REGISTRATE
            .item("pizza_prosciutto_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/ham_pizza_slice")))
            .register();

    public static final ItemEntry<Item> PIZZA_FUNGHI_RAW = REGISTRATE
            .item("pizza_funghi_raw", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/raw_mushroom_pizza")))
            .register();

    public static final ItemEntry<Item> PIZZA_FUNGHI_SLICE = REGISTRATE
            .item("pizza_funghi_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/mushroom_pizza_slice")))
            .register();

    public static final ItemEntry<Item> PIZZA_MARGHERITA_RAW = REGISTRATE
            .item("pizza_margherita_raw", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/raw_margherita_pizza")))
            .register();

    public static final ItemEntry<Item> PIZZA_MARGHERITA_SLICE = REGISTRATE
            .item("pizza_margherita_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/margherita_pizza_slice")))
            .register();

    public static final ItemEntry<Item> PIZZA_DANTE_RAW = REGISTRATE
            .item("pizza_dante_raw", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/raw_dantes_special_pizza")))
            .register();

    public static final ItemEntry<Item> PIZZA_DANTE_SLICE = REGISTRATE
            .item("pizza_dante_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(0.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/dantes_special_pizza_slice")))
            .register();

    public static final ItemEntry<Item> PIZZA_DIAVOLA_RAW = REGISTRATE
            .item("pizza_diavola_raw", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/raw_diavola_pizza")))
            .register();

    public static final ItemEntry<Item> PIZZA_DIAVOLA_SLICE = REGISTRATE
            .item("pizza_diavola_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/pizza_diavola_slice")))
            .register();
//披萨结束
    public static final ItemEntry<Item> BLACK_TEA_CAKE_SLICE = REGISTRATE
            .item("black_tea_cake_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/cake/black_tea_cake_slice")))
            .register();

    public static final ItemEntry<Item> GREEN_TEA_CAKE_SLICE = REGISTRATE
            .item("green_tea_cake_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/cake/green_tea_cake_slice")))
            .register();

    public static final ItemEntry<Item> YELLOW_TEA_CAKE_SLICE = REGISTRATE
            .item("yellow_tea_cake_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, prov) -> prov.generated(ctx, prov.modLoc("item/food/cake/yellow_tea_cake_slice")))
            .register();
//蛋糕结束
public static final ItemEntry<DrinkItem> ADZUKI_MILK_TEA = REGISTRATE
            .item("adzuki_milk_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/adzuki_milk_tea")))
    .register();

        public static final ItemEntry<DrinkItem> MINT_GREEN_TEA = REGISTRATE
                .item("mint_green_tea", DrinkItem::new)
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.3f) .build()))
                .model((ctx, provider) -> provider
                .generated(ctx::get, provider
                .modLoc("item/food/drink/mint_green_tea")))
        .register();

        public static final ItemEntry<DrinkItem> MOCHA_COFFEE = REGISTRATE
                .item("mocha_coffee", DrinkItem::new)
                .properties(p -> p.food(new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.3f) .build()))
                .model((ctx, provider) -> provider
                .generated(ctx::get, provider
                .modLoc("item/food/drink/mocha_coffee")))
        .register();

public static final ItemEntry<DrinkItem> SNOW_TOP_BLACK_TEA = REGISTRATE
            .item("snow_top_black_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/snow_top_black_tea")))
    .register();

public static final ItemEntry<DrinkItem> SNOW_TOP_COFFEE = REGISTRATE
            .item("snow_top_coffee", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/snow_top_coffee")))
    .register();

public static final ItemEntry<DrinkItem> SNOW_TOP_GREEN_TEA = REGISTRATE
            .item("snow_top_green_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/snow_top_green_tea")))
    .register();

public static final ItemEntry<DrinkItem> SNOW_TOP_YELLOW_TEA = REGISTRATE
            .item("snow_top_yellow_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/snow_top_yellow_tea")))
    .register();

public static final ItemEntry<DrinkItem> VANILLA_MILK_TEA = REGISTRATE
            .item("vanilla_milk_tea", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/drink/vanilla_milk_tea")))
    .register();

public static final ItemEntry<BowlReturnFoodItem> BLACK_TEA_ICE_CREAM = REGISTRATE
            .item("black_tea_ice_cream", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/cake/black_tea_ice_cream")))
    .register();

public static final ItemEntry<BowlReturnFoodItem> GREEN_TEA_ICE_CREAM = REGISTRATE
            .item("green_tea_ice_cream", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/cake/green_tea_ice_cream")))
    .register();

public static final ItemEntry<BowlReturnFoodItem> YELLOW_TEA_ICE_CREAM = REGISTRATE
            .item("yellow_tea_ice_cream", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/cake/yellow_tea_ice_cream")))
    .register();

public static final ItemEntry<BowlReturnFoodItem> RESPITEFUL_ICE_CREAM = REGISTRATE
            .item("respiteful_ice_cream", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/cake/respiteful_ice_cream")))
    .register();

public static final ItemEntry<BowlReturnFoodItem> COFFEE_ICE_CREAM = REGISTRATE
            .item("coffee_ice_cream", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/cake/coffee_ice_cream")))
    .register();
//风味结束
//开始
//甜品
public static final ItemEntry<Item> BERRY_DELIGHT = REGISTRATE
            .item("berry_delight", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/berry_delight")))
            .register();

public static final ItemEntry<Item> CIAMBALLONE = REGISTRATE
            .item("ciamballone", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/ciamballone")))
            .register();

public static final ItemEntry<Item> CIAMBALLONE_SLICE = REGISTRATE
            .item("ciamballone_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/ciamballone_slice")))
            .register();

public static final ItemEntry<Item> PANDORO_DOUGH = REGISTRATE
            .item("pandoro_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/pandoro_dough")))
            .register();

public static final ItemEntry<Item> PANDORO = REGISTRATE
            .item("pandoro", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/pandoro")))
            .register();

public static final ItemEntry<Item> PANDORO_SLICE = REGISTRATE
            .item("pandoro_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/pandoro_slice")))
            .register();

public static final ItemEntry<Item> PANETTONE = REGISTRATE
            .item("panettone", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/panettone")))
            .register();

public static final ItemEntry<Item> PANETTONE_SLICE = REGISTRATE
            .item("panettone_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/panettone_slice")))
            .register();

public static final ItemEntry<Item> TIRAMISU = REGISTRATE
            .item("tiramisu", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/tiramisu")))
            .register();
//正餐
public static final ItemEntry<Item> BRUSCHETTA = REGISTRATE
            .item("bruschetta", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/bruschetta")))
            .register();

public static final ItemEntry<Item> MOZZARELLA_SALAD = REGISTRATE
            .item("mozzarella_salad", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/mozzarella_salad")))
            .register();

public static final ItemEntry<Item> PASTA_AL_TOMATO = REGISTRATE
            .item("pasta_al_tomato", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/pasta_al_tomato")))
            .register();

public static final ItemEntry<Item> RISOTTO_AL_FUNGGHI = REGISTRATE
            .item("risotto_al_funghi", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/risotto_al_funghi")))
            .register();

public static final ItemEntry<Item> RISOTTO_AL_SUGO = REGISTRATE
            .item("risotto_al_sugo", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/risotto_al_sugo")))
            .register();
//香肠

public static final ItemEntry<Item> SALAME_SEAWEED_MIX = REGISTRATE
            .item("salame_seaweed_mix", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/salame_seaweed_mix")))
            .register();

public static final ItemEntry<Item> SALAME = REGISTRATE
            .item("salame", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/salame")))
            .register();

public static final ItemEntry<Item> SALAMI_SLICES = REGISTRATE
            .item("salami_slices", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/salami_slices")))
            .register();

public static final ItemEntry<DrinkItem> BERRY_WINE = REGISTRATE
            .item("berry_wine", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/berry_wine")))
    .register();

public static final ItemEntry<DrinkItem> DRAGONBORN_WINE = REGISTRATE
            .item("dragonborn_wine", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/dragonborn_wine")))
    .register();

public static final ItemEntry<DrinkItem> GLOWBERRY_WINE = REGISTRATE
            .item("glowberry_wine", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/glowberry_wine")))
    .register();

public static final ItemEntry<DrinkItem> HASTING_WINE = REGISTRATE
            .item("hasting_wine", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/hasting_wine")))
    .register();

public static final ItemEntry<DrinkItem> HELLHOUND_WINE = REGISTRATE
            .item("hellhound_wine", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/hellhound_wine")))
    .register();

public static final ItemEntry<DrinkItem> ROSE_WINE = REGISTRATE
            .item("rose_wine", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/rose_wine")))
    .register();

public static final ItemEntry<DrinkItem> SPUMANTE = REGISTRATE
            .item("spumante", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/spumante")))
    .register();



public static final ItemEntry<DrinkItem> WINE_PRE_SUBSTANCE = REGISTRATE
            .item("wine_pre-substance", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/italian_delight/wine_pre-substance")))
    .register();   
//意大利乐事结束
//Delightful Burgers

public static final ItemEntry<Item> BASIC_BURGER = REGISTRATE
            .item("basic_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/buger/basic_burger")))
            .register();

public static final ItemEntry<Item> CHICKEN_BURGER = REGISTRATE
            .item("chicken_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/buger/chicken_burger")))
            .register();

public static final ItemEntry<Item> DOUBLE_PATTY_BURGER = REGISTRATE
            .item("double_patty_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/buger/double_patty_burger")))
            .register();

//蟑螂乐事/农夫悲事
public static final ItemEntry<Item> GOKIBURI_YAKI = REGISTRATE
            .item("gokiburi_yaki", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/gokiburi_yaki")))
            .register();

public static final ItemEntry<Item> JUICY_ROAST_ROACH = REGISTRATE
            .item("juicy_roast_roach", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/juicy_roast_roach")))
            .register();

public static final ItemEntry<Item> PROTEIN_BLOCK = REGISTRATE
            .item("protein_block", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/protein_block")))
            .register();

public static final ItemEntry<Item> ROACH_BURGER = REGISTRATE
            .item("roach_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_burger")))
            .register();

public static final ItemEntry<Item> ROACH_PATTY = REGISTRATE
            .item("roach_patty", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_patty")))
            .register();

public static final ItemEntry<Item> ROACH_ROLL = REGISTRATE
            .item("roach_roll", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_roll")))
            .register();

public static final ItemEntry<Item> ROACH_SALAD_PLATTER = REGISTRATE
            .item("roach_salad_platter", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_salad_platter")))
            .register();

public static final ItemEntry<Item> ROACH_SANDWICH = REGISTRATE
            .item("roach_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_sandwich")))
            .register();

public static final ItemEntry<Item> ROACH_SKEWER = REGISTRATE
            .item("roach_skewer", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_skewer")))
            .register();

public static final ItemEntry<Item> ROACH_WHISKER_CANDY = REGISTRATE
            .item("roach_whisker_candy", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_whisker_candy")))
            .register();

public static final ItemEntry<Item> ROACH_MEATBALL = REGISTRATE
            .item("roach_meatball", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/roach/roach_meatball")))
            .register();

//蟑螂三件套
//康复新液
    public static final ItemEntry<DrinkItem> KANGFU_XIN_YE = REGISTRATE
            .item("kangfu_xin_ye", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/roach/kangfu_xin_ye")))
    .register();

    public static final ItemEntry<DrinkItem> BOTTLED_ROACH = REGISTRATE
            .item("bottled_roach", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/roach/bottled_roach")))
    .register();
//蟑螂结束
//感恩节乐事
public static final ItemEntry<Item> PECAN_PIE_SLICE = REGISTRATE
            .item("pecan_pie_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/pecan_pie_slice")))
            .register();

public static final ItemEntry<BowlReturnFoodItem> SWEET_POTATO_CASSEROLE = REGISTRATE
            .item("sweet_potato_casserole", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/sweet_potato_casserole")))
            .register();

public static final ItemEntry<BowlReturnFoodItem> ROAST_TURKEY = REGISTRATE
            .item("roast_turkey", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/roast_turkey")))
            .register();

public static final ItemEntry<BowlReturnFoodItem> STUFFING = REGISTRATE
            .item("stuffing", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/stuffing")))
            .register();

public static final ItemEntry<BowlReturnFoodItem> MASHED_POTATOES_AND_GRAVY = REGISTRATE
            .item("mashed_potatoes_and_gravy", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/mashed_potatoes_and_gravy")))
            .register();

public static final ItemEntry<Item> PECAN = REGISTRATE
            .item("pecan", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/pecan")))
            .register();

    public static final ItemEntry<Item> EMPTY_CORNucOPIA = REGISTRATE
            .item("empty_cornucopia", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/empty_cornucopia")))
            .register();

    public static final ItemEntry<Item> PAN = REGISTRATE
            .item("pan", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/bountiful_harvest/pan")))
            .register();

// GregTech Food Option 格雷科技食物优选
// 这里是阉割版，完整版还是要等CTNH发力的
public static final ItemEntry<Item> ALL_SMOGUS = REGISTRATE
            .item("all_smogus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(16)
                    .saturationMod(7.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/all_smogus")))
            .register();

public static final ItemEntry<Item> MULTI_SMOGUS = REGISTRATE
            .item("multi_smogus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(14)
                    .saturationMod(7.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/multi_smogus")))
            .register();

public static final ItemEntry<Item> SMOGUS = REGISTRATE
            .item("smogus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(10)
                    .saturationMod(7.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/smogus")))
            .register();

public static final ItemEntry<Item> SMORE = REGISTRATE
            .item("smore", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/smore")))
            .register();

public static final ItemEntry<Item> CHUM_BURGER = REGISTRATE
            .item("chum_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/chum_burger")))
            .register();

public static final ItemEntry<Item> MEAT_BURGER = REGISTRATE
            .item("meat_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/meat_burger")))
            .register();

public static final ItemEntry<Item> CHEESE_BURGER = REGISTRATE
            .item("cheese_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cheese_burger")))
            .register();

public static final ItemEntry<Item> VEGGIE_BURGER = REGISTRATE
            .item("veggie_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/veggie_burger")))
            .register();

public static final ItemEntry<Item> VEGGIE_SANDWICH = REGISTRATE
            .item("veggie_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/veggie_sandwich")))
            .register();

public static final ItemEntry<Item> CHEESE_SANDWICH = REGISTRATE
            .item("cheese_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cheese_sandwich")))
            .register();

public static final ItemEntry<Item> LARGE_BACON_SANDWICH = REGISTRATE
            .item("large_bacon_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/large_bacon_sandwich")))
            .register();

public static final ItemEntry<Item> LARGE_STEAK_SANDWICH = REGISTRATE
            .item("large_steak_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/large_steak_sandwich")))
            .register();
//蓝纹奶酪
public static final ItemEntry<Item> GORGONZOLA_CHEESE_WHEEL = REGISTRATE
            .item("gorgonzola_cheese_wheel", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/gorgonzola_cheese_wheel")))
            .register();
//蓝纹奶酪切片
public static final ItemEntry<Item> GORGONZOLA_CHEESE_SLICE = REGISTRATE
            .item("gorgonzola_cheese_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/gorgonzola_cheese_slice")))
            .register();

public static final ItemEntry<Item> GRAHAM_CRACKER = REGISTRATE
            .item("graham_cracker", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/graham_cracker")))
            .register();

public static final ItemEntry<Item> CHUM = REGISTRATE
            .item("chum", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/chum")))
            .register();

//炸薯片
public static final ItemEntry<Item> FRIED_POTATO_SLICE = REGISTRATE
            .item("fried_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fried_potato_slice")))
            .register();
//钨钢苹果
public static final ItemEntry<Item> TUNGSTEN_STEEL_APPLE = REGISTRATE
            .item("tungsten_steel_apple", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/tungsten_steel_apple")))
            .register();

public static final ItemEntry<Item> APPLE_HARD_CANDY = REGISTRATE
            .item("apple_hard_candy", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/apple_hard_candy")))
            .register();

public static final ItemEntry<Item> CORED_APPLE = REGISTRATE
            .item("cored_apple", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cored_apple")))
            .register();

public static final ItemEntry<Item> BAGUETTE = REGISTRATE
            .item("baguette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/baguette")))
            .register();

public static final ItemEntry<Item> UNBAKED_BAGUETTE = REGISTRATE
            .item("unbaked_baguette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.1f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/unbaked_baguette")))
            .register();
//薯片！！！
public static final ItemEntry<Item> SYALS = REGISTRATE
            .item("syals", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/syals")))
            .register();

public static final ItemEntry<Item> KETTLE_CHIPS = REGISTRATE
            .item("kettle_chips", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/kettle_chips")))
            .register();

public static final ItemEntry<Item> REDUCED_FAT_CHIPS = REGISTRATE
            .item("reduced_fat_chips", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/reduced_fat_chips")))
            .register();

public static final ItemEntry<Item> BAG_O_CHIPS = REGISTRATE
            .item("bag_o_chips", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/bag_o_chips")))
            .register();

public static final ItemEntry<Item> VINEGAR_CHIPS = REGISTRATE
            .item("vinegar_chips", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/vinegar_chips")))
            .register();
//列宁柠檬汁
public static final ItemEntry<DrinkItem> LENINADE = REGISTRATE
            .item("leninade", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/leninade")))
    .register();

//伏特加
public static final ItemEntry<DrinkItem> VODKA = REGISTRATE
            .item("vodka", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(6)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/vodka")))
    .register();

//紫色饮料
public static final ItemEntry<DrinkItem> PURPLE_DRINK = REGISTRATE
            .item("purple_drink", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gregtech/purple_drink")))
    .register();

public static final ItemEntry<CanDrinkItem> ETRIPS = REGISTRATE
            .item("etrips", CanDrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/etrips")))
            .register();

public static final ItemEntry<CanDrinkItem> SPARKLING_WATER = REGISTRATE
            .item("sparkling_water", CanDrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/sparkling_water")))
            .register();

public static final ItemEntry<Item> GUMMY_BEAR = REGISTRATE
            .item("gummy_bear", Item::new)
            .properties(p -> p.rarity(Rarity.EPIC))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(25)
                    .saturationMod(9.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/gummy_bear")))
            .register();
//GTFO批萨
public static final ItemEntry<Item> CHEESE_PIZZA_SLICE = REGISTRATE
            .item("cheese_pizza_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cheese_pizza_slice")))
            .register();

public static final ItemEntry<Item> MINCE_MEAT_PIZZA_SLICE = REGISTRATE
            .item("mince_meat_pizza_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/mince_meat_pizza_slice")))
            .register();

public static final ItemEntry<Item> OLIVE_MUSHROOM_PIZZA_SLICE = REGISTRATE
            .item("olive_mushroom_pizza_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/olive_mushroom_pizza_slice")))
            .register();

//生披萨
public static final ItemEntry<Item> RAW_CHEESE_PIZZA = REGISTRATE
            .item("raw_cheese_pizza", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_cheese_pizza")))
            .register();

public static final ItemEntry<Item> RAW_MINCE_MEAT_PIZZA = REGISTRATE
            .item("raw_mince_meat_pizza", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_mince_meat_pizza")))
            .register();

public static final ItemEntry<Item> RAW_OLIVE_MUSHROOM_PIZZA = REGISTRATE
            .item("raw_olive_mushroom_pizza", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_olive_mushroom_pizza")))
            .register();

public static final ItemEntry<Item> COOKED_SAUSAGE = REGISTRATE
            .item("cooked_sausage", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cooked_sausage")))
            .register();

public static final ItemEntry<Item> SAUSAGE = REGISTRATE
            .item("sausage", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/sausage")))
            .register();

public static final ItemEntry<Item> FERMENTED_CHORUS_PIE = REGISTRATE
            .item("fermented_chorus_pie", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationMod(9.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fermented_chorus_pie")))
            .register();

public static final ItemEntry<Item> FERMENTED_CHORUS_PIE_SLICE = REGISTRATE
            .item("fermented_chorus_pie_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fermented_chorus_pie_slice")))
            .register();

public static final ItemEntry<Item> PORCHETTA = REGISTRATE
            .item("porchetta", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/porchetta")))
            .register();

public static final ItemEntry<Item> PORCHETTA_SLICE = REGISTRATE
            .item("porchetta_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/porchetta_slice")))
            .register();

public static final ItemEntry<Item> BAKED_BEANS_TOAST = REGISTRATE
            .item("baked_beans_toast", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/baked_beans_toast")))
            .register();

public static final ItemEntry<Item> BAKED_BEANS = REGISTRATE
            .item("baked_beans", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/baked_beans")))
            .register();
//硅岩风味牛乳饮品
public static final ItemEntry<NoneDrink> NAQUADAH_MILK = REGISTRATE
            .item("naquadah_milk", NoneDrink::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/naquadah_milk")))
            .register();

public static final ItemEntry<Item> FERMENTED_CHORUS_CAPSULE = REGISTRATE
            .item("fermented_chorus_capsule", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fermented_chorus_capsule")))
            .register();

public static final ItemEntry<Item> FERMENTED_CHORUS = REGISTRATE
            .item("fermented_chorus", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fermented_chorus")))
            .register();

public static final ItemEntry<Item> FRIED_NAQUADAH_POTATO_SLICE = REGISTRATE
            .item("fried_naquadah_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fried_naquadah_potato_slice")))
            .register();

public static final ItemEntry<Item> NAQUADAH_CHIPS = REGISTRATE
            .item("naquadah_chips", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/naquadah_chips")))
            .register();
            
public static final ItemEntry<Item> GELATIN = REGISTRATE
            .item("gelatin", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/gelatin")))
            .register();

public static final ItemEntry<Item> GELATIN_CAPSULE = REGISTRATE
            .item("gelatin_capsule", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/gelatin_capsule")))
            .register();
            
public static final ItemEntry<Item> PARACETAMOL_CAPSULE = REGISTRATE
            .item("paracetamol_capsule", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/paracetamol_capsule")))
            .register();

public static final ItemEntry<Item> VIBRANT_CAPSULE = REGISTRATE
            .item("vibrant_capsule", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/vibrant_capsule")))
            .register();
            
public static final ItemEntry<Item> PLUTONIUM_241_CAPSULE = REGISTRATE
            .item("plutonium_241_capsule", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/plutonium_241_capsule")))
            .register();

public static final ItemEntry<Item> PEA_POD = REGISTRATE
            .item("pea_pod", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pea_pod")))
            .register();

public static final ItemEntry<Item> PEA = REGISTRATE
            .item("pea", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pea")))
            .register();

public static final ItemEntry<Item> PEA_PASTE = REGISTRATE
            .item("pea_paste", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pea_paste")))
            .register();
//硅岩
public static final ItemEntry<Item> NAQUADAH_INGOT = REGISTRATE
            .item("naquadah_ingot", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/naquadah_ingot")))
            .register();

//包装袋
public static final ItemEntry<Item> CHIPS_BAG = REGISTRATE
            .item("chips_bag", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/chips_bag")))
            .register();

public static final ItemEntry<DrinkItem> COAC = REGISTRATE
            .item("coac", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/coac")))
    .register();

public static final ItemEntry<DrinkItem> SEPIP = REGISTRATE
            .item("sepip", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/sepip")))
    .register();

public static final ItemEntry<DrinkItem> GTFO_PURPLE_DRINK = REGISTRATE
            .item("gtfo_purple_drink", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/gtfo_purple_drink")))
    .register();  

public static final ItemEntry<CanDrinkItem> ANTAF = REGISTRATE
            .item("antaf", CanDrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/antaf")))
    .register();

public static final ItemEntry<CanDrinkItem> CRANBERRY_ETRIPS = REGISTRATE
            .item("cranberry_etrips", CanDrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/cranberry_etrips")))
    .register();

public static final ItemEntry<Item> MINCE_MEAT = REGISTRATE
            .item("mince_meat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/mince_meat")))
            .register();

public static final ItemEntry<Item> COOKED_MINCE_MEAT = REGISTRATE
            .item("cooked_mince_meat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cooked_mince_meat")))
            .register();

public static final ItemEntry<Item> MEAT_INGOT = REGISTRATE
            .item("meat_ingot", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/meat_ingot")))
            .register();

public static final ItemEntry<Item> COOKED_MEAT_INGOT = REGISTRATE
            .item("cooked_meat_ingot", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cooked_meat_ingot")))
            .register();

public static final ItemEntry<DrinkItem> BEER = REGISTRATE
            .item("beer", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/beer")))
    .register();

public static final ItemEntry<DrinkItem> QINGDAO_BEER = REGISTRATE
            .item("qingdao_beer", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/qingdao_beer")))
    .register();
//饮料
public static final ItemEntry<NoneDrink> ORANGE_JUICE = REGISTRATE
            .item("orange_juice", NoneDrink::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/orange_juice")))
    .register();
//饮料
public static final ItemEntry<NoneDrink> APPLE_JUICE = REGISTRATE
            .item("apple_juice", NoneDrink::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
            .generated(ctx::get, provider
            .modLoc("item/food/gtfo/apple_juice")))
    .register();

//你在这里之后创建 别乱创建！

// 以下按模板注册（继承 PorcelainBowlFoodItem）
// ---- 插入：基础 Item 批次（带 FoodProperties） ----
public static final ItemEntry<Item> BACON_BURGER = REGISTRATE
            .item("bacon_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/bacon_burger")))
            .register();

public static final ItemEntry<Item> BACON_SANDWICH = REGISTRATE
            .item("bacon_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/bacon_sandwich")))
            .register();

public static final ItemEntry<Item> CUTTED_BAGUETTE = REGISTRATE
            .item("cutted_baguette", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cutted_baguette")))
            .register();

public static final ItemEntry<Item> CUTTED_BREAD = REGISTRATE
            .item("cutted_bread", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cutted_bread")))
            .register();

public static final ItemEntry<Item> CUTTED_BUN = REGISTRATE
            .item("cutted_bun", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cutted_bun")))
            .register();

public static final ItemEntry<Item> LARGE_CHEESE_SANDWICH = REGISTRATE
            .item("large_cheese_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/large_cheese_sandwich")))
            .register();

public static final ItemEntry<Item> LARGE_VEGGIE_SANDWICH = REGISTRATE
            .item("large_veggie_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/large_veggie_sandwich")))
            .register();

public static final ItemEntry<Item> STEAK_BURGER = REGISTRATE
            .item("steak_burger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/steak_burger")))
            .register();

public static final ItemEntry<Item> STEAK_SANDWICH = REGISTRATE
            .item("steak_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/steak_sandwich")))
            .register();

public static final ItemEntry<Item> TOAST_SANDWICH = REGISTRATE
            .item("toast_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/toast_sandwich")))
            .register();
// ---- 插入结束 ----
public static final ItemEntry<PorcelainBowlFoodItem> COOKED_LONG_GRAIN_RICE = REGISTRATE
            .item("cooked_long_grain_rice", PorcelainBowlFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cooked_rice")))
            .register();

public static final ItemEntry<PorcelainBowlFoodItem> PASTA_E_FAGIOLI = REGISTRATE
            .item("pasta_e_fagioli", PorcelainBowlFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pasta_e_fagioli")))
            .register();

public static final ItemEntry<PorcelainBowlFoodItem> POLENTA = REGISTRATE
            .item("polenta", PorcelainBowlFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/polenta")))
            .register();

public static final ItemEntry<PorcelainBowlFoodItem> RISOTTO_BOWL = REGISTRATE
            .item("risotto", PorcelainBowlFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/risotto")))
            .register();

public static final ItemEntry<PorcelainBowlFoodItem> TORTELLINI_IN_BRODO = REGISTRATE
            .item("tortellini_in_brodo", PorcelainBowlFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(2.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/tortellini_in_brodo")))
            .register();
            
public static final ItemEntry<PorcelainBowlFoodItem> CAPONATA = REGISTRATE
            .item("caponata", PorcelainBowlFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/caponata")))
            .register();

// 以下为 PorcelainPlateFoodItem 类型的一批物品（来自 png，去掉后缀）
public static final ItemEntry<PorcelainPlateFoodItem> CARBONARA = REGISTRATE
            .item("carbonara", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/carbonara")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> CARCIOFI_ALLA_ROMANA = REGISTRATE
            .item("carciofi_alla_romana", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/carciofi_alla_romana")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> CHUM_LASAGNA = REGISTRATE
            .item("chum_lasagna", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/chum_lasagna")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> FETTUCCINE_ALFREDO = REGISTRATE
            .item("fettuccine_alfredo", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fettuccine_alfredo")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> MELANZANE_PARMIGIANA = REGISTRATE
            .item("melanzane_parmigiana", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/melanzane_parmigiana")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> NEAPOLITAN_LASAGNA = REGISTRATE
            .item("neapolitan_lasagna", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/neapolitan_lasagna")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> PASTA_ALLA_NORMA = REGISTRATE
            .item("pasta_alla_norma", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pasta_alla_norma")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> PASTA_ALL_AMOGUS = REGISTRATE
            .item("pasta_all_amogus", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pasta_all_amogus")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> PESTO_LASAGNA = REGISTRATE
            .item("pesto_lasagna", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pesto_lasagna")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> RAFANATA = REGISTRATE
            .item("rafanata", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/rafanata")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> SPAGHETTI_ALL_ASSASSINA = REGISTRATE
            .item("spaghetti_all_assassina", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/spaghetti_all_assassina")))
            .register();

public static final ItemEntry<PorcelainPlateFoodItem> VETELLO_TONNATO = REGISTRATE
            .item("vetello_tonnato", PorcelainPlateFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/vetello_tonnato")))
            .register();

// 以下为一批串/烤物与相关生品（基本 Item，带 FoodProperties）
public static final ItemEntry<Item> BAKED_POTATO_WITH_STICK = REGISTRATE
            .item("baked_potato_with_stick", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/baked_potato_with_stick")))
            .register();

public static final ItemEntry<Item> BARG_KEBAB = REGISTRATE
            .item("barg_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/barg_kebab")))
            .register();

public static final ItemEntry<Item> CARROT_KEBAB = REGISTRATE
            .item("carrot_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/carrot_kebab")))
            .register();

public static final ItemEntry<Item> CHUM_KEBAB = REGISTRATE
            .item("chum_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/chum_kebab")))
            .register();

public static final ItemEntry<Item> CHUM_WITH_STICK = REGISTRATE
            .item("chum_with_stick", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/chum_with_stick")))
            .register();

public static final ItemEntry<Item> KEBAB_E_SOLTANI = REGISTRATE
            .item("kebab_e_soltani", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/kebab_e_soltani")))
            .register();

public static final ItemEntry<Item> KUBIDEH_KEBAB = REGISTRATE
            .item("kubideh_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/kubideh_kebab")))
            .register();

public static final ItemEntry<Item> MARSHMALLOW_STICK = REGISTRATE
            .item("marshmallow_stick", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/marshmallow_stick")))
            .register();

public static final ItemEntry<Item> MEAT_KEBAB = REGISTRATE
            .item("meat_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/meat_kebab")))
            .register();

public static final ItemEntry<Item> ONION_KEBAB = REGISTRATE
            .item("onion_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/onion_kebab")))
            .register();

public static final ItemEntry<Item> POTATO_WITH_STICK = REGISTRATE
            .item("potato_with_stick", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/potato_with_stick")))
            .register();

public static final ItemEntry<Item> RAW_BARG_KEBAB = REGISTRATE
            .item("raw_barg_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_barg_kebab")))
            .register();

public static final ItemEntry<Item> RAW_CARROT_KEBAB = REGISTRATE
            .item("raw_carrot_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_carrot_kebab")))
            .register();

public static final ItemEntry<Item> RAW_CHUM_KEBAB = REGISTRATE
            .item("raw_chum_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_chum_kebab")))
            .register();

public static final ItemEntry<Item> RAW_KUBIDEH_KEBAB = REGISTRATE
            .item("raw_kubideh_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_kubideh_kebab")))
            .register();

public static final ItemEntry<Item> RAW_MEAT_KEBAB = REGISTRATE
            .item("raw_meat_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_meat_kebab")))
            .register();

public static final ItemEntry<Item> RAW_ONION_KEBAB = REGISTRATE
            .item("raw_onion_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_onion_kebab")))
            .register();

public static final ItemEntry<Item> RAW_TAILFAT_KEBAB = REGISTRATE
            .item("raw_tailfat_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_tailfat_kebab")))
            .register();

public static final ItemEntry<Item> RAW_TOMATO_KEBAB = REGISTRATE
            .item("raw_tomato_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_tomato_kebab")))
            .register();

public static final ItemEntry<Item> TAILFAT_KEBAB = REGISTRATE
            .item("tailfat_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/tailfat_kebab")))
            .register();

public static final ItemEntry<Item> TOASTED_MARSHMALLOW_WITH_STICK = REGISTRATE
            .item("toasted_marshmallow_with_stick", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/toasted_marshmallow_with_stick")))
            .register();

public static final ItemEntry<Item> TOMATO_KEBAB = REGISTRATE
            .item("tomato_kebab", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/tomato_kebab")))
            .register();

public static final ItemEntry<Item> BRITISH_BREAKFAST = REGISTRATE
            .item("british_breakfast", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/british_breakfast")))
            .register();

public static final ItemEntry<Item> MALTED_BREAD = REGISTRATE
            .item("malted_bread", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/bread_slice")))
            .register();

public static final ItemEntry<Item> BEEF_SLICE = REGISTRATE
            .item("beef_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/beef_slice")))
            .register();

public static final ItemEntry<Item> BEANS_WITH_TOMATO_SAUSE = REGISTRATE
            .item("beans_with_tomato_sause", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/beans_with_tomato_sause")))
            .register();

public static final ItemEntry<Item> BAGGED_GT_POPCORN = REGISTRATE
            .item("bagged_gt_popcorn", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/bagged_popcorn")))
            .register();

public static final ItemEntry<Item> APPLE_HARD_CANDY_PLATE = REGISTRATE
            .item("apple_hard_candy_plate", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/apple_hard_candy_plate")))
            .register();

public static final ItemEntry<Item> APPLE_HARD_CANDY_FONDANT = REGISTRATE
            .item("apple_hard_candy_fondant", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/apple_hard_candy_fondant")))
            .register();

public static final ItemEntry<Item> FISH_AND_CHIPS = REGISTRATE
            .item("fish_and_chips", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fish_and_chips")))
            .register();

public static final ItemEntry<Item> CRASHED_APPLE_HARD_CANDY = REGISTRATE
            .item("crashed_apple_hard_candy", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crashed_apple_hard_candy")))
            .register();

public static final ItemEntry<Item> COOKED_BEEF_SLICE = REGISTRATE
            .item("cooked_beef_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cooked_beef_slice")))
            .register();

public static final ItemEntry<Item> COOKED_SAUSAGE_ROLL = REGISTRATE
            .item("cooked_sausage_roll", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cooked_sausage_roll")))
            .register();

public static final ItemEntry<Item> FRIED_FISH = REGISTRATE
            .item("fried_fish", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fried_fish")))
            .register();

public static final ItemEntry<Item> HOT_APPLE_HARD_CANDY_PLATE = REGISTRATE
            .item("hot_apple_hard_candy_plate", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/hot_apple_hard_candy_plate")))
            .register();

public static final ItemEntry<Item> HOT_GRAHAM_CRACKER = REGISTRATE
            .item("hot_graham_cracker", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/hot_graham_cracker")))
            .register();

public static final ItemEntry<Item> FLAVOURED_PELMENI = REGISTRATE
            .item("flavoured_pelmeni", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/flavoured_pelmeni")))
            .register();

public static final ItemEntry<Item> JIAOZI = REGISTRATE
            .item("jiaozi", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/jiaozi")))
            .register();

public static final ItemEntry<Item> MARSHMALLOW = REGISTRATE
            .item("marshmallow", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/marshmallow")))
            .register();

public static final ItemEntry<Item> MASHED_POTATO = REGISTRATE
            .item("mashed_potato", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/mashed_potato")))
            .register();

public static final ItemEntry<Item> MELTING_MILK_CHOCOLATE = REGISTRATE
            .item("melting_milk_chocolate", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/melting_milk_chocolate")))
            .register();

public static final ItemEntry<Item> MILK_CHOCOLATE = REGISTRATE
            .item("milk_chocolate", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/milk_chocolate")))
            .register();

public static final ItemEntry<Item> PELMENI = REGISTRATE
            .item("pelmeni", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pelmeni")))
            .register();

public static final ItemEntry<Item> GT_POPCORN = REGISTRATE
            .item("gt_popcorn", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/popcorn")))
            .register();

public static final ItemEntry<Item> MALTED_BREAD_TOAST = REGISTRATE
            .item("malted_bread_toast", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/toast")))
            .register();

public static final ItemEntry<Item> SPOILED_MEAT = REGISTRATE
            .item("spoiled_meat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/spoiled_meat")))
            .register();

public static final ItemEntry<Item> GLYCINE_SOJA = REGISTRATE
            .item("glycine_soja", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/glycine_soja")))
            .register();

public static final ItemEntry<Item> WILD_SOYBEAN_POD = REGISTRATE
            .item("wild_soybean_pod", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.6f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/crop/wild_soybean_pod")))
            .register();

public static final ItemEntry<Item> BAKED_COCOA_BEANS = REGISTRATE
            .item("baked_cocoa_beans", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/baked_cocoa_beans")))
            .register();

public static final ItemEntry<Item> BROKEN_GRAHAM_CRACKER = REGISTRATE
            .item("broken_graham_cracker", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/broken_graham_cracker")))
            .register();

public static final ItemEntry<Item> BUN = REGISTRATE
            .item("bun", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/bun")))
            .register();

public static final ItemEntry<Item> COCOA_SHELL = REGISTRATE
            .item("cocoa_shell", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/cocoa_shell")))
            .register();

public static final ItemEntry<Item> EMERGENCY_RATIONS = REGISTRATE
            .item("emergency_rations", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(4.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/emergency_rations")))
            .register();

public static final ItemEntry<Item> HULLED_COCOA_BEAN = REGISTRATE
            .item("hulled_cocoa_bean", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/hulled_cocoa_bean")))
            .register();

public static final ItemEntry<Item> MARSHMALLOW_GUM = REGISTRATE
            .item("marshmallow_gum", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/marshmallow_gum")))
            .register();

public static final ItemEntry<Item> PEELED_BANANA = REGISTRATE
            .item("peeled_banana", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/peeled_banana")))
            .register();

public static final ItemEntry<Item> PREMIXED_PASTA_DOUGH = REGISTRATE
            .item("premixed_pasta_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/premixed_pasta_dough")))
            .register();

public static final ItemEntry<Item> SWEET_DOUGH = REGISTRATE
            .item("sweet_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/sweet_dough")))
            .register();

public static final ItemEntry<Item> VIBRANT_SANDWICH = REGISTRATE
            .item("vibrant_sandwich", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/vibrant_sandwich")))
            .register();

public static final ItemEntry<Item> INDUSTRIALIST_PIE = REGISTRATE
            .item("industrialist_pie", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/shepherds_pie")))
            .register();

public static final ItemEntry<Item> SAUSAGE_ROLL = REGISTRATE
            .item("sausage_roll", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/sausage_roll")))
            .register();

public static final ItemEntry<Item> BAKED_CAKE_BOTTOM = REGISTRATE
            .item("baked_cake_bottom", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/baked_cake_bottom")))
            .register();

public static final ItemEntry<Item> BATCH_FRIED_POTATO_SLICE = REGISTRATE
            .item("batch_fried_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/batch_fried_potato_slice")))
            .register();

public static final ItemEntry<Item> CAPSULE_BODY = REGISTRATE
            .item("capsule_body", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/capsule_body")))
            .register();

public static final ItemEntry<Item> CAPSULE_HAT = REGISTRATE
            .item("capsule_hat", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/capsule_hat")))
            .register();

public static final ItemEntry<Item> CORNCOB = REGISTRATE
            .item("corncob", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/corncob")))
            .register();

public static final ItemEntry<Item> DITALINI = REGISTRATE
            .item("ditalini", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/ditalini")))
            .register();

public static final ItemEntry<Item> DRIED_CORN = REGISTRATE
            .item("dried_corn", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/dried_corn")))
            .register();

public static final ItemEntry<Item> DRIED_DITALINI = REGISTRATE
            .item("dried_ditalini", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/dried_ditalini")))
            .register();

public static final ItemEntry<Item> DRIED_LASAGNA = REGISTRATE
            .item("dried_lasagna", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/dried_lasagna")))
            .register();

public static final ItemEntry<Item> DRIED_RIGATONI = REGISTRATE
            .item("dried_rigatoni", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/dried_rigatoni")))
            .register();

public static final ItemEntry<Item> DRIED_SPAGHETTI = REGISTRATE
            .item("dried_spaghetti", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/dried_spaghetti")))
            .register();

public static final ItemEntry<Item> DRIED_TAGLIATELLE = REGISTRATE
            .item("dried_tagliatelle", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/dried_tagliatelle")))
            .register();

public static final ItemEntry<Item> EGG_PASTA_DOUGH = REGISTRATE
            .item("egg_pasta_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/egg_pasta_dough")))
            .register();

public static final ItemEntry<Item> FLAT_DOUGH = REGISTRATE
            .item("flat_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/flat_dough")))
            .register();

public static final ItemEntry<Item> FRENCH_FRY = REGISTRATE
            .item("french_fry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/french_fry")))
            .register();

public static final ItemEntry<Item> FRIED_POTATO_STRIP = REGISTRATE
            .item("fried_potato_strip", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/fried_potato_strip")))
            .register();

public static final ItemEntry<Item> GRAHAM_DOUGH = REGISTRATE
            .item("graham_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/graham_dough")))
            .register();

public static final ItemEntry<Item> GREASY_POTATO_SLICE = REGISTRATE
            .item("greasy_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/greasy_potato_slice")))
            .register();

public static final ItemEntry<Item> HOT_GRAHAM_CRACKER_BASE = REGISTRATE
            .item("hot_graham_cracker_base", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/hot_graham_cracker_base")))
            .register();

public static final ItemEntry<Item> HOT_GRAHAM_DOUGH = REGISTRATE
            .item("hot_graham_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/hot_graham_dough")))
            .register();

public static final ItemEntry<Item> HOT_POTATO_SLICE = REGISTRATE
            .item("hot_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/hot_potato_slice")))
            .register();

public static final ItemEntry<Item> LASAGNA = REGISTRATE
            .item("lasagna", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/lasagna")))
            .register();

public static final ItemEntry<Item> LOW_FAT_POTATO_SLICE = REGISTRATE
            .item("low_fat_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/low_fat_potato_slice")))
            .register();

public static final ItemEntry<Item> PASTA_DOUGH = REGISTRATE
            .item("pasta_dough", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pasta_dough")))
            .register();

public static final ItemEntry<Item> PEELED_POTATO = REGISTRATE
            .item("peeled_potato", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/peeled_potato")))
            .register();

public static final ItemEntry<Item> PIE_CRUST = REGISTRATE
            .item("pie_crust", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/pie_crust")))
            .register();

public static final ItemEntry<Item> THINLY_POTATO_SLICE = REGISTRATE
            .item("thinly_potato_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/potato_slice")))
            .register();

public static final ItemEntry<Item> COARSE_POTATO_STRIP = REGISTRATE
            .item("coarse_potato_strip", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/potato_strip")))
            .register();

public static final ItemEntry<Item> RAW_JIAOZI = REGISTRATE
            .item("raw_jiaozi", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_jiaozi")))
            .register();

public static final ItemEntry<Item> RAW_PELMENI = REGISTRATE
            .item("raw_pelmeni", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/raw_pelmeni")))
            .register();

public static final ItemEntry<Item> RIGATONI = REGISTRATE
            .item("rigatoni", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/rigatoni")))
            .register();

public static final ItemEntry<Item> SPAGHETTI = REGISTRATE
            .item("spaghetti", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/spaghetti")))
            .register();

public static final ItemEntry<Item> TAGLIATELLE = REGISTRATE
            .item("tagliatelle", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/tagliatelle")))
            .register();

public static final ItemEntry<Item> TORTELLINI = REGISTRATE
            .item("tortellini", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/tortellini")))
            .register();

public static final ItemEntry<Item> UNBAKED_BREAD = REGISTRATE
            .item("unbaked_bread", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/unbaked_bread")))
            .register();

public static final ItemEntry<Item> UNBAKED_BUN = REGISTRATE
            .item("unbaked_bun", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/unbaked_bun")))
            .register();

public static final ItemEntry<Item> UNBAKED_CAKE_BOTTOM = REGISTRATE
            .item("unbaked_cake_bottom", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/unbaked_cake_bottom")))
            .register();

public static final ItemEntry<Item> UNFILTERED_GRAHAM_CRACKER = REGISTRATE
            .item("unfiltered_graham_cracker", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.0f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/unfiltered_graham_cracker")))
            .register();

//欧洲黑莓
public static final ItemEntry<Item> EUROPEAN_BLACKBERRY = REGISTRATE
            .listItem("european_blackberry", Item::new)
            .tooltips(
            "§7§oA member of the Rubus fruticosus agg.",
            "§7§oIt is widespread across Britain and Ireland."
        )
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/european_blackberry")))
            .register();

//美洲黑醋栗
public static final ItemEntry<Item> AMERICAN_BLACK_CURRANT = REGISTRATE
            .listItem("american_black_currant", Item::new)
            .tooltips(
            "§7§oAmerican black currant is a common wild currant in North America."
        )
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/american_black_currant")))
            .register();

//罗瓦达红醋栗
public static final ItemEntry<Item> ROVADA_RED_CURRANT = REGISTRATE
            .listItem("rovada_red_currant", Item::new)
            .tooltips(
            "§7§oKing of Red Currants!"
        )
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/rovada_red_currant")))
            .register();

//凡尔赛白醋栗
public static final ItemEntry<Item> VERSAILLES_WHITE_CURRANT = REGISTRATE
            .listItem("versailles_white_currant", Item::new)
            .tooltips(
            "§7§oThe aristocrat of currants"
        )
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/versailles_white_currant")))
            .register();

//东方草莓
public static final ItemEntry<Item> ORIENTAL_STRAWBERRY = REGISTRATE
            .item("oriental_strawberry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/oriental_strawberry")))
            .register();

//越橘
public static final ItemEntry<Item> LINGONBERRY = REGISTRATE
            .item("lingonberry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/lingonberry")))
            .register();

//哈施贝格接骨木莓
public static final ItemEntry<Item> HASCHBERG_ELDERBERRY = REGISTRATE
            .item("haschberg_elderberry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/haschberg_elderberry")))
            .register();

//大果蔓越莓
public static final ItemEntry<Item> LARGE_CRANBERRY = REGISTRATE
            .item("large_cranberry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/large_cranberry")))
            .register();

//欧洲红树莓
public static final ItemEntry<Item> EUROPEAN_RED_RASPBERRY = REGISTRATE
            .item("european_red_raspberry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/european_red_raspberry")))
            .register();

//北高丛蓝莓
public static final ItemEntry<Item> NORTHERN_HIGHBUSH_BLUEBERRY = REGISTRATE
            .item("northern_highbush_blueberry", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(1.5f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/berry/northern_highbush_blueberry")))
            .register();
//什锦浆果
public static final ItemEntry<BowlReturnFoodItem> BERRY_MEDLEY = REGISTRATE
            .item("berry_medley", BowlReturnFoodItem::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/berry_medley")))
            .register();
//GTFO食物结束 私货结束
/*
public static final ItemEntry<Item>  = REGISTRATE
            .item("", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationMod(3.4f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/gtfo/")))
            .register();
*/
//神他妈干制槟榔
public static final ItemEntry<Item> BETEL_NUT_DRIED = REGISTRATE
            .item("betel_nut_dried", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.1f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/dried/betel_nut_dried")))
            .register();

    //特制面粉
    public static final ItemEntry<Item> SPECIAL_WHEAT_FLOUR = REGISTRATE
            .item("special_wheat_flour", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/mooncake/life_after/special_wheat_flour")))
            .register();
 /*
    // 果冻（双层调色：jelly_base 为底图，jelly 为上层调色图）
    // 用法：颜色常量写成 0xAARRGGBB；想触发“明度档位 + 主色”公式时，直接在这里先算出 tint：
    //       .item("jelly", p -> new JellyItem(p, ColorSpaceUtil.tintFromGray(0xFFF2D65C, 0.75F)))
    //       0xFFF2D65C 是主色，0.75F 是明度档位；上层 jelly 纹理保持灰度明暗，tintIndex=1 负责把灰度映射成对应主色，底图 jelly_base 不参与调色。
    // .item("jelly", p -> new JellyItem(p, ColorSpaceUtil.tintFromGray(0xFFF2D65C, 0.75F)))
    public static final ItemEntry<JellyItem> JELLY = REGISTRATE
            .item("jelly", p -> new JellyItem(p, 0xFFF2D65C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();

   //调色月饼模板

   public static final ItemEntry<MooncakeItem> _MOONCAKE = REGISTRATE
            .item("_mooncake", p -> new MooncakeItem(p, ))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.mooncakeModel(ctx, provider,
                    "list:item/food/mooncake/mooncake_base",
                    "list:item/food/mooncake/mooncake_filling"))
            .register();
  */
//月饼结束
//集成捆绑
//注册模板
    /*
    public static final ItemEntry<继承类> 常量名 = REGISTRATE
            .item("注册名", 继承类::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition()
                    .saturationMod(f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/与注册名相同的资源路径")))
            .register();
     */

    // CopperCupDrinkItem (杯类容器)
    public static final ItemEntry<CopperCupDrinkItem> ADZUKI_CURRY_CUP = REGISTRATE
            .item("adzuki_curry_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/adzuki_curry_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> ADZUKI_MILK_TEA_CUP = REGISTRATE
            .item("adzuki_milk_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/adzuki_milk_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> BEER_GLASS = REGISTRATE
            .item("beer_glass", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/beer_glass")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> BLACK_TEA_CUP = REGISTRATE
            .item("black_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/black_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> BLOODY_MARY_GLASS = REGISTRATE
            .item("bloody_mary_glass", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/bloody_mary_glass")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> BORSCHT_CUP = REGISTRATE
            .item("borscht_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/borscht_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> COFFEE_CUP = REGISTRATE
            .item("coffee_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/coffee_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> DANDELION_TEA_CUP = REGISTRATE
            .item("dandelion_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/dandelion_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> GREEN_TEA_CUP = REGISTRATE
            .item("green_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/green_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> LONG_BLACK_TEA_CUP = REGISTRATE
            .item("long_black_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/long_black_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> LONG_COFFEE_CUP = REGISTRATE
            .item("long_coffee_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/long_coffee_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> LONG_DANDELION_TEA_CUP = REGISTRATE
            .item("long_dandelion_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/long_dandelion_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> LONG_GREEN_TEA_CUP = REGISTRATE
            .item("long_green_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/long_green_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> LONG_YELLOW_TEA_CUP = REGISTRATE
            .item("long_yellow_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/long_yellow_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> MINT_GREEN_TEA_CUP = REGISTRATE
            .item("mint_green_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/mint_green_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> MOCHA_COFFEE_CUP = REGISTRATE
            .item("mocha_coffee_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/mocha_coffee_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> NETTLE_SOUP_CUP = REGISTRATE
            .item("nettle_soup_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/nettle_soup_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> PURULENT_TEA_CUP = REGISTRATE
            .item("purulent_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/purulent_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> ROSE_HIP_TEA_CUP = REGISTRATE
            .item("rose_hip_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/rose_hip_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> STRONG_BLACK_TEA_CUP = REGISTRATE
            .item("strong_black_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strong_black_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> STRONG_COFFEE_CUP = REGISTRATE
            .item("strong_coffee_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strong_coffee_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> STRONG_GREEN_TEA_CUP = REGISTRATE
            .item("strong_green_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strong_green_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> STRONG_PURULENT_TEA_CUP = REGISTRATE
            .item("strong_purulent_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strong_purulent_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> STRONG_ROSE_HIP_TEA_CUP = REGISTRATE
            .item("strong_rose_hip_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strong_rose_hip_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> STRONG_YELLOW_TEA_CUP = REGISTRATE
            .item("strong_yellow_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strong_yellow_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> VANILLA_MILK_TEA_CUP = REGISTRATE
            .item("vanilla_milk_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/vanilla_milk_tea_cup")))
            .register();

    public static final ItemEntry<CopperCupDrinkItem> YELLOW_TEA_CUP = REGISTRATE
            .item("yellow_tea_cup", CopperCupDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/yellow_tea_cup")))
            .register();

    // GlassTankardItem (玻璃罐/杯类特殊容器)
    public static final ItemEntry<GlassTankardItem> DREAD_NOG_GLASS = REGISTRATE
            .item("dread_nog_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/dread_nog_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> EGG_GROG_GLASS = REGISTRATE
            .item("egg_grog_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/egg_grog_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> GLITTERING_GRENADINE_GLASS = REGISTRATE
            .item("glittering_grenadine_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/glittering_grenadine_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> KOMBUCHA_GLASS = REGISTRATE
            .item("kombucha_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/kombucha_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> MEAD_GLASS = REGISTRATE
            .item("mead_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/mead_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> PALE_JANE_GLASS = REGISTRATE
            .item("pale_jane_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/pale_jane_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> RADIANT_BREW_GLASS = REGISTRATE
            .item("radiant_brew_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/radiant_brew_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> RED_RUM_GLASS = REGISTRATE
            .item("red_rum_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/red_rum_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> RICE_WINE_GLASS = REGISTRATE
            .item("rice_wine_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/rice_wine_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> ROOT_BEER_GLASS = REGISTRATE
            .item("root_beer_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/root_beer_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> SACCHARINE_RUM_GLASS = REGISTRATE
            .item("saccharine_rum_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/saccharine_rum_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> SALTY_FOLLY_GLASS = REGISTRATE
            .item("salty_folly_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/salty_folly_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> STEEL_TOE_STOUT_GLASS = REGISTRATE
            .item("steel_toe_stout_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/steel_toe_stout_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> STRONGROOT_ALE_GLASS = REGISTRATE
            .item("strongroot_ale_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strongroot_ale_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> VODKA_GLASS = REGISTRATE
            .item("vodka_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/vodka_glass")))
            .register();

    public static final ItemEntry<GlassTankardItem> WITHERING_DROSS_GLASS = REGISTRATE
            .item("withering_dross_glass", GlassTankardItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/withering_dross_glass")))
            .register();

    // CopperTankardDrinkItem (饮用类型 - swig)
    public static final ItemEntry<CopperTankardDrinkItem> BEER_SWIG = REGISTRATE
            .item("beer_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/beer_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> BLOODY_MARY_SWIG = REGISTRATE
            .item("bloody_mary_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/bloody_mary_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> DREAD_NOG_SWIG = REGISTRATE
            .item("dread_nog_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/dread_nog_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> EGG_GROG_SWIG = REGISTRATE
            .item("egg_grog_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/egg_grog_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> GLITTERING_GRENADINE_SWIG = REGISTRATE
            .item("glittering_grenadine_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/glittering_grenadine_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> KOMBUCHA_SWIG = REGISTRATE
            .item("kombucha_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/kombucha_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> MEAD_SWIG = REGISTRATE
            .item("mead_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/mead_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> PALE_JANE_SWIG = REGISTRATE
            .item("pale_jane_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/pale_jane_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> RADIANT_BREW_SWIG = REGISTRATE
            .item("radiant_brew_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/radiant_brew_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> RED_RUM_SWIG = REGISTRATE
            .item("red_rum_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/red_rum_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> RICE_WINE_SWIG = REGISTRATE
            .item("rice_wine_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/rice_wine_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> ROOT_BEER_SWIG = REGISTRATE
            .item("root_beer_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/root_beer_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> SACCHARINE_RUM_SWIG = REGISTRATE
            .item("saccharine_rum_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/saccharine_rum_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> SALTY_FOLLY_SWIG = REGISTRATE
            .item("salty_folly_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/salty_folly_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> STEEL_TOE_STOUT_SWIG = REGISTRATE
            .item("steel_toe_stout_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/steel_toe_stout_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> STRONGROOT_ALE_SWIG = REGISTRATE
            .item("strongroot_ale_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/strongroot_ale_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> VODKA_SWIG = REGISTRATE
            .item("vodka_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/vodka_swig")))
            .register();

    public static final ItemEntry<CopperTankardDrinkItem> WITHERING_DROSS_SWIG = REGISTRATE
            .item("withering_dross_swig", CopperTankardDrinkItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/withering_dross_swig")))
            .register();

    // 普通食物或 DrinkItem（无容器的饮料/食物）
    public static final ItemEntry<Item> BORSCHT = REGISTRATE
            .item("borscht", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/borscht")))
            .register();

    public static final ItemEntry<Item> NETTLE_SOUP = REGISTRATE
            .item("nettle_soup", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/nettle_soup")))
            .register();

    public static final ItemEntry<Item> RADIANT_BREW = REGISTRATE
            .item("radiant_brew", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/radiant_brew")))
            .register();

    public static final ItemEntry<Item> ROOT_BEER = REGISTRATE
            .item("root_beer", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/root_beer")))
            .register();

    public static final ItemEntry<Item> SCARLET_CHEESEBURGER = REGISTRATE
            .item("scarlet_cheeseburger", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/scarlet_cheeseburger")))
            .register();

    public static final ItemEntry<Item> WHITE_STRAWBERRY_CAKE_SLICE = REGISTRATE
            .item("white_strawberry_cake_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/white_strawberry_cake_slice")))
            .register();

    public static final ItemEntry<DrinkItem> WHITE_STRAWBERRY_MILKSHAKE = REGISTRATE
            .item("white_strawberry_milkshake", DrinkItem::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/white_strawberry_milkshake")))
            .register();

    public static final ItemEntry<Item> WHITE_STRAWBERRY_ICE_CREAM = REGISTRATE
            .item("white_strawberry_ice_cream", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3f).build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/white_strawberry_ice_cream")))
            .register();

    // 非食物：粉末类（不添加 food 属性）
    public static final ItemEntry<Item> POWDERED_ADZUKI_BEANS = REGISTRATE
            .item("powdered_adzuki_beans", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/powdered_adzuki_beans")))
            .register();

    public static final ItemEntry<Item> POWDERED_BLACK_TEA_LEAVES = REGISTRATE
            .item("powdered_black_tea_leaves", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/powdered_black_tea_leaves")))
            .register();

    public static final ItemEntry<Item> POWDERED_GREEN_TEA_LEAVES = REGISTRATE
            .item("powdered_green_tea_leaves", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/powdered_green_tea_leaves")))
            .register();

    public static final ItemEntry<Item> POWDERED_MINT_LEAVES = REGISTRATE
            .item("powdered_mint_leaves", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/powdered_mint_leaves")))
            .register();

    public static final ItemEntry<Item> POWDERED_VANILLA_PODS = REGISTRATE
            .item("powdered_vanilla_pods", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/powdered_vanilla_pods")))
            .register();

    public static final ItemEntry<Item> POWDERED_YELLOW_TEA_LEAVES = REGISTRATE
            .item("powdered_yellow_tea_leaves", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/powdered_yellow_tea_leaves")))
            .register();

    // 其它单独列出的项
    public static final ItemEntry<Item> RADIANT_BREW_PLAIN = REGISTRATE
            .item("radiant_brew", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/integrated/bundled/radiant_brew")))
            .register();

    // --- 自动插入结束 ---
    //雄蜂
    public static final ItemEntry<Item> COLLAPSE_DRONE = REGISTRATE
            .item("collapse_drone", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/special_item/collapse_drone"))
                    .customLoader(HaloModelBuilder::new))
            .register();

    //蜂后
    public static final ItemEntry<Item> COLLAPSE_QUEEN = REGISTRATE
            .item("collapse_queen", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/special_item/collapse_queen"))
                    .customLoader(HaloModelBuilder::new))
            .register();

    //公主蜂
    public static final ItemEntry<Item> COLLAPSE_PRINCESS = REGISTRATE
            .item("collapse_princess", Item::new)
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider.modLoc("item/special_item/collapse_princess"))
                    .customLoader(HaloModelBuilder::new))
            .register();

    //纯净番茄饲料
    public static final ItemEntry<Item> PURE_TOMATO_FEED = REGISTRATE
            .item("pure_tomato_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/pure_tomato_feed")))
            .register();

    //纯净南瓜饲料
    public static final ItemEntry<Item> PURE_PUMKIN_FEED = REGISTRATE
            .item("pure_pumpkin_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/pure_pumpkin_feed")))
            .register();

    //高级水果纯净饲料
    public static final ItemEntry<Item> ADVANCED_PURE_FRUIT_FEED = REGISTRATE
            .item("advanced_pure_fruit_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/advanced_pure_fruit_feed")))
            .register();

    //高级桃桃纯净饲料
    public static final ItemEntry<Item> ADVANCED_PURE_PEACH_FEED = REGISTRATE
            .item("advanced_pure_peach_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/advanced_pure_peach_feed")))
            .register();

    //高级瓜瓜纯净饲料
    public static final ItemEntry<Item> ADVANCED_PURE_MELON_MELON_FEED = REGISTRATE
            .item("advanced_pure_melon_melon_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/advanced_pure_melon_melon_feed")))
            .register();

   //纯净牛肉饲料
    public static final ItemEntry<Item> PURE_BEEF_FEED = REGISTRATE
            .item("pure_beef_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/pure_beef_feed")))
            .register();

  //纯净猪肉饲料
    public static final ItemEntry<Item> PURE_PORKCHOP_FEED = REGISTRATE
            .item("pure_porkchop_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/pure_porkchop_feed")))
            .register();

    //高级肉类纯净饲料
    public static final ItemEntry<Item> ADVANCED_PURE_MEAT_FEED = REGISTRATE
            .item("advanced_pure_meat_feed", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/advanced_pure_meat_feed")))
            .register();

    public static final ItemEntry<Item> WINE_VIAL = REGISTRATE
            .item("wine_vial", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/wine_vial")))
            .register();

    public static final ItemEntry<Item> WINE_BOTTLE = REGISTRATE
            .item("wine_bottle", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/italian_delight/wine_bottle")))
            .register();


    //木制固沙方格
    public static final ItemEntry<Item> WOODEN_SAND_FIXATION_GRID = REGISTRATE
            .item("wooden_sand_fixation_grid", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/wooden_sand_fixation_grid")))
            .register();

    //珍珠粉
    public static final ItemEntry<Item> PEARL_DUST = REGISTRATE
            .item("pearl_dust", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/pearl_dust")))
            .register();

   //青钕刀
    public static final ItemEntry<DelightKnifeItem> AZURE_NEODYMIUM_KNIFE = REGISTRATE
            .item("azure_neodymium_knife", p -> new DelightKnifeItem(Tiers.IRON, 0, -2.0F, p))
            .model((ctx, provider) -> provider.handheld(ctx::get, provider.modLoc("item/manmade/tool/azure_neodymium_knife")))
            .register();

  //赤钕刀
    public static final ItemEntry<DelightKnifeItem> SCARLET_NEODYMIUM_KNIFE = REGISTRATE
            .item("scarlet_neodymium_knife", p -> new DelightKnifeItem(Tiers.IRON, 0, -2.0F, p))
            .model((ctx, provider) -> provider.handheld(ctx::get, provider.modLoc("item/manmade/tool/scarlet_neodymium_knife")))
            .register();

//沉重骨刀
    public static final ItemEntry<DelightKnifeItem> CLEAVER_OF_HEAVY_BONE = REGISTRATE
            .item("cleaver_of_heavy_bone", p -> new DelightKnifeItem(Tiers.IRON, 0, -2.0F, p))
            .model((ctx, provider) -> provider.handheld(ctx::get, provider.modLoc("item/manmade/tool/cleaver_of_heavy_bone")))
            .register();
//神秘的柠檬
    public static final ItemEntry<fishy_lemon> FISHY_LEMON = REGISTRATE
            .item("fishy_lemon", fishy_lemon::new)
            .model(NonNullBiConsumer.noop())
            .register();

   //易拉罐
    public static final ItemEntry<Item> CAN = REGISTRATE
            .item("can", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/can")))
            .register();

   //铜酒杯
    public static final ItemEntry<Item> COPPER_TANKARD = REGISTRATE
            .item("copper_tankard", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/tool/copper_tankard")))
            .register();

   //铜杯子
    public static final ItemEntry<Item> COPPER_CUP = REGISTRATE
            .item("copper_cup", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/tool/copper_cup")))
            .register();

   //玻璃酒杯
    public static final ItemEntry<Item> GLASS_TANKARD = REGISTRATE
            .item("glass_tankard", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/tool/glass_tankard")))
            .register();

   //包装袋
    public static final ItemEntry<Item> SYALS_BAG = REGISTRATE
            .item("syals_bag", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/syals_bag")))
            .register();

    //袋
    public static final ItemEntry<Item> PAPER_BAG = REGISTRATE
            .item("paper_bag", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/paper_bag")))
            .register();

   //瓷盘
    public static final ItemEntry<Item> PORCELAIN_PLATE = REGISTRATE
            .item("porcelain_plate", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/porcelain_plate")))
            .register();

    //瓷碗
    public static final ItemEntry<Item> PORCELAIN_BOWL = REGISTRATE
            .item("porcelain_bowl", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/porcelain_bowl")))
            .register();

    public static final ItemEntry<Item> CERAMIC_CLAY = REGISTRATE
            .item("ceramic_clay", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/ceramic_clay")))
            .register();

    public static final ItemEntry<Item> EARTH_BRICK = REGISTRATE
            .item("earth_brick", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/earth_brick")))
            .register();

    public static final ItemEntry<Item> MUD_BRICK = REGISTRATE
            .item("mud_brick", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/mud_brick")))
            .register();

    public static final ItemEntry<Item> UNFIRED_BOWL = REGISTRATE
            .item("unfired_bowl", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/unfired_bowl")))
            .register();

    public static final ItemEntry<Item> UNFIRED_PLATE = REGISTRATE
            .item("unfired_plate", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/unfired_plate")))
            .register();

   //钨钢锭
    public static final ItemEntry<Item> TUNGSTEN_STEEL = REGISTRATE
            .item("tungsten_steel", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/tungsten_steel")))
            .register();

   //铝锭
    public static final ItemEntry<Item> ALUMINUM_INGOT = REGISTRATE
            .item("aluminum_ingot", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/aluminum_ingot")))
            .register();

   //铝箔
    public static final ItemEntry<Item> ALUMINUM_FOIL = REGISTRATE
            .item("aluminum_foil", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/aluminum_foil")))
            .register();

   //树液
    public static final ItemEntry<Item> TREE_SAP = REGISTRATE
            .item("tree_sap", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/tree_products/tree_sap")))
            .register();

   //生漆桶
   public static final ItemEntry<RecipeBucketItem> RAW_LACQUER_BUCKET = REGISTRATE
            .item("raw_lacquer_bucket", RecipeBucketItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/tree_products/raw_lacquer_bucket")))
            .register();

  //生乳胶桶
   public static final ItemEntry<RecipeBucketItem> URUSHI_BUCKET = REGISTRATE
            .item("urushi_bucket", RecipeBucketItem::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/tree_products/urushi_bucket")))
            .register();

    //紫色饮料测试 — 改为使用 MasonJarFood
    public static final ItemEntry<MasonJarFood> PURPLE_DRINK_TEXT = REGISTRATE
            .item("purple_drink_text", MasonJarFood::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationMod(2.3f) .build()))
            .model((ctx, provider) -> provider
                    .generated(ctx::get, provider
                            .modLoc("item/food/gregtech/purple_drink")))
            .register();

    //模具
    public static final ItemEntry<Item> EMPTY_COPPER_MOLD = REGISTRATE
            .item("empty_copper_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/empty_copper_mold")))
            .register();

     //模具
    public static final ItemEntry<Item> DITALINI_MOLD = REGISTRATE
            .item("ditalini_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/ditalini_mold")))
            .register();

     //模具
    public static final ItemEntry<Item> LASAGNA_MOLD = REGISTRATE
            .item("lasagna_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/lasagna_mold")))
            .register();

     //模具
    public static final ItemEntry<Item> PASTA_MOLD = REGISTRATE
            .item("pasta_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/pasta_mold")))
            .register();

     //模具
    public static final ItemEntry<Item> RIGATONI_MOLD = REGISTRATE
            .item("rigatoni_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/rigatoni_mold")))
            .register();

     //模具
    public static final ItemEntry<Item> SPAGHETTI_MOLD = REGISTRATE
            .item("spaghetti_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/spaghetti_mold")))
            .register();

     //模具
    public static final ItemEntry<Item> TAGLIATELLE_MOLD = REGISTRATE
            .item("tagliatelle_mold", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/mold/tagliatelle_mold")))
            .register();

     //罐头罐子
    public static final ItemEntry<Item> EMPTY_CAN = REGISTRATE
            .item("empty_can", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/tin_can")))
            .register();
    //烧烤签
    public static final ItemEntry<Item> METAL_SKEWER = REGISTRATE
            .item("metal_skewer", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/metal_skewer")))
            .register();
     // 自动注册的月饼（基于外部映射）。有效改动字段：注册名、常量名、馅料颜色（ARGB）
     // 下面为来自附加清单的月饼注册（仅包含带有 <item:...> 映射的条目）



/*
//调色果冻模板 不要覆盖
    public static final ItemEntry<JellyItem> 常量名 = REGISTRATE
            .item("注册名", p -> new JellyItem(p, 颜色))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.4f)
                    .build()))
            .model((ctx, provider) -> ItemModelUtil.jellyModel(ctx, provider,
                    "list:item/food/component/jelly_base",
                    "list:item/food/component/jelly"))
            .register();
*/

    public static final ItemEntry<Item> BLACK_BEAUTY_MELON_SLICE = REGISTRATE
            .item("black_beauty_melon_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/melon/black_beauty_melon_slice")))
            .register();

    public static final ItemEntry<Item> GEM_MELON_SLICE = REGISTRATE
            .item("gem_melon_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/melon/gem_melon_slice")))
            .register();

    public static final ItemEntry<Item> FROST_MELON_SLICE = REGISTRATE
            .item("frost_melon_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/melon/frost_melon_slice")))
            .register();

    public static final ItemEntry<Item> QI_FRUIT_SLICE = REGISTRATE
            .item("qi_fruit_slice", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/melon/qi_fruit_slice")))
            .register();

    public static final ItemEntry<Item> FINGER_LEMON = REGISTRATE
            .item("finger_lemon", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/finger_lemon")))
            .register();

    public static final ItemEntry<Item> SMALL_LIME = REGISTRATE
            .item("small_lime", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/small_lime")))
            .register();

    public static final ItemEntry<Item> GUIWEI_LITCHI = REGISTRATE
            .item("guiwei_litchi", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/guiwei_litchi")))
            .register();

    public static final ItemEntry<Item> LITCHI_KING = REGISTRATE
            .item("litchi_king", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/litchi_king")))
            .register();

    public static final ItemEntry<Item> PETRI_DISH = REGISTRATE
            .item("petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish")))
            .register();

    public static final ItemEntry<Item> PENICILLIUM_ROQUEFORTI_PETRI_DISH = REGISTRATE
            .item("penicillium_roqueforti_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> BACILLUS_SUBTILIS_PETRI_DISH = REGISTRATE
            .item("bacillus_subtilis_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> LACTOBACILLUS_PENTOSIS_PETRI_DISH = REGISTRATE
            .item("lactobacillus_pentosis_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> PHYCOMYCES_BLAKESLEEANUS_PETRI_DISH = REGISTRATE
            .item("phycomyces_blakesleeanus_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> BREVIBACTERIUM_PETRI_DISH = REGISTRATE
            .item("brevibacterium_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> BIFIDOBACTERIUM_PETRI_DISH = REGISTRATE
            .item("bifidobacterium_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> ESCHERICHIA_PETRI_DISH = REGISTRATE
            .item("escherichia_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> STREPTOCOCCUS_PYOGENES_PETRI_DISH = REGISTRATE
            .item("streptococcus_pyogenes_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> CUPRIAVIDUS_PETRI_DISH = REGISTRATE
            .item("cupriavidus_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> SHEWANELLA_PETRI_DISH = REGISTRATE
            .item("shewanella_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static final ItemEntry<Item> CLOSTRIDIUM_PASTEURINUM_PETRI_DISH = REGISTRATE
            .item("clostridium_pasteurianum_petri_dish", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/manmade/gregtech/petri_dish_2")))
            .register();

    public static void register() {
        ModItemsEgg.register();
        ModItemsMooncake.register();
        ModItemsJelly.register();
        ModItemsSmokerFish.register();
    }
}
