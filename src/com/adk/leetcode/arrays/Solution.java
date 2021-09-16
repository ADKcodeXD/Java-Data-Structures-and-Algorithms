package com.adk.leetcode.arrays;

class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String sb=countAndSay(n-1);
        char temp=sb.charAt(0);
        int count=0;
        String wb="";
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!=temp){
                wb+=String.valueOf(count);
                wb+=temp;
                temp=sb.charAt(i);
                count=1;
                continue;
            }
            count++;
        }
        wb+=count;
        wb+=temp;
        return wb;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(5);
        System.out.println(s);
    }
}