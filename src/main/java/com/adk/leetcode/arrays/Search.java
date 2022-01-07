package com.adk.leetcode.arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 */
public class Search {
    public int search(int[] nums, int target) {
        if(nums.length==1 && nums[0]==target) return 1;
        int left=0;int right=nums.length-1;
        int mid=left+(right-left)/2;
        int cnt=0;
        while(left<right){
            if(nums[mid]<target){
                left=mid+1;
                mid=left+(right-left)/2;
            }
            else if(nums[mid]>target){
                right=mid;
                mid=left+(right-left)/2;
            }
            else if(nums[mid]==target) {
                cnt++;
                break;
            }
        }
        if(left == right && nums[left]!=target){
            return 0;
        }else if(left == right && nums[left]==target){
            cnt++;
        }

        for(int i=mid+1; i<=right ;i++){
            if(nums[i]==target){
                cnt++;
            }else break;
        }

        for(int i=mid-1; i>=left ;i--){
            if(nums[i]==target){
                cnt++;
            }else break;
        }

        return cnt;
    }
}
