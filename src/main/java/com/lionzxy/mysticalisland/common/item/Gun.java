package com.lionzxy.mysticalisland.common.item;

import com.lionzxy.mysticalisland.MysticalIsland;
import com.lionzxy.mysticalisland.MysticalIslandGuiHandler;
import com.lionzxy.mysticalisland.MysticalIslandVersion;
import com.lionzxy.mysticalisland.common.entity.EntityGun;
import com.lionzxy.mysticalisland.common.inventory.InventoryGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.List;

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
        this.setMaxStackSize(1);
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        if (!world.isRemote && player.isSneaking()) player.openGui(MysticalIsland.instance, MysticalIslandGuiHandler.GUN, world, player.inventory.currentItem, 0, 0);
        if (!world.isRemote && Shot(player))
        {

            //world.playSound(player.posX, player.posY, player.posZ, MysticalIslandVersion.MODID+":flint", 15.0F, 15F, false);
            world.spawnEntityInWorld(new EntityGun(world, player,1));
        }
        return item;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        //list.add("Flint Gun");
    }
    public static InventoryGun getInventory(ItemStack gun) {
        return new InventoryGun(gun);
    }
    public static boolean Shot(EntityPlayer player){
        ItemStack currentItem = player.getCurrentEquippedItem();
        NBTTagList items = player.getCurrentEquippedItem().getTagCompound().getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
        if(currentItem.hasTagCompound()){
            // TO DO
            System.out.println("Item has NBT");

            System.out.println("Display name 0 slot: "+ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)));
        }
      // return false;
        return true;}
}
