package com.calvin.educative.io.stack.queue;

import java.util.ArrayDeque;

/**
 * Queue is FIFO
 * Stack is LIFO
 * @author Calvin
 *
 */
public class Stack {
	private final ArrayDeque<Object> queue = new ArrayDeque<>();
	private final ArrayDeque<Object> queueTransient = new ArrayDeque<>();
	private ArrayDeque<Object> activeQueue = queue;

	/**
	 * For every push, we want to make sure
	 * @param value
	 * O(1)
	 */
	public void push(Object value){
		activeQueue.add(value);
	}
	
	/**
	 * Poll from head
	 * O(n)
	 * @return
	 */
	public Object pop(){
		if (activeQueue.isEmpty()){
			throw new IllegalStateException("Empty stack: cannot pop");
		}
		
		ArrayDeque<Object> inactiveQueue = activeQueue;
		activeQueue = (activeQueue == queue) ? queueTransient : queue;
		
		while (inactiveQueue.size() > 1){
			activeQueue.add(inactiveQueue.poll());
		}
		return inactiveQueue.poll();
	}
}
