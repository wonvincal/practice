package com.calvin.cake;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedTest {
	@Test
	public void test(){
		int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
		int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

		Assert.assertArrayEquals(
				new int[]{1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19},
				MergeSorted.merge(myArray, alicesArray));
		System.out.println(Arrays.toString(MergeSorted.merge(myArray, alicesArray)));

		myArray     = new int[]{3, 4, 6, 10, 11, 15};
		alicesArray = new int[]{};
		Assert.assertArrayEquals(
				new int[]{3, 4, 6, 10, 11, 15},
				MergeSorted.merge(myArray, alicesArray));
	}

}
