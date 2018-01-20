package com.calvin.educative.io.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
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
		Node other = (Node) obj;
		if (data != other.data)
			return false;
		return true;
	}
	private List<Node> neighbors = new ArrayList<Node>();
	private int data;
	
	public static Node of(int data){
		return new Node(data);
	}
	
	Node(int data){
		this.data = data;
	}
	
	public int data(){ return data;}
	public List<Node> neighbors(){ return neighbors;}
	
	@Override
	public String toString() {
		String msg = "[" + data +"] -> [";
		for (Node neighbor : neighbors){
			msg += neighbor.data + " ";
		}
		msg += "]";
		return msg;
	}
	
}
