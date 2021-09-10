package com.adk.leetcode;

import com.adk.tree.TreeNode;

public class IsValidBST {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)) return false;
        if(prev!=null && prev.val>=root.val) return false;
        prev=root;//前一个节点
        if(!isValidBST(root.right)) return false;
        return true;
    }
}
