package com.adk.tree;

/**
 * 封装一个树类型
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

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
class MaxHeapNode{
    int []data;
    int maxSize;
    public int size;
    final int MAXDATA=9999999;
    public MaxHeapNode(int maxSize){
        this.maxSize=maxSize;
        this.data=new int[maxSize+1];
        this.data[0]=MAXDATA;
        this.size=0;
    }
}
