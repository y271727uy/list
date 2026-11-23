package com.list.data;

import com.list.ListMod;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

import static com.list.ListMod.REGISTRATE;


@Mod.EventBusSubscriber(modid = ListMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGen {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();

        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRegistryProvider(generator.getPackOutput(), registries));
        generator.addProvider(event.includeClient(), new com.list.dsl.OreChineseLanguageProvider(generator.getPackOutput()));
        generator.addProvider(event.includeServer(), new com.list.dsl.OreBehaviorChecks());
        // generator.addProvider(event.includeServer(), new FishPoolLootTableProvider(generator.getPackOutput()));
    }

    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, ModLangs::init);
        REGISTRATE.addDataGenerator(ProviderType.ITEM_MODEL, ModModels::initItem);
        REGISTRATE.addDataGenerator(ProviderType.RECIPE, com.list.dsl.registrate.ModOres::recipes);
    }
}
