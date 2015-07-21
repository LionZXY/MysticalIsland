package com.lionzxy.mysticalisland.common.item;

import com.lionzxy.mysticalisland.MysticalIsland;
import com.lionzxy.mysticalisland.MysticalIslandGuiHandler;
import com.lionzxy.mysticalisland.common.entity.EntityGun;
import com.lionzxy.mysticalisland.common.inventory.InventoryGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by lionzxy on 16.07.15.
 */
public class Gun extends Item {
    String resourceLocation;
    public Gun(){
        super();
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("testgun");
        this.setTextureName("flintgun");
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        if (!world.isRemote && player.isSneaking()) player.openGui(MysticalIsland.instance, MysticalIslandGuiHandler.GUN, world, player.inventory.currentItem, 0, 0);
        if (!world.isRemote)
        {
            //world.playSound(player.posX, player.posY, player.posZ, "dig.stone", 1.0F, 0.6F, false);
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
