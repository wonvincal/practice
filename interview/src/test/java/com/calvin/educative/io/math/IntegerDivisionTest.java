package com.calvin.educative.io.math;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.educative.io.math.IntegerDivision;

public class IntegerDivisionTest {
	@Test
	public void test(){
		assertEquals(10, IntegerDivision.divide(40, 4));
		assertEquals(10, IntegerDivision.divide(43, 4));
		assertEquals(5, IntegerDivision.divide(43, 8));
		assertEquals(25, IntegerDivision.divide(100, 4));
		assertEquals(20, IntegerDivision.divide(100, 5));
		assertEquals(8, IntegerDivision.divide(32, 4));
		assertEquals(4, IntegerDivision.divide(32, 8));
	}
}
