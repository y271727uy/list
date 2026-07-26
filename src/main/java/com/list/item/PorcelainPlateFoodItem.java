package com.list.item;

import com.list.all.ModItems;
import javax.annotation.Nonnull;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PorcelainPlateFoodItem extends Item {
	public PorcelainPlateFoodItem(Properties properties) {
		super(properties);
	}

	@Override
	public @Nonnull ItemStack finishUsingItem(@Nonnull ItemStack stack, @Nonnull Level level, @Nonnull LivingEntity livingEntity) {
		ItemStack result = super.finishUsingItem(stack, level, livingEntity);
		ItemStack plate = new ItemStack(ModItems.PORCELAIN_PLATE.get());

		if (livingEntity instanceof Player player && player.getAbilities().instabuild) {
			return result;
		}

		if (result.isEmpty()) {
			return plate;
		}

		if (livingEntity instanceof Player player) {
			if (!player.getInventory().add(plate)) {
				player.drop(plate, false);
			}
		} else {
			livingEntity.spawnAtLocation(plate);
		}

		return result;
	}
}
