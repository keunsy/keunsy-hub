package com.keunsy.hub.core.algorithm.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/description/
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 *
 * 说明：
 */
public class CoinChange_322 {

  public static void main(String[] args) {

    int nums[] = {1, 2, 5};
    System.out.println(coinChange(nums, 10));

  }

  /**
   * todo 待进一步研究确认
   */
  static int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];//最大只有 amcount 枚硬币
    Arrays.fill(dp, max);//填充设置为最大的硬币数+1，用于判断是否均满足要求
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {//当前硬币值小于 剩余总额
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);//求最小的数量
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }

}
