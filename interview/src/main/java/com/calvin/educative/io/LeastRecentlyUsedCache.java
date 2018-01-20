package com.calvin.educative.io;

import java.util.HashSet;
import java.util.LinkedList;

/** Doesn't work with Java implementation, needs our own LinkedListNode
 * 
 * @author Calvin
 *
 */
public class LeastRecentlyUsedCache {
	private final LinkedList<Integer> evicts;
	private final HashSet<Integer> cache;
	private final int limit;
	
	LeastRecentlyUsedCache(int size){
		this.cache = new HashSet<>(size);
		this.evicts = new LinkedList<>();
		this.limit = size;
	}
	
	public int get(int value){
		if (this.cache.contains(value)){
		}
		else {
			if (this.evicts.size() >= limit){
				this.evicts.pollFirst();
				this.cache.remove(value);
			}
			this.evicts.offer(value);
			this.cache.add(value);
		}
		return value;
	}
	
	public void set(int value){
		
	}
}
