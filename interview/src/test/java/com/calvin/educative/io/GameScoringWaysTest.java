package com.calvin.educative.io;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameScoringWaysTest {
	@Test
	public void test(){
		assertEquals(10, GameScoringWays.findWays(5));
	}
}
