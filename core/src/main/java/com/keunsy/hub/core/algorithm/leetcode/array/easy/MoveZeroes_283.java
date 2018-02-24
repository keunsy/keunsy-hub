package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * 说明：将0移到最后，先后顺序不变
 */
public class MoveZeroes_283 {


  public static void main(String[] args) {
    int nums[] = {1, 0, 3, 0, 8, 13, 26, 0};

    func(nums);
    for (int num : nums) {
      System.out.println(num);
    }

  }

  private static void func(int[] nums) {

    int x = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[x++] = nums[i];
      }
    }
    for (int i = x; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  static void moveZeroes(int[] nums) {

    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        j++;
      }
    }
  }
}
