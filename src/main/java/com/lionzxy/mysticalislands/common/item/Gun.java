package com.lionzxy.mysticalislands.common.item;

import com.lionzxy.mysticalislands.client.gui.GuiGun;
import com.lionzxy.mysticalislands.common.container.ContainerGun;
import com.lionzxy.mysticalislands.common.entity.EntityGun;
import com.lionzxy.mysticalislands.common.inventory.InventoryGun;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
    if (player.isSneaking()) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiGun(new ContainerGun(player, player.inventory, new InventoryGun(item))));
    }if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityGun(world, player,7));
        }
        return item;
    }
}
