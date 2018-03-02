package com.keunsy.hub.core.algorithm.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/house-robber/description/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
 *
 * 说明：有一排房子，现在需要抢劫房子里的钱，不能抢劫相邻的房子，否则会触发警报，输出能抢劫到的最大金额(无负数)
 */
public class HouseRobber_198 {

  public static void main(String[] args) {

    int nums[] = {10, 5, 20, 8, 1, 9, 6, 1, 3, 3};
    System.out.println(func(nums));
    System.out.println(rob(nums));

  }

  private static int func(int[] nums) {
    int[] dp = new int[nums.length + 1];

    dp[0] = nums[0];
    dp[1] = nums[1];
    dp[2] = nums[0] + nums[2];//由于每次跨度2或者3
    for (int i = 3; i < nums.length + 1; i++) {

      //由于不能相邻跳跃，所以每个位置最大的金额等于 前2或者前3位置的数，四个或四个以上不如使用两次前2
      dp[i] = (i == nums.length ? 0 : nums[i]) + Math.max(dp[i - 2], dp[i - 3]);//最后一个数 需要特殊处理
    }

    //比较最后两个的大小
    return Math.max(dp[nums.length], dp[nums.length - 1]);

  }


  // TODO: 2018/2/28 待研究
  static int rob(int[] num) {
    int rob = 0; //max monney can get if rob current house
    int notrob = 0; //max money can get if not rob current house
    for (int i = 0; i < num.length; i++) {
      int currob = notrob + num[i]; //if rob current value, previous house must not be robbed
      notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
      rob = currob;
    }
    return Math.max(rob, notrob);
  }


}
