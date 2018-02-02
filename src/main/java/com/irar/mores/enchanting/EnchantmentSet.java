package com.irar.mores.enchanting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.irar.mores.items.AlloyTool;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;

public class EnchantmentSet {

	private static final HashMap<Enchantment, Integer> toolEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> enchantWeights = new HashMap<>();
	static {
		toolEnchants.put(Enchantments.VANISHING_CURSE, -300);
		toolEnchants.put(Enchantments.EFFICIENCY, 5);
		toolEnchants.put(Enchantments.FORTUNE, 50);
		toolEnchants.put(Enchantments.MENDING, 200);
		toolEnchants.put(Enchantments.SHARPNESS, 20);
		toolEnchants.put(Enchantments.SILK_TOUCH, 200);
		toolEnchants.put(Enchantments.UNBREAKING, 20);
		
		
		enchantWeights.put(Enchantments.VANISHING_CURSE, 1);
		enchantWeights.put(Enchantments.EFFICIENCY, 10);
		enchantWeights.put(Enchantments.FORTUNE, 3);
		enchantWeights.put(Enchantments.MENDING, 1);
		enchantWeights.put(Enchantments.SHARPNESS, 2);
		enchantWeights.put(Enchantments.SILK_TOUCH, 2);
		enchantWeights.put(Enchantments.UNBREAKING, 7);
	}
	
	private HashMap<Enchantment, Integer> enchantments = new HashMap<>();
	
	public EnchantmentSet(ItemStack stack) {
		if(stack.getItem() instanceof AlloyTool) {
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
				this.enchantments = getToolEnchantments(stack.getTagCompound().getInteger("INGOT_DATA"));
			}
		}
	}

	private HashMap<Enchantment, Integer> getToolEnchantments(int value) {
		HashMap<Enchantment, Integer> toolEnchants = (HashMap<Enchantment, Integer>) EnchantmentSet.toolEnchants.clone();
		Random r = new Random(value);
		HashMap<Enchantment, Integer> enchantments = new HashMap<>();
		int triesLeft = 10;
		while(triesLeft > 0) {
			Enchantment enchantment = getRandomWeighted(r, toolEnchants);
			if(enchantment.equals(Enchantments.SILK_TOUCH) && enchantments.containsKey(Enchantments.FORTUNE)) {
				enchantment = Enchantments.FORTUNE;
			}
			if(enchantment.equals(Enchantments.FORTUNE) && enchantments.containsKey(Enchantments.SILK_TOUCH)) {
				triesLeft--;
				continue;
			}
			if(enchantment.isCurse()) {
				if(!(r.nextInt(10) == 1)) {
					triesLeft--;
					continue;
				}
			}
			int price = toolEnchants.get(enchantment);
			if(value > price) {
				value -= price;
				if(enchantments.containsKey(enchantment)) {
					enchantments.put(enchantment, enchantments.get(enchantment) + 1);
				}else {
					enchantments.put(enchantment, 1);
				}
				if(enchantment.getMaxLevel() == 1) {
					toolEnchants.remove(enchantment);
				}else {
					toolEnchants.put(enchantment, price * 2);
				}
			}else {
				triesLeft--;
			}
		}
		return enchantments;
	}
	
	private Enchantment getRandomWeighted(Random r, HashMap<Enchantment, Integer> enchants) {
		List<Enchantment> rand = new ArrayList<>();
		for(Enchantment ench : enchantWeights.keySet()) {
			int times = enchantWeights.get(ench);
			if(enchants.containsKey(ench)) {
				for(int i = 0; i < times; i++) {
					rand.add(ench);
				}
			}
		}
		return rand.get(r.nextInt(rand.size()));
	}

	public ItemStack enchant(ItemStack stack) {
		for(Enchantment ench : this.enchantments.keySet()) {
			stack.addEnchantment(ench, this.enchantments.get(ench));
		}
		return stack;
	}
	
}
