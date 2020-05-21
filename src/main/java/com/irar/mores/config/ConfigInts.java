package com.irar.mores.config;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

public class ConfigInts {
	
	private static List<ConfigInt> cfgints = new ArrayList<>();
	
	static List<ConfigInt> getConfigInts(){
		List<ConfigInt> cfgintscopy = new ArrayList<>();
		cfgintscopy.addAll(cfgints);
		return cfgintscopy;
	}
	
	public static class ConfigInt{
		
		int value;
		final Configuration file;
		public final String category;
		public final String name;
		public final int defaultValue;
		public final String description;
		public final int min;
		public final int max;

		public ConfigInt(Configuration file, String category, String name, String description, int defaultValue, int min, int max) {
			this.file = file;
			this.category = category;
			this.name = name;
			this.description = description + " (default: " + defaultValue + ", min: " + min + ", max: " + max + ")";
			this.defaultValue = defaultValue;
			this.min = min;
			this.max = max;
			cfgints.add(this);
		}
		
		public int getValue() {
			return value;
		}
		
	}

}
