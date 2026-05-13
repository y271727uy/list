package com.list.item;

import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 双层图层物品基类，支持每层独立调色
 * <p>
 * 模型结构: 基础层A (layer0) + 覆盖层B (layer1)
 * 调色: tintIndex=0 → 基础层A颜色, tintIndex=1 → 覆盖层B颜色
 * <p>
 * 用法示例:
 * <pre>
 * public static final ItemEntry&lt;LayeredItem&gt; MY_ITEM = REGISTRATE
 *     .item("my_item", p -> new LayeredItem(p, 0xFF0000, 0x00FF00))
 *     .model(ItemModelUtil::layeredItemModel)
 *     .register();
 * </pre>
 */
public class LayeredItem extends Item {

    /** 所有LayeredItem实例列表，用于自动注册颜色处理器 */
    public static final List<LayeredItem> LAYERED_ITEMS = new ArrayList<>();

    private final int baseColor;    // 基础层A颜色 (tintIndex=0)
    private final int overlayColor; // 覆盖层B颜色 (tintIndex=1)

    /**
     * @param properties   物品属性
     * @param baseColor    基础层A颜色 (ARGB格式, 如 0xFFFFFFFF)
     * @param overlayColor 覆盖层B颜色 (ARGB格式, 如 0xFFFFFFFF)
     */
    public LayeredItem(Properties properties, int baseColor, int overlayColor) {
        super(properties);
        this.baseColor = baseColor;
        this.overlayColor = overlayColor;
        LAYERED_ITEMS.add(this);
    }

    /**
     * 根据tintIndex获取对应层的颜色
     * @param tintIndex 图层索引 (0=基础层A, 1=覆盖层B)
     * @return ARGB颜色值
     */
    public int getColor(int tintIndex) {
        return switch (tintIndex) {
            case 0 -> baseColor;
            case 1 -> overlayColor;
            default -> 0xFFFFFFFF;
        };
    }

    public int getBaseColor() {
        return baseColor;
    }

    public int getOverlayColor() {
        return overlayColor;
    }
}
