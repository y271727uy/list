package com.list;

import com.list.all.ModBlockEntities;
import com.list.all.ModBlocks;
import com.list.all.ModCreativeModeTabs;
import com.list.all.ModItems;
import com.list.all.ModMenus;
import com.list.all.ModRecipes;
import com.list.data.ModDataGen;
import com.list.network.ModMessages;
import com.tterrag.registrate.Registrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

@Mod(ListMod.MODID)
public class ListMod
{
    public static final String MODID = "list";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Registrate REGISTRATE = Registrate.create(MODID);
    
    public ListMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register();
        ModBlocks.register();
        ModBlockEntities.register();
        ModCreativeModeTabs.register(modEventBus);
        ModMenus.register();
        ModRecipes.register(modEventBus);
        
        // 注册通用设置事件
        modEventBus.addListener(this::commonSetup);
        
        // 注册服务器启动事件
        MinecraftForge.EVENT_BUS.register(this);

        //我不到啊，我和ai还有mcreator一起拉了泡大的
        
        LOGGER.info("List Mod initialized");

        ModDataGen.init();
    }
    
    private void commonSetup(final FMLCommonSetupEvent event) {
        ModMessages.register();
        LOGGER.info("List Mod setup complete");
    }
    
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() == ModItems.JUST_BREAD.get()) {
            event.getToolTip().add(Component.translatable("item.list.just_bread.desc.1").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.just_bread.desc.2").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.just_bread.desc.3").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
        } else if (event.getItemStack().getItem() == ModItems.FARMERS_RANCH_STAR.get()) {
            event.getToolTip().add(Component.translatable("item.list.farmers_ranch_star.desc.1").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.farmers_ranch_star.desc.2").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
        } else if (event.getItemStack().getItem() == ModItems.BAD_ITEM.get()) {
            event.getToolTip().add(Component.translatable("item.list.bad_item.desc").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
        } else if (event.getItemStack().getItem() == ModItems.EUASTACUS_ARMATUS.get()) {
            event.getToolTip().add(Component.translatable("item.list.euastacus_armatus.desc").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
        } else if (event.getItemStack().getItem() == ModItems.TASMANIAN_GIANT_FRESHWATER_CRAYFISH.get()) {
            event.getToolTip().add(Component.translatable("item.list.tasmanian_giant_freshwater_crayfish.desc.1").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.tasmanian_giant_freshwater_crayfish.desc.2").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.tasmanian_giant_freshwater_crayfish.desc.3").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.tasmanian_giant_freshwater_crayfish.desc.4").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));




            
        } else if (event.getItemStack().getItem() == ModItems.BAD_ITEM.get()) {
            event.getToolTip().add(Component.translatable("item.list.bad_item.desc").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
        }      
    }
    
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("List Mod server starting");
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }
}