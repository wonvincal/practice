package com.calvin.educative.io.search;

public class BinarySearch {
	public static int search(int[] items, int key){
		return search(items, key, 0, items.length - 1);
	}

	public static int searchIterative(int[] items, int key){
		int startIndex = 0;
		int endIndex = items.length - 1;
		int mid = -1;
		while (startIndex <= endIndex){
			mid = (startIndex + endIndex) / 2;
			int element = items[mid];
			if (element == key){
				return mid;
			}			
			if (element < key){
				startIndex = mid + 1;
			}
			else {
				endIndex = mid - 1;
			}			
		}
		return mid;
	}
	
	public static int search(int[] items, int key, int startIndex, int endIndex){
		if (startIndex > endIndex){
			return startIndex;
		}
		
		int mid = (startIndex + endIndex) / 2;
		
		int element = items[mid];
		if (element == key){
			return mid;
		}
		
		if (element < key){
			return search(items, key, mid + 1, endIndex);
		}
		else {
			return search(items, key, startIndex, mid - 1);			
		}
	}
}
