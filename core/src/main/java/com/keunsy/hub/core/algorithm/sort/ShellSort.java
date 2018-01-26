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
 * 类描述：    希尔排序
 */
public class ShellSort {

  public static void main(String[] args) {
    int length = 5000000;
    int array1[] = CommonUtils.createRandomArray(length);
    int array2[] = array1.clone();

    long start1 = new Date().getTime();
    shellSort1(array1, length);
    long end1 = new Date().getTime();
    System.out.println("time1:" + (end1 - start1));

    long start2 = new Date().getTime();
    shellSort2(array2, length);
    long end2 = new Date().getTime();
    System.out.println("time2:" + (end2 - start2));

    //        for (int i = 0; i < array2.length; i++) {
    //            System.out.print(array2[i] + "\t");
    //        }

  }

  public static void shellSort1(int[] a, int length) {

    int i, j, gap;

    for (gap = length / 2; gap > 0; gap /= 2) {//步长
      for (i = 0; i < gap; i++) {//分组（第一个组循环）
        for (j = i + gap; j < length; j += gap) {//累加步长
          if (a[j] < a[j - gap]) {//对比各组对应位置值
            int temp = a[j];
            int k = j - gap;//
            while (k >= 0 && a[k] > temp) {//对应位置所有值 进行对比直到 他们正序排列
              a[k + gap] = a[k];//传递值
              k -= gap;
            }
            a[k + gap] = temp;
          }
        }
      }
    }

  }

  public static void shellSort2(int[] a, int length) {

    int j, gap;

    for (gap = length / 2; gap > 0; gap /= 2) {//步长
      for (j = gap; j < length; j++) {//第gap个元素开始 与方法一的区别
        if (a[j] < a[j - gap]) {//对比各组对应位置值
          int temp = a[j];
          int k = j - gap;//
          while (k >= 0 && a[k] > temp) {//对应位置所有值 进行对比直到 他们正序排列
            a[k + gap] = a[k];//传递值
            k -= gap;
          }
          a[k + gap] = temp;
        }
      }
    }

  }

  public static void shellSort3(int[] a, int length) {

    int out, in, temp;
    int h = 1;

    while (h <= length / 3) {
      h = h * 3 + 1;
      while (h > 0) {
        for (out = h; out < length; out++) {
          temp = a[out];
          in = out;

          while (in > h - 1 && a[in - h] >= temp) {
            a[in] = a[in - h];
            in -= h;
          }
          a[in] = temp;
        }
        h = (h - 1) / 3;
      }
    }
  }

}
