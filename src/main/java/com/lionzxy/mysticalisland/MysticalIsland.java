package com.lionzxy.mysticalisland;

import com.lionzxy.mysticalisland.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by lionzxy on 16.07.15.
 */
@Mod(modid = MysticalIslandVersion.MODID,name= MysticalIslandVersion.NAME,version= MysticalIslandVersion.VERSION)
public class MysticalIsland {

    @SidedProxy(clientSide = "com.lionzxy.mysticalisland.proxy.ClientProxy",serverSide = "com.lionzxy.mysticalisland.proxy.CommonProxy")
    public static CommonProxy proxy;
    @Mod.Instance
    public static MysticalIsland instance;

    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event)
    {
        MysticalIslandItems.allLoad();
        proxy.registerProxies();
        proxy.registerRender();
    }
}
