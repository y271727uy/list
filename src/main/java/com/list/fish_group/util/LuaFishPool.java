package com.list.fish_group.util;

import com.list.ListMod;
import net.minecraft.resources.ResourceLocation;

public final class LuaFishPool {
    private LuaFishPool() {
    }

    public static ResourceLocation of(String path) {
        return ListMod.rl(path);
    }
}

