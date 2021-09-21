package com.adk.util;

public class Util {
    public static long printNums(int[] nums){
        long l;
        System.out.println("=====元素个数:"+nums.length);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println("\n");
        l = System.currentTimeMillis();
        return l;
    }
}
