package com.calvin.educative.io.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PythagTripletsInArray {

	public static List<String> find(int[] items){
		// O(n log n)
		Arrays.sort(items);
		
		// O(n)
		HashSet<Integer> cache = new HashSet<>();
		for (int i = 0; i < items.length; i++){
			cache.add(items[i] * items[i]); 
		}
		
		// O(n^2)
//		ArrayList<String> triplets = new ArrayList<>();
//		for (int i = 0; i < items.length - 2; i++){
//			for (int j = i + 1; j < items.length - 1; j++){
//				int result = items[i]*items[i] + items[j]*items[j];
//				if (cache.contains(result)){
//					triplets.add(items[i] + "," + items[j]);
//				}
//			}
//		}
		
		Iterator<Integer> iterator = cache.iterator();
		ArrayList<String> triplets = new ArrayList<>();
		while (iterator.hasNext()){
			Integer cSquare = iterator.next().intValue();
			int start = 0;
			int end = items.length - 1;
			while (start < end){
				int abSquare = items[start] * items[start] + items[end] * items[end];
				if (abSquare == cSquare){
					triplets.add(items[start] + "," + items[end]);
				}
				if (abSquare > cSquare){
					end--;
				}
				else {
					start++;
				}
			}
		}
		
		return triplets;
	}
}
