package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.Arrays;

public class ConstructMaximumBinaryTree {
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }
    public TreeNode build(int[] nums,int start,int end) {
        if(start>end){
            return null;//说明已经到了尽头
        }
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                index=i;
                max=nums[i];
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=build(nums,start,index-1);
        root.right=build(nums,index+1,end);
        return root;
    }
}
