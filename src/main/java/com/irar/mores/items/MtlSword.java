package com.irar.mores.items;

import com.irar.mores.handlers.CreativeTabHandler;

import net.minecraft.item.ItemSword;

public class MtlSword extends ItemSword{

	public MtlSword(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
//		this.setCreativeTab(CreativeTabHandler.MORES);
	}

}
