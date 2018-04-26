package com.irar.mores.util;

import com.irar.mores.Ref;
import com.irar.mores.entity.EntityAlloyArrow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class IArrowAction implements IForgeRegistryEntry<IArrowAction>{

	private ResourceLocation registryName;
	
	private IArrowAction() {}
	
	public IArrowAction(String name) {
		this.setRegistryName(name);
	}
	
	public abstract void apply(EntityAlloyArrow arrow, Entity entity, ActionType type);
	
	
	/**
	 * To be used like enchantments e.g. returning "Exploding" would make the tooltip something like "Exploding I"
	 * 
	 * @return a string
	 */
	public abstract String getDisplayName();
	
	public int getLevel(EntityAlloyArrow arrow) {
		return this.getLevel(arrow.ingotData);
	}
	
	public int getLevel(int ingotData) {
		return ArrowHelper.getLevel(ingotData);
	}
	
	public IArrowAction setRegistryName(String name) {
		this.setRegistryName(new ResourceLocation(Ref.MODID, name));
		return this;
	}

	@Override
	public IArrowAction setRegistryName(ResourceLocation name) {
		this.registryName = name;
		return this;
	}

	@Override
	public ResourceLocation getRegistryName() {
		return this.registryName;
	}

	@Override
	public Class<IArrowAction> getRegistryType() {
		return IArrowAction.class;
	}

	public abstract ActionType[] getActionTypes();
	
}
