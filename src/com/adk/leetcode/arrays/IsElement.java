package com.adk.leetcode.arrays;

public class IsElement {
    public static int removeElement(int[] nums, int val) {
        int left=0;
        int right=nums.length-1;
        int count=nums.length;
        if((left==right)&&nums[left]!=val){
            return 1;
        }
        while(left<right){
            while(nums[left]!=val && left<right){
                left++;

            }
            while(nums[right]==val && left<right){
                count--;
                right--;
            }
            if(nums[left]!=nums[right]){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []nums={1,0,1,0,1,0,1,0,1,0};
        int []nums2={0,1,2,2,3,0,4,2};
        IsElement.removeElement(nums,1);
        IsElement.removeElement(nums2,2);
    }
}
