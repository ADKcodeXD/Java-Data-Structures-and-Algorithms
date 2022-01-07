package com.adk.leetcode.string;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if(char1[i-1]==char2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int cnt=dp[word1.length()][word2.length()];
        return word1.length()-cnt+word2.length()-cnt;
    }
}
