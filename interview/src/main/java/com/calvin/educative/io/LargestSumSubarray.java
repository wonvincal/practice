package com.calvin.educative.io;

public class LargestSumSubarray {
	public long find(int[] items){
		// Kadane's Algo
		long currentMax = items[0];
		long globalMax = items[0];
		for (int i = 1; i < items.length; i++){
			int current = items[i];
			if (currentMax < 0){
				// This is for the purpose of negative number
				currentMax = current;
			}
			else {
				currentMax += current;
			}
			if (globalMax < currentMax){
				globalMax = currentMax;
			}
		}
		return globalMax;
	}
}
