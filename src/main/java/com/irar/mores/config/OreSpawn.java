package com.irar.mores.config;

import com.irar.mores.config.ConfigInts.ConfigInt;

import net.minecraftforge.common.config.Configuration;

public class OreSpawn {
	
	public static ConfigInt PHANTOM_VEIN_SIZE;
	public static ConfigInt PHANTOM_SPAWN_CHANCE;
	public static ConfigInt PHANTOM_MIN_Y;
	public static ConfigInt PHANTOM_MAX_Y;

	public static ConfigInt AYZANITE_VEIN_SIZE;
	public static ConfigInt AYZANITE_SPAWN_CHANCE;
	public static ConfigInt AYZANITE_MIN_Y;
	public static ConfigInt AYZANITE_MAX_Y;

	public static ConfigInt SIVENIUM_VEIN_SIZE;
	public static ConfigInt SIVENIUM_SPAWN_CHANCE;
	public static ConfigInt SIVENIUM_MIN_Y;
	public static ConfigInt SIVENIUM_MAX_Y;

	public static ConfigInt AURINE_VEIN_SIZE;
	public static ConfigInt AURINE_SPAWN_CHANCE;
	public static ConfigInt AURINE_MIN_Y;
	public static ConfigInt AURINE_MAX_Y;

	public static ConfigInt ITURITE_VEIN_SIZE;
	public static ConfigInt ITURITE_SPAWN_CHANCE;
	public static ConfigInt ITURITE_MIN_Y;
	public static ConfigInt ITURITE_MAX_Y;

	public static ConfigInt NODEMITE_VEIN_SIZE;
	public static ConfigInt NODEMITE_SPAWN_CHANCE;
	public static ConfigInt NODEMITE_MIN_Y;
	public static ConfigInt NODEMITE_MAX_Y;

	public static ConfigInt DRAXATE_VEIN_SIZE;
	public static ConfigInt DRAXATE_SPAWN_CHANCE;
	public static ConfigInt DRAXATE_MIN_Y;
	public static ConfigInt DRAXATE_MAX_Y;

	public static ConfigInt EUKAVOYNT_VEIN_SIZE;
	public static ConfigInt EUKAVOYNT_SPAWN_CHANCE;
	public static ConfigInt EUKAVOYNT_MIN_Y;
	public static ConfigInt EUKAVOYNT_MAX_Y;

	public static ConfigInt BLACKHOLE_VEIN_SIZE;
	public static ConfigInt BLACKHOLE_SPAWN_CHANCE;
	public static ConfigInt BLACKHOLE_MIN_Y;
	public static ConfigInt BLACKHOLE_MAX_Y;

	static void init(ConfigHandler handler) {
		Configuration config = handler.getConfigForFile("ore-spawn");
		PHANTOM_VEIN_SIZE = new ConfigInt(config, "phantom", "vein-size", "Phantom ore vein size", 10, 1, 512);
		PHANTOM_SPAWN_CHANCE = new ConfigInt(config, "phantom", "spawn-chance", "Maximum number of Phantom ore veins per chunk", 8, 0, 512);
		PHANTOM_MIN_Y = new ConfigInt(config, "phantom", "min-y", "Lowest y value Phantom ore can spawn at", 5, 0, 256);
		PHANTOM_MAX_Y = new ConfigInt(config, "phantom", "max-y", "Highest y value Phantom ore can spawn at", 70, 0, 256);
		
		AYZANITE_VEIN_SIZE = new ConfigInt(config, "ayzanite", "vein-size", "Ayzanite ore vein size", 10, 1, 512);
		AYZANITE_SPAWN_CHANCE = new ConfigInt(config, "ayzanite", "spawn-chance", "Maximum number of Ayzanite ore veins per chunk", 10, 0, 512);
		AYZANITE_MIN_Y = new ConfigInt(config, "ayzanite", "min-y", "Lowest y value Ayzanite ore can spawn at", 20, 0, 256);
		AYZANITE_MAX_Y = new ConfigInt(config, "ayzanite", "max-y", "Highest y value Ayzanite ore can spawn at", 100, 0, 256);
		
		SIVENIUM_VEIN_SIZE = new ConfigInt(config, "sivenium", "vein-size", "Sivenium ore vein size", 10, 1, 512);
		SIVENIUM_SPAWN_CHANCE = new ConfigInt(config, "sivenium", "spawn-chance", "Maximum number of Sivenium ore veins per chunk", 10, 0, 512);
		SIVENIUM_MIN_Y = new ConfigInt(config, "sivenium", "min-y", "Lowest y value Sivenium ore can spawn at", 20, 0, 256);
		SIVENIUM_MAX_Y = new ConfigInt(config, "sivenium", "max-y", "Highest y value Sivenium ore can spawn at", 100, 0, 256);
		
		AURINE_VEIN_SIZE = new ConfigInt(config, "aurine", "vein-size", "Aurine ore vein size", 10, 1, 512);
		AURINE_SPAWN_CHANCE = new ConfigInt(config, "aurine", "spawn-chance", "Maximum number of Aurine ore veins per chunk", 4, 0, 512);
		AURINE_MIN_Y = new ConfigInt(config, "aurine", "min-y", "Lowest y value Aurine ore can spawn at", 20, 0, 256);
		AURINE_MAX_Y = new ConfigInt(config, "aurine", "max-y", "Highest y value Aurine ore can spawn at", 100, 0, 256);
		
		ITURITE_VEIN_SIZE = new ConfigInt(config, "iturite", "vein-size", "Iturite ore vein size", 10, 1, 512);
		ITURITE_SPAWN_CHANCE = new ConfigInt(config, "iturite", "spawn-chance", "Maximum number of Iturite ore veins per chunk", 1, 0, 512);
		ITURITE_MIN_Y = new ConfigInt(config, "iturite", "min-y", "Lowest y value Iturite ore can spawn at", 30, 0, 256);
		ITURITE_MAX_Y = new ConfigInt(config, "iturite", "max-y", "Highest y value Iturite ore can spawn at", 50, 0, 256);
		
		NODEMITE_VEIN_SIZE = new ConfigInt(config, "nodemite", "vein-size", "Nodemite ore vein size", 10, 1, 512);
		NODEMITE_SPAWN_CHANCE = new ConfigInt(config, "nodemite", "spawn-chance", "Maximum number of Nodemite ore veins per chunk", 2, 0, 512);
		NODEMITE_MIN_Y = new ConfigInt(config, "nodemite", "min-y", "Lowest y value Nodemite ore can spawn at", 30, 0, 256);
		NODEMITE_MAX_Y = new ConfigInt(config, "nodemite", "max-y", "Highest y value Nodemite ore can spawn at", 50, 0, 256);
		
		DRAXATE_VEIN_SIZE = new ConfigInt(config, "draxate", "vein-size", "Draxate ore vein size", 10, 1, 512);
		DRAXATE_SPAWN_CHANCE = new ConfigInt(config, "draxate", "spawn-chance", "Maximum number of Draxate ore veins per chunk", 1, 0, 512);
		DRAXATE_MIN_Y = new ConfigInt(config, "draxate", "min-y", "Lowest y value Draxate ore can spawn at", 5, 0, 256);
		DRAXATE_MAX_Y = new ConfigInt(config, "draxate", "max-y", "Highest y value Draxate ore can spawn at", 30, 0, 256);
		
		EUKAVOYNT_VEIN_SIZE = new ConfigInt(config, "eukavoynt", "vein-size", "Eukavoynt ore vein size", 8, 1, 512);
		EUKAVOYNT_SPAWN_CHANCE = new ConfigInt(config, "eukavoynt", "spawn-chance", "Maximum number of Eukavoynt ore veins per chunk", 1, 0, 512);
		EUKAVOYNT_MIN_Y = new ConfigInt(config, "eukavoynt", "min-y", "Lowest y value Eukavoynt ore can spawn at", 5, 0, 256);
		EUKAVOYNT_MAX_Y = new ConfigInt(config, "eukavoynt", "max-y", "Highest y value Eukavoynt ore can spawn at", 70, 0, 256);
		
		BLACKHOLE_VEIN_SIZE = new ConfigInt(config, "black-hole", "vein-size", "Black Hole ore vein size", 10, 1, 512);
		BLACKHOLE_SPAWN_CHANCE = new ConfigInt(config, "black-hole", "spawn-chance", "Maximum number of Black Hole ore veins per chunk", 1, 0, 512);
		BLACKHOLE_MIN_Y = new ConfigInt(config, "black-hole", "min-y", "Lowest y value Black Hole ore can spawn at", 5, 0, 256);
		BLACKHOLE_MAX_Y = new ConfigInt(config, "black-hole", "max-y", "Highest y value Black Hole ore can spawn at", 120, 0, 256);
	}
	
}
