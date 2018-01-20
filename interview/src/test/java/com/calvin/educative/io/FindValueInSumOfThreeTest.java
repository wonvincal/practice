package com.calvin.educative.io;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FindValueInSumOfThreeTest {
	@Test
	public void test(){
		assertTrue(FindValueInSumOfThree.find(new int[]{3, 7, 1, 2, 8, 4, 5}, 20));
	}
}
