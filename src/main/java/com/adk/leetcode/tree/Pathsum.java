package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class Pathsum {
    LinkedList<Integer> temp=new LinkedList<>();
    LinkedList<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        go(root,target);
        return res;
    }
    public void go(TreeNode root, int target){
        if(root==null) return;//为空即返回
        target-=root.val;
        if(target == 0 &&root.left==null && root.right==null ){
            temp.add(root.val);
            res.add(new LinkedList(temp));
            temp.removeLast();
            return;
        }
        else{
            temp.add(root.val);
            go(root.left,target);
            go(root.right,target);
            temp.removeLast();
        }
        return;
    }
}
