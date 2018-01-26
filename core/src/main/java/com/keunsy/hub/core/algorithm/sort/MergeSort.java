/**
 * 文件名：MergeSort.java
 *
 * 版本信息：
 * 日期：2015-6-19
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

import java.util.Date;

/**
 * 类描述：    归并排序
 */
public class MergeSort {

  public static void main(String[] args) {
    int size = 500000;
    int array1[] = CommonUtils.createRandomArray(size);
    int temp[] = new int[size];

    //排序算法
    long start1 = new Date().getTime();
    mergeSort(array1, 0, size - 1, temp);
    long end1 = new Date().getTime();
    System.out.println("time1:" + (end1 - start1));

    for (int i = 0; i < array1.length; i++) {
      System.out.print(array1[i] + "\t");
    }

  }

  public static void mergeSort(int[] a, int first, int last, int temp[]) {

    if (first < last) {
      int mid = (first + last) / 2;
      mergeSort(a, first, mid, temp);//左边有序
      mergeSort(a, mid + 1, last, temp);//左边有序
      memeryArray(a, first, mid, last, temp);//合并两个有序数列
    }
  }

  public static void memeryArray(int a[], int first, int mid, int last, int temp[]) {

    int i = first, j = mid + 1, k = 0;
    int m = mid, n = last;
    while (i <= m && j <= n) {
      if (a[i] < a[j]) {
        temp[k++] = a[i++];
      } else {
        temp[k++] = a[j++];
      }
    }
    while (i <= m) {
      temp[k++] = a[i++];
    }
    while (j <= n) {
      temp[k++] = a[j++];
    }

    for (int l = 0; l < k; l++) {
      a[first + l] = temp[l];
    }
  }

  private static void test(int a[], int first, int mid, int last, int temp[]) {

    int sec_first = mid + 1;
    int k = 0;
    int temp_first = first;

    while (first <= mid && sec_first <= last) {
      if (a[first] < a[sec_first]) {
        temp[k++] = a[first++];
      } else {
        temp[k++] = a[sec_first++];
      }
    }

    while (first <= mid) {
      temp[k++] = a[first++];
    }

    while (sec_first <= last) {
      temp[k++] = a[sec_first++];
    }

    for (int i = 0; i < k; i++) {
      a[temp_first + i] = temp[i];
    }

  }

  /**
   * memeryArray2(非实际所用方法)
   *
   * @param @return 设定文件
   * @return String    DOM对象
   * @Exception 异常对象
   * @since CodingExample　Ver(编码范例查看) 1.1
   */
  void memeryArray2(int a[], int len_a, int b[], int len_b, int c[]) {

    int i, j, k;
    i = j = k = 0;
    //对比两个数组 按照大小依次放到c数组中（前提为 a b 已经是有序的数组）
    while (i < len_a && j < len_b) {
      if (a[i] < b[j]) {
        c[k++] = a[i++];
      } else {
        c[k++] = b[j++];
      }
    }
    //如果a数组 未全部装填完毕，则将剩余内容装入c中
    while (i < len_a) {
      c[k++] = a[i++];
    }
    while (j < len_b) {
      c[k++] = b[j++];
    }
  }

  /**
   * testTest(这里用一句话描述这个方法的作用)
   *
   * @param @return 设定文件
   * @return String    DOM对象
   * @Exception 异常对象
   * @since CodingExample　Ver(编码范例查看) 1.1
   */
  private static void testTest(int a[], int first, int last, int temp[]) {
    if (first < last) {
      int mid = (first + last) / 2;
      testTest(a, first, mid, temp);
      testTest(a, mid + 1, last, temp);
      test(a, first, mid, last, temp);
    }

  }
}
