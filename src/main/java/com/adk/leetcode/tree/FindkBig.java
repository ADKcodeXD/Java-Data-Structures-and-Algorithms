package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class FindkBig {

    List<Integer> res=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        Integer[] inorder = inorder(root);
        return inorder[inorder.length-k];
    }

    public Integer[] inorder(TreeNode root){
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode T=root;
        stack.add(T);
        while (!stack.isEmpty()){
            while(T!=null && T.left!=null){
                stack.push(T.left);
                T=T.left;
            }
            T=stack.poll();
            res.add(T.val);
            if(T.right!=null){
                stack.push(T.right);
                T=T.right;
            }else {
                T=null;
            }
        }
        return res.toArray(new Integer[res.size()]);
    }
}
