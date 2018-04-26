package com.irar.mores.arrow;

import java.util.ArrayList;
import java.util.List;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;
import com.irar.mores.util.WorldHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class ArrowSplit extends IArrowAction{

	public ArrowSplit(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity entity, ActionType type) {
		if(arrow.isDead) {
			return;
		}
		int level = this.getLevel(arrow);
		boolean isInRange = false;
//		Entity inRange = null;
		List<Entity> entities = arrow.world.loadedEntityList;
		List<EntityLivingBase> entitiesToHit = new ArrayList<>();
		for(Entity ent : entities) {
			double distance = WorldHelper.getDistance(arrow.world, arrow.shootingEntity, ent);
			if(ent instanceof EntityLivingBase && !ent.equals(arrow.shootingEntity)) {
				EntityLivingBase mob = (EntityLivingBase) ent;
/*				if(distance <= 2 * level) {
					inRange = mob;
				}
*/				if(distance <= level * 7) {
					isInRange = true;
					entitiesToHit.add(mob);
				}
			}
		}
		if(!isInRange) {
			return;
		}
		for(EntityLivingBase mob : entitiesToHit) {
			double y = arrow.posY;
			int increase = 0;
			while(increase < level * 2 && arrow.world.getBlockState(new BlockPos(arrow.posX, y + 1, arrow.posZ)).getBlock().equals(Blocks.AIR)) {
				y++;
				increase++;
			}
			arrow.setPositionAndUpdate(arrow.posX, y, arrow.posZ);
	        EntityTippedArrow subArrow = new EntityTippedArrow(arrow.world, arrow.posX, y, arrow.posZ);
/*	        float[] py = WorldHelper.getPitchAndYawTo(arrow, mob);
	        float pitch = py[0];
	        float yaw = py[1];*/
	        subArrow.setNoGravity(true);
//	        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
//	        float f1 = -MathHelper.sin(pitch * 0.017453292F);
//	        float f2 = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
//	        subArrow.setThrowableHeading((double)f, (double)f1, (double)f2, 0.01F, 0.0F);
//	        subArrow.setAim(subArrow, pitch, yaw, 0.0F, 0.01F, 0.0F);
	        subArrow.setThrowableHeading(mob.posX - subArrow.posX, mob.posY - subArrow.posY, mob.posZ - subArrow.posZ, level * 8.0F, 0.0F);
	        subArrow.setDamage((arrow.getDamage()) / MathHelper.sqrt(subArrow.motionX * subArrow.motionX + subArrow.motionY * subArrow.motionY + subArrow.motionZ * subArrow.motionZ));
	        subArrow.setKnockbackStrength(1);
	        if(arrow.isBurning()) {
	        	subArrow.setFire(100);
	        }
	        subArrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
	        arrow.world.spawnEntity(subArrow);
		}
		arrow.setDead();
	}

	@Override
	public String getDisplayName() {
		return "Arrow Rain";
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.DURINGFLIGHT};
	}

}
