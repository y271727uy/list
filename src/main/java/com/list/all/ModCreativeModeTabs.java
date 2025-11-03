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
                //方块下面
                output.accept(ModBlocks.FISHPOND_CORE.get());
                output.accept(ModBlocks.GREENHOUSE_FURNACE.get());
            });
        })
        .register();

    public static void register() {
    }
}
