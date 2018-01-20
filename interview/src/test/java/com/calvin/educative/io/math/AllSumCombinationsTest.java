package com.calvin.educative.io.math;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.calvin.educative.io.math.AllSumCombinations;

public class AllSumCombinationsTest {
	@Test
	public void test(){
		assertEquals(6, AllSumCombinations.find(5));
		
		List<String> list = AllSumCombinations.findRecursive(10);
		list.forEach((c) -> { System.out.println(c);});
	}
}
