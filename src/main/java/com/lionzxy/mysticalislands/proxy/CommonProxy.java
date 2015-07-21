package com.lionzxy.mysticalislands.proxy;

import com.lionzxy.mysticalislands.MysticalIslands;
import com.lionzxy.mysticalislands.MysticalIslandsGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

/**
 * Created by lionzxy on 18.07.15.
 */
public class CommonProxy {
    public void registerRender(){

    }
    public void registerProxies(){
        NetworkRegistry.INSTANCE.registerGuiHandler(MysticalIslands.instance, new MysticalIslandsGuiHandler());
    }
}
