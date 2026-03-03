package com.list.client;

import com.list.ListMod;
import com.list.all.ModRecipes;
import com.list.integration.jei.tooltip.SellingBinClientTooltipComponent;
import com.list.integration.jei.tooltip.SellingBinTooltipComponent;
import com.list.item.EggItem;
import com.list.recipe.SellingBinRecipe;
import com.mojang.datafixers.util.Either;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = ListMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ModBusEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            for (EggItem eggItem : EggItem.EGG_ITEMS) {
                event.register(((stack, tintIndex) -> eggItem.getColor(tintIndex)), eggItem);
            }
        }

        @SubscribeEvent
        public static void registerTooltipComponents(RegisterClientTooltipComponentFactoriesEvent event) {
            event.register(SellingBinTooltipComponent.class, SellingBinClientTooltipComponent::new);
        }
    }

    @Mod.EventBusSubscriber(modid = ListMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeBusEvents {

        @SubscribeEvent
        public static void onRenderTooltipPre(RenderTooltipEvent.GatherComponents event) {
            Minecraft mc = Minecraft.getInstance();
            ClientPacketListener connection = mc.getConnection();
            ClientLevel level = mc.level;
            if (connection != null && level != null) {
                connection.getRecipeManager().getRecipeFor(
                        ModRecipes.SELLING_BIN_RECIPE_TYPE.get(),
                        new SellingBinRecipe.RecipeInput(List.of(event.getItemStack())),
                        level
                ).ifPresent(recipe -> {
                    event.getTooltipElements().add(Either.right(new SellingBinTooltipComponent(recipe.input, recipe.output)));
                });
            }
        }
    }
}