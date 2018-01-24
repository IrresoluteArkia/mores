package com.irar.mores.items;

import com.irar.mores.handlers.CreativeTabHandler;

import net.minecraft.item.ItemSpade;

public class MtlShovel extends ItemSpade{

	public MtlShovel(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
//		this.setCreativeTab(CreativeTabHandler.MORES);
	}

}
