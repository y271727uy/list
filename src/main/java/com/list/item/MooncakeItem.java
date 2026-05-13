package com.list.item;

import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 月饼物品 - 使用双层图层模型 (A+B模式)
 * <p>
 * 基础层A: mooncake_base.png (月饼皮，不需要调色)
 * 覆盖层B: mooncake_filling.png (月饼馅，需要调色，tintIndex=1)
 * <p>
 * 纹理路径约定:
 * - 基础层: item/food/mooncake/mooncake_base (所有月饼共用)
 * - 覆盖层: item/food/mooncake/{mooncake_name}_filling (每种月饼独立)
 */
public class MooncakeItem extends Item {

    /** 所有MooncakeItem实例列表，用于自动注册颜色处理器 */
    public static final List<MooncakeItem> MOONCAKE_ITEMS = new ArrayList<>();

    private final int fillingColor; // 月饼馅颜色 (tintIndex=1)

    /**
     * @param properties    物品属性
     * @param fillingColor  月饼馅颜色 (ARGB格式，如 0xFFD700)
     */
    public MooncakeItem(Properties properties, int fillingColor) {
        super(properties);
        this.fillingColor = fillingColor;
        MOONCAKE_ITEMS.add(this);
    }

    /**
     * 获取指定图层的颜色
     * @param tintIndex 图层索引 (0=基础层不变色, 1=覆盖层/馅料调色)
     * @return ARGB颜色值
     */
    public int getColor(int tintIndex) {
        if (tintIndex == 1) {
            return 0xFF000000 | (fillingColor & 0x00FFFFFF);
        }
        return 0xFFFFFFFF; // 基础层不调色
    }

    public int getFillingColor() {
        return fillingColor;
    }
}
