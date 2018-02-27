package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/description/
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 * 说明：找出数组中任意三个数，保证乘积最大，输出最大值(其实就是找出最大的三个数)
 */
public class MaximumProductOfThreeNumbers_628 {


  public static void main(String[] args) {
    int nums[] = {1, 5, 2, 3, 7, 8, 3, 6, 9, 1, 4};
    System.out.println(func2(nums));

  }

  static int func(int[] nums) {
    Arrays.sort(nums);
    //可能存在负数
    return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
  }


  /**
   * 未考虑负数的情况
   */
  static int func2(int[] nums) {

    int max1 = nums[0];
    int max2 = 0;
    int max3 = 0;
    for (int i = 1; i < nums.length; i++) {

      if (nums[i] >= max1) {
        max3 = max2;
        max2 = max1;
        max1 = nums[i];
      } else if (nums[i] >= max2) {
        max3 = max2;
        max2 = nums[i];
      } else if (nums[i] > max3) {
        max3 = nums[i];
      }
    }
    return max1 * max2 * max3;


  }

  /**
   * 考虑了 正负数
   */
  public int maximumProduct(int[] nums) {
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    for (int n : nums) {
      if (n <= min1) {
        min2 = min1;
        min1 = n;
      } else if (n <= min2) {     // n lies between min1 and min2
        min2 = n;
      }
      if (n >= max1) {            // n is greater than max1, max2 and max3
        max3 = max2;
        max2 = max1;
        max1 = n;
      } else if (n >= max2) {     // n lies betweeen max1 and max2
        max3 = max2;
        max2 = n;
      } else if (n >= max3) {     // n lies betwen max2 and max3
        max3 = n;
      }
    }
    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
  }


}
