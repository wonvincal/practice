package com.calvin.cake;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StringProcessorTest {
	@Test
	public void test(){
		assertEquals(0, StringProcessor.reverseInPlace("ABCDE").compareTo("EDCBA"));
	}
	
	@Test
	public void testReverseWordsInPlace(){
		assertEquals(0, StringProcessor.reverseWordsInStringInPlace("I HAVE A MACHINE").compareTo("MACHINE A HAVE I"));

		String message = "find you will pain only go you recordings security the into if";
		String expected = "if into the security recordings you go only pain will you find";
		assertEquals(0, StringProcessor.reverseWordsInStringInPlace(message).compareTo(expected));

		message = "find you will pain only go you recordings security the into if ";
		expected = " if into the security recordings you go only pain will you find";
		assertEquals(0, StringProcessor.reverseWordsInStringInPlace(message).compareTo(expected));

		message = "find you will pain only go you recordings security the into if   ";
		expected = "   if into the security recordings you go only pain will you find";
		assertEquals(0, StringProcessor.reverseWordsInStringInPlace(message).compareTo(expected));

		message = "find   you will pain only go you recordings security the into if   ";
		expected = "   if into the security recordings you go only pain will you   find";
		assertEquals(0, StringProcessor.reverseWordsInStringInPlace(message).compareTo(expected));
	}

	@Test
	public void testPermutation(){
		List<String> permutation = StringProcessor.permutation("ABCDE");
		permutation.forEach((c) -> System.out.println(c));
	}
	
	@Test
	public void testFindClosingBracketPosition(){
		String message = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		assertEquals(79, StringProcessor.findClosingBracketPosition(message, 10));
	}

	@Test
	public void testValidateBrackets(){
		String message = "{ [ ] ( ) }";
		assertTrue(StringProcessor.validateBrackets(message));
		message = "{ [ ( ] ) }";
		assertFalse(StringProcessor.validateBrackets(message));
		message = "{ [ }";
		assertFalse(StringProcessor.validateBrackets(message));
	}
	
	@Test
	public void testPalindrome(){
		assertTrue(StringProcessor.hasPalindrome("civic"));
		assertTrue(StringProcessor.hasPalindrome("ivicc"));
		assertFalse(StringProcessor.hasPalindrome("civil"));
		assertFalse(StringProcessor.hasPalindrome("livci"));
	}

}
