package com.adk.leetcode.recall;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    List<List<Integer>> ans=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0);
        return ans;
    }
    public void dfs(int[] candidates,int target,int startIndex){
        if(target==0) {
            ans.add(new LinkedList<>(temp));
            return;
        }
        if(target<0) return;
        for(int i=startIndex;i<candidates.length;i++) {
            if(i > startIndex && candidates[i] == candidates[i-1]) continue;
            temp.addLast(candidates[i]);
            target-=candidates[i];

            dfs(candidates,target,i+1);

            target+=candidates[i];
            temp.removeLast();

        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int []a={2,1,2,2,5};

        combinationSum2.combinationSum2(a,5);

    }
}
