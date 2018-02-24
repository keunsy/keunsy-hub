package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * 说明：查询所有确实的数字，存在重复，无序，不含0
 */
public class FindAllNumbersDisappearedInAnArray_448 {


  public static void main(String[] args) {
    int nums[] = {1, 2, 3, 7, 8, 5, 4, 6, 1};
//    int nums[] = {1, 1, 2, 4};

    System.out.println(findDisappearedNumbers(nums));
  }

  static List<Integer> findDisappearedNumbers(int[] nums) {
    List<Integer> ret = new ArrayList<>();

    //根据值来标记相应位置，同时为了防止相关值被覆盖，使用负数原理
    for (int i = 0; i < nums.length; i++) {
      int val = Math.abs(nums[i]) - 1;  //该位置的值可能被标记为负数，所以需要绝对值来定位当前位置
      if (nums[val] > 0) {
        nums[val] = -nums[val];
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {//未被标记过的位置 即为正确位置
        ret.add(i + 1);
      }
    }
    return ret;
  }


}
