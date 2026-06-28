package com.list.item.util;

import com.list.ListMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 烟熏鱼物品。
 * <p>
 * 结构：
 * - layer0: 鱼底图，使用 tintIndex=0 进行 RGB 调色
 * - layer1: 烟雾层，可由注册时指定
 */
@SuppressWarnings("unused")
public class SmokerFish extends Item {

    public static final List<SmokerFish> SMOKER_FISH_ITEMS = new ArrayList<>();

    private final int fishColor;
    private final SmokeVariant smokeVariant;
    private final ResourceLocation smokeTexture;

    public SmokerFish(Properties properties, int fishColor, SmokeVariant smokeVariant) {
        this(properties, fishColor, smokeVariant, smokeVariant.textureLocation());
    }

    public SmokerFish(Properties properties, int fishColor, ResourceLocation smokeTexture) {
        this(properties, fishColor, SmokeVariant.CUSTOM, smokeTexture);
    }

    private SmokerFish(Properties properties, int fishColor, SmokeVariant smokeVariant, ResourceLocation smokeTexture) {
        super(properties);
        this.fishColor = fishColor;
        this.smokeVariant = smokeVariant;
        this.smokeTexture = smokeTexture;
        SMOKER_FISH_ITEMS.add(this);
    }

    public int getColor(int tintIndex) {
        if (tintIndex == 0) {
            return fishColor;
        }
        return 0xFFFFFFFF;
    }

    public int getFishColor() {
        return fishColor;
    }

    public SmokeVariant getSmokeVariant() {
        return smokeVariant;
    }

    public ResourceLocation getSmokeTexture() {
        return smokeTexture;
    }

    public static List<SmokerFish> getSmokerFishItems() {
        return SMOKER_FISH_ITEMS;
    }


    public enum SmokeVariant {
        LARGE("smoke_large"),
        LITE("smoke_lite"),
        CUSTOM("custom");

        private final String textureName;

        SmokeVariant(String textureName) {
            this.textureName = textureName;
        }

        public ResourceLocation textureLocation() {
            if (this == CUSTOM) {
                return ListMod.rl("item/food/component/custom");
            }
            return ListMod.rl("item/food/component/" + textureName);
        }
    }
}


