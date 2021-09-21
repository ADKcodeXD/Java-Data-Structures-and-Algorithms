package com.adk.leetcode.dp;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 *
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *
 */
public class TotalOfLis {
    /**
     * 很疑惑
     * 首先了解LIS的解法
     * 填充dp数组为1  然后每次遍历i次数组
     * 1 2 5 8 3 6
     * 1  - > dp[0]=1
     * 1 2  -> dp[1]=max(dp[1],dp[j(0)]+1)   i = 1 ,j = 0  j<i
     * 1 2 5 -> dp[2]=max(dp[2],dp[j(1)]+1)  i = 2 ,j = 1  j<i
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int[] cnt=new int[nums.length];
        int max=1;
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        for( int i=0 ; i<nums.length ; i++){
            for( int j=0 ; j<i ; j++ ){
                if( nums[j]< nums[i] ){
                    if( dp[i] < ( dp[j] + 1 ) ){
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if( dp[i] == ( dp[j] + 1 ) ){
                        cnt[i] += cnt[j];
                    }
                }
            }
            max=Math.max(dp[i],max);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) ans += cnt[i];
        }
        return ans;
    }
}
