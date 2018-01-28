package com.calvin.cake;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class GraphColor {
	public static final String[] COLORS = new String[]{"red", "orange", "yellow", "green", "turquoise", "blue", "purple"};
	
	private static Set<String> colorChoices(int degree){
		Set<String> choices = new HashSet<String>(degree + 1);
		for (int i = 0; i < degree + 1; i++){
			choices.add(COLORS[i]);			
		}
		return choices;
	}
	
	public static void fillColor(GraphNode[] nodes){
		
		// Fill color of each node using maximum of D (degree + 1)
		PriorityQueue<GraphNode> heap = new PriorityQueue<>(nodes.length, new Comparator<GraphNode>() {
			@Override
			public int compare(GraphNode o1, GraphNode o2) {
				return o2.getNeighbors().size() - o1.getNeighbors().size();
			}
		});
		
		for (GraphNode node : nodes){
			heap.add(node);
		}
		
		// Find out the max degree
		int degree = heap.peek().getNeighbors().size();
		
		// Pick each node by degree in decreasing order
		while (!heap.isEmpty()){
			GraphNode node = heap.poll();
			
			// Color yourself
			// Loop thru itself and neighbors
			// Look at colors that have already been used
			Set<String> availableColors = colorChoices(degree);
			if (node.hasColor()){
				availableColors.remove(node.getColor());
			}
			
			for (GraphNode neighbor : node.getNeighbors()){
				if (neighbor.hasColor()){
					availableColors.remove(neighbor.getColor());
				}
			}
			
			// Assign remaining colors to blank node
			if (!node.hasColor()){
				String color = availableColors.iterator().next();
				node.setColor(color);
				availableColors.remove(color);
			}			
			Set<GraphNode> neighbors = node.getNeighbors();
			for (GraphNode neighbor : neighbors){
				if (!neighbor.hasColor()){
					String color = availableColors.iterator().next();
					neighbor.setColor(color);
					availableColors.remove(color);					
				}
			}
		}
	}
}
