package com.calvin.educative.io.graph;

import java.util.Iterator;
import java.util.Stack;

/**
 * There are two well known algos:
 * 1) Krudal's
 * 2) Prim's - 
 *    1) pick a vertex, 
 *    2) update weight of the adjacent vertices and put them into a priority queue, 
 *    3) pick the lowest vertices
 *    4) no need to find loop, just to make sure we only add vertex that hasn't been added
 * @author wongca
 *
 */
public class MinSpanningTree {
	public static class PathNode {
		private int nodeIndex;
		private int cumulatedWeight;
		
		public int nodeIndex(){return nodeIndex;}
		public int cumulatedWeight(){ return cumulatedWeight;}
		public static PathNode of(int nodeIndex, int weight){
			return new PathNode(nodeIndex, weight);
		}
		PathNode(int nodeIndex, int weight){
			this.nodeIndex = nodeIndex;
			this.cumulatedWeight = weight;
		}
	}
	
	public static void prim(int[][] matrix){
		
	}
	
	/**
	 * This is basically wrong.  This logic 'traverses' whereas the
	 * question is  more about 'spanning' 
	 * @param currentIndex
	 * @param matrix
	 * @param path
	 */
	public static void traverse(int currentIndex, int[][] matrix, Stack<PathNode> path){
		if (path.size() == matrix.length){
			// Found something
			System.out.println("Found");
			Iterator<PathNode> iterator = path.iterator();
			while (iterator.hasNext()){
				PathNode node = iterator.next();
				System.out.println(node.nodeIndex + ", total: " + node.cumulatedWeight);
			}			
			System.out.println("");
			return;
		}
		for (int i = 0; i < matrix[currentIndex].length; i++){
			int weight = matrix[currentIndex][i];
			if (weight != -1){
				// Check if this node is in path
				// If not, push it with latest weight
				boolean visited = false;
				Iterator<PathNode> iterator = path.iterator();
				while (iterator.hasNext()){
					PathNode node = iterator.next();
					if (node.nodeIndex == i){
						visited = true;
						break;
					}
				}
				if (!visited){
					path.push(PathNode.of(i, path.peek().cumulatedWeight() + matrix[currentIndex][i]));
					traverse(i, matrix, path);
					path.pop();
				}
			}
		}
	}
}
