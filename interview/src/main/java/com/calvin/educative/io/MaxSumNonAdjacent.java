package com.calvin.educative.io;

/***
 * Breakdown the problem.  One way I confused myself was trying to optimize the problem
 * by thinking about consecutive negative number
 * 
 * 
 * @author Calvin
 *
 */
public class MaxSumNonAdjacent {
	public static long find(int[] items){
		if (items.length == 2){
			return Math.max(items[0], items[1]);
		}
		else if (items.length == 1){
			return items[0];
		}
//		int[] highest = new int[]{Integer.MIN_VALUE};
//		long max = findMaxSum(items, 0, highest);
//		if (max > 0){
//			return max;
//		}
//		return highest[0];
		return simpleFindMax(items, items.length - 1);
	}
	
	public static long simpleFindMax(int[] items, int i){
		if (i == 0){
			return items[0];
		}
		if (i == 1){
			return Math.max(items[0], items[1]);
		}
		return Math.max(items[i], Math.max(items[i] + simpleFindMax(items, i -2), simpleFindMax(items, i -1)));
	}	
	
	
	public static long simpleFindMaxSum(int[] items, int currentIndex){
		if (items.length == currentIndex){
			System.out.println("Here");
			return 0;
		}
		// When there is only one item
		if (items.length - 1 == currentIndex){
			System.out.println("Here 2");
//			return Math.max(items[currentIndex], 0);
			return items[currentIndex];
		}
		return Math.max(
				items[currentIndex] + ((currentIndex + 2 < items.length) ? simpleFindMaxSum(items, currentIndex + 2) : 0), 
				((currentIndex + 1 < items.length) ? simpleFindMaxSum(items, currentIndex + 1) : Integer.MIN_VALUE));
	}
	
	public static long findMaxSum(int[] items, int currentIndex, int[] highest){
		// Two items remaining
		// If all negative, returns least negative.  How to tell if all negative?
		if (items.length - 1 == currentIndex){
			int prev = highest[0];
			highest[0] = Math.max(highest[0], items[currentIndex]);
			if (prev != highest[0]){
				System.out.println("highest got updated from: " + prev + " to " + highest[0]);
			}
			return items[currentIndex];
		}
		else if (items.length - 2 == currentIndex){
			int prev = highest[0];
			int max = Math.max(items[currentIndex], items[currentIndex + 1]);
			highest[0] = Math.max(highest[0], max);
			if (prev != highest[0]){
				System.out.println("highest got updated from: " + prev + " to " + highest[0]
						+ ", item[current]: " + items[currentIndex] + ", item[current + 1]: " + items[currentIndex+ 1]);
			}
			return max;
		}
		highest[0] = Math.max(Math.max(highest[0], items[currentIndex]), items[currentIndex+1]);
		// Skip any element <= 0
		if (items[0] <= 0){
			return findMaxSum(items, currentIndex + 1, highest);
		}
		long max = items[currentIndex] + ((currentIndex + 2 < items.length) ? findMaxSum(items, currentIndex + 2, highest) : 0);
		if (items[currentIndex + 1] > 0){
			long alt = items[currentIndex + 1] + 
					((currentIndex + 3 < items.length) ? findMaxSum(items, currentIndex + 3, highest) : 0);
			if (alt > max){
				max = alt;
			}
		}
		return max;
	}
}
