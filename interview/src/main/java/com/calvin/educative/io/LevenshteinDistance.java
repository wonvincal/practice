package com.calvin.educative.io;

import java.util.Arrays;

public class LevenshteinDistance {
	public static int findDistance(String start, String end){
		return 0;
	}
	public static int findDistanceBrute(String start, String end){
		if (start.compareTo(end) == 0){
			return 0;
		}
		char[] startChars = start.toCharArray();
		char[] endChars = end.toCharArray();
		int min = 0;
		for (int i = 0; i < startChars.length; i++){
			if (startChars[i] != endChars[i]){
				char[] clone = Arrays.copyOf(startChars, startChars.length);
				clone[i] = endChars[i];
				min = Math.min(min, 1 + findDistanceBrute(new String(clone), end));
			}
		}
		return min;
	}
}
