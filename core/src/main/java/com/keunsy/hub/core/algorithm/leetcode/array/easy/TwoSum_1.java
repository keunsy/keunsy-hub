package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created on 2018/2/2.
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum_1 {


  public static void main(String[] args) {
    int array[] = {5, 8, 0, 6, 1, 3};
    int target = 4;
    System.out.println(function(array, target));

  }

  static String function(int[] array, int target) {

    String result = "";
    Map<Integer, Integer> map = Maps.newHashMap();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(target - array[i])) {
        return array[i] + " + " + (target - array[i]) + " = " + target;
      }
      map.put(array[i], i);
    }

    return result;
  }

}
