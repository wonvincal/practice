package com.calvin.cake;

import java.util.Stack;
import java.util.TreeMap;

public class MaxStack {
	private final Stack<Integer> stack = new Stack<>();
	private final Stack<Integer> maxStack = new Stack<>();
	private final TreeMap<Integer, Integer> tree = new TreeMap<>();
	private int max = Integer.MIN_VALUE;

	
	
	/**
	 * O(log n)
	 * @return
	 */
	public void push(Integer item){
		stack.push(item);
		
		if (item >= max){
			maxStack.push(item);
			max = item;
		}		
//		Integer value = tree.get(item);
//		if (value == null){
//			tree.put(item, 1);
//		}
//		else {
//			tree.put(item, 1 + value);
//		}
//		max = Math.max(max, item);
	}
	
	/**
	 * O(log n)
	 * @return
	 */
	public Integer pop(){
		Integer item = stack.pop();
		
		if (item.intValue() == max){
			maxStack.pop();
			max = maxStack.peek();
		}
		
//		Integer value = tree.get(item);
//		value = value - 1;
//		if (value == 0){
//			// Find the next max item
//			tree.remove(item);
//			max = tree.lastKey();
//		}
//		else {
//			tree.put(item, value);
//		}
		return item;
	}
	
	public int getMax(){
		return max;
	}
}
