package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 *
 *
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 *
 * 说明：求连续的数组和最大的平均值(k表示连续的个数)
 * 也就求连续K个数的最大和
 */
public class MaximumAverageSubarray1_643 {


  public static void main(String[] args) {
    int nums[] = {1, 12, -5, -6, 50, 3};
    System.out.println(func(nums, 4));

  }

  static double func(int[] nums, int k) {

    double maxSum = 0;
    int currMaxSum = 0;
    for (int i = 0; i < nums.length - 1; i++) {

      if (i <= k - 1) {
        currMaxSum += nums[i];
      }
      if (i >= k - 1) {
        maxSum = Math.max(maxSum, Math.max(currMaxSum - nums[i - k + 1] + nums[i + 1], currMaxSum));
        currMaxSum = nums[i - k + 1] + nums[i + 1];
      }
    }

    return maxSum / k;
  }

  /**
   * 优质解答
   */
  public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; i++)
      sum += nums[i];
    double res = sum;
    for (int i = k; i < nums.length; i++) {
      sum += nums[i] - nums[i - k];
      res = Math.max(res, sum);
    }
    return res / k;
  }


}
