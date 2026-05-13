package com.list.item;

import com.list.util.ColorSpaceUtil;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * 果冻物品 - 使用双层图层模型 (A+B模式)
 * <p>
 * 基础层A: jelly_base.png (不需要调色)
 * 覆盖层B: jelly.png (需要调色，tintIndex=1)
 * <p>
 * 调色思路：按灰度明度做分层上色，色相基准遵循 XYZ 色彩空间原理。
 * 运行时仍然是单层 tint 色值；真正的明度层次由灰度纹理自身提供。
 */
public class JellyItem extends Item {

    /** 所有 JellyItem 实例列表，用于自动注册颜色处理器 */
    public static final List<JellyItem> JELLY_ITEMS = new ArrayList<>();

    public final int jellyColor;

    public JellyItem(Properties properties, int jellyColor) {
        super(properties);
        this.jellyColor = jellyColor;
        JELLY_ITEMS.add(this);
    }

    /**
     * 获取指定图层的颜色
     * @param tintIndex 图层索引 (0=基础层不变色, 1=覆盖层调色)
     * @return ARGB颜色值（仅覆盖层 tintIndex=1 参与调色）
     */
    public int getColor(int tintIndex) {
        if (tintIndex == 1) {
            return ColorSpaceUtil.normalizeOpaque(jellyColor);
        }
        return 0xFFFFFFFF;
    }

}

