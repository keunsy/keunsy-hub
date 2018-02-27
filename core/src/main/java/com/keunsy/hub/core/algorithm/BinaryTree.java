package com.keunsy.hub.core.algorithm;

/**
 * 构建二叉树
 * Created on 2018/2/27.
 */
public class BinaryTree {

  private Node root;

  private class Node {
    private Node left;
    private Node right;
    private int data;

    public Node(int data) {
      this.data = data;
    }
  }

  /**
   * 递归创建二叉树
   */
  // TODO: 2018/2/27 待确认
  public void buildTree(Node node, int data) {
    if (root == null) {
      root = new Node(data);
    } else {
      if (data < node.data) {
        if (node.left == null) {
          node.left = new Node(data);
        } else {
          buildTree(node.left, data);
        }
      } else {
        if (node.right == null) {
          node.right = new Node(data);
        } else {
          buildTree(node.right, data);
        }
      }

    }

  }
}
