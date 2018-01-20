package com.calvin.crack.linkedlist;

public class Node<T> {
	private Node<T> next;
	private T data;
	
	public Node(T data){
		this.data = data;
	}
	
	public T data(){
		return data;
	}

	public Node<T> next(){
		return next;
	}

	public Node<T> next(Node<T> node){
		this.next = node;
		return this;
	}

}
