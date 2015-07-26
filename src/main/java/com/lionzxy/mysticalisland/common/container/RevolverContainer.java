package com.lionzxy.mysticalisland.common.container;

import com.lionzxy.mysticalisland.common.inventory.InventoryRevolver;
import com.lionzxy.mysticalisland.common.item.RevolverGun;
import com.lionzxy.mysticalisland.common.utils.GunSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class RevolverContainer extends Container {

    private final InventoryRevolver inventory;
    private int currentSlot;

    public RevolverContainer(EntityPlayer player, InventoryPlayer inventoryPlayer, ItemStack gun) {
        this.inventory = RevolverGun.getInventory(inventoryPlayer.getCurrentItem(), player);
        this.currentSlot = inventoryPlayer.currentItem;

        int i;

                /* Gun Inventoty */

            this.addSlotToContainer(new GunSlot(this.inventory, 0, 57, 20));
            this.addSlotToContainer(new GunSlot(this.inventory, 1, 81, 10));
            this.addSlotToContainer(new GunSlot(this.inventory, 2, 105, 20));
            this.addSlotToContainer(new GunSlot(this.inventory, 3, 105, 45));
            this.addSlotToContainer(new GunSlot(this.inventory, 4, 81, 55));
            this.addSlotToContainer(new GunSlot(this.inventory, 5, 57, 45));

                /* Player Main Inventory */
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 9 + j * 18, 88 + i * 18));
            }
        }

                /* Player Hotbar */
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 9 + i * 18, 146));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return inventory.isUseableByPlayer(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     * Only real change we make to this is to set needsUpdate to true at the end.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotID) {
        ItemStack stack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotID);

        if (slot != null && slot.getHasStack())
        {
            ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();

            if (slotID < inventory.getSizeInventory())
            {
                if (!this.mergeItemStack(slotStack, inventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(slotStack, 0, inventory.getSizeInventory(), false))
            {
                return null;
            }

            if (slotStack.stackSize == 0)
            {
                slot.putStack((ItemStack) null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return stack;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        inventory.closeInventory();
        super.onContainerClosed(player);
    }

    /**
     * NOTE: The following is necessary if you want to prevent the player from moving the item while the
     * inventory is open; if you don't and the player moves the item, the inventory will not be able to save properly
     */
    @Override
    public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
        // This will prevent the player from interacting with the item that opened the inventory:
        if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
            return null;
        }
        return super.slotClick(slot, button, flag, player);
    }
}
