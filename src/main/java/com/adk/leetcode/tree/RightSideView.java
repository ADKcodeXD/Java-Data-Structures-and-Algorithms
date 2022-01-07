package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return res;
        bfsRight(root);
        return res;
    }
    public void bfsRight(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode a=queue.poll();
                if(a.left!=null) queue.add(a.left);
                if(a.right!=null) queue.add(a.right);
                if(i==size-1) res.add(a.val);
            }
        }
    }
}
