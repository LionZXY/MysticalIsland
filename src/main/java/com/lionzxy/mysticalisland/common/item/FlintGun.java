package com.lionzxy.mysticalisland.common.item;


import com.lionzxy.mysticalisland.MysticalIslandConfig;
import com.lionzxy.mysticalisland.MysticalIslandGuiHandler;
import com.lionzxy.mysticalisland.MysticalIslandVersion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

/**
 * Created by lionzxy on 21.07.15.
 */
public class FlintGun extends Gun {
    public FlintGun(){

    }
    @Override
    public void setValue(){
        this.name="flintGun";
        this.textureName="flintgun";
        this.itemNeed=Items.flint;
        this.isDamage=false;
        this.damage=MysticalIslandConfig.getDamageGun("flintDamage");
        this.idGuiGun=1;
        MysticalIslandGuiHandler.textureLocationFlintGun=new ResourceLocation(MysticalIslandVersion.MODID, "textures/gui/gunGui.png");
    }
}
