package com.calvin.cake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * There are two ways to solve this problem.  
 * The key is to realize that we must deal with the "same" coin in the logics....
 * try 
 * 1, 2, 2, 2
 * 1, 1, 2, 2, 2,
 * 1, 1, 1, 2, 2,
 * 
 * We must not allow the logic to do
 * 1, 2, 2, 1, 2 - since this is equivalent to 1, 1, 2, 2, 2, this will yield duplicate count.
 * 
 * @author Calvin
 *
 */
public class CoinChange {
	public static int calculateNumWays(int amount, int[] coins, int startIndex){
		return calculateNumWays(amount, coins, startIndex, new Stack<Integer>());
	}
	
	public static int calculateNumWays(int amount, int[] coins, int startIndex, Stack<Integer> path){
		// Make sure coins are sorted
		//Arrays.sort(coins);
		
		if (amount == 0){
			StringBuilder builder = new StringBuilder();
			path.forEach((c) -> { builder.append(c);});
			System.out.println(builder.toString());
			return 1;
		}
		if (amount < 0){
			return 0;
		}
		
		int numWays = 0;
		
		// First first, 1, 1, 1, 1
		// At each step, we want to try each coin.
		for (int i = startIndex; i < coins.length; i++){
			path.push(coins[i]);
			numWays += calculateNumWays(amount - coins[i], coins, i, path);
			path.pop();
		}
		return numWays;
	}
	
	/**
	 * At each sum, we can try to figure out how many ways to reach there with "this" coin
	 * @param amount
	 * @param coins
	 * @return
	 */
	public static int calculateNumWaysIterative(int amount, int[] coins){
		int[] sums = new int[amount + 1];
		
		sums[0] = 1;
		
		for (int coin : coins){
			for (int i = coin; i <= amount; i++){
				sums[i] = sums[i] + sums[i - coin];
			}
		}
		return sums[amount];
	}
	
	public static int changePossibilitiesTopDown(int amount, int[] denominations) {
		return changePossibilitiesTopDown(amount, denominations, 0, new HashMap<>());
	}

	private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex, HashMap<Integer, Integer> cache) {

		// base cases:
		// we hit the amount spot on. yes!
		if (amountLeft == 0) {
			return 1;
		}

		// we overshot the amount left (used too many coins)
		if (amountLeft < 0) {
			return 0;
		}

		// we're out of denominations
		if (currentIndex == denominations.length) {
			return 0;
		}

		int key = amountLeft * 100 + currentIndex;
		Integer cachedValue = cache.get(key);
		if (cachedValue != null){
			return cachedValue.intValue();
		}
		
		System.out.printf("checking ways to make %d with %s, current coin: %d\n", 
				amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
						currentIndex, denominations.length)), denominations[currentIndex]);

		// choose a current coin
		int currentCoin = denominations[currentIndex];

		// see how many possibilities we can get
		// for each number of times to use currentCoin
		int numPossibilities = 0;
		while (amountLeft >= 0) {
			numPossibilities += changePossibilitiesTopDown(amountLeft, denominations, currentIndex + 1, cache);
			amountLeft -= currentCoin;
		}

		cache.put(key, numPossibilities);
		return numPossibilities;
	}
}

