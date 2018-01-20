package com.calvin.interview.io;

import org.junit.Assert;
import org.junit.Test;

public class CalculateProductTest {
	@Test(expected=IllegalArgumentException.class)
	public void testException(){
		CalculateProduct product = new CalculateProduct();
		Assert.assertArrayEquals(new int[]{1}, product.calculate(new int[]{1}));
	}

	@Test
	public void testCreate(){
		CalculateProduct product = new CalculateProduct();
		Assert.assertArrayEquals(new int[]{0, 0}, product.calculate(new int[]{0, 0}));
	}
	
	@Test
	public void testScenario1(){
		CalculateProduct product = new CalculateProduct();
		Assert.assertArrayEquals(new int[]{540, 270, 90, 108, 60}, product.calculate(new int[]{1, 2, 6, 5, 9}));
	}
	
	@Test
	public void testScenario2(){
		CalculateProduct product = new CalculateProduct();
		Assert.assertArrayEquals(new int[]{2*3*4*5, 1*3*4*5, 1*2*4*5, 1*2*3*5, 1*2*3*4}, product.calculate(new int[]{1, 2, 3, 4, 5}));
	}

	@Test
	public void testScenario3(){
		CalculateProduct product = new CalculateProduct();
		Assert.assertArrayEquals(new int[]{1, 10}, product.calculate(new int[]{10, 1}));
	}

}
