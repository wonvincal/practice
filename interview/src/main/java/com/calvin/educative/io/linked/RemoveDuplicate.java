package com.calvin.educative.io.linked;

import java.util.HashSet;

public class RemoveDuplicate {
	public static Node<Integer> removeDup(Node<Integer> head){
		// Traverse
		// Check next
		HashSet<Integer> appeared = new HashSet<>();
		
		Node<Integer> current = head;
		appeared.add(current.data());
		while (current.next() != null){
			if (!appeared.add(current.next().data())){
				// Remove next
				Node<Integer> removed = current.next();
				current.next(removed.next());
				removed.next(null);				
			}
			else {
				current = current.next();
			}
		}
		return head;
	}
}
