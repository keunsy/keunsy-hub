package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * Created on 2018/2/8.
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 1:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition_35 {


  public static void main(String[] args) {
    int nums[] = {1, 2, 3, 4, 5, 6, 7};
    System.out.println(function(nums, 9));

  }


  static int function(int[] nums, int val) {


    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= val) {
        return i;
      }
    }
    return nums.length;
  }

  /**
   * 性能最佳
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length;
    while(low < high) {
      int mid = low + (high - low) / 2;
      if(nums[mid] < target)
        low = mid + 1;
      else
        high = mid;
    }
    return low;
  }
}
