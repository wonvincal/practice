package com.calvin.crack.stack;

public class ComparableArrayStack<T extends Comparable<T>> {
	private ArrayStack<T> mins;
	private ArrayStack<T> items;
	private T min;
	
	public ComparableArrayStack(Class<T> c, int maxSize){
		this.mins = new ArrayStack<T>(c, maxSize);
		this.items = new ArrayStack<T>(c, maxSize);
	}
	
	public T min(){
		return min;
	}

	public void push(T item){
		if (this.min == null || this.min.compareTo(item) > 0){
			this.min = item;
		}
		this.mins.push(this.min);
		this.items.push(item);
	}
	
	public T pop(){
		this.mins.pop();
		this.min = this.mins.peek();
		return this.items.pop();
	}
}
