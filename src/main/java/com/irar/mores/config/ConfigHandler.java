package com.irar.mores.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.irar.mores.Ref;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	private List<Configuration> configs = new ArrayList<>();
    File configDir;

    public ConfigHandler(File mainConfigDir){
        MinecraftForge.EVENT_BUS.register(this);

        configDir = new File(mainConfigDir.getAbsolutePath() + "/mores");
        if(!configDir.exists()) {
        	configDir.mkdir();
        }
        
        initConfigs();
        
        for(Configuration config : configs) {
        	config.load();
        }

        changeConfigs();
    }

    private void initConfigs() {
		OreSpawn.init(this);
	}

	public void changeConfigs(){
		for(Configuration config : configs) {
	        ConfigStore.setConfigs(config);

	        if(config.hasChanged()){
	            config.save();
	        }
		}
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){
        if(event.getModID().equalsIgnoreCase(Ref.MODID)){
            changeConfigs();
        }
    }
    
    Configuration getConfigForFile(String filename) {
    	Configuration config = new Configuration(new File(configDir.getAbsolutePath() + "/" + filename + ".cfg"));
    	configs.add(config);
    	return config;
    }

}
