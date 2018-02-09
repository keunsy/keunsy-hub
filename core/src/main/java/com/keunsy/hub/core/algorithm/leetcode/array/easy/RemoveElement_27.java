package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * Created on 2018/2/8.
 * https://leetcode.com/problems/remove-element/description/
 *
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * 注：需要删除相应的值
 * 使用办法：快慢指针
 */
public class RemoveElement_27 {

  public static void main(String[] args) {
    int array[] = {1, 2, 3, 5, 5, 10, 10};
    System.out.println(removeElement(array, 5));

  }

  static int custom(int[] array, int val) {
    //未进行数组重导不符合要求
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != val) {
        count++;
      }
    }

    return count;
  }

  static int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }
}
