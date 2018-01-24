package com.irar.mores.handlers;

import com.irar.mores.blocks.BlockOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockHandler {
	public static Block PhantomOre;//0,0,1
	public static Block SiveniumOre;//1,1,0      (Group, number in group, type of ore)
	public static Block AyzaniteOre;//1,2,0      (Groups are in ascending difficulty to mine)
	public static Block AurineOre;//1,2,1        (Numbers are ascending starting with 1)
	public static Block IturiteOre;//2,1,0       (Types: 0 is smeltable, 1 is multidrop)
	public static Block NodemiteOre;//2,2,1
	public static Block DraxateOre;//3,1,0
	public static Block EukavoyntOre;//3,2,0
	public static Block BlackHoleOre;//3,2,0
	
	public static Block NetherPhantomOre;//0,0,1
	public static Block NetherSiveniumOre;//1,1,0      (Group, number in group, type of ore)
	public static Block NetherAyzaniteOre;//1,2,0      (Groups are in ascending difficulty to mine)
	public static Block NetherAurineOre;//1,2,1        (Numbers are ascending starting with 1)
	public static Block NetherIturiteOre;//2,1,0       (Types: 0 is smeltable, 1 is multidrop)
	public static Block NetherNodemiteOre;//2,2,1
	public static Block NetherDraxateOre;//3,1,0
	public static Block NetherEukavoyntOre;//3,2,0
	
	public static Block OxaxagiteOre;//4?,1,???            PLEASE NOTE THAT THIS DATA MAY NO LONGER BE RELAVENT
	
	public static ItemBlock ibPhantomOre;
	public static ItemBlock ibSiveniumOre;
	public static ItemBlock ibAyzaniteOre;
	public static ItemBlock ibAurineOre;
	public static ItemBlock ibIturiteOre;
	public static ItemBlock ibNodemiteOre;
	public static ItemBlock ibDraxateOre;
	public static ItemBlock ibEukavoyntOre;
	public static ItemBlock ibBlackHoleOre;
	public static ItemBlock ibNetherPhantomOre;
	public static ItemBlock ibNetherSiveniumOre;
	public static ItemBlock ibNetherAyzaniteOre;
	public static ItemBlock ibNetherAurineOre;
	public static ItemBlock ibNetherIturiteOre;
	public static ItemBlock ibNetherNodemiteOre;
	public static ItemBlock ibNetherDraxateOre;
	public static ItemBlock ibNetherEukavoyntOre;
	public static ItemBlock ibOxaxagiteOre;
	public static void init(){
		PhantomOre = new BlockOre("phantom_ore", MaterialHandler.PHANTOM, 1F, 3F, 0, "sword", false, null);
		SiveniumOre = new BlockOre("sivenium_ore", Material.ROCK, 5F, 15F, 2, "pickaxe", true, ItemHandler.SiveniumDust);
		AyzaniteOre = new BlockOre("ayzanite_ore", Material.ROCK, 6F, 18F, 2, "pickaxe", true, ItemHandler.AyzaniteDust);
		AurineOre = new BlockOre("aurine_ore", Material.ROCK, 7F, 21F, 2, "pickaxe", true, ItemHandler.AurineDust);
		IturiteOre = new BlockOre("iturite_ore", Material.ROCK, 8F, 24F, 3, "pickaxe", true, ItemHandler.IturiteDust);
		NodemiteOre = new BlockOre("nodemite_ore", Material.ROCK, 9F, 27F, 3, "pickaxe", true, ItemHandler.NodemiteDust);
		DraxateOre = new BlockOre("draxate_ore", Material.ROCK, 10F, 30F, 4, "pickaxe", true, ItemHandler.DraxateDust);
		EukavoyntOre = new BlockOre("eukavoynt_ore", Material.ROCK, 11F, 33F, 4, "pickaxe", true, ItemHandler.EukavoyntDust);
		BlackHoleOre = new BlockOre("black_hole_ore", Material.ROCK, 11F, 33F, 4, "pickaxe", true);
		NetherPhantomOre = new BlockOre("nether_phantom_ore", MaterialHandler.PHANTOM, 1F, 3F, 0, "sword", false, null);
		NetherSiveniumOre = new BlockOre("nether_sivenium_ore", Material.ROCK, 5F, 15F, 2, "pickaxe", true, ItemHandler.SiveniumDust);
		NetherAyzaniteOre = new BlockOre("nether_ayzanite_ore", Material.ROCK, 6F, 18F, 2, "pickaxe", true, ItemHandler.AyzaniteDust);
		NetherAurineOre = new BlockOre("nether_aurine_ore", Material.ROCK, 7F, 21F, 2, "pickaxe", true, ItemHandler.AurineDust);
		NetherIturiteOre = new BlockOre("nether_iturite_ore", Material.ROCK, 8F, 24F, 3, "pickaxe", true, ItemHandler.IturiteDust);
		NetherNodemiteOre = new BlockOre("nether_nodemite_ore", Material.ROCK, 9F, 27F, 3, "pickaxe", true, ItemHandler.NodemiteDust);
		NetherDraxateOre = new BlockOre("nether_draxate_ore", Material.ROCK, 10F, 30F, 4, "pickaxe", true, ItemHandler.DraxateDust);
		NetherEukavoyntOre = new BlockOre("nether_eukavoynt_ore", Material.ROCK, 11F, 33F, 4, "pickaxe", true, ItemHandler.EukavoyntDust);
		OxaxagiteOre = new BlockOre("oxaxagite_ore", Material.ROCK, 12F, 36F, 5, "pickaxe", true, Item.getItemFromBlock(BlockHandler.OxaxagiteOre));

		ibPhantomOre = (ItemBlock) new ItemBlock(PhantomOre);
		ibSiveniumOre = (ItemBlock) new ItemBlock(SiveniumOre);
		ibAyzaniteOre = (ItemBlock) new ItemBlock(AyzaniteOre);
		ibAurineOre = (ItemBlock) new ItemBlock(AurineOre);
		ibIturiteOre = (ItemBlock) new ItemBlock(IturiteOre);
		ibNodemiteOre = (ItemBlock) new ItemBlock(NodemiteOre);
		ibDraxateOre = (ItemBlock) new ItemBlock(DraxateOre);
		ibEukavoyntOre = (ItemBlock) new ItemBlock(EukavoyntOre);
		ibBlackHoleOre = (ItemBlock) new ItemBlock(BlackHoleOre);
		ibNetherPhantomOre = (ItemBlock) new ItemBlock(NetherPhantomOre);
		ibNetherSiveniumOre = (ItemBlock) new ItemBlock(NetherSiveniumOre);
		ibNetherAyzaniteOre = (ItemBlock) new ItemBlock(NetherAyzaniteOre);
		ibNetherAurineOre = (ItemBlock) new ItemBlock(NetherAurineOre);
		ibNetherIturiteOre = (ItemBlock) new ItemBlock(NetherIturiteOre);
		ibNetherNodemiteOre = (ItemBlock) new ItemBlock(NetherNodemiteOre);
		ibNetherDraxateOre = (ItemBlock) new ItemBlock(NetherDraxateOre);
		ibNetherEukavoyntOre = (ItemBlock) new ItemBlock(NetherEukavoyntOre);
		ibOxaxagiteOre = (ItemBlock) new ItemBlock(OxaxagiteOre);
		
		ibPhantomOre.setRegistryName(PhantomOre.getRegistryName());
		ibSiveniumOre.setRegistryName(SiveniumOre.getRegistryName());
		ibAyzaniteOre.setRegistryName(AyzaniteOre.getRegistryName());
		ibAurineOre.setRegistryName(AurineOre.getRegistryName());
		ibIturiteOre.setRegistryName(IturiteOre.getRegistryName());
		ibNodemiteOre.setRegistryName(NodemiteOre.getRegistryName());
		ibDraxateOre.setRegistryName(DraxateOre.getRegistryName());
		ibEukavoyntOre.setRegistryName(EukavoyntOre.getRegistryName());
		ibBlackHoleOre.setRegistryName(BlackHoleOre.getRegistryName());
		ibNetherPhantomOre.setRegistryName(NetherPhantomOre.getRegistryName());
		ibNetherSiveniumOre.setRegistryName(NetherSiveniumOre.getRegistryName());
		ibNetherAyzaniteOre.setRegistryName(NetherAyzaniteOre.getRegistryName());
		ibNetherAurineOre.setRegistryName(NetherAurineOre.getRegistryName());
		ibNetherIturiteOre.setRegistryName(NetherIturiteOre.getRegistryName());
		ibNetherNodemiteOre.setRegistryName(NetherNodemiteOre.getRegistryName());
		ibNetherDraxateOre.setRegistryName(NetherDraxateOre.getRegistryName());
		ibNetherEukavoyntOre.setRegistryName(NetherEukavoyntOre.getRegistryName());
		ibOxaxagiteOre.setRegistryName(OxaxagiteOre.getRegistryName());
		
		PhantomOre.setLightOpacity(0);
		NetherPhantomOre.setLightOpacity(0);
	}
	
	public static void register(){
		ForgeRegistries.BLOCKS.register(PhantomOre);
		ForgeRegistries.BLOCKS.register(SiveniumOre);
		ForgeRegistries.BLOCKS.register(AyzaniteOre);
		ForgeRegistries.BLOCKS.register(AurineOre);
		ForgeRegistries.BLOCKS.register(IturiteOre);
		ForgeRegistries.BLOCKS.register(NodemiteOre);
		ForgeRegistries.BLOCKS.register(DraxateOre);
		ForgeRegistries.BLOCKS.register(EukavoyntOre);
		ForgeRegistries.BLOCKS.register(BlackHoleOre);
		ForgeRegistries.BLOCKS.register(NetherPhantomOre);
		ForgeRegistries.BLOCKS.register(NetherSiveniumOre);
		ForgeRegistries.BLOCKS.register(NetherAyzaniteOre);
		ForgeRegistries.BLOCKS.register(NetherAurineOre);
		ForgeRegistries.BLOCKS.register(NetherIturiteOre);
		ForgeRegistries.BLOCKS.register(NetherNodemiteOre);
		ForgeRegistries.BLOCKS.register(NetherDraxateOre);
		ForgeRegistries.BLOCKS.register(NetherEukavoyntOre);
		ForgeRegistries.BLOCKS.register(OxaxagiteOre);

		ForgeRegistries.ITEMS.register(ibPhantomOre);
		ForgeRegistries.ITEMS.register(ibSiveniumOre);
		ForgeRegistries.ITEMS.register(ibAyzaniteOre);
		ForgeRegistries.ITEMS.register(ibAurineOre);
		ForgeRegistries.ITEMS.register(ibIturiteOre);
		ForgeRegistries.ITEMS.register(ibNodemiteOre);
		ForgeRegistries.ITEMS.register(ibDraxateOre);
		ForgeRegistries.ITEMS.register(ibEukavoyntOre);
		ForgeRegistries.ITEMS.register(ibBlackHoleOre);
		ForgeRegistries.ITEMS.register(ibNetherPhantomOre);
		ForgeRegistries.ITEMS.register(ibNetherSiveniumOre);
		ForgeRegistries.ITEMS.register(ibNetherAyzaniteOre);
		ForgeRegistries.ITEMS.register(ibNetherAurineOre);
		ForgeRegistries.ITEMS.register(ibNetherIturiteOre);
		ForgeRegistries.ITEMS.register(ibNetherNodemiteOre);
		ForgeRegistries.ITEMS.register(ibNetherDraxateOre);
		ForgeRegistries.ITEMS.register(ibNetherEukavoyntOre);
		ForgeRegistries.ITEMS.register(ibOxaxagiteOre);
	}
	
	public static void registerRenders(){
		registerRender(PhantomOre);
		registerRender(SiveniumOre);
		registerRender(AyzaniteOre);
		registerRender(AurineOre);
		registerRender(IturiteOre);
		registerRender(NodemiteOre);
		registerRender(DraxateOre);
		registerRender(EukavoyntOre);
		registerRender(BlackHoleOre);
		registerRender(NetherPhantomOre);
		registerRender(NetherSiveniumOre);
		registerRender(NetherAyzaniteOre);
		registerRender(NetherAurineOre);
		registerRender(NetherIturiteOre);
		registerRender(NetherNodemiteOre);
		registerRender(NetherDraxateOre);
		registerRender(NetherEukavoyntOre);
		registerRender(OxaxagiteOre);
		
		ItemHandler.registerRender(ibPhantomOre);
		ItemHandler.registerRender(ibSiveniumOre);
		ItemHandler.registerRender(ibAyzaniteOre);
		ItemHandler.registerRender(ibAurineOre);
		ItemHandler.registerRender(ibIturiteOre);
		ItemHandler.registerRender(ibNodemiteOre);
		ItemHandler.registerRender(ibDraxateOre);
		ItemHandler.registerRender(ibEukavoyntOre);
		ItemHandler.registerRender(ibBlackHoleOre);
		ItemHandler.registerRender(ibNetherPhantomOre);
		ItemHandler.registerRender(ibNetherSiveniumOre);
		ItemHandler.registerRender(ibNetherAyzaniteOre);
		ItemHandler.registerRender(ibNetherAurineOre);
		ItemHandler.registerRender(ibNetherIturiteOre);
		ItemHandler.registerRender(ibNetherNodemiteOre);
		ItemHandler.registerRender(ibNetherDraxateOre);
		ItemHandler.registerRender(ibNetherEukavoyntOre);
		ItemHandler.registerRender(ibOxaxagiteOre);
	}
	
	public static void registerRender(Block block){
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
