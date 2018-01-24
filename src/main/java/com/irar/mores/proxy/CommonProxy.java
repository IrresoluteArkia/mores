package com.irar.mores.proxy;


import com.irar.mores.handlers.BlockHandler;
import com.irar.mores.handlers.CraftingHandler;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.OreDictHandler;
import com.irar.mores.world.WorldGenOre;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
		ItemHandler.init();
		ItemHandler.register();
		
		BlockHandler.init();
		BlockHandler.register();
		
		GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
		
		OreDictHandler.init();
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		CraftingHandler.init();
	}

}
