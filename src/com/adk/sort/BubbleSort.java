package com.adk.sort;

public class BubbleSort {
    public void bubbleSort(int [] nums ){
        if (nums==null||nums.length<2){
            return;
        }
        int temp;
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length-1-i;j++){
                if (nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] news={89,45,100,12,5,6,17,88,9,0,21};
        new BubbleSort().bubbleSort(news);
        for (int i : news) {
            System.out.print(i+" ");
        }
    }
}
