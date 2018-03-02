package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 *
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 *
 * In this case, no transaction is done, i.e. max profit = 0.
 *
 * 说明： 数组必须按照先买后卖的顺序，可以在任意一点买，在任意一点卖，寻找利润最高的，如果卖的比买的低，则利润为零
 */

public class BestTimeToBuyAndSellStock_121 {

  public static void main(String[] args) {

    int[] nums = {6, 8, 9, 2, 40, 36, 99};
    System.out.println(func(nums));
  }

  static int func(int[] nums) {

    int min = nums[0];
    int max = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > min) {
        max = Math.max(max, nums[i] - min);
      } else {
        min = nums[i];
      }
    }

    return max;
  }

  /**
   * 官方答案
   */
  public int maxProfit(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice)
        minprice = prices[i];
      else if (prices[i] - minprice > maxprofit)
        maxprofit = prices[i] - minprice;
    }
    return maxprofit;
  }

}
