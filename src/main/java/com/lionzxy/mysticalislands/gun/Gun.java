package com.lionzxy.mysticalislands.gun;

import com.lionzxy.mysticalislands.MysticalIslandsVersion;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by lionzxy on 16.07.15.
 */
public class Gun extends Item {
    public Gun(){
        super();
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("testgun");

    }
    public ItemStack onItemRightClick(ItemStack item, World worldIn, EntityPlayer player)
    {
        Minecraft.getMinecraft().displayGuiScreen(new GuiGun(new ContainerGun(player,player.inventory,new InventoryGun(item))));
        return super.onItemRightClick(item,worldIn,player);
    }
}
