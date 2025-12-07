package com.list.all;

import com.list.client.screen.FishPondScreen;
import com.list.menu.FishPondMenu;
import com.tterrag.registrate.util.entry.MenuEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraftforge.network.NetworkHooks;

import static com.list.ListMod.REGISTRATE;

public class ModMenus {
    @SuppressWarnings("DataFlowIssue")
    public static final MenuEntry<FishPondMenu> FISH_POND = REGISTRATE
        .menu("fish_pond", FishPondMenu::new, () -> FishPondScreen::new)
        .register();

    public static void open(ServerPlayer player, MenuProvider provider) {
        NetworkHooks.openScreen(player, provider);
    }

    public static void open(ServerPlayer player, MenuProvider provider, BlockPos pos) {
        NetworkHooks.openScreen(player, provider, pos);
    }

    public static void register() {
    }
}
