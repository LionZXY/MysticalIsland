package com.lionzxy.mysticalislands.client.models;

import com.lionzxy.mysticalislands.MysticalIslandsVersion;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

/**
 * Created by lionzxy on 20.07.15.
 */
public class RenderGun implements IItemRenderer {
    protected FlintGun model;
    public RenderGun(){
        model = new FlintGun();
    }
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch (type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                return true;
            default:return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type){
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
                float scale = 2F;
                GL11.glPushMatrix();
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glScalef(scale, scale, scale);
                GL11.glRotatef(220F, 0F, 0F, 0F);
                Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(MysticalIslandsVersion.MODID, "textures/models/flintGun.png"));
                model.render((Entity)data[1],0.0F,0.0F,0.0F,0.0F,0.0F,0.07F);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glPopMatrix();
        }
    }
}
