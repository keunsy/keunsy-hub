package com.keunsy.hub.core.algorithm.leetcode.dynamicprogramming;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * Created on 2018/3/9.
 *
 * 爬楼梯 打印所有路径  ClimbingStairs_70 加强版
 */
public class ClimbingStairsPrintAllPath {

  static Set<String> set = Sets.newHashSet();

  public static void main(String[] args) {


    int n = 10;
    climb(n);
    set.stream().sorted().forEach(x -> System.out.println(x));

  }

  private static void climb(int n) {


    func(0, 0, n, "");

  }

  private static void func(int step, int sum, int n, String path) {


    if (sum == n) {
      set.add(path);
      return;
    } else if (sum > n) {
      return;
    }
    sum += step;
    if (step >= 1) {
      path += " " + step;
    }
    func(1, sum, n, path);
    func(2, sum, n, path);
  }
}
