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
                //output.accept(ModItems.花蟹.get());
                //output.accept(ModItems.珍宝蟹.get());
                output.accept(ModItems.SWIMMING_CRAB.get());
                output.accept(ModItems.HERMIT_CRAB.get());
                //output.accept(ModItems.河蟹.get());
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
                //output.accept(ModItems.锦鲤.get());
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
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
                //output.accept(ModItems..get());
    
                output.accept(ModBlocks.FISHPOND_CORE.get());
                output.accept(ModBlocks.GREENHOUSE_FURNACE.get());
            });
        })
        .register();

    public static void register() {
    }
}
