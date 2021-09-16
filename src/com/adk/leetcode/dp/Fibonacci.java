package com.adk.leetcode.dp;

/**
 * 斐波那契数列数列 使用动态规划进行求解
 * 答案需要在大于1000000007进行取模
 */
public class Fibonacci {
    public static int fib(int n) {
        if(n==0) return 0;
        int[]dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
            if(dp[i]>1000000008){
                dp[i]%=1000000007;
            }
        }
        return dp[n];
    }

    /**
     * fib2 优化空间复杂度为O（1）
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if(n==0) return 0;
        int prev=0,curr=1;
        for(int i=2;i<=n;i++){
            int sum=prev+curr;
            prev=curr;
            if(sum>1000000007) {
                curr=sum%1000000007;
            }else {
                curr=sum;
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(fib2(55));
        System.out.println(fib(55));
    }
}
