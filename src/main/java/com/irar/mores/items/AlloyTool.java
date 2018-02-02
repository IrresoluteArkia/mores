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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import scala.Char;

public abstract class AlloyTool extends ItemTool implements IItemColor{

	private String toolType;

	protected AlloyTool(String name, String tooltype) {
		super(1, 1, ToolMaterialHandler.ALLOY, Sets.newHashSet());
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.toolType = tooltype;
	}
	
    @Override
    public Set<String> getToolClasses(ItemStack stack){
    	return ImmutableSet.<String>of(toolType);
    };

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
			String name = AlloyName.getRandomName(r);
			return name;
		}
		return "Alloy";
	}

	public static ItemStack withValue(AlloyTool item, int value) {
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

	@Override
    public int getHarvestLevel(ItemStack stack, String toolClass, @javax.annotation.Nullable net.minecraft.entity.player.EntityPlayer player, @javax.annotation.Nullable IBlockState blockState)
    {
        int level = 1;
        if (this.getToolClasses(stack).contains(toolClass))
        {
        	if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
        		return Math.max(1, stack.getTagCompound().getInteger("INGOT_DATA") / 10);
        	}
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    public int getHarvestLevel(ItemStack stack)
    {
    	if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
    		return Math.max(1, stack.getTagCompound().getInteger("INGOT_DATA") / 10);
    	}
        return 1;
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

	protected float getEfficiency(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("efficiency"));
			return 1.0F + (num / 50.0F) + (r.nextFloat() * num / 10.0F);
		}
		return 1.0F;
	}
	
	@Override
	public int getMaxDamage(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("damage"));
			return Math.max(10, (num * 100) + r.nextInt(200) - 100);
		}
		return 1;
	}
	
	@Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack)
    {
		return getHarvestLevel(stack) >= state.getBlock().getHarvestLevel(state);
    }
	
	@Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot, ItemStack stack)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", (double)getDamageVsEntity(stack), 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", (double)getAttackSpeed(stack), 0));
        }

        return multimap;
    }

	private double getAttackSpeed(ItemStack stack) {
		//TODO: optimize this
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
			int num = stack.getTagCompound().getInteger("INGOT_DATA");
			Random r = new Random(num + toInt("attackspeed"));
			num = Math.max(num, 1);
			double value = 1.0D;
			double rand = r.nextDouble();
			value = value + (rand - rand / 2);
			value = value / r.nextInt((int) Math.pow(num, 1.0 / 4.0));
			return value;
		}
		return 1.0D;
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

	
}
