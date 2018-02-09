package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/8.
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * 杨辉三角
 */

public class PascalsTriangle_118 {

  public static void main(String[] args) {

    for (List<Integer> list : generate(6)) {
      for (Integer integer : list) {
        System.out.print(integer + ",");
      }
      System.out.println();
    }

  }

  static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> list = Lists.newArrayList();
    for (int i = 0; i < numRows; i++) {
      List<Integer> inners = Lists.newArrayList();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          inners.add(1);
        } else {
          inners.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
        }
      }
      list.add(inners);

    }
    return list;
  }

  /**
   *  优质解答
   * @param numRows
   * @return
   */
  static List<List<Integer>> generate1(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();

    // First base case; if user requests zero rows, they get zero rows.
    if (numRows == 0) {
      return triangle;
    }

    // Second base case; first row is always [1].
    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for (int rowNum = 1; rowNum < numRows; rowNum++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prevRow = triangle.get(rowNum-1);

      // The first row element is always 1.
      row.add(1);

      // Each triangle element (other than the first and last of each row)
      // is equal to the sum of the elements above-and-to-the-left and
      // above-and-to-the-right.
      for (int j = 1; j < rowNum; j++) {
        row.add(prevRow.get(j-1) + prevRow.get(j));
      }

      // The last row element is always 1.
      row.add(1);

      triangle.add(row);
    }

    return triangle;
  }
}
