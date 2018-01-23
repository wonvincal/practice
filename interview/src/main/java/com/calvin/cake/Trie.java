package com.calvin.cake;

import java.util.HashMap;

class TrieNode {
	private HashMap<Character, TrieNode> nodeChildren;
	
	public TrieNode(){
		this.nodeChildren = new HashMap<>();
	}
	
	public boolean hasChildNode(char character){
		return this.nodeChildren.containsKey(character);
	}
	
	public void makeChildNode(char character){
		this.nodeChildren.put(character, new TrieNode());
	}
	
	public TrieNode getChildNod(char character){
		return this.nodeChildren.get(character);
	}
}

/**
 * Space saved:
 * 1) Originally 26 * 26 * 26 * 26 * 26 (combinations of all 5-character urls x 5 bytes
 * 2) Currently  26 * 26 * 26 * 26 * 26 = 26^5
 * @author Calvin
 *
 */
public class Trie{
	private TrieNode rootNode;
	private final char endOfWordMarket = '\0';
	
	public Trie(){
		this.rootNode = new TrieNode();
	}
	
	public boolean addWord(String word){
		TrieNode currentNode = this.rootNode;
		boolean isNewWord = false;
		
		for (int i = 0; i < word.length(); i++){
			char character = word.charAt(i);
			if (!currentNode.hasChildNode(character)){
				currentNode.makeChildNode(character);
				isNewWord = true;
			}
			currentNode = currentNode.getChildNod(character);
		}
		
		if (!currentNode.hasChildNode(endOfWordMarket)){
			isNewWord = true;
			currentNode.makeChildNode(endOfWordMarket);
		}
		
		return isNewWord;
	}
}
