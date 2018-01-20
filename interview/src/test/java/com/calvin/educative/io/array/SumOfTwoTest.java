package com.calvin.educative.io.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumOfTwoTest {
	@Test
	public void test(){
		assertTrue(SumOfTwo.find(new int[]{5, 7, 1, 2, 8, 4, 3}, 10));
		assertTrue(SumOfTwo.find(new int[]{-5, -7, 10, 20, 8, 4, 3}, -4));
	}
}
