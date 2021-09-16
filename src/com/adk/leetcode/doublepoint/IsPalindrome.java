package com.adk.leetcode.doublepoint;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length()==0) return true;
        int left=0;
        int right=s.length()-1;
        while (left<right){
            while (left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }else {
                right--;left++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="dsaihnfiaslfd";
        boolean palindrome = new IsPalindrome().isPalindrome(s);
        System.out.println(palindrome);
    }
}
