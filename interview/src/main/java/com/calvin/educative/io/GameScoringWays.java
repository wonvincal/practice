package com.calvin.educative.io;

import java.util.Arrays;

public class GameScoringWays {
	public static int findWays(int n){
		int[] results = new int[n + 1];
		Arrays.fill(results, -1);
		results[0] = 1;
		return findWays(n, results);
	}
	/***
	 * Top to bottom way
	 * @param n
	 * @param results
	 * @return
	 */
	public static int findWays(int n, int[] results){
		if (n < 0){
			return 0;
		}

//		if (n == 0){
//			return 1;
//		}
		if (results[n] != -1){
			return results[n];
		}
		
		
		results[n] = findWays(n - 1, results) + findWays(n - 2, results) + findWays(n - 4, results);
		return results[n];
//		int result4 = 0, result2 = 0, result1 = 0;
//		if (n - 4 >= 0){
//			result4 = results[n - 4];
//			if (results[n - 4] == -1){
//				result4 = findWays(n - 4);
//				results[n - 4] = result4;
//			}
//		}
//		if (n - 2 >= 0){
//			result2 = results[n - 2];
//			if (result2 == -1){
//				result2 = findWays(n - 2);
//				results[n - 2] = result2;
//			}
//		}
//		if (n - 1 >= 0){
//			result1 = results[n - 1];
//			if (result1 == -1){
//				result1 = findWays(n - 1);
//				results[n - 1] = result1;
//			}
//		}
//		return result4 + result2 + result1;
	}
}
