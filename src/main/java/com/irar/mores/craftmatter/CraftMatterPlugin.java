package com.irar.mores.craftmatter;

import java.util.Random;

import com.irar.craftmatter.api.CMPlugin;
import com.irar.craftmatter.api.ICustomValue;
import com.irar.craftmatter.api.ICustomValueRegistry;
import com.irar.craftmatter.api.IModPlugin;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@CMPlugin
public class CraftMatterPlugin implements IModPlugin{

	@Override
	public void registerCustomValues(ICustomValueRegistry registry) {
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 2;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyIngot);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyIngot;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") / 16;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyArrow);
			}

			@Override
			public Item getItemFor() {
				return ItemHandler.AlloyArrow;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 6 + 2;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyPickaxe);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyPickaxe;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 2 + 2;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyShovel);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyShovel;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 6 + 2;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyAxe);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyAxe;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 4 + 2;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloySword);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloySword;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 6 + 9;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyBow);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyBow;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 10;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyHelmet);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyHelmet;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 16;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyChestplate);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyChestplate;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 14;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyLeggings);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyLeggings;
			}
			
		});
		registry.register(new ICustomValue() {

			@Override
			public int getValueFor(ItemStack stack) {
				if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
					return stack.getTagCompound().getInteger("INGOT_DATA") * 8;
				}
				return 0;
			}

			@Override
			public boolean hasValueFor(ItemStack stack) {
				return stack.getItem().equals(ItemHandler.AlloyBoots);
			}

			@Override
			public Item getItemFor() {
				// TODO Auto-generated method stub
				return ItemHandler.AlloyBoots;
			}
			
		});
	}

}
