package com.adk.sort;

import com.adk.util.CreateNums;
import com.adk.util.Util;

/**
 * 插入排序 时间复杂度 O(n^2)
 * 将待排序的数字插入到有序的数组中，如未排序的数字比有序数组的小则一直往前移动
 * 具体做法就是将排好序的下一个数字 和前一个进行比对
 * 如果比前面的小 则与前面的数字进行交换
 * 如果是逆序的数组则达到最坏的时间复杂度N^2
 */
public class InsertionSort {
    public void insertionSort(int[] nums){
        int temp=0;
        for (int i=1;i<nums.length;i++){
            int j=i;
            while(j>0 && nums[j]<nums[j-1]){
                temp=nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] createList = CreateNums.CreateList(10000, 1, 50000);
        long l = Util.printNums(createList);
        new InsertionSort().insertionSort(createList);
        long l1 = Util.printNums(createList);
        System.out.println(l1-l);
    }
}
