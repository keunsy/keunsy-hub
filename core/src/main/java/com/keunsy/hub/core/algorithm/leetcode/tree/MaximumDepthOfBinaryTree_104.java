package com.keunsy.hub.core.algorithm.leetcode.tree;

/**
 * Created on 2018/2/9.
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * .  /  \
 * ..15   7
 * return its depth = 3.
 *
 *
 * 递归思维：
 * 1.归（非必要性）  返回什么值？倒序看待
 * 2.递（必要） 如何传递（调用自身）
 * 3.结束条件（必要） 什么时候结束
 *
 * 递归分为：
 * 1.有递无归（比如分治处理，过程打印信息）
 * 2.有递有归（需要向上层传递）
 */
public class MaximumDepthOfBinaryTree_104 {

  public static void main(String[] args) {

    System.out.println(maxDepth(new TreeNode()));
  }

  //遍历求树的深度 当存在左或者右
  static int maxDepth(TreeNode root) {

    if (root == null) {//结束条件  无子节点
      return 0;//归
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));//归+递  max用于同层去重
  }





}
