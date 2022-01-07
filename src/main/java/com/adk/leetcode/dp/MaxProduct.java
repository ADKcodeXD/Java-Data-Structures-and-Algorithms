package com.adk.leetcode.dp;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
    public static int maxProduct2(int[] nums) {
        if(nums.length==0) return 0;
        int max=0;
        int[] dp=new int[nums.length];//定义一个dp数组 存放负数和正数
        /**先相乘 对比max 放入max  如果有负数 先暂时放入dp[i][1]中
         *对比有负数的情况dp[i-1][0]*nums[i] or dp[i-1][1]*nums[i]
         *其实有偶数个负数的情况下 那么最大数组就是整个数组相乘(如果其中有0就不算) 如果只有奇数个负数的话 那么就要根据dp求出最大乘积
         */
        int temp=nums[0];;
        dp[0]=nums[0];
        if(nums[0]<0){
            dp[0]=0;
        }else if(nums[0]==0){
            dp[0]=0;
            temp=0;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>0){
                if(dp[i-1]==0){
                    dp[i]=nums[i];
                }else{
                    dp[i]=dp[i-1]*nums[i];
                }
                temp*=nums[i];
                max=Math.max(dp[i],max);
            }else if(nums[i]<0){
                dp[i]=0;
                temp*=nums[i];
                max=Math.max(temp,max);
            }else {
                dp[i]=0;
                temp=0;
            }
        }
        return max;
    }
}
