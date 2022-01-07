package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

/**
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 *
 * 返回移除了所有不包含 1 的子树的原二叉树。
 *
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * 示例 2：
 *
 *
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 * 示例 3：
 *
 *
 * 输入：root = [1,1,0,1,1,0,1,0]
 * 输出：[1,1,0,1,1,null,1]
 *
 */
public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        boolean trueornull=hasOne(root);
        if(!trueornull){
            root=null;
        }
        return root;
    }
    public boolean hasOne(TreeNode root){
        if(root==null){
            return true;
        }
        if(root.left==null&&root.right==null){
            return root.val==1;
        }
        boolean leftHas=hasOne(root.left);
        boolean rightHas=hasOne(root.right);
        if(!leftHas){
            root.left=null;
        }
        if(!rightHas){
            root.right=null;
        }
        if(root.left==null&&root.right==null){
            return root.val==1;
        }
        return true;
    }
}
