package com.calvin.crack.stack;

public class Node {
	private Node next;
	private Object data;
	
	public static Node of(Object data){
		return new Node(data);
	}
	
	Node(Object data){
		this.next = null;
		this.data = data;
	}
	
	public void next(Node next){
		this.next = next;
	}
	
	public Node next(){
		return next;
	}

	public Object data(){
		return data;
	}
}
