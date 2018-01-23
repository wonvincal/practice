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
		assertTrue(BinaryTreeChecker.isValidSearchTreeSmartIterative(node));
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
		assertFalse(BinaryTreeChecker.isValidSearchTreeSmartIterative(node));
		assertFalse(BinaryTreeChecker.isValidSearchTreeInOrder(node));
		assertFalse(BinaryTreeChecker.isValidSearchTreeIterative(node));
//		assertFalse(BinaryTreeChecker.isValidSearchTree(node));

	}
	
	@Test
	public void testSecondLargest(){
		BinaryTreeNode node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);
		node.right = new BinaryTreeNode(14);		
		assertEquals(10, BinaryTreeChecker.findSecondLargest(node));
		assertEquals(10, BinaryTreeChecker.findSecondLargestSmart(node));		

		node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);		
		assertEquals(5, BinaryTreeChecker.findSecondLargest(node));
		assertEquals(5, BinaryTreeChecker.findSecondLargestSmart(node));

		node = new BinaryTreeNode(10);
		node.left = new BinaryTreeNode(5);
		node.right = new BinaryTreeNode(14);
		node.right.left = new BinaryTreeNode(11);
		node.right.right = new BinaryTreeNode(15);
		assertEquals(14, BinaryTreeChecker.findSecondLargest(node));
		assertEquals(14, BinaryTreeChecker.findSecondLargestSmart(node));

		node = new BinaryTreeNode(5);
		node.left = new BinaryTreeNode(3);
		node.right = new BinaryTreeNode(8);
		node.left.left = new BinaryTreeNode(1);
		node.left.right = new BinaryTreeNode(4);
		node.right.left = new BinaryTreeNode(7);
		node.right.right = new BinaryTreeNode(12);
		node.right.right.left = new BinaryTreeNode(10);
		node.right.right.left.left = new BinaryTreeNode(9);
		node.right.right.left.right = new BinaryTreeNode(11);
		assertEquals(11, BinaryTreeChecker.findSecondLargest(node));
		assertEquals(11, BinaryTreeChecker.findSecondLargestSmart(node));
	}
}
