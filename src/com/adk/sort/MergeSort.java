package com.adk.sort;

import com.adk.util.CreateNums;
import com.adk.util.Util;

/**
 * 归并排序 是一种十分高效的排序算法
 * 时间复杂度为O(nlogn)
 * 采用的分治的思想，将数组不断分为小的数组，
 * 分而治之 最后进行合并来达到目的
 * 是稳定的排序方法。
 */
public class MergeSort {
    public void mergeSort(int[] nums,int[] temp,int startIndex,int endIndex) {
        int center;
        if(startIndex<endIndex){
            center=(startIndex+endIndex)/2;
            mergeSort(nums,temp,startIndex,center);
            mergeSort(nums,temp,center+1,endIndex);
            merge(nums,startIndex,endIndex,center,temp);
        }
    }
    public void merge(int[] nums,int startIndex,int endIndex,int center,int[] temp){
        int leftStart=startIndex;
        int rightStart=center+1;
        int tempStart=0;
        while(leftStart<=center&&rightStart<=endIndex){
            if(nums[leftStart]<nums[rightStart]){
                temp[tempStart++]=nums[leftStart++];
            }else {
                temp[tempStart++]=nums[rightStart++];
            }
        }
        //出来后 其中一段的数组已经排序完毕，还剩一段数组都是大于已经排好序的数组，直接赋值进去即可
        while(leftStart<=center){
            temp[tempStart++]=nums[leftStart++];
        }
        while(rightStart<=endIndex){
            temp[tempStart++]=nums[rightStart++];
        }
        //归并完成后，temp数组已经排序完成 置tempstart为0将其复制到nums数组中去
        tempStart=0;
        while (startIndex<=endIndex){
            nums[startIndex++]=temp[tempStart++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ints = CreateNums.CreateList(30000, 1, 50000);
        int[] temp = new int[ints.length];
        long l = Util.printNums(ints);
        mergeSort.mergeSort(ints,temp,0,ints.length-1);
        long l1 = Util.printNums(ints);
        System.out.println(l1-l);
    }
}
