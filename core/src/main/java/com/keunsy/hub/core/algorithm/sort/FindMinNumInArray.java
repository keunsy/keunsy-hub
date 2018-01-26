/**
 * 文件名：FindMinNumInArray.java
 *
 * 版本信息：
 * 日期：2015-7-3
 * Copyright 足下 Corporation 2015
 * 版权所有
 */
package com.keunsy.hub.core.algorithm.sort;

/**
 * 项目名称：dataStructure
 * 类名称：FindMinNumInArray
 */
public class FindMinNumInArray {

  public static void main(String[] args) {

    int[] a = {33, 1, 14, 15, 18, 56, 3, 4, 2, 0, 2, 5, 6, 8, 3, 10, 68, 9, -1, 11, 12, 13, 7};
    //int[] a = { 0, 33, 1, 14, 15, 10, 68, 9, -1, 11, 12, 13, 7 };
    int[] b = a.clone();
    int[] c = a.clone();
    int[] d = a.clone();
    int n = a.length;
    System.out.println("数组大小为：" + n);
    System.out.println(method(c, n));
    System.out.println(method1(a, n));
    System.out.println(method1Extend(b, n, 1));
    System.out.println(method2(d, n));

  }

  /**
   * method1(网上方法)
   */
  public static int method(int[] a, int n) {

    int i;
    for (i = 0; i < n; i++) {
      while (a[i] > 0 && a[i] <= n && a[i] != i + 1 && a[i] != a[a[i] - 1]) {
        int temp = a[i];
        a[i] = a[temp - 1];
        a[temp - 1] = temp;
      }
    }
    for (i = 0; i < n; i++) {
      if (a[i] != i + 1) {
        break;
      }
    }
    return i + 1;
  }

  /**
   * method1(基数排序，可控制需要的最小值)
   */
  public static int method1(int[] a, int n) {

    for (int i = 0; i < n; i++) {
      //System.out.println(i + "==" + a[i]);
      while (a[i] >= 0 && a[i] < n && a[i] != a[a[i]]) {
        int temp = a[i];
        a[i] = a[temp];
        a[temp] = temp;
      }
    }
    for (int i = 0; i < n; i++) {
      if (a[i] != i) {
        return i;
      }
    }
    return n + 1;
  }

  /**
   * method1Extend(方法一 扩展，可控制需要的最小值,前提 是min<n)
   */
  public static int method1Extend(int[] a, int n, int min) {

    if (min < n) {
      for (int i = min; i < n; i++) {
        while (a[i] >= 0 && a[i] < n && a[i] != a[a[i]]) {
          int temp = a[i];
          a[i] = a[temp];
          a[temp] = temp;
        }
      }
      for (int i = min; i < n; i++) {
        if (a[i] != i) {
          return i;
        }
      }
    }

    return n + 1;
  }

  /**
   * testname(需要借助额外数组,较容易理解)
   */
  public static int method2(int[] a, int n) {
    int[] b = new int[n];
    for (int i = 0; i < n; i++) {
      b[i] = 0;
    }
    for (int i = 0; i < n; i++) {
      if (a[i] > 0 && a[i] < n) {
        b[a[i]] = 1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (b[i] == 0) {
        return i;
      }
    }
    return n + 1;

  }
}
