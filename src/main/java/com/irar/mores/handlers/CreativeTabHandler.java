package com.irar.mores.handlers;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class CreativeTabHandler {
	public static CreativeTabs MORES = new CreativeTabs("mores"){

		public ItemStack getTabIconItem() {
			return new ItemStack(ItemHandler.PhantomShard);
		}
		
	};
}
