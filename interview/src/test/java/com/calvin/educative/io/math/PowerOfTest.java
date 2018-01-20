package com.calvin.educative.io.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOfTest {
	@Test
	public void test(){
		assertEquals(8, PowerOf.calculate(2, 3), 0.00001);
		assertEquals(32, PowerOf.calculate(2, 5), 0.00001);
		assertEquals(81, PowerOf.calculate(3, 4), 0.00001);
		assertEquals(3.375, PowerOf.calculate(1.5, 3), 0.00001);
		assertEquals(0.25, PowerOf.calculate(2, -2), 0.00001);
	}
}
