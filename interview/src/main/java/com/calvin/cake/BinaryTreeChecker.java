package com.calvin.cake;

import java.util.Stack;

public class BinaryTreeChecker {
	public static class BinaryTreeNode {

		public int level;
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
	
	public static boolean isSuperBalancedIterative(BinaryTreeNode node){		
		// recursively find depth of all leaves
		// take min and max
		
		System.out.println("Check Begin");
		return checkIterative(node);
	}

	/**
	 * All nodes on the left must be smaller than all nodes on the right
	 * @param node
	 * @return -1 if something invalid is found
	 */
	public static boolean isValidSearchTree(BinaryTreeNode node){
		MinMaxResult minMaxAndCheck = getMinMaxAndCheck(node);
		return minMaxAndCheck.isValid;
	}

	public static boolean isValidSearchTreeIterative(BinaryTreeNode node){
		return checkSearchTreeIterative(node);
	}

	public static boolean isValidSearchTreeInOrder(BinaryTreeNode node){
		return checkSearchTreeValidInOrder(node);
	}
	
	public static boolean isValidSearchTreeSmart(BinaryTreeNode node){
		return checkSearchTreeSmart(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static class CurrentValue {
		int value;
	}

	/**
	 * I was only able to focus that all nodes on the left of a node must be less than the node.value,
	 * and all nodes on the right of a node must be greater than the node.value.  However I wasn't able
	 * to identify that a node is valid if it is within a "range created by its ancestor"
	 * @param node
	 * @return
	 */
	public static boolean checkSearchTreeSmart(BinaryTreeNode node, int lowerBound, int upperBound){
		if (node == null){
			return true;
		}
		
		if (node.value < lowerBound || node.value > upperBound){
			return false;
		}
		
		return checkSearchTreeSmart(node.left, lowerBound, node.value) &&
				checkSearchTreeSmart(node.right, node.value, upperBound);
	}
	
	/** There are two ways to do this
	 *  1) Traverse in-order
	 * @param node
	 * @return
	 */
	public static boolean checkSearchTreeValidInOrder(BinaryTreeNode node){
		CurrentValue value = new CurrentValue();
		value.value = Integer.MIN_VALUE;
		return checkSearchTreeValidInOrder(node, value);
	}

	private static boolean checkSearchTreeValidInOrder(BinaryTreeNode node, CurrentValue current){
		if (node == null){
			return true;
		}
		
		if (!checkSearchTreeValidInOrder(node.left, current)){
			return false;
		}
		
		if (node.value <= current.value){
			return false;
		}
		current.value = node.value;
		
		if (!checkSearchTreeValidInOrder(node.right, current)){
			return false;
		}
		
		return true;
	}

	public static class BinaryTreeNodeInfo {
		BinaryTreeNode node;
		BinaryTreeNodeInfo ancestor;
		boolean leftSideOfAncestor;
		
		BinaryTreeNodeInfo(BinaryTreeNode node, BinaryTreeNodeInfo ancestor, boolean leftSideOfAncestor){
			this.node = node;
			this.ancestor = ancestor;
			this.leftSideOfAncestor = leftSideOfAncestor;
		}
	}
	
	private static boolean checkSearchTreeIterative(BinaryTreeNode node){
		Stack<BinaryTreeNodeInfo> stack = new Stack<>();
		stack.push(new BinaryTreeNodeInfo(node, null, false));
		while (!stack.isEmpty()){
			BinaryTreeNodeInfo current = stack.pop();
			
			// Check if current is ok by going up all the way
			if (current.ancestor != null){
				BinaryTreeNodeInfo at = current;
				while (at.ancestor != null){
					if (at.leftSideOfAncestor && current.node.value >= at.ancestor.node.value){
						return false;
					}
					if (!at.leftSideOfAncestor && current.node.value <= at.ancestor.node.value){
						return false;
					}
					at = at.ancestor;							
				}
			}
			
			// Push the children
			if (current.node.left != null){
				stack.push(new BinaryTreeNodeInfo(current.node.left, current, true));				
			}
			if (current.node.right != null){
				stack.push(new BinaryTreeNodeInfo(current.node.right, current, false));
			}
			
		}
		return true;
	}
	
	public static class MinMaxResult {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isValid = true;
		MinMaxResult(int min, int max, boolean isValid){
			this.min = min;
			this.max = max;
			this.isValid = isValid;
		}
	}
	
	private static MinMaxResult getMinMaxAndCheck(BinaryTreeNode node){
		if (node.left == null && node.right == null){
			return new MinMaxResult(node.value, node.value, true);
		}
		
		int min = node.value;
		int max = node.value;
		if (node.right != null){
			MinMaxResult resultRight = getMinMaxAndCheck(node.right);
			if (!resultRight.isValid){
				return resultRight;
			}
			if (node.value >= resultRight.min){
				resultRight.isValid = false;
				return resultRight;
			}
			max = resultRight.max;
		}
		if (node.left != null){
			MinMaxResult resultLeft = getMinMaxAndCheck(node.left);
			if (!resultLeft.isValid){
				return resultLeft;
			}
			if (node.value <= resultLeft.max){
				resultLeft.isValid = false;
				return resultLeft;
			}
			min = resultLeft.min;
		}
				
		return new MinMaxResult(min, max, true);
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
	
	private static boolean checkIterative(BinaryTreeNode node){
		if (node == null){
			return false;
		}
		Stack<BinaryTreeNode> stack = new Stack<>();
		node.level = 1;
		stack.push(node);
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = 0;
		int currentHeight = 0;
		while (!stack.isEmpty()){
			BinaryTreeNode at = stack.pop();
			currentHeight = at.level;
			if (at.left == null && at.right == null){
				minHeight = Math.min(minHeight, currentHeight);
				maxHeight = Math.max(maxHeight, currentHeight);
				if ((maxHeight - minHeight) > 1){
					return false;
				}
			}
			else {
				if (at.right != null){
					at.right.level = currentHeight + 1;
					stack.push(at.right);
				}
				if (at.left != null){
					at.left.level = currentHeight + 1;
					stack.push(at.left);
				}
			}
		}
		return (maxHeight - minHeight) <= 1; 
	}
}
