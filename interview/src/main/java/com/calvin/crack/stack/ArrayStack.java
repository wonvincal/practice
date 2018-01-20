package com.calvin.crack.stack;

import java.lang.reflect.Array;

public class ArrayStack<T> {
	private T[] items;
	private int current; // current element index
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Class<T> c, int maxSize){
		items = (T[])Array.newInstance(c, maxSize);
		current = -1;
	}
	
	public T peek(){
		if (current >= 0){
			return items[current];
		}
		return null;
	}
	
	public T pop(){
		if (current >= 0){
			return items[current--];
		}
		throw new RuntimeException("No element is available");
	}
	
	public void push(T item){
		if (current < items.length - 1){
			items[++current] = item;
		}		
		// Do we want this to be auto expand?
		new RuntimeException("Exceed maximum size");
	}
}
