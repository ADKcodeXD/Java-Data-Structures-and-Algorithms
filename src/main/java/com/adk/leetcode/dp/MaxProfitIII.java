package com.adk.leetcode.dp;

public class MaxProfitIII {
    /**
     * dp[i][0]=max(dp[i-1][0],dp[i-1][2]-p[i])(由于是 01x00001x0001) x是无法买入的
     *                                          所以要一个2来记录i-1的最大值
     *                                          [i-1][2]-p[i] 前前天不买今天买
     * dp[i][1]=dp[i-1][0]+p[i]                 前x天不买的最大利润 加上今天卖的最大利润
     * dp[i][2]=max(dp[i-1][2],dp[i-1][1])      [如果昨天卖了 那就记录昨天的最大值]
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][3];
        dp[0][0]=-prices[0];
        for (int i=1;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);
    }
}
