package com.adk.leetcode.search;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid=left+(right-left)/2;
        while(left<right){
            if(nums[mid]>target){
                right=mid;
                mid=left+(right-left)/2;
            }
            else if(nums[mid]<target){
                left=mid+1;
                mid=left+(right-left)/2;
            }else {
                left=mid;
                right=mid;
            }
        }
        if(left==right && nums[left]==target){
            while(left>0&&nums[left-1]==target) left--;
            while(right<nums.length-1&&nums[right+1]==target) right++;
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }
}
