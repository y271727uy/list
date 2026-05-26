package com.list.menu;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.SmokerMenu;
import net.minecraft.world.Container;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.inventory.MenuType;
import javax.annotation.Nullable;

public class FishSmokerMenu extends SmokerMenu {
    public FishSmokerMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()) instanceof Container container ? container : new net.minecraft.world.SimpleContainer(3), new SimpleContainerData(4));
    }

    public FishSmokerMenu(int containerId, Inventory inventory, Container container, ContainerData data) {
        super(containerId, inventory, container, data);
    }
}






