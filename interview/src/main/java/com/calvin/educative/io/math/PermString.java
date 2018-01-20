package com.calvin.educative.io.math;

/**
 * Permutation: concept of fix and swap, so that we can try out all permutations
 * @author Calvin
 *
 */
public class PermString {
	public static void list(String source){
		char[] input = source.toCharArray();
		permutate(input, 0, input.length - 1);
	}
	
	public static void permutate(char[] input, int currentIndex, int endIndex){
		if (endIndex == currentIndex){
			// Found
			System.out.println(input);
			return;
		}
		for (int i = currentIndex; i <= endIndex; i++){
			swap(input, currentIndex, i);
			permutate(input, currentIndex + 1, endIndex);
			swap(input, currentIndex, i);
		}
	}
	
	public static void swap(char[] input, int fromIndex, int toIndex){
		char temp = input[fromIndex];
		input[fromIndex] = input[toIndex];
		input[toIndex] = temp;
		
		// No temporary field
	}
}
