package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/description/
 *
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 *
 * 说明：查询数组里出现最多的数字，则此数字的次数为此数组度数，现求出与该度数相同的最小的子数租
 * 解析：求最频繁数字的最早跟最晚标志位，并求差
 */
public class DegreeOfAnArray_697 {


  public static void main(String[] args) {
//    int nums[] = {1, 2, 2, 3, 1, 4, 2};
    int nums[] = {1, 2, 2, 3, 1};

    System.out.println(func(nums));
  }

  private static int func(int[] nums) {

    Map<Integer, List<Integer>> map = Maps.newHashMap();

    int degree = 0;

    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], Lists.newArrayList(i)); //存入第一个元素的标志位
      } else {
        map.get(nums[i]).add(i);
        if (map.get(nums[i]).size() > degree) {//如果出现次数更大
          degree = map.get(nums[i]).size();
        }
      }
    }

    //处理可能存在多个度数相同的情况
    int min = Integer.MAX_VALUE;
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      if (entry.getValue().size() == degree) {
        min = Math.min(entry.getValue().get(entry.getValue().size() - 1) - entry.getValue().get(0) + 1, min);
      }
    }

    return min;//最大的标志位减去最小的标志位


  }

  /**
   * 网上参考解答
   */
  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> left = new HashMap(),
            right = new HashMap(), count = new HashMap();

    for (int i = 0; i < nums.length; i++) {
      int x = nums[i];
      if (left.get(x) == null) left.put(x, i);
      right.put(x, i);
      count.put(x, count.getOrDefault(x, 0) + 1);
    }

    int ans = nums.length;
    int degree = Collections.max(count.values());
    for (int x : count.keySet()) {
      if (count.get(x) == degree) {
        ans = Math.min(ans, right.get(x) - left.get(x) + 1);
      }
    }
    return ans;
  }


}
