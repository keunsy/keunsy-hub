package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/non-decreasing-array/description/
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 *
 * 说明：最多改变一个数值，使之变为非递减数组（即 全部变为递增（可以存在相等）），判断是否存在符合规则的
 * 解析：
 * 让左边的数值均小于等于右边，当左边的值大于右边，尝试改变左边或者右边的值，最终查看改变的次数是否超过1次
 *
 * fixme 进一步确认
 */
public class NonDecreasingArray_665 {


  public static void main(String[] args) {
//    int nums[] = {4, 2, 3};
    int nums[] = {2, 1, 3, 4, 2, 4, 6};

    System.out.println(checkPossibility(nums));
  }

  /**
   * The strategy is to lower a[i-1] to match a[i] if possible - (a[i-2] not exist or no smaller than a[i]);
   * otherwise rise a[i] to match a[i-1].
   */
  static boolean checkPossibility(int[] a) {
    int modified = 0;
    for (int i = 1; i < a.length; i++) {
      if (a[i] < a[i - 1]) {//存在减的情况
        if (modified++ > 0) return false;//改变的次数大于1
        if (i - 2 < 0 || a[i - 2] <= a[i]) a[i - 1] = a[i]; // lower a[i - 1]
        else a[i] = a[i - 1]; // rise a[i]
      }
    }
    return true;
  }

  /**
   * 不改变原数组
   */
  static boolean checkPossibility2(int[] a) {
    int modified = 0;
    for (int i = 1, prev = a[0]; i < a.length; i++) {
      if (a[i] < prev) {
        if (modified++ > 0) return false;
        if (i - 2 >= 0 && a[i - 2] > a[i]) continue;
      }
      prev = a[i];
    }
    return true;
  }


}
