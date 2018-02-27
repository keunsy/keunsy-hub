package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 *
 * 说明：查找最长的连续递增子数组，返回其长度（注：相等不属于递增）
 */
public class LongestContinuousIncreasingSubsequence_674 {


  public static void main(String[] args) {
    int nums[] = {2, 2, 2, 2, 2};
//    int nums[] = {1, 3, 5, 4, 7};

    System.out.println(func(nums));
  }

  private static int func(int[] nums) {

    int maxLength = 1;
    int currLength = 1;
    for (int i = 1; i < nums.length; i++) {

      if (nums[i] > nums[i - 1]) {

        currLength++;
        if (currLength > maxLength) {//置换最大长度
          maxLength = currLength;
        }

      } else {

        if (maxLength > (nums.length - i)) {//当前最大长度已经大于剩余长度，则结束循环
          return maxLength;
        }

        currLength = 1;//重置
      }

    }

    return maxLength;
  }

  /**
   * 简单方案
   */
  public int findLengthOfLCIS(int[] a) {
    int mx = 0, len = 0;
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] <= a[i - 1]) len = 0;
      mx = Math.max(mx, ++len);
    }
    return mx;
  }

  /**
   * 快慢
   */
  public int findLengthOfLCIS2(int[] a) {
    int mx = 0;
    for (int i = 0, j = 0; j < a.length; i = (j == 0 || a[j] <= a[j - 1]) ? j : i, mx = Math.max(mx, j - i + 1), j++) {
    }
    return mx;
  }

}
