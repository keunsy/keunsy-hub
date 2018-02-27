package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/description/
 *
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 *
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 *
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 *
 * Note:
 *
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 *
 * 说明：找出数组中最大数的下表，并且满足其值大于等于其他数值的两倍
 */
public class LargestNumberAtLeastTwiceOfOthers_747 {


  public static void main(String[] args) {
    int nums[] = {3, 6, 1, 0};
//    int nums[] = {1, 2, 3, 4};


  }

  /**
   * 第一遍找最大的值，
   * 第二遍遍历验证
   */
  public int dominantIndex(int[] nums) {
    int maxIndex = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > nums[maxIndex])
        maxIndex = i;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (maxIndex != i && nums[maxIndex] < 2 * nums[i])
        return -1;
    }
    return maxIndex;
  }

  /**
   * 遍历找出第一大以及第二大，最终判断第一大是否大于等于第二大的两倍
   */
  public int dominantIndex2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    if (nums.length == 1) {
      return 0;
    }
    int max = Integer.MIN_VALUE + 1;
    int secondMax = Integer.MIN_VALUE;
    int index = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) {
        secondMax = max;
        max = nums[i];
        index = i;
      } else if (nums[i] != max && nums[i] > secondMax) {
        secondMax = nums[i];
      }
    }
    if (secondMax * 2 <= max) {
      return index;
    }
    return -1;
  }

}
