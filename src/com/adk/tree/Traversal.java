package com.adk.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树遍历实现
 * 包含先序中序后序层序的递归实现和非递归实现
 *
 */
public class Traversal {

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
            while(T!=null &&  T.left!=null) {
                stack.add(T.left);
                T = T.left;
            }//如果是左节点是空的 就走这个分支，说明没有左子树了

            T = stack.removeLast();//返回到上一个节点（根节点）
            System.out.print(T.val+" ");//访问

            if(T!=null && T.right!=null) {//如果栈点元素有右孩子的话，将有节点压入栈中
                stack.addLast(T.right);
                T = T.right;
            }else {
                T=null;
            }

        }
    }

    /**
     * 后序遍历的递归实现
     * @param treeNode
     */
    public void postOrderTraversal(TreeNode treeNode){
        if(treeNode==null){
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.val);
    }

    /**
     * 二叉树层先遍历法 使用队列进行遍历。
     * @param treeNode
     */
    public void levelOrderTraversal(TreeNode treeNode){
        if(treeNode==null) return;
        TreeNode T=treeNode;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(T);
        while (!queue.isEmpty()){
            T=queue.poll();
            System.out.print(T.val+" ");
            if (T.left!=null) queue.add(T.left);
            if (T.right!=null) queue.add(T.right);
        }
    }


    public static void main(String[] args) {
        /**
         * 新建一个树结构进行测试
         * 树的结构为
         *                   1
         *          2                3
         * 4            null    5           6
         */
        TreeNode node3 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(5, null, null);
        TreeNode node5 = new TreeNode(6, null, null);
        TreeNode node1 = new TreeNode(2, node3, null);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode root = new TreeNode(1, node1, node2);
        Traversal traversal = new Traversal();
        traversal.inOrderTraversal_NonRecursive(root);
    }
}
