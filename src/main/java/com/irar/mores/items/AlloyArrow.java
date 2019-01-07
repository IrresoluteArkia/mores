package com.irar.mores.items;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import javax.swing.text.NumberFormatter;

import com.irar.mores.entity.EntityAlloyArrow;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.name.AlloyName;
import com.irar.mores.util.ArrowHelper;
import com.irar.mores.util.IArrowAction;
import com.irar.mores.util.MathHelper;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import scala.Char;

public class AlloyArrow extends ItemArrow implements IItemColor{

	public AlloyArrow(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@Override
    public void addInformation(ItemStack stack, World player, List<String> list, ITooltipFlag par4)
    {
		int level = this.getIngotData(stack);
		
		List<IArrowAction> actions = ArrowHelper.getArrowActionsForIngot(level);
		
		for(IArrowAction action : actions) {
			list.add(action.getDisplayName() + " " + MathHelper.getRomanNumber(action.getLevel(level)));
		}
		
		super.addInformation(stack, player, list, par4);
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
			String name = AlloyName.getRandomName(r) + " Arrow";
			return name;
		}
		return "Alloy Arrow";
	}

	public static ItemStack withValue(int value) {
		ItemStack stack = new ItemStack(ItemHandler.AlloyArrow, 32);
		NBTTagCompound tag = stack.serializeNBT();
		tag.setInteger("INGOT_DATA", value);
		stack.setTagCompound(tag);
		return stack;
	}
	
    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityTippedArrow entitytippedarrow = new EntityAlloyArrow(worldIn, shooter, this.getIngotData(stack));
        entitytippedarrow.setPotionEffect(stack);
        return entitytippedarrow;
    }

    private int getIngotData(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			return stack.getTagCompound().getInteger("INGOT_DATA");
		}
		return 0;
	}

	public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : true;
    }
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

}
