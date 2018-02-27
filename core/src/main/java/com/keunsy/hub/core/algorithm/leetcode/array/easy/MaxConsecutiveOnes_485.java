package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 * 说明：查询相同的连续的数字数量，数组只有0跟1
 */
public class MaxConsecutiveOnes_485 {


  public static void main(String[] args) {
    int nums[] = {1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1};
//    int nums[] = {1, 1, 2, 4};

    System.out.println(func(nums));
  }

  /**
   * 此解法适用于任何求算连续的（不限于0跟1）
   */
  private static int func(int[] nums) {

    int count = 1;
    int current = nums[0];
    int maxinum = 1;

    for (int i = 1; i < nums.length; i++) {
      if (current == nums[i]) {
        if (++count > maxinum) {
          maxinum = count;
        }
      } else {
        current = nums[i];
        count = 1;
      }
    }

    return maxinum;
  }


  /**
   * 优质解答，仅限于0跟1，并只能求0的次数
   */
  public int findMaxConsecutiveOnes(int[] nums) {
    int result = 0;
    int count = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        count++;
        result = Math.max(count, result);
      } else count = 0;
    }

    return result;
  }


  /**
   * 最优解答
   * The idea is to reset maxHere to 0 if we see 0, otherwise increase maxHere by 1
   * The max of all maxHere is the solution
   */
  public int findMaxConsecutiveOnes1(int[] nums) {
    int maxHere = 0, max = 0;
    for (int n : nums)
      max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
    return max;
  }


}
