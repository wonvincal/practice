package com.calvin.educative.io.linked;

public class Node<T> {
	private Node<T> next;
	private T data;

	public static <T> Node<T> of(T data){
		return new Node<>(data);
	}
	Node(T data){
		this.data = data;
	}
	public T data(){ return data;}
	public Node<T> next() { return next;}
	public Node<T> next(Node<T> next) { 
		this.next =  next;
		return this;
	}
	
	@Override
	public String toString() {
		return "[" + data + "]";
	}
}
