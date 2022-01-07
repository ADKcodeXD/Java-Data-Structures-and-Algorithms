package com.adk.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

public class TreeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }
    public void dfs(Node root){
        if(root == null) return;
        dfs(root.left);

        if(pre != null) pre.right = root;
        else head = root;

        root.left = pre;
        pre = root;

        dfs(root.right);

    }
}
