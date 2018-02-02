package com.irar.mores.items;

import java.awt.Color;
import java.util.Random;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.ToolMaterialHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scala.Char;

public class AlloyPickaxe extends AlloyTool{

	public AlloyPickaxe(String name) {
		super(name, "pickaxe");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return super.getItemStackDisplayName(stack) + " Pickaxe";
	}
    
    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getStrVsBlock(stack, state) : getEfficiency(stack);
    }

}
