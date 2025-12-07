package com.list.all;

import com.list.item.EggItem;
import com.list.item.GlowingItem;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

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
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish/lifeafter//")))
            .register();

    */

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
    public static final ItemEntry<EggItem> FLUKE_EGG = REGISTRATE
            .item("fluke_egg", p -> new EggItem(p, 0xDEB887))
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
    public static final ItemEntry<EggItem> SOLE_FISH_EGG = REGISTRATE
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

    // 乌翅真鲨卵
    public static final ItemEntry<EggItem> BLACKFIN_SHARK_EGG = REGISTRATE
            .item("blackfin_shark_egg", p -> new EggItem(p, 0x4A4A4A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    // 血红龙卵
    public static final ItemEntry<EggItem> BLOOD_RED_DRAGONFISH_EGG = REGISTRATE
            .item("blood_red_dragonfish_egg", p -> new EggItem(p, 0x8B0000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    //  红海黄金蝶卵
    public static final ItemEntry<EggItem> RED_SEA_GOLDEN_BUTTERFLY_EGG = REGISTRATE
            .item("red_sea_golden_butterfly_egg", p -> new EggItem(p, 0xFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 紫海刺水母卵
    public static final ItemEntry<EggItem> PURPLE_SEA_JELLYFISH_EGG = REGISTRATE
            .item("purple_sea_jellyfish_egg", p -> new EggItem(p, 0x9370DB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 皇冠狗头卵
    public static final ItemEntry<EggItem> CROWN_DOGHEAD_EGG = REGISTRATE
            .item("crown_doghead_egg", p -> new EggItem(p, 0xFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 花高头龙睛卵
    public static final ItemEntry<EggItem> FLOWER_HIGHHEAD_DRAGONEYE_EGG = REGISTRATE
            .item("flower_highhead_dragoneye_egg", p -> new EggItem(p, 0xFF69B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 线纹海马卵
    public static final ItemEntry<EggItem> STRIPED_SEAHORSE_EGG = REGISTRATE
            .item("striped_seahorse_egg", p -> new EggItem(p, 0x40E0D0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 黄尾蓝魔卵
    public static final ItemEntry<EggItem> YELLOWTAIL_BLUE_DEMON_EGG = REGISTRATE
            .item("yellowtail_blue_demon_egg", p -> new EggItem(p, 0x1E90FF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 秘鲁神仙卵
    public static final ItemEntry<EggItem> PERUVIAN_FAIRYFISH_EGG = REGISTRATE
            .item("peruvian_fairyfish_egg", p -> new EggItem(p, 0xFF69B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 三间火箭卵
    public static final ItemEntry<EggItem> THREE_SPOTTED_ROCKETFISH_EGG = REGISTRATE
            .item("three_spotted_rocketfish_egg", p -> new EggItem(p, 0xFF4500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 红剑卵
    public static final ItemEntry<EggItem> RED_SWORDFISH_EGG = REGISTRATE
            .item("red_swordfish_egg", p -> new EggItem(p, 0xDC143C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 吕宋棘海星卵
    public static final ItemEntry<EggItem> LUZON_SPINY_STARFISH_EGG = REGISTRATE
            .item("luzon_spiny_starfish_egg", p -> new EggItem(p, 0xFF6347))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 红腹食人鲳卵
    public static final ItemEntry<EggItem> RED_BELLIED_PIRANHA_EGG = REGISTRATE
            .item("red_bellied_piranha_egg", p -> new EggItem(p, 0xB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

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

// 莲藕
public static final ItemEntry<Item> LOTUS_ROOT = REGISTRATE
        .item("lotus_root", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/lotus_root")))
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

// 绿豆
public static final ItemEntry<Item> MUNG_BEAN = REGISTRATE
        .item("mung_bean", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/lifafter/mung_bean")))
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
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/red_cabbage")))
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

// 豌豆
public static final ItemEntry<Item> PEA = REGISTRATE
        .item("pea", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/pea")))
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
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/cp/red_onion")))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(1.2f)
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

// 红葱头（红葱头一般叫红毛葱）
public static final ItemEntry<Item> SHALLOT = REGISTRATE
        .item("shallot", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/vegetable/stardewvalley/shallot")))
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
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/nectarine")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 腰果
public static final ItemEntry<Item> CASHEW = REGISTRATE
        .item("cashew", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/cashew")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 碧根果
public static final ItemEntry<Item> PECAN = REGISTRATE
        .item("pecan", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/pecan")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 开心果
public static final ItemEntry<Item> PISTACHIO = REGISTRATE
        .item("pistachio", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/stardewvalley/pistachio")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();


/*
// 84西瓜（明日之后 水果 真的很少）
public static final ItemEntry<Item> WATERMELON_84 = REGISTRATE
        .item("watermelon_84", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/watermelon_84")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

// 黄桃
public static final ItemEntry<Item> YELLOW_PEACH = REGISTRATE
        .item("yellow_peach", Item::new)
        .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fruit/lifafter/yellow_peach")))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(3)
                .saturationMod(1.2f)
                .build()))
        .register();

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

*/


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
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/cutting/red_cabbage_leaf")))
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




    public static void register() {
    }
}
