package com.adk.test;

import com.adk.leetcode.arrays.MaxArea;
import com.adk.leetcode.dp.CanJumpII;
import com.adk.leetcode.dp.MaxSubArray;
import com.adk.leetcode.dp.TotalOfLis;
import com.adk.leetcode.stack.IsValid;
import com.adk.leetcode.stack.ValidateStackSequences;
import com.adk.leetcode.tree.Pathsum;
import com.adk.tree.TreeNode;
import org.junit.Test;

public class TestClass {

    @Test
    public void test1(){
        int [] a={1,2,4,3};
        MaxArea.maxArea(a);
    }
    @Test
    public void test2(){
        int [] a={1,2,4,3,5};
        TotalOfLis.findNumberOfLIS(a);
    }
    @Test
    public void test3(){
        int [] a={-2,1};
        MaxSubArray.maxSubArray(a);
    }
    @Test
    public void test4(){
        int[] a={1,2,3,99,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        CanJumpII.jump(a);
    }
    @Test
    public void testTree(){
        TreeNode node6 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(7, null ,null );
        TreeNode node1 = new TreeNode(4, node3, node6);
        TreeNode node2 = new TreeNode(2, node5 ,node4);
        TreeNode root = new TreeNode(1, node1, node2);
        Pathsum pathsum = new Pathsum();
        pathsum.pathSum(root, 7);
    }
}
