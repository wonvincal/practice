package com.calvin.cake;

import java.util.HashSet;

public class DroneFinder {
	public static int[] findMissing(int[] deliveryIds){
		HashSet<Integer> exists = new HashSet<>(deliveryIds.length / 2);
		for (int deliveryId : deliveryIds){
			if (!exists.add(deliveryId)){
				exists.remove(deliveryId);
			}
		}
		return exists.stream().mapToInt(Number::intValue).toArray();
	}
	
	/**
	 * The key is to realize that XOR is commutative and associative
	 * @param deliveryIds
	 * @return
	 */
	public static int findMissingFast(int[] deliveryIds){
		int unique = 0;
		for (int deliveryId : deliveryIds){
			unique ^= deliveryId;
		}
		return unique;
	}
}
