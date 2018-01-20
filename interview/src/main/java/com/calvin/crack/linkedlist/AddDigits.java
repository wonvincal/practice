package com.calvin.crack.linkedlist;

public class AddDigits {
	public Node<Integer> add(Node<Integer> a, Node<Integer> b, int carry){
		if (a == null && b == null){
			if (carry > 0){
				return new Node<Integer>(carry);
			}
		}
		if (a == null){
			if (b == null){				
				return null;
			}
			return new Node<Integer>(b.data());
		}
		else {
			if (b == null){
				return new Node<Integer>(a.data());
			}		
		}
		int value = a.data().intValue() + b.data().intValue() + carry;
		int newcarry = (value >= 10) ? 1 : 0;
		value %= 10;
		Node<Integer> node = new Node<Integer>(value);
		Node<Integer> next = add(a.next(), b.next(), newcarry);
		node.next(next);
		return node;
	}
}
