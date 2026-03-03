package com.list.menu;

import com.list.all.ModBlocks;
import com.list.block.entity.ForestryGreenhouseBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nullable;

/**
 * Minimal menu for Forestry Greenhouse.
 *
 * Currently provides only the player inventory/hotbar; add TE slots when gameplay is implemented.
 */
public class ForestryGreenhouseMenu extends AbstractContainerMenu {
    private final Level level;
    private final ForestryGreenhouseBlockEntity blockEntity;

    public ForestryGreenhouseMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory, FriendlyByteBuf buf) {
        this(menuType, containerId, inventory, inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public ForestryGreenhouseMenu(@Nullable MenuType<?> menuType, int containerId, Inventory inventory, BlockEntity be) {
        super(menuType, containerId);
        this.blockEntity = (ForestryGreenhouseBlockEntity) be;
        this.level = inventory.player.level();

        // TE input slots (0-8) at the provided coordinates
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 0, 14, 29));
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 1, 14, 47));
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 2, 14, 65));

        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 3, 32, 29));
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 4, 32, 47));
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 5, 32, 65));

        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 6, 50, 29));
            this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 7, 50, 47));
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 8, 50, 65));

            // extra independent input slots (9-11)
            this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 9, 50, 86));
            this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 10, 70, 86));
            this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 11, 90, 86));

        addPlayerInventory(inventory);
        addPlayerHotbar(inventory);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 123 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 181));
        }
    }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        // No TE slots yet, so nothing special to shift-click.
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            return ItemStack.EMPTY;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()), player, ModBlocks.FORESTRY_GREENHOUSE.get());
    }
}

