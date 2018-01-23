package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoinChangeTest {
	@Test
	public void test(){
		assertEquals(4, CoinChange.changePossibilitiesTopDown(4, new int[]{3, 2, 1}));
		assertEquals(2, CoinChange.changePossibilitiesTopDown(6, new int[]{3, 2}));
		assertEquals(2, CoinChange.calculateNumWays(6, new int[]{2, 3}, 0));

	}
}
