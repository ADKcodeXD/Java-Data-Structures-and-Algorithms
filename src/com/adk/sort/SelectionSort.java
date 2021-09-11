package com.adk.sort;

import com.adk.util.CreateNums;

/**
 * 选择排序，每次遍历选出一个最小的数值，将他与第一个未排序过的位置交换
 * 时间复杂度O(n^2) 不稳定
 */
public class SelectionSort {
    public void selectionSort(int []nums){
        if (nums==null||nums.length<2){
            return;
        }
        int temp=0;
        int index=0;
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            index=i;
            for(int j=i;j<nums.length;j++){
                if (temp>nums[j]){
                    temp=nums[j];
                    index=j;
                }
            }
            temp=nums[i];
            nums[i]=nums[index];
            nums[index]=temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = CreateNums.CreateList(30, 1, 100);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(ints);
        System.out.println("\n");
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
