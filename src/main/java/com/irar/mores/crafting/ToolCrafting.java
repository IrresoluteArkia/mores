package com.irar.mores.crafting;

import java.util.ArrayList;
import java.util.List;

import com.irar.mores.Ref;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.items.AlloyArmor;
import com.irar.mores.items.AlloyArrow;
import com.irar.mores.items.AlloyBow;
import com.irar.mores.items.AlloyIngot;
import com.irar.mores.items.AlloyPickaxe;
import com.irar.mores.items.AlloySword;
import com.irar.mores.items.AlloyTool;
import com.irar.mores.items.ItemIngot;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ToolCrafting implements IRecipe{

	private static int ID = 0;
	
	private final int id;
	private final int[] alloys;
	private final int[] sticks;
	private Integer[] air;
	private static final int[] slots = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
	private Item result;
	
	public ToolCrafting(int[] alloys, int[] sticks, Item result) {
		this.id = ID++;
		this.alloys = alloys;
		this.sticks = sticks;
		this.result = result;
		List<Integer> air = new ArrayList<>();
		for(int i : slots) {
			if(!(contains(alloys, i) || contains(sticks, i))) {
				air.add(i);
			}
		}
		this.air = air.toArray(new Integer[0]);
	}
	
	private boolean contains(int[] alloys, int num) {
		for(int i : alloys) {
			if(i == num) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		int num = 0;
		if(!(inv.getStackInSlot(alloys[0]).getItem() instanceof AlloyIngot)) {
			return false;
		}
		int targetValue = getValue(inv.getStackInSlot(alloys[0]));
		for(int i : alloys) {
			if(!(inv.getStackInSlot(i).getItem() instanceof AlloyIngot && getValue(inv.getStackInSlot(i)) == targetValue)) {
				return false;
			}
		}
		for(int i : sticks) {
			if(result instanceof AlloyBow) {
				if(!inv.getStackInSlot(i).getItem().equals(Items.STRING)) {
					return false;
				}
			}else {
				if(!inv.getStackInSlot(i).getItem().equals(Items.STICK)) {
					return false;
				}
			}
		}
		for(int i : air) {
			if(!inv.getStackInSlot(i).isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack stack = inv.getStackInSlot(alloys[0]);
		int value = getValue(stack);
		if(result instanceof AlloyTool) {
			return AlloyTool.withValue((AlloyTool) result, value);
		}else if(result instanceof AlloySword) {
			return AlloySword.withValue((AlloySword) result, value);
		}else if(result instanceof AlloyBow) {
			return AlloyBow.withValue(value);
		}else if(result instanceof AlloyArmor) {
			return AlloyArmor.withValue((AlloyArmor) result, value);
		}else if(result instanceof AlloyArrow) {
			return AlloyArrow.withValue(value);
		}else {
			return ItemStack.EMPTY;
		}
	}

	private int getValue(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			return stack.getTagCompound().getInteger("INGOT_DATA");
		}
		return -1;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width == 3 && height == 3;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(result);
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		return this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return new ResourceLocation(Ref.MODID, "alloy_tool_crafting" + id);
	}

	@Override
	public Class<IRecipe> getRegistryType() {
		return IRecipe.class;
	}

}
