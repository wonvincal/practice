package com.calvin.cake;

import java.util.Collections;
import java.util.PriorityQueue;

import org.junit.Test;

public class GraphColorTest {
	@Test
	public void test(){
		PriorityQueue<Integer> heap = new PriorityQueue<>(10, Collections.reverseOrder());
		heap.add(10);
		heap.add(5);
		heap.add(10);
		
		System.out.println(heap.poll());
		System.out.println(heap.poll());
		System.out.println(heap.poll());
	}
	
	@Test
	public void testColor(){
		GraphNode a = new GraphNode("a");
		GraphNode b = new GraphNode("b");
		GraphNode c = new GraphNode("c");

		a.addNeighbor(b);
		b.addNeighbor(a);
		b.addNeighbor(c);
		c.addNeighbor(b);

		GraphNode[] graph = new GraphNode[] { a, b, c };
		GraphColor.fillColor(graph);
		print(graph);
	}
	
	private static void print(GraphNode[] graph){
		for (GraphNode node : graph){
			System.out.println(node.toString());
		}
	}
}
