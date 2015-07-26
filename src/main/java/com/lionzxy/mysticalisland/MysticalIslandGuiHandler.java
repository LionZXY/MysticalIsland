package com.lionzxy.mysticalisland;

import com.lionzxy.mysticalisland.client.gui.GuiGun;
import com.lionzxy.mysticalisland.client.gui.RevolverGui;
import com.lionzxy.mysticalisland.common.container.ContainerGun;
import com.lionzxy.mysticalisland.common.container.RevolverContainer;
import com.lionzxy.mysticalisland.common.item.RevolverGun;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MysticalIslandGuiHandler implements IGuiHandler {
    public static final int FLINT_GUN = 1;
    public static final int PISTON_GUN = 2;
    public static final int RIFLE_GUN=3;
    public static final int REVOLVER_GUN=4;

    public static ResourceLocation textureLocationFlintGun;
    public static ResourceLocation textureLocationPistonGun;
    public static ResourceLocation textureLocationRifleGun;
    public static ResourceLocation textureLocationRevolverGun;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        switch(id) {
            case FLINT_GUN:
                return new ContainerGun(player, player.inventory, player.inventory.getStackInSlot(x));
            case PISTON_GUN:
                return new ContainerGun(player, player.inventory, player.inventory.getStackInSlot(x));
            case RIFLE_GUN:
                return new ContainerGun(player, player.inventory, player.inventory.getStackInSlot(x));
            case REVOLVER_GUN:
                return new RevolverContainer(player, player.inventory, player.inventory.getStackInSlot(x));
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
            case RIFLE_GUN:
                return new GuiGun((ContainerGun) server,textureLocationPistonGun);
            case REVOLVER_GUN:
                return new RevolverGui((RevolverContainer) server,textureLocationRevolverGun);
            default:
                return null;
        }
    }
}
