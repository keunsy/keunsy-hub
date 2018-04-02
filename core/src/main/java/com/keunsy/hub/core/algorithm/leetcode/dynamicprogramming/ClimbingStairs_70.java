package com.keunsy.hub.core.algorithm.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 *
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 *
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 说明：爬梯子问题，每次可以爬1或者2个阶位，给定总的阶数，求一共有多少种方法
 */
public class ClimbingStairs_70 {

  public static void main(String[] args) {

    System.out.println(func(10));
    System.out.println(climbStairs(10));

  }

  private static int func(int n) {

    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }

    return func(n - 1) + func(n - 2);
  }

  /**
   * dp 方法
   */
  static int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  /**
   * Fibonacci 斐波那契 方法
   */
  public int climbStairs2(int n) {
    if (n == 1) {
      return 1;
    }
    int first = 1;
    int second = 2;
    for (int i = 3; i <= n; i++) {
      int third = first + second;
      first = second;
      second = third;
    }
    return second;
  }

  /**
   * Fibonacci 斐波那契公式
   */
  public int climbStairs3(int n) {
    double sqrt5 = Math.sqrt(5);
    double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
    return (int) (fibn / sqrt5);
  }
}
