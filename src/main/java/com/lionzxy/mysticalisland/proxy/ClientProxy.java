package com.lionzxy.mysticalisland.proxy;

import com.lionzxy.mysticalisland.MysticalIslandItems;
import com.lionzxy.mysticalisland.client.render.RenderFlintGun;
import com.lionzxy.mysticalisland.client.render.RenderPistonGun;
import com.lionzxy.mysticalisland.client.render.RenderRevolverGun;
import com.lionzxy.mysticalisland.client.render.RenderRifleGun;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by lionzxy on 18.07.15.
 */
public class ClientProxy extends CommonProxy{
    public void registerRender(){

        MinecraftForgeClient.registerItemRenderer(MysticalIslandItems.flintGun, new RenderFlintGun());
        MinecraftForgeClient.registerItemRenderer(MysticalIslandItems.pistonGun, new RenderPistonGun());
        MinecraftForgeClient.registerItemRenderer(MysticalIslandItems.revolverGun, new RenderRevolverGun());
       // MinecraftForgeClient.registerItemRenderer(MysticalIslandItems.rifleGun, new RenderRifleGun());
    }
    public void registerProxies(){
        super.registerProxies();
    }
}
