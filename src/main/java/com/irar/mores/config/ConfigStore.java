package com.irar.mores.config;

import com.irar.mores.config.ConfigInts.ConfigInt;

import net.minecraftforge.common.config.Configuration;

public class ConfigStore {

	public static void setConfigs(Configuration config) {
		for(ConfigInt cfgint : ConfigInts.getConfigInts()) {
			cfgint.value = config.get(cfgint.category, cfgint.name, cfgint.defaultValue, cfgint.description, cfgint.min, cfgint.max).getInt();
		}
	}

}
