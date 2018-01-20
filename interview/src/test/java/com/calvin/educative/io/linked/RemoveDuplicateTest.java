package com.calvin.educative.io.linked;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicateTest {
	@Test
	public void test(){
		Node<Integer> head = new Node<Integer>(7);
		head.next(Node.of(14).next(Node.of(28).next(Node.of(28).next(Node.of(14).next(Node.of(21))))));
		print(head);
		Node<Integer> nonDup = RemoveDuplicate.removeDup(head);
		print(nonDup);
		
		assertTrue(assertList(new int[]{7,14,28,21}, nonDup));
		assertFalse(assertList(new int[]{7,14,28}, nonDup));
	}

	public static boolean assertList(int[] expected, Node<Integer> node){
		int i = 0;
		while (node != null){
			if (i >= expected.length || expected[i] != node.data()){
				return false;
			}
			node = node.next();
			i++;
		}
		return i == expected.length;
		
	}
	public static <T> void print(Node<T> node){
		while (node != null){
			System.out.print(node.data() + ",");
			node = node.next();
		}
		
		System.out.println();
	}
}
