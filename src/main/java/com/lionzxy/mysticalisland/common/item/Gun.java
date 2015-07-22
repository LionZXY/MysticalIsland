package com.lionzxy.mysticalisland.common.item;

import com.lionzxy.mysticalisland.*;
import com.lionzxy.mysticalisland.common.container.ContainerGun;
import com.lionzxy.mysticalisland.common.entity.EntityGun;
import com.lionzxy.mysticalisland.common.inventory.InventoryGun;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
    public String name;//Ready
    public String textureName;//Ready
    public Item itemNeed;//Ready
    public boolean isDamage;//Ready
    public int damage;//Ready
    public int idGuiGun;

    public Gun(){
        super();
        setValue();
        this.setCreativeTab(MysticalIslandTab.tabGeneral);
        this.setUnlocalizedName(name);
        this.setTextureName(MysticalIslandVersion.MODID + ":gun/" + textureName);
        this.setMaxStackSize(1);
        this.setMaxDamage(21);


    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player){
        if (!world.isRemote && player.isSneaking()) player.openGui(MysticalIsland.instance, idGuiGun, world, player.inventory.currentItem, 0, 0);
        if (!world.isRemote && Shot(player))
        {
            world.playSound(player.posX, player.posY, player.posZ, MysticalIslandVersion.MODID+":flint", 15.0F, 15F, false);
            world.spawnEntityInWorld(new EntityGun(world, player, damage));
        }
        return item;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {   switch(idGuiGun){
        case 1: {
        list.add("Damage: "+MysticalIslandConfig.getDamageGun("flintGun"));
        if(stack.hasTagCompound()){
            list.add("Request: Flint("+getItem(0,stack)+"), GunPowder("+getItem(1,stack)+"), Flint And Steel("+getItem(2,stack)+")");
        }else{
            list.add("Open gui in Shift+Click");
        }
            list.add("Shot on click");
        break;}
        }

    }

    public static InventoryGun getInventory(ItemStack gun,EntityPlayer player) {
        return new InventoryGun(gun,player);
    }
    String getItem(int i,ItemStack stack) {
        if (checkNotNull(i, stack)) {
            switch (i) {
                case 0:
                    if (ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i)).getItem() == Items.flint) {
                        return "" + ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i)).stackSize;
                    } else {
                        return null;
                    }
                case 1:
                    if (ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i)).getItem() == Items.gunpowder) {
                        return "" + ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i)).stackSize;
                    } else {
                        return null;
                    }
                case 2:
                    if (ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i)).getItem() == Items.flint_and_steel) {
                        return "" + ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i)).getItemDamage();
                    } else {
                        return null;
                    }
            }
        } else {
            return null;
        }
    return null;
    }
    boolean checkNotNull(int i,ItemStack stack){
        return ItemStack.loadItemStackFromNBT(stack.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i))!=null;
    }
    public boolean Shot(EntityPlayer player){
        if(player.inventory.getCurrentItem().hasTagCompound()){
        ItemStack currentItem = player.inventory.getCurrentItem();
        NBTTagList items = player.inventory.getCurrentItem().getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND);
        if(!isDamage){
           if(currentItem.hasTagCompound()&&
           checkNotNull(0,currentItem)&&
           checkNotNull(1,currentItem)&&
           checkNotNull(2,currentItem)){
           if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).getItem()==Items.flint&&
           ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).getItem()==Items.gunpowder&&
           ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItem()==Items.flint_and_steel){
           writeToNBT(currentItem.getTagCompound(),new ItemStack[]{
                   ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).splitStack(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).stackSize-1),
                   ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).splitStack(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).stackSize-1),
                   new ItemStack(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItem(),1,ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItemDamage()+1)
                   });
           return true;
        }}}
        else{if(currentItem.getItemDamage()<20){currentItem.damageItem(1, player);return true;}else{
            if(currentItem.hasTagCompound()&&
                    checkNotNull(0,currentItem)&&
                    checkNotNull(1,currentItem)&&
                    checkNotNull(2,currentItem)){
                if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).getItem()== MysticalIslandItems.bullet[0]&&
                        ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).getItem()==Items.gunpowder&&
                        ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItem()==Items.flint_and_steel){
                    writeToNBT(currentItem.getTagCompound(),new ItemStack[]{
                            ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).splitStack(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).stackSize-1),
                            ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).splitStack(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).stackSize-1),
                            new ItemStack(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItem(),1,ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItemDamage()+1)
                    });
                    currentItem.damageItem(-20,player);
                    return true;
        }}}}}
      return false;}

    public void writeToNBT(NBTTagCompound tagcompound,ItemStack[] inventory) {

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
    }
    public void setValue(){

    }}
