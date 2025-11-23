package com.list.block.entity;

import com.list.all.ModMenus;
import com.list.all.ModRecipes;
import com.list.menu.FishPondMenu;
import com.list.recipe.FishPondRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;

public class FishPondCoreBlockEntity extends BlockEntity implements MenuProvider {
    private ResourceLocation runningRecipe = null;
    private FishPondRecipe runningRecipeCache = null;
    private int progress = 0;

    // 0-8 input, 9-11 output
    public final ItemStackHandler itemHandler = new ItemStackHandler(12) {
        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            if (slot >= 14) {
                return stack;
            }
            return super.insertItem(slot, stack, simulate);
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (runningRecipe == null || runningRecipeCache == null) {
                findRecipe();
            }
        }
    };

    public final LazyOptional<IItemHandler> handlerOptional = LazyOptional.of(() -> itemHandler);

    public FishPondCoreBlockEntity(BlockEntityType<FishPondCoreBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return handlerOptional.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.list.fishpond_core");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new FishPondMenu(ModMenus.FISH_POND.get(), id, inventory, this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Inventory", itemHandler.serializeNBT());
        if (runningRecipe != null) {
            tag.putString("RunningRecipe", runningRecipe.toString());
        }
        tag.putInt("Progress", progress);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Inventory")) {
            itemHandler.deserializeNBT(tag.getCompound("Inventory"));
        }
        if (tag.contains("RunningRecipe")) {
            runningRecipe = new ResourceLocation(tag.getString("RunningRecipe"));
            level.getRecipeManager().byKey(runningRecipe).ifPresent(recipe -> {
                runningRecipeCache = (FishPondRecipe) recipe;
            });
        } else {
            tag.remove("RunningRecipe");
        }
        progress = tag.getInt("Progress");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag);
        return tag;
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if (runningRecipe != null && runningRecipeCache != null) {
            if (progress >= runningRecipeCache.time) {
                // Insert outputs
                for (ItemStack output : runningRecipeCache.results) {
                    for (int i = 9; ; i++) {
                        ItemStack remaining = itemHandler.insertItem(i, output.copy(), true);
                        if (remaining.isEmpty()) {
                            break;
                        }
                        if (i == 11) {
                            return;
                        }
                    }
                }

                // Actually insert outputs
                for (ItemStack output : runningRecipeCache.results) {
                    for (int i = 9; i < 12; i++) {
                        ItemStack remaining = itemHandler.insertItem(i, output.copy(), false);
                        if (remaining.isEmpty()) {
                            break;
                        }
                    }
                }

                runningRecipe = null;
                runningRecipeCache = null;
                progress = 0;
                findRecipe();
            }
            progress++;
            setChanged();
        }
    }

    private void findRecipe() {
        ArrayList<ItemStack> inputs = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            inputs.add(itemHandler.getStackInSlot(i));
        }
        level.getRecipeManager().getRecipeFor(
            ModRecipes.FISH_POND_RECIPE_TYPE.get(),
            new FishPondRecipe.RecipeInput(inputs),
            level
        ).ifPresent(recipe -> {
            runningRecipe = recipe.getId();
            runningRecipeCache = recipe;
            progress = 0;
            setChanged();
            consumeRecipeInputs();
        });
    }

    private void consumeRecipeInputs() {
        if (runningRecipe == null) {
            return;
        }
        for (Ingredient ingredient : runningRecipeCache.ingredients) {
            for (int i = 0; i < 9; i++) {
                ItemStack stackInSlot = itemHandler.getStackInSlot(i);
                if (ingredient.test(stackInSlot)) {
                    itemHandler.extractItem(i, 1, false);
                    break;
                }
            }
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        handlerOptional.invalidate();
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            ItemStack itemstack = itemHandler.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                Block.popResource(level, worldPosition, itemstack);
            }
        }
    }
}
