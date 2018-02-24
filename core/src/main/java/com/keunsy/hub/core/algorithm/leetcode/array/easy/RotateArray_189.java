package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/rotate-array/description/
 *
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * [show hint]
 *
 * Hint:
 * Could you do it in-place with O(1) extra space?
 * Related problem: Reverse Words in a String II
 *
 * 说明：根据给定的标志位旋转数组(从右往左边第K位)
 */
public class RotateArray_189 {


  public static void main(String[] args) {
    int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    rotate2(array, 3);
    for (int i : array) {
      System.out.println(i);
    }

  }

  /**
   * 额外空间
   */
  static void rotate(int[] nums, int k) {
    int[] a = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      a[(i + k) % nums.length] = nums[i];
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = a[i];
    }
  }


  /**
   * 方法2，最优解答
   */
  static void rotate2(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);//所有均旋转
    reverse(nums, 0, k - 1);//旋转前面的
    reverse(nums, k, nums.length - 1);//旋转后面的
  }

  static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}
