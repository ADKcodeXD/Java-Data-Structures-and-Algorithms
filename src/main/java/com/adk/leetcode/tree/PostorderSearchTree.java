package com.adk.leetcode.tree;

public class PostorderSearchTree {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    public boolean recur(int[]postorder ,int i,int j){
        if(i>=j) return true;
        int p=i;
        while(postorder[p]<postorder[j]) p++ ;//当数字比跟节点小，说明这是左子树
        int right=p;
        while (postorder[p]>postorder[j]) p++;//当数字比根节点大,这是右子树

        return p==j&&recur(postorder,i,right-1)&&recur(postorder,right,j-1);//每次搞完把最后一个节点排除
    }
}
