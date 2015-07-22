package com.lionzxy.mysticalisland;

import com.lionzxy.mysticalisland.common.utils.MyTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by lionzxy on 22.07.15.
 */
public class MysticalIslandTab {
        public static final CreativeTabs tabGeneral = new MyTab("tabGeneral");
        public static void postInit() {
            ((MyTab) tabGeneral).setTabIconItem(new ItemStack(Items.arrow));
        }
}
