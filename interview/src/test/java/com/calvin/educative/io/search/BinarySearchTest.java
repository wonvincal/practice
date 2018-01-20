package com.calvin.educative.io.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void test(){
		assertEquals(4, BinarySearch.searchIterative(new int[]{1, 2, 5, 6, 8, 10, 30, 36}, 8));
		assertEquals(4, BinarySearch.search(new int[]{1, 2, 5, 6, 8, 10, 30, 36}, 7));
		assertEquals(5, BinarySearch.search(new int[]{1, 2, 5, 6, 8, 10, 30, 36}, 9));
	}
}
