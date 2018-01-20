package com.calvin.educative.io.math;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.calvin.educative.io.math.FindKthPermutation;

public class FindKthPermutationTest {
	@Test
	public void test(){
//		int[] result = FindKthPermutation.findK(new int[]{1,  2, 3}, 5);
//		ArrayList<Integer> result = new ArrayList<>();
//		FindKthPermutation.findKSmart(new int[]{1, 2, 3}, 5, result);
		List<Character> items = new ArrayList<Character>();
		items.add('1');
		items.add('2');
		items.add('3');
		StringBuilder result = new StringBuilder();
		FindKthPermutation.findKSmartLib(items, 5, result);
		System.out.println(result.toString());
	}
}
