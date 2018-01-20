package com.calvin.educative.io;

import java.util.Arrays;

import org.junit.Test;

public class MakeColAndRowZeroesTest {
	@Test
	public void test(){
		int[][] matrix = new int[3][];
		matrix[0] = new int[5];
		matrix[1] = new int[3];
		matrix[2] = new int[4];
		System.out.println(matrix.length + ", " + matrix[0].length);
	}
	@Test
	public void testRun(){
		int[][] matrix = new int[4][];
		matrix[0] = new int[]{5, 4, 3, 9};
		matrix[1] = new int[]{2, 0, 7, 6};
		matrix[2] = new int[]{1, 3, 4, 0};
		matrix[3] = new int[]{9, 8, 3, 4};
		
		prettify(matrix);
//		System.out.println(Arrays.deepToString(matrix));
		
		MakeColAndRowZeroes.zeroize(matrix);
		
		prettify(matrix);
//		System.out.println(Arrays.deepToString(matrix));
	}
	
	private static void prettify(int[][] matrix){
		String[] tokens = Arrays.deepToString(matrix).split("],");
		Arrays.stream(tokens).forEach((t) -> {System.out.println(t);});
	}
}