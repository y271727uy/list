package com.list.fish_group.util;

import com.list.ListMod;
import net.minecraft.resources.ResourceLocation;

public final class LilisLuckyLuresIdentifier {
    private LilisLuckyLuresIdentifier() {
    }

    public static ResourceLocation of(String path) {
        return ListMod.rl(path);
    }
}

