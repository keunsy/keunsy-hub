/**
 * 文件名：SelectSort.java
 *
 * 版本信息：
 * 日期：2015-6-19
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

import java.util.Date;

/**
 * 类描述：    选择排序
 */
public class SelectSort {

  public static void main(String[] args) {
    int size = 50;
    int array1[] = CommonUtils.createRandomArray(size);

    //排序算法
    long start1 = new Date().getTime();
    selectSort(array1, size);
    long end1 = new Date().getTime();
    System.out.println("time1:" + (end1 - start1));

    for (int i = 0; i < array1.length; i++) {
      System.out.println(array1[i]);
    }

  }

  public static void selectSort(int[] a, int length) {

    int i, j, minIndex;

    for (i = 0; i < length; i++) {//调整次数  array[0]为有序区
      minIndex = i;//最小元素
      for (j = i + 1; j < length; j++) {//寻找无序区最小元素位置
        if (a[j] < a[minIndex]) {
          minIndex = j;
        }
      }
      CommonUtils.swapVal(minIndex, i, a);//进行交换
    }
  }
}
