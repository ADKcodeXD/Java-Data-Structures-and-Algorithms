package com.adk.leetcode;

import com.adk.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root){
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int size;int numsize;
        Deque<Integer> nums=new LinkedList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        nums.add(root.val);
        while (!queue.isEmpty()){
            size=queue.size();
            numsize=nums.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null){
                    queue.add(poll.left);
                    nums.add(poll.left.val);
                }else {
                    nums.add(Integer.MIN_VALUE);
                }
                if(poll.right!=null){
                    queue.add(poll.right);
                    nums.add(poll.right.val);
                }else {
                    nums.add(Integer.MIN_VALUE);
                }
            }
            nums2.clear();
            for(int i=0;i<numsize;i++){
                nums2.add(nums.poll());
            }

            for(int i=0,j=nums2.size()-1; i<nums2.size() && j>0&& i<j;i++,j--){
                if(!nums2.get(i).equals(nums2.get(j))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode node6 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(3, null, null);
        TreeNode node3 = new TreeNode(3, null ,null );
        TreeNode node1 = new TreeNode(2, node3, null);
        TreeNode node2 = new TreeNode(2, null ,node4);
        TreeNode root = new TreeNode(1, node1, node2);
        boolean symmetric = isSymmetric.isSymmetric(root);
        System.out.println(symmetric);
    }
}
