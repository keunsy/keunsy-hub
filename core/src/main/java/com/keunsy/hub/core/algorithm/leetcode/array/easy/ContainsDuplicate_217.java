package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/description/
 *
 * Given an array of integers,
 * find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * 说明：数组是否有重复的数据
 * 1.map、set较简单
 * 2.双循环、排序复杂度高
 */
public class ContainsDuplicate_217 {


  public static void main(String[] args) {
    int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (int i : array) {
      System.out.println(i);
    }

  }


  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>(nums.length);
    for (int x : nums) {
      if (set.contains(x)) return true;
      set.add(x);
    }
    return false;
  }

}
