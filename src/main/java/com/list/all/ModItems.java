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

    //照抄
    public static final ItemEntry<EggItem> TEST_EGG = REGISTRATE
            .item("test_egg", p -> new EggItem(p, 0x55ffff))
            .model(ItemModelUtil::eggItemModel)
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

    //草鱼卵
    public static final ItemEntry<EggItem> GRASS_CARO_EGG = REGISTRATE
            .item("grass_carp_egg", p -> new EggItem(p, 0xAFAF60))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鳜鱼卵 (Mandarin fish egg) - 淡橙色
    public static final ItemEntry<EggItem> MANDARIN_FISH_EGG = REGISTRATE
            .item("mandarin_fish_egg", p -> new EggItem(p, 0xFFD580))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 大黄鱼卵 (Large yellow croaker egg)
    public static final ItemEntry<EggItem> LARGE_YELLOW_CROAKER_EGG = REGISTRATE
            .item("large_yellow_croaker_egg", p -> new EggItem(p, 0xFFC125))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 银鲳鱼卵 (Silver pomfret egg)
    public static final ItemEntry<EggItem> SILVER_POMFRET_EGG = REGISTRATE
            .item("silver_pomfret_egg", p -> new EggItem(p, 0xC0C0C0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 多宝鱼卵 (Turbot egg) -
    public static final ItemEntry<EggItem> TURBOT_EGG = REGISTRATE
            .item("turbot_egg", p -> new EggItem(p, 0x87CEEB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 红石斑鱼卵 (Red grouper egg) -
    public static final ItemEntry<EggItem> RED_GROUPER_EGG = REGISTRATE
            .item("red_grouper_egg", p -> new EggItem(p, 0xFF4500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鹦嘴鱼卵 (Parrotfish egg) -
    public static final ItemEntry<EggItem> PARROT_FISH_EGG = REGISTRATE
            .item("parrotfish_egg", p -> new EggItem(p, 0x40E0D0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 苏眉鱼卵 (Camouflage grouper egg) -
    public static final ItemEntry<EggItem> CAMOUFLAGE_GROUPER_EGG = REGISTRATE
            .item("camouflage_grouper_egg", p -> new EggItem(p, 0x9370DB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 锦鲤卵 (Koi egg) -
    public static final ItemEntry<EggItem> KOI_EGG = REGISTRATE
            .item("koi_egg", p -> new EggItem(p, 0xF0F8FF))
            .properties(p -> p.rarity(Rarity.EPIC))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鸡鱼卵 (Threadfin bream egg) -
    public static final ItemEntry<EggItem> THREADFIN_BREAM_EGG = REGISTRATE
            .item("threadfin_bream_egg", p -> new EggItem(p, 0xFFA500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 云斑海猪鱼卵 (Checkerboard wrasse egg) -
    public static final ItemEntry<EggItem> CHECKERBOARD_WRASSE_EGG = REGISTRATE
            .item("checkerboard_wrasse_egg", p -> new EggItem(p, 0xFFFF00))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 海鳗卵 (Moray eel egg) -
    public static final ItemEntry<EggItem> MORAY_EEL_EGG = REGISTRATE
            .item("moray_eel_egg", p -> new EggItem(p, 0x6B8E23))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鲅鱼卵 (Spanish mackerel egg)
    public static final ItemEntry<EggItem> SPANISH_MACKEREL_EGG = REGISTRATE
            .item("spanish_mackerel_egg", p -> new EggItem(p, 0x4682B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 条纹鲈鱼卵 (Striped bass egg)
    public static final ItemEntry<EggItem> STRIPED_BASS_EGG = REGISTRATE
            .item("striped_bass_egg", p -> new EggItem(p, 0x5F9EA0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鳙鱼卵 (Bighead carp egg) -
    public static final ItemEntry<EggItem> BIGHEAD_CARP_EGG = REGISTRATE
            .item("bighead_carp_egg", p -> new EggItem(p, 0xFFB6C1))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鲥鱼卵 (Chinese shad egg)
    public static final ItemEntry<EggItem> CHINESE_SHAD_EGG = REGISTRATE
            .item("chinese_shad_egg", p -> new EggItem(p, 0xFFF8DC))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 秋刀鱼卵 (Pacific saury egg) -
    public static final ItemEntry<EggItem> PACIFIC_SAURY_EGG = REGISTRATE
            .item("pacific_saury_egg", p -> new EggItem(p, 0xFFA07A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 火鼠鱼卵 (Fire rat fish egg) - 特殊颜色规范：深橙色
    public static final ItemEntry<EggItem> FIRE_RAT_FISH_EGG = REGISTRATE
            .item("fire_rat_fish_egg", p -> new EggItem(p, 0xFF0000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 冰棘鱼卵 (Icethorn fish egg) - 特殊颜色规范：水色
    public static final ItemEntry<EggItem> ICETHORN_FISH_EGG = REGISTRATE
            .item("icethorn_fish_egg", p -> new EggItem(p, 0x00BFFF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 蛇鱼卵
    public static final ItemEntry<EggItem> SNAKEHEAD_FISH_EGG = REGISTRATE
            .item("snakehead_fish_egg", p -> new EggItem(p, 0x8B4513))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 红鲷鱼卵
    public static final ItemEntry<EggItem> RED_SNAPPER_EGG = REGISTRATE
            .item("red_snapper_egg", p -> new EggItem(p, 0xB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 魔鬼鱼卵
    public static final ItemEntry<EggItem> DEVIL_RAY_EGG = REGISTRATE
            .item("devil_ray_egg", p -> new EggItem(p, 0x2F4F4F))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 长颌鲚卵
    public static final ItemEntry<EggItem> LONGJAW_COILIA_EGG = REGISTRATE
            .item("longjaw_coilia_egg", p -> new EggItem(p, 0x4682B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 小银鱼卵
    public static final ItemEntry<EggItem> SMALL_WHITEBAIT_EGG = REGISTRATE
            .item("small_whitebait_egg", p -> new EggItem(p, 0xD3D3D3))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 胭脂鱼卵
    public static final ItemEntry<EggItem> ROSY_BARB_EGG = REGISTRATE
            .item("rosy_barb_egg", p -> new EggItem(p, 0xFF69B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 凤尾鱼卵
    public static final ItemEntry<EggItem> ANCHOVY_EGG = REGISTRATE
            .item("anchovy_egg", p -> new EggItem(p, 0x708090))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 马面鱼卵
    public static final ItemEntry<EggItem> HORSEFACE_FISH_EGG = REGISTRATE
            .item("horseface_fish_egg", p -> new EggItem(p, 0xD2B48C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 黄鳝卵
    public static final ItemEntry<EggItem> RICE_PADDY_EEL_EGG = REGISTRATE
            .item("rice_paddy_eel_egg", p -> new EggItem(p, 0xDA70D6))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鲽鱼卵
    public static final ItemEntry<EggItem> SOLE_FISH_EGG = REGISTRATE
            .item("sole_fish_egg", p -> new EggItem(p, 0xDEB887))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 乌青鱼卵
    public static final ItemEntry<EggItem> BLACK_AMUR_BREAM_EGG = REGISTRATE
            .item("black_amur_bream_egg", p -> new EggItem(p, 0x000080))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鳊鱼卵
    public static final ItemEntry<EggItem> BREAM_EGG = REGISTRATE
            .item("bream_egg", p -> new EggItem(p, 0x8FBC8F))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 沙丁鱼卵
    public static final ItemEntry<EggItem> SARDINE_EGG = REGISTRATE
            .item("sardine_egg", p -> new EggItem(p, 0x20B2AA))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 海鲈鱼卵
    public static final ItemEntry<EggItem> SEA_BASS_EGG = REGISTRATE
            .item("sea_bass_egg", p -> new EggItem(p, 0x4169E1))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 红歌鲤卵
    public static final ItemEntry<EggItem> RED_SONG_CARP_EGG = REGISTRATE
            .item("red_song_carp_egg", p -> new EggItem(p, 0xDC143C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 巴浪鱼卵
    public static final ItemEntry<EggItem> BARRACUDA_EGG = REGISTRATE
            .item("barracuda_egg", p -> new EggItem(p, 0x7FFFD4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 三刀鱼卵
    public static final ItemEntry<EggItem> THREE_KNIFE_FISH_EGG = REGISTRATE
            .item("three_knife_fish_egg", p -> new EggItem(p, 0x000000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 马头鱼卵
    public static final ItemEntry<EggItem> HORSEHEAD_FISH_EGG = REGISTRATE
            .item("horsehead_fish_egg", p -> new EggItem(p, 0x8B4513))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 花英斑卵
    public static final ItemEntry<EggItem> FLOWER_SPOTTED_GROUPER_EGG = REGISTRATE
            .item("flower_spotted_grouper_egg", p -> new EggItem(p, 0xFF1493))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 深海鲑鱼卵
    public static final ItemEntry<EggItem> DEEP_SEA_SALMON_EGG = REGISTRATE
            .item("deep_sea_salmon_egg", p -> new EggItem(p, 0xFFA07A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 蓝飞鱼卵
    public static final ItemEntry<EggItem> BLUE_FLYING_FISH_EGG = REGISTRATE
            .item("blue_flying_fish_egg", p -> new EggItem(p, 0x0000FF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 飞鱼卵
    public static final ItemEntry<EggItem> FLYING_FISH_EGG = REGISTRATE
            .item("flying_fish_egg", p -> new EggItem(p, 0xFFFF00))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 雨鱼卵
    public static final ItemEntry<EggItem> RAINFISH_EGG = REGISTRATE
            .item("rainfish_egg", p -> new EggItem(p, 0x87CEEB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 白条鱼卵
    public static final ItemEntry<EggItem> WHITE_STRIPE_FISH_EGG = REGISTRATE
            .item("white_stripe_fish_egg", p -> new EggItem(p, 0xFFFFFF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 赤魟卵
    public static final ItemEntry<EggItem> RED_STINGRAY_EGG = REGISTRATE
            .item("red_stingray_egg", p -> new EggItem(p, 0xB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 针鱼卵
    public static final ItemEntry<EggItem> NEEDLEFISH_EGG = REGISTRATE
            .item("needlefish_egg", p -> new EggItem(p, 0x32CD32))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 龙利鱼卵
    public static final ItemEntry<EggItem> SOLE_FISH_EGG_DUPLICATE = REGISTRATE
            .item("sole_fish_egg", p -> new EggItem(p, 0xDEB887))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 青花鱼卵
    public static final ItemEntry<EggItem> CHUB_MACKEREL_EGG = REGISTRATE
            .item("chub_mackerel_egg", p -> new EggItem(p, 0x4682B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 桂鱼卵
    public static final ItemEntry<EggItem> CHINESE_PERCH_EGG = REGISTRATE
            .item("chinese_perch_egg", p -> new EggItem(p, 0xFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 带鱼卵
    public static final ItemEntry<EggItem> HAIRTAIL_EGG = REGISTRATE
            .item("hairtail_egg", p -> new EggItem(p, 0xC0C0C0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 大马哈鱼卵
    public static final ItemEntry<EggItem> CHUM_SALMON_EGG = REGISTRATE
            .item("chum_salmon_egg", p -> new EggItem(p, 0xFA8072))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();



    // 草菇
    public static final ItemEntry<Item> STRAW_MUSHROOM =REGISTRATE
            .item("straw_mushroom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/mushroom/straw_mushroom")))
            .register();

    // 海蘑菇
    public static final ItemEntry<Item> SEA_MUSHROOM =REGISTRATE
            .item("sea_mushroom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/mushroom/sea_mushroom")))
            .register();

    // 洞穴菇
    public static final ItemEntry<Item> CAVE_MUSHROOM =REGISTRATE
            .item("cave_mushroom", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/mushroom/cave_mushroom")))
            .register();

    // 草菇菌落
    public static final ItemEntry<Item> STRAW_MUSHROOM_COLONY =REGISTRATE
            .item("straw_mushroom_colony", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/colony/straw_mushroom_colony")))
            .register();

    // 海蘑菇菌落
    public static final ItemEntry<Item> SEA_MUSHROOM_COLONY =REGISTRATE
            .item("sea_mushroom_colony", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/colony/sea_mushroom_colony")))
            .register();

    // 洞穴菇菌落
    public static final ItemEntry<Item> CAVE_MUSHROOM_COLONY =REGISTRATE
            .item("cave_mushroom_colony", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/colony/cave_mushroom_colony")))
            .register();








    // 蟹肉
    public static final ItemEntry<Item> CRAB_MEAT = REGISTRATE
            .item("crab_meat", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/meat/crab_meat")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationMod(1.2f)
                    .build()))
            .register();



    public static void register() {
    }
}
