package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class DroneFinderTest {
	@Test
	public void test(){
		int[] missing = DroneFinder.findMissing(new int[]{1, 3, 5, 7, 5, 3, 7});
		assertArrayEquals(new int[]{1}, missing);

		missing = DroneFinder.findMissing(new int[]{1, 3, 5, 7, 5, 3, 7});
		assertArrayEquals(new int[]{1}, missing);

		int unique = DroneFinder.findMissingFast(new int[]{1, 3, 5, 7, 5, 3, 7});
		assertEquals(1, unique);
	}
}
