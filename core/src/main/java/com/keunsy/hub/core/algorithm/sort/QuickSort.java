/**
 * 文件名：QuickSort.java
 *
 * 版本信息：
 * 日期：2015-6-19
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

import java.util.Date;

/**
 * 类描述：    快速排序
 */
public class QuickSort {

  public static void main(String[] args) {
    int size = 1000000;
    int array1[] = CommonUtils.createRandomArray(size);

    //排序算法
    long start1 = new Date().getTime();
    quickSort(array1, 0, size - 1);
    long end1 = new Date().getTime();
    System.out.println("time1:" + (end1 - start1));

    //        for (int i = 0; i < array1.length; i++) {
    //            System.out.print(array1[i] + "\t");
    //            if ((i + 1) % 10 == 0) {
    //                System.out.println();
    //            }
    //        }
  }

  public static void quickSort(int s[], int l, int r) {
    if (l < r) {
      //如果需要以 中间的数作为基准
      //CommonUtils.swapVal(l, (l + r) / 2,s]);
      int i = l, j = r, x = s[l];
      while (i < j) {
        while (i < j && s[j] >= x) {//从右向左循环找第一个小于X的数
          j--;
        }
        if (i < j) {
          s[i++] = s[j];//将找到的第一个小于X的数填充到左边i位置中
        }
        while (i < j && s[i] <= x) {//从左向有循环找第一个大于X的数
          i++;
        }
        if (i < j) {
          s[j--] = s[i];//将找到的第一个大于X的数填充到右边j位置中
        }
      }
      s[i] = x;//将基数X填充到 i或j的位置（此时i=j）
      //递归
      quickSort(s, l, i - 1);//基数左边部分重复上述操作
      quickSort(s, i + 1, r);
    }
  }

  private static void test(int a[], int l, int r) {
    if (l < r) {
      int i = l, j = r, x = a[i];
      while (i < j) {
        //处理左边
        while (i < j && a[j] > x) {
          j--;
        }
        if (i < j) {
          a[i++] = a[j];
        }
        //处理右边
        while (i < j && a[i] < x) {
          i++;
        }
        if (i < j) {
          a[j--] = a[i];
        }
      }
      a[i] = x;
      test(a, l, i - 1);
      test(a, i + 1, r);
    }

  }
}
