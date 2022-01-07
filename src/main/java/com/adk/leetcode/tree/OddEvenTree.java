package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OddEvenTree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean isOdd=true;
        while(!queue.isEmpty()){
            int length=queue.size();
            int prev=isOdd?0:Integer.MAX_VALUE;
            for(int i=0;i<length;i++){
                TreeNode node=queue.poll();
                //判断 如果这个时候是奇数层 只能严格递增 偶数层则严格递减 按照isOdd判断
                int cur=node.val;
                if(isOdd && (cur%2==0||cur<=prev)) return false;
                if(!isOdd && (cur%2!=0||cur>=prev)) return false;
                prev=cur;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            isOdd=!isOdd;
        }
        return true;
    }
}
