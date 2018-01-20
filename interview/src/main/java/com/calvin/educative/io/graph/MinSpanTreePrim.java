package com.calvin.educative.io.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MinSpanTreePrim {
	public void find(Graph graph){
		// Pick any vertex
		// Find the edges associated with this vertex
		
		HashSet<Vertex> onTree = new HashSet<>();
		Vertex vertex = graph.vertices().get(0);
		onTree.add(vertex);
		
		Comparator<Edge> weightComparator = new Comparator<Edge>() {			
			@Override
			public int compare(Edge o1, Edge o2) {
				
				return o1.weight() - o2.weight(); 
			}
		};
		PriorityQueue<Edge> edgeByWeight = new PriorityQueue<>((e1, e2) -> e1.weight() - e2.weight());
		while (onTree.size() <= graph.vertices().size()){
			// There is a chance that the graph is not connected
			// Find the adjacent edges
			for (Edge edge : vertex.edges()){
				edgeByWeight.add(edge);
			}
			
			// Pick the min weight one off the list
			Edge minEdge;
			while ((minEdge = edgeByWeight.poll()) != null){
				Vertex toVertex;
				if (minEdge.dest().equals(vertex)){
					toVertex = minEdge.src();
				}
				else {
					toVertex = minEdge.src();
				}
				// Check if we have already captured this vertex
				if (onTree.add(toVertex)){
					// if not exist
				}
				else {
					break;					
				}
				
			}
		}
	}
}
