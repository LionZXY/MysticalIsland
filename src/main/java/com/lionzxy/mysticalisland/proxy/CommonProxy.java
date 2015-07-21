package com.lionzxy.mysticalisland.proxy;

import com.lionzxy.mysticalisland.MysticalIsland;
import com.lionzxy.mysticalisland.MysticalIslandGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * Created by lionzxy on 18.07.15.
 */
public class CommonProxy {
    public void registerRender(){

    }
    public void registerProxies(){
        NetworkRegistry.INSTANCE.registerGuiHandler(MysticalIsland.instance, new MysticalIslandGuiHandler());
    }
}
