package com.calvin.cake;

public class MergeSorted {
	public static int[] merge(int[] sorted1, int[] sorted2){
		int[] result = new int[sorted1.length + sorted2.length];
		
		// First answer: for each new element, pick from one of the arrays
		int i = 0;
		int sorted1Index = 0;
		int sorted2Index = 0;
		while (i < result.length && sorted1Index < sorted1.length && sorted2Index < sorted2.length){
			if (sorted1[sorted1Index] <= sorted2[sorted2Index]){
				result[i++] = sorted1[sorted1Index++];
			}
			else{
				result[i++] = sorted2[sorted2Index++];
			}
		}
		if (i < result.length){
			if (sorted1Index < sorted1.length){
				for (; i < result.length; i++){
					result[i] = sorted1[sorted1Index++];
				}
			}
			else {
				// remaining in sorted2
				for (; i < result.length; i++){
					result[i] = sorted2[sorted2Index++];					
				}
			}
		}
		return result;
	}
}
