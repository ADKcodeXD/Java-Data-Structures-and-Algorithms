package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

public class PathSumII {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum2(root,targetSum,0);
    }
    public int pathSum2(TreeNode root, int targetSum,int nowValue) {
        if(root==null) return 0;
        if(targetSum==nowValue+root.val){
            return 1;
        }
        int leftPath=0,rightPath=0,excludeMyselfLeft=0,excludeMyselfRight=0;
        if(targetSum>nowValue+root.val){
            leftPath=pathSum2(root.left,targetSum,nowValue+root.val);
            rightPath=pathSum2(root.right,targetSum,nowValue+root.val);
            excludeMyselfLeft=pathSum2(root.left,targetSum,root.val);
            excludeMyselfRight=pathSum2(root.right,targetSum,root.val);
        }else if(targetSum<nowValue+root.val){
            leftPath=0;
            rightPath=0;
            excludeMyselfLeft=pathSum2(root.left,targetSum,0);
            excludeMyselfRight=pathSum2(root.right,targetSum,0);
        }
        return leftPath+rightPath+excludeMyselfLeft+excludeMyselfRight;
    }
}
