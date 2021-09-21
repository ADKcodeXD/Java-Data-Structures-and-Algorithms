package com.adk.leetcode.search;

public class FindMinII {
    public static int minArray(int[] nums) {
        int left=0;int right=nums.length-1;
        int mid=left+(right-left)/2;
        int piviot=0;
        while(left<right){
            piviot=nums[mid];
            if(piviot>nums[right]){
                left=mid+1;
                mid=left+(right-left)/2;
            }else if(piviot<nums[right]){
                right=mid;
                mid=left+(right-left)/2;
            }else if(piviot==nums[right] && piviot<nums[left]) {
                right = mid;
                mid = left + (right - left) / 2;
            }else if(piviot==nums[right] && piviot>nums[left]) {
                break;
            }else {
                left++;
                right--;
                mid = left + (right - left) / 2;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[]a={1,1};
        int[]b={1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1};
        minArray(a);
        minArray(b);
    }
}
