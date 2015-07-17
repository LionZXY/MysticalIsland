package com.lionzxy.mysticalislands;

import com.lionzxy.mysticalislands.gun.Gun;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

/**
 * Created by lionzxy on 16.07.15.
 */
public class MysticalIslandsItems {
    public static Item testGun;
    public static void allLoad(){
        createItem();
        registerItems();
    }
    public static void createItem(){
        testGun = new Gun();
    }
    public static void registerItems(){
        GameRegistry.registerItem(testGun,"testgun");
    }

}
