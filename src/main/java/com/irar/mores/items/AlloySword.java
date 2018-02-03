package com.irar.mores.items;

import java.awt.Color;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.irar.mores.enchanting.EnchantmentSet;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.ToolMaterialHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Char;

public class AlloySword extends ItemSword implements IItemColor{

	public AlloySword(String name) {
		super(ToolMaterialHandler.ALLOY);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
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
			String name = AlloyName.getRandomName(r) + " Sword";
			return name;
		}
		return "Alloy Sword";
	}

	public static ItemStack withValue(AlloySword item, int value) {
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
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return 10;
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	if(toRepair.hasTagCompound() && toRepair.getTagCompound().hasKey("INGOT_DATA")) {
    		if(repair.hasTagCompound() && repair.getTagCompound().hasKey("INGOT_DATA")) {
    			if(toRepair.getTagCompound().getInteger("INGOT_DATA") == repair.getTagCompound().getInteger("INGOT_DATA")) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state) {
    	return super.getStrVsBlock(stack, state);
    }

	@Override
	public int getMaxDamage(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("damage"));
			return Math.max(10, (num * 10) + r.nextInt(200) - 100);
		}
		return 1;
	}
	
	@Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack stack)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", getDamageVsEntity(stack)  * 3.0F, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)getAttackSpeed(stack), 0));
        }

        return multimap;
    }

	private double getAttackSpeed(ItemStack stack) {
		//TODO: optimize this
		/*if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("attackspeed"));
			num = Math.max(num, 1);
			double value = 1.0D;
			double rand = r.nextDouble();
			value = value + (rand - rand / 2);
			value = value / r.nextInt((int) Math.pow(num, 1.0 / 4.0));
			return value;
		}
		return 1.0D;*/
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("efficiency"));
			return (float) ((1.0F * Math.log(num)) * (r.nextFloat()) - 3 - r.nextFloat());
		}
		return 1.0F;
	}

	private double getDamageVsEntity(ItemStack stack) {
		//TODO: optimize this
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("attackdamage"));
			num = Math.max(num, 1);
			int temp = (int) Math.pow(num, 1.0 / 4.0);
			double value = 1.0D;
			double rand = r.nextDouble();
			value = value * r.nextInt(temp);
			value = value + ((rand - rand / 2) * temp);
			return value;
		}
		return 1.0D;
	}

    public float getDamageVsEntity()
    {
        return this.getDamageVsEntity() * 3.0F;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(1, attacker);
        return true;
    }

    /**
     * Called when a Block is destroyed using this Item. Return true to trigger the "Use Item" statistic.
     */
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        if ((double)state.getBlockHardness(worldIn, pos) != 0.0D)
        {
            stack.damageItem(2, entityLiving);
        }

        return true;
    }

    /**
     * Check whether this Item can harvest the given Block
     */
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return blockIn.getBlock() == Blocks.WEB;
    }


}
