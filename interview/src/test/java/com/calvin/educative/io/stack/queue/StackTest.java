package com.calvin.educative.io.stack.queue;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTest {
	@Test
	public void test(){
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		assertTrue("Test", "C".equals(stack.pop()));

		StackPollFast stackPollFast = new StackPollFast();
		stackPollFast.push("A");
		stackPollFast.push("B");
		stackPollFast.push("C");
		assertTrue("Test", "C".equals(stackPollFast.pop()));

	}
}
