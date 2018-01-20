package com.calvin.educative.io.math;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.educative.io.math.IsStringValidNumber;

public class IsStringValidNumberTest {
	@Test
	public void test(){
		assertTrue(IsStringValidNumber.isValid("0.001"));
		assertFalse(IsStringValidNumber.isValid("0.0.001"));
		assertTrue(IsStringValidNumber.isValid("-0.001"));
		assertFalse(IsStringValidNumber.isValid("-.001"));
	}
}
