/**
 * 文件名：BubbleSort.java
 *
 * 版本信息：
 * 日期：2015-6-16
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

import java.util.Date;

/**
 * 类描述：    冒泡排序
 */
public class BubbleSort {

  public static void main(String[] args) {

    int array1[] = CommonUtils.createRandomArray(50000);
    int array2[] = array1.clone();

    //排序算法
    long start1 = new Date().getTime();
    bubbleSort1(array1);
    long end1 = new Date().getTime();
    System.out.println("time1:" + (end1 - start1));

    long start2 = new Date().getTime();
    bubbleSort2(array2);
    long end2 = new Date().getTime();
    System.out.println("time2:" + (end2 - start2));

    //        for (int i = 0; i < array.length; i++) {
    //            System.out.print(array[i] + "\t");
    //        }

  }

  private static int[] bubbleSort1(int[] array) {

    int length = array.length;
    for (int i = 0; i < length; i++) {//调整次数
      for (int j = 0; j < length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          CommonUtils.swapVal(j, j + 1, array);
        }
      }
    }
    return array;
  }

  private static int[] bubbleSort2(int[] array) {

    boolean flag = true;
    int length = array.length;
    while (flag) {
      flag = false;
      for (int i = 1; i < length; i++) {
        if (array[i - 1] > array[i]) {
          CommonUtils.swapVal(i, i - 1, array);
          flag = true;
        }
      }
      length--;
    }
    return array;
  }

}
