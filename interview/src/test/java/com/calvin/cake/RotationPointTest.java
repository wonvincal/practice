package com.calvin.cake;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotationPointTest {
	@Test
	public void test(){
		String[] words = new String[]{
			    "ptolemaic",
			    "retrograde",
			    "supplant",
			    "undulate",
			    "xenoepist",
			    "asymptote",  // <-- rotates here!
			    "babka",
			    "banoffee",
			    "engender",
			    "karpatka",
			    "othellolagkage",
			};
		assertEquals(4, RotationPoint.findRotationPoint(words, 0, words.length - 1));

		words = new String[]{
			    "ptolemaic",
			    "retrograde",
			    "supplant",
			    "undulate",
			    "xenoepist",
			    "yabc",
			    "yyab",
			    "asymptote",  // <-- rotates here!
			    "babka",
			    "banoffee",
			    "engender",
			    "karpatka",
			    "othellolagkage",
			};
		assertEquals(6, RotationPoint.findRotationPoint(words, 0, words.length - 1));

	}
}
