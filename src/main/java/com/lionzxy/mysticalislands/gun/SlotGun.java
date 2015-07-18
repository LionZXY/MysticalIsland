package com.lionzxy.mysticalislands.gun;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by lionzxy on 18.07.15.
 */
public class SlotGun extends Slot {
    public SlotGun(IInventory inventory, int slotIndex, int x, int y) {
        super(inventory, slotIndex, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return false;
    }
}
