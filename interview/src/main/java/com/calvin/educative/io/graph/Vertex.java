package com.calvin.educative.io.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private int id;
	private boolean visited;
	private ArrayList<Edge> edges;
	
	public static Vertex of(int id){
		return new Vertex(id);
	}
	
	Vertex(int id){
		this.id = id;
		this.edges = new ArrayList<>();
	}
	public List<Edge> edges(){ return edges;}
	public int id(){ return id;}
	public boolean visited(){ return visited;}
	public Vertex visited(boolean value){
		this.visited = value;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
