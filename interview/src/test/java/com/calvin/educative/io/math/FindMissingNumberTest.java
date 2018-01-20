package com.calvin.educative.io.math;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.educative.io.math.FindMissingNumber;

public class FindMissingNumberTest {
	@Test
	public void test(){
		assertEquals(6, FindMissingNumber.findMissing(new int[]{3, 2, 4, 7, 8, 1, 5}, 8));
	}
}
