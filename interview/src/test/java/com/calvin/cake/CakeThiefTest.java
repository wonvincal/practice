package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

import com.calvin.cake.CakeThief.CakeType;

public class CakeThiefTest {
	@Test
	public void test(){
		CakeType[] cakeTypes = new CakeType[]{
				new CakeType(7, 160),
				new CakeType(3, 90),
				new CakeType(2, 15)
		};
	
		assertEquals(555, CakeThief.maxDuffelBagValue(cakeTypes, 20));
	}
}
