package com.lionzxy.mysticalisland.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import org.lwjgl.Sys;

/**
 * Created by lionzxy on 16.07.15.
 */
public class InventoryGun implements IInventory {

        /**
         * Defining your inventory size this way is handy
         */
        public static final int INV_SIZE = 3;

        /**
         * Inventory's size must be same as number of slots you add to the Container class
         */
        private ItemStack[] inventory = new ItemStack[INV_SIZE];

        /**
         * Provides NBT Tag Compound to reference
         */
        private ItemStack invItem;

        public InventoryGun(ItemStack stack) {
            this.invItem = stack;
            // Just in case the itemstack doesn't yet have an NBT Tag Compound:
            if (!stack.hasTagCompound()) {
                stack.setTagCompound(new NBTTagCompound());
            }
            // note that it's okay to use stack instead of invItem right there
            // both reference the same memory location, so whatever you change using
            // either reference will change in the other

            // Read the inventory contents from NBT
            readFromNBT(stack.getTagCompound());

        }

        public ItemStack getInvItem() {
            return invItem;
        }

        @Override
        public int getSizeInventory() {
            return inventory.length;
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
            return inventory[slot];
        }

        @Override
        public ItemStack decrStackSize(int slot, int amount) {
            ItemStack stack = getStackInSlot(slot);
            if (stack != null) {
                if (stack.stackSize > amount) {
                    stack = stack.splitStack(amount);
                    markDirty();
                } else {
                    System.out.println("ELSE!");
                    setInventorySlotContents(slot, null);
                }
            }
            return stack;
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot) {
            ItemStack stack = getStackInSlot(slot);
            return stack;
        }

        @Override
        public void setInventorySlotContents(int slot, ItemStack itemStack) {
            this.inventory[slot] = itemStack;

            if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
                itemStack.stackSize = this.getInventoryStackLimit();
            }
            markDirty();
        }

        @Override
        public String getInventoryName() {
            return "Bag Inventory";
        }

        @Override
        public boolean hasCustomInventoryName() {
            return false;
        }

        @Override
        public int getInventoryStackLimit() {
            return 1024;
        }

        @Override
        public void markDirty() {
            for (int i = 0; i < getSizeInventory(); i++) {
                if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
                    inventory[i] = null;
            }

            writeToNBT(invItem.getTagCompound());

        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer player) {
            return true;
        }

        @Override
        public void openInventory() {

        }

        @Override
        public void closeInventory() {
            writeToNBT(invItem.getTagCompound());
            System.out.println(invItem.getTagCompound());
        }

        @Override
        public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
            return true;
        }

        /**
         * A custom method to read our inventory from an ItemStack's NBT compound
         */
        public void readFromNBT(NBTTagCompound tagcompound) {
            // Gets the custom taglist we wrote to this compound.
//Не показывает (Пустое)
            NBTTagList items = tagcompound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);

            for (int i = 0; i < items.tagCount(); ++i) {
                NBTTagCompound item = /*(NBTTagCompound)*/ items.getCompoundTagAt(i);
                byte slot = item.getByte("Slot");

                // Just double-checking that the saved slot index is within our inventory array bounds
                if (slot >= 0 && slot < getSizeInventory()) {
                    inventory[slot] = ItemStack.loadItemStackFromNBT(item);
                }
            }
        }

        /**
         * A custom method to write our inventory to an ItemStack's NBT compound
         */
        public void writeToNBT(NBTTagCompound tagcompound) {

            NBTTagList nbttaglist = new NBTTagList();
            for(int i = 0; i < inventory.length; i++){
                if(inventory[i] != null){
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.setByte("Slot", (byte) i);
                    inventory[i].writeToNBT(nbttagcompound1);
                    nbttaglist.appendTag(nbttagcompound1);
                    tagcompound.setTag("Items", nbttaglist);
                }
            }
//Показывает
        }


}
