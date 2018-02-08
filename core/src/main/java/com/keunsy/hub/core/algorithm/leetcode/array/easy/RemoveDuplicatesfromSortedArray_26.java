package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created on 2018/2/2.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesfromSortedArray_26 {

  public static void main(String[] args) {
    int array[] = {1, 2, 3, 5, 5, 10, 10};
    System.out.println(removeDuplicates(array));

  }

  /**
   * 需要额外空间，不满足题目要求（ps：可用于非有序的情况）
   */
  static int function(int[] array) {

    Map<Integer, Integer> map = Maps.newHashMap();
    int result = array.length;
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i])) {
        result--;
      }
      map.put(array[i], i);
    }
    return result;
  }

  /**
   * 优质答案
   */
  static int removeDuplicates(int[] array) {
    int i = 0;
    for (int j = 1; j < array.length; j++) {
      if (array[j] != array[i]) {
        array[++i] = array[j];
      }
    }
    return i + 1;
  }
}
