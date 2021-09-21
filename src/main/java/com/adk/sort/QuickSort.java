package com.adk.sort;

import com.adk.util.CreateNums;

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

//        for (int num : nums) {
//            System.out.print(num+" ");
//
//        }
//        System.out.print("\n");

        quickSort(startIndex, left - 1, nums);
        quickSort(left + 1, endIndex, nums);
    }

    public static void main(String[] args) {
        int[] nums= CreateNums.CreateList(100000,1,100000);
        long nanoTime = System.currentTimeMillis();
        new QuickSort().quickSort(0,99999,nums);

        System.out.println((System.currentTimeMillis()-nanoTime));
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
