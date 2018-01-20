package com.calvin.epi.bit;

public class BitProcessor {
	public static short countBits(int x){
		short numBits = 0;
		while (x != 0){
			numBits += (x & 1);
			x >>>= 1;
		}
		return numBits;
	}
	public static short parity(long x){
		return parityFast(x);
	}
	private static short parityBrute(long x){
		short result = 0;
		while (x != 0){
			result ^= (x & 1);
			x >>>= 1;
		}
		return result;		
	}
	/**
	 * O(k) where k is the number of bit set
	 * @param x
	 * @return
	 */
	private static short parityShortcut(long x){
		short result = 0;
		while (x != 0){
			result ^= 1;
			x &= (x - 1); // Drop lowest set bit of x
		}
		return result;
	}
	
	private static int NUM_SLOTS = (int)Math.pow(2, 16);
	private static int[] PARITIES = new int[NUM_SLOTS];
	
	static {
		for (int i = 0; i < NUM_SLOTS; i++){
			PARITIES[i] = parityShortcut(i);
		}
	}
	/**
	 * O(n/L) or o(n/16)
	 * @param x
	 * @return
	 */
	private static short parityFast(long x){
		long mask = 0x0000FFFF;
		short result = 0;
		while (x != 0){
			int lookup = (int)(x & mask);
			result ^= PARITIES[lookup];
			x >>>= 16;
		}
		return result;
	}
	
	/**
	 * If the two bits are same, no need to swap.
	 * If they are different, we just need to flip it
	 * @param input
	 * @param i
	 * @param j
	 * @return
	 */
	public static long swapBitFast(long input, int i, int j){
		long iMask = 1;
		iMask <<= i;
		long jMask = 1;
		jMask <<= j;
		long iValue = input & iMask;
		System.out.println("i: " + i + ", j: " + j);
		System.out.println("Mask with i: iValue:" + Long.toBinaryString(iValue));

		long jValue = input & jMask;
		System.out.println("Mask with j: jValue:" + Long.toBinaryString(jValue));
		if (iValue >> i == jValue >> j){
			return input;
		}
		System.out.println("iMask: " + Long.toBinaryString(iMask));
		System.out.println("jMask: " + Long.toBinaryString(jMask));
		// Flip a bit - XOR with 1 (0 XOR 1 = 1, 1 XOR 1 = 0) (0 XOR 0 -> 0, 1 XOR 0 -> 1)
		input ^= (jMask | iMask);
		return input;
	}
	
	public static long swapBit(long input, int i, int j){
		long iMask = 1 << i;
		long jMask = 1 << j;
		long iValue = input & iMask;
		long jValue = input & jMask;
		
		if (i > j){ // 7 -> 4
			iValue >>>= (i - j);
			jValue <<= (j - i);
		}
		else {
			iValue >>>= (j - i);
			jValue <<= (i - j);			
		}
		
		// Clear bit at i and j
		input &= (~iMask);
		input &= (~jMask);
		input |= iValue;
		input |= jValue;
		return input;
	}

	public static long reverseBrute(long input){
		int i =  0;
		int j = 63;
		System.out.println(Long.toBinaryString(input));
		while (i < j){
			input = BitProcessor.swapBitFast(input, i, j);
			System.out.println(Long.toBinaryString(input) + ": Swap " + i + " with " + j);
			i++;
			j--;
		}
		return input;
	}
}
