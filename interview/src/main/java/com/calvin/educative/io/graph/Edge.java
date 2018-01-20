package com.calvin.educative.io.graph;

public class Edge {
	private Vertex src;
	private Vertex dest;
	private int weight;
	private boolean visited;
	
	public static Edge of(Vertex src, Vertex dest, int weight){
		return new Edge(src, dest, weight);
	}
	
	Edge(Vertex src, Vertex dest, int weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}
	
	public boolean consistOf(Vertex v){
		return src.equals(v) || dest.equals(v);
	}
	public Vertex src(){ return src;}
	public Vertex dest(){ return dest;}
	public int weight(){ return weight;}
	public Edge visited(boolean value){ 
		this.visited = value;
		return this;
	}
	public boolean visited(){ return visited;}

}
