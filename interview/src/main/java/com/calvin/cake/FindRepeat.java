package com.calvin.cake;

public class FindRepeat {
	/**
	 * Find repeat item in the array.
	 * Space: O(1)
	 * @param items
	 */
	public static int beastMode(int[] items){
		// There are n + 1 items
		// The range of items is 1..n
		
		// One-base position
		// 1) Make sure you are in a cycle (since there are n+1 items, you must be 
		//    in a cycle after n moves
		int pos = items.length;
		for (int i = 0; i < items.length; i++){
			int index = pos - 1;
			int nextPos = items[index];
			int nextIndex = nextPos - 1;
			if (items[nextIndex] == nextPos){
				// Duplicate is found
				return nextPos;
			}
			pos = nextPos;
		}

		// 2) Find the size of loop
		int startValue = items[pos - 1];
		int nextPos = startValue;
		int length = 1;
		while (items[nextPos - 1] != startValue){			
			nextPos = items[nextPos - 1];
			length++;
		}
				
		// 3) Restart from the head of the list and with n-unit-wide-stick.  Stop
		//    at where head == end, that's the duplicate
		int stickBeginPos = items.length;
		int stickEndPos = items[stickBeginPos - 1];
		for (int i = 1; i < length; i++){
			stickEndPos = items[stickEndPos - 1];
		}
		
		while (items[stickBeginPos - 1] != items[stickEndPos - 1]){
			stickBeginPos = items[stickBeginPos - 1];
			stickEndPos = items[stickEndPos - 1];
		}
		
		return items[stickEndPos - 1];
		// *) During the process, if the item references itself, duplicate is found
	}
}
