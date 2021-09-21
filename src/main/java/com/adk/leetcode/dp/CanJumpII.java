package com.adk.leetcode.dp;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 */
public class CanJumpII {
    /**
     * 动态规划  dp[0]=1;
     * 首先 如果第一个是2 说明跳一步能达到 0 1 2  dp[1] dp[2] =1
     * 到dp[2] 即能够到达   2 3 4  dp[2]=1 dp[3]=2 dp[4]=2
     * 返回dp [4]
     * 两次循环 当j=length 即可返回
     * 还是用贪心吧  ······························
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int maxPos=0;
        int end=0;
        int step=0;
        for(int i=0;i<nums.length-1;i++){
            maxPos=Math.max(maxPos,i+nums[i]);
            if(i==end){
                end=maxPos;
                step++;
            }
            if(end>=nums.length-1) break;//如果end大于长度 明显可以到达最后值 直接返回即可
        }
        return step;
    }
}
