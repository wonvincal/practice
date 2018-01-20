package com.calvin.crack.stack;

public class Stack {
	Node top;
	
	public Stack push(Object data){
		Node node = Node.of(data);
		node.next(top);
		top = node;
		return this;
	}
	
	public Object pop(){
		if (top != null){
			Object data = top.data();
			Node removed = top;
			top = removed.next();
			removed.next(null);
			return data;			
		}		
		return null;
	}
	
	public Object peek(){
		return top.data();
	}
}
