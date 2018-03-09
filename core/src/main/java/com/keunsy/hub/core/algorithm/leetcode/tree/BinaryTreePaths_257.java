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


  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<String> answer = new ArrayList<String>();
    if (root != null) {
      searchBT(root, "", answer);
    }
    return answer;
  }

  private void searchBT(TreeNode root, String path, List<String> answer) {
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
}
