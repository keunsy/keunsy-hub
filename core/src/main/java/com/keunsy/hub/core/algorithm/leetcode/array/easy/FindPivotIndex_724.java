package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/find-pivot-index/description/
 *
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Note:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 *
 * 说明：求数组某个标志位 满足 左边的和等于右边的和，如果存在多个，输出最小的标志位
 * 解析：
 */
public class FindPivotIndex_724 {


  public static void main(String[] args) {
//    int nums[] = {1, 7, 3, 6, 5, 6};


    int nums[] = {1, 2, 3};
    System.out.println(func(nums));

  }

  private static int func(int[] nums) {

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    int leftSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (leftSum == (sum - nums[i] - leftSum)) {//左右两边相等意味着，左边数值和的两倍加上当前数值等于总值
        return i;
      }
      leftSum += nums[i];

    }

    return -1;
  }


}
