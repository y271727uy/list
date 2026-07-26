package com.list.item;

import javax.annotation.Nonnull;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NoneDrink extends DrinkItem {
    public NoneDrink(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemStack getFinishedContainerItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity livingEntity) {
        return ItemStack.EMPTY;
    }
}
