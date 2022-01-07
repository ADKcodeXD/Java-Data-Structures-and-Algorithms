package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BSTIterator {
    Deque<TreeNode> Iterator =new LinkedList<>();
    public BSTIterator(TreeNode root) {
        init(root);
    }
    private void init(TreeNode root){
        if(root==null) return;
        init(root.left);
        Iterator.add(root);
        init(root.right);
    }
    public int next() {
        return Iterator.poll().val;
    }

    public boolean hasNext() {
        return Iterator.peek()==null?false:true;
    }
}
