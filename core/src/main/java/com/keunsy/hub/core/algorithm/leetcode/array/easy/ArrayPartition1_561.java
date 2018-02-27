package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/description/
 *
 *
 *
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 *
 * 说明：数组一定是偶数个数据，找出所有对最小值的 最大和
 */
public class ArrayPartition1_561 {


  public static void main(String[] args) {
    int nums[] = {1, 4, 3, 2};

    System.out.println(func(nums));
  }

  private static int func(int[] nums) {

    //排序 直接累加偶数数位置的值
    Arrays.sort(nums);

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i % 2 == 0)
        sum += nums[i];
    }

    return sum;
  }

  /**
   * 网上解答，类似
   */
  public int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length; i += 2) {
      result += nums[i];
    }
    return result;
  }

}
