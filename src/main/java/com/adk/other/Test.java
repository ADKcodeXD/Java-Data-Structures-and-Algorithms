package com.adk.other;

import com.adk.tree.Traversal;
import com.adk.tree.TreeNode;
import com.adk.util.Util;

import java.util.*;

public class Test {
    public boolean isparlindrome(int x){
        if(x<10&&x>-10) return true;
        if(x<0){
            x=-x;
        }
        int m=1;//用于获取数字最高位
        int a=(int) Math.log10(x);//log10取数字位数
        for (int i=0;i<a;i++) m*=10;//此时m和x的数量级是一样的
        while (x!=0){
            int last=x%10;
            int frist=x/m;
            if(last!=frist) return false;
            x/=m;x/=10;
            m/=100;
        }
        return true;
    }
    public static int[] treeRowMax(TreeNode tree){
        if(tree==null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(tree);
        List<Integer> res=new ArrayList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            int maxValue=0;
            for(int i=0;i<size;i++){
                TreeNode treePoint=queue.poll();
                if(treePoint.val>maxValue){
                    maxValue=treePoint.val;
                }
                if(treePoint.left!=null){
                    queue.add(treePoint.left);
                }
                if (treePoint.right!=null){
                    queue.add(treePoint.right);
                }
            }
            res.add(maxValue);
        }
        int[] arrays=new int[res.size()];
        for(int i=0;i<res.size();i++){
            arrays[i]=res.get(i);
        }
        return arrays;
    }
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(5, null, null);
        TreeNode node5 = new TreeNode(6, null, null);
        TreeNode node1 = new TreeNode(2, node3, null);
        TreeNode node2 = new TreeNode(3, node4, node5);
        TreeNode root = new TreeNode(1, node1, node2);
        Traversal traversal = new Traversal();
        traversal.inOrderTraversal_NonRecursive(root);
        int[] ints = treeRowMax(root);
    }
}
