package com.irar.mores.arrow;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;
import com.irar.mores.util.MathHelper;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArrowFireBomb extends IArrowAction{

	public ArrowFireBomb(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity entity, ActionType type) {
		int level = getLevel(arrow);
		World world = arrow.world;
		for(int lev = 1; lev <= level; lev++) {
			for(int i = 0; i < 100; i++) {
				BlockPos pos = arrow.getPosition();
				int xSkew = MathHelper.getSkewedRandom() * lev;
				int zSkew = MathHelper.getSkewedRandom() * lev;
				int x = pos.getX() + xSkew;
				int y = pos.getY();
				int z = pos.getZ() + zSkew;
				int yRange = Math.abs(xSkew) + Math.abs(zSkew);
				for(int j = y - yRange; j <= y + yRange; j++) {
					BlockPos firePos = new BlockPos(x, j, z);
					Block block = world.getBlockState(firePos).getBlock();
					if(block.isReplaceable(world, firePos) || block.equals(Blocks.AIR)) {
						world.setBlockState(firePos, Blocks.FIRE.getDefaultState());
					}
				}
			}
		}
		arrow.setDead();
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.BOTH};
	}

	@Override
	public String getDisplayName() {
		return "Fire Bomb";
	}
	
}
