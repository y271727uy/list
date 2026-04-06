package com.list.client;

import com.list.ListMod;
import com.list.all.ModRecipes;
import com.list.fish_group.FishGroupRegistry;
import com.list.fish_group.client.model.entity.FloatingBooksModel;
import com.list.fish_group.client.model.entity.FloatingDebrisModel;
import com.list.fish_group.client.model.entity.OceanFishPoolModel;
import com.list.fish_group.client.model.entity.RiverFishPoolModel;
import com.list.fish_group.client.renderer.entity.FloatingBooksRenderer;
import com.list.fish_group.client.renderer.entity.FloatingDebrisRenderer;
import com.list.fish_group.client.renderer.entity.OceanFishPoolRenderer;
import com.list.fish_group.client.renderer.entity.RiverFishPoolRenderer;
import com.list.integration.jei.tooltip.SellingBinClientTooltipComponent;
import com.list.integration.jei.tooltip.SellingBinTooltipComponent;
import com.list.item.EggItem;
import com.list.recipe.SellingBinRecipe;
import com.mojang.datafixers.util.Either;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FishingRodItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
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
            event.enqueueWork(() -> ItemProperties.register(
                    FishGroupRegistry.BAMBOO_FISHING_ROD.get(),
                    ListMod.rl("cast"),
                    (stack, level, entity, seed) -> {
                        if (!(entity instanceof Player player)) {
                            return 0.0F;
                        }

                        boolean mainHand = player.getMainHandItem() == stack;
                        boolean offHand = player.getOffhandItem() == stack;
                        if (player.getMainHandItem().getItem() instanceof FishingRodItem) {
                            offHand = false;
                        }

                        return (mainHand || offHand) && player.fishing != null ? 1.0F : 0.0F;
                    }
            ));
        }

        @SubscribeEvent
        public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(FishGroupRegistry.FLOATING_DEBRIS.get(), FloatingDebrisRenderer::new);
            event.registerEntityRenderer(FishGroupRegistry.FLOATING_BOOKS.get(), FloatingBooksRenderer::new);
            event.registerEntityRenderer(FishGroupRegistry.RIVER_FISH_POOL.get(), RiverFishPoolRenderer::new);
            event.registerEntityRenderer(FishGroupRegistry.OCEAN_FISH_POOL.get(), OceanFishPoolRenderer::new);
        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(FloatingDebrisModel.LAYER_LOCATION, FloatingDebrisModel::getTexturedModelData);
            event.registerLayerDefinition(FloatingBooksModel.LAYER_LOCATION, FloatingBooksModel::getTexturedModelData);
            event.registerLayerDefinition(RiverFishPoolModel.LAYER_LOCATION, RiverFishPoolModel::getTexturedModelData);
            event.registerLayerDefinition(OceanFishPoolModel.LAYER_LOCATION, OceanFishPoolModel::getTexturedModelData);
        }

        @SubscribeEvent
        public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
            for (EggItem eggItem : EggItem.EGG_ITEMS) {
                event.register((stack, tintIndex) -> eggItem.getColor(tintIndex), eggItem);
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
                ).ifPresent(recipe -> event.getTooltipElements().add(
                        Either.right(new SellingBinTooltipComponent(recipe.input, recipe.output))
                ));
            }
        }
    }
}