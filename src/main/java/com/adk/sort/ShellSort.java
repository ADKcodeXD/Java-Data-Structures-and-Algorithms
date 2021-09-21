package com.adk.sort;

import com.adk.util.CreateNums;
import com.adk.util.Util;

import java.util.ArrayList;

/**
 * 希尔排序 最差情况N^1.5  平均复杂度N^1.25 时间复杂度（在特定的增量序列下）
 * 首先先确定数组的初始间距，然后缩小间距再进行排序
 * 是基于插入排序的改良版本
 * 需要定义一个增量序列 增量序列是必须为互质的
 */
public class ShellSort {
    public void shellSort(int[] nums){
        int temp;
        //生成hibbard递增序列
        int[] hibbard = hibbardSequence(nums.length);
        for(int i=0;i<hibbard.length;i++){
            int gap=hibbard[i];
            //下面是普通的插入排序算法
            for(int k=gap;k<nums.length;k++){
                int j=k;
                while(j-gap>=0 && nums[j]<nums[j-gap]){
                    temp=nums[j];
                    nums[j]=nums[j-gap];
                    nums[j-gap]=temp;
                    j-=gap;
                }
            }
        }
    }

    /**
     * 生成相对应长度的hibbard增量序列
     * 返回一个数组，生成至某个长度则停止生成
     * Hibbard 增量序列的递推公式为：
     * h1=1,hi=2∗hi−1+1
     * @param length
     * @return
     */
    public int[] hibbardSequence(int length){
        int h1=1;int index=0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (h1<=length){
            arrayList.add(h1);
            h1=h1*2+1;
        }
        int[] ints = new int[arrayList.size()];
        for (int i=0,j=arrayList.size()-1;i<arrayList.size()&&j>=0;i++,j--){
            ints[i]=arrayList.get(j);
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = CreateNums.CreateList(1000, 1, 4500);
        ShellSort shellSort = new ShellSort();
        long l = Util.printNums(ints);
        shellSort.shellSort(ints);
        long l1 = Util.printNums(ints);
        System.out.println(l1-l);
    }
}
