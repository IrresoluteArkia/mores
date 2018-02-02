package com.irar.mores.items;

import java.util.List;

import com.irar.mores.handlers.CreativeTabHandler;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemIngot extends Item {
	
	boolean isBlackMetal = false;
	public int value = 0;
	
	public ItemIngot(String name){
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabHandler.MORES);
	}
	public ItemIngot(String name, boolean isBlackMetal){
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabHandler.MORES);
		this.isBlackMetal = isBlackMetal;
	}
	
    public ItemIngot(String string, int i) {
		this(string);
		this.value = i;
	}
	@Override
    public void addInformation(ItemStack stack, World player, List<String> list, ITooltipFlag par4)
    {
    	if(this.isBlackMetal){
    		list.add("You Can Feel The Metal Shudder");
    		list.add("As It Threatens To Collapse On Itself");
    	}
    	super.addInformation(stack, player, list, par4);
    }
	
/*	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		super.onItemRightClick(worldIn, playerIn, handIn);
		return null;
	}*/
	
}
