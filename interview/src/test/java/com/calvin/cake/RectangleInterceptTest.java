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
		System.out.println("Rect1: " + rect1);
		System.out.println("Rect2: " + rect2);
		System.out.println("Result: " + result);
		System.out.println("Expected: " + expected);
		assertTrue(expected.equals(result));
		
		
		Rectangle rect3 = new Rectangle(1, 1, 9, 9);
		Rectangle rect4 = new Rectangle(5, 5, 2, 2);
		Rectangle result2 = rect3.interects(rect4);
		assertTrue(rect4.equals(result2));

		Rectangle rect5 = new Rectangle(1, 1, 9, 9);
		Rectangle rect6 = new Rectangle(11, 11, 2, 2);
		Rectangle result3 = rect5.interects(rect6);
		assertTrue(Rectangle.NULL_RECTANGLE.equals(result3));

		Rectangle rect7 = new Rectangle(1, 1, 9, 9);
		Rectangle rect8 = new Rectangle(1, 10, 2, 2);
		Rectangle result4 = rect7.interects(rect8);
		System.out.println("Result x: " + result4);
	}
}
