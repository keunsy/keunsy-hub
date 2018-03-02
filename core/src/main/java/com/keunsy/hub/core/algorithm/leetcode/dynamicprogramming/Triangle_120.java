package com.keunsy.hub.core.algorithm.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/triangle/description/
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * 说明：
 */
public class Triangle_120 {

  public static void main(String[] args) {

    int[][] nums = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}

//            {7},
//            {3, 8},
//            {8, 1, 0},
//            {2, 7, 4, 4},
//            {4, 5, 2, 6, 5}
    };
//    System.out.println(func(nums));
    System.out.println(minimumTotal(nums));

  }

  private static int func(int[][] nums) {

    int[][] dp = new int[nums.length][nums[nums.length - 1].length];
    dp[0][0] = nums[0][0];
//    dp[1][0] = nums[1][0] + nums[0][0];
//    dp[1][1] = nums[1][1] + nums[0][0];

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        if (j == 0) {
          dp[i][j] = nums[i][j] + dp[i - 1][j];
        } else if (j == nums[i].length - 1) {
          dp[i][j] = nums[i][j] + dp[i - 1][j - 1];
        } else {
          dp[i][j] = nums[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
        }
      }
    }

    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < dp[nums.length - 1].length; i++) {
      minSum = Math.min(minSum, dp[nums.length - 1][i]);
    }
    return minSum;
  }


  /**
   * 最优解答 todo 进一步分析
   */
  static int minimumTotal(int[][] nums) {

    int[] dp = new int[nums.length + 1];
    for (int i = nums.length - 1; i >= 0; i--) // For each i
    {
      for (int j = 0; j < nums[i].length; j++) // Check its every 'node'
      {
        // Find the lesser of its two children, and sum the current value in the triangle with it.
        dp[j] = Math.min(dp[j], dp[j + 1]) + nums[i][j];
      }
    }
    return dp[0];
  }


  /**
   * 变形 求最大和
   */
  private static int func2(int[][] nums) {

    int[][] dp = new int[nums.length][nums[nums.length - 1].length];
    dp[0][0] = nums[0][0];
    dp[1][0] = nums[1][0] + nums[0][0];
    dp[1][1] = nums[1][1] + nums[0][0];

    for (int i = 2; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        if (j == 0) {
          dp[i][j] = nums[i][j] + dp[i - 1][j];
        } else if (j == nums[i].length - 1) {
          dp[i][j] = nums[i][j] + dp[i - 1][j - 1];
        } else {
          dp[i][j] = nums[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
        }
      }
    }

    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < dp[nums.length - 1].length; i++) {
      maxSum = Math.max(maxSum, dp[nums.length - 1][i]);
    }
    return maxSum;
  }

}
