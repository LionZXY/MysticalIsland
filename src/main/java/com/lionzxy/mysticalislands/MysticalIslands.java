package com.lionzxy.mysticalislands;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by lionzxy on 16.07.15.
 */
@Mod(modid = MysticalIslandsVersion.MODID,name=MysticalIslandsVersion.NAME,version=MysticalIslandsVersion.VERSION)
public class MysticalIslands {

    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        MysticalIslandsItems.allLoad();
    }
}
