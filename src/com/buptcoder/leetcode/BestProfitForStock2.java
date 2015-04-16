package com.buptcoder.leetcode;

public class BestProfitForStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        int currentStock = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price - currentStock > 0) {
                profit = profit + price - currentStock;
            }
            currentStock = price;
        }
        return profit;
    }
}
