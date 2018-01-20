package com.calvin.educative.io.stack.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {
	@Test
	public void test(){
		Queue queue = new Queue();
		queue.offer("A");
		queue.offer("B");
		queue.offer("C");
		assertTrue("A".equals(queue.poll()));
		assertTrue("B".equals(queue.poll()));
		assertTrue("C".equals(queue.poll()));
	}
}
