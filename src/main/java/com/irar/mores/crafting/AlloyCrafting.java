package com.irar.mores.crafting;

import com.irar.mores.Ref;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.items.AlloyIngot;
import com.irar.mores.items.ItemIngot;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class AlloyCrafting implements IRecipe{

	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		int num = 0;
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack.getItem() instanceof ItemIngot) {
				if(stack.getItem() instanceof AlloyIngot && stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					num++;
				}else {
					if(((ItemIngot) stack.getItem()).value == 0) {
						return false;
					}
					num++;
				}
			}else if(!stack.isEmpty()){
				return false;
			}
		}
		return num == 2;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		int value = 0;
		for(int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if(stack.getItem() instanceof ItemIngot) {
				if(stack.getItem() instanceof AlloyIngot && stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					value += stack.getTagCompound().getInteger("INGOT_DATA");
				}else {
					value += ((ItemIngot) stack.getItem()).value;
				}
			}
		}
		return AlloyIngot.withValue(value);
	}

	@Override
	public boolean canFit(int width, int height) {
		return true;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return new ItemStack(ItemHandler.AlloyIngot);
	}

	@Override
	public IRecipe setRegistryName(ResourceLocation name) {
		return this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return new ResourceLocation(Ref.MODID, "alloy_crafting");
	}

	@Override
	public Class<IRecipe> getRegistryType() {
		// TODO Auto-generated method stub
		return IRecipe.class;
	}

}
