package com.calvin.collection;

public class SinglyLinkedList<T> {
	public static class Node<T> {
		T data;
		Node<T> next;
		public static <T> Node<T> of(T data){
			return new Node<T>(data, null);
		}
		Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
		public T data(){ return data;}
		public Node<T> next(Node<T> node){ this.next = node; return this;}
		public Node<T> next(){ return this.next;}
	}
	
	private Node<T> head;
	SinglyLinkedList(){
		this.head = null;
	}
	public void insertHead(Node<T> node){
		if (this.head != null){
			node.next = this.head;
			this.head = node;
		}
		else {
			this.head = node;
		}
	}
	public Node<T> head(){ return head;}
}
