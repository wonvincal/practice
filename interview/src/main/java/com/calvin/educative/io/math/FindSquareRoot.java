package com.calvin.educative.io.math;

public class FindSquareRoot {
	public static double findSqrt(double number){
		double start = 0;
		double end = number;
		double mid = (end - start) / 2;
		
		double square = mid * mid;
		while (Math.abs(square - number) > 0.00001){
			if (square > number){
				end = mid;
			}
			
			else {
				start = mid;
			}
			mid = (end + start) / 2;
			square = mid * mid;
		}
		System.out.println(mid);
		return mid;
	}

	public static double findSqrtRecursive(double number){
		return findSqrtRecursive(0, number, number);
	}

	
	public static double findSqrtRecursive(double start, double end, double number){
//		double start = 0;
//		double end = number;
		double mid = (end + start) / 2;
		
		double square = mid * mid;
		if (Math.abs(square - number) <= 0.00001)
		{
			return mid;
		}
		System.out.println(mid);
		
		if (square > number){
			return findSqrtRecursive(start, mid, number);
		}
		else{
			return findSqrtRecursive(mid, end, number);			
		}
	}

}
