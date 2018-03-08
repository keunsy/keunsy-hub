package com.keunsy.hub.core.algorithm.leetcode.linkedlist;

import com.keunsy.hub.core.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/description/
 *
 * Reverse a singly linked list.
 *
 * click to show more hints.
 *
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * 说明：
 * todo
 */
public class ReverseLinkedList_206 {

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);

    print(head);

    System.out.println();

    print(func(head));


  }

  private static void print(ListNode head) {
    ListNode current = head;
    while (current != null) {
      System.out.println(current.data);
      current = current.next;
    }
  }

  private static ListNode func(ListNode head) {

    ListNode current = head;
    ListNode pre = null;
    while (current != null) {        //  1  2   3     //  2  3    // 3
      ListNode temp = current.next;  //  2  3         //  3       // null
      current.next = pre;            //  1            //  2  1    // 3  2  1
      pre = current;                 //  1            //  2  1    // 3  2  1
      current = temp;                //  2  3         //  3       // null
    }

    return pre;
  }

  /**
   * 递归方法
   */
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }


}
