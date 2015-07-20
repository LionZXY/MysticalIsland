package com.lionzxy.mysticalislands;

import com.lionzxy.mysticalislands.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by lionzxy on 16.07.15.
 */
@Mod(modid = MysticalIslandsVersion.MODID,name=MysticalIslandsVersion.NAME,version=MysticalIslandsVersion.VERSION)
public class MysticalIslands {

    @SidedProxy(clientSide = "com.lionzxy.mysticalislands.proxy.ClientProxy",serverSide = "com.lionzxy.mysticalislands.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        MysticalIslandsItems.allLoad();
        proxy.registerProxies();
        proxy.registerRender();
    }
}
