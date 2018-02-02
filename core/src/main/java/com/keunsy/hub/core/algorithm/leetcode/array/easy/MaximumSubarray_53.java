package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * Created on 2018/2/2.
 * 参考地址：https://leetcode.com/problems/maximum-subarray/
 * 说明：
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * click to show more practice.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray_53 {


  public static void main(String[] args) {

    int array[] = {-1, 5, -2, 8, 0, -5, 6, 1, 3, -5};
    System.out.println(function(array));

  }


  static int function(int[] array) {

    int currSum = 0;
    int maxSum = array[0];

    for (int i = 0; i < array.length; i++) {
      currSum += array[i];
      if (currSum < 0) {//累加值如果小于0，说明前部分内容已无累加必要，从新的标识位开始累加即可
        currSum = 0;
      }
      if (currSum > maxSum) {
        maxSum = currSum;
      }
    }
    return maxSum;

  }


  /**
   * 最优方案
   */
  public static int maxSubArray(int[] array) {
    int maxSoFar = array[0], maxEndingHere = array[0];
    for (int i = 1; i < array.length; ++i) {
      maxEndingHere = Math.max(maxEndingHere + array[i], array[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}
