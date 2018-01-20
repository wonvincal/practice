package com.calvin.educative.io;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInMatrixTest {
	@Test
	public void test(){
		int[][] matrix = new int[4][];
		matrix[0] = new int[]{2,4,9,13};
		matrix[1] = new int[]{3,5,11,18};
		matrix[2] = new int[]{6,8,16,21};
		matrix[3] = new int[]{9,11,20,25};
		int[] pos = new int[2];
//		assertTrue(SearchInMatrix.search(matrix, 16, pos));
//		assertEquals(2, pos[0]);
//		assertEquals(2, pos[1]);
//
//		assertTrue(SearchInMatrix.search(matrix, 11, pos));
//		assertEquals(1, pos[0]);
//		assertEquals(2, pos[1]);

		assertTrue(SearchInMatrix.search(matrix, 6, pos));
		assertEquals(2, pos[0]);
		assertEquals(0, pos[1]);
	}
}
