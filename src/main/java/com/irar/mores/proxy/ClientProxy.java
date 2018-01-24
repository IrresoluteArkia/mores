package com.irar.mores.proxy;

import com.irar.mores.handlers.BlockHandler;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.OreDictHandler;

public class ClientProxy extends CommonProxy{
	public void init(){
		ItemHandler.registerRenders();
		BlockHandler.registerRenders();
		OreDictHandler.init();
	}
}
