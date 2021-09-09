package com.adk.sort;

/**
 * 快速排序算法，以第一个数为基准，先从右边找到比基准数小的
 * 再从左边找到比基准数大的
 * 然后两个数字进行交换， 一直到left==right
 * 然后将0,left-1  left+1进行递归
 * left会和一开始的基准数(startindex)进行交换
 * 如果startindex>=endindex 说明已经递归完成 此时返回。
 */
public class QuickSort {
    public void quickSort(int startIndex,int endIndex,int []nums){
        if(startIndex>=endIndex){
            return;
        }

        int piviot=nums[startIndex];
        int left=startIndex;
        int right=endIndex;
        int temp;

        while (left<right){
            while(nums[right]>=piviot && left<right){
                right--;
            }
            while(nums[left]<=piviot && left<right){
                left++;
            }
            if(left<right){
                temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
            }
        }

        nums[startIndex]=nums[left];
        nums[left]=piviot;

        for (int num : nums) {
            System.out.print(num+" ");

        }
        System.out.print("\n");

        quickSort(startIndex, left - 1, nums);
        quickSort(left + 1, endIndex, nums);
    }

    public static void main(String[] args) {
        int[] nums={3,8,9,4,6,7,5,0,2,10,15};
        new QuickSort().quickSort(0,10,nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
