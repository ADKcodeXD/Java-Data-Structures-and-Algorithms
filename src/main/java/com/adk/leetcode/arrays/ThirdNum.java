package com.adk.leetcode.arrays;

public class ThirdNum {
    public static int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>third){
                if(nums[i]<second){
                    third=nums[i];
                }else if(nums[i]>second){
                    if(nums[i]<first){
                        third=second;
                        second=nums[i];
                    }else if(nums[i]>first){
                        third=second;
                        second=first;
                        first=nums[i];
                    }
                }
            }
        }
        if(first==Long.MIN_VALUE) return 0;
        if(third==Long.MIN_VALUE){
            third=first;
        }
        return (int) third;
    }

    public static void main(String[] args) {
        int[] a={1,2,-2147483648};
        thirdMax(a);
    }
}
