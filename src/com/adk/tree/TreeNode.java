package com.adk.tree;

/**
 * 封装一个树类型
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class AVLTreeNode{
    int height;
    AVLTreeNode left;
    AVLTreeNode right;
    int val;

    public AVLTreeNode(int height, AVLTreeNode left, AVLTreeNode right, int val) {
        this.height = height;
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
