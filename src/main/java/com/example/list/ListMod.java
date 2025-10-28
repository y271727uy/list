package com.example.list;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.ChatFormatting;

@Mod(ListMod.MODID)
public class ListMod
{
    public static final String MODID = "list";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public ListMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // 注册物品
        ModItems.ITEMS.register(modEventBus);
        
        // 注册方块
        ModBlocks.BLOCKS.register(modEventBus);
        
        // 注册创造模式物品栏
        ModCreativeModeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        
        // 注册通用设置事件
        modEventBus.addListener(this::commonSetup);
        
        // 注册创造模式物品栏内容事件
        modEventBus.addListener(this::addCreative);
        
        // 注册服务器启动事件
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("List Mod initialized");
    }
    
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("List Mod setup complete");
    }
    
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.LIST_TAB.get()) {
            event.accept(ModItems.INDUSTRIAL_COPPER_CREDIT.get());
            event.accept(ModItems.INDUSTRIAL_SILVER_CREDIT.get());
            event.accept(ModItems.INDUSTRIAL_GOLD_CREDIT.get());
            event.accept(ModItems.INDUSTRIAL_PLATINUM_CREDIT.get());
            event.accept(ModItems.INDUSTRIAL_OSMIUM_CREDIT.get());
            event.accept(ModItems.JUST_BREAD.get());
            event.accept(ModItems.FISHPOND_CORE.get());
        }
    }
    
    @SubscribeEvent
    public void onItemTooltip(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() == ModItems.JUST_BREAD.get()) {
            event.getToolTip().add(Component.translatable("item.list.just_bread.desc.1").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.just_bread.desc.2").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
            event.getToolTip().add(Component.translatable("item.list.just_bread.desc.3").withStyle(style -> style.withColor(ChatFormatting.GRAY).withItalic(true)));
        }
    }
    
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("List Mod server starting");
    }
}