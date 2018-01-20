package com.calvin.cake;

import java.util.Collections;
import java.util.PriorityQueue;

public class HighestProductThree {
	public static long findHighest(int[] items){
		if (items.length < 3){
			throw new IllegalArgumentException("Need at least 3 elements");
		}
		long highestProdOf2 = items[0] * items[1];
		long lowestProdOf2 = highestProdOf2;
		long highest = Math.max(items[0], items[1]);
		long lowest = Math.min(items[0], items[1]);
		long highestProdOf3 = (long)items[0] * items[1] * items[2]; 
		
		for (int i = 2; i < items.length; i++){
			int current = items[i];
			highestProdOf3 = Math.max(
								Math.max(highestProdOf3, highestProdOf2 * current), 
								lowestProdOf2 * current);
			highestProdOf2 = Math.max(
					Math.max(highestProdOf2, highest * current), 
					lowest * current);
			lowestProdOf2 = Math.min(
					Math.min(lowestProdOf2, highest * current), 
					lowest * current);
			highest = Math.max(current, highest);
			lowest = Math.min(current, lowest);
		}
		
		return highestProdOf3;
	}

	public static long mine(int[] items){
		if (items.length < 3){
			throw new IllegalArgumentException("Need at least 3 elements");
		}
		
		PriorityQueue<Integer> queueMinNeg = new PriorityQueue<Integer>(4);
		PriorityQueue<Integer> queueMax = new PriorityQueue<Integer>(4, Collections.reverseOrder());;
		for (int i = 0; i < items.length; i++){
			queueMax.offer(items[i]);
			if (items[i] < 0){
				queueMinNeg.offer(items[i]);				
			}
		}
		if (queueMinNeg.size() < 2){
			// Overflow
			long max = queueMax.poll();
			max *= queueMax.poll();
			max *= queueMax.poll();
			return max;
		}
		else {
			if (queueMax.isEmpty()){
				// Negative number
				long max = queueMinNeg.poll();
				max *= queueMinNeg.poll();
				max *= queueMinNeg.poll();
				return max;
			}
			else if (queueMax.size() == 1){
				long max = queueMinNeg.poll();
				max *= queueMinNeg.poll();
				max *= queueMax.poll();
				return max;		
			}
			else{
				// Both structures have at least two elements now
				long totalMaxFromNeg = queueMinNeg.poll();
				totalMaxFromNeg *= queueMinNeg.poll();
				long maxPos = queueMax.poll();
				long totalMaxPos = maxPos * queueMax.poll();
				if (totalMaxFromNeg > totalMaxPos){
					return totalMaxFromNeg * maxPos;
				}
				else{
					return totalMaxPos * queueMax.poll();
				}
			}
		}
	}
	
	public static long brute(int[] items){
		// Test for
		// overflow
		// at least three integers
		// sort or not? (double negative == positive)		
		if (items.length < 3){
			throw new IllegalArgumentException("Need at least 3 elements");
		}
		
		long max = -1;
		for (int i = 0; i < items.length; i++){
			for (int j = 0; j < items.length; j++){
				if (j == i){
					continue;
				}
				for (int k = 0; k < items.length; k++){
					if (k == i || k == j){
						continue;
					}
					long current = items[i] * items[j] * items[k];
					if (current > max){
						max = current;
					}
				}
			}
		}
		return max;		
	}
}
