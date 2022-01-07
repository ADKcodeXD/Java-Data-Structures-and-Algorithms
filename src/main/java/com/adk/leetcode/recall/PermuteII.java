package com.adk.leetcode.recall;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteII {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums,used);
        return res;
    }
    public void dfs(int[] nums ,boolean[] used){
        if(temp.size()==nums.length){
            res.add(new LinkedList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if (used[i])   continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i - 1])continue;

            temp.addLast(nums[i]);
            used[i] = true;

            dfs(nums,used);

            used[i] = false;
            temp.removeLast();
        }
    }
}
