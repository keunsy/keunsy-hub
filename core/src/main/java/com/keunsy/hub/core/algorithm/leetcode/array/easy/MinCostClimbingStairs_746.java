package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 *
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 *
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
 *
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * Note:
 * cost will have a length in the range [2, 1000].
 * Every cost[i] will be an integer in the range [0, 999].
 *
 * 说明： 将数组走完，找花费总额最低的路线，输出花费总额，可以从0或者1开始，每次都可以走1或者2个位置。
 *
 * #Dynamic Programming
 */
public class MinCostClimbingStairs_746 {


  public static void main(String[] args) {
    int nums[] = {1, 100, 1, 1, 1};


    System.out.println(func(nums));
    System.out.println(minCostClimbingStairs(nums));

  }

  private static int func(int[] nums) {

    return Math.min(climbingStairs(nums, 0),
            climbingStairs(nums, 1));
  }

  private static int climbingStairs(int[] nums, int index) {

    if (index >= nums.length - 2) {
      return nums[index];
    }

    return nums[index] + Math.min(climbingStairs(nums, index + 1), climbingStairs(nums, index + 2));
  }


  /**
   * dp 方法解答
   */
  static int minCostClimbingStairs(int[] nums) {
    int[] dp = new int[nums.length + 1];
    dp[0] = nums[0];
    dp[1] = nums[1];

    for (int i = 2; i <= nums.length; i++) {
      int costV = (i == nums.length) ? 0 : nums[i];
      dp[i] = costV + Math.min(dp[i - 1], dp[i - 2]);
    }
    return dp[nums.length];
  }

  /**
   * 简单方法
   */
  static int minCostClimbingStairs2(int[] cost) {
    int f1 = 0, f2 = 0;
    for (int i = cost.length - 1; i >= 0; --i) {
      int f0 = cost[i] + Math.min(f1, f2);
      f2 = f1;
      f1 = f0;
    }
    return Math.min(f1, f2);
  }
}
