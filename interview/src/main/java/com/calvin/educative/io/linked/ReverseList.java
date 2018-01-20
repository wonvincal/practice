package com.calvin.educative.io.linked;

public class ReverseList {
	public static <T> Node<T> reverse(Node<T> head){
		// Take the Node out
		Node<T> newHead = head;
		Node<T> current = head.next();
		newHead.next(null);
		
		while (current != null){
			Node<T> temp = current.next();
			current.next(newHead);
			newHead = current;
			current = temp;
		}
		return newHead;
	}

	/**
	 * This is so CONFUSING!
	 * 
	 * Recursive is not a natural way of thinking in this case.  It is
	 * mainly used as a mean to reach the end of the list.
	 * 
	 * The key lies in the fact that
	 * head->next->next = head; (means reverse)
	 * head->next = null;
	 * @param head
	 * @return
	 */
	public static <T> Node<T> reverseRecursive(Node<T> head){
		// Take the Node out
		if (head == null || head.next() == null){
			return head; // end of list
		}
		
		Node<T> headOfList = reverseRecursive(head.next());
		
		head.next().next(head);
		head.next(null);
		
		return headOfList;
	}

}
