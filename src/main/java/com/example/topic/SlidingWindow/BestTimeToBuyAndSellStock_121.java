package com.example.topic.SlidingWindow;


/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuyAndSellStock_121 {

    // Using brute force
    // Find all the pair and calculate
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        System.out.println(maxProfit);
        return maxProfit;
    }

    //using two pointers
    public int maxProfitSol2(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        int l = 0, r = 1;
        while (r < len) {
            if (prices[r] < prices[l]) {
                l = r;
            }
            maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            r++;
        }
        return maxProfit;
    } //using two pointers

    public int maxProfitSol3(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;

    }
}
