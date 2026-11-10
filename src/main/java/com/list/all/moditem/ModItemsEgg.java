package com.list.all.moditem;

import com.list.item.util.EggItem;
import com.list.util.ItemModelUtil;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import static com.list.ListMod.REGISTRATE;

public class ModItemsEgg {

    public static final ItemEntry<EggItem> TEST_EGG = REGISTRATE
            .item("test_egg", p -> new EggItem(p, 0x55ffff))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> GRASS_CARO_EGG = REGISTRATE
            .item("grass_carp_egg", p -> new EggItem(p, 0xAFAF60))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> MANDARIN_FISH_EGG = REGISTRATE
            .item("mandarin_fish_egg", p -> new EggItem(p, 0xFFD580))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> LARGE_YELLOW_CROAKER_EGG = REGISTRATE
            .item("large_yellow_croaker_egg", p -> new EggItem(p, 0xFFC125))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SILVER_POMFRET_EGG = REGISTRATE
            .item("silver_pomfret_egg", p -> new EggItem(p, 0xC0C0C0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> TURBOT_EGG = REGISTRATE
            .item("turbot_egg", p -> new EggItem(p, 0x87CEEB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RED_GROUPER_EGG = REGISTRATE
            .item("red_grouper_egg", p -> new EggItem(p, 0xFF4500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> PARROT_FISH_EGG = REGISTRATE
            .item("parrotfish_egg", p -> new EggItem(p, 0x40E0D0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CAMOUFLAGE_GROUPER_EGG = REGISTRATE
            .item("camouflage_grouper_egg", p -> new EggItem(p, 0x9370DB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> KOI_EGG = REGISTRATE
            .item("koi_egg", p -> new EggItem(p, 0xF0F8FF))
            .properties(p -> p.rarity(Rarity.EPIC))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> THREADFIN_BREAM_EGG = REGISTRATE
            .item("threadfin_bream_egg", p -> new EggItem(p, 0xFFA500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CHECKERBOARD_WRASSE_EGG = REGISTRATE
            .item("checkerboard_wrasse_egg", p -> new EggItem(p, 0xFFFF00))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> MORAY_EEL_EGG = REGISTRATE
            .item("moray_eel_egg", p -> new EggItem(p, 0x6B8E23))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SPANISH_MACKEREL_EGG = REGISTRATE
            .item("spanish_mackerel_egg", p -> new EggItem(p, 0x4682B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> STRIPED_BASS_EGG = REGISTRATE
            .item("striped_bass_egg", p -> new EggItem(p, 0x5F9EA0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> BIGHEAD_CARP_EGG = REGISTRATE
            .item("bighead_carp_egg", p -> new EggItem(p, 0xFFB6C1))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CHINESE_SHAD_EGG = REGISTRATE
            .item("chinese_shad_egg", p -> new EggItem(p, 0xFFF8DC))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> PACIFIC_SAURY_EGG = REGISTRATE
            .item("pacific_saury_egg", p -> new EggItem(p, 0xFFA07A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> FIRE_RAT_FISH_EGG = REGISTRATE
            .item("fire_rat_fish_egg", p -> new EggItem(p, 0xFF0000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> ICETHORN_FISH_EGG = REGISTRATE
            .item("icethorn_fish_egg", p -> new EggItem(p, 0x00BFFF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SNAKEHEAD_FISH_EGG = REGISTRATE
            .item("snakehead_fish_egg", p -> new EggItem(p, 0x8B4513))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RED_SNAPPER_EGG = REGISTRATE
            .item("red_snapper_egg", p -> new EggItem(p, 0xB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> DEVIL_RAY_EGG = REGISTRATE
            .item("devil_ray_egg", p -> new EggItem(p, 0x2F4F4F))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> LONGJAW_COILIA_EGG = REGISTRATE
            .item("longjaw_coilia_egg", p -> new EggItem(p, 0x4682B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SMALL_WHITEBAIT_EGG = REGISTRATE
            .item("small_whitebait_egg", p -> new EggItem(p, 0xD3D3D3))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> ROSY_BARB_EGG = REGISTRATE
            .item("rosy_barb_egg", p -> new EggItem(p, 0xFF69B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> ANCHOVY_EGG = REGISTRATE
            .item("anchovy_egg", p -> new EggItem(p, 0x708090))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> HORSEFACE_FISH_EGG = REGISTRATE
            .item("horseface_fish_egg", p -> new EggItem(p, 0xD2B48C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RICE_PADDY_EEL_EGG = REGISTRATE
            .item("rice_paddy_eel_egg", p -> new EggItem(p, 0xDA70D6))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> FLUKE_EGG = REGISTRATE
            .item("fluke_egg", p -> new EggItem(p, 0xDEB887))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> BLACK_AMUR_BREAM_EGG = REGISTRATE
            .item("black_amur_bream_egg", p -> new EggItem(p, 0x000080))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> BREAM_EGG = REGISTRATE
            .item("bream_egg", p -> new EggItem(p, 0x8FBC8F))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SARDINE_EGG = REGISTRATE
            .item("sardine_egg", p -> new EggItem(p, 0x20B2AA))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SEA_BASS_EGG = REGISTRATE
            .item("sea_bass_egg", p -> new EggItem(p, 0x4169E1))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RED_SONG_CARP_EGG = REGISTRATE
            .item("red_song_carp_egg", p -> new EggItem(p, 0xDC143C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> BARRACUDA_EGG = REGISTRATE
            .item("barracuda_egg", p -> new EggItem(p, 0x7FFFD4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> THREE_KNIFE_FISH_EGG = REGISTRATE
            .item("three_knife_fish_egg", p -> new EggItem(p, 0x000000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> HORSEHEAD_FISH_EGG = REGISTRATE
            .item("horsehead_fish_egg", p -> new EggItem(p, 0x8B4513))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> FLOWER_SPOTTED_GROUPER_EGG = REGISTRATE
            .item("flower_spotted_grouper_egg", p -> new EggItem(p, 0xFF1493))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> DEEP_SEA_SALMON_EGG = REGISTRATE
            .item("deep_sea_salmon_egg", p -> new EggItem(p, 0xFFA07A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> BLUE_FLYING_FISH_EGG = REGISTRATE
            .item("blue_flying_fish_egg", p -> new EggItem(p, 0x0000FF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> FLYING_FISH_EGG = REGISTRATE
            .item("flying_fish_egg", p -> new EggItem(p, 0xFFFF00))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RAINFISH_EGG = REGISTRATE
            .item("rainfish_egg", p -> new EggItem(p, 0x87CEEB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> WHITE_STRIPE_FISH_EGG = REGISTRATE
            .item("white_stripe_fish_egg", p -> new EggItem(p, 0xFFFFFF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RED_STINGRAY_EGG = REGISTRATE
            .item("red_stingray_egg", p -> new EggItem(p, 0xB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> NEEDLEFISH_EGG = REGISTRATE
            .item("needlefish_egg", p -> new EggItem(p, 0x32CD32))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> SOLE_FISH_EGG = REGISTRATE
            .item("sole_fish_egg", p -> new EggItem(p, 0xDEB887))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CHUB_MACKEREL_EGG = REGISTRATE
            .item("chub_mackerel_egg", p -> new EggItem(p, 0x4682B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CHINESE_PERCH_EGG = REGISTRATE
            .item("chinese_perch_egg", p -> new EggItem(p, 0xFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> HAIRTAIL_EGG = REGISTRATE
            .item("hairtail_egg", p -> new EggItem(p, 0xC0C0C0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CHUM_SALMON_EGG = REGISTRATE
            .item("chum_salmon_egg", p -> new EggItem(p, 0xFA8072))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> BLACKFIN_SHARK_EGG = REGISTRATE
            .item("blackfin_shark_egg", p -> new EggItem(p, 0x4A4A4A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    public static final ItemEntry<EggItem> BLOOD_RED_DRAGONFISH_EGG = REGISTRATE
            .item("blood_red_dragonfish_egg", p -> new EggItem(p, 0x8B0000))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    public static final ItemEntry<EggItem> RED_SEA_GOLDEN_BUTTERFLY_EGG = REGISTRATE
            .item("red_sea_golden_butterfly_egg", p -> new EggItem(p, 0xFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> PURPLE_SEA_JELLYFISH_EGG = REGISTRATE
            .item("purple_sea_jellyfish_egg", p -> new EggItem(p, 0x9370DB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CROWN_DOGHEAD_EGG = REGISTRATE
            .item("crown_doghead_egg", p -> new EggItem(p, 0xFFD700))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> FLOWER_HIGHHEAD_DRAGONEYE_EGG = REGISTRATE
            .item("flower_highhead_dragoneye_egg", p -> new EggItem(p, 0xFF69B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> STRIPED_SEAHORSE_EGG = REGISTRATE
            .item("striped_seahorse_egg", p -> new EggItem(p, 0x40E0D0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> YELLOWTAIL_BLUE_DEMON_EGG = REGISTRATE
            .item("yellowtail_blue_demon_egg", p -> new EggItem(p, 0x1E90FF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> PERUVIAN_FAIRYFISH_EGG = REGISTRATE
            .item("peruvian_fairyfish_egg", p -> new EggItem(p, 0xFF69B4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> THREE_SPOTTED_ROCKETFISH_EGG = REGISTRATE
            .item("three_spotted_rocketfish_egg", p -> new EggItem(p, 0xFF4500))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RED_SWORDFISH_EGG = REGISTRATE
            .item("red_swordfish_egg", p -> new EggItem(p, 0xDC143C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> LUZON_SPINY_STARFISH_EGG = REGISTRATE
            .item("luzon_spiny_starfish_egg", p -> new EggItem(p, 0xFF6347))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> RED_BELLIED_PIRANHA_EGG = REGISTRATE
            .item("red_bellied_piranha_egg", p -> new EggItem(p, 0xB22222))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

public static final ItemEntry<EggItem> LAVA_PUFFERFISH_EGG = REGISTRATE
        .item("lava_pufferfish_egg", p -> new EggItem(p, 0xFF0000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> OBSIDIANFISH_EGG = REGISTRATE
        .item("obsidianfish_egg", p -> new EggItem(p, 0x000000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SEARING_COD_EGG = REGISTRATE
        .item("searing_cod_egg", p -> new EggItem(p, 0xFFA500))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BONEFISH_EGG = REGISTRATE
        .item("bonefish_egg", p -> new EggItem(p, 0x808080))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> WITHER_BONEFISH_EGG = REGISTRATE
        .item("wither_bonefish_egg", p -> new EggItem(p, 0x000000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BLAZEFISH_EGG = REGISTRATE
        .item("blazefish_egg", p -> new EggItem(p, 0xFFD700))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> MAGMACUBEFISH_EGG = REGISTRATE
        .item("magmacubefish_egg", p -> new EggItem(p, 0x8B4513))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> GLOWDINE_EGG = REGISTRATE
        .item("glowdine_egg", p -> new EggItem(p, 0xFFFF00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SOULSUCKER_EGG = REGISTRATE
        .item("soulsucker_egg", p -> new EggItem(p, 0xA0522D))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> FORTRESS_GROUPER_EGG = REGISTRATE
        .item("fortress_grouper_egg", p -> new EggItem(p, 0xD2691E))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> EYEBALL_FISH_EGG = REGISTRATE
        .item("eyeball_fish_egg", p -> new EggItem(p, 0x8B0000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> FLAME_SQUAT_LOBSTER_EGG = REGISTRATE
        .item("flame_squat_lobster_egg", p -> new EggItem(p, 0x191970))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> OBSIDIAN_SWORD_FISH_EGG = REGISTRATE
        .item("obsidian_sword_fish_egg", p -> new EggItem(p, 0x000000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> STEAM_FLYING_FISH_EGG = REGISTRATE
        .item("steam_flying_fish_egg", p -> new EggItem(p, 0xFFFDD0))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> AGNI_FISH_EGG = REGISTRATE
        .item("agni_fish_egg", p -> new EggItem(p, 0x8B4513))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> AROWANA_FISH_EGG = REGISTRATE
        .item("arowana_fish_egg", p -> new EggItem(p, 0xFF2400))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> QUARTZ_FISH_EGG = REGISTRATE
        .item("quartz_fish_egg", p -> new EggItem(p, 0xFFFDD0))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SCALY_FOOT_SNAIL_EGG = REGISTRATE
        .item("scaly_foot_snail_egg", p -> new EggItem(p, 0x800000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> YETI_CRAB_EGG = REGISTRATE
        .item("yeti_crab_egg", p -> new EggItem(p, 0xAFEEEE))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> LAVA_LAMPREY_EGG = REGISTRATE
        .item("lava_lamprey_egg", p -> new EggItem(p, 0xFFC0CB))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BOULTI_EGG = REGISTRATE
        .item("boulti_egg", p -> new EggItem(p, 0xFFD700))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CAPITAINE_EGG = REGISTRATE
        .item("capitaine_egg", p -> new EggItem(p, 0xC0C0C0))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SYNODONTIS_EGG = REGISTRATE
        .item("synodontis_egg", p -> new EggItem(p, 0x8B7355))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SMALLMOUTH_BASS_EGG = REGISTRATE
        .item("smallmouth_bass_egg", p -> new EggItem(p, 0x556B2F))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BROWN_TROUT_EGG = REGISTRATE
        .item("brown_trout_egg", p -> new EggItem(p, 0x8B4513))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BLUEGILL_EGG = REGISTRATE
        .item("bluegill_egg", p -> new EggItem(p, 0x4682B4))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BAYAD_EGG = REGISTRATE
        .item("bayad_egg", p -> new EggItem(p, 0x696969))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> RAINBOW_TROUT_EGG = REGISTRATE
        .item("rainbow_trout_egg", p -> new EggItem(p, 0xE75480))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> POLLOCK_EGG = REGISTRATE
        .item("pollock_egg", p -> new EggItem(p, 0xBDB76B))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CARP_EGG = REGISTRATE
        .item("carp_egg", p -> new EggItem(p, 0xFFD700))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CATFISH_EGG = REGISTRATE
        .item("catfish_egg", p -> new EggItem(p, 0x9ACD32))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> GAR_EGG = REGISTRATE
        .item("gar_egg", p -> new EggItem(p, 0x556B2F))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> MUSKELLUNGE_EGG = REGISTRATE
        .item("muskellunge_egg", p -> new EggItem(p, 0xB22222))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> MINNOW_EGG = REGISTRATE
        .item("minnow_egg", p -> new EggItem(p, 0xF0E68C))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> PERCH_EGG = REGISTRATE
        .item("perch_egg", p -> new EggItem(p, 0xDAA520))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> ARAPAIMA_EGG = REGISTRATE
        .item("arapaima_egg", p -> new EggItem(p, 0x8B4513))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> PIRANHA_EGG = REGISTRATE
        .item("piranha_egg", p -> new EggItem(p, 0xDC143C))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TAMBAQUI_EGG = REGISTRATE
        .item("tambaqui_egg", p -> new EggItem(p, 0x2E8B57))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BROWN_SHROOMA_EGG = REGISTRATE
        .item("brown_shrooma_egg", p -> new EggItem(p, 0xA0522D))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> RED_SHROOMA_EGG = REGISTRATE
        .item("red_shrooma_egg", p -> new EggItem(p, 0xFF6347))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TUNA_EGG = REGISTRATE
        .item("tuna_egg", p -> new EggItem(p, 0x1E90FF))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> RED_DOT_EGG = REGISTRATE
        .item("red_dot_egg", p -> new EggItem(p, 0xCD5C5C))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> GOLDFISH_EGG = REGISTRATE
        .item("goldfish_egg", p -> new EggItem(p, 0xFF8C00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BLACKFISH_EGG = REGISTRATE
        .item("blackfish_egg", p -> new EggItem(p, 0x2F4F4F))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> ATLANTIC_COD_EGG = REGISTRATE
        .item("atlantic_cod_egg", p -> new EggItem(p, 0xFF8C00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> ATLANTIC_HERRING_EGG = REGISTRATE
        .item("atlantic_herring_egg", p -> new EggItem(p, 0xFFFACD))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> PACIFIC_HALIBUT_EGG = REGISTRATE
        .item("pacific_halibut_egg", p -> new EggItem(p, 0xBC8F8F))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> ATLANTIC_HALIBUT_EGG = REGISTRATE
        .item("atlantic_halibut_egg", p -> new EggItem(p, 0x8B4513))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> PINK_SALMON_EGG = REGISTRATE
        .item("pink_salmon_egg", p -> new EggItem(p, 0xFFB6C1))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> EYELASH_EGG = REGISTRATE
        .item("eyelash_egg", p -> new EggItem(p, 0xF5F5DC))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SPINDLEFISH_EGG = REGISTRATE
        .item("spindlefish_egg", p -> new EggItem(p, 0xC0C0C0))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SNOWFLAKE_EGG = REGISTRATE
        .item("snowflake_egg", p -> new EggItem(p, 0xF0F8FF))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> AERO_MONO_EGG = REGISTRATE
        .item("aero_mono_egg", p -> new EggItem(p, 0x87CEEB))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> PICKLEFISH_EGG = REGISTRATE
        .item("picklefish_egg", p -> new EggItem(p, 0x9ACD32))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> AMBER_GOBY_EGG = REGISTRATE
        .item("amber_goby_egg", p -> new EggItem(p, 0xFFBF00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BEAKED_HERRING_EGG = REGISTRATE
        .item("beaked_herring_egg", p -> new EggItem(p, 0xEEE8AA))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BLIND_SAILFIN_EGG = REGISTRATE
        .item("blind_sailfin_egg", p -> new EggItem(p, 0x778899))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CIRCUS_FISH_EGG = REGISTRATE
        .item("circus_fish_egg", p -> new EggItem(p, 0xFF69B4))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> COPPERFLAME_ANTHIAS_EGG = REGISTRATE
        .item("copperflame_anthias_egg", p -> new EggItem(p, 0xB87333))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> DEMON_HERRING_EGG = REGISTRATE
        .item("demon_herring_egg", p -> new EggItem(p, 0x8B0000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> DROOPING_GOURAMI_EGG = REGISTRATE
        .item("drooping_gourami_egg", p -> new EggItem(p, 0xFFDAB9))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> DUALITY_DAMSELFISH_EGG = REGISTRATE
        .item("duality_damselfish_egg", p -> new EggItem(p, 0x696969))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> FORKFISH_EGG = REGISTRATE
        .item("forkfish_egg", p -> new EggItem(p, 0xA9A9A9))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> HATCHETFISH_EGG = REGISTRATE
        .item("hatchetfish_egg", p -> new EggItem(p, 0x708090))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SNEEP_SNORP_EGG = REGISTRATE
        .item("sneep_snorp_egg", p -> new EggItem(p, 0x98FB98))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TRIPLE_TWIRL_PLECO_EGG = REGISTRATE
        .item("triple_twirl_pleco_egg", p -> new EggItem(p, 0x8B7355))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SAILOR_BARB_EGG = REGISTRATE
        .item("sailor_barb_egg", p -> new EggItem(p, 0x000080))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> BARK_ANGELFISH_EGG = REGISTRATE
        .item("bark_angelfish_egg", p -> new EggItem(p, 0x8B4513))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TREVALLY_EGG = REGISTRATE
        .item("trevally_egg", p -> new EggItem(p, 0x1E90FF))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> AROWANA_EGG = REGISTRATE
        .item("arowana_egg", p -> new EggItem(p, 0xB8860B))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SUNFISH_EGG = REGISTRATE
        .item("sunfish_egg", p -> new EggItem(p, 0xFFE4B5))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TRIGGERFISH_EGG = REGISTRATE
        .item("triggerfish_egg", p -> new EggItem(p, 0xFF4500))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> FOOTBALL_FISH_EGG = REGISTRATE
        .item("football_fish_egg", p -> new EggItem(p, 0x4B0082))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SPADEFISH_EGG = REGISTRATE
        .item("spadefish_egg", p -> new EggItem(p, 0xF5F5F5))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> KING_CRAB_EGG = REGISTRATE
        .item("king_crab_egg", p -> new EggItem(p, 0xFF4500))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> LANTERNFISH_EGG = REGISTRATE
        .item("lanternfish_egg", p -> new EggItem(p, 0xADFF2F))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TRIPODFISH_EGG = REGISTRATE
        .item("tripodfish_egg", p -> new EggItem(p, 0xD3D3D3))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TRILOCARIS_EGG = REGISTRATE
        .item("trilocaris_egg", p -> new EggItem(p, 0x8B7355))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> RADGILL_EGG = REGISTRATE
        .item("radgill_egg", p -> new EggItem(p, 0x7CFC00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SEA_PIG_EGG = REGISTRATE
        .item("sea_pig_egg", p -> new EggItem(p, 0xFFC0CB))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> MUSSEL_EGG = REGISTRATE
        .item("mussel_egg", p -> new EggItem(p, 0x191970))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SWEETISH_FISH_PINK_EGG = REGISTRATE
        .item("sweetish_fish_pink_egg", p -> new EggItem(p, 0xFFC0CB))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SWEETISH_FISH_RED_EGG = REGISTRATE
        .item("sweetish_fish_red_egg", p -> new EggItem(p, 0xFF0000))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SWEETISH_FISH_BLUE_EGG = REGISTRATE
        .item("sweetish_fish_blue_egg", p -> new EggItem(p, 0x0000FF))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SWEETISH_FISH_GREEN_EGG = REGISTRATE
        .item("sweetish_fish_green_egg", p -> new EggItem(p, 0x00FF00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SWEETISH_FISH_YELLOW_EGG = REGISTRATE
        .item("sweetish_fish_yellow_egg", p -> new EggItem(p, 0xFFFF00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CLAWSTER_EGG = REGISTRATE
        .item("clawster_egg", p -> new EggItem(p, 0xFF4500))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CLAM_EGG = REGISTRATE
        .item("clam_egg", p -> new EggItem(p, 0xFFFDD0))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> JELLYFISH_EGG = REGISTRATE
        .item("jellyfish_egg", p -> new EggItem(p, 0xE6E6FA))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> PLATINUM_BASS_EGG = REGISTRATE
        .item("platinum_bass_egg", p -> new EggItem(p, 0xE5E4E2))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> URCHIN_EGG = REGISTRATE
        .item("urchin_egg", p -> new EggItem(p, 0x800080))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SEA_CLAM_EGG = REGISTRATE
        .item("sea_clam_egg", p -> new EggItem(p, 0xADD8E6))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> TIGER_PRAWN_EGG = REGISTRATE
        .item("tiger_prawn_egg", p -> new EggItem(p, 0x2F4F4F))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> SHRIMP_EGG = REGISTRATE
        .item("shrimp_egg", p -> new EggItem(p, 0xFFDAB9))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> LAMPREY_EGG = REGISTRATE
        .item("lamprey_egg", p -> new EggItem(p, 0x808080))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> ABALONE_EGG = REGISTRATE
        .item("abalone_egg", p -> new EggItem(p, 0xF0E68C))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> GUARDIAN_EGG = REGISTRATE
        .item("guardian_egg", p -> new EggItem(p, 0x7FFF00))
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

public static final ItemEntry<EggItem> CRAYFISH_EGG = REGISTRATE
        .item("crayfish_egg", p -> new EggItem(p, 0x8B4513)) // saddle brown（深褐）
        .properties(p -> p.food(new FoodProperties.Builder()
                .nutrition(1)
                .saturationMod(0.3f)
                .build()))
        .model(ItemModelUtil::eggItemModel)
        .register();

    public static final ItemEntry<EggItem> TASMANIAN_GIANT_FRESHWATER_EGG = REGISTRATE
            .item("tasmanian_giant_freshwater_egg", p -> new EggItem(p, 0xC2A878)) // khaki brown（黄褐）
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> EUASTACUS_ARMATUS_EGG = REGISTRATE
            .item("euastacus_armatus_egg", p -> new EggItem(p, 0x6B4C3B)) // dark brown（暗褐）
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> MARRON_CRAYFISH_EGG = REGISTRATE
            .item("marron_crayfish_egg", p -> new EggItem(p, 0xA0522D)) // sienna（棕褐）
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static final ItemEntry<EggItem> CAMBAROIDES_DAURICUS_EGG = REGISTRATE
            .item("cambaroides_dauricus_egg", p -> new EggItem(p, 0x7F5A36)) // brownish（棕色）
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();


    public static final ItemEntry<Item> COOK_ZHURUOLING_EGG = REGISTRATE
            .item("cook_zhuruoling_egg", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/cook_zhuruoling_egg")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    public static final ItemEntry<Item> ZHURUOLING_EGG = REGISTRATE
            .item("zhuruoling_egg", Item::new)
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/special_item/zhuruoling_egg")))
            .properties(p -> p.rarity(Rarity.EPIC))
            .register();

    public static final ItemEntry<Item> EMPEROR_CRAB_EGG = REGISTRATE
            .item("emperor_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/emperor_crab_egg")))
            .register();

    public static final ItemEntry<Item> JONAH_CRAB_EGG = REGISTRATE
            .item("jonah_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/jonah_crab_egg")))
            .register();

    public static final ItemEntry<Item> PELAGIC_SWIMMING_CRAB_EGG = REGISTRATE
            .item("pelagic_swimming_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/pelagic_swimming_crab_egg")))
            .register();

    public static final ItemEntry<Item> DUNGENESS_CRAB_EGG = REGISTRATE
            .item("dungeness_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/dungeness_crab_egg")))
            .register();

    public static final ItemEntry<Item> SWIMMING_CRAB_EGG = REGISTRATE
            .item("swimming_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/swimming_crab_egg")))
            .register();

    public static final ItemEntry<Item> HERMIT_CRAB_EGG = REGISTRATE
            .item("hermit_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/hermit_crab_egg")))
            .register();

    public static final ItemEntry<Item> RIVER_CRAB_EGG = REGISTRATE
            .item("river_crab_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/river_crab_egg")))
            .register();

    public static final ItemEntry<Item> BLUE_LOBSTER_EGG = REGISTRATE
            .item("blue_lobster_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/blue_lobster_egg")))
            .register();

    public static final ItemEntry<Item> MARBLED_LOBSTER_EGG = REGISTRATE
            .item("marbled_lobster_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/marbled_lobster_egg")))
            .register();

    public static final ItemEntry<Item> DEEP_SEA_STAG_SHRIMP_EGG = REGISTRATE
            .item("deep-sea_stag_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/deep-sea_stag_shrimp_egg")))
            .register();

    public static final ItemEntry<Item> VANNAMEI_SHRIMP_EGG = REGISTRATE
            .item("vannamei_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/vannamei_shrimp_egg")))
            .register();

    public static final ItemEntry<Item> MANTIS_SHRIMP_EGG = REGISTRATE
            .item("mantis_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/mantis_shrimp_egg")))
            .register();

    public static final ItemEntry<Item> RIVER_SHRIMP_EGG = REGISTRATE
            .item("river_shrimp_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/fish_egg/crustacean/shrimp/river_shrimp_egg")))
            .register();

    public static final ItemEntry<Item> COOK_GOOSE_EGG =REGISTRATE.item("cook_goose_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_goose_egg")))
            .register();

    public static final ItemEntry<Item> COOK_DUCK_EGG = REGISTRATE.item("cook_duck_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_duck_egg")))
            .register();

    public static final ItemEntry<Item> COOK_TURKEY_EGG = REGISTRATE.item("cook_turkey_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_turkey_egg")))
            .register();

 public static final ItemEntry<Item> COOK_BLACK_GOOSE_EGG = REGISTRATE.item("cook_black_goose_egg", Item::new)
         .properties(p -> p.food(new FoodProperties.Builder()
                 .nutrition(2)
                 .saturationMod(0.8f)
                 .build()))
         .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_black_goose_egg")))
         .properties(p -> p.rarity(Rarity.EPIC))
         .register();

 public static final ItemEntry<Item> COOK_WHITE_GOOSE_EGG = REGISTRATE.item("cook_white_goose_egg", Item::new)
         .properties(p -> p.food(new FoodProperties.Builder()
                 .nutrition(2)
                 .saturationMod(0.8f)
                 .build()))
         .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_white_goose_egg")))
         .properties(p -> p.rarity(Rarity.EPIC))
         .register();

    public static final ItemEntry<Item> COOK_TORTOISE_EGG = REGISTRATE.item("cook_tortoise_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_tortoise_egg")))
            .register();

    public static final ItemEntry<Item> COOK_ALLIGATOR_EGG = REGISTRATE.item("cook_alligator_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_alligator_egg")))
            .register();

    public static final ItemEntry<Item> COOK_ASTRO_EGG = REGISTRATE.item("cook_astro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_astro_egg")))
            .register();

    public static final ItemEntry<Item> COOK_BARINA_EGG = REGISTRATE.item("cook_barina_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_barina_egg")))
            .register();

    public static final ItemEntry<Item> COOK_BRACHI_EGG = REGISTRATE.item("cook_brachi_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_brachi_egg")))
            .register();

    public static final ItemEntry<Item> COOK_HWACHA_EGG = REGISTRATE.item("cook_hwacha_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_hwacha_egg")))
            .register();

    public static final ItemEntry<Item> COOK_COTY_EGG = REGISTRATE.item("cook_coty_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_coty_egg")))
            .register();

    public static final ItemEntry<Item> COOK_KENTRO_EGG = REGISTRATE.item("cook_kentro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_kentro_egg")))
            .register();

    public static final ItemEntry<Item> COOK_MAJUNGA_EGG = REGISTRATE.item("cook_majunga_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_majunga_egg")))
            .register();

    public static final ItemEntry<Item> COOK_PACHY_EGG = REGISTRATE.item("cook_pachy_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_pachy_egg")))
            .register();

    public static final ItemEntry<Item> COOK_RAPTRO_EGG = REGISTRATE.item("cook_raptro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_raptro_egg")))
            .register();

    public static final ItemEntry<Item> COOK_REX_EGG = REGISTRATE.item("cook_rex_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_rex_egg")))
            .register();

    public static final ItemEntry<Item> COOK_MEGALA_EGG = REGISTRATE.item("cook_megala_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_megala_egg")))
            .register();

    public static final ItemEntry<Item> COOK_ANTARCTO_EGG = REGISTRATE.item("cook_antarcto_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_antarcto_egg")))
            .register();

    public static final ItemEntry<Item> COOK_TRIKE_EGG = REGISTRATE.item("cook_trike_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_trike_egg")))
            .register();

    public static final ItemEntry<Item> COOK_ANURO_EGG = REGISTRATE.item("cook_anuro_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_anuro_egg")))
            .register();

    public static final ItemEntry<Item> COOK_ULUGH_EGG = REGISTRATE.item("cook_ulugh_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_ulugh_egg")))
            .register();

    public static final ItemEntry<Item> COOK_TALPANAS_EGG = REGISTRATE.item("cook_talpanas_egg", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationMod(0.8f)
                    .build()))
            .model((ctx, provider) -> provider.generated(ctx::get, provider.modLoc("item/food/cook_egg/cook_talpanas_egg")))
            .register();

    // --- chest-paired fish eggs ---
    // 福寿螺卵
    public static final ItemEntry<EggItem> APPLE_SNAIL_EGG = REGISTRATE
            .item("apple_snail_egg", p -> new EggItem(p, 0x8F6B3A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 黑帽蜗牛卵
    public static final ItemEntry<EggItem> BLACKCAP_SNAIL_EGG = REGISTRATE
            .item("blackcap_snail_egg", p -> new EggItem(p, 0x555CF8))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 水滴鱼卵
    public static final ItemEntry<EggItem> BLOBFISH_EGG = REGISTRATE
            .item("blobfish_egg", p -> new EggItem(p, 0x77225A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 砖红蜗牛卵
    public static final ItemEntry<EggItem> BRICK_SNAIL_EGG = REGISTRATE
            .item("brick_snail_egg", p -> new EggItem(p, 0xD513FE))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 小丑鲨卵
    public static final ItemEntry<EggItem> CLOWNTHORN_SHARK_EGG = REGISTRATE
            .item("clownthorn_shark_egg", p -> new EggItem(p, 0xA24467))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 珊瑚虾卵
    public static final ItemEntry<EggItem> CORAL_SKRIMP_EGG = REGISTRATE
            .item("coral_skrimp_egg", p -> new EggItem(p, 0x8C53AB))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 宇宙鳕鱼卵
    public static final ItemEntry<EggItem> COSMIC_COD_EGG = REGISTRATE
            .item("cosmic_cod_egg", p -> new EggItem(p, 0x2538C4))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 深层爬虫卵
    public static final ItemEntry<EggItem> DEEP_CRAWLER_EGG = REGISTRATE
            .item("deep_crawler_egg", p -> new EggItem(p, 0x8BCE38))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 魔鳉卵
    public static final ItemEntry<EggItem> DEVILS_HOLE_PUPFISH_EGG = REGISTRATE
            .item("devils_hole_pupfish_egg", p -> new EggItem(p, 0xFDC087))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 淡水螳螂卵
    public static final ItemEntry<EggItem> FRESHWATER_MANTIS_EGG = REGISTRATE
            .item("freshwater_mantis_egg", p -> new EggItem(p, 0x2CAFAD))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 发光鱿鱼卵
    public static final ItemEntry<EggItem> GLOW_SQUID_EGG = REGISTRATE
            .item("glow_squid_egg", p -> new EggItem(p, 0x00937F))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 基围虾卵
    public static final ItemEntry<EggItem> GREASYBACK_SHRIMP_EGG = REGISTRATE
            .item("greasyback_shrimp_egg", p -> new EggItem(p, 0x510BAF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 裂纹弹涂鱼卵
    public static final ItemEntry<EggItem> LOBED_SKIPPER_EGG = REGISTRATE
            .item("lobed_skipper_egg", p -> new EggItem(p, 0x6D843C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 苔藓牛鱼卵
    public static final ItemEntry<EggItem> MOSSTHORN_EGG = REGISTRATE
            .item("mossthorn_egg", p -> new EggItem(p, 0x3077FE))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 泥砖蜗牛卵
    public static final ItemEntry<EggItem> MUDDYTOP_SNAIL_EGG = REGISTRATE
            .item("muddytop_snail_egg", p -> new EggItem(p, 0x3F8FB1))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 弹涂鱼卵
    public static final ItemEntry<EggItem> MUDSKIPPER_EGG = REGISTRATE
            .item("mudskipper_egg", p -> new EggItem(p, 0x4B8F7F))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 粉鳍镰鱼卵
    public static final ItemEntry<EggItem> PINKFIN_IDOL_EGG = REGISTRATE
            .item("pinkfin_idol_egg", p -> new EggItem(p, 0x6CF0C3))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 豪猪龙虾卵
    public static final ItemEntry<EggItem> PORCUPINE_LOBSTA_EGG = REGISTRATE
            .item("porcupine_lobsta_egg", p -> new EggItem(p, 0x8F368A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 河豚卵
    public static final ItemEntry<EggItem> PUFFERFISH_EGG = REGISTRATE
            .item("pufferfish_egg", p -> new EggItem(p, 0x527C89))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 裂锯鱼卵
    public static final ItemEntry<EggItem> RIPPER_EGG = REGISTRATE
            .item("ripper_egg", p -> new EggItem(p, 0xEFD411))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 海蚊卵
    public static final ItemEntry<EggItem> SEA_MOSQUITO_EGG = REGISTRATE
            .item("sea_mosquito_egg", p -> new EggItem(p, 0x496578))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 皇冠海蛛卵
    public static final ItemEntry<EggItem> SEA_SPIDER_EGG = REGISTRATE
            .item("sea_spider_egg", p -> new EggItem(p, 0x9D4E4C))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 震荡猫鲶卵
    public static final ItemEntry<EggItem> SHOCKCAT_EGG = REGISTRATE
            .item("shockcat_egg", p -> new EggItem(p, 0x25E481))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 勺鲨卵
    public static final ItemEntry<EggItem> SPOON_SHARK_EGG = REGISTRATE
            .item("spoon_shark_egg", p -> new EggItem(p, 0x2053F6))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 鱿鱼卵
    public static final ItemEntry<EggItem> SQUID_EGG = REGISTRATE
            .item("squid_egg", p -> new EggItem(p, 0xD7E583))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 斯奎德尔卵
    public static final ItemEntry<EggItem> SQUODDLE_EGG = REGISTRATE
            .item("squoddle_egg", p -> new EggItem(p, 0xBEA4B0))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 虎皮鲀卵
    public static final ItemEntry<EggItem> TIGER_PUFFER_EGG = REGISTRATE
            .item("tiger_puffer_egg", p -> new EggItem(p, 0xDACDD7))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 伏特鮟鱇鱼卵
    public static final ItemEntry<EggItem> VOLT_ANGLER_EGG = REGISTRATE
            .item("volt_angler_egg", p -> new EggItem(p, 0x904C2A))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    // 魔力水母卵
    public static final ItemEntry<EggItem> WIZARD_JELLY_EGG = REGISTRATE
            .item("wizard_jelly_egg", p -> new EggItem(p, 0xEC1BFF))
            .properties(p -> p.food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .build()))
            .model(ItemModelUtil::eggItemModel)
            .register();

    public static void register() {
    }
}
