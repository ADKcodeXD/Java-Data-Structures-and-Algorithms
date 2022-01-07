package com.adk.leetcode.recall;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 */
public class Permute {
    List<List<Integer>> res=new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track=new LinkedList<>();
        back(nums,track);
        return res;
    }
    private void back(int[] nums,LinkedList<Integer> track){
        if(track.size()==nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //回溯前
            if(track.contains(nums[i])){
                continue;//如果当前列表中已经加入了该元素  跳过这一轮
            }
            track.add(nums[i]);

            //回溯
            back(nums,track);

            //回溯后
            track.removeLast();
        }
    }
}
