package com.lionzxy.mysticalisland;

import com.lionzxy.mysticalisland.client.gui.GuiGun;
import com.lionzxy.mysticalisland.common.container.ContainerGun;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MysticalIslandGuiHandler implements IGuiHandler {
    public static final int GUN = 1;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch(id) {
            case GUN:
                return new ContainerGun(player, player.inventory, player.inventory.getStackInSlot(x));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        Object server = getServerGuiElement(id, player, world, x, y, z);
        switch(id) {
            case GUN:
                return new GuiGun((ContainerGun) server);
            default:
                return null;
        }
    }
}
