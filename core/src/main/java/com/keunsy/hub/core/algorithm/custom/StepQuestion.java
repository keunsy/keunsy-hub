package com.keunsy.hub.core.algorithm.custom;

/**
 * Created on 2018/2/9.
 * 有一100阶层的楼梯，有三种走楼梯方式，一次走一阶， 一次走两阶，一次走三阶。用算法实现，走完100阶
 */
public class StepQuestion {

  public static void main(String[] args) {

    step(100);
  }

  static double step(int n) {
    if (n == 1 || n == 2)
      return n;
    else
      return step(n - 1) + step(n - 2);
  }
}
