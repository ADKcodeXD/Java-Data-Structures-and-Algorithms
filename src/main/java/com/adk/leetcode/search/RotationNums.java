package com.adk.leetcode.search;

public class RotationNums {
    public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        if(nums.length==1)return nums[0]==target?0:-1;
        int start=0;
        int end=nums.length-1;
        int mid;
        //由于不知道旋转了几次，所以 不能确定到底在哪去找。
        while(start<=end){
            mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            // 只有两种情况 一种是mid大于nums[0]
            // 另一种是小于nums[0]
            if(nums[mid]>= nums[0]){
                if(nums[mid] > target && target >= nums[0]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(nums[mid] < target &&  nums[nums.length-1] >= target){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RotationNums rotationNums = new RotationNums();
        int []a={5,1,3};

        rotationNums.search(a,5);

    }
}
