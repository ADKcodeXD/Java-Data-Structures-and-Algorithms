package com.adk.leetcode.math;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 */
public class Yearofdays {
    public int dayOfYear(String date) {
        String[] split = date.split("-");
        int [] months={31,28,31,30,31,30,31,31,30,31,30,31};
        int year=Integer.valueOf(split[0]);
        int month=Integer.valueOf(split[1]);
        int days=Integer.valueOf(split[2]);
        int total=0;
        if((year%4==0 && year%100!=0 ) || year%400==0 ){
            months[1]+=1;
        }
        if(month<2){
            total=days;
        }else{
            for (int i=0;i<month-1;i++)
                total+=months[i];
            total+=days;
        }
        return total;
    }
}
