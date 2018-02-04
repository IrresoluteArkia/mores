package com.irar.mores.proxy;

import com.irar.mores.handlers.BlockHandler;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.OreDictHandler;
import com.irar.mores.proxy.CommonProxy.MainEventHandler;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{
	public void init(){
		super.init();
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
		OreDictHandler.init();
	}
	
	public void postInit() {
		super.postInit();
		MainEventHandler eventHandler = new MainEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
	}
}
