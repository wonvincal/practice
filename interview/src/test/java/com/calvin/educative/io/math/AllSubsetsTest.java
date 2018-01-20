package com.calvin.educative.io.math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.calvin.educative.io.math.AllSubsets;

public class AllSubsetsTest {
	@Test
	public void test(){
		assertEquals(10, AllSubsets.combination(5, 2));
		List<HashSet<Integer>> output = new ArrayList<HashSet<Integer>>();
		AllSubsets.combination(new int[]{2, 5, 7}, output);
		output.forEach((s) -> { System.out.println(s);});
	}
}
