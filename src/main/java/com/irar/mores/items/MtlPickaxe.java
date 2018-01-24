package com.irar.mores.items;

import com.irar.mores.handlers.CreativeTabHandler;

import net.minecraft.item.ItemPickaxe;

public class MtlPickaxe extends ItemPickaxe{

	public MtlPickaxe(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
//		this.setCreativeTab(CreativeTabHandler.MORES);
	}

}
