package com.calvin.cake;

public class BinaryTreeChecker {
	public static class BinaryTreeNode {

	    public int value;
	    public BinaryTreeNode left;
	    public BinaryTreeNode right;

	    public BinaryTreeNode(int value) {
	        this.value = value;
	    }

	    public BinaryTreeNode insertLeft(int leftValue) {
	        this.left = new BinaryTreeNode(leftValue);
	        return this.left;
	    }

	    public BinaryTreeNode insertRight(int rightValue) {
	        this.right = new BinaryTreeNode(rightValue);
	        return this.right;
	    }
	}
	
	public static class Result {
		int maxLevel;
		int minLevel;
		
		Result(){
			maxLevel = 0;
			minLevel = Integer.MAX_VALUE;
		}
	}
	
	/**
	 * Make sure depths of any two leaf nodes is no greater than one
	 * @param node
	 * @return
	 */
	public static boolean isSuperBalanced(BinaryTreeNode node){		
		// recursively find depth of all leaves
		// take min and max
		
		System.out.println("Check Begin");
		return check(node, 1, new Result());
	}
	
	private static boolean check(BinaryTreeNode node, int level, Result result){
		if (node.left == null && node.right == null){
			result.maxLevel = Math.max(result.maxLevel, level);
			result.minLevel = Math.min(result.minLevel, level);
			System.out.println("node: " + node.value + " at level: " + level + ", min: " + result.minLevel + ", max: " + result.maxLevel);
			return Math.abs(result.maxLevel - result.minLevel) <= 1;
		}
		
		boolean isBalanced = true;
		if (node.left != null){
			isBalanced = isBalanced && check(node.left, level + 1, result);
		}
		if (node.right != null){
			isBalanced = isBalanced && check(node.right, level + 1, result);
		}
		return isBalanced;
	}
}
