package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/description/
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 *
 * 说明：查找出现次数大于n/2的数字（假定一定存在）
 */
public class MajorityElement_169 {


  public static void main(String[] args) {
    int array[] = {5, 8, 5, 5, 4, 2, 5};
    System.out.println(majorityElement(array));

  }

  /**
   * 此方法成功的必要条件： 必须有数据大于 规定次数！！！！！！
   * 说明：采用消耗法，如果次数大于N/2，也就是大于一半，那么此数一定足够抵消
   */
  static int majorityElement(int[] num) {

    int major = num[0], count = 1;
    for (int i = 1; i < num.length; i++) {
      if (count == 0) {
        count++;
        major = num[i];
      } else if (major == num[i]) {
        count++;
      } else count--;

    }
    return major;
  }

  public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }


  public int majorityElement2(int[] nums) {
    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    int ret = 0;
    for (int num : nums) {
      if (!myMap.containsKey(num))
        myMap.put(num, 1);
      else
        myMap.put(num, myMap.get(num) + 1);
      if (myMap.get(num) > nums.length / 2) {
        ret = num;
        break;
      }
    }
    return ret;
  }
}
