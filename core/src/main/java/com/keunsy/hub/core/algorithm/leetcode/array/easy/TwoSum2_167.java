package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * 解读：1的基础上，但是是排序的
 * 解法：快慢
 */
public class TwoSum2_167 {


  public static void main(String[] args) {
    int array[] = {2, 7, 11, 15};
    int target = 18;
    for (int i : function(array, target)) {
      System.out.println(i);
    }

  }

  static int[] function(int[] array, int target) {

    int first = 0;
    int last = array.length - 1;
    while (first < last) {
      int temp = target - array[last];
      if (array[first] == temp) {
        return new int[]{first, last};
      } else if (array[first] < temp) {
        first++;
      } else {
        last--;
      }
    }

    return new int[]{};

  }

}
