package com.irar.mores.items;

import com.irar.mores.handlers.CreativeTabHandler;

import net.minecraft.item.ItemAxe;

public class MtlAxe extends ItemAxe{

	public MtlAxe(String name, ToolMaterial material) {
		super(material, material.getDamageVsEntity(), material.getEfficiencyOnProperMaterial());
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
//		this.setCreativeTab(CreativeTabHandler.MORES);
	}

}
