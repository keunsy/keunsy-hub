package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 *
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 * 说明：找出非从小到大的数据，并返回其长度
 */
public class ShortestUnsortedContinuousSubarray_581 {


  public static void main(String[] args) {
    int nums[] = {2, 6, 4, 8, 10, 9, 15};
    System.out.println(findUnsortedSubarray(nums));

  }

  static int findUnsortedSubarray(int[] A) {
    int n = A.length, beg = -1, end = -2, min = A[n - 1], max = A[0];
    for (int i = 1; i < n; i++) {
      max = Math.max(max, A[i]);
      min = Math.min(min, A[n - 1 - i]);
      if (A[i] < max) end = i;
      if (A[n - 1 - i] > min) beg = n - 1 - i;
    }
    return end - beg + 1;
  }


}
