package com.calvin.crack.stack;

import java.util.Arrays;

public class MultiArrayStack {
	private int[] indices;
	private int[][] items;
	
	MultiArrayStack(int numStacks, int maxItemPerStack){
		items = new int[numStacks][maxItemPerStack];
		indices = new int[numStacks];
		Arrays.fill(indices, -1);
	}
	
	public void push(int stackIndex, int value){
		int index = indices[stackIndex];
		if (index < items[stackIndex].length - 1){
			index++;
			indices[stackIndex] = index;
			items[stackIndex][index] = value;
		}
		throw new RuntimeException("Stack " + stackIndex+ " is full");
	}
	
	public int pop(int stackIndex){
		int index = indices[stackIndex];
		if (index >= 0){
			int result = items[stackIndex][index];
			indices[stackIndex] = index - 1;
			return result;
		}
		throw new RuntimeException("Stack " + stackIndex+ " is empty");
	}
}
