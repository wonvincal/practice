package com.calvin.crack.linkedlist;

public class DuplicateRemover {
	public void remove(Node<String> node){
		// Use a buffer to hold what has been appeared
	}
	
	public void removeOneGo(Node<String> node){
		if (node.next() == null){
			return;
		}
		Node<String> outer = node.next();
		
		// One while loop to remove once
		while (outer.next() != null){
			String data = outer.data();			
			Node<String> runner = outer;
			while (runner.next() != null){
				if (runner.next().data() == data){
					runner.next(runner.next().next());
				}
				else{
					runner = runner.next();
				}				
			}			
			outer = outer.next();
		}
	}
}
