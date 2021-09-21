package com.adk.leetcode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */
public class Rob {

    /**
     * 动态规划  dp[i][0]第x家不抢的最大收益
     * dp[i][1]第x家抢了的最大收益
     * 也即 maxValue=Max(dp[i-1][0]+nums[i],dp[i-1][1])
     * 前一家不抢（抢当前这一家）的收益大 还是 前一家抢 (这一家不抢)的收益大
     * @param nums
     * @return
     */
    public static int rob(int[] nums){
        if(nums.length==0) return 0;
        if(nums.length==1){
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[][] dp=new int[nums.length+1][2];
        dp[0][0]=0;
        dp[0][1]=nums[0];
        dp[1][0]=dp[0][1];
        dp[1][1]=nums[1];

        //base 第一家抢 即nums0 抢第二家 即nums1
        for(int i=2;i<nums.length;i++){
            dp[i][1]=dp[i-1][0]+nums[i];
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][0]);//对比上一家抢和不抢的收益 如果上一家不抢比抢收益更大 那就等于不抢的收益
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }

    public static void main(String[] args) {
        int [] ro={99,0,0,0,1,0,88,45,88,99,0,0,1,50};
        rob(ro);
    }
}
