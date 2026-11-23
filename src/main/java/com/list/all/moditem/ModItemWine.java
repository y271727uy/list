package com.list.all.moditem;

import com.list.item.WineItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.model.generators.ModelFile;

import static com.list.ListMod.REGISTRATE;

public class ModItemWine {
    private static final FoodProperties WINE_FOOD = new FoodProperties.Builder()
            .nutrition(7)
            .saturationMod(0.5f)
            .build();

    // FTB 任务书「缤纷水果」，沿用任务排列顺序。
    public static final ItemEntry<WineItem> SEA_GRAPE_WINE = wine("sea_grape_wine", 0xFF77B862); // oceanic_delight:sea_grape
    public static final ItemEntry<WineItem> OXYGRAPE_WINE = wine("oxygrape_wine", 0xFF8DC8BE); // immortalers_delight:oxygrape
    public static final ItemEntry<WineItem> PASSION_FRUIT_WINE = wine("passion_fruit_wine", 0xFFD79F53); // bountifulfares:passion_fruit
    public static final ItemEntry<WineItem> STRAWBERRY_WINE = wine("strawberry_wine", 0xFFD75064); // neapolitan:strawberries
    public static final ItemEntry<WineItem> WILDBERRY_WINE = wine("wildberry_wine", 0xFF9863A5); // cosmopolitan:wildberry
    public static final ItemEntry<WineItem> CRANBERRY_WINE = wine("cranberry_wine", 0xFFB93B58); // fruitsdelight:cranberry
    public static final ItemEntry<WineItem> BLACKBERRY_WINE = wine("blackberry_wine", 0xFF623477); // manors_bounty:blackberry
    public static final ItemEntry<WineItem> MELON_WINE = wine("melon_wine", 0xFFE36771); // minecraft:melon
    public static final ItemEntry<WineItem> HAMIMELON_WINE = wine("hamimelon_wine", 0xFFE5A767); // fruitsdelight:hamimelon
    public static final ItemEntry<WineItem> JABOTICABA_WINE = wine("jaboticaba_wine", 0xFF744485); // nethers_exoticism:jaboticaba
    public static final ItemEntry<WineItem> DRAGON_FRUIT_WINE = wine("dragon_fruit_wine", 0xFFD667A9); // manors_bounty:dragon_fruit
    public static final ItemEntry<WineItem> PINK_DRAGON_FRUIT_WINE = wine("pink_dragon_fruit_wine", 0xFFCF4F86); // collectorsreap:pink_dragon_fruit
    public static final ItemEntry<WineItem> JUNIPER_BERRY_WINE = wine("juniper_berry_wine", 0xFF7185A9); // brewincompatdelight:juniper_berries
    public static final ItemEntry<WineItem> ROSEHIP_WINE = wine("rosehip_wine", 0xFFC15B52); // yeastnfeast:rose_hips
    public static final ItemEntry<WineItem> HOLLY_BERRY_WINE = wine("holly_berry_wine", 0xFFBD333E); // manors_bounty:holly_berry
    public static final ItemEntry<WineItem> PEARLIP_WINE = wine("pearlip_wine", 0xFFD6BD82); // immortalers_delight:pearlip
    public static final ItemEntry<WineItem> PINEAPPLE_WINE = wine("pineapple_wine", 0xFFE7BE51); // fruitsdelight:pineapple
    public static final ItemEntry<WineItem> BANANA_WINE = wine("banana_wine", 0xFFE2C759); // neapolitan:banana_bunch
    public static final ItemEntry<WineItem> GREEN_BANANA_WINE = wine("green_banana_wine", 0xFFA8BB62); // vietnam_delight:green_banana_bunch
    public static final ItemEntry<WineItem> WITHER_BERRY_WINE = wine("wither_berry_wine", 0xFF666981); // frightsdelight:wither_berry
    public static final ItemEntry<WineItem> SOUL_BERRY_WINE = wine("soul_berry_wine", 0xFF7CBCD3); // frightsdelight:soul_berry
    public static final ItemEntry<WineItem> TEA_BERRY_WINE = wine("tea_berry_wine", 0xFFA3606F); // bountifulfares:tea_berries
    public static final ItemEntry<WineItem> GEARO_BERRY_WINE = wine("gearo_berry_wine", 0xFFC77C42); // vintagedelight:gearo_berry
    public static final ItemEntry<WineItem> SPONGEKIN_WINE = wine("spongekin_wine", 0xFFD8AE66); // bountifulfares:spongekin
    public static final ItemEntry<WineItem> CANTALOUPE_WINE = wine("cantaloupe_wine", 0xFFEDA35D); // delightful:cantaloupe
    public static final ItemEntry<WineItem> MINI_MELON_WINE = wine("mini_melon_wine", 0xFFDA7378); // delightful:mini_melon
    public static final ItemEntry<WineItem> CLOUD_BERRY_WINE = wine("cloud_berry_wine", 0xFFC6D9EC); // delighto_flight:cloud_berries
    public static final ItemEntry<WineItem> SALMONBERRY_WINE = wine("salmonberry_wine", 0xFFE68A50); // delightful:salmonberries
    public static final ItemEntry<WineItem> ACAI_WINE = wine("acai_wine", 0xFF87397B); // braziliandelight:acai_berries
    public static final ItemEntry<WineItem> WHITE_STRAWBERRY_WINE = wine("white_strawberry_wine", 0xFFE8C1CB); // neapolitan:white_strawberries
    public static final ItemEntry<WineItem> ARBUTUS_BERRY_WINE = wine("arbutus_berry_wine", 0xFFCB514D); // cosmopolitan:arbutus_berries
    public static final ItemEntry<WineItem> GOOSEBERRY_WINE = wine("gooseberry_wine", 0xFFACC86B); // manors_bounty:gooseberry
    public static final ItemEntry<WineItem> LANTERN_FRUIT_WINE = wine("lantern_fruit_wine", 0xFFDF9C43); // trailandtales_delight:lantern_fruit
    public static final ItemEntry<WineItem> BLACKCURRANT_WINE = wine("blackcurrant_wine", 0xFF7E4C91); // manors_bounty:blackcurrant
    public static final ItemEntry<WineItem> LYCHEE_WINE = wine("lychee_wine", 0xFFE79696); // fruitsdelight:lychee
    public static final ItemEntry<WineItem> GUARANA_WINE = wine("guarana_wine", 0xFFD05A49); // braziliandelight:guarana_fruit
    public static final ItemEntry<WineItem> KEY_LIME_WINE = wine("key_lime_wine", 0xFFAEC85A); // collectorsreap:lime
    public static final ItemEntry<WineItem> GREEN_MANGO_WINE = wine("green_mango_wine", 0xFFAEC25B); // extravagantdelight:green_mango
    public static final ItemEntry<WineItem> GREEN_APPLE_WINE = wine("green_apple_wine", 0xFF8AC44A); // manors_bounty:green_apple
    public static final ItemEntry<WineItem> GREEN_KUMQUAT_WINE = wine("green_kumquat_wine", 0xFFB8B84F); // vietnam_delight:green_kumquat
    public static final ItemEntry<WineItem> CITRON_WINE = wine("citron_wine", 0xFFDFCE6C); // fruitfulfun:citron
    public static final ItemEntry<WineItem> LEMON_WINE = wine("lemon_wine", 0xFFEACF53); // fruitsdelight:lemon
    public static final ItemEntry<WineItem> STYGIAN_POMEGRANATE_WINE = wine("stygian_pomegranate_wine", 0xFFA8486F); // collectorsreap:stygian_pomegranate
    public static final ItemEntry<WineItem> DURIAN_WINE = wine("durian_wine", 0xFFCDB651); // fruitsdelight:durian
    public static final ItemEntry<WineItem> GREEN_COCONUT_WINE = wine("green_coconut_wine", 0xFFA6BD75); // braziliandelight:green_coconut
    public static final ItemEntry<WineItem> DATE_WINE = wine("date_wine", 0xFFAA6D3D); // ramadandelight:date
    public static final ItemEntry<WineItem> COCONUT_WINE = wine("coconut_wine", 0xFFDACBB5); // braziliandelight:coconut
    public static final ItemEntry<WineItem> AVOCADO_WINE = wine("avocado_wine", 0xFFA7B951); // culturaldelights:avocado
    public static final ItemEntry<WineItem> KIWI_WINE = wine("kiwi_wine", 0xFF91AF48); // fruitsdelight:kiwi
    public static final ItemEntry<WineItem> MUSANG_KING_DURIAN_WINE = wine("musang_king_durian_wine", 0xFFDDB856); // manors_bounty:musang_king_durian
    public static final ItemEntry<WineItem> RAW_PAPAYA_WINE = wine("raw_papaya_wine", 0xFFBCCA74); // muffins_thaidelight:raw_papaya
    public static final ItemEntry<WineItem> POMEGRANATE_WINE = wine("pomegranate_wine", 0xFFBE3D59); // collectorsreap:pomegranate
    public static final ItemEntry<WineItem> REDLOVE_WINE = wine("redlove_wine", 0xFFCF625F); // fruitfulfun:redlove
    public static final ItemEntry<WineItem> RAMBUTAN_WINE = wine("rambutan_wine", 0xFFDD716F); // nethers_exoticism:ramboutan
    public static final ItemEntry<WineItem> UME_WINE = wine("ume_wine", 0xFFABB960); // manors_bounty:ume
    public static final ItemEntry<WineItem> THUNDER_FRUIT_WINE = wine("thunder_fruit_wine", 0xFFE7CB6D); // delighto_flight:thunder_fruit
    public static final ItemEntry<WineItem> KUMQUAT_WINE = wine("kumquat_wine", 0xFFF1A64B); // vietnam_delight:kumquat
    public static final ItemEntry<WineItem> LIME_WINE = wine("lime_wine", 0xFFA2C650); // fruitfulfun:lime
    public static final ItemEntry<WineItem> WARPED_LAUREL_WINE = wine("warped_laurel_wine", 0xFF73BAAA); // immortalers_delight:warped_laurel
    public static final ItemEntry<WineItem> LUCUMA_WINE = wine("lucuma_wine", 0xFFD9AA55); // collectorsreap:lucuma
    public static final ItemEntry<WineItem> HAWTHORN_WINE = wine("hawthorn_wine", 0xFFCA574C); // fruitsdelight:hawberry
    public static final ItemEntry<WineItem> BUDDHAS_HAND_WINE = wine("buddhas_hand_wine", 0xFFE6CD50); // nethers_exoticism:bouddha_s_hand
    public static final ItemEntry<WineItem> GOLD_KIWI_WINE = wine("gold_kiwi_wine", 0xFFE0BB58); // manors_bounty:gold_kiwifruit
    public static final ItemEntry<WineItem> OLIVE_WINE = wine("olive_wine", 0xFFA4A451); // manors_bounty:olive_fruit
    public static final ItemEntry<WineItem> ORANGE_WINE = wine("orange_wine", 0xFFF1A044); // fruitsdelight:orange
    public static final ItemEntry<WineItem> SWEET_ORANGE_WINE = wine("sweet_orange_wine", 0xFFF4AD53); // bountifulfares:sweet_orange
    public static final ItemEntry<WineItem> KIWANO_WINE = wine("kiwano_wine", 0xFFDF9E55); // nethers_exoticism:kiwano
    public static final ItemEntry<WineItem> ILLAGE_LIME_WINE = wine("illage_lime_wine", 0xFFA0B746); // ltc2:illage_lime
    public static final ItemEntry<WineItem> PEAR_WINE = wine("pear_wine", 0xFFC7D484); // fruitsdelight:pear
    public static final ItemEntry<WineItem> PERSIMMON_WINE = wine("persimmon_wine", 0xFFE18A49); // fruitsdelight:persimmon
    public static final ItemEntry<WineItem> MANGOSTEEN_WINE = wine("mangosteen_wine", 0xFF9D507F); // fruitsdelight:mangosteen
    public static final ItemEntry<WineItem> POMELO_WINE = wine("pomelo_wine", 0xFFE2BA77); // manors_bounty:yuzumelo
    public static final ItemEntry<WineItem> BAYBERRY_WINE = wine("bayberry_wine", 0xFFB84262); // fruitsdelight:bayberry
    public static final ItemEntry<WineItem> APRICOT_WINE = wine("apricot_wine", 0xFFF3A24D); // manors_bounty:apricot
    public static final ItemEntry<WineItem> PAPAYA_WINE = wine("papaya_wine", 0xFFEC9056); // muffins_thaidelight:papaya
    public static final ItemEntry<WineItem> HOARY_APPLE_WINE = wine("hoary_apple_wine", 0xFFBBA280); // bountifulfares:hoary_apple
    public static final ItemEntry<WineItem> FIG_WINE = wine("fig_wine", 0xFFB05C78); // fruitsdelight:fig
    public static final ItemEntry<WineItem> DUSKMELON_WINE = wine("duskmelon_wine", 0xFFAF7CC0); // regions_unexplored:duskmelon_slice
    public static final ItemEntry<WineItem> EARLIGHT_FRUIT_WINE = wine("earlight_fruit_wine", 0xFF83BFD0); // regions_unexplored:hanging_earlight_fruit
    public static final ItemEntry<WineItem> BOILBERRY_WINE = wine("boilberry_wine", 0xFFE87550); // cosmopolitan:boilberry
    public static final ItemEntry<WineItem> SPINALBERRY_WINE = wine("spinalberry_wine", 0xFFAC80A4); // cosmopolitan:spinalberry
    public static final ItemEntry<WineItem> UNRIPE_CRYSTAL_CRABAPPLE_WINE = wine("unripe_crystal_crabapple_wine", 0xFF94D2A8); // trailandtales_delight:unripe_crystal_crabapple
    public static final ItemEntry<WineItem> CRYSTAL_CRABAPPLE_WINE = wine("crystal_crabapple_wine", 0xFFD58CBB); // trailandtales_delight:crystal_crabapple
    public static final ItemEntry<WineItem> FEIJOA_WINE = wine("feijoa_wine", 0xFFAFC272); // forestry:fruit_feijoa
    public static final ItemEntry<WineItem> ASTRAL_BERRY_WINE = wine("astral_berry_wine", 0xFF8798F4); // delighto_flight:astral_berries
    public static final ItemEntry<WineItem> MIXING_CRESCENT_SILVERMELON_WINE = wine("mixing_crescent_silvermelon_wine", 0xFFD0D8E9); // delighto_flight:mixing_crescent_silvermelon
    public static final ItemEntry<WineItem> WANING_CRESCENT_SILVERMELON_WINE = wine("waning_crescent_silvermelon_wine", 0xFF9DB3DE); // delighto_flight:waning_crescent_silvermelon
    public static final ItemEntry<WineItem> SILVERMELON_WINE = wine("silvermelon_wine", 0xFFBAC9E2); // delighto_flight:waxing_crescent_silvermelon

    // List 自带的果类作物。
    public static final ItemEntry<WineItem> ANCIENT_FRUIT_WINE = wine("ancient_fruit_wine", 0xFF5C9CA5); // list:ancient_fruit
    public static final ItemEntry<WineItem> GEMBERRY_WINE = wine("gemberry_wine", 0xFFC85076); // list:gemberry
    public static final ItemEntry<WineItem> CRYSTAL_FRUIT_WINE = wine("crystal_fruit_wine", 0xFF91CCEC); // list:crystal_fruit
    public static final ItemEntry<WineItem> HEART_FRUIT_WINE = wine("heart_fruit_wine", 0xFFC78A61); // list:heart_fruit
    public static final ItemEntry<WineItem> MUSHROOM_BERRY_WINE = wine("mushroom_berry_wine", 0xFFD99143); // list:mushroom_berry
    public static final ItemEntry<WineItem> NECTARINE_WINE = wine("nectarine_wine", 0xFFE79359); // list:nectarine
    public static final ItemEntry<WineItem> ORIENTAL_STRAWBERRY_WINE = wine("oriental_strawberry_wine", 0xFFDD586B); // list:oriental_strawberry
    public static final ItemEntry<WineItem> HARSH_WINTER_STRAWBERRY_WINE = wine("harsh_winter_strawberry_wine", 0xFFC74B79); // list:harsh_winter_strawberry
    public static final ItemEntry<WineItem> NORTHERN_HIGHBUSH_BLUEBERRY_WINE = wine("northern_highbush_blueberry_wine", 0xFF6379C3); // list:northern_highbush_blueberry
    public static final ItemEntry<WineItem> AMERICAN_BLACK_CURRANT_WINE = wine("american_black_currant_wine", 0xFF74498C); // list:american_black_currant
    public static final ItemEntry<WineItem> ROVADA_RED_CURRANT_WINE = wine("rovada_red_currant_wine", 0xFFD54862); // list:rovada_red_currant
    public static final ItemEntry<WineItem> VERSAILLES_WHITE_CURRANT_WINE = wine("versailles_white_currant_wine", 0xFFE1CE91); // list:versailles_white_currant
    public static final ItemEntry<WineItem> LARGE_CRANBERRY_WINE = wine("large_cranberry_wine", 0xFFBA395E); // list:large_cranberry
    public static final ItemEntry<WineItem> LINGONBERRY_WINE = wine("lingonberry_wine", 0xFFD54C52); // list:lingonberry
    public static final ItemEntry<WineItem> HASCHBERG_ELDERBERRY_WINE = wine("haschberg_elderberry_wine", 0xFF75468B); // list:haschberg_elderberry
    public static final ItemEntry<WineItem> EUROPEAN_RED_RASPBERRY_WINE = wine("european_red_raspberry_wine", 0xFFC64C70); // list:european_red_raspberry
    public static final ItemEntry<WineItem> EUROPEAN_BLACKBERRY_WINE = wine("european_blackberry_wine", 0xFF624180); // list:european_blackberry
    public static final ItemEntry<WineItem> CAFONA_APRICOT_WINE = wine("cafona_apricot_wine", 0xFFEBA251); // list:cafona_apricot
    public static final ItemEntry<WineItem> CINNAMON_FRUIT_WINE = wine("cinnamon_fruit_wine", 0xFF86644A); // list:cinnamon_fruit
    public static final ItemEntry<WineItem> CORATION_OLIVE_WINE = wine("coration_olive_wine", 0xFFA7AD56); // list:coration_olive
    public static final ItemEntry<WineItem> DEKOPON_ORANGE_WINE = wine("dekopon_orange_wine", 0xFFF2A044); // list:dekopon_orange
    public static final ItemEntry<WineItem> FIANO_WHITE_GRAPE_WINE = wine("fiano_white_grape_wine", 0xFFC5D078); // list:fiano_white_grape
    public static final ItemEntry<WineItem> GROS_MICHEL_BANANA_WINE = wine("gros_michel_banana_wine", 0xFFE4C55C); // list:gros_michel_banana
    public static final ItemEntry<WineItem> KENT_MANGO_WINE = wine("kent_mango_wine", 0xFFEABB55); // list:kent_mango
    public static final ItemEntry<WineItem> NEBBIOLO_GRAPE_WINE = wine("nebbiolo_grape_wine", 0xFF8C456D); // list:nebbiolo_grape
    public static final ItemEntry<WineItem> DWARF_COCONUT_FRUIT_WINE = wine("dwarf_coconut_fruit_wine", 0xFFD9C3A0); // list:dwarf_coconut_fruit
    public static final ItemEntry<WineItem> RED_PINEAPPLE_WINE = wine("red_pineapple_wine", 0xFFD77C63); // list:red_pineapple
    public static final ItemEntry<WineItem> TAIWAN_GREEN_PINEAPPLE_WINE = wine("taiwan_green_pineapple_wine", 0xFFC6C35E); // list:taiwan_green_pineapple
    public static final ItemEntry<WineItem> PERFUME_PINEAPPLE_WINE = wine("perfume_pineapple_wine", 0xFFEBCF67); // list:perfume_pineapple
    public static final ItemEntry<WineItem> NYPA_WINE = wine("nypa_wine", 0xFFCFAC7C); // list:nypa
    public static final ItemEntry<WineItem> CHOCOLAT_PERSIMMON_WINE = wine("chocolat_persimmon_wine", 0xFFBC7848); // list:chocolat_persimmon
    public static final ItemEntry<WineItem> YELLOW_PEACH_WINE = wine("yellow_peach_wine", 0xFFF0A55D); // list:yellow_peach
    public static final ItemEntry<WineItem> RED_DACCA_BANANA_WINE = wine("red_dacca_banana_wine", 0xFFC87356); // list:red_dacca_banana
    public static final ItemEntry<WineItem> BLUE_JAVA_BANANA_WINE = wine("blue_java_banana_wine", 0xFF83BDCB); // list:blue_java_banana
    public static final ItemEntry<WineItem> PLANTAIN_WINE = wine("plantain_wine", 0xFFAFC465); // list:plantain
    public static final ItemEntry<WineItem> FINGER_LEMON_WINE = wine("finger_lemon_wine", 0xFFAACD5E); // list:finger_lemon
    public static final ItemEntry<WineItem> SMALL_LIME_WINE = wine("small_lime_wine", 0xFFA1BC4A); // list:small_lime
    public static final ItemEntry<WineItem> GUIWEI_LITCHI_WINE = wine("guiwei_litchi_wine", 0xFFDE878D); // list:guiwei_litchi
    public static final ItemEntry<WineItem> LITCHI_KING_WINE = wine("litchi_king_wine", 0xFFD76177); // list:litchi_king
    public static final ItemEntry<WineItem> BLACK_BEAUTY_MELON_WINE = wine("black_beauty_melon_wine", 0xFFD35869); // list:black_beauty_melon
    public static final ItemEntry<WineItem> GEM_MELON_WINE = wine("gem_melon_wine", 0xFFD2A26C); // list:gem_melon
    public static final ItemEntry<WineItem> FROST_MELON_WINE = wine("frost_melon_wine", 0xFFA5D5E7); // list:frost_melon
    public static final ItemEntry<WineItem> QI_MELON_WINE = wine("qi_melon_wine", 0xFF698CC8); // list:qi_melon

    private static ItemEntry<WineItem> wine(String name, int color) {
        return REGISTRATE.item(name, properties -> new WineItem(properties, color))
                .properties(properties -> properties.stacksTo(16)
                        .craftRemainder(Items.GLASS_BOTTLE)
                        .food(WINE_FOOD))
                .model((ctx, provider) -> provider.getBuilder(ctx.getName())
                        .parent(new ModelFile.UncheckedModelFile("list:item/fruit_wine_bottle")))
                .register();
    }

    public static void register() {
    }
}
