package com.lionzxy.mysticalislands.common.item;

import com.lionzxy.mysticalislands.MysticalIslands;
import com.lionzxy.mysticalislands.MysticalIslandsGuiHandler;
import com.lionzxy.mysticalislands.MysticalIslandsVersion;
import com.lionzxy.mysticalislands.client.gui.GuiGun;
import com.lionzxy.mysticalislands.common.container.ContainerGun;
import com.lionzxy.mysticalislands.common.entity.EntityGun;
import com.lionzxy.mysticalislands.common.inventory.InventoryGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.Resource;

/**
 * Created by lionzxy on 16.07.15.
 */
public class Gun extends Item {
    String resourceLocation;
    public Gun(){
        super();
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("testgun");
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        if (!world.isRemote && player.isSneaking()) player.openGui(MysticalIslands.instance, MysticalIslandsGuiHandler.GUN, world, player.inventory.currentItem, 0, 0);
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityGun(world, player,7));
        }
        return item;
    }
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }

    public static InventoryGun getInventory(ItemStack gun) {
        return new InventoryGun(gun);
    }
}
