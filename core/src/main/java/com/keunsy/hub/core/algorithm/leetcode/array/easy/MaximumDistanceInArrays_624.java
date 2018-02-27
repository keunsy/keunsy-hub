package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.List;

/**
 * https://leetcode.com/problems/Maximum-Distance-in-Arrays/description/
 *
 * Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.
 *
 * Example 1:
 *
 * Input:
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 * Note:
 *
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000].
 *
 * 说明：多个正序数组，求不同数组的最大值与最小值的最大差值（注意：不能同数组比较）
 * fixme 待验证
 */
public class MaximumDistanceInArrays_624 {


  public static void main(String[] args) {
    int nums[] = {1, 0, 0, 0, 0, 0, 1};
//    System.out.println(maxDistance(nums));

  }

  public int maxDistance(int[][] nums) {
    int maxDistance = 0;
    int max = nums[0][nums[0].length - 1];
    int min = nums[0][0];

    for (int i = 1; i < nums.length; i++) {
      maxDistance = Math.max(maxDistance, Math.abs(nums[i][0] - max));
      maxDistance = Math.max(maxDistance, Math.abs(nums[i][nums[i].length - 1] - min));
      max = Math.max(max, Math.abs(nums[i][nums[i].length - 1]));
      min = Math.min(min, nums[i][0]);
    }

    return maxDistance;
  }

  public int maxDistance(List<List<Integer>> arrays) {
    int ans = 0;
    int max = arrays.get(0).get(arrays.get(0).size() - 1);
    int min = arrays.get(0).get(0);

    for (int i = 1; i < arrays.size(); i++) {
      ans = Math.max(ans, Math.abs(arrays.get(i).get(0) - max));
      ans = Math.max(ans, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
      max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
      min = Math.min(min, arrays.get(i).get(0));
    }

    return ans;
  }


}
