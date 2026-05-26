package com.list.all;

import com.list.client.screen.ForestryHybridizerScreen;
import com.list.client.screen.ForestryGreenhouseScreen;
import com.list.client.screen.FishPondScreen;
import com.list.menu.ForestryGreenhouseMenu;
import com.list.menu.ForestryHybridizerMenu;
import com.list.menu.FishPondMenu;
import net.minecraft.client.gui.screens.inventory.SmokerScreen;
import com.tterrag.registrate.util.entry.MenuEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraftforge.network.NetworkHooks;

import static com.list.ListMod.REGISTRATE;

public class ModMenus {
    @SuppressWarnings({"DataFlowIssue", "unused"})
    public static final MenuEntry<SmokerMenu> FISH_SMOKER = REGISTRATE
        .menu("fish_smoker", (menuType, containerId, inventory, buf) -> new SmokerMenu(
                containerId,
                inventory,
                inventory.player.level().getBlockEntity(buf.readBlockPos()) instanceof Container container ? container : new SimpleContainer(3),
                new SimpleContainerData(4)
            ),
            () -> SmokerScreen::new)
        .register();

    @SuppressWarnings("DataFlowIssue")
    public static final MenuEntry<FishPondMenu> FISH_POND = REGISTRATE
        .menu("fish_pond", FishPondMenu::new, () -> FishPondScreen::new)
        .register();

    @SuppressWarnings("DataFlowIssue")
    public static final MenuEntry<ForestryHybridizerMenu> FORESTRY_HYBRIDIZER = REGISTRATE
        .menu("forestry_hybridizer", ForestryHybridizerMenu::new, () -> ForestryHybridizerScreen::new)
        .register();

    @SuppressWarnings("DataFlowIssue")
    public static final MenuEntry<ForestryGreenhouseMenu> FORESTRY_GREENHOUSE = REGISTRATE
        .menu("forestry_greenhouse", ForestryGreenhouseMenu::new, () -> ForestryGreenhouseScreen::new)
        .register();

    @SuppressWarnings("unused")
    public static void open(ServerPlayer player, MenuProvider provider) {
        NetworkHooks.openScreen(player, provider);
    }

    @SuppressWarnings("unused")
    public static void open(ServerPlayer player, MenuProvider provider, BlockPos pos) {
        NetworkHooks.openScreen(player, provider, pos);
    }

    public static void register() {
    }
}
