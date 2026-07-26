package com.list.item;

import com.list.all.ModItems;
import javax.annotation.Nonnull;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CanDrinkItem extends DrinkItem {
	public CanDrinkItem(Properties properties) {
		super(properties);
	}

	@Override
	protected ItemStack getFinishedContainerItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity livingEntity) {
		return new ItemStack(ModItems.CAN.get());
	}
}

