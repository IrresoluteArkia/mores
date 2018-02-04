package com.irar.mores.items;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import com.irar.mores.enchanting.EnchantmentSet;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.ToolMaterialHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import scala.Char;

public class AlloyArmor extends ItemArmor implements IItemColor{

	private String extra;
	
	public AlloyArmor(String name, EntityEquipmentSlot slot, String extra) {
		super(ToolMaterialHandler.AALLOY, 3, slot);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.extra = extra;
	}
	
	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        return tintIndex > 0 ? -1 : getCColor(stack);
	}

	@Override
	public int getColor(ItemStack stack) {
		return getCColor(stack);
	}
	
	public static int getCColor(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			Random r = new Random(stack.getTagCompound().getInteger("INGOT_DATA") + toInt("color"));
			Color c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			return c.getRGB();
		}
		return 0;
	}
	
	private static int toInt(String s) {
		int ret = 0;
		for(char c : s.toCharArray()) {
			ret += Char.char2int(c);
		}
		return ret;
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			Random r = new Random(stack.getTagCompound().getInteger("INGOT_DATA") + toInt("name"));
			String name = AlloyName.getRandomName(r) + " " + extra;
			return name;
		}
		return "Alloy " + extra;
	}

	public static ItemStack withValue(AlloyArmor item, int value) {
		ItemStack stack = new ItemStack(item);
		NBTTagCompound tag = stack.serializeNBT();
		tag.setInteger("INGOT_DATA", value);
		stack.setTagCompound(tag);
		enchant(stack);
		return stack;
	}
	
    private static void enchant(ItemStack stack) {
		EnchantmentSet enchants = new EnchantmentSet(stack);
		enchants.enchant(stack);
	}
	
	/**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	if(toRepair.getItem() instanceof AlloyArmor && repair.getItem() instanceof AlloyIngot && toRepair.hasTagCompound() && toRepair.getTagCompound().hasKey("INGOT_DATA")) {
    		if(repair.hasTagCompound() && repair.getTagCompound().hasKey("INGOT_DATA")) {
    			if(toRepair.getTagCompound().getInteger("INGOT_DATA") == repair.getTagCompound().getInteger("INGOT_DATA")) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    @Override
    public boolean hasOverlay(ItemStack stack)
    {
        return true;
    }
    
    @Override
    public int getMaxDamage(ItemStack stack)
    {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("damage"));
			return Math.max(10, (num * 10) + r.nextInt(200) - 100);
		}
		return 1;
    }


}
