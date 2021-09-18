package com.adk.leetcode.tree;

import com.adk.tree.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 */
public class IsSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null) return false;

        //先判断A和B是否相同 如果不相同就用A左和A右和B进行判断
        return recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    //结束条件  如果B=null 即表示B完成递归  B数确实属于A树
    //如果A==null 说明下面没有东西了 说明B不属于该树
    //判断完之后继续判断left和right
    public boolean recur(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null||A.val!=B.val) return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}
