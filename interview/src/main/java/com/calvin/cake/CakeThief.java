package com.calvin.cake;

public class CakeThief {
	public static class CakeType {

	    int weight;
	    int value;

	    public CakeType(int weight, int value) {
	        this.weight = weight;
	        this.value  = value;
	    }
	}
	
	public static int maxDuffelBagValue(CakeType[] cakeTypes, int capacity){
		// Coin change, the key is not to loop the same coin again
		Result result = new Result();
		maxDuffelBagValue(cakeTypes, 0, capacity, 0, result);
		
		// Coin change problem with maximum value
		return result.max;
	}
	
	public static class Result{
		int max;
	}
	/**
	 * Try first coin first
	 * @param cakeTypes
	 * @param startIndex
	 * @param capacity
	 * @param totalValue
	 * @return
	 */
	public static void maxDuffelBagValue(CakeType[] cakeTypes, int startIndex, int capacity, int totalValue, Result result){
		if (startIndex >= cakeTypes.length){
			return;
		}
		while (capacity > 0){
			// Pick cakes using other cake types for make up for remaining value
			maxDuffelBagValue(cakeTypes, startIndex + 1, capacity, totalValue, result);

			// Use N x cakeType
			capacity -= cakeTypes[startIndex].weight;			
			totalValue += cakeTypes[startIndex].value;			
		}
		if (capacity == 0){
			result.max = Math.max(result.max, totalValue);
		}
		else if (capacity < 0){
			result.max = Math.max(result.max, totalValue - cakeTypes[startIndex].value);
		}
	}
	
	/**
	 * Iterative: the key is to realize that:
	 * value[N] = cakeType.value + value[N - cakeType.value]
	 * 
	 * @param cakeTypes
	 * @param startIndex
	 * @param capacity
	 * @param totalValue
	 * @param result
	 */
	public static int maxDuffelBagValueIterative(CakeType[] cakeTypes, int startIndex, int capacity, int totalValue){
		if (capacity <= 0){
			return 0;
		}
		
		// Maximum value at each weight
		int max = Integer.MIN_VALUE;				
		int[] capacities = new int[capacity + 1];
//		for (CakeType cakeType : cakeTypes){
//			if (cakeType.weight == 0 || cakeType.value == 0){
//				continue;
//			}
//			for (int i = cakeType.weight; i < capacities.length; i++){
//				if (capacities[i - cakeType.weight] != 0 || (i - cakeType.weight) == 0){
//					capacities[i] = Math.max(capacities[i], capacities[i - cakeType.weight] + cakeType.value);
//					max = Math.max(capacities[i], max);
//				}
//			}
//		}
		for (int i = 0; i < capacities.length; i++){
			for (CakeType cakeType : cakeTypes){
				if (cakeType.value == 0 || cakeType.weight == 0){
					throw new RuntimeException();
				}
				if (cakeType.weight <= i){
					capacities[i] = Math.max(capacities[i], capacities[i - cakeType.weight] + cakeType.value);
					max = Math.max(max, capacities[i]);
				}
			}
		}
		return max;
	}
}
