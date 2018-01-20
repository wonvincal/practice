package com.calvin.educative.io.math;

import java.util.HashSet;
import java.util.List;

public class AllSubsets {
	/**
	 * Use increment of binary number to simulate items[i] to be used in a subset
	 * Key:
	 * 1) Number of subsets = 2^n
	 * 2) Use increment of binary number
	 * @param input
	 * @param currentIndex
	 * @param endIndex
	 * @param c
	 * @param output
	 */
	public static void combination(int[] input, List<HashSet<Integer>> output){
		// Number of subsets
		int n = (int)Math.pow(2, input.length);
		for (int i = 0; i < n; i++){
			HashSet<Integer> result = new HashSet<>();
			for (int at = 0; at < input.length; at++){
				if (getBit(i, at)){
					result.add(input[at]);
				}
			}
			output.add(result);
		}
	}
	
	public static boolean getBit(int number, int index){
		int mask = 0x1;
		mask <<= index;
		return (number & mask) != 0;
	}
	public static int combination(int n, int c){
		if (c == 0 || n == c){
			return 1;
		}
		return combination(n - 1, c - 1) + combination(n - 1, c);
	}
}
