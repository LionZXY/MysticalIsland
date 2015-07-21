package com.lionzxy.mysticalisland.client.render;

import com.lionzxy.mysticalisland.MysticalIslandVersion;
import com.lionzxy.mysticalisland.client.models.FlintGun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
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
        float scale = 0.8F;
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glScalef(scale, scale, scale);
        switch (type) {
            case EQUIPPED_FIRST_PERSON:
                GL11.glRotatef(180F, 2F, 1F, 0F);
                GL11.glTranslatef(1F, 1F, 0F);
                break;
            case EQUIPPED:
                GL11.glRotatef(360F, -0.4F, 3F, 0F);
                GL11.glTranslatef(0.1F, 0.1F, 0F);
                break;

        }
        Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(MysticalIslandVersion.MODID, "textures/models/flintGun.png"));
        model.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.07F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }}
