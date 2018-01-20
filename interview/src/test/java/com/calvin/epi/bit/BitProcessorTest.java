package com.calvin.epi.bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitProcessorTest {
	@Test
	public void testCountBits(){
		assertEquals(1, BitProcessor.countBits(8));
		assertEquals(0, BitProcessor.countBits(0));
		assertEquals(2, BitProcessor.countBits(12));
		assertEquals(3, BitProcessor.countBits(13));
		assertEquals(5, BitProcessor.countBits(1024 + 512 + 8 + 4 + 1));
		System.out.println(Character.getNumericValue('A'));
	}
	@Test
	public void testParity(){
		assertEquals(0, BitProcessor.parity(12));
		assertEquals(1, BitProcessor.parity(8));
		long x = 1;
		x <<= 32;
		x -= 1;
		assertEquals(0, BitProcessor.parity(x));
		x = 1;
		x <<= 31;
		x -= 1;
		assertEquals(1, BitProcessor.parity(x));
	}
	@Test
	public void testSwapBits(){
		assertEquals(11, BitProcessor.swapBitFast(73, 1, 6));
	}
	@Test
	public void testReverse(){
		String inputStr = "01010";
		long input = Long.parseLong(inputStr, 2);
		String expectedStrPrefix = "01010";
		for (int i = inputStr.length(); i < 63; i++){
			expectedStrPrefix += "0";
		}
		System.out.println("length: " + expectedStrPrefix.length());
		long expected = Long.parseLong(expectedStrPrefix, 2);
//		long jMask = 1;
//		jMask <<= 63;
//		System.out.println("jMask:" + Long.toBinaryString(jMask));
		
		assertEquals(expected, BitProcessor.reverseBrute(input));
		System.out.println(Long.toBinaryString(expected));
	}
}
