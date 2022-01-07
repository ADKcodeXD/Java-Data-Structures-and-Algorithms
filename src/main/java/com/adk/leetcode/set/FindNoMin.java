package com.adk.leetcode.set;

import java.util.HashSet;
import java.util.Set;

public class FindNoMin {
    public static int findSmall(int [] arr){
        int min=1;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=0)continue;
            else {
                if (min==arr[i]){
                    do {
                        min++;
                    }while (set.contains(min));
                }else set.add(arr[i]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] a={-1,2,-3,4,1};
        System.out.println(findSmall(a));
    }
}
