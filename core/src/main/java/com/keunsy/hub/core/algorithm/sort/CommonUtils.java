/**
 * 文件名：CommonUtils.java
 *
 * 版本信息：
 * 日期：2015-6-18
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

import java.util.Random;

/**
 * 项目名称：dataStructure
 * 类名称：CommonUtils
 */
public class CommonUtils {

  public static void main(String[] args) {

    int a[] = {4, 1, 2, 8, 5, 9,};
    int n = a.length;
    //选择排序
    //        for (int i = 0; i < n; i++) {//有序
    //            int minIndex = i;
    //            for (int j = i + 1; j < n; j++) {
    //                if (a[minIndex] > a[j]) {
    //                    minIndex = j;
    //                }
    //            }
    //            swapVal(minIndex, i, a);
    //        }

    //插入排序
    //        int i, j;
    //        for (i = 1; i < a.length; i++) {
    //            if (a[i] < a[i - 1]) {
    //                int temp = a[i];
    //                for (j = i - 1; j >= 0; j--) {
    //                    if (a[j] > temp) {
    //                        a[j + 1] = a[j];
    //                    } else {
    //                        break;
    //                    }
    //                }
    //                a[j + 1] = temp;
    //            }
    //        }

    //希尔排序
    //        int i, j, gap = 0;
    //        for (gap = n / 2; gap > 0; gap /= 2) {
    //            for (i = gap; i < n; i++) {
    //                if (a[i] < a[i - gap]) {
    //                    int temp = a[i];
    //                    for (j = i - gap; j >= 0 && a[j] > temp; j -= gap) {
    //                        a[j + gap] = a[j];
    //                    }
    //                    a[j + gap] = temp;
    //                }
    //            }
    //        }

    for (int k = 0; k < a.length; k++) {
      System.out.println(a[k]);
    }

  }

  public static void swapVal(int i, int j, int[] a) {
    int temp = a[j];
    a[j] = a[i];
    a[i] = temp;
  }

  public static int[] createRandomArray(int size) {

    int array[] = new int[size];
    Random random = new Random();

    for (int i = 0; i < size; i++) {
      array[i] = random.nextInt(size) + 1;
    }

    return array;

  }

}
