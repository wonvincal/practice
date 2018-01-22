package com.calvin.cake;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.calvin.cake.BinaryTreeChecker.BinaryTreeNode;

public class BinaryTreeCheckerTest {
	@Test
	public void test(){
		BinaryTreeNode node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);
		node.right = new BinaryTreeNode(4);
		node.left.left = new BinaryTreeNode(6);
		
		assertTrue(BinaryTreeChecker.isSuperBalancedIterative(node));
		assertTrue(BinaryTreeChecker.isSuperBalanced(node));
		node.left.left.left = new BinaryTreeNode(7);
		assertFalse(BinaryTreeChecker.isSuperBalanced(node));
		assertFalse(BinaryTreeChecker.isSuperBalancedIterative(node));
	}
	
	@Test
	public void testSearchTree(){
		BinaryTreeNode node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);
		node.right = new BinaryTreeNode(14);
		node.left.left = new BinaryTreeNode(3);
		node.left.right = new BinaryTreeNode(7);
		node.right.left = new BinaryTreeNode(11);
		node.right.right = new BinaryTreeNode(15);
		assertTrue(BinaryTreeChecker.isValidSearchTreeSmart(node));
		assertTrue(BinaryTreeChecker.isValidSearchTreeInOrder(node));
		assertTrue(BinaryTreeChecker.isValidSearchTreeIterative(node));
//		assertTrue(BinaryTreeChecker.isValidSearchTree(node));
//
		node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);
		node.right = new BinaryTreeNode(14);
		node.left.left = new BinaryTreeNode(3);
		node.left.right = new BinaryTreeNode(11);
		node.right.left = new BinaryTreeNode(11);
		node.right.right = new BinaryTreeNode(15);
		assertFalse(BinaryTreeChecker.isValidSearchTreeSmart(node));
		assertFalse(BinaryTreeChecker.isValidSearchTreeInOrder(node));
		assertFalse(BinaryTreeChecker.isValidSearchTreeIterative(node));
//		assertFalse(BinaryTreeChecker.isValidSearchTree(node));

	}
}
