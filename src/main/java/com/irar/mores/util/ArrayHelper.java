package com.irar.mores.util;

import java.util.Collection;

public class ArrayHelper {

	public static <T> boolean contains(Collection<T> c, T obj) {
		for(T t : c) {
			if(t == obj || (t instanceof Object && obj instanceof Object && t.equals(obj))) {
				return true;
			}
		}
		return false;
	}
	
	public static <T> boolean contains(T[] c, T obj) {
		for(T t : c) {
			if(t == obj || (t instanceof Object && obj instanceof Object && t.equals(obj))) {
				return true;
			}
		}
		return false;
	}
	
}
