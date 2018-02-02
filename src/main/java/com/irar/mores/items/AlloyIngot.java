package com.irar.mores.items;

import java.awt.Color;
import java.util.Random;

import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scala.Char;

public class AlloyIngot extends ItemIngot implements IItemColor{

	public AlloyIngot(String name) {
		super(name);
	}

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
        return tintIndex > 0 ? -1 : getColor(stack);
	}

	public static int getColor(ItemStack stack) {
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
			String name = AlloyName.getRandomName(r) + " Ingot";
			return name;
		}
		return "Alloy Ingot";
	}

	public static ItemStack withValue(int value) {
		ItemStack stack = new ItemStack(ItemHandler.AlloyIngot);
		NBTTagCompound tag = stack.serializeNBT();
		tag.setInteger("INGOT_DATA", value);
		stack.setTagCompound(tag);
		return stack;
	}

}
