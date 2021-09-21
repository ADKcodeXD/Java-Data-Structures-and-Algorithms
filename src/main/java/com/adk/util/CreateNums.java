package com.adk.util;

import java.util.Random;

public class CreateNums {
    public static int [] CreateList(int total,int min ,int max){
        int[] array=new int[total];
        for (int i=0;i<total;i++) {
            array[i]= (int)(Math.random()*(max-min)+min);
        }
        return array;
    }
}
