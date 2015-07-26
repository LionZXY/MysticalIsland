package com.lionzxy.mysticalisland.common.item;

import com.lionzxy.mysticalisland.MysticalIslandConfig;
import com.lionzxy.mysticalisland.MysticalIslandGuiHandler;
import com.lionzxy.mysticalisland.MysticalIslandItems;
import com.lionzxy.mysticalisland.MysticalIslandVersion;
import com.lionzxy.mysticalisland.common.item.libs.Gun;
import net.minecraft.util.ResourceLocation;

/**
 * Created by nikit_000 on 26.07.2015.
 */
public class RifleGun extends Gun {
    public RifleGun(){

    }
    @Override
    public void setValue(){
        this.name="rifleGun";
        this.textureName="riflegun";
        this.itemNeed= MysticalIslandItems.bullet[1];
        this.isDamage=false;
        this.damage= MysticalIslandConfig.getDamageGun("rifleDamage");
        this.idGuiGun=3;
        MysticalIslandGuiHandler.textureLocationRifleGun = new ResourceLocation(MysticalIslandVersion.MODID, "textures/gui/gunGui.png");
    }
}
