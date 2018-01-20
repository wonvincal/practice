package com.calvin.educative.io.graph;

import org.junit.Test;

public class GraphWithEdgeTest {
	@Test
	public void test(){
		GraphWithEdge graph = new GraphWithEdge();
		Vertex v1 = Vertex.of(1);
		Vertex v2 = Vertex.of(2);
		Vertex v3 = Vertex.of(3);
		Vertex v4 = Vertex.of(4);
		Vertex v5 = Vertex.of(5);
		Vertex v6 = Vertex.of(6);
		Vertex v7 = Vertex.of(7);
		graph.addVertex(v7).addVertex(v6).addVertex(v5).addVertex(v4).addVertex(v3).addVertex(v2).addVertex(v1);

		Edge e12 = Edge.of(v1, v2, 2);
		Edge e13 = Edge.of(v1, v3, 1);
		Edge e14 = Edge.of(v1, v4, 2);
		Edge e24 = Edge.of(v2, v4, 3);
		Edge e34 = Edge.of(v3, v4, 1);
		Edge e35 = Edge.of(v3, v5, 2);
		Edge e47 = Edge.of(v4, v7, 2);
		Edge e56 = Edge.of(v5, v6, 1);
		Edge e57 = Edge.of(v5, v7, 2);
		graph.addEdge(e12).addEdge(e13).addEdge(e14).addEdge(e24).addEdge(e34).addEdge(e35).addEdge(e47).addEdge(e56).addEdge(e57);
		
		graph.findMinSpan();
	}
}
