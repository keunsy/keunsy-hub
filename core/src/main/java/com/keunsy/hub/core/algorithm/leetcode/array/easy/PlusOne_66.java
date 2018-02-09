package com.keunsy.hub.core.algorithm.leetcode.array.easy;

/**
 * Created on 2018/2/8.
 * https://leetcode.com/problems/plus-one/description/
 *
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 *
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * 大意：用一个数组表示数字，不含负数以及不含0，现在将该数字的值+1，并以数组形式体现(一个数字小于10占一个数组位)
 */
public class PlusOne_66 {


  public static void main(String[] args) {
    int array[] = {1, 1, 3, 4, 1, 9, 9};


    for (int i : plusOne(array)) {
      System.out.print(i);
    }

  }

  static int[] plusOne(int[] digits) {

    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    //全都是9的情况
    int[] newNumber = new int[n + 1];
    newNumber[0] = 1;

    return newNumber;
  }
}
