package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.cake.LinkedListProcessor.LinkedListNode;

public class LinkedListProcessorTest {
	@Test
	public void test(){
		LinkedListNode node1 = new LinkedListNode("1");
		LinkedListNode node2 = new LinkedListNode("2");
		LinkedListNode node3 = new LinkedListNode("3");
		LinkedListNode node4 = new LinkedListNode("4");
		LinkedListNode node5 = new LinkedListNode("5");
		LinkedListNode node6 = new LinkedListNode("6");
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		assertFalse(LinkedListProcessor.hasCycle(node1));

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		
		assertTrue(LinkedListProcessor.hasCycle(node1));

	}
	
	@Test
	public void reverse(){
		LinkedListNode node1 = new LinkedListNode("1");
		LinkedListNode node2 = new LinkedListNode("2");
		LinkedListNode node3 = new LinkedListNode("3");
		LinkedListNode node4 = new LinkedListNode("4");
		LinkedListNode node5 = new LinkedListNode("5");
		LinkedListNode node6 = new LinkedListNode("6");
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		print(node1);
		
		print(LinkedListProcessor.reverse(node1));
	}
	
	@Test
	public void testKthToLast(){
		LinkedListNode node1 = new LinkedListNode("1");
		LinkedListNode node2 = new LinkedListNode("2");
		LinkedListNode node3 = new LinkedListNode("3");
		LinkedListNode node4 = new LinkedListNode("4");
		LinkedListNode node5 = new LinkedListNode("5");
		LinkedListNode node6 = new LinkedListNode("6");
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		assertEquals(node4, LinkedListProcessor.kthToLast(3, node1));
		assertEquals(node4, LinkedListProcessor.kthToLastSmart(3, node1));
	}
	
	public static void print(LinkedListNode node){
		StringBuilder builder = new StringBuilder();
		LinkedListNode head = node;
		while (node != null){
			builder.append(node.value).append(",");
			node = node.next;
		}
		if (head != null){
			builder.deleteCharAt(builder.length() - 1);
		}
		System.out.println(builder.toString());
	}
}
