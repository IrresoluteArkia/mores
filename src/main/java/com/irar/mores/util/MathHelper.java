package com.irar.mores.util;

import java.util.Random;

import net.minecraft.util.NonNullList;

public class MathHelper {

	public static double log(double base, double num) {
		return Math.log(num) / Math.log(base);
	}
	
	public static int getSkewedRandom() {
		Random r = new Random();
		int ret = 1;
		while(r.nextBoolean()) {
			ret++;
		}
		return r.nextBoolean() ? ret : - ret;
	}
	
	public static String getRomanNumber(int number) {
	    return String.join("", nCopies(number, "I"))
	            .replace("IIIII", "V")
	            .replace("IIII", "IV")
	            .replace("VV", "X")
	            .replace("VIV", "IX")
	            .replace("XXXXX", "L")
	            .replace("XXXX", "XL")
	            .replace("LL", "C")
	            .replace("LXL", "XC")
	            .replace("CCCCC", "D")
	            .replace("CCCC", "CD")
	            .replace("DD", "M")
	            .replace("DCD", "CM");
	}

	private static NonNullList<String> nCopies(int number, String string) {
		if(number < 0) {
			number = 0;
		}
		return NonNullList.<String>withSize(number, string);
	}
	
	
	
}
