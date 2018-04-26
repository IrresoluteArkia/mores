package com.irar.mores.arrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;
import com.irar.mores.util.MathHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArrowChorus extends IArrowAction{

	public ArrowChorus(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity entity, ActionType type) {
		if(type.equals(ActionType.DURINGFLIGHT)) {
			arrow.setDamage(0);
			arrow.setKnockbackStrength(0);
			return;
		}
		Random r = new Random();
		int level = this.getLevel(arrow) * 3;
		List<double[]> possibleSpots = new ArrayList<>();
		World world = entity.world;
		double x = entity.posX;
		double y = entity.posY;
		double z = entity.posZ;
		for(int lev = 1; lev <= level; lev++) {
			for(int i = 0; i < 100; i++) {
				BlockPos pos = arrow.getPosition();
				int xSkew = MathHelper.getSkewedRandom() * lev;
				int zSkew = MathHelper.getSkewedRandom() * lev;
				double tx = x + xSkew;
				double ty = y;
				double tz = z + zSkew;
				int yRange = Math.abs(xSkew) + Math.abs(zSkew);
				for(int j = (int) (ty - yRange); j <= ty + yRange; j++) {
					BlockPos toPos = new BlockPos(tx, j, tz);
					Block block = world.getBlockState(toPos).getBlock();
					if(block.isReplaceable(world, toPos) || block.equals(Blocks.AIR)) {
						possibleSpots.add(new double[] {tx, j, tz});
					}
				}
			}
		}
		r.nextInt(1);
		double[] pos = possibleSpots.get(r.nextInt(possibleSpots.size()));
		entity.setPositionAndUpdate(pos[0], pos[1], pos[2]);
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.ENTITY, ActionType.DURINGFLIGHT};
	}

	@Override
	public String getDisplayName() {
		return "Chorus";
	}

}
