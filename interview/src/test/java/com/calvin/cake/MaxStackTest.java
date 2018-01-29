package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxStackTest {
	@Test
	public void test(){
		MaxStack stack = new MaxStack();
		stack.push(10);
		assertEquals(10, stack.getMax());
		stack.push(50);
		stack.push(30);
		assertEquals(50, stack.getMax());
		stack.push(50);
		stack.push(30);
		assertEquals(50, stack.getMax());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		assertEquals(10, stack.getMax());
	}
}
