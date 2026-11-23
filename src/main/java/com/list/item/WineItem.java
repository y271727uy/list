package com.list.item;

import java.util.ArrayList;
import java.util.List;

public class WineItem extends DrinkItem {
    public static final List<WineItem> WINE_ITEMS = new ArrayList<>();

    private final int wineColor;

    public WineItem(Properties properties, int wineColor) {
        super(properties);
        this.wineColor = wineColor;
        WINE_ITEMS.add(this);
    }

    public int getColor(int tintIndex) {
        return tintIndex == 1 ? wineColor : 0xFFFFFFFF;
    }
}
