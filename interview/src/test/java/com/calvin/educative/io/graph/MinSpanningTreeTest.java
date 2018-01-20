package com.calvin.educative.io.graph;

import java.util.Stack;

import org.junit.Test;

import com.calvin.educative.io.graph.MinSpanningTree.PathNode;

public class MinSpanningTreeTest {
	@Test
	public void test(){
		int[][] matrix = new int[5][];
		matrix[0] = new int[]{-1, 1, 1, -1, -1};
		matrix[1] = new int[]{1, -1, 2, 3, -1};
		matrix[2] = new int[]{1, 2, -1, -1, 3};
		matrix[3] = new int[]{-1, 3, -1, -1, 2};
		matrix[4] = new int[]{-1, -1, 3, 2, -1};
		Stack<PathNode> path = new Stack<>();
		path.add(PathNode.of(2, 0));
		MinSpanningTree.traverse(2, matrix, path);
	}
}
