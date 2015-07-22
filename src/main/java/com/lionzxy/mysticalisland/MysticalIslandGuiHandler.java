package com.lionzxy.mysticalisland;

import com.lionzxy.mysticalisland.client.gui.GuiGun;
import com.lionzxy.mysticalisland.common.container.ContainerGun;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MysticalIslandGuiHandler implements IGuiHandler {
    public static final int FLINT_GUN = 1;
    public static final int PISTON_GUN = 2;

    public static ResourceLocation textureLocationFlintGun;
    public static ResourceLocation textureLocationPistonGun;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch(id) {
            case FLINT_GUN:
                return new ContainerGun(player, player.inventory, player.inventory.getStackInSlot(x));
            case PISTON_GUN:
                return new ContainerGun(player, player.inventory, player.inventory.getStackInSlot(x));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        Object server = getServerGuiElement(id, player, world, x, y, z);
        switch(id) {
            case FLINT_GUN:
                return new GuiGun((ContainerGun) server,textureLocationFlintGun);
            case PISTON_GUN:
                return new GuiGun((ContainerGun) server,textureLocationPistonGun);
            default:
                return null;
        }
    }
}
