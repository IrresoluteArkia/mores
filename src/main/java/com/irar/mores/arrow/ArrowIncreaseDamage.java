package com.irar.mores.arrow;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class ArrowIncreaseDamage extends IArrowAction{

	public ArrowIncreaseDamage(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity target, ActionType type) {
		if(!(target instanceof EntityLivingBase)) {
			return;
		}
		int level = getLevel(arrow);
		EntityLivingBase mob = (EntityLivingBase) target;
		mob.attackEntityFrom(DamageSource.MAGIC, (float) Math.pow(level, 2));
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.ENTITY};
	}

	@Override
	public String getDisplayName() {
		return "Sharpness";
	}
	
}
