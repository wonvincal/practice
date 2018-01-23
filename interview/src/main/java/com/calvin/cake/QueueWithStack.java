package com.calvin.cake;

import java.util.Stack;

public class QueueWithStack {
	private final Stack<Integer> inStack = new Stack<>();
	private final Stack<Integer> outStack = new Stack<>();
	
	public void enqueue(Integer value){
		inStack.push(value);
		
		// Put value at the bottom of the stack
//		while (!inStack.isEmpty()){
//			outStack.push(inStack.pop());
//		}
//		inStack.push(value);
//		while (!outStack.isEmpty()){
//			inStack.push(outStack.pop());
//		}
	}
	
	public Integer dequeue(){
		if (outStack.isEmpty()){
			while (!inStack.isEmpty()){
				outStack.push(inStack.pop());
			}
		}
		
		if (outStack.isEmpty()){
			throw new RuntimeException("Queue is empty");
		}
		
		return outStack.pop();
	}
}
