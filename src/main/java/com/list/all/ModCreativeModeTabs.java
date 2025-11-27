package com.list.all;

import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.world.item.CreativeModeTab;

import static com.list.ListMod.REGISTRATE;

public class ModCreativeModeTabs {
    public static final RegistryEntry<CreativeModeTab> LIST_TAB = REGISTRATE
        .defaultCreativeTab("list", builder -> {
            builder.icon(ModItems.INDUSTRIAL_OSMIUM_CREDIT::asStack);
            builder.displayItems((parameters, output) -> {
                output.accept(ModItems.INDUSTRIAL_COPPER_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_SILVER_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_GOLD_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_PLATINUM_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_COPPER_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_SILVER_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_GOLD_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_PLATINUM_CREDIT.get());
                output.accept(ModItems.INDUSTRIAL_OSMIUM_CREDIT.get());
                output.accept(ModItems.JUST_BREAD.get());
                output.accept(ModItems.FOOD_STAR.get());
                output.accept(ModItems.FISHERY_STAR.get());
                output.accept(ModItems.FARMING_STAR.get());
                output.accept(ModItems.FORESTRY_STAR.get());
                output.accept(ModItems.WEALTH_STAR.get());
                output.accept(ModItems.ANIMAL_HUSBANDRY_STAR.get());
                output.accept(ModItems.FARMERS_RANCH_STAR.get());
                output.accept(ModItems.EMPEROR_CRAB.get());
                output.accept(ModItems.JONAH_CRAB.get());
                output.accept(ModItems.PELAGIC_SWIMMING_CRAB.get());
                output.accept(ModItems.DUNGENESS_CRAB.get());
                output.accept(ModItems.SWIMMING_CRAB.get());
                output.accept(ModItems.HERMIT_CRAB.get());
                output.accept(ModItems.RIVER_CRAB.get());
                //output.accept(ModItems.蓝龙虾.get());
                //output.accept(ModItems.锦绣龙虾.get());
                //output.accept(ModItems.深海鳌虾.get());
                //output.accept(ModItems.基围虾.get());
                //output.accept(ModItems.濑尿虾.get());
                output.accept(ModItems.RIVER_SHRIMP.get());
                //output.accept(ModItems.海螺.get());
                //output.accept(ModItems.甲鱼.get());
                //output.accept(ModItems.草鱼.get());
                //output.accept(ModItems.蕨鱼.get());
                //output.accept(ModItems.大黄鱼.get());
                //output.accept(ModItems.银鲳鱼.get());
                //output.accept(ModItems.多宝鱼.get());
                //output.accept(ModItems.红石斑鱼.get());
                //output.accept(ModItems.鹦嘴鱼.get());
                //output.accept(ModItems.苏眉鱼.get());
                output.accept(ModItems.KOI.get());
                //output.accept(ModItems.鸡鱼.get());
                //output.accept(ModItems.云斑海猪鱼.get());
                //output.accept(ModItems.海鳗.get());
                //output.accept(ModItems.鲅鱼.get());
                //output.accept(ModItems.条纹鲈鱼.get());
                //output.accept(ModItems.鳙鱼.get());
                //output.accept(ModItems.鲥鱼.get());
                //output.accept(ModItems.秋刀鱼.get());
                //output.accept(ModItems.火鼠鱼.get());
                //output.accept(ModItems.冰棘鱼.get());
                //output.accept(ModItems.蛇鱼.get());
                //output.accept(ModItems.红鲷鱼.get());
                //output.accept(ModItems.魔鬼鱼.get());
                //output.accept(ModItems.长颌鲚.get());
                //output.accept(ModItems.小银鱼.get());
                //output.accept(ModItems.胭脂鱼.get());
                //output.accept(ModItems.凤尾鱼.get());
                //output.accept(ModItems.马面鱼.get());
                //output.accept(ModItems.黄鳝.get());
                //output.accept(ModItems.鲽鱼.get());
                //output.accept(ModItems.乌青鱼.get());
                //output.accept(ModItems.鳊鱼.get());
                //output.accept(ModItems.沙丁鱼.get());
                //output.accept(ModItems.海鲈鱼.get());
                //output.accept(ModItems.红歌鲤.get());
                //output.accept(ModItems.巴浪鱼.get());
                //output.accept(ModItems.三刀鱼.get());
                //output.accept(ModItems.马头鱼.get());
                //output.accept(ModItems.花英斑.get());
                //output.accept(ModItems.深海鲑鱼.get());
                //output.accept(ModItems.蓝飞鱼.get());
                //output.accept(ModItems.飞鱼.get());
                //output.accept(ModItems.雨鱼.get());
                //output.accept(ModItems.白条鱼.get());
                //output.accept(ModItems.赤魟.get());
                //output.accept(ModItems.针鱼.get());
                //output.accept(ModItems.龙利鱼.get());
                //output.accept(ModItems.青花鱼.get());
                //output.accept(ModItems.桂鱼.get());
                //output.accept(ModItems.带鱼.get());
                //output.accept(ModItems.大马哈鱼.get());
                //output.accept(ModItems.乌翅真鲨.get());
                //output.accept(ModItems.血红龙.get());
                //output.accept(ModItems.红海黄金蝶.get());
                //output.accept(ModItems.紫海刺水母.get());
                //output.accept(ModItems.皇冠狗头.get());
                //output.accept(ModItems.花高头龙睛.get());
                //output.accept(ModItems.线纹海马.get());
                //output.accept(ModItems.黄尾蓝魔.get());
                //output.accept(ModItems.秘鲁神仙.get());
                //output.accept(ModItems.三间火箭.get());
                //output.accept(ModItems.红剑.get());
                //output.accept(ModItems.吕宋棘海星.get());
                //output.accept(ModItems.红腹食人鲳.get());
                //output.accept(ModItems.草鱼王.get());
                //output.accept(ModItems..get());
                //output.accept(ModItems.鸟蛤.get());             //蟹 虾 贝 软体 鱼 
                //output.accept(ModItems.蚌.get());          
                //output.accept(ModItems.牡蛎.get());
                //output.accept(ModItems.玉蜀螺.get());
                //output.accept(ModItems.绯红鱼.get());
                //output.accept(ModItems.传说之鱼.get());
                //output.accept(ModItems.冰川鱼.get());
                //output.accept(ModItems.变种鲤鱼.get());
                //output.accept(ModItems.绯红鱼之子.get());
                //output.accept(ModItems.雌𩽾𩾌鱼.get());
                //output.accept(ModItems.传说之鱼二代.get());
                //output.accept(ModItems.小冰川鱼.get());
                //output.accept(ModItems.放射性鲤鱼.get());
                //output.accept(ModItems.午夜鱿鱼.get());
                //output.accept(ModItems.幽灵鱼.get());
                //output.accept(ModItems.水滴鱼.get());
                //output.accept(ModItems.虾虎鱼.get());
                //output.accept(ModItems.蓝饼铁鱼.get());
                //output.accept(ModItems.狮子鱼.get());
                //output.accept(ModItems.黄貂鱼.get());
                //output.accept(ModItems.史莱姆鱼.get());
                //output.accept(ModItems.虚空鲑鱼.get());
                //output.accept(ModItems.木跃鱼.get());
                //output.accept(ModItems.大比目鱼.get());
                //output.accept(ModItems.蛇齿单线鱼.get());
                //output.accept(ModItems.西鲱.get());
                //output.accept(ModItems.麻哈脂鲤.get());
                //output.accept(ModItems.大头鱼.get());
                //output.accept(ModItems.虎纹鳟鱼.get());
                //output.accept(ModItems.鲟鱼（存疑）.get());
                //output.accept(ModItems.午夜鲤鱼.get());
                //output.accept(ModItems.沙鱼.get());
                //output.accept(ModItems.岩浆鳗鱼.get());
                //output.accept(ModItems.冰柱鱼.get());
                //output.accept(ModItems.石鱼.get());
                //output.accept(ModItems.鬼鱼.get());
                //output.accept(ModItems.大海参.get());
                //output.accept(ModItems.海参.get());
                //output.accept(ModItems.红鲷鱼（存疑）.get());
                //output.accept(ModItems.章鱼.get()); 
                //output.accept(ModItems.红鲻鱼.get());
                //output.accept(ModItems.太阳鱼.get()); 
                //output.accept(ModItems.椰子蟹.get());  //现实
                //output.accept(ModItems.蜘蛛蟹.get());
                //output.accept(ModItems.雪蟹.get());
                //output.accept(ModItems.澳洲雪蟹（水晶蟹）.get());
                //output.accept(ModItems.松叶蟹.get());
                //output.accept(ModItems.老虎蟹.get());
                //output.accept(ModItems.甘氏巨鳌蟹.get());
                //output.accept(ModItems.缅甸青蟹.get()); 
                //output.accept(ModItems.中华鲎.get());
                //output.accept(ModItems.巨象真龙虾.get());
                //output.accept(ModItems.欧洲龙虾.get());
                //output.accept(ModItems.南澳岩龙虾.get()); 
                //output.accept(ModItems.小龙虾.get());z
                //output.accept(ModItems.塔斯马尼亚巨型淡水龙虾.get());
                //output.accept(ModItems.费氏巨鳌虾.get());
                //output.accept(ModItems.三角巨鳌虾.get()); 
                //output.accept(ModItems.墨累河刺鳌虾.get());
                //output.accept(ModItems.澳洲红刺鳌虾.get());
                //output.accept(ModItems.马龙鳌虾.get());             
                //output.accept(ModItems.中华长白山鳌虾（蝲蛄）.get());
                //output.accept(ModItems.琵琶虾.get());
                //output.accept(ModItems.螳螂虾（皮皮虾，虾虎）.get());
                //output.accept(ModItems.非洲犀牛虾.get());
                //output.accept(ModItems.罗氏沼虾.get());
                //output.accept(ModItems.牡丹虾.get());
                //output.accept(ModItems.葡萄虾.get());
                //output.accept(ModItems.大王具足虫.get());
                //output.accept(ModItems.新西兰黑金鲍.get());
                //output.accept(ModItems.澳洲黄金鲍.get());
                //output.accept(ModItems.阿拉斯加红鲍.get());
                //output.accept(ModItems.澳洲黑唇鲍.get());
                //output.accept(ModItems.澳洲青唇鲍.get());
                //output.accept(ModItems.鹅颈藤壶.get());
                //output.accept(ModItems.火山口藤壶.get());
                //output.accept(ModItems.象拔蚌.get());
                //output.accept(ModItems.椰子螺.get());
                //output.accept(ModItems.非洲涡螺.get());
                //output.accept(ModItems.猫眼螺.get());
                //output.accept(ModItems.花螺.get());
                //output.accept(ModItems.响螺.get());
                //output.accept(ModItems.香螺.get());
                //output.accept(ModItems.泥螺.get());
                //output.accept(ModItems.田螺.get());
                //output.accept(ModItems.钉螺.get());
                //output.accept(ModItems.螺狮.get());
                //output.accept(ModItems.翡翠螺.get());
                //output.accept(ModItems.河蚬（淡水蛤蜊）.get());
                //output.accept(ModItems.北极贝.get());
                //output.accept(ModItems.扇贝.get());
                //output.accept(ModItems.蛤蜊.get());
                //output.accept(ModItems.竹蛏.get());
                //output.accept(ModItems.血蛤.get());
                //output.accept(ModItems.中华马珂蛤.get());
                //output.accept(ModItems.水松贝.get());
                //output.accept(ModItems.文蛤.get());
                //output.accept(ModItems.赤贝.get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems.辽参.get());
                //output.accept(ModItems.日本海参.get());
                //output.accept(ModItems.太平洋刺参.get());
                //output.accept(ModItems.阿拉斯加红海参.get());
                //output.accept(ModItems.紫海胆.get());
                //output.accept(ModItems.绿海胆.get());
                //output.accept(ModItems.红海胆.get());
                //output.accept(ModItems.月亮鱼.get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());

                output.accept(ModItems.EMPEROR_CRAB_EGG.get());
                output.accept(ModItems.JONAH_CRAB_EGG.get());
                output.accept(ModItems.PELAGIC_SWIMMING_CRAB_EGG.get());
                output.accept(ModItems.DUNGENESS_CRAB_EGG.get());
                output.accept(ModItems.SWIMMING_CRAB_EGG.get());
                output.accept(ModItems.HERMIT_CRAB_EGG.get());
                output.accept(ModItems.RIVER_CRAB_EGG.get());
                output.accept(ModItems.BLUE_LOBSTER_EGG.get());
                output.accept(ModItems.MARBLED_LOBSTER_EGG.get());
                output.accept(ModItems.DEEP_SEA_STAG_SHRIMP_EGG.get());
                output.accept(ModItems.VANNAMEI_SHRIMP_EGG.get());
                output.accept(ModItems.MANTIS_SHRIMP_EGG.get());
                output.accept(ModItems.RIVER_SHRIMP_EGG.get());
                //output.accept(ModItems.海螺.get());
                //output.accept(ModItems.甲鱼.get());
                output.accept(ModItems.GRASS_CARO_EGG.get());
                output.accept(ModItems.MANDARIN_FISH_EGG.get());
                output.accept(ModItems.LARGE_YELLOW_CROAKER_EGG.get());
                output.accept(ModItems.SILVER_POMFRET_EGG.get());
                output.accept(ModItems.TURBOT_EGG.get());
                output.accept(ModItems.RED_GROUPER_EGG.get());
                output.accept(ModItems.PARROT_FISH_EGG.get());
                output.accept(ModItems.CAMOUFLAGE_GROUPER_EGG.get());
                output.accept(ModItems.KOI_EGG.get());
                output.accept(ModItems.THREADFIN_BREAM_EGG.get());
                output.accept(ModItems.CHECKERBOARD_WRASSE_EGG.get());
                output.accept(ModItems.MORAY_EEL_EGG.get());
                output.accept(ModItems.SPANISH_MACKEREL_EGG.get());
                output.accept(ModItems.STRIPED_BASS_EGG.get());
                output.accept(ModItems.BIGHEAD_CARP_EGG.get());
                output.accept(ModItems.CHINESE_SHAD_EGG.get());
                output.accept(ModItems.PACIFIC_SAURY_EGG.get());
                output.accept(ModItems.FIRE_RAT_FISH_EGG.get());
                output.accept(ModItems.ICETHORN_FISH_EGG.get());
                output.accept(ModItems.SNAKEHEAD_FISH_EGG.get());          // 蛇鱼卵
                output.accept(ModItems.RED_SNAPPER_EGG.get());             // 红鲷鱼卵
                output.accept(ModItems.DEVIL_RAY_EGG.get());               // 魔鬼鱼卵
                output.accept(ModItems.LONGJAW_COILIA_EGG.get());          // 长颌鲚卵
                output.accept(ModItems.SMALL_WHITEBAIT_EGG.get());         // 小银鱼卵
                output.accept(ModItems.ROSY_BARB_EGG.get());               // 胭脂鱼卵
                output.accept(ModItems.ANCHOVY_EGG.get());                 // 凤尾鱼卵
                output.accept(ModItems.HORSEFACE_FISH_EGG.get());          // 马面鱼卵
                output.accept(ModItems.RICE_PADDY_EEL_EGG.get());          // 黄鳝卵
                output.accept(ModItems.SOLE_FISH_EGG.get());               // 鲽鱼卵
                output.accept(ModItems.BLACK_AMUR_BREAM_EGG.get());        // 乌青鱼卵
                output.accept(ModItems.BREAM_EGG.get());                   // 鳊鱼卵
                output.accept(ModItems.SARDINE_EGG.get());                 // 沙丁鱼卵
                output.accept(ModItems.SEA_BASS_EGG.get());                // 海鲈鱼卵
                output.accept(ModItems.RED_SONG_CARP_EGG.get());           // 红歌鲤卵
                output.accept(ModItems.BARRACUDA_EGG.get());               // 巴浪鱼卵
                output.accept(ModItems.THREE_KNIFE_FISH_EGG.get());        // 三刀鱼卵
                output.accept(ModItems.HORSEHEAD_FISH_EGG.get());          // 马头鱼卵
                output.accept(ModItems.FLOWER_SPOTTED_GROUPER_EGG.get());  // 花英斑卵
                output.accept(ModItems.DEEP_SEA_SALMON_EGG.get());         // 深海鲑鱼卵
                output.accept(ModItems.BLUE_FLYING_FISH_EGG.get());        // 蓝飞鱼卵
                output.accept(ModItems.FLYING_FISH_EGG.get());             // 飞鱼卵
                output.accept(ModItems.RAINFISH_EGG.get());                // 雨鱼卵
                output.accept(ModItems.WHITE_STRIPE_FISH_EGG.get());       // 白条鱼卵
                output.accept(ModItems.RED_STINGRAY_EGG.get());            // 赤魟卵
                output.accept(ModItems.NEEDLEFISH_EGG.get());              // 针鱼卵
                output.accept(ModItems.SOLE_FISH_EGG.get());               // 龙利鱼卵
                output.accept(ModItems.CHUB_MACKEREL_EGG.get());           // 青花鱼卵
                output.accept(ModItems.CHINESE_PERCH_EGG.get());           // 桂鱼卵
                output.accept(ModItems.HAIRTAIL_EGG.get());                // 带鱼卵
                output.accept(ModItems.CHUM_SALMON_EGG.get());             // 大马哈鱼卵
                //output.accept(ModItems.乌翅真鲨.get());
                //output.accept(ModItems.血红龙.get());
                //output.accept(ModItems.红海黄金蝶.get());
                //output.accept(ModItems.紫海刺水母.get());
                //output.accept(ModItems.皇冠狗头.get());
                //output.accept(ModItems.花高头龙睛.get());
                //output.accept(ModItems.线纹海马.get());
                //output.accept(ModItems.黄尾蓝魔.get());
                //output.accept(ModItems.秘鲁神仙.get());
                //output.accept(ModItems.三间火箭.get());
                //output.accept(ModItems.红剑.get());
                //output.accept(ModItems.吕宋棘海星.get());
                //output.accept(ModItems.红腹食人鲳.get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems.皇帝蟹.get());
                //output.accept(ModItems.面包蟹.get());
                //output.accept(ModItems.花蟹.get());
                //output.accept(ModItems.珍宝蟹.get());
                //output.accept(ModItems.梭子蟹.get());
                //output.accept(ModItems.寄居蟹.get());
                //output.accept(ModItems.河蟹.get());
                //output.accept(ModItems.蓝龙虾.get());
                //output.accept(ModItems.锦绣龙虾.get());
                //output.accept(ModItems.深海鳌虾.get());
                //output.accept(ModItems.基围虾.get());
                //output.accept(ModItems.濑尿虾.get());
                //output.accept(ModItems.河虾.get());
                //output.accept(ModItems.海螺.get());
                //output.accept(ModItems.甲鱼.get());
                //output.accept(ModItems.生草鱼片.get());
                //output.accept(ModItems.生蕨鱼片.get());
                //output.accept(ModItems.生大黄鱼片.get());
                //output.accept(ModItems.生银鲳鱼片.get());
                //output.accept(ModItems.生多宝鱼片.get());
                //output.accept(ModItems.生红石斑鱼片.get());
                //output.accept(ModItems.生鹦嘴鱼片.get());
                //output.accept(ModItems.生苏眉鱼片.get());
                //output.accept(ModItems.生锦鲤片.get());
                //output.accept(ModItems.生鸡鱼片.get());
                //output.accept(ModItems.生云斑海猪鱼片.get());
                //output.accept(ModItems.生海鳗片.get());
                //output.accept(ModItems.生鲅鱼片.get());
                //output.accept(ModItems.生条纹鲈鱼片.get());
                //output.accept(ModItems.生鳙鱼片.get());
                //output.accept(ModItems.生鲥鱼片.get());
                //output.accept(ModItems.生秋刀鱼片.get());
                //output.accept(ModItems.生火鼠鱼片.get());
                //output.accept(ModItems.生冰棘鱼片.get());
                //output.accept(ModItems.生蛇鱼片.get());
                //output.accept(ModItems.生红鲷鱼片.get());
                //output.accept(ModItems.生魔鬼鱼片.get());
                //output.accept(ModItems.生长颌鲚片.get());
                //output.accept(ModItems.生小银鱼片.get());
                //output.accept(ModItems.生胭脂鱼片.get());
                //output.accept(ModItems.生凤尾鱼片.get());
                //output.accept(ModItems.生马面鱼片.get());
                //output.accept(ModItems.生黄鳝片.get());
                //output.accept(ModItems.生鲽鱼片.get());
                //output.accept(ModItems.生乌青鱼片.get());
                //output.accept(ModItems.生鳊鱼片.get());
                //output.accept(ModItems.生沙丁鱼片.get());
                //output.accept(ModItems.生海鲈鱼片.get());
                //output.accept(ModItems.生红歌鲤片.get());
                //output.accept(ModItems.生巴浪鱼片.get());
                //output.accept(ModItems.生三刀鱼片.get());
                //output.accept(ModItems.生马头鱼片.get());
                //output.accept(ModItems.生花英斑片.get());
                //output.accept(ModItems.生深海鲑鱼片.get());
                //output.accept(ModItems.生蓝飞鱼片.get());
                //output.accept(ModItems.生飞鱼片.get());
                //output.accept(ModItems.生雨鱼片.get());
                //output.accept(ModItems.生白条鱼片.get());
                //output.accept(ModItems.生赤魟片.get());
                //output.accept(ModItems.生针鱼片.get());
                //output.accept(ModItems.生龙利鱼片.get());
                //output.accept(ModItems.生青花鱼片.get());
                //output.accept(ModItems.生桂鱼片.get());
                //output.accept(ModItems.生带鱼片.get());
                //output.accept(ModItems.生大马哈鱼片.get())
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());

                output.accept(ModItems.STRAW_MUSHROOM.get());
                output.accept(ModItems.SEA_MUSHROOM.get());
                output.accept(ModItems.CAVE_MUSHROOM.get());

                output.accept(ModItems.STRAW_MUSHROOM_COLONY.get());
                output.accept(ModItems.SEA_MUSHROOM_COLONY.get());
                output.accept(ModItems.CAVE_MUSHROOM_COLONY.get());

                output.accept(ModItems.CRAB_MEAT.get());   //蟹肉

                output.accept(ModBlocks.TREE_COMPOST.get());  //树坑
                output.accept(ModBlocks.FISHPOND_CORE.get());
                output.accept(ModBlocks.GREENHOUSE_FURNACE.get());
            });
        })
        .register();

    public static void register() {
    }
}
