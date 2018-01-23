package com.calvin.cake;

import java.util.Arrays;
import java.util.HashSet;

public class MoviesPicker {
	/**
	 * O(n)
	 * Space: O(n)
	 * @param flightLength
	 * @param movieLengths
	 * @return
	 */
	public static boolean select(int flightLength, int movieLengths[]){
		HashSet<Integer> lengths = new HashSet<>();
		for (int i = 0; i < movieLengths.length; i++){
			int remaining = flightLength - movieLengths[i];
			if (lengths.contains(remaining)){
				return true;
			}
			lengths.add(movieLengths[i]);
		}
		return false;
	}
	
	/**
	 * n log n
	 * 
	 * +
	 * 
	 * n / 2
	 * 
	 * O(n log n)
	 * 
	 * Space: O(1)
	 * @param flightLength
	 * @param movieLengths
	 * @return
	 */
	public static boolean selectPivot(int flightLength, int movieLengths[]){
		Arrays.sort(movieLengths);
		
		int begin = 0;
		int end = movieLengths.length - 1;
		while (begin < end){
			int total = movieLengths[begin] + movieLengths[end];
			if (total == flightLength){
				return true;
			}
			if (total > flightLength){
				end--;
			}
			else {
				begin++;
			}
		}
		return false;
	}
}
