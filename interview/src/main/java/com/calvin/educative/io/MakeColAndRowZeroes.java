package com.calvin.educative.io;

import java.util.stream.IntStream;

public class MakeColAndRowZeroes {
	public static void zeroize(int[][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int[] colUpdates = new int[numCols];
		
		// O(n^2)
		for (int row = 0; row < numRows; row++){
			for (int col = 0; col < numCols; col++){
				if (matrix[row][col] == 0){
					// make all cells in row zero
					// mark this col to be updated to zero
					final int rowToBeZeroized = row;
					IntStream.range(0, numCols).forEach((n) -> {matrix[rowToBeZeroized ][n] = 0;});
					colUpdates[col] = 1;
					break;
				}
			}
		}
		// O(n^2)
		for (int i = 0; i < colUpdates.length; i++){
			if (colUpdates[i] == 1){
				final int col = i;
				IntStream.range(0, numRows).forEach((n) -> {
					matrix[n][col] = 0;
				});
			}
		}
	}	
}
