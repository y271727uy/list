package com.list.all;

import com.list.ListMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    // 创建 DeferredRegister
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ListMod.MODID);

    // 主标签页
    @SuppressWarnings("NoTranslation")
    public static final RegistryObject<CreativeModeTab> LIST_TAB = CREATIVE_TABS.register("list", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.list.list"))  // 语言键: itemGroup.listmod.list
                    .icon(() -> new ItemStack(ModItems.INDUSTRIAL_OSMIUM_CREDIT.get()))
                    .displayItems((parameters, output) -> {

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
                    output.accept(ModBlocks.TREE_COMPOST.get());  //树坑
                    output.accept(ModBlocks.FISHPOND_CORE.get());
                    output.accept(ModBlocks.GREENHOUSE_FURNACE.get());
                    })
                    .build()
    );

    // 菌类标签页
    public static final RegistryObject<CreativeModeTab> MUSHROOM_TAB = CREATIVE_TABS.register("crops_mushroom", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.list.mushroom"))
                    .icon(() -> new ItemStack(ModItems.SEA_MUSHROOM_COLONY.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STRAW_MUSHROOM.get());
                        //output.accept(ModItems.香菇.get());
                        output.accept(ModItems.SEA_MUSHROOM.get());
                        output.accept(ModItems.CAVE_MUSHROOM.get());

                        //output.accept(ModItems.紫蘑菇.get());
                        //output.accept(ModItems.熔岩蘑菇.get());
                        //output.accept(ModItems.鸡油菌.get());
                        //output.accept(ModItems.鸡冠菌.get())；

                        output.accept(ModItems.STRAW_MUSHROOM_COLONY.get());
                        output.accept(ModItems.SEA_MUSHROOM_COLONY.get());
                        output.accept(ModItems.CAVE_MUSHROOM_COLONY.get());
                    })
                    .build()
    );
    // 鱼类标签页
    public static final RegistryObject<CreativeModeTab> FISH_TAB = CREATIVE_TABS.register("crops_fish", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.list.fish"))  // 语言键: itemGroup.listmod.crops
                    .icon(() -> new ItemStack(ModItems.DUNGENESS_CRAB.get()))
                    .displayItems((parameters, output) -> {

                    output.accept(ModItems.EMPEROR_CRAB.get());
                    output.accept(ModItems.JONAH_CRAB.get());
                    output.accept(ModItems.PELAGIC_SWIMMING_CRAB.get());
                    output.accept(ModItems.DUNGENESS_CRAB.get());
                    output.accept(ModItems.SWIMMING_CRAB.get());
                    output.accept(ModItems.HERMIT_CRAB.get());
                    output.accept(ModItems.RIVER_CRAB.get());  //河蟹
                    //output.accept(ModItems.蓝龙虾.get());    //蓝龙虾
                    //output.accept(ModItems.锦绣龙虾.get());  //锦绣龙虾
                    //output.accept(ModItems.深海鳌虾.get());  //深海鳌虾
                    //output.accept(ModItems.基围虾.get());    //基围虾
                    //output.accept(ModItems.濑尿虾.get());    //濑尿虾
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
                    output.accept(ModItems.THREADFIN_BREAM.get());         // 鸡鱼
                    output.accept(ModItems.CHECKERBOARD_WRASSE.get());     // 云斑海猪鱼
                    //output.accept(ModItems.MORAY_EEL.get());               // 海鳗
                    //output.accept(ModItems.SPANISH_MACKEREL.get());        // 鲅鱼
                    output.accept(ModItems.STRIPED_BASS.get());            // 条纹鲈鱼
                    output.accept(ModItems.BIGHEAD_CARP.get());            // 鳙鱼
                    output.accept(ModItems.CHINESE_SHAD.get());            // 鲥鱼
                    output.accept(ModItems.PACIFIC_SAURY.get());           // 秋刀鱼
                    output.accept(ModItems.FIRE_RAT_FISH.get());           // 火鼠鱼
                    output.accept(ModItems.ICETHORN_FISH.get());           // 冰棘鱼
                    output.accept(ModItems.SNAKEHEAD_FISH.get());          // 蛇鱼
                    output.accept(ModItems.RED_SNAPPER.get());             // 红鲷鱼
                    output.accept(ModItems.DEVIL_RAY.get());               // 魔鬼鱼
                    output.accept(ModItems.LONGJAW_COILIA.get());          // 长颌鲚
                    output.accept(ModItems.SMALL_WHITEBAIT.get());         // 小银鱼
                    output.accept(ModItems.ROSY_BARB.get());               // 胭脂鱼
                    output.accept(ModItems.ANCHOVY.get());                 // 凤尾鱼
                    output.accept(ModItems.HORSEFACE_FISH.get());          // 马面鱼
                    //output.accept(ModItems.RICE_PADDY_EEL.get());          // 黄鳝
                    output.accept(ModItems.FLUKE.get());               // 鲽鱼
                    output.accept(ModItems.BLACK_AMUR_BREAM.get());        // 乌青鱼
                    output.accept(ModItems.BREAM.get());                   // 鳊鱼
                    output.accept(ModItems.SARDINE.get());                 // 沙丁鱼
                    output.accept(ModItems.SEA_BASS.get());                // 海鲈鱼
                    output.accept(ModItems.RED_SONG_CARP.get());           // 红歌鲤
                    output.accept(ModItems.BARRACUDA.get());               // 巴浪鱼
                    output.accept(ModItems.THREE_KNIFE_FISH.get());        // 三刀鱼
                    output.accept(ModItems.HORSEHEAD_FISH.get());          // 马头鱼
                    output.accept(ModItems.FLOWER_SPOTTED_GROUPER.get());  // 花英斑
                    output.accept(ModItems.DEEP_SEA_SALMON.get());         // 深海鲑鱼
                    output.accept(ModItems.BLUE_FLYING_FISH.get());        // 蓝飞鱼
                    //output.accept(ModItems.FLYING_FISH.get());             // 飞鱼
                    output.accept(ModItems.RAINFISH.get());                // 雨鱼
                    output.accept(ModItems.WHITE_STRIPE_FISH.get());       // 白条鱼
                    //output.accept(ModItems.RED_STINGRAY.get());            // 赤魟
                    output.accept(ModItems.NEEDLEFISH.get());              // 针鱼
                    output.accept(ModItems.SOLE_FISH.get());               // 龙利鱼
                    output.accept(ModItems.CHUB_MACKEREL.get());           // 青花鱼
                    output.accept(ModItems.CHINESE_PERCH.get());           // 桂鱼
                    //output.accept(ModItems.HAIRTAIL.get());                // 带鱼
                    //output.accept(ModItems.CHUM_SALMON.get());             // 大马哈鱼
                    //output.accept(ModItems.BLACKFIN_SHARK.get());          // 乌翅真鲨
                    //output.accept(ModItems.BLOOD_RED_DRAGONFISH.get());    // 血红龙
                    //output.accept(ModItems.RED_SEA_GOLDEN_BUTTERFLY.get()); // 红海黄金蝶
                    //output.accept(ModItems.PURPLE_SEA_JELLYFISH.get());    // 紫海刺水母
                    //output.accept(ModItems.CROWN_DOGHEAD.get());           // 皇冠狗头
                    //output.accept(ModItems.FLOWER_HIGHHEAD_DRAGONEYE.get());// 花高头龙睛
                    //output.accept(ModItems.STRIPED_SEAHORSE.get());        // 线纹海马
                    //output.accept(ModItems.YELLOWTAIL_BLUE_DEMON.get());   // 黄尾蓝魔
                    //output.accept(ModItems.PERUVIAN_FAIRYFISH.get());      // 秘鲁神仙
                    //output.accept(ModItems.THREE_SPOTTED_ROCKETFISH.get());// 三间火箭
                    //output.accept(ModItems.RED_SWORDFISH.get());           // 红剑
                    //output.accept(ModItems.LUZON_SPINY_STARFISH.get());    // 吕宋棘海星
                    //output.accept(ModItems.RED_BELLIED_PIRANHA.get());     // 红腹食人鲳
                    //output.accept(ModItems.GRASS_CARP_KING.get());            //草鱼王
                    //output.accept(ModItems.RIVER_SHRIMP_KING.get());          //对虾王
                    //output.accept(ModItems.RIVER_CRAB_KING.get());            //河蟹王
                    //output.accept(ModItems.CARP_KING.get());                  //鲤鱼王
                    //output.accept(ModItems.PUFFERFISH_KING.get());            //河豚王
                    //output.accept(ModItems.CATFISH_KING.get());               //鲶鱼王
                    //output.accept(ModItems.MANDARIN_FISH_KING.get());         //鳜鱼王（桂花鱼）
                    //output.accept(ModItems.RED_TILAPIA_KING.get());           //红罗非鱼王
                    //output.accept(ModItems.LARGE_YELLOW_CROAKER_KING.get());  //大黄鱼王
                    //output.accept(ModItems.SILVER_POMFRET_KING.get());        //银鲳鱼王
                    //output.accept(ModItems.HAIRTAIL_KING.get());              //带鱼王
                    //output.accept(ModItems.TURBOT_KING.get());                //多宝鱼王
                    //output.accept(ModItems.RED_GROUPER_KING.get());           //红石斑鱼王
                    //output.accept(ModItems.SALMON_KING.get());                //鲑鱼王
                    //output.accept(ModItems.PARROT_FISH_KING.get());           //鹦嘴鱼王
                    //output.accept(ModItems.LOBSTER_KING.get());               //龙虾王
                    //output.accept(ModItems.NAPOLEON_FISH_KING.get());         //苏眉鱼王（拿破仑鱼）
                    //output.accept(ModItems.THREADFIN_BREAM_KING.get());       //鸡鱼王（多指鸡鱼/鲷类，最常见为鲷科 Threadfin Bream）
                    //output.accept(ModItems.SQUID_KING.get());                 //鱿鱼王
                    //output.accept(ModItems.CHECKERBOARD_WRASSE_KING.get());   //云斑海猪鱼王
                    //output.accept(ModItems.MORAY_EEL_KING.get());             //海鳗王
                    //output.accept(ModItems.SOFTSHELL_TURTLE_KING.get());      //甲鱼王
                    //output.accept(ModItems.SWIMMING_CRAB_KING.get());         //梭子蟹王
                    //output.accept(ModItems.SPANISH_MACKEREL_KING.get());      //鲅鱼王
                    //output.accept(ModItems.STRIPED_BASS_KING.get());          //条纹鲈鱼王
                    //output.accept(ModItems.RAINBOW_TROUT_KING.get());         //虹鳟鱼王
                    //output.accept(ModItems.BLUEGILL_KING.get());              //蓝鳃太阳鱼王
                    //output.accept(ModItems.BIGHEAD_CARP_KING.get());          //鳙鱼王
                    //output.accept(ModItems.PACIFIC_SAURY_KING.get());         //秋刀鱼王
                    //output.accept(ModItems.RAINFISHI_KING.get());             //雨鱼王
                    //output.accept(ModItems.FIRE_MOUSEFISH_KING.get());        //火鼠鱼王（幻想生物，保留直译）
                    //output.accept(ModItems.ICE_THORN_FISH_KING.get());        //冰棘鱼王（幻想生物直译）
                    //output.accept(ModItems.SNAKEHEAD_KING.get());             //蛇鱼王（黑鱼 Snakehead）
                    //output.accept(ModItems.SOLE_FISH_KING.get());             //龙利鱼王（多指鲽目 Sole 或 Flounder，这里取 Sole）
                    //output.accept(ModItems.RED_SNAPPER_KING.get());           //红鲷鱼王
                    //output.accept(ModItems.TOPMOUTH_GUDGEON_KING.get());      //白条鱼王（常见“白条鱼”= Topmouth gudgeon）
                    //output.accept(ModItems.TUNA_KING.get());                  //金枪鱼王
                    //output.accept(ModItems.CLOWNFISH_KING.get());             //小丑鱼王
                    //output.accept(ModItems.MANTA_RAY_KING.get());             //魔鬼鱼王（Manta Ray）
                    //output.accept(ModItems.COCKLE.get());                 //鸟蛤（就是鸟贝） cockle      //蟹 虾 贝 软体 鱼
                    //output.accept(ModItems.CLAM.get());                   // 蚌（游戏中为 Clam）
                    //output.accept(ModItems.OYSTER.get());                 // 牡蛎
                    //output.accept(ModItems.NAUTILUS_SHELL.get());         // 玉蜀螺（官方：Nautilus Shell）
                    //output.accept(ModItems.CRIMSONFISH.get());            // 绯红鱼（传奇鱼之一：Crimsonfish）
                    //output.accept(ModItems.LEGEND.get());                 // 传说之鱼（Legend）
                    //output.accept(ModItems.GLACIERFISH.get());            // 冰川鱼（Glacierfish）
                    //output.accept(ModItems.MUTANT_CARP.get());            // 变种鲤鱼（Mutant Carp）
                    //output.accept(ModItems.SON_OF_CRIMSONFISH.get());     // 绯红鱼之子（Son of Crimsonfish）
                    //output.accept(ModItems.Ms_ANGELFISH.get());           // 雌𩽾𩾌鱼
                    //output.accept(ModItems.LEGEND_II.get());              // 传说之鱼二代（Legend II）
                    //output.accept(ModItems.GLACIERFISH_JR.get());         // 小冰川鱼（Glacierfish Jr.）
                    //output.accept(ModItems.RADIOACTIVE_CARP.get());       // 放射性鲤鱼（Radioactive Carp）
                    //output.accept(ModItems.MIDNIGHT_SQUID.get());         // 午夜鱿鱼（Midnight Squid）
                    //output.accept(ModItems.GHOSTFISH.get());              // 幽灵鱼（Ghostfish）
                    //output.accept(ModItems.BLOBFISH.get());               // 水滴鱼（Blobfish）
                    //output.accept(ModItems.GOBY.get());                   // 虾虎鱼（Goby，游戏未收录，为通用译名）
                    //output.accept(ModItems.BLUE_DISC_CUSKEEL.get());      // 蓝饼铁鱼（依据形态翻译）
                    //output.accept(ModItems.LIONFISH.get());               // 狮子鱼（Lionfish）
                    //output.accept(ModItems.STINGRAY.get());               // 黄貂鱼（Stingray）
                    //output.accept(ModItems.SLIMEJACK.get());              // 史莱姆鱼（Slimejack）
                    //output.accept(ModItems.VOID_SALMON.get());            // 虚空鲑鱼（Void Salmon）
                    //output.accept(ModItems.WOODSKIP.get());               // 木跃鱼（Woodskip）
                    //output.accept(ModItems.SNAILEY_ONE_LINE_FISH.get());  // 蛇齿单线鱼（无官方名 → 合理科学译名）
                    //output.accept(ModItems.HERRING.get());                // 西鲱（Herring）
                    //output.accept(ModItems.CHUB.get());                   // 大头鱼（Chub）
                    //output.accept(ModItems.TIGER_TROUT.get());            // 虎纹鳟鱼（Tiger Trout）
                    //output.accept(ModItems.STURGEON.get());               // 鲟鱼（Sturgeon）
                    //output.accept(ModItems.MIDNIGHT_CARP.get());          // 午夜鲤鱼（Midnight Carp）
                    //output.accept(ModItems.SAND_FISH.get());              // 沙鱼（Sandfish）
                    //output.accept(ModItems.LAVA_EEL.get());               // 岩浆鳗鱼（Lava Eel）
                    //output.accept(ModItems.ICE_PIP.get());                // 冰柱鱼（Ice Pip）
                    //output.accept(ModItems.STONEFISH.get());              // 石鱼（Stonefish）
                    //output.accept(ModItems.SPIRIT_EEL.get());             // 鬼鱼（Spirit Eel）
                    //output.accept(ModItems.SEA_CUCUMBER.get());           // 大海参（Sea Cucumber，注意区分尺寸时用 Super Cucumber）
                    //output.accept(ModItems.SUPER_CUCUMBER.get());         // 海参（Super Cucumber）
                    //output.accept(ModItems.RED_MULLET.get());             // 红鲻鱼（Red Mullet）
                    //output.accept(ModItems.SUNFISH.get());                // 太阳鱼（Sunfish）
                    //output.accept(ModItems.CoconutCrab.get());  //椰子蟹  现实
                    //output.accept(ModItems.SpiderCrab.get());  //蜘蛛蟹
                    //output.accept(ModItems.SnowCrab.get());  //雪蟹
                    //output.accept(ModItems.CrystalCrab.get());  //水晶蟹（商品名称一般是澳洲雪蟹，事实上和雪蟹没有半毛钱关系）
                    //output.accept(ModItems.RedKingCrab.get());  //松叶蟹（注意：松叶蟹对应 red king crab / japanese king crab）
                    //output.accept(ModItems.TigerCrab.get());  //老虎蟹
                    //output.accept(ModItems.GiantMudCrab.get());  //甘氏巨鳌蟹
                    //output.accept(ModItems.MyanmarMudCrab.get());  //缅甸青蟹
                    //output.accept(ModItems.ChineseHorseshoeCrab.get());  //中华鲎
                    //output.accept(ModItems.GiantMarineLobster.get());  //巨象真龙虾
                    //output.accept(ModItems.EuropeanLobster.get());  //欧洲龙虾
                    //output.accept(ModItems.SouthAustraliaRockLobster.get());  //南澳岩龙虾
                    //output.accept(ModItems.Crayfish.get());  //小龙虾
                    //output.accept(ModItems.TasmanianGiantFreshwaterCrayfish.get());  //塔斯马尼亚巨型淡水龙虾
                    //output.accept(ModItems.FitzroyRiverYabby.get());  //费氏巨鳌虾
                    //output.accept(ModItems.TriangleYabby.get());  //三角巨鳌虾
                    //output.accept(ModItems.MurrayCrayfish.get());  //墨累河刺鳌虾
                    //output.accept(ModItems.AustralianRedClawCrayfish.get());  //澳洲红刺鳌虾
                    //output.accept(ModItems.MarronCrayfish.get());  //马龙鳌虾
                    //output.accept(ModItems.ChangbaishanCrayfish.get());  //中华长白山鳌虾 其实是蝲蛄
                    //output.accept(ModItems.SlipperLobster.get());  //琵琶虾
                    //output.accept(ModItems.MantisShrimp.get());  //螳螂虾
                    //output.accept(ModItems.RhinocerosShrimp.get());  //非洲犀牛虾
                    //output.accept(ModItems.GiantRiverPrawn.get());  //罗氏沼虾
                    //output.accept(ModItems.BotaniShrimp.get());  //牡丹虾
                    //output.accept(ModItems.GrapeShrimp.get());  //葡萄虾
                    //output.accept(ModItems.GiantIsopod.get());  //大王具足虫
                    //output.accept(ModItems.NewZealandBlackFootAbalone.get());  //新西兰黑金鲍
                    //output.accept(ModItems.AustralianGoldenAbalone.get());  //澳洲黄金鲍
                    //output.accept(ModItems.AlaskaRedAbalone.get());  //阿拉斯加红鲍
                    //output.accept(ModItems.AustralianBlacklipAbalone.get());  //澳洲黑唇鲍
                    //output.accept(ModItems.AustralianGreenlipAbalone.get());  //澳洲青唇鲍
                    //output.accept(ModItems.GooseneckBarnacle.get());  //鹅颈藤壶
                    //output.accept(ModItems.VolcanicBarnacle.get());  //火山口藤壶
                    //output.accept(ModItems.Geoduck.get());  //象拔蚌
                    //output.accept(ModItems.CoconutSnail.get());  //椰子螺
                    //output.accept(ModItems.AfricanTurboSnail.get());  //非洲涡螺
                    //output.accept(ModItems.CatseyeSnail.get());  //猫眼螺
                    //output.accept(ModItems.FlowerSnail.get());  //花螺
                    //output.accept(ModItems.QueenConch.get());  //响螺
                    //output.accept(ModItems.FragrantConch.get());  //香螺
                    //output.accept(ModItems.MudSnail.get());  //泥螺
                    //output.accept(ModItems.FieldSnail.get());  //田螺
                    //output.accept(ModItems.NailSnail.get());  //钉螺
                    //output.accept(ModItems.RiverSnail.get());  //螺狮
                    //output.accept(ModItems.JadeSnail.get());  //翡翠螺
                    //output.accept(ModItems.FreshwaterClam.get());  //河蚬（淡水蛤蜊）
                    //output.accept(ModItems.ArcticSurfClam.get());  //北极贝
                    //output.accept(ModItems.Scallop.get());  //扇贝
                    //output.accept(ModItems.Clam.get());  //蛤蜊
                    //output.accept(ModItems.RazorClam.get());  //竹蛏
                    //output.accept(ModItems.BloodCockle.get());  //血蛤
                    //output.accept(ModItems.ChineseMahuaClam.get());  //中华马珂蛤
                    //output.accept(ModItems.WaterPineClam.get());  //水松贝
                    //output.accept(ModItems.AsariClam.get());  //文蛤
                    //output.accept(ModItems.Akabai.get());  //赤贝
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
                    //output.accept(ModItems.龙趸石斑鱼.get());
                    //output.accept(ModItems.马林鱼（剑鱼）.get());
                    //output.accept(ModItems.鲣鱼.get());
                    //output.accept(ModItems.泥鳅.get());
                    //output.accept(ModItems..get());
                    //output.accept(ModItems..get());
                    //output.accept(ModItems..get());
                    //output.accept(ModItems..get());

                     })
                    .build()
    );

    /*
    // 鱼片
    public static final RegistryObject<CreativeModeTab> FISH_SLICE_TAB = CREATIVE_TABS.register("fish_slice", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.list.fish_slice"))
                    .icon(() -> new ItemStack(ModItems..get()))
                    .displayItems((parameters, output) -> {

                    //output.accept(ModItems.蓝龙虾.get());
                    //output.accept(ModItems.锦绣龙虾.get());
                    //output.accept(ModItems.深海鳌虾.get());
                    //output.accept(ModItems.基围虾.get());
                    //output.accept(ModItems.濑尿虾.get());
                    //output.accept(ModItems.河虾.get());
                    //output.accept(ModItems.海螺片.get());
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

                    })
                    .build()
    );
    */


     //卵
    public static final RegistryObject<CreativeModeTab> EGG_TAB = CREATIVE_TABS.register("list_egg", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.list.egg"))  // 语言键: itemGroup.listmod.list
                    .icon(() -> new ItemStack(ModItems.EMPEROR_CRAB_EGG.get()))
                    .displayItems((parameters, output) -> {
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
                    //output.accept(ModItems.海螺卵.get());
                    //output.accept(ModItems.甲鱼卵.get());
                    output.accept(ModItems.GRASS_CARO_EGG.get());
                    output.accept(ModItems.MANDARIN_FISH_EGG.get());
                    output.accept(ModItems.LARGE_YELLOW_CROAKER_EGG.get());
                    output.accept(ModItems.SILVER_POMFRET_EGG.get());
                    output.accept(ModItems.TURBOT_EGG.get());
                    output.accept(ModItems.RED_GROUPER_EGG.get());
                    output.accept(ModItems.PARROT_FISH_EGG.get());
                    output.accept(ModItems.CAMOUFLAGE_GROUPER_EGG.get());
                    output.accept(ModItems.KOI_EGG.get());   //锦鲤卵
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
                    output.accept(ModItems.FLUKE_EGG.get());                   // 鲽鱼卵
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
                    output.accept(ModItems.BLACKFIN_SHARK_EGG.get());          // 乌翅真鲨卵
                    output.accept(ModItems.BLOOD_RED_DRAGONFISH_EGG.get());    // 血红龙卵
                    output.accept(ModItems.RED_SEA_GOLDEN_BUTTERFLY_EGG.get()); // 红海黄金蝶卵
                    output.accept(ModItems.PURPLE_SEA_JELLYFISH_EGG.get());    // 紫海刺水母卵
                    output.accept(ModItems.CROWN_DOGHEAD_EGG.get());           // 皇冠狗头卵
                    output.accept(ModItems.FLOWER_HIGHHEAD_DRAGONEYE_EGG.get());// 花高头龙睛卵
                    output.accept(ModItems.STRIPED_SEAHORSE_EGG.get());        // 线纹海马卵
                    output.accept(ModItems.YELLOWTAIL_BLUE_DEMON_EGG.get());   // 黄尾蓝魔卵
                    output.accept(ModItems.PERUVIAN_FAIRYFISH_EGG.get());      // 秘鲁神仙卵
                    output.accept(ModItems.THREE_SPOTTED_ROCKETFISH_EGG.get());// 三间火箭卵
                    output.accept(ModItems.RED_SWORDFISH_EGG.get());           // 红剑卵
                    output.accept(ModItems.LUZON_SPINY_STARFISH_EGG.get());    // 吕宋棘海星卵
                    output.accept(ModItems.RED_BELLIED_PIRANHA_EGG.get());     // 红腹食人鲳卵
                    })
                    .build()
    );

    // 鱼片
    public static final RegistryObject<CreativeModeTab> FOOD_AND_PRODUCT_TAB = CREATIVE_TABS.register("food_and_product", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.list.food_and_product"))
                            .icon(() -> new ItemStack(ModItems.RED_CABBAGE_LEAF.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.CRAB_MEAT.get());   //蟹肉
                output.accept(ModItems.RED_CABBAGE_LEAF.get());//红卷心菜叶
            })
            .build()
    );


    // 农作物标签页
    public static final RegistryObject<CreativeModeTab> CROPS_TAB = CREATIVE_TABS.register("crops_crops", () ->
            CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.list.crops"))  // 语言键: itemGroup.listmod.crops
                    .icon(() -> new ItemStack(ModItems.RED_ONION.get()))
                    .displayItems((parameters, output) -> {
                        //output.accept(ModItems.SPRING_BAMBOO_SHOOT.get());     // 春笋   //明日之后蔬菜
                    //output.accept(ModItems.HAIRY_BAMBOO_SHOOT.get());      // 毛笋
                    //output.accept(ModItems.LOTUS_ROOT.get());              // 莲藕
                    //output.accept(ModItems.GLUTINOUS_RICE.get());          // 糯米
                    //output.accept(ModItems.MUNG_BEAN.get());               // 绿豆
                    //output.accept(ModItems.SESAME_SEED.get());             // 芝麻
                    //output.accept(ModItems.RAPESEED.get());                // 油菜
                    //output.accept(ModItems.CHRYSANTHEMUM.get());           // 菊花
                    //output.accept(ModItems.PARSNIP.get());                 // 防风草     //蔬菜 星露谷
                    //output.accept(ModItems.SNOW_YAM.get());                // 雪山药
                    //output.accept(ModItems.WHITE_RADISH.get());            // 白萝卜
                    //output.accept(ModItems.AMARANTH.get());                // 苋菜
                    output.accept(ModItems.RED_CABBAGE.get());               //红叶卷心菜
                    //output.accept(ModItems.GOLDEN_ZUCCHINI.get());  //金皮西葫芦
                    //output.accept(ModItems.ARTICHOKE.get());        //洋蓟
                    //output.accept(ModItems.BOK_CHOY.get());         //小白菜
                    //output.accept(ModItems.YAM.get());              //山药
                    //output.accept(ModItems.FROSTED_MELON.get());    //霜瓜
                    //output.accept(ModItems.CABBAGE.get());          //甘蓝菜
                    //output.accept(ModItems.WINTER_ROOT.get());      //冬根
                    //output.accept(ModItems.QI_GUAN.get());          //齐瓜
                    //output.accept(ModItems.WILD_WASABI.get());       //野山葵
                    //output.accept(ModItems.WASABI_ROOT.get());       //山葵根       //蔬菜 星露谷聚宝盆mod
                    //output.accept(ModItems.HOROPPA.get());           //胡罗巴
                    //output.accept(ModItems.MUSTARD.get());           //芥菜
                    //output.accept(ModItems.OREGANO.get());           //牛至
                    //output.accept(ModItems.CHIVES.get());            //细香葱
                    //output.accept(ModItems.OKRA.get());              //秋葵
                    //output.accept(ModItems.THYMUS.get());            //百里香
                    //output.accept(ModItems.LETTUCE.get());           //生菜
                    //output.accept(ModItems.CATNIP.get());            //猫薄荷
                    //output.accept(ModItems.BAY_LEAF.get());          //月桂叶
                    //output.accept(ModItems.LENTIL.get());            //扁豆
                    //output.accept(ModItems.FENNEL.get());            //小茴香
                    //output.accept(ModItems.CILANTRO.get());          //香菜
                    //output.accept(ModItems.ROSEMARY.get());          //迷迭香
                    //output.accept(ModItems.DILL.get());              //莳萝
                    //output.accept(ModItems.CELERY.get());            //芹菜
                    //output.accept(ModItems.TARRAGON.get());          //龙蒿
                    //output.accept(ModItems.BEAN_SPROUT.get());       //豆芽
                    //output.accept(ModItems.ALOE.get());              //芦荟
                    //output.accept(ModItems.WORMWOOD.get());          //苦艾
                    //output.accept(ModItems.RAPESEED_FLOWER.get());   //油菜花
                    //output.accept(ModItems.PERILLA_LEAF.get());      //紫苏叶
                    //output.accept(ModItems.PEA.get());               //豌豆
                    //output.accept(ModItems.RED_BEAN.get());          //赤豆
                    //output.accept(ModItems.BASIL.get());             //罗勒
                    output.accept(ModItems.RED_ONION.get());           //红洋葱
                    //output.accept(ModItems.SPEARMINT.get());            //香花薄荷
                    //output.accept(ModItems.AGAVE.get());                //龙舌兰
                    //output.accept(ModItems.BLUE_AGAVE.get());           //蓝龙舌兰
                    //output.accept(ModItems.SHALLOT.get());              //红葱头（红葱头一般叫红毛葱）
                    //output.accept(ModItems.RED_KIDNEY_BEAN.get());      //红腰豆（有毒）
                    //output.accept(ModItems.NAVY_BEAN.get());            //海军豆
                    //output.accept(ModItems.PURPLE_YAM.get());           //紫山药
                    //output.accept(ModItems.LICORICE_ROOT.get());        //洋甘草根
                    //output.accept(ModItems.HAVANA_CHILI.get());         //哈瓦那辣椒
                    //output.accept(ModItems.BUCKWHEAT.get());            //荞麦
                    //output.accept(ModItems.ASPARAGUS.get());            //芦笋
                    //output.accept(ModItems.CREAM_PUMPKIN.get());        //奶油南瓜
                    //output.accept(ModItems.QUINOA.get());               //藜麦
                    //output.accept(ModItems.NUTMEG.get());               //肉豆蔻
                    //output.accept(ModItems.SAGE.get());                 //鼠尾草
                    output.accept(ModItems.GINSENG.get());              //人参
                    output.accept(ModItems.LAYER_TREE_LEAF.get());      //千层树叶
                    output.accept(ModItems.CAMPHOR_LEAF.get());         //樟树叶
                    output.accept(ModItems.EUCALYPTUS_LEAF.get());      //桉树叶
                    output.accept(ModItems.ANCIENT_FRUIT.get());          //上古水果（星露谷水果，反正分不清了就这样吧）
                    output.accept(ModItems.GEMBERRY.get());               //宝石甜莓
                    output.accept(ModItems.CRYSTAL_FRUIT.get());          //水晶果
                    output.accept(ModItems.HEART_FRUIT.get());            //人心果
                    //output.accept(ModItems.LUOHAN_ORANGE.get());          //罗汉橙
                    //output.accept(ModItems.BANANA.get());                 //芭蕉
                    //output.accept(ModItems.AMERICAN_RASPBERRY.get());     //美洲大树莓
                    output.accept(ModItems.MUSHROOM_BERRY.get());         //菇娘果
                    //output.accept(ModItems.BREADFRUIT.get());             //面包果
                    //output.accept(ModItems.FRAGRANT_BERRY.get());         //香味浆果
                    //output.accept(ModItems.MUSK_MELON.get());             //香瓜
                    //output.accept(ModItems.GOLDEN_MELON.get());           //金丝甜瓜
                    output.accept(ModItems.NECTARINE.get());              //油桃
                    output.accept(ModItems.CASHEW.get());                 //腰果
                    output.accept(ModItems.PECAN.get());                  //碧根果
                    output.accept(ModItems.PISTACHIO.get());              //开心果
                    //output.accept(ModItems.YELLOW_PEACH.get());           //黄桃（明日之后 水果 真的很少）
                    //output.accept(ModItems.SEA_BUCKTHORN.get());          //沙棘果
                    //output.accept(ModItems.LONGAN.get());                 //龙眼
                    //output.accept(ModItems.MULBERRY.get());               //桑葚
                    //output.accept(ModItems.WINTER_JUJUBE.get());          //冬枣
                    //output.accept(ModItems.WATERMELON_84.get());          //84西瓜
                    //output.accept(ModItems..get());       //黑美人西瓜
                    //output.accept(ModItems..get());       //宁夏晒砂瓜
                    //output.accept(ModItems..get());       //黄金麒麟瓜 （外部金黄，黄色肉）
                    //output.accept(ModItems..get());       //金色罗黄西瓜 （黄色肉，外部绿黑）
                    //output.accept(ModItems..get());       //圣彩西瓜（外部绿黑，内部橙红色）
                    //output.accept(ModItems..get());       //赤肉甜西瓜（Crimson Sweet）
                    //output.accept(ModItems..get());       //三白瓜 （就是全白的西瓜）
                    //output.accept(ModItems..get());       //新红宝西瓜
                    //output.accept(ModItems..get());       //墨童西瓜
                    //output.accept(ModItems..get());       //日本Densuke黑皮西瓜（伝助スイカ）  英文：Japanese Densuke Black Watermelon
                    //output.accept(ModItems..get());       //打瓜 （籽瓜）
                    //output.accept(ModItems..get());       //石山西瓜
                    //output.accept(ModItems..get());       //Moon & Stars Watermelon
                    //output.accept(ModItems..get());       //非洲野西瓜 Citrullus lanatus var. citroides
                    //output.accept(ModItems..get());       //药西瓜（有毒）
                    //output.accept(ModItems.DURIO_GRAVEOLENS.get());       //红肉榴莲 拉丁学名Durio graveolens
                    //output.accept(ModItems..get());       //龟榴莲   拉丁学名Durio testudinarum
                    //output.accept(ModItems..get());       //古泰榴莲 拉丁学名Durio kutejensis
                    //output.accept(ModItems..get());       //奥氏榴莲 拉丁学名Durio oxleyanus
                    //output.accept(ModItems..get());       //大花榴莲 拉丁学名Durio grandiflorus
                    //output.accept(ModItems..get());       //黑刺榴莲 这玩意不是野生品种了
                    //output.accept(ModItems..get());       //犀牛蕉
                    //output.accept(ModItems..get());       //千指蕉
                    //output.accept(ModItems..get());       //小王子蕉
                    //output.accept(ModItems..get());       //象腿蕉
                    //output.accept(ModItems..get());       //朝天蕉  不是tmd重庆那个朝天椒
                    //output.accept(ModItems..get());       //南洋红香蕉
                    //output.accept(ModItems..get());       //蓝爪哇香蕉 Blue Java   题外话：FUCK JAVA!!!
                    //output.accept(ModItems..get());       //大麦克香蕉
                    //output.accept(ModItems..get());       //红宝石香蕉
                    //output.accept(ModItems..get());       //巨人香蕉
                    //output.accept(ModItems..get());       //Isla Banana
                    //output.accept(ModItems..get());       //菜蕉
                    //output.accept(ModItems..get());       //皇帝蕉
                    //output.accept(ModItems..get());       //费香蕉  应该是学名fe’i banana
                    //output.accept(ModItems..get());       //野蕉（香蕉老祖）
                    //output.accept(ModItems..get());       //小果野蕉（香蕉老祖）
                    output.accept(ModItems.RED_PINEAPPLE.get());       //红菠萝 外皮红色
                    //output.accept(ModItems..get());       //台湾土菠萝
                    //output.accept(ModItems..get());       //粉红菠萝 pinkglow 内部粉红
                    //output.accept(ModItems..get());       //海南鸡冠凤梨
                    output.accept(ModItems.PERFUME_PINEAPPLE.get());       //香水凤梨
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //中国南瓜 Cucurbita moschata
                    //output.accept(ModItems..get());       //蓝哈伯德南瓜Blue Hubbard
                    //output.accept(ModItems..get());       //意大利青皮南瓜 Marina di Chioggia
                    //output.accept(ModItems..get());       //大西洋巨人南瓜 Cucurbita maxima, Atlantic Giant
                    //output.accept(ModItems..get());       //西非牡蛎瓜 Cucumeropsis mannii
                    //output.accept(ModItems..get());       //白沙蜜甜瓜（都白）
                    //output.accept(ModItems..get());       //羊角密瓜
                    //output.accept(ModItems..get());       //玲珑密瓜（绿肉）
                    //output.accept(ModItems..get());       //香妃密瓜（黄皮黄肉）
                    //output.accept(ModItems..get());       //白兰瓜（白皮绿肉）
                    //output.accept(ModItems..get());       //伊丽莎白（黄皮白肉）
                    //output.accept(ModItems..get());       //脆宝甜瓜（全绿的甜瓜）
                    //output.accept(ModItems..get());       //江西梨瓜（白皮绿肉的甜瓜）
                    //output.accept(ModItems..get());       //流星甜瓜（白皮白肉甜瓜）
                    //output.accept(ModItems..get());       //博洋9号密瓜
                    //output.accept(ModItems..get());       //面瓜
                    //output.accept(ModItems..get());       //花皮冬瓜
                    //output.accept(ModItems..get());       //菜瓜（烧瓜）
                    //output.accept(ModItems..get());       //冬瓜
                    //output.accept(ModItems..get());       //蛇瓜
                    //output.accept(ModItems..get());       //瓠瓜
                    //output.accept(ModItems..get());       //佛手瓜
                    //output.accept(ModItems..get());       //苦瓜
                    //output.accept(ModItems..get());       //苹果苦瓜
                    //output.accept(ModItems..get());       //丝瓜
                    //output.accept(ModItems..get());       //马泡瓜 学名Cucumis melo var. agrestis
                    //output.accept(ModItems..get());       //拇指西瓜（糙毛马㼎儿）学名Melothria scabra
                    //output.accept(ModItems..get());       //蒙特可可 Theobroma bicolor
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //
                    //output.accept(ModItems..get());       //   
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}

