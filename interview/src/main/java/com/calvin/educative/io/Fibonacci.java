package com.calvin.educative.io;

import java.util.Arrays;

public class Fibonacci {
	public static long calculate(int n){
		return fibDynIter(n);
	}

	
	private static long fibDynIter(int n){
		if (n <= 1){
			return n;
		}
		long result = 0;
		long n_1 = 1;
		long n_2 = 0;
		for (int i = 2; i <= n; i++){
			result = n_1 + n_2;
			n_2 = n_1;
			n_1 = result;
		}
		return result;
	}
	
	private static long fibDyn(int n){
		if (n <= 1){
			return n;
		}
		long[] cache = new long[n + 1];
		Arrays.fill(cache, -1);
		return fibDyn(n, cache);
	}
	
	private static long fibDyn(int n, long[] cache){
		if (n <= 1){
			return n;
		}
		long n1 = cache[n - 1];
		if (n1 == -1){
			n1 = fibDyn(n - 1, cache);			
		}
		long n2 = cache[n - 2];
		if (n2 == -1){
			n2 = fibDyn(n - 2, cache);
		}
		long result = n1 + n2;
		cache[n] = result;
		return result;

	}

	
	private static long fibBrute(int n){
		if (n <= 1){
			return n;
		}
		return fibBrute(n - 1) + fibBrute(n - 2);
	}
}
