/**
 * 文件名：HeapSort.java
 *
 * 版本信息：
 * 日期：2015-7-8
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

/**
 * 堆排序
 */
public class HeapSort {

  public static void main(String[] args) {
    int size = 2000000;
    int array1[] = CommonUtils.createRandomArray(size);
    doHeapSort(array1, size);

    for (int i = 0; i < array1.length; i++) {
      System.out.print(array1[i] + "\t");
    }

  }

  static void makeMinHeap(int a[], int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      minHeapFixDown(a, i, n);
    }
  }

  static void minHeapFixDown(int a[], int i, int n) {
    int j, temp;

    temp = a[i];
    j = 2 * i + 1;
    while (j < n) {
      if (j + 1 < n && a[j + 1] < a[j]) {
        j++;
      }

      if (a[j] >= temp) {
        break;
      }
      a[i] = a[j];
      i = j;
      j = 2 * i + 1;
    }
    a[i] = temp;
  }

  static void doHeapSort(int a[], int n) {

    makeMinHeap(a, n);//建立最小堆

    for (int i = n - 1; i >= 1; i--) {
      CommonUtils.swapVal(i, 0, a);//将第一个与最后一个交换顺序
      minHeapFixDown(a, 0, i);//检查是否满足最小堆条件
    }
  }

}
