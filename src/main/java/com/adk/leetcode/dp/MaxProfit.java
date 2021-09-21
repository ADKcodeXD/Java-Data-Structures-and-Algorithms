package com.adk.leetcode.dp;

/**
 * leetcode
 * 买卖股票一次
 * 保证利润是最大的
 * 因此可以使用动态规划  状态为
 * 第i天买卖和前i-1天买卖的最大利润比较
 * 设置值记录前i天最小的花费成本可知在哪一天买入
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int cost=Integer.MAX_VALUE;
        int profit=0;
        int length=prices.length;
        for(int i=0;i<length;i++){
            cost=Math.min(cost,prices[i]);
            profit=Math.max(profit,prices[i]-cost);
        }
        return profit;
    }
}
