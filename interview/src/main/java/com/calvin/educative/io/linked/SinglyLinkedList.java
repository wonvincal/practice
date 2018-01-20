package com.calvin.educative.io.linked;

public class SinglyLinkedList<T> {
	private Node<T> head;
	
	SinglyLinkedList(){}
	
	public void insertHead(Node<T> node){
		if (head == null){
			head = node;
		}
		else{
			node.next(head);
			head = node;
		}
	}
	
	public Node<T> removeHead(){
		Node<T> removed = head;
		if (head != null){
			head = head.next();
		}
		return removed;
	}
	
	public Node<T> head(){ return head;}
	
	public boolean isEmpty(){ return head == null;}
}
