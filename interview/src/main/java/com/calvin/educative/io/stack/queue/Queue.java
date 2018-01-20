package com.calvin.educative.io.stack.queue;

import java.util.Stack;

public class Queue {
	private final java.util.Stack<Object> activeStack = new Stack<>(); 
	private final java.util.Stack<Object> altStack = new Stack<>();
	
	Queue(){
		
	}
	
	public void offer(Object item){
		// Move all existing items to altStack
		// Push to activeStack
		// Push all from altStack to activeStack
		while (!activeStack.isEmpty()){
			altStack.push(activeStack.pop());
		}
		activeStack.push(item);
		while (!altStack.isEmpty()){
			activeStack.push(altStack.pop());
		}
	}
	
	public Object poll(){
		return activeStack.pop();
	}
}
