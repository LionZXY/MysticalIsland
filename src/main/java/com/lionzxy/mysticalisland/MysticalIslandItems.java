package com.lionzxy.mysticalisland;

import com.lionzxy.mysticalisland.common.item.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by lionzxy on 16.07.15.
 */
public class MysticalIslandItems {
    public static Item flintGun;
    public static Item pistonGun;
    public static Item rifleGun;
    public static Item revolverGun;
    public static Item[] bullet = new Item[4];
    public static void allLoad(){
        createItem();
        registerItems();
    }
    public static void createItem(){
        revolverGun = new RevolverGun();
        flintGun = new FlintGun();
        pistonGun = new PistonGun();
        //rifleGun = new RifleGun();
        for(int i=0;i<bullet.length;i++){
            bullet[i] = new Bullet().setTextureName(MysticalIslandVersion.MODID+":bullet/"+i).setUnlocalizedName("bullet"+i);
            GameRegistry.registerItem(bullet[i], "bullet"+i);
        }
    }
    public static void registerItems(){
        GameRegistry.registerItem(revolverGun,"revolverGun");
       // GameRegistry.registerItem(rifleGun, "rifleGun");
        GameRegistry.registerItem(flintGun,"flintGun");
        GameRegistry.registerItem(pistonGun,"pistonGun");
    }

}
