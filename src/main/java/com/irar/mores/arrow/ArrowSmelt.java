package com.irar.mores.arrow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.util.ActionType;
import com.irar.mores.util.IArrowAction;
import com.irar.mores.util.MathHelper;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ArrowSmelt extends IArrowAction{

	public ArrowSmelt(String name) {
		super(name);
	}

	@Override
	public void apply(EntityAlloyArrow arrow, Entity entity, ActionType type) {
		int level = this.getLevel(arrow);
		
		HashMap<BlockPos, IBlockState> blocks = new HashMap<>();
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		HashMap<ItemStack, ItemStack> blockrecipes = new HashMap<>();
		
		World world = arrow.world;
		
		double x = arrow.posX;
		double y = arrow.posY;
		double z = arrow.posZ;
		
		world.addWeatherEffect(new EntityLightningBolt(world, x, y, z, false));

		for(int lev = 1; lev <= level; lev++) {
			for(int i = 0; i < 100; i++) {
				BlockPos pos = arrow.getPosition();
				int xSkew = MathHelper.getSkewedRandom() * lev;
				int zSkew = MathHelper.getSkewedRandom() * lev;
				int tx = pos.getX() + xSkew;
				int ty = pos.getY();
				int tz = pos.getZ() + zSkew;
				int yRange = Math.abs(xSkew) + Math.abs(zSkew);
				for(int j = ty - yRange; j <= ty + yRange; j++) {
					BlockPos smeltPos = new BlockPos(tx, j, tz);
					Block block = world.getBlockState(smeltPos).getBlock();
					if(!block.equals(Blocks.AIR)) {
						blocks.put(smeltPos, world.getBlockState(smeltPos));
					}
				}
			}
		}

		recipes.forEach((in, out) -> {
			Item item1 = in.getItem();
			Item item2 = out.getItem();
			
			if(item1 instanceof ItemBlock && item2 instanceof ItemBlock) {
				blockrecipes.put(in, out);
			}
		});

		blocks.forEach((pos, state) -> {
			boolean hasOut = false;
			IBlockState out = null;
			for(ItemStack stack : blockrecipes.keySet()) {
				ItemBlock ib = (ItemBlock) stack.getItem();
				IBlockState bState = ib.getBlock().getStateFromMeta(stack.getMetadata());
				if(state.getBlock().equals(bState.getBlock())) {
					hasOut = true;
					out = ((ItemBlock) blockrecipes.get(stack).getItem()).getBlock().getStateFromMeta(blockrecipes.get(stack).getMetadata());
					break;
				}
			}
			if(hasOut) {
				world.setBlockState(pos, out);
			}
		});
		arrow.setDead();
	}

	@Override
	public String getDisplayName() {
		return "Electric";
	}

	@Override
	public ActionType[] getActionTypes() {
		return new ActionType[] {ActionType.WORLD, ActionType.ENTITY};
	}

}
