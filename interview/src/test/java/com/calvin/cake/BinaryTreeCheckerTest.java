package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.cake.BinaryTreeChecker.BinaryTreeNode;

public class BinaryTreeCheckerTest {
	@Test
	public void test(){
		BinaryTreeNode node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);
		node.right = new BinaryTreeNode(4);
		node.left.left = new BinaryTreeNode(6);
		
		assertTrue(BinaryTreeChecker.isSuperBalanced(node));
		node.left.left.left = new BinaryTreeNode(7);
		assertFalse(BinaryTreeChecker.isSuperBalanced(node));
	}
}
