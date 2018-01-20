package com.calvin.educative.io.math;

import java.util.HashMap;

public class PowerOf {
	public static double calculate(double base, int exp){
		int signum = Integer.signum(exp);
		exp = Math.abs(exp);
//		HashMap<Integer, Double> cache = new HashMap<>(exp);
//		if (signum != -1){
//			return PowerOf.power(base, exp, cache);
//		}
//		return 1.0 / PowerOf.power(base, exp, cache);
		if (signum != -1){
			return PowerOf.powerWithoutMap(base, exp);
		}
		return 1.0 / PowerOf.powerWithoutMap(base, exp);
	}

	private static double powerWithoutMap(double base, int exp){
		if (exp == 0){
			return 1;
		}
		if (exp == 1){
			return base;
		}
		int half = exp / 2;
		double result = powerWithoutMap(base, half);
		return (exp % 2 == 0) ? result * result : result * result * base;
	}
	private static double power(double base, int exp, HashMap<Integer, Double> cache){
		if (exp == 0){
			return 1;
		}
		if (exp == 1){
			return base;
		}
		Double cached = cache.get(exp);
		if (cached != null){
			return cached.doubleValue();
		}
		int first = exp / 2;
		int second = exp - first;
		double result = power(base, first, cache) * power(base, second, cache); 
		cache.put(exp, result);
		return result;
	}
}
