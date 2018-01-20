package com.calvin.crack.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayStackTest {
	@Test
	public void test(){
		ArrayStack<Integer> stack = new ArrayStack<Integer>(Integer.class, 5);
		assertNull(stack.pop());
		
		stack.push(1);
		assertEquals(1, stack.pop().intValue());

		stack.push(2);
		stack.push(3);
		stack.push(4);

		assertEquals(4, stack.pop().intValue());
		assertEquals(3, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
	}
}
