package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibTest {
	@Test
	public void test(){
		assertEquals(3, Fib.calculate(4));
		assertEquals(3, Fib.calculateIterative(4));
	}
}
