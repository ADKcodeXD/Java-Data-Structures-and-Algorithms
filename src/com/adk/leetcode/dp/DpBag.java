package com.adk.leetcode.dp;

/**
 * 经典01背包问题
 * 判断每个状态下
 * 装入当前物品还是不装入当前物品的价值大
 * dp[i-1][w-wt[i]]+val[i] 装入当前物品=前i-1个物品且容量减去当前物品 并加上当前物品的值
 * dp[i-1][w]不装入当前物品 也即前i-1个物品的价值最大值
 */
public class DpBag {
    public static int Bag01(int W,int N,int []wt,int []val){
        int [][] dp=new int[N+1][W+1];
        for(int i=1;i<=N;i++){
            for(int w=1;w<=W;w++){
                //自底向上进行遍历
                if(w-wt[i-1]<0) dp[i][w]=dp[i-1][w];
                else {
                    dp[i][w]=Math.max(
                            dp[i-1][w],
                            dp[i-1][w-wt[i-1]]+val[i-1]
                    );
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int[]val={5,3,2,7,8};
        int[]weight={6,2,1,7,9};
        System.out.println(Bag01(10, 5, weight, val));
    }
}
