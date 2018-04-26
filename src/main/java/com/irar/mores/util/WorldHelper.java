package com.irar.mores.util;

import com.irar.mores.entity.EntityAlloyArrow;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class WorldHelper {

	public static double getDistance(World world, Entity ent1, Entity ent2) {
		double x1 = ent1.posX;
		double y1 = ent1.posY;
		double z1 = ent1.posZ;
		double x2 = ent2.posX;
		double y2 = ent2.posY;
		double z2 = ent2.posZ;
		double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
		return distance;
	}
	
	public static float getAngle(double[] pos1, double[] pos2) {
		if(!(pos1.length == pos2.length)) {
			return 0;
		}
		if(pos1.length == 3) {
			double xdif = pos1[0] - pos2[0];
			double ydif = pos1[1] - pos2[1];
			double zdif = pos1[2] - pos2[2];
			double xzdif = Math.sqrt(xdif * xdif + zdif * zdif);
			
			float angle = (float) Math.toDegrees(Math.atan2(ydif, zdif));
			
		    if(angle < 0){
		        angle += 360;
		    }
	
		    return angle;
		}else {
			double xdif = pos1[0] - pos2[0];
			double zdif = pos1[1] - pos2[1];
		    float angle = (float) Math.toDegrees(Math.atan2(zdif, xdif));
		    
		    if(zdif > 0 && zdif > xdif) {
		    	angle -= 90;
		    }
	
		    if(xdif > 0 && xdif > zdif) {
		    	angle += 90;
		    }
	
		    if(zdif < 0 && zdif < xdif) {
		    	angle += 90;
		    }
	
		    if(xdif < 0 && xdif < zdif) {
		    	angle -= 90;
		    }
	
		    if(angle < 0){
		        angle += 360;
		    }
	
		    return angle;
		}
	}
	
	public static float[] getPitchAndYawTo(Entity ent1, Entity ent2) {
		float[] py = new float[] {getAngle(new double[] {ent1.posX, ent1.posY, ent1.posZ}, new double[] {ent2.posX, ent2.posY, ent2.posZ}), getAngle(new double[] {ent1.posX, ent1.posZ}, new double[] {ent2.posX, ent2.posZ})};
		return py;
	}

}
