package com.irar.mores;


import com.irar.mores.proxy.IProxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;

@Mod(modid = Ref.MODID, version = Ref.VERSION)

public class Mores {
	@SidedProxy(clientSide=Ref.CLIENT_PROXY, serverSide=Ref.SERVER_PROXY)
	public static IProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	proxy.preInit();
    }
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.postInit();
    }
}
