package com.adk.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树遍历实现
 * 包含先序中序后序的递归实现和非递归实现
 *
 */
public class Traversal {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 先序遍历 递归实现
     * @param treeNode
     */
    public void preOrderTraversal(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        System.out.print(treeNode.val);
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    /**
     * 前序遍历，非递归实现，先入栈右节点再入栈左节点
     * @param treeNode
     */
    public void preOrderTraversal_NonRecursive(TreeNode treeNode){
        if (treeNode==null) return;
        TreeNode T=treeNode;
        Deque<TreeNode> stack=new LinkedList<>();
        stack.addLast(T);
        while (!stack.isEmpty()){
            T=stack.removeLast();
            System.out.print(T.val+" ");
            if(T.right!=null) stack.addLast(T.right);
            if(T.left!=null) stack.addLast(T.left);
        }
    }

    /**
     * 中序遍历 ，递归实现
     * @param treeNode
     */
    public void inOrderTraversal(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.val);
        inOrderTraversal(treeNode.right);
    }

    /**
     * 中序遍历的非递归实现，使用栈来进行实现
     * @param treeNode
     */
    public void inOrderTraversal_NonRecursive(TreeNode treeNode){
        if (treeNode==null) return;
        TreeNode T=treeNode;
        Deque<TreeNode> stack=new LinkedList<>();
        stack.addLast(T);
        while (!stack.isEmpty()){
            if(T!=null &&  T.left!=null) {
                stack.add(T.left);
                T = T.left;
            }else {//如果是左节点是空的 就走这个分支，说明没有左子树了
                T = stack.removeLast();//返回到上一个节点（根节点）
                System.out.print(T.val+" ");//访问
                if(T!=null && T.right!=null) {//如果栈点元素有右孩子的话，将有节点压入栈中
                    stack.addLast(T.right);
                   T = T.right;
                }else
                    T = null;//p=stk.pop;已经访问过p了，p设置为null
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(5, null, null);
        TreeNode node5 = new TreeNode(6, null, null);
        TreeNode node1 = new TreeNode(2, node3, null);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode root = new TreeNode(1, node1, node2);
        Traversal traversal = new Traversal();
        traversal.preOrderTraversal_NonRecursive(root);
    }
}
