package com.calvin.educative.io.math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * There are two ways to handle these coin change problem.
 * Using a stack can help us for output of result, otherwise we will need to use O(n^n) of memory 
 * 
 * Using bottom-up dynamic programming, i can attempt to create output again.
 * 
 * The most important key of this problem is to figure out that the individual coin needs to be tried 
 * in the increasing order.
 * 
 * Optimization:
 * 1) When you add to a sum and the value exceeds target, we can return right away, because that function
 * is DONE.
 * @author Calvin
 *
 */
public class AllSumCombinations {
	
	public static List<String> findRecursive(int sum){
		List<String> output = new ArrayList<String>();
		findRecursive(1, 0, sum, new Stack<>(), output);
		return output;
	}
	
	public static void findRecursive(int start, int sum, int target, Stack<Integer> path, List<String> output){
		if (sum == target){
			// We got it
			Iterator<Integer> iterator = path.iterator();
			StringBuilder builder = new StringBuilder();
			while (iterator.hasNext()){
				builder.append(iterator.next().toString());
			}
			output.add(builder.toString());
			return;
		}
		
		if (sum > target){
			return;
		}
		
		for (int i = start; i < target; i++){
			int new_sum = sum + i;
			if (new_sum <= target){
				path.push(i);
				findRecursive(i, new_sum, target, path, output);
				path.pop();
			}
			else {
				return;
			}
		}
	}
	
	public static int find(int sum){
		int[] sums = new int[sum + 1];
		sums[0] = 1;
		for (int coin = 1; coin < sum; coin++){
			for (int i = coin; i <= sum; i++){
				sums[i] += sums[i - coin];
			}
		}
		return sums[sum];
	}
}
