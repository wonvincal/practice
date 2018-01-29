package com.calvin.cake;

import java.util.Random;

public class RandomProcessor {
	static Random rand = new Random();
	public static int rand7(){
		return rand.nextInt(7) + 1;
	}

	/**
	 * Rand7 generates 1 to 7.
	 *
	 * @return
	 */
	public static int rand5(){
		// Actually this solution is the easiest!
		// Each result has the same chance of 1/7, equal to each other.
		int result = 7;
		while (result > 5){
			result = rand7();
		}
		return result;
	}
	
	public static int rand7GivenRand5(){
		// Do something on rand5 to produce evenly distributed output
		// Limit the total to only divisible by 5
		int result = 5 * rand5() + rand5();
		while (result > 28){
			result = 5 * rand5() + rand5();
		}
		return result % 7;
	}
}
