package com.adk.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinDifference {
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> newArray=new ArrayList<>();
        for(int i=0;i<timePoints.size();i++){
            String abc = timePoints.get(i);
            String[] split = abc.split(":");
            int hour = Integer.valueOf(split[0]);
            int min  = Integer.valueOf(split[1]);
            if(hour>23 || hour<0 || min >59 || min<0){
                continue;
            }
            int minTotal=0;
            minTotal=hour*60;
            minTotal+=min;
            newArray.add(minTotal);
        }
        Integer[] arr = newArray.toArray(new Integer[newArray.size()]);
        int[] arr2 = Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(arr2);
        int min=Integer.MAX_VALUE;
        for (int i=0;i<arr2.length-1;i++) {
            if(min>Math.abs(arr2[i+1]-arr2[i])){
                min=Math.abs(arr2[i+1]-arr2[i]);
            }
        }
        return Math.min(min,arr2[0]+1440-arr2[arr2.length-1]);
    }

    public static void main(String[] args) {
        List<String> strings=new ArrayList<>();
        strings.add("11:59");
        strings.add("13:13");

        findMinDifference(strings);
    }
}
