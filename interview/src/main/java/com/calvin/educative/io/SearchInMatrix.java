package com.calvin.educative.io;

public class SearchInMatrix {
	public static boolean searchSimpler(int[][] matrix, int key, int[] pos){
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		
		int row = 0;
		int col = numCol - 1;
		while (row != (numRow - 1) || col != 0){
			int value = matrix[row][col];
			System.out.println("At [" + row + "][" + col + "] = " + value + ", searching for: " + key);
			if (key == value){
				pos[0] = row;
				pos[1] = col;
				return true;
			}
			if (key > value){
				row++;
			}
			else {
				col--;
			}
		}
		return false;
	}
	
	public static boolean search(int[][] matrix, int key, int[] pos){
		return searchSimpler(matrix, key, pos);
	}
	
	public static boolean searchRecursion(int[][] matrix, int key, int rowFrom, int rowTo, int colFrom, int colTo, int[] pos){
		System.out.println("from [" + rowFrom + "][" + colFrom + "] to [" + rowTo + "][" + colTo + "]");
		if (rowFrom > rowTo || colFrom > colTo){
			return false;
		}
		int min = matrix[rowFrom][colFrom];
		if (min == key){
			pos[0] = rowFrom;
			pos[1] = colFrom;
			return true;
		}
		int max = matrix[rowTo][colTo];
		System.out.println("key: " + key + ", min: " + min + ", max: " + max);
		if (key > min && key <= max){
			int numRow = (rowTo - rowFrom) + 1;
			int numCol = (colTo - colFrom) + 1;
			int midRowIndex = numRow/2 + rowFrom;
			int midColIndex = numCol/2 + colFrom;
			if (searchRecursion(matrix, key, rowFrom, midRowIndex - 1, colFrom, midColIndex - 1, pos) 
					|| searchRecursion(matrix, key, rowFrom, midRowIndex - 1, midColIndex, colTo, pos)
					|| searchRecursion(matrix, key, midRowIndex, rowTo, colFrom, midColIndex - 1, pos)
					|| searchRecursion(matrix, key, midRowIndex, rowTo, midColIndex, colTo, pos)){
				return true;
			}
		}
		return false;
	}
}
