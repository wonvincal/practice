package com.calvin.cake;

public class FindDuplicateInt {
	public static int find(int[] numbers){
		int n = numbers.length - 1;
		int expectedNormalSum = n* (n + 1) / 2;
		int runningSum = 0;
		for (int i = 0; i < numbers.length; i++){
			runningSum += numbers[i];
		}
		return runningSum - expectedNormalSum;
	}
	public static int findMinSpace(int[] numbers){
		int n = numbers.length - 1;
		
		// At least one number, at least two
		// Simplest answer is to use a hashset
		// Space: O(n)
		
		// Another answer is to use in-place sorting
		// O(n + n log n)
		
		
		int expectedNormalSum = n* (n + 1) / 2;
		int runningSum = 0;
		for (int i = 0; i < numbers.length; i++){
			runningSum += numbers[i];
		}
		return runningSum - expectedNormalSum;
	}
}
