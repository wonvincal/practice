package com.calvin.educative.io;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class FibonacciTest {
	@Test
	public void testArrayList(){
		ArrayList<Integer> items = new ArrayList<Integer>();
		items.set(5, 1);
		items.get(0);
	}
	@Test
	public void test(){
		// n = 1, 2, 3, 4, 5, 6, 7, 8
		// r = 1, 1, 2, 3, 5, 8, 13, 21
		assertEquals(5, Fibonacci.calculate(5));
		assertEquals(21, Fibonacci.calculate(8));
	}
}
