package com.irar.mores.arrow;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ArrowExplode extends IArrowAction{

	public ArrowExplode(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity entity, ActionType type) {
		World world = arrow.world;
		double x = entity.posX;
		double y = entity.posY;
		double z = entity.posZ;
		world.createExplosion(entity, x, y, z, getLevel(arrow), true);
		arrow.setDead();
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.BOTH};
	}

	@Override
	public String getDisplayName() {
		return "Exploding";
	}
}
