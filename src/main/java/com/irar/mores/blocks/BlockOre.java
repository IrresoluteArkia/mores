package com.irar.mores.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.irar.mores.handlers.CreativeTabHandler;
import com.irar.mores.handlers.ItemHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOre extends Block{

	boolean opCu;
	String name;
	Item drop;
	private boolean isSpecialDrop = true;
	
	public BlockOre(String name, Material materialIn, float hardness, float resistance, int harvestLevel, String tool, boolean opCu, Item drop) {
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		if((name == "phantom_ore" || name == "nether_phantom_ore")){}else{
			this.setHarvestLevel(tool, harvestLevel);
		}
		this.setCreativeTab(CreativeTabHandler.MORES);
		this.opCu=opCu;
		this.name=name;
		this.drop=drop;
	}
	public BlockOre(String name, Material materialIn, float hardness, float resistance, int harvestLevel, String tool, boolean opCu) {
		super(materialIn);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setHardness(hardness);
		this.setResistance(resistance);
		if((name == "phantom_ore" || name == "nether_phantom_ore")){}else{
			this.setHarvestLevel(tool, harvestLevel);
		}
		this.setCreativeTab(CreativeTabHandler.MORES);
		this.opCu=opCu;
		this.name=name;
		this.drop=null;
		this.isSpecialDrop  = false;
	}
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		if(this.isSpecialDrop){
			return this.drop;
		}else{
			return super.getItemDropped(state, rand, fortune);
		}
	}
	@Override
	public boolean isOpaqueCube(IBlockState defaultBlockState){
		return opCu;
	}
	@Override
	public boolean isFullCube(IBlockState defaultBlockState){
		return opCu;
	}
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
    	if(!opCu){
    		return BlockRenderLayer.TRANSLUCENT;
    	}
    	else{
    		return BlockRenderLayer.SOLID;
    	}
    }
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        if((name == "phantom_ore" || name == "nether_phantom_ore")){
            return NULL_AABB;
        }else{
        	return FULL_BLOCK_AABB;
        }
    }
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if ((name == "phantom_ore" || name == "nether_phantom_ore") && !worldIn.isRemote && stack.getItem().hasEffect(stack))
        {
            player.addStat(StatList.getBlockStats(this));
            spawnAsEntity(worldIn, pos, new ItemStack(ItemHandler.PhantomShard, 1));
            spawnAsEntity(worldIn, pos, new ItemStack(ItemHandler.PhantomShard, 1));
            spawnAsEntity(worldIn, pos, new ItemStack(ItemHandler.PhantomShard, 1));
            spawnAsEntity(worldIn, pos, new ItemStack(ItemHandler.PhantomShard, 1));
        }else if((name == "phantom_ore" || name == "nether_phantom_ore")){
        	
        }
        else
        {
        	
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }
    @Override
    public void addInformation(ItemStack stack, World player, List<String> list, ITooltipFlag par4)
    {
    	if((name == "phantom_ore" || name == "nether_phantom_ore")){
    		list.add("Mine this with enchanted items");
    	}
    }
}
