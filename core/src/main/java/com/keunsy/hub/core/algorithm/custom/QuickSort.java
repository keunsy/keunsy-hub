package com.keunsy.hub.core.algorithm.custom;

/**
 * Created by chenr on 2017/2/8.
 */
public class QuickSort {


  private QuickSort() {
  }

  public static void doQuickSort(long[] s) {
    quickSort(s, 0, s.length - 1);
  }


  public static void quickSort(long[] s, int l, int r) {
    if (l < r) {
      int i = l;
      int j = r;
      long x = s[l];

      while (i < j) {
        while (i < j && s[j] >= x) {
          --j;
        }

        if (i < j) {
          s[i++] = s[j];
        }

        while (i < j && s[i] <= x) {
          ++i;
        }

        if (i < j) {
          s[j--] = s[i];
        }
      }

      s[i] = x;
      quickSort(s, l, i - 1);
      quickSort(s, i + 1, r);
    }

  }
}
