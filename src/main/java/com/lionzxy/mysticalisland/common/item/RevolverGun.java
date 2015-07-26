package com.lionzxy.mysticalisland.common.item;

import com.lionzxy.mysticalisland.*;
import com.lionzxy.mysticalisland.common.container.ContainerGun;
import com.lionzxy.mysticalisland.common.entity.EntityGun;
import com.lionzxy.mysticalisland.common.inventory.InventoryGun;
import com.lionzxy.mysticalisland.common.inventory.InventoryRevolver;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.List;

/**
 * Created by lionzxy on 16.07.15.
 */
public class RevolverGun extends Item {
    public String name;//Ready
    public String textureName;//Ready
    public Item itemNeed;//Ready
    public Item itemNeed2=Items.gunpowder;
    public boolean isDamage;//Ready
    public int damage;//Ready
    public int idGuiGun;

    public RevolverGun(){
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
        if (!world.isRemote && shot(player))
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



    public static InventoryRevolver getInventory(ItemStack gun,EntityPlayer player) {
        return new InventoryRevolver(gun,player);
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
    public boolean shot(EntityPlayer player){
        if(player.inventory.getCurrentItem().hasTagCompound()){
            ItemStack currentItem = player.inventory.getCurrentItem();
            NBTTagList items = player.inventory.getCurrentItem().getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND);
            for(int i = 0; i < 6; i++){
                if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(i))!= null){
                    if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(i)).getItem()== MysticalIslandItems.bullet[3]){
                        writeToNBT(currentItem.getTagCompound(),generateItemStackArr(currentItem.getTagCompound(),i));
                        return true;
                    }
                }else return false;}
                    }
        return false;}

    public ItemStack[] generateItemStackArr (NBTTagCompound tagcompound,int slot){
        ItemStack[] items = new ItemStack[6];
        for(int i = 0; i<items.length; i++){
            items[i]=ItemStack.loadItemStackFromNBT(tagcompound.getTagList("Items", Constants.NBT.TAG_COMPOUND).getCompoundTagAt(i));
        }
        items[slot]=null;

        return items;
    }
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
        this.name="revolverGun";
        this.textureName="revolvergun";
        this.itemNeed=MysticalIslandItems.bullet[2];
        this.isDamage=true;
        this.damage=MysticalIslandConfig.getDamageGun("revolverDamage");
        this.idGuiGun=4;
        MysticalIslandGuiHandler.textureLocationRevolverGun = new ResourceLocation(MysticalIslandVersion.MODID, "textures/gui/gunRevolverGui.png");

    }
    public boolean check(Item item1,Item item2,NBTTagList items){
        if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(0)).getItem()!= item1)return false;
        if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(1)).getItem()!= item2)return false;
        if(ItemStack.loadItemStackFromNBT(items.getCompoundTagAt(2)).getItem()!=Items.flint_and_steel)return false;
        return true;
    }}
