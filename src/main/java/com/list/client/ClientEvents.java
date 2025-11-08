package com.list.client;

import com.list.ListMod;
import com.list.item.EggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ListMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
//        event.enqueueWork(() -> {
//            MenuScreens.register(ModMenus.FISHPONDCORE.get(), FishpondcoreScreen::new);
//        });
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        for (EggItem eggItem : EggItem.EGG_ITEMS) {
            event.register(((stack, tintIndex) -> eggItem.getColor(tintIndex)), eggItem);
        }
    }
}