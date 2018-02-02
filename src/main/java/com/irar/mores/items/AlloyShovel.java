package com.irar.mores.items;

import java.awt.Color;
import java.util.Random;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.irar.mores.handlers.ItemHandler;
import com.irar.mores.handlers.ToolMaterialHandler;
import com.irar.mores.name.AlloyName;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.Char;

public class AlloyShovel extends AlloyTool{

	public AlloyShovel(String name) {
		super(name, "shovel");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return super.getItemStackDisplayName(stack) + " Shovel";
	}
    
    public boolean canHarvestBlock(IBlockState blockIn)
    {
        Block block = blockIn.getBlock();

        if (block == Blocks.SNOW_LAYER)
        {
            return true;
        }
        else
        {
            return block == Blocks.SNOW;
        }
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (facing != EnumFacing.DOWN && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR && block == Blocks.GRASS)
            {
                IBlockState iblockstate1 = Blocks.GRASS_PATH.getDefaultState();
                worldIn.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

                if (!worldIn.isRemote)
                {
                    worldIn.setBlockState(pos, iblockstate1, 11);
                    itemstack.damageItem(1, player);
                }

                return EnumActionResult.SUCCESS;
            }
            else
            {
                return EnumActionResult.PASS;
            }
        }
    }
    
    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.CLAY && material != Material.CRAFTED_SNOW && material != Material.GRASS && material != Material.GROUND && material != Material.SAND && material != Material.SNOW ? super.getStrVsBlock(stack, state) : getEfficiency(stack);
    }


}
