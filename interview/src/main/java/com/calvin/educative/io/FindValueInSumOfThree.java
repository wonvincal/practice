package com.calvin.educative.io;

import java.util.Arrays;

/**
 * 1) Brute force: O(n^2)
 * 2) Binary search: O(n^2 log n)
 * 3) If we use hashset to hold all items, and find the diff from hash.  Then we
 *    can bring down to O(n^2)
 * 4) If use use pivot way, after n2
 * @author Calvin
 *
 */
public class FindValueInSumOfThree {
	public static boolean find(int[] items, int target){
		return findPivot(items, target);
	}

	public static boolean findFaster(int[] items, int target){
		Arrays.sort(items);
		// This way of traverse
		boolean found = false;
		for (int i = 0; i < items.length - 2; i++){
			for (int j = i + 1; j < items.length - 1; j++){
				int searchFor = target - items[i] - items[j];
				int k = Arrays.binarySearch(items, searchFor);
				if (k > 0 && k != i && k != j){
					return true;
				}
			}
		}
		return found;
		
	}
	
	public static boolean findNaive(int[] items, int target){
		// This way of traverse
		int result = -1;
		boolean found = false;
		for (int i = 0; i < items.length - 2; i++){
			for (int j = i + 1; j < items.length - 1; j++){
				for (int k = j + 1; k < items.length; k++){
					if (k == i || k == j){
						continue;
					}
					result = items[i] + items[j] + items[k];
					if (result > target){
						break;
					}
					if (result == target){
						found = true;
						break;
					}
				}
			}
		}
		return found;		
	}

	public static boolean findPivot(int[] items, int target){
		Arrays.sort(items);
		
		for (int i = 0; i < items.length - 2; i++){
			int remaining = target - items[i];
			if (pivotFind(items, i+1, remaining)){
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean pivotFind(int[] items, int startIndex, int value){
		int left = startIndex;
		int right = items.length - 1;
		
		while (left < right){
//			if (left == excludeIndex || right == excludeIndex){
//				if ((items[left] + items[right])> value){
//					right--;
//				}
//				else {
//					left++;
//				}
//		 		continue;
//			}
			int leftItem = items[left];
			int rightItem = items[right];
			int sum = leftItem + rightItem;
			if (sum == value){
				return true;
			}
			if (sum > value){
				right--;
			}
			else {
				left++;
			}
		}
		return false;
	}
}
