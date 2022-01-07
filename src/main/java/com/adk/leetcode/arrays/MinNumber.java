package com.adk.leetcode.arrays;

public class MinNumber {
    public String minNumber(int[] nums) {
        String res="";
        for(int num:nums){
            if(num>9){
                int temp= (int) (num/Math.log10(num));
            }

        }
        return "hello";
    }

}
