package com.lionzxy.mysticalislands.proxy;

import com.lionzxy.mysticalislands.MysticalIslandsItems;
import com.lionzxy.mysticalislands.client.models.RenderGun;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by lionzxy on 18.07.15.
 */
public class ClientProxy extends CommonProxy{
    public void registerRender(){

       MinecraftForgeClient.registerItemRenderer(MysticalIslandsItems.testGun, new RenderGun());
    }
    public void registerProxies(){

    }
}
