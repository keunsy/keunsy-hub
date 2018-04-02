package com.keunsy.hub.core.algorithm.leetcode.tree;

import com.keunsy.hub.core.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 * 说明：从根节点开始，输出所有的路径
 */
public class BinaryTreePaths_257 {


  public static void main(String[] args) {


    TreeNode root = new TreeNode();
    root.value = 1;

    TreeNode left1 = new TreeNode(2);
    TreeNode rigth1 = new TreeNode(3);
    root.left = left1;
    root.right = rigth1;

    left1.right = new TreeNode(5);

    rigth1.left = new TreeNode(6);
    rigth1.right = new TreeNode(10);

    System.out.println(binaryTreePaths(root));

    System.out.println(binaryTreeSums(root));

    print(root);

  }


  static List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) {
      searchBT(root, "", answer);
    }
    return answer;
  }

  static void searchBT(TreeNode root, String path, List<String> answer) {
    if (root.left == null && root.right == null) {
      answer.add(path + root.value);
    }
    if (root.left != null) {
      searchBT(root.left, path + root.value + "->", answer);
    }
    if (root.right != null) {
      searchBT(root.right, path + root.value + "->", answer);
    }
  }


  /**
   * 求和（非题目要求）
   */
  static List<Integer> binaryTreeSums(TreeNode root) {
    List<Integer> sums = new ArrayList<>();
    if (root != null) {
      getSums(root, root.value, sums);
    }
    return sums;
  }

  private static void getSums(TreeNode root, Integer sum, List<Integer> sums) {

    if (root.left == null && root.right == null) {
      sums.add(sum);
    }
    if (root.left != null) {
      getSums(root.left, sum + root.left.value, sums);
    }
    if (root.right != null) {
      getSums(root.right, sum + root.right.value, sums);
    }
  }

  /**
   * 遍历
   */
  static void print(TreeNode root) {

    if (root == null) {
      return;
    }

//    System.out.println(root.value);//前序：根结点 ---> 左子树 ---> 右子树
    print(root.left);
//    System.out.println(root.value);中序：左子树 ---> 根结点 ---> 右子树
    print(root.right);
//    System.out.println(root.value);后序：左子树 ---> 右子树 ---> 根结点
  }


}
