package com.calvin.crack.stack;

public class IntArrayStack {
	private int[] items;
	private int current; // current element index
	
	public IntArrayStack(int maxSize){
		items = new int[maxSize];
		current = -1;
	}
	
	public int peek(){
		if (current >= 0){
			return items[current];
		}
		return -1;
	}
	
	public int pop(){
		if (current >= 0){
			return items[current--];
		}
		throw new RuntimeException("No element is available");
	}
	
	public void push(int item){
		if (current < items.length - 1){
			items[++current] = item;
		}		
		// Do we want this to be auto expand?
		new RuntimeException("Exceed maximum size");
	}

}
