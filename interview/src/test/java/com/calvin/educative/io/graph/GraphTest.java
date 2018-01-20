package com.calvin.educative.io.graph;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class GraphTest {
	@Test
	public void test(){
		Node node0 = Node.of(0);
		Node node1 = Node.of(1);
		Node node2 = Node.of(2);
		Node node3 = Node.of(3);
		Node node4 = Node.of(4);
		node0.neighbors().add(node2);
		node0.neighbors().add(node3);
		node0.neighbors().add(node4);

		node1.neighbors().add(node2);

		node2.neighbors().add(node0);

		node3.neighbors().add(node2);

		node4.neighbors().add(node0);
		node4.neighbors().add(node1);
		node4.neighbors().add(node3);
		
		HashMap<Node, Node> visited = new HashMap<>();
		Node cloned0 = Graph.clone(node0, visited);
		for (Entry<Node, Node> entry : visited.entrySet()){
			Node orig = entry.getKey();
			Node node = orig;
			System.out.print("[" + node.data() + "] -> [");
			for (Node neighbor : node.neighbors()){
				System.out.print(neighbor.data() + " ");
			}
			System.out.println("]");
			
			node = entry.getValue();
			System.out.print("[" + node.data() + "] -> [");
			for (Node neighbor : node.neighbors()){
				System.out.print(neighbor.data() + " ");
			}
			System.out.println("]");
			System.out.println("");
		}
	}
}
