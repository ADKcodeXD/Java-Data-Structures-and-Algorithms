package com.adk.leetcode.recall;

import java.util.LinkedList;
import java.util.List;

public class SubSet {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList temp=new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {

        res.add(new LinkedList<>(temp));
        for(int i=1;i<=nums.length;i++){
            dfs(nums,i,0);
        }
        return res;
    }
    public void dfs(int[] nums , int length,int startIndex){
        if(temp.size()==length){
            res.add(new LinkedList<>(temp));
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            if (res.contains(nums[i]))continue;
            temp.addLast(nums[i]);

            dfs(nums,length,i);

            temp.removeLast();
        }
    }
}
