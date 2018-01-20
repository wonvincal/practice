package com.calvin.educative.io.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * There are two ways to represent graph
 * 1) Adjacency NxN matrix
 * 2) Adjacency List: List of LinkedList
 * @author wongca
 *
 */
public class Graph {
	private final ArrayList<Vertex> vertices;
	private final ArrayList<Edge> edges;
	
	Graph(){
		this.vertices = new ArrayList<>();
		this.edges = new ArrayList<>();
	}
	
	public List<Vertex> vertices(){ return vertices;}
	public List<Edge> edges(){ return edges;}
	
	public static Node clone(Node source, HashMap<Node, Node> visited){
		cloneRecursive(source, visited);
		return visited.get(source);
	}
	
	private static Node cloneRecursive(Node source, HashMap<Node, Node> visited){
		if (visited.containsKey(source)){
			return visited.get(source);
		}
		
		int data = source.data();
		Node cloned = Node.of(data);
		visited.put(source, cloned);
		
		for (Node neighbor : source.neighbors()){
			Node clonedNeighbor = cloneRecursive(neighbor, visited);
			cloned.neighbors().add(clonedNeighbor);
		}
		return cloned;
	}
}
