package com.lionzxy.mysticalisland.common.item;

import com.lionzxy.mysticalisland.MysticalIslandConfig;
import com.lionzxy.mysticalisland.MysticalIslandGuiHandler;
import com.lionzxy.mysticalisland.MysticalIslandItems;
import com.lionzxy.mysticalisland.MysticalIslandVersion;
import com.lionzxy.mysticalisland.common.item.libs.Gun;
import net.minecraft.util.ResourceLocation;

/**
 * Created by lionzxy on 22.07.15.
 */
public class PistonGun extends Gun {
    public PistonGun(){

    }
    @Override
    public void setValue(){
        this.name="pistonGun";
        this.textureName="pistongun";
        this.itemNeed=MysticalIslandItems.bullet[0];
        this.isDamage=true;
        this.damage=MysticalIslandConfig.getDamageGun("pistonDamage");
        this.idGuiGun=2;
        MysticalIslandGuiHandler.textureLocationPistonGun = new ResourceLocation(MysticalIslandVersion.MODID, "textures/gui/gunGui.png");
    }
}
