package com.calvin.interview.io;

public class MaxStockProfit {
	/**
	 * What happens when the price keeps falling.  We need to pick one with minimal
	 * loss.
	 * @param prices
	 * @return
	 */
	private double[] getMaxProfitNaive(double[] prices){		
		double maxProfit = -1;
		double buyAt = -1;
		double sellAt = -1;
		for (int i = 0; i < prices.length - 1; i++){
			double buy = prices[i];
			double sell = prices[i + 1]; 
			double profit = sell - buy;
			if (profit > maxProfit){
				maxProfit = profit;
				buyAt = buy;
				sellAt = sell;
			}
			for (int j = i + 2; j < prices.length; j++){
				double currentSell = prices[j];
				if (currentSell > sell){
					sell = currentSell;
					profit = sell - buy;
					if (profit > maxProfit){
						maxProfit = profit;
						buyAt = buy;
						sellAt = sell;
					}
				}
			}
		}
		return new double[]{maxProfit, buyAt, sellAt};		
	}

	public double[] getMaxProfit(double[] prices){
		return getMaxProfitNaive(prices);
	}
}
