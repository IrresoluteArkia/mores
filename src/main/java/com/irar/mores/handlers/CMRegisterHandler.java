package com.irar.mores.handlers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class CMRegisterHandler {

	public static void init() {
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.SiveniumDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 1 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.AyzaniteDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 6 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.AurineDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 60 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.IturiteDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 77 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.NodemiteDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 80 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.DraxateDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 300 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.EukavoyntDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 437 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.PhantomShard)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 0 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.AtaruDust)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 0 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(ItemHandler.AtaruIngot)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 0 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.OxaxagiteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 0 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.BlackHoleOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", -277 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.SiveniumOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 2 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherSiveniumOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 2 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.AyzaniteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 12 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherAyzaniteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 12 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.AurineOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 120 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherAurineOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 120 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.IturiteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 154 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherIturiteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 154 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NodemiteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 160 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherNodemiteOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 160 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.DraxateOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 600 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherDraxateOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 600 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.EukavoyntOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 874 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherEukavoyntOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 874 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.PhantomOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 0 + "");
		System.out.println(FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", new ItemStack(BlockHandler.NetherPhantomOre)));
		FMLInterModComms.sendMessage("craftmatter", "MATTER_VALUE_REGISTRATION", 0 + "");
	}

}
