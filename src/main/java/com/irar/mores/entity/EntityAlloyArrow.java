package com.irar.mores.entity;

import com.irar.mores.util.ArrowHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityAlloyArrow extends EntityTippedArrow{

	public int ingotData;
	
	public EntityAlloyArrow(World worldIn, EntityLivingBase shooter, int ingotData) {
		super(worldIn, shooter);
		this.ingotData = ingotData;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
        if (this.inGround){
        	ArrowHelper.arrowHit(this);
        }else {
        	ArrowHelper.duringFlight(this);
        }
	}
	
	@Override
    protected void arrowHit(EntityLivingBase living)
    {
        ArrowHelper.arrowHit(this, living);
        super.arrowHit(living);
    }
    
}
