package com.keunsy.hub.temp;

/**
 * Created on 2018/3/9.
 */
public class TestQuickSort {

  public static void main(String[] args) {


  }

  static void sort(int nums[]) {
    doSort(nums, 0, nums.length - 1);
  }

  private static void doSort(int[] nums, int left, int right) {

    if (left < right) {

      int l = left, r = right;
      int x = nums[l];

      //从右边开始，找出比x小的
      while (l < r && nums[r] >= x) {
        r--;
      }
      //将x的位置赋值
      if (l < r) {
        nums[l] = nums[r];
        l++;
      }

      while (l < r && nums[l] <= x) {
        l++;
      }

      if (l < r) {
        nums[r] = nums[l];
        r--;
      }
      nums[l] = x;

      doSort(nums, left, l - 1);
      doSort(nums, l + 1, right);
    }

  }
}
