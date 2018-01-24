package com.irar.mores.world;

import java.util.Random;
import java.util.function.Predicate;

import com.irar.mores.handlers.BlockHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOre implements IWorldGenerator{

	private void genSurface(World world, Random random, int chunkX, int chunkZ){
		addOreSpawn(BlockHandler.PhantomOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 8, 5, 70,  BlockMatcher.forBlock(Blocks.STONE));
		
		addOreSpawn(BlockHandler.AyzaniteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 10, 20, 100,  BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(BlockHandler.SiveniumOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 10, 20, 100,  BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(BlockHandler.AurineOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 4, 20, 100,  BlockMatcher.forBlock(Blocks.STONE));

		addOreSpawn(BlockHandler.IturiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 1, 30, 50,  BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(BlockHandler.NodemiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 2, 30, 50,  BlockMatcher.forBlock(Blocks.STONE));
		
		addOreSpawn(BlockHandler.DraxateOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 1, 5, 30,  BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(BlockHandler.EukavoyntOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 8, 1, 5, 70,  BlockMatcher.forBlock(Blocks.STONE));

		addOreSpawn(BlockHandler.BlackHoleOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 8, 1, 5, 120,  BlockMatcher.forBlock(Blocks.STONE));

//		addOreSpawn(BlockHandler.OxaxagiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 4, 10, 40,  BlockMatcher.forBlock(Blocks.STONE));
	}
	private void genNether(World world, Random random, int chunkX, int chunkZ){
		addOreSpawn(BlockHandler.NetherPhantomOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 8, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
		
		addOreSpawn(BlockHandler.NetherAyzaniteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 10, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
		addOreSpawn(BlockHandler.NetherSiveniumOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 10, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
		addOreSpawn(BlockHandler.NetherAurineOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 4, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));

		addOreSpawn(BlockHandler.NetherIturiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 1, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
		addOreSpawn(BlockHandler.NetherNodemiteOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 2, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
		
		addOreSpawn(BlockHandler.NetherDraxateOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 10, 1, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
		addOreSpawn(BlockHandler.NetherEukavoyntOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, 8, 1, 5, 100,  BlockMatcher.forBlock(Blocks.NETHERRACK));
	}
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chance, int minY, int maxY, BlockMatcher blockToSpawnIn){
		int diffMinMaxY = maxY - minY;
		for(int x = 0; x < chance; x++){
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(diffMinMaxY);
			int posZ = blockZPos + random.nextInt(maxZ);
//			System.out.println(posX+", "+posY+", "+posZ);
			(new WorldGenMinable(block, maxVeinSize, blockToSpawnIn)).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case 0:
			genSurface(world, random, chunkX*16, chunkZ*16);
			break;
		case -1:
			genNether(world, random, chunkX*16, chunkZ*16);
			break;
		}
	}
}
