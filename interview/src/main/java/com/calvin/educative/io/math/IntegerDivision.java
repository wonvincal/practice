package com.calvin.educative.io.math;

public class IntegerDivision {
	/**
	 * The key is to use x2 to speed up the process
	 * Then to use recursion to finish off the remainder
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor){
		int quotient = 1;
		int temp = divisor;
		
		if (dividend < divisor){
			return 0;
		}
		if (dividend == divisor){
			return 1;
		}
		if (divisor == 0){
			return -1;
		}
		
		while (temp < dividend){
			quotient <<= 1;
			temp <<= 1;
		}
		quotient >>= 1;
		temp >>= 1;
		return quotient + divide(dividend - temp, divisor);
	}
}
