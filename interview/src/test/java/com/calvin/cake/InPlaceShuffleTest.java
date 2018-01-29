package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class InPlaceShuffleTest {
	@Test
	public void test(){
		int[] items = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		InPlaceShuffle.shuffle(items);
		for (int i = 0; i < items.length; i++){
			System.out.print(items[i] + " ");
		}
	}
	
	@Test
	public void testRiffle(){
		int[] items = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] half1 = new int[]{1, 3, 5, 7, 9};
		int[] half2 = new int[]{2, 4, 6, 8, 10};
		assertTrue(InPlaceShuffle.isRiffle(items, half1, half2));
	}
}
