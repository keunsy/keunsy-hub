package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/can-place-flowers/description/
 *
 *
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 *
 * 说明：种植花，相邻不能种植，用0表示没有种，1表示种了，重新给定N多花，判断这N朵花是否都能种植到空地上
 */
public class CanPlaceFlowers_605 {


  public static void main(String[] args) {
    int nums[] = {1, 0, 0, 0, 0, 0, 1};
    System.out.println(canPlaceFlowers(nums, 3));

  }

  static boolean func(int[] nums, int n) {

    int count = 0;
    //fixme 注意开始或者结尾为零的问题
    for (int i = 1; i < nums.length - 1; i++) {
      if (nums[i] == 0) {
        if (nums[i - 1] != 1 && nums[i + 1] != 1) {
          nums[i] = 1;
          if (++count >= n) {
            return true;
          }
        }
      }
    }

    return false;
  }

  /**
   * 最优方案
   */
  static boolean canPlaceFlowers(int[] bed, int n) {
    for (int i = 0; i < bed.length; i++) {
      //当前可种并且之前可种并且之后可种 （第一个以及最后一个位置 特殊处理）
      if (bed[i] == 0 && (i == 0 || bed[i - 1] == 0) && (i == bed.length - 1 || bed[i + 1] == 0)) {
        bed[i] = 1;//进行种植
        n--;//需要种的减少
      }
    }
    return n <= 0;
  }


}
