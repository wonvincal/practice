package com.calvin.cake;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class StringProcessor {
	public static String reverseInPlace(String source){
		char[] characters = source.toCharArray();
		int beginIndex = 0;
		int endIndex = characters.length - 1;
		while (beginIndex < endIndex){
			char temp = characters[beginIndex];
			characters[beginIndex] = characters[endIndex];
			characters[endIndex] = temp;
			beginIndex++;
			endIndex--;
		}
		
		return new String(characters);
	}
	
	private static void reverseInPlace(char[] items, int beginIndex, int endIndex){
		while (beginIndex < endIndex){
			char temp = items[beginIndex];
			items[beginIndex] = items[endIndex];
			items[endIndex] = temp;
			beginIndex++;
			endIndex--;
		}
	}
	
	public static boolean hasPalindrome(String source){
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < source.length(); i++){
			char item = source.charAt(i);
			if (set.contains(item)){
				set.remove(item);
			}
			else{
				set.add(item);
			}
		}
		return set.isEmpty() || set.size() == 1;
	}
	
	public static boolean validateBrackets(String source){
		Stack<Character> bracketStack = new Stack<>();
		for (int i = 0; i < source.length(); i++){
			char item = source.charAt(i);
			if (item == '{' || item == '[' || item == '('){
				bracketStack.push(item);
			}
			else if (item == '}'){
				if (bracketStack.pop() != '{'){
					return false;
				}
			}
			else if (item == ']'){
				if (bracketStack.pop() != '['){
					return false;
				}
			}
			else if (item == ')'){
				if (bracketStack.pop() != '('){
					return false;
				}
			}
		}
		return bracketStack.isEmpty();
	}
	public static int findClosingBracketPosition(String source, int pos){
//		Stack<Character> bracketStack = new Stack<>();
//		bracketStack.push(items[pos]);
		int numOpenBrackets = 1;
		for (int i = pos+1; i < source.length(); i++){
			char item = source.charAt(i);
			if (item == '('){
				numOpenBrackets++;
			}
			else if (item == ')'){
				numOpenBrackets--;
				if (numOpenBrackets == 0){
					return i;
				}
			}
		}
		return -1;
	}
	public static String reverseWordsInStringInPlace(String source){
		// Two passes
		// 1) reverse whole string
		// 2) reverse individual words
		char[] items = source.toCharArray();
		reverseInPlace(items, 0, items.length - 1);
		
		System.out.println(new String(items));
		
		// skip all white spaces in the beginning
//		int beginIndex = 0;
//		while (items[beginIndex] == ' '){
//			beginIndex++;
//		}
//		for (int i = 1; i < items.length; i++){
//			if (items[i] == ' '){
//				reverseInPlace(items, beginIndex, i - 1);
//				
//				// Find index of next non space
//				beginIndex = i + 1;
//				boolean shouldContinue = true;
//				if (beginIndex >= items.length){
//					// Done
//					shouldContinue = false;
//				}
//				while (items[beginIndex] == ' '){
//					beginIndex++;
//					if (beginIndex >= items.length){
//						// Done
//						shouldContinue = false;
//						break;
//					}
//				}
//				if (!shouldContinue){
//					break;
//				}
//				// Since for loop will increment the count by one
//				i = beginIndex;
//			}
//		}
		
		int beginIndex = -1;
		for (int i = 0; i < items.length; i++){
			if (items[i] == ' '){
				if (beginIndex != -1){
					reverseInPlace(items, beginIndex, i - 1);
					beginIndex = -1;
				}
			}
			else {
				if (beginIndex == -1){
					beginIndex = i;
				}
			}
		}
		
		// Reverse last word, given that the last character is not a space
		if (beginIndex < items.length - 1){
			reverseInPlace(items, beginIndex, items.length - 1);
		}
		System.out.println(new String(items));
		return new String(items);
	}
	
	static public class LinkedListNode {

		public char value;
		public LinkedListNode next;

		public LinkedListNode(char value) {
			this.value = value;
		}
	}

	/**
	 * 1) Interview cake way:
	 * cats = s + permutation of "cat"
	 * For that, it means to stick s into every position from each permutation of "cat"
	 * 
	 * 2) My way
	 * cats = 1) c + permutation of "ats" + 
	 * 		  2) a + permutation of "cts" + 
	 * 		  3) t + permutation of "cas" + 
	 * 		  4) s + permutation of "cat" 
	 * 
	 * @param begin
	 * @param end
	 * @param path
	 * @param result
	 */
	private static void permutation(LinkedListNode begin, LinkedListNode end, Stack<Character> path, List<String> result){
		if (begin == end){
			path.push(begin.value);
			StringBuilder builder = new StringBuilder();
			path.forEach((c) -> builder.append(c));
			result.add(builder.toString());
			path.pop();
			return;
		}
		
		// for i = 0...
		//   path.push(head character)
		//   permutation(head.next, result)
		//   path.pop()
		//   move begin and end		
		LinkedListNode originalBegin = begin;
		do {
			path.push(begin.value);
			permutation(begin.next, end, path, result);
			path.pop();
			
			// [A->B->null]
			// [A->B->A]
			// Begin = B
			end.next = begin;
			end = begin;
			begin = begin.next;
		} 
		while (begin != originalBegin);
	}
	
	public static List<String> permutation(String source){
		// Create a linked list of source's character
		// begin, end
		// Create a stack to hold current path
		LinkedListNode head = new LinkedListNode(source.charAt(0));
		LinkedListNode end = head;
		for (int i = 1; i < source.length(); i++){
			end.next = new LinkedListNode(source.charAt(i));
			end = end.next;
		}
		Stack<Character> path = new Stack<>();
		List<String> result = new ArrayList<>();
		
		permutation(head, end, path, result);
		return result;
	}
}
