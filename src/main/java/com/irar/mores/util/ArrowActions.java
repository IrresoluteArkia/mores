package com.irar.mores.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.irar.mores.Ref;
import com.irar.mores.arrow.ArrowChorus;
import com.irar.mores.arrow.ArrowExplode;
import com.irar.mores.arrow.ArrowFireBomb;
import com.irar.mores.arrow.ArrowIncreaseDamage;
import com.irar.mores.arrow.ArrowSmelt;
import com.irar.mores.arrow.ArrowSplit;
import com.irar.mores.arrow.ArrowTeleport;
import com.irar.mores.entity.EntityAlloyArrow;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

public class ArrowActions {
	
	public static final IForgeRegistry<IArrowAction> arrowActionRegistry = new RegistryBuilder<IArrowAction>().setName(new ResourceLocation(Ref.MODID, "arrow_actions")).setType(IArrowAction.class).setMaxID(Integer.MAX_VALUE >> 5).create();

	private static HashMap<IArrowAction, Integer> actionWeights = new HashMap<>();

	public static IArrowAction EXPLODE;
	public static IArrowAction FIRE;
	public static IArrowAction DAMAGE;
	public static IArrowAction CHORUS;
	public static IArrowAction SPLIT;
	public static IArrowAction TELEPORT;
	public static IArrowAction SMELT;
	
	public static List<IArrowAction> allActions = new ArrayList<>();
	
	public static void init() {
		EXPLODE = new ArrowExplode("explode");
		FIRE = new ArrowFireBomb("fire_bomb");
		DAMAGE = new ArrowIncreaseDamage("damage");
		CHORUS = new ArrowChorus("chorus");
		SPLIT = new ArrowSplit("rain");
		TELEPORT = new ArrowTeleport("teleport");
		SMELT = new ArrowSmelt("smelt");
		
		setActionWeight(EXPLODE, 1);
		setActionWeight(FIRE, 2);
		setActionWeight(DAMAGE, 5);
		setActionWeight(CHORUS, 4);
		setActionWeight(SPLIT, 1);
		setActionWeight(TELEPORT, 2);
		setActionWeight(SMELT, 1);
		
		allActions.add(EXPLODE);
		allActions.add(FIRE);
		allActions.add(DAMAGE);
		allActions.add(CHORUS);
		allActions.add(SPLIT);
		allActions.add(TELEPORT);
		allActions.add(SMELT);
	}
	
	public static void register() {
		for(IArrowAction action : allActions) {
			arrowActionRegistry.register(action);
		}
	}
	
	public static int getActionWeight(IArrowAction action) {
		if(actionWeights.containsKey(action)) {
			return actionWeights.get(action);
		}
		return 1;
	}
	
	public static void setActionWeight(IArrowAction action, int weight) {
		actionWeights.put(action, weight);
	}
	
}
