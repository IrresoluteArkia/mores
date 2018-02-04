package com.irar.mores.enchanting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.items.AlloyArmor;
import com.irar.mores.items.AlloyBow;
import com.irar.mores.items.AlloySword;
import com.irar.mores.items.AlloyTool;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentSet {

	private static final HashMap<Enchantment, Integer> toolEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> enchantWeights = new HashMap<>();
	private static final HashMap<Enchantment, Integer> swordEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> bowEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> armorEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> helmetEnchants = new HashMap<>();
	private static final HashMap<Enchantment, Integer> bootsEnchants = new HashMap<>();
	
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
		
		bowEnchants.put(Enchantments.UNBREAKING, 20);
		bowEnchants.put(Enchantments.MENDING, 200);
		bowEnchants.put(Enchantments.VANISHING_CURSE, -300);
		bowEnchants.put(Enchantments.FLAME, 50);
		bowEnchants.put(Enchantments.INFINITY, 200);
		bowEnchants.put(Enchantments.POWER, 20);
		bowEnchants.put(Enchantments.PUNCH, 60);
		
		armorEnchants.put(Enchantments.BLAST_PROTECTION, 50);
		armorEnchants.put(Enchantments.BINDING_CURSE, -300);
		armorEnchants.put(Enchantments.VANISHING_CURSE, -300);
		armorEnchants.put(Enchantments.FIRE_PROTECTION, 50);
		armorEnchants.put(Enchantments.MENDING, 200);
		armorEnchants.put(Enchantments.PROJECTILE_PROTECTION, 50);
		armorEnchants.put(Enchantments.PROTECTION, 100);
		armorEnchants.put(Enchantments.THORNS, 110);
		armorEnchants.put(Enchantments.UNBREAKING, 40);
		
		bootsEnchants.put(Enchantments.DEPTH_STRIDER, 40);
		bootsEnchants.put(Enchantments.FEATHER_FALLING, 40);
		bootsEnchants.put(Enchantments.FROST_WALKER, 40);
		
		helmetEnchants.put(Enchantments.AQUA_AFFINITY, 40);
		helmetEnchants.put(Enchantments.RESPIRATION, 40);
		
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
		enchantWeights.put(Enchantments.FLAME, 4);
		enchantWeights.put(Enchantments.INFINITY, 2);
		enchantWeights.put(Enchantments.POWER, 10);
		enchantWeights.put(Enchantments.PUNCH, 12);
		enchantWeights.put(Enchantments.BLAST_PROTECTION, 3);
		enchantWeights.put(Enchantments.BINDING_CURSE, 2);
		enchantWeights.put(Enchantments.FIRE_PROTECTION, 3);
		enchantWeights.put(Enchantments.PROJECTILE_PROTECTION, 5);
		enchantWeights.put(Enchantments.PROTECTION, 4);
		enchantWeights.put(Enchantments.THORNS, 3);
		enchantWeights.put(Enchantments.DEPTH_STRIDER, 3);
		enchantWeights.put(Enchantments.FEATHER_FALLING, 5);
		enchantWeights.put(Enchantments.FROST_WALKER, 1);
		enchantWeights.put(Enchantments.AQUA_AFFINITY, 4);
		enchantWeights.put(Enchantments.RESPIRATION, 2);
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
		if(stack.getItem() instanceof AlloyBow) {
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
				this.enchantments = getBowEnchantments(stack.getTagCompound().getInteger("INGOT_DATA"));
			}
		}
		if(stack.getItem() instanceof AlloyArmor) {
			if(stack.hasTagCompound() && stack.getTagCompound().hasKey("INGOT_DATA")) {
				this.enchantments = getArmorEnchantments(stack.getItem(), stack.getTagCompound().getInteger("INGOT_DATA"));
			}
		}
	}

	private HashMap<Enchantment, Integer> getArmorEnchantments(Item item, int value) {
		HashMap<Enchantment, Integer> armorEnchants = (HashMap<Enchantment, Integer>) EnchantmentSet.armorEnchants.clone();
		if(item.equals(ItemHandler.AlloyBoots)) {
			bootsEnchants.forEach((ench, val) -> {
				armorEnchants.put(ench, val);
			});
		}
		if(item.equals(ItemHandler.AlloyHelmet)) {
			helmetEnchants.forEach((ench, val) -> {
				armorEnchants.put(ench, val);
			});
		}
		Random r = new Random(value);
		HashMap<Enchantment, Integer> enchantments = new HashMap<>();
		int triesLeft = 10;
		while(triesLeft > 0) {
			Enchantment enchantment = getRandomWeighted(r, armorEnchants);
			if(enchantment.equals(Enchantments.FIRE_PROTECTION) || enchantment.equals(Enchantments.BLAST_PROTECTION) || enchantment.equals(Enchantments.PROJECTILE_PROTECTION) || enchantment.equals(Enchantments.PROTECTION)) {
				if(enchantments.containsKey(Enchantments.FIRE_PROTECTION)) {
					enchantment = Enchantments.FIRE_PROTECTION;
				}else if(enchantments.containsKey(Enchantments.BLAST_PROTECTION)) {
					enchantment = Enchantments.BLAST_PROTECTION;
				}else if(enchantments.containsKey(Enchantments.PROJECTILE_PROTECTION)) {
					enchantment = Enchantments.PROJECTILE_PROTECTION;
				}else if(enchantments.containsKey(Enchantments.PROTECTION)) {
					enchantment = Enchantments.PROTECTION;
				}
			}
			if(enchantment.isCurse()) {
				if(!(r.nextInt(10) == 1)) {
					triesLeft--;
					continue;
				}
			}
			int price = armorEnchants.get(enchantment);
			if(value > price) {
				value -= price;
				if(enchantments.containsKey(enchantment)) {
					enchantments.put(enchantment, enchantments.get(enchantment) + 1);
				}else {
					enchantments.put(enchantment, 1);
				}
				if(enchantment.getMaxLevel() == 1) {
					armorEnchants.remove(enchantment);
				}else {
					armorEnchants.put(enchantment, price * 3);
				}
			}else {
				triesLeft--;
			}
		}
		return enchantments;
	}

	private HashMap<Enchantment, Integer> getBowEnchantments(int value) {
		HashMap<Enchantment, Integer> bowEnchants = (HashMap<Enchantment, Integer>) EnchantmentSet.bowEnchants.clone();
		Random r = new Random(value);
		HashMap<Enchantment, Integer> enchantments = new HashMap<>();
		int triesLeft = 10;
		while(triesLeft > 0) {
			Enchantment enchantment = getRandomWeighted(r, bowEnchants);
			if(enchantment.isCurse()) {
				if(!(r.nextInt(10) == 1)) {
					triesLeft--;
					continue;
				}
			}
			int price = bowEnchants.get(enchantment);
			if(value > price) {
				value -= price;
				if(enchantments.containsKey(enchantment)) {
					enchantments.put(enchantment, enchantments.get(enchantment) + 1);
				}else {
					enchantments.put(enchantment, 1);
				}
				if(enchantment.getMaxLevel() == 1) {
					bowEnchants.remove(enchantment);
				}else {
					bowEnchants.put(enchantment, price * 3);
				}
			}else {
				triesLeft--;
			}
		}
		return enchantments;
	}

	private HashMap<Enchantment, Integer> getSwordEnchantments(int value) {
		HashMap<Enchantment, Integer> swordEnchants = (HashMap<Enchantment, Integer>) EnchantmentSet.swordEnchants.clone();
		Random r = new Random(value);
		HashMap<Enchantment, Integer> enchantments = new HashMap<>();
		int triesLeft = 10;
		while(triesLeft > 0) {
			Enchantment enchantment = getRandomWeighted(r, swordEnchants);
			if(enchantment.equals(Enchantments.SHARPNESS) || enchantment.equals(Enchantments.SMITE) || enchantment.equals(Enchantments.BANE_OF_ARTHROPODS)) {
				if(enchantments.containsKey(Enchantments.SHARPNESS)) {
					enchantment = Enchantments.SHARPNESS;
				}else if(enchantments.containsKey(Enchantments.SMITE)) {
					enchantment = Enchantments.SMITE;
				}else if(enchantments.containsKey(Enchantments.BANE_OF_ARTHROPODS)) {
					enchantment = Enchantments.BANE_OF_ARTHROPODS;
				}
			}
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
					swordEnchants.put(enchantment, price * 3);
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
					toolEnchants.put(enchantment, price * 3);
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
