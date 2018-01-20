package com.calvin.educative.io.stack.queue;

import java.util.ArrayDeque;

public class StackPollFast {
	private ArrayDeque<Object> activeQueue = new ArrayDeque<>();
	private ArrayDeque<Object> inactiveQueue = new ArrayDeque<>();
	
	public void push(Object value){
		// Add to non active queue
		// Poll all items from active queue to non active queue
		// Set active queue = non active queue
		inactiveQueue.add(value);
		
		while (!activeQueue.isEmpty()){
			inactiveQueue.add(activeQueue.poll());
		}

		ArrayDeque<Object> x = activeQueue;
		activeQueue = inactiveQueue;
		inactiveQueue = x;
	}
	
	/**
	 * Poll from head
	 * O(1)
	 * @return
	 */
	public Object pop(){
		return activeQueue.poll();
	}
}
