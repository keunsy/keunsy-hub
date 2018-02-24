package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * 说明：基于第一个问题基础上，要求算总的最高利润
 * 解析：其实就是算连续两个数的差值和
 */

public class BestTimeToBuyAndSellStock2_122 {

  public static void main(String[] args) {

    int[] nums = {6, 8, 9, 2, 40, 36, 99};
    System.out.println(maxProfit(nums));
  }

  static int maxProfit(int[] prices) {
    int maxprofit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1])
        maxprofit += prices[i] - prices[i - 1];
    }
    return maxprofit;
  }

}
