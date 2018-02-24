package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i
 * and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 *
 * 说明：找出相同的元素，并且其标识位差最多等于K值
 * 举例：{1,5,6,2,3,4,5} 假定K为3, 数字5的标志位差值为6-1=5 > 3，则不符合要求
 *
 * 解答：hashmap  key存nums[i]，value存i
 */
public class ContainsDuplicate2_219 {


  public static void main(String[] args) {
    int nums[] = {1, 5, 6, 2, 3, 4, 5};
    System.out.println(containsNearbyDuplicate(nums, 6));

  }

  static boolean containsNearbyDuplicate(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > k)
        set.remove(nums[i - k - 1]);
      if (!set.add(nums[i]))
        return true;
    }
    return false;
  }

}
