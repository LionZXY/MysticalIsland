package com.lionzxy.mysticalisland.proxy;

import com.lionzxy.mysticalisland.MysticalIslandItems;
import com.lionzxy.mysticalisland.client.render.RenderGun;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by lionzxy on 18.07.15.
 */
public class ClientProxy extends CommonProxy{
    public void registerRender(){

       MinecraftForgeClient.registerItemRenderer(MysticalIslandItems.testGun, new RenderGun());

    }
    public void registerProxies(){
        super.registerProxies();
    }
}
