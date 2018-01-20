package com.calvin.crack.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddDigitsTest {
	@Test
	public void testCreate(){
		AddDigits ad = new AddDigits();
		assertNotNull(ad);
	}
	
	@Test
	public void testAdd(){
		// 617
		Node<Integer> first = new Node<Integer>(7).next(new Node<Integer>(1).next(new Node<Integer>(6)));
		// 295
		Node<Integer> second = new Node<Integer>(5).next(new Node<Integer>(9).next(new Node<Integer>(2)));
		
		AddDigits ad = new AddDigits();
		Node<Integer> sum = ad.add(first, second, 0);
		print(sum);
	}

	@Test
	public void testAddBig(){
		// 617
		Node<Integer> first = new Node<Integer>(7).next(new Node<Integer>(1).next(new Node<Integer>(6)));
		// 295
		Node<Integer> second = new Node<Integer>(5).next(new Node<Integer>(9).next(new Node<Integer>(6)));
		
		AddDigits ad = new AddDigits();
		Node<Integer> sum = ad.add(first, second, 0);
		print(sum);
	}

	public static void print(Node<Integer> x){
		Node<Integer> current = x;
		while (current != null){
			System.out.println(current.data().intValue() + " ");
			current = current.next();
		}
	}
}
