package com.calvin.educative.io;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxSumNonAdjacentTest {
	@Test
	public void test(){
		assertEquals(9, MaxSumNonAdjacent.find(new int[]{1, -1, 6, -4, 2, 2}));
		assertEquals(25, MaxSumNonAdjacent.find(new int[]{1, 6, 10, 14, -5, -1, 2, -1, 3}));
		assertEquals(-3, MaxSumNonAdjacent.find(new int[]{-4, -3, -5}));
		assertEquals(0, MaxSumNonAdjacent.find(new int[]{-8, -1, 0, -2, -4, -3, -5}));
		assertEquals(-2, MaxSumNonAdjacent.find(new int[]{-8, -5, -2, -3, -4, -3, -5}));
	}
}
