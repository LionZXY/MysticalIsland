package com.lionzxy.mysticalisland.common.utils;

import com.lionzxy.mysticalisland.MysticalIsland;
import com.lionzxy.mysticalisland.MysticalIslandItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by nikit_000 on 26.07.2015.
 */
public class GunSlot extends Slot {
    public GunSlot(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_) {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }
    @Override
    public boolean isItemValid(ItemStack itemStack) {
        if(itemStack.getItem()== MysticalIslandItems.bullet[3])return true;
        return false;
    }
}
