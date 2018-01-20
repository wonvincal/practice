package com.calvin.educative.io;

public class LargestSumArray {
	public int find(int[] items){
		boolean isPos = (items[0] >= 0);
		
		long max = 0;
		long currentMax = 0;
		long currentSumNeg = 0;
		long currentSumPos = 0;
		if (isPos){
			currentSumPos = items[0];
		}
		else {
			currentSumNeg = items[0];
		}
		for (int i = 1; i < items.length; i++){
			boolean currentPos = (items[i] >= 0);
			if (isPos != currentPos){
				
			}
			else {
				if (isPos){
					currentSumPos += items[i];
				}
				else {
					currentSumNeg += items[i];
				}
			}
		}
		return 0;
	}
}
