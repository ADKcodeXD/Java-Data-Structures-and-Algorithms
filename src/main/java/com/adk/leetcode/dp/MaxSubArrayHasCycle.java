package com.adk.leetcode.dp;

public class MaxSubArrayHasCycle {
    public int maxSubarraySumCircular(int[] nums) {
        int sum=0;
        int max=nums[0];
        int min=nums[0];
        int truesum=0;

        for(int num:nums){
            if(sum>0){
                sum+=num;
            }else{
                sum=num;
            }
            max=Math.max(max,sum);
        }
        //这一段就是求最大子序和 如果子序中有负数 那就越加越小 除非下一个整数加上去更大 不然就一直等于前面的sum
        //求完之后就可以得出max的子序和（无环情况下）
        sum=0;
        for(int num:nums){
            if(sum < 0){
                sum += num;
            }else {
                sum = num;
            }
            min = Math.min(min,sum);
            truesum += num;
        }
        //这一段就是求最小子序和
        //为什么要求最小子序和呢？
        //因为如果最大子序和是从两边开始的话  那么子序和会只从两边开始  加到某一个为负数的时候停止
        //那这就说明 中间的都是负数  反正是没用到的数字  那么想要求最大子序和 就要用全部数字累加起来 减去中间根本没用到的负数或0

        // 特殊情况 全是负的
        if(truesum == min){
            return max;
        }
        return Math.max(truesum-min, max);
    }
}
