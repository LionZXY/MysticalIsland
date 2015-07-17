package com.lionzxy.mysticalislands.gun;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by lionzxy on 16.07.15.
 */
public class ContainerGun extends Container{
    private static final int
            /*Наш инвентарь идет так:
                     0  1  2
            3  4  5  6  7  8  9  10 11
            12 13 14 15 16 17 18 19 20
            21 22 23 24 25 26 27 28 29
            __________________________
            30 31 32 33 34 35 36 37 38
            */
            INV_START = 3,
            INV_END = 29,
            HOTBAR_START =30,
            HOTBAR_END = 38;


    public ContainerGun(EntityPlayer player,ItemStack itemStack){

        //Gun inventory
        for (int i = 0; i < InventoryGun.INV_SIZE; ++i) {
            this.addSlotToContainer(new Slot(new InventoryGun(itemStack),i,81+i*18,29));;
        }

        //Main inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 9 + j * 18, 78 + i * 18));
            }
        }

        //Player Hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player.inventory, i, 9 + i * 18, 136));
        }

    }
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return player.inventory.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int numSlot) {
        ItemStack itemstack = null;
        Slot slot =(Slot) this.inventorySlots.get(numSlot);
        System.out.println(numSlot);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (numSlot < INV_START) {
                //Move item from gun inventory to inventory
                if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END+1, true)) {

                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else {
                if (numSlot >= INV_START && numSlot <= INV_END) {
                                        /* Item in Player Inventory, move to the gun inventory */
                    System.out.println("Item in Player Inventory, move to the gun inventory ");
                    if (!this.mergeItemStack(itemstack1, 0, 2, false)) {
                        return null;
                    }
                }
                                /* Item in the Hot Bar, move it to Player Inventory */
                else if (numSlot >= HOTBAR_START && numSlot < HOTBAR_END + 1) {
                    System.out.println("Item in the Hot Bar, move it to Player Inventory ");
                    if (!this.mergeItemStack(itemstack1, INV_START, INV_END, false)) {
                        return null;
                    }
                }
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
/*
   protected boolean mergeItemStack(ItemStack itemStack, int startInvSlot, int endInvSlot, boolean p_75135_4_)
    {
        boolean flag1 = false;
        int k = startInvSlot;

        if (p_75135_4_)
        {
            k = endInvSlot - 1;
        }

        Slot slot;
        ItemStack itemstack1;

        if (itemStack.isStackable())
        {
            while (itemStack.stackSize > 0 && (!p_75135_4_ && k < endInvSlot || p_75135_4_ && k >= startInvSlot))
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (itemstack1 != null && itemstack1.getItem() == itemStack.getItem() && (!itemStack.getHasSubtypes() || itemStack.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(itemStack, itemstack1))
                {
                    int l = itemstack1.stackSize + itemStack.stackSize;

                    if (l <= itemStack.getMaxStackSize())
                    {
                        itemStack.stackSize = 0;
                        itemstack1.stackSize = l;
                        slot.onSlotChanged();
                        flag1 = true;
                    }
                    else if (itemstack1.stackSize < itemStack.getMaxStackSize())
                    {
                        itemStack.stackSize -= itemStack.getMaxStackSize() - itemstack1.stackSize;
                        itemstack1.stackSize = itemStack.getMaxStackSize();
                        slot.onSlotChanged();
                        flag1 = true;
                    }
                }

                if (p_75135_4_)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }

        if (itemStack.stackSize > 0)
        {
            if (p_75135_4_)
            {
                k = endInvSlot - 1;
            }
            else
            {
                k = startInvSlot;
            }

            while (!p_75135_4_ && k < endInvSlot || p_75135_4_ && k >= startInvSlot)
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();

                if (itemstack1 == null)
                {
                    slot.putStack(itemStack.copy());
                    slot.onSlotChanged();
                    itemStack.stackSize = 0;
                    flag1 = true;
                    break;
                }

                if (p_75135_4_)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }

        return flag1;
    }*/

    /*@Override
    public ItemStack slotClick(int slot, int button, int flag, EntityPlayer player) {
        // This will prevent the player from interacting with the item that opened the inventory:
        if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem()) {
            return null;
        }
        return super.slotClick(slot, button, flag, player);}*/
}