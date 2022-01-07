package com.adk.leetcode.recall;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> temp=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,candidates[0],target,0);
        return res;
    }
    public void backtrack(int[] candidates,int nowNum,int target,int startIndex){
        if(target==0){
            res.add(new LinkedList(temp));
            return;
        }else if(target<0){
            return;
        }else{
            for(int i=startIndex;i<candidates.length;i++){

                temp.addLast(candidates[i]);
                target-=candidates[i];

                backtrack(candidates,candidates[i],target,i);

                target+=candidates[i];
                temp.removeLast();
            }
        }
    }
}
