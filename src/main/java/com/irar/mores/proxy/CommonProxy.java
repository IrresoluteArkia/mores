package com.irar.mores.proxy;


import com.irar.mores.handlers.BlockHandler;
import com.irar.mores.handlers.CMRegisterHandler;
import com.irar.mores.handlers.CraftingHandler;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.OreDictHandler;
import com.irar.mores.items.AlloyBow;
import com.irar.mores.util.ArrowActions;
import com.irar.mores.world.WorldGenOre;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
		ItemHandler.init();
		ItemHandler.register();
		
		BlockHandler.init();
		BlockHandler.register();
		
		ArrowActions.init();
		ArrowActions.register();
		
		GameRegistry.registerWorldGenerator(new WorldGenOre(), 0);
		
		OreDictHandler.init();
		
		CMRegisterHandler.init();


	}

	@Override
	public void init() {
		
	}

	@Override
	public void postInit() {
		CraftingHandler.init();
	}
	
	public class MainEventHandler{
		private int use = 0;
		@SubscribeEvent
		public void updateFOV(FOVUpdateEvent event) {
			if(!event.getEntity().getActiveItemStack().isEmpty()) {
				if(event.getEntity().getActiveItemStack().getItem() instanceof AlloyBow) {
					use++;
					event.setNewfov((event.getNewfov() != 0 ? event.getNewfov() : event.getFov()) - (use * 0.01F));
				}
			}
		}
		
		@SubscribeEvent
		public void arrowLoose(ArrowLooseEvent event) {
			use = 0;
		}
	}

}
