package com.irar.mores.arrow;

import java.util.Random;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;

public class ArrowTeleport extends IArrowAction{

	public ArrowTeleport(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity entity, ActionType type) {
		if(arrow.isDead) {
			return;
		}
		Random r = new Random();
		double x = arrow.posX;
		double y = arrow.posY;
		double z = arrow.posZ;
        for (int i = 0; i < 32; ++i)
        {
        	arrow.world.spawnParticle(EnumParticleTypes.PORTAL, arrow.shootingEntity.posX, arrow.shootingEntity.posY + r.nextDouble() * 2.0D, arrow.shootingEntity.posZ, r.nextGaussian(), 0.0D, r.nextGaussian());
        }
		arrow.shootingEntity.setPositionAndUpdate(x, y, z);
        for (int i = 0; i < 32; ++i)
        {
        	arrow.world.spawnParticle(EnumParticleTypes.PORTAL, arrow.shootingEntity.posX, arrow.shootingEntity.posY + r.nextDouble() * 2.0D, arrow.shootingEntity.posZ, r.nextGaussian(), 0.0D, r.nextGaussian());
        }
		arrow.setDead();
	}

	@Override
	public String getDisplayName() {
		return "Ender";
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.WORLD};
	}
	
	@Override
	public int getLevel(int num) {
		return 0;
	}

}
