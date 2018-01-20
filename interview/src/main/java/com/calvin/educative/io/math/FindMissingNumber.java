package com.calvin.educative.io.math;

public class FindMissingNumber {
	public static int findMissing(int[] items, int n){
		int total = n * (n + 1) / 2;
		int actual = 0;
		for (int item : items){
			actual += item;
		}
		return total - actual;
	}
}
