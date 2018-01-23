package com.calvin.cake;

public class RotationPoint {
	public static int findRotationPoint(String[] words, int beginIndex, int endIndex){
		// Divide by three
		// Check if two words
		if (endIndex - beginIndex == 1){
			// xmin, apple
			return (words[beginIndex].compareTo(words[endIndex]) > 0) ? beginIndex : -1;
		}
		if (endIndex - beginIndex == 2){
			int index = findRotationPoint(words, beginIndex, beginIndex + 1);
			if (index == -1){
				index = findRotationPoint(words, beginIndex + 1, endIndex);
			}
			return index;
		}
		// 3, 4, 5, 6
		int space = endIndex - beginIndex + 1;
		space = space / 3; // 1
		int mid1 = beginIndex + space; // 1
		int mid2 = mid1 + space;  // 2

		int index;
		// Found the right section
		if (words[mid1].compareTo(words[mid2]) > 0){
			index = findRotationPoint(words, mid1, mid2);
		}
		else if (words[beginIndex].compareTo(words[mid1]) > 0){
			index = findRotationPoint(words, beginIndex, mid1);
		}
		else {
			// (words[mid2].compareTo(words[endIndex]) > 0)
			index = findRotationPoint(words, mid2, endIndex);
		}
		return index;
	}
}
