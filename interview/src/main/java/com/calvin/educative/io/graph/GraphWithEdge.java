package com.calvin.educative.io.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GraphWithEdge {
	private HashMap<Integer, Vertex> vertices;
	private List<Edge> edges;
	
	GraphWithEdge(){
		this.vertices = new HashMap<>();
		this.edges = new ArrayList<>();
	}
	public GraphWithEdge addVertex(Vertex v){
		vertices.put(v.id(), v);
		return this;
	}
	public GraphWithEdge addEdge(Edge e){
		edges.add(e);
		return this;
	}
	
	public int findMinSpan(){
		int vertexCount = 0;
		int weight = 0;
		
		Vertex current  = vertices.values().iterator().next();
		current.visited(true);
		vertexCount++;

		// Sort all edges by weight
		Collections.sort(this.edges, Comparator.comparingInt(Edge::weight));

		while (vertexCount < this.vertices.size()){
			Edge smallest = null;
			// Get edge with smallest weight
			for (Edge edge : edges){
				if (!edge.visited() && !edge.dest().visited()){
					smallest = edge;
					break;
				}
			}
			
			// Loop thru all edges and find one with one visited vertex
			for (Edge edge : edges){
				if (!edge.visited()){
					if (edge.src().visited() && 
						!edge.dest().visited() &&
						(edge.weight() < smallest.weight())){
						smallest = edge;
					}
				}
			}
			
			smallest.visited(true);
			smallest.dest().visited(true);
			weight += smallest.weight();
			vertexCount++;
		}
		return weight;
	}
}
