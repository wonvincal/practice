package com.calvin.cake;

import java.util.Random;

public class InPlaceShuffle {
	static Random rand = new Random();
	/**
	 * [1, 2]
	 * @param floor
	 * @param ceiling
	 * @return
	 */
	public static int getRandom(int floor, int ceiling){
		return rand.nextInt((ceiling - floor) + 1) + floor;
	}
	/**
	 * Each item has an equal probability to be shuffled to another spot
	 * @param items
	 */
	public static void shuffle(int[] items){
		for (int i = 0; i < items.length; i++){
			int temp = items[i];
			int toIndex = getRandom(i, items.length);
			items[i] = items[toIndex - 1];
			items[toIndex - 1]= temp;
		}
	}

	public static boolean isRiffle(int[] shuffledDeck, int[] half1, int[] half2){
		if (half1.length != half2.length || shuffledDeck.length != (half1.length + half2.length)){
			throw new IllegalArgumentException();
		}
		return isRiffle(shuffledDeck, shuffledDeck.length - 1, half1, half1.length - 1, half2, half2.length - 1);
	}

	private static boolean isRiffle(int[] shuffledDeck, int shuffledDeckIndex, int[] half1, int half1Index, int[] half2, int half2Index){
		// Face card in shuffledDeck is either the face card of half1 or half2
		if (half1Index == half2Index){
			if (half1Index == -1){
				return true;
			}
			if (half1Index >= 0 && shuffledDeck[shuffledDeckIndex] == half1[half1Index]){
				return isRiffle(shuffledDeck, shuffledDeckIndex - 1, half1, half1Index - 1, half2, half2Index);
			}
			else if (half2Index >= 0 && shuffledDeck[shuffledDeckIndex] == half2[half2Index]){
				return isRiffle(shuffledDeck, shuffledDeckIndex - 1, half1, half1Index, half2, half2Index - 1);
			}
			return false;
		}
		else if (half1Index > half2Index) {
			if (half1Index >= 0 && shuffledDeck[shuffledDeckIndex] == half1[half1Index]){
				return isRiffle(shuffledDeck, shuffledDeckIndex - 1, half1, half1Index - 1, half2, half2Index);
			}
			return false;
		}
		else{
			if (half2Index >= 0 && shuffledDeck[shuffledDeckIndex] == half2[half2Index]){
				return isRiffle(shuffledDeck, shuffledDeckIndex - 1, half1, half1Index, half2, half2Index - 1);
			}
			return false;			
		}
	}
}
