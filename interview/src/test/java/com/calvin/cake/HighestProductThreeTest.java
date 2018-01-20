package com.calvin.cake;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Test;

public class HighestProductThreeTest {
	@Test
	public void test(){
		assertEquals(6*10*12, HighestProductThree.findHighest(new int[]{3, 6, 10, 12}));
		assertEquals(6*10*3, HighestProductThree.findHighest(new int[]{3, 6, 10, -12}));
		assertEquals((long)400*200*100, HighestProductThree.findHighest(new int[]{-50, 100, 200, -300, 400}));
		assertEquals((long)400*-300*-500, HighestProductThree.findHighest(new int[]{-500, 100, 200, -300, 400}));
//		assertEquals(6*10*3, HighestProductThree.findHighest(new int[]{3, 6, 10, -12}));
//		assertEquals(6*10*3, HighestProductThree.findHighest(new int[]{3, 6, 10, -12}));
//		assertEquals(6*10*3, HighestProductThree.findHighest(new int[]{3, 6, 10, -12}));
	}
	@Test
	public void testPriorityQueue(){
		PriorityQueue<Integer> queueMinNeg = new PriorityQueue<Integer>(4);
		queueMinNeg.offer(-100);
		queueMinNeg.offer(-200);
		queueMinNeg.offer(-300);
		assertEquals(-300, queueMinNeg.poll().intValue());
		assertEquals(-200, queueMinNeg.poll().intValue());
		assertEquals(-100, queueMinNeg.poll().intValue());
		assertNull(queueMinNeg.poll());
		queueMinNeg.offer(-100);
		queueMinNeg.offer(-100);
		assertEquals(-100, queueMinNeg.poll().intValue());
		assertEquals(-100, queueMinNeg.poll().intValue());
	}
}
