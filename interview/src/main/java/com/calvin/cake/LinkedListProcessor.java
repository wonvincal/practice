package com.calvin.cake;

import java.util.Stack;

public class LinkedListProcessor {
	static public class LinkedListNode {

		public String value;
		public LinkedListNode next;

		public LinkedListNode(String value) {
			this.value = value;
		}
	}
	public static void delete(LinkedListNode remove){
		if (remove.next == null){
			throw new RuntimeException("Impossible");
		}
		// Copy from the next node
		remove.value = remove.next.value;
		remove.next = remove.next.next;
	}
	
	public static LinkedListNode kthToLast(int k, LinkedListNode head){
		// Recursion or Stack
		// If requirement on space, reverse the list
		Stack<LinkedListNode> stack = new Stack<>();
		while (head != null){
			stack.push(head);
			head = head.next;
		}
		if (k > stack.size()){
			return null;
		}
		for (int i = 0; i < k - 1; i++){
			stack.pop();
		}
		return stack.pop();
	}
	
	public static LinkedListNode kthToLastSmart(int k, LinkedListNode head){
		if (head == null){
			throw new RuntimeException();
		}
		
		LinkedListNode left;
		LinkedListNode right = head;
		left = head;
		for (int i = 0; i < k - 1; i++){
			right = right.next;
			if (right == null){
				throw new RuntimeException();
			}
		}
		
		while (right.next != null){
			left = left.next;
			right = right.next;
		}
		
		return left;
	}

	public static LinkedListNode reverse(LinkedListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		LinkedListNode current = head;
		LinkedListNode reversed = null;
		//[1 -> 2 -> 3]
		// Temp -> 2
		// Take out 1
		// 1 -> reversed.next
		// reversed -> 1
		// current = 2
		// [2 -> 3]
		// 
		LinkedListNode temp;
		while (current != null){
			temp = current.next;
			current.next = reversed;
			reversed = current;
			current = temp;
		}
		return reversed;
	}
	
	/**
	 * Simplest way is to add each node to a hashset, return if hashset already
	 * Space: O(n)
	 * Time: O(n * 1)
	 * 
	 * If we want to reduce space
	 * 
	 * contains a node.
	 * @param node
	 * @return
	 */
	public static boolean hasCycle(LinkedListNode node){
		if (node.next == null){
			return false;
		}
		
		LinkedListNode slow = node;
		LinkedListNode fast = node.next;
		
		while (fast != slow){
			if (fast.next == null || fast.next.next == null){
				return false;
			}
			
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
