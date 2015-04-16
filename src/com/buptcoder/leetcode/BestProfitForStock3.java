package com.buptcoder.leetcode;

public class BestProfitForStock3 {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int length = prices.length;
        int[] profitFromStart = new int[length];
        int[] profitFromEnd = new int[length];
        int current = prices[0];
        int max = 0;
        for (int i = 0; i < length; i++) {
            int price = prices[i];
            int profit = price - current;
            if (profit > max) {
                max = profit;
            }
            if (price <= current) {
                current = price;
            }
            profitFromStart[i] = max;
        }
        current = prices[length - 1];
        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            int price = prices[i];
            int profit = current - price;
            if (profit > max) {
                max = profit;
            }
            if (price >= current) {
                current = price;
            }
            profitFromEnd[i] = max;
        }
        max = profitFromStart[0] + profitFromEnd[0];
        for (int i = 0; i < length; i++) {
            int tmpMax = profitFromStart[i] + profitFromEnd[i];
            if (tmpMax > max) {
                max = tmpMax;
            }
        }
        return max;
    }
}
