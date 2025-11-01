package com.list;

import com.list.world.inventory.FishpondcoreMenu;
import com.list.ListMod;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public class ModMenus {
    public static final DeferredRegister<MenuType<?>> MENUS = 
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, ListMod.MODID);

    public static final RegistryObject<MenuType<FishpondcoreMenu>> FISHPONDCORE = 
            MENUS.register("fishpondcore", () -> IForgeMenuType.create(FishpondcoreMenu::new));
    
    public interface MenuAccessor {
        Map<Integer, net.minecraft.world.inventory.Slot> getSlots();
        Map<String, Object> getMenuState();
    }
}