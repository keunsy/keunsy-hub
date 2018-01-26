/**
 * 文件名：InsertSort.java
 *
 * 版本信息：
 * 日期：2015-6-18
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

import java.util.Date;

/**
 * 类描述：    插入排序
 */
public class InsertSort {

  public static void main(String[] args) {

    int array[] = CommonUtils.createRandomArray(50000);
    int length = array.length;

    long start1 = new Date().getTime();
    insertSort3(array, length);
    long end1 = new Date().getTime();
    System.out.println("time1:" + (end1 - start1));

  }

  public static void insertSort1(int[] array, int length) {

    //1.初始数据 array[0] 默认成一个有序 array[1..n-1]为无序
    //2.循环array[i]并入a[0..i-1]中形成a[0..i]的有序直至 i=n-1
    int i, j, k = 0;

    for (i = 1; i < length; i++) {//调整次数
      for (j = i - 1; j >= 0; j--) {
        if (array[j] < array[i]) {
          break;
        }
      }
      //即 新插入数据比原有数据小的不止少一个，此时将所有比新数据大的后移
      if (j != i - 1) {
        int temp = array[i];
        for (k = i - 1; k > j; k--) {
          array[k + 1] = array[k];
        }
        array[k + 1] = temp;//
      }
    }
  }

  public static void insertSort2(int[] array, int length) {

    int i, j;

    for (i = 1; i < length; i++) {//调整次数  array[0]为有序区
      if (array[i] < array[i - 1]) {//
        int temp = array[i];
        for (j = i - 1; j >= 0 && array[j] > temp; j--) {//有序区所有比新数据大的 统一右移
          array[j + 1] = array[j];
        }
        array[j + 1] = temp;//新数据归入合理位置
      }
    }
  }

  public static void insertSort3(int[] array, int length) {

    int i, j;

    for (i = 1; i < length; i++) {//调整次数  array[0]为有序区
      int temp = array[i];
      j = i - 1;
      while (j >= 0 && array[j] > temp) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = temp;
    }
  }

}
