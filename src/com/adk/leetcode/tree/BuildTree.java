package com.adk.leetcode.tree;

import com.adk.tree.Traversal;
import com.adk.tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        TreeNode treeNode=new TreeNode(preorder[0]);
         for (int j=0;j<inorder.length;j++){
             if(preorder[0]==inorder[j]){
                 int length=j+1;
                 int[] a=Arrays.copyOfRange(preorder,1,j+1);
                 int[] b=Arrays.copyOfRange(preorder,j+1,preorder.length);
                 int[] c=Arrays.copyOfRange(inorder,0,j);
                 int[] d=Arrays.copyOfRange(inorder,j+1,inorder.length);
                 treeNode.left=buildTree(a,c);
                 treeNode.right=buildTree(b,d);
             }
         }
         return treeNode;
    }

    public static void main(String[] args) {
        int[] a1={1,2};
        int[] a2={1,2};
        TreeNode treeNode = buildTree(a1, a2);
        Traversal traversal=new Traversal();
        traversal.inOrderTraversal_NonRecursive(treeNode);
    }
}
