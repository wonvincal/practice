package com.calvin.crack.stack;

/*
 * 12345
 * 
 * 1 then 2 then 3 then 4 then 5
 * 
 * 12345
 * 
 * 5 then 4 then 3 then 2 then 1
 * 
 * 
 */
public class QueueWithStack {
	private final IntArrayStack queue;
	private final IntArrayStack proxy;
	
	QueueWithStack(int maxSize){
		queue = new IntArrayStack(maxSize);
		proxy = new IntArrayStack(maxSize);
	}
	
	public void queue(int item){
		queue.push(item);
	}
	
	/**
	 * Pop all except the last one from queue, push to proxy
	 * @param item
	 * @return
	 */
	public int dequeue(){
		int item;
		while ((item = queue.pop()) != -1){
			proxy.push(item);
		}
		int result = proxy.pop();
		while ((item = proxy.pop()) != -1){
			queue.push(item);
		}
		return result;
	}
}
