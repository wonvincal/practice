package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.cake.RectangleIntercept.Rectangle;

public class RectangleInterceptTest {
	@Test
	public void test(){
		Rectangle rect1 = new Rectangle(1, 1, 14, 9);
		Rectangle rect2 = new Rectangle(10, 5, 6, 7);
		Rectangle expected = new Rectangle(10, 5, 5, 5);
		Rectangle result = rect1.interects(rect2);
		System.out.println(rect1);
		System.out.println(rect2);
		System.out.println(result);
		System.out.println(expected);
		assertTrue(expected.equals(result));
	}
}
