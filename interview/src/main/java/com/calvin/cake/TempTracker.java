package com.calvin.cake;

public class TempTracker {
	private int count;
	private double sum;
	private int max;
	private int min;
	private int mode = 0;
	private int[] occurrences;

	public TempTracker(){
		this.occurrences = new int[111];
	}
	
	/**
	 * Validate input
	 * @param fahrenheit
	 * @return
	 */
	public TempTracker insert(int fahrenheit){
		if (fahrenheit < 0 || fahrenheit > 110){
			throw new IllegalArgumentException();
		}
		count++;
		sum += fahrenheit;
		max = Math.max(max, fahrenheit);
		min = Math.min(min, fahrenheit);
		occurrences[fahrenheit]++;
		if (occurrences[fahrenheit] > occurrences[mode]){
			mode = fahrenheit;
		}
		return this;
	}
	
	public int getMax(){
		// Keep track of max
		// vs Heap - heap has O(log n)
		return max;
	}
	
	public int getMin(){
		return min;
	}
	
	public double getMean(){
		return sum / count;
	}
	
	public int getMode(){
		return mode;
	}
}
