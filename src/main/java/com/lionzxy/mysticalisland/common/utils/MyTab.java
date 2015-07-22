package com.lionzxy.mysticalisland.common.utils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by lionzxy on 22.07.15.
 */
public class MyTab extends CreativeTabs {
    ItemStack item;

    public MyTab(String lable) {
        super(lable);
    }

    public void setTabIconItem(ItemStack item) {
        this.item = item;
    }

    @Override
    public Item getTabIconItem() {
        return item.getItem();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return item;
    }
}
