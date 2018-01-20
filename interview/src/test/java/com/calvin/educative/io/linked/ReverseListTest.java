package com.calvin.educative.io.linked;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ReverseListTest {
	@Test
	public void test(){
		// [1, 2, 3, 4, 5, 6]
		Node<Integer> head = new Node<Integer>(1);
		Node<Integer> current = head;
		for (int i = 2; i <= 6; i++){
			Node<Integer> data = new Node<Integer>(i);
			current.next(data);
			current = data;
		}
		System.out.println(Arrays.toString(toArray(head)));
		System.out.println(Arrays.toString(toArray(ReverseList.reverse(head))));
		System.out.println(Arrays.toString(toArray(ReverseList.reverseRecursive(head))));
	}
	
	public static int[] toArray(Node<Integer> head){
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null){
			list.add(head.data());
			head = head.next();
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++){
			result[i] = list.get(i);
		}
		return result;
	}
}
