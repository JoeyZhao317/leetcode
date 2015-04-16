package com.buptcoder.acm;

public class BestProfitForStock {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //O(n^2)
        if (prices == null || prices.length == 1) {
            return 0;
        }
        int max = 0;
        int length = prices.length;
        for (int i = length - 1; i >= 1; i--) {
            int laterPrice = prices[i];
            for (int j = i - 1; j >= 0; j--) {
                int max_tmp = laterPrice - prices[j];
                if (max < max_tmp) {
                    max = max_tmp;
                }
            }
        }
        return max;
    }
    //O(n)
    public int maxProfitImproved(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int current = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
             int max_tmp = prices[i] - current;
             if(max_tmp > max) {
                 max = max_tmp;
             }
             current = current > prices[i] ? prices[i]:current;
        } 
        return max;
    }
}
