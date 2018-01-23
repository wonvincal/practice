package com.calvin.cake;

import java.util.Arrays;

public class Fib {
	private static final int[] cache;
	static {
		cache = new int[100];
		Arrays.fill(cache, -1);
	}
	public static int calculate(int n){
		if (n == 1){
			return 1;
		}
		if (n == 0){
			return 0;
		}
		
		int cached = cache[n];
		if (cached != -1){
			return cached;
		}
		
		int sum = calculate(n - 1) + calculate(n - 2); 
		cache[n] = sum;
		return sum;
	}

	public static int calculateIterative(int n){
		if (n == 0){
			return 0;
		}
		if (n == 1){
			return 1;
		}
		// f(5)
		// f(4) + f(3)
		// f(3) + f(2) + f(2) + f(1)
		// f(2) + f(1) + f(2) + 		
		// f(2)
		// f(0)
		
		// f(1)
		// f(2) = f(1) + f(0)
		// f(3) = f(2) + f(1)
		// f(4) = f(3) + f(2)		
		int fN_2 = 0;
		int fN_1 = 1;
		int fN = 1;
		for (int i = 2; i <= n; i++){
			fN = fN_1 + fN_2;
			fN_2 = fN_1;
			fN_1 = fN;
		}
		return fN;
	}
}
