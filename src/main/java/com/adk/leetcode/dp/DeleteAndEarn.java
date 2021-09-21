package com.adk.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 */
public class DeleteAndEarn {
    /**
     * 真是恶心这题
     * 意思就是 删掉3 那就把全部3删掉  3-1 和3+1 的元素也要删掉
     * 不过点数只加3的 2和4的不加上去
     * 也就是动态规划  删不删这个数
     * dp[i]=Max(dp[i-1],dp[i-2]+nums[i]*count(i))
     * 不删  就取dp[i-1]  删 就是i-2加上这个数的个数*点数  (i-1)的就不算在内了
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0){
            return 0;
        }if (nums.length==1){
            return nums[0];
        }
        int max=0;
        //这一步是为了获取 输入数组中的最大值 以确定新建的数组的大小
        for (int num : nums) {
            max=Math.max(max,num);
        }
        //确定了最大值后就可以开始构建新的数组了
        int[] newint=new int[max+1];
        //重复的就+1
        for (int num : nums) {
            newint[num]++;
        }
        //构建数组完成
        int[] dp=new int[max+1];
        dp[0]=newint[0]*0;
        dp[1]=newint[1]*1;
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+i*newint[i]);
        }
        return dp[max];
    }
}
