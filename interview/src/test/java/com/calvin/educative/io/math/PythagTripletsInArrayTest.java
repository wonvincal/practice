package com.calvin.educative.io.math;

import java.util.List;

import org.junit.Test;

import com.calvin.educative.io.math.PythagTripletsInArray;

public class PythagTripletsInArrayTest {
	@Test
	public void test(){
		int[] items = new int[]{4,16,1,2,3,5,6,8,25,10};
		List<String> triplets = PythagTripletsInArray.find(items);
		triplets.forEach((c) -> {System.out.println(c);});
	}
}
