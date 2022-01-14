package com.adk.leetcode.dp;

public class LongestSub {
    public String longestPalindrome(String s) {
        int size=s.length();
        if(s.length()<2) return s;
        boolean[][] dp=new boolean[size][size];
        for(int i=0;i<size;i++) dp[i][i]=true;
        char[] schar = s.toCharArray();
        int maxlen=0;int begin=0;
        for(int j=1;j<size;j++){
            for(int i=0;i<j;i++){
                if(schar[i]!=schar[j]){
                    dp[i][j]=false;
                }else {
                    if(j-i+1 <3){
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }

                if(dp[i][j]&&(j-i+1)>maxlen){
                    maxlen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
