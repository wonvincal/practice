package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindRepeatTest {
	@Test
	public void test(){
		assertEquals(3, FindRepeat.beastMode(new int[]{3,4,2,3,1,5}));
	}
}
