package com.calvin.interview.io;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxStockProfitTest {
	private static double EPSILON = 0.00001;
	@Test
	public void testCreate(){
		MaxStockProfit s = new MaxStockProfit();
		double[] prices = {1.0, 1.1, 1.2, 1.1, 1.0};
		s.getMaxProfit(prices);
	}
	
	@Test
	public void testScenario1(){
		MaxStockProfit s = new MaxStockProfit();
		double[] prices = {1.0, 1.1, 1.2, 1.1, 1.0};
		double[] result = s.getMaxProfit(prices);
		assertTrue(Math.abs(result[0] - 0.2) <= EPSILON);
		assertTrue(Math.abs(result[1] - 1.0) <= EPSILON);
		assertTrue(Math.abs(result[2] - 1.2) <= EPSILON);
	}
	
	@Test
	public void testScenario2(){
		MaxStockProfit s = new MaxStockProfit();
		double[] prices = {1.0, 1.0, 1.0, 1.0, 1.0};
		double[] result = s.getMaxProfit(prices);
		assertTrue(Math.abs(result[0]) <= EPSILON);
		assertTrue(Math.abs(result[1] - 1.0) <= EPSILON);
		assertTrue(Math.abs(result[2] - 1.0) <= EPSILON);
	}
	
	@Test
	public void testScenario3(){
		MaxStockProfit s = new MaxStockProfit();
		double[] prices = {5.0, 2.0, 1.0, 0.5, 0.20};
		double[] result = s.getMaxProfit(prices);
		assertTrue(Math.abs(result[0] + 0.3) <= EPSILON);
		assertTrue(Math.abs(result[1] - 0.5) <= EPSILON);
		assertTrue(Math.abs(result[2] - 0.2) <= EPSILON);
	}

	@Test
	public void testScenario4(){
		MaxStockProfit s = new MaxStockProfit();
		double[] prices = {5.0, 4.0, 3.5, 3.0, 2.0};
		double[] result = s.getMaxProfit(prices);
		assertTrue(Math.abs(-0.5 - result[0]) <= EPSILON);
		assertEquals(4.0, result[1], EPSILON);
		assertEquals(3.5, result[2], EPSILON);
	}

}
