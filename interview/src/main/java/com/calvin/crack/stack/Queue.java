package com.calvin.crack.stack;

public class Queue {
	Node head;
	
	public void enqueue(Object item){
		Node node = Node.of(item);
		if (head != null){
			head.next(node);
		}
		else{
			head = node;
		}
	}
	
	public Object dequeue(){
		Object result = null;
		if (head != null){
			result = head.data();
			head = head.next();
			return result;
		}
		return result;
	}
}
