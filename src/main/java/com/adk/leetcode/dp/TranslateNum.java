package com.adk.leetcode.dp;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 */
public class TranslateNum {
    public int translateNum(int num) {
        if(num<=9) return 1;
        String numString = String.valueOf(num);
        int[] dp=new int[numString.length()];
        dp[0]=1;
        if(numString.charAt(0)=='2'&&numString.charAt(1)<='5' || numString.charAt(0)=='1'){
            dp[1]=2;
        }else{
            dp[1]=1;
        }
        for(int i=2;i<numString.length();i++){
            if(numString.charAt(i-1)=='2'&&numString.charAt(i)<='5' || numString.charAt(i-1)=='1' ){
                dp[i]=dp[i-1]+dp[i-2];
            }
            else {
                dp[i]=dp[i-1];
            }
        }
        return dp[numString.length()-1];
    }
}
