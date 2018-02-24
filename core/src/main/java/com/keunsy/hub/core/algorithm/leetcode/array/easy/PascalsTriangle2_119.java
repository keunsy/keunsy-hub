package com.keunsy.hub.core.algorithm.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/8.
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * 杨辉三角
 *
 * todo 等待进一步研究
 */

public class PascalsTriangle2_119 {

  public static void main(String[] args) {

    System.out.println(getRow(4));


  }

  static List<Integer> getRow(int rowIndex) {
    List<Integer> list = new ArrayList<>();
    if (rowIndex < 0)
      return list;

    for (int i = 0; i < rowIndex + 1; i++) {
      list.add(0, 1);
      for (int j = 1; j < list.size() - 1; j++) {
        list.set(j, list.get(j) + list.get(j + 1));
      }
    }
    return list;
  }

}
