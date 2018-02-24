package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/missing-number/description/
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * 说明：查找缺失的数字
 * 解法：
 * 1.
 */
public class MissingNumber_268 {


  public static void main(String[] args) {
    int nums[] = {1, 4, 3, 5, 8, 7, 6, 0};

    System.out.println(func1(nums));
  }

  /**
   * 先求和，再一一扣减，最后剩下的即为要求的（要求数字不重复）
   */
  static int func1(int[] nums) {

    int sum = (nums.length + 1) * nums.length / 2;

    for (int num : nums) {
      sum -= num;
    }

    return sum;
  }

  static int missingNumber(int[] nums) {
    Set<Integer> numSet = new HashSet<Integer>();
    for (int num : nums) numSet.add(num);

    int expectedNumCount = nums.length + 1;
    for (int number = 0; number < expectedNumCount; number++) {
      if (!numSet.contains(number)) {
        return number;
      }
    }
    return -1;
  }

  /**
   * 简单方法
   * 解析：
   * Index	0	1	2	3
   * Value	0	1	3	4
   *
   * 则有：
   * missing
   * =4^(0^0)^(1^1)^(2^3)^(3^4)
   * =(4^4)^(0^0)^(1^1)^(3^3)^2
   * =0^0^0^0^2=2
   */
  static int missingNumber2(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }
}
