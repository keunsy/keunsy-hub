package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * Created on 2018/2/8.
 * https://leetcode.com/problems/merge-sorted-array/description/
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 解读：两个有序数组合并成一个有序的数组,数组1的容量足够包含数组1、2的合并
 */
public class MergeSortedArray_88 {

  public static void main(String[] args) {

    int temp[] = {1, 3, 5, 6, 45, 62, 89};
    int array2[] = {2, 4, 8, 33, 88};

    int[] array1 = new int[temp.length + array2.length];
    for (int i = 0; i < temp.length; i++) {
      array1[i] = temp[i];
    }
    merge(array1, temp.length, array2, array2.length);
    for (int i : array1) {
      System.out.println(i);
    }

  }


  static void merge(int A[], int m, int B[], int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;

    //倒序从数组最后一位开始向前遍历
    while (i > -1 && j > -1) {
      A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];//大的数 将其标识位降低1
    }

    //数组2 存在某些值比数组1所有值都小的情况
    while (j > -1) {
      A[k--] = B[j--];
    }
  }

}
