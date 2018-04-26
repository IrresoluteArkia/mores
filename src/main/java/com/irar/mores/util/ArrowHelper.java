package com.irar.mores.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.irar.mores.entity.EntityAlloyArrow;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class ArrowHelper {

	private static List<IArrowAction> allActions = new ArrayList<>();
	
	static {
		allActions = ArrowActions.allActions;
	}
	
	public static void arrowHit(EntityAlloyArrow entity) {
		applyToWorld(entity);
		arrowHit(entity, entity.posX, entity.posY, entity.posZ);
	}

	public static void arrowHit(EntityAlloyArrow entity, EntityLivingBase living) {
		applyToLiving(entity, living);
		arrowHit(entity, living.posX, living.posY, living.posZ);
	}

	private static void arrowHit(EntityAlloyArrow entity, double posX, double posY, double posZ) {
		
	}

	private static void applyToLiving(EntityAlloyArrow arrow, EntityLivingBase living) {
		List<IArrowAction> actions = getArrowActionsForIngot(arrow.ingotData);
		for(IArrowAction action : actions) {
			if(ArrayHelper.contains(action.getActionTypes(), (ActionType.ENTITY)) || ArrayHelper.contains(action.getActionTypes(), (ActionType.BOTH))) {
				action.apply(arrow, living, ActionType.ENTITY);
			}
		}
	}

	private static void applyToWorld(EntityAlloyArrow arrow) {
		List<IArrowAction> actions = getArrowActionsForIngot(arrow.ingotData);
		for(IArrowAction action : actions) {
			if(ArrayHelper.contains(action.getActionTypes(), (ActionType.WORLD)) || ArrayHelper.contains(action.getActionTypes(), (ActionType.BOTH))) {
				action.apply(arrow, arrow, ActionType.WORLD);
			}
		}
	}

	public static List<IArrowAction> getArrowActionsForIngot(int ingotData) {
		List<IArrowAction> actions = new ArrayList<>();
		List<IArrowAction> actionsWithWeight = new ArrayList<>();
		for(IArrowAction action : allActions) {
			int j = ArrowActions.getActionWeight(action);
			for(int i = 0; i < j; i++) {
				actionsWithWeight.add(action);
			}
		}
		Random r = new Random(ingotData);
		r.nextInt(1);
		actions.add(actionsWithWeight.get(r.nextInt(actionsWithWeight.size())));
		return actions;
	}
	
	public static int getLevel(EntityAlloyArrow arrow) {
		return getLevel(arrow.ingotData);
	}

	public static int getLevel(int level) {
		int retLevel = (int) MathHelper.log(5, level);
		return retLevel;
	}

	public static void duringFlight(EntityAlloyArrow arrow) {
		List<IArrowAction> actions = getArrowActionsForIngot(arrow.ingotData);
		for(IArrowAction action : actions) {
			if(ArrayHelper.contains(action.getActionTypes(), (ActionType.DURINGFLIGHT))) {
				action.apply(arrow, arrow, ActionType.DURINGFLIGHT);
			}
		}
	}

}
