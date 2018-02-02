package com.irar.mores.enchanting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.irar.mores.items.AlloySword;
import com.irar.mores.items.AlloyTool;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;

public class EnchantmentSet {

	private static final HashMap<Enchantment, Integer> toolEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> enchantWeights = new HashMap<>();
	private static final HashMap<Enchantment, Integer> swordEnchants = new HashMap<>();
	static {
		toolEnchants.put(Enchantments.VANISHING_CURSE, -300);
		toolEnchants.put(Enchantments.EFFICIENCY, 5);
		toolEnchants.put(Enchantments.FORTUNE, 50);
		toolEnchants.put(Enchantments.MENDING, 200);
		toolEnchants.put(Enchantments.SHARPNESS, 20);
		toolEnchants.put(Enchantments.SILK_TOUCH, 200);
		toolEnchants.put(Enchantments.UNBREAKING, 20);
		
		swordEnchants.put(Enchantments.BANE_OF_ARTHROPODS, 30);
		swordEnchants.put(Enchantments.VANISHING_CURSE, -300);
		swordEnchants.put(Enchantments.FIRE_ASPECT, 50);
		swordEnchants.put(Enchantments.KNOCKBACK, 60);
		swordEnchants.put(Enchantments.MENDING, 200);
		swordEnchants.put(Enchantments.LOOTING, 50);
		swordEnchants.put(Enchantments.SMITE, 60);
		swordEnchants.put(Enchantments.SWEEPING, 70);
		swordEnchants.put(Enchantments.SHARPNESS, 20);
		swordEnchants.put(Enchantments.UNBREAKING, 20);
		
		enchantWeights.put(Enchantments.VANISHING_CURSE, 2);
		enchantWeights.put(Enchantments.EFFICIENCY, 20);
		enchantWeights.put(Enchantments.FORTUNE, 6);
		enchantWeights.put(Enchantments.MENDING, 2);
		enchantWeights.put(Enchantments.SHARPNESS, 6);
		enchantWeights.put(Enchantments.SILK_TOUCH, 4);
		enchantWeights.put(Enchantments.UNBREAKING, 10);
		enchantWeights.put(Enchantments.BANE_OF_ARTHROPODS, 2);
		enchantWeights.put(Enchantments.FIRE_ASPECT, 2);
		enchantWeights.put(Enchantments.LOOTING, 3);
		enchantWeights.put(Enchantments.SMITE, 2);
		enchantWeights.put(Enchantments.SWEEPING, 4);
		enchantWeights.put(Enchantments.KNOCKBACK, 5);
	}
	
	private HashMap<Enchantment, Integer> enchantments = new HashMap<>();
	
	public EnchantmentSet(ItemStack stack) {
		if(stack.getItem() instanceof AlloyTool) {
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
				this.enchantments = getToolEnchantments(stack.getTagCompound().getInteger("INGOT_DATA"));
			}
		}
		if(stack.getItem() instanceof AlloySword) {
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
				this.enchantments = getSwordEnchantments(stack.getTagCompound().getInteger("INGOT_DATA"));
			}
		}
	}

	private HashMap<Enchantment, Integer> getSwordEnchantments(int value) {
		HashMap<Enchantment, Integer> swordEnchants = (HashMap<Enchantment, Integer>) EnchantmentSet.swordEnchants.clone();
		Random r = new Random(value);
		HashMap<Enchantment, Integer> enchantments = new HashMap<>();
		int triesLeft = 10;
		while(triesLeft > 0) {
			Enchantment enchantment = getRandomWeighted(r, swordEnchants);
			if(enchantment.isCurse()) {
				if(!(r.nextInt(10) == 1)) {
					triesLeft--;
					continue;
				}
			}
			int price = swordEnchants.get(enchantment);
			if(value > price) {
				value -= price;
				if(enchantments.containsKey(enchantment)) {
					enchantments.put(enchantment, enchantments.get(enchantment) + 1);
				}else {
					enchantments.put(enchantment, 1);
				}
				if(enchantment.getMaxLevel() == 1) {
					swordEnchants.remove(enchantment);
				}else {
					swordEnchants.put(enchantment, price * 2);
				}
			}else {
				triesLeft--;
			}
		}
		return enchantments;
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
