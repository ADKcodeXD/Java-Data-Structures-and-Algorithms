package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

import java.util.*;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum=queue.size();//记录每层的节点数
            ArrayList<Integer> subList = new ArrayList<>();//每层的子数组
            for(int i=0;i<levelNum;i++){
                //将每层队列的节点出队完再下一层。
                TreeNode treeNode = queue.poll();
                subList.add(treeNode.val);
                if(treeNode.left!=null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right!=null){
                    queue.add(treeNode.right);
                }
            }
            res.add(subList);
        }
        return res;
    }
}
