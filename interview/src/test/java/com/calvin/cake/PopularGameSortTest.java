package com.calvin.cake;

import org.junit.Test;
import static org.junit.Assert.*;

public class PopularGameSortTest {
	@Test
	public void test(){
		int[] rawScores = new int[]{37, 89, 41, 65, 91, 53};
		final int HIGHEST_POSSIBLE_SCORE = 100;
		PopularGameSort.sortScores(rawScores, HIGHEST_POSSIBLE_SCORE);
		assertArrayEquals(new int[]{91, 89, 65, 53, 41, 37}, rawScores);
	}
}
