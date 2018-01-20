package com.calvin.educative.io.math;

import java.util.ArrayList;
import java.util.List;

public class FindKthPermutation {
	public static class Result {
		int foundPerm = 0;
		int at;
		final int[] elements;
		
		public Result(int numElements){
			this.foundPerm = 0;
			this.elements = new int[numElements];
			this.at = numElements - 1;
		}
		
		public void prepend(int value){
			this.elements[at] = value;
			at--;
		}
	}
	
	public static int factorial(int n){
		int result = 1;
		for (int i = 2; i <= n; i++){
			result *= i;
		}
		return result;
	}
	
	public static int[] cloneWithout(int[] items, int withoutIndex){
		int[] result = new int[items.length - 1];
		int index = 0;
		for (int i = 0; i < items.length; i++){
			if (i != withoutIndex){
				result[index++] = items[i];
			}
		}
		return result;
	}

	public static void findKSmartLib(List<Character> items, int kth, StringBuilder result){
		if (items.isEmpty()){
			return;
		}
		
		int upToKth = 0;
		int numPermPerBlock = factorial(items.size() - 1);
		int selected = (kth - 1)/ numPermPerBlock;
		result.append(items.get(selected));
		items.remove(selected);

		kth = kth - (numPermPerBlock * selected);
		findKSmartLib(items, kth, result);
	}

	public static void findKSmart(int[] items, int kth, ArrayList<Integer> result){
		int numPermPerBlock = factorial(items.length - 1);
		int upToKth = 0;
		if (items.length == 1){
			result.add(items[0]);
			return;
		}
		
		for (int i = 0; i < items.length; i++){
			if (upToKth < kth && kth <= (upToKth + numPermPerBlock)){
				result.add(items[i]);				
				findKSmart(cloneWithout(items, i), kth - upToKth, result);
				break;
			}
			upToKth += numPermPerBlock;
		}
	}
	
	public static int[] findK(int[] items, int kth){
		Result result = new Result(items.length);
		if (findK(items, kth, result)){
			return result.elements;
		}
		return null;
	}
	
	public static boolean findK(int[] items, int kth, Result result){
		if (items.length == 1){
			result.foundPerm++;
			if (result.foundPerm == kth){
				result.prepend(items[0]);
				return true;
			}
			return false;
		}
		for (int i = 0; i < items.length; i++){
			// Create an element list with one less item
			int[] oneLess = new int[items.length - 1];
			int index = 0;
			for (int j = 0; j < items.length; j++){
				if (j != i){
					oneLess[index] = items[j];
					index++;
				}
			}
			if (findK(oneLess, kth, result)){
				result.prepend(items[i]);
				return true;
			}
		}
		return false;
	}
}
