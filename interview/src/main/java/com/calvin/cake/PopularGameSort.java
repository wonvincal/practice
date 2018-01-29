package com.calvin.cake;

/**
Write a method that takes:

an array of unsortedScores
the highestPossibleScore in the game
and returns a sorted array of scores in less than O(n\lg{n})O(nlgn) time.
 * 
 */
public class PopularGameSort {
	public static void sortScores(int[] rawScores, int topScore){
		int[] freqs = new int[topScore + 1];
		for (int rawScore : rawScores){
			freqs[rawScore]++;
		}
		int index = 0;
		for (int i = freqs.length - 1; i >= 0; i--){
			while (freqs[i] != 0){
				rawScores[index] = i;
				index++;
				freqs[i]--;
			}
		}
	}
}
