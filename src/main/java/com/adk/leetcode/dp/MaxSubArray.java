package com.adk.leetcode.dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 */
public class MaxSubArray {
    public  static int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i]+nums[i]>dp[i-1]+nums[i]){
                dp[i]=nums[i];//说明前面的总和还没当前nums[i]大 直接从nums[i]继续开始+起
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            max=Math.max(dp[i],max);//出来的时候都得比较一下到底谁大谁小
        }
        return max;
    }
}
