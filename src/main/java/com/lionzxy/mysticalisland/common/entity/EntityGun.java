package com.lionzxy.mysticalisland.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * Created by lionzxy on 18.07.15.
 */
public class EntityGun extends EntityThrowable
{
    int valueDamage;

    public EntityGun (World par1World, EntityLivingBase par2EntityLiving,
                            ItemStack itemStack)
    {
        super(par1World, par2EntityLiving);
        double f1 = par1World.isRemote ? 0.06 : 0.3;

    }

    public EntityGun (World par1World, EntityLivingBase par2EntityLivingBase, int valueDamage)
    {
        super(par1World, par2EntityLivingBase);
        this.valueDamage=valueDamage;
    }

    public EntityGun (World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    protected float getGravityVelocity() {
        return 0.0F;
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
    	/*if (par1MovingObjectPosition.entityHit != null)
        {
           byte b0 = 0;
            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
            {
                b0 = 0;
            }
            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
        }
        for (int i = 0; i < 0; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }*/
        if (par1MovingObjectPosition.entityHit != null) {

            par1MovingObjectPosition.entityHit.attackEntityFrom(
                    DamageSource.causeThrownDamage(this, this.getThrower()), valueDamage);
        }

        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }
}
