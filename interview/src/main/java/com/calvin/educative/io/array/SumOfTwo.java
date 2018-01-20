package com.calvin.educative.io.array;

import java.util.Arrays;
import java.util.HashSet;

public class SumOfTwo {
	public static boolean find(int[] items, int value){
		return findByPivot(items, value);
	}
	
	/**
	 * Runtime: O(n)
	 * Memory: O(n)
	 * @param items
	 * @param value
	 * @return
	 */
	public static boolean findByHash(int[] items, int value){
		HashSet<Integer> visited = new HashSet<Integer>(items.length);
		
		for (int i = 0; i < items.length; i++){
			visited.add(items[i]);
			int diff = value = items[i];
			if (visited.contains(diff)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * O(n log n) - to sort
	 * O(n) to traverse and pivot
	 * Runtime: Overall O(n log n)
	 * Memory: O(1)
	 * Moving sum > value, move from right to left to make the sum smaller
	 * Moving sum < value, move from left to right to make the sum larger
	 * @param items
	 * @param value
	 * @return
	 */
	public static boolean findByPivot(int[] items, int value){
		// O(log N)
		Arrays.sort(items);
		int i = 0;
		int j = items.length - 1;
		while (i != j){
			int result = items[i] + items[j];
			if (result == value){
				return true;
			}
			if (result > value){
				j--;
			}
			else {
				i++;
			}
		}
		return false;
	}
}
