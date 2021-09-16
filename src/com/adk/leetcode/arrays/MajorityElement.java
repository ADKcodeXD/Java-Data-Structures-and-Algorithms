package com.adk.leetcode.arrays;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 */
public class MajorityElement {
    /**
     * 自己实现的方法，使用哈希表
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])!=null){
                Integer integer = map.get(nums[i])+1;
                if(integer>nums.length/2){
                    return nums[i];
                }
                map.put(nums[i],integer);
            }else {
                map.put(nums[i],1);
            }
        }
        return nums[0];
    }
    public int majorityElement2(int[] nums) {
        if (nums.length==1)return nums[0];
        int count=1;
        int maxCountNum=nums[0];
        for (int i=1;i<nums.length;i++){
            if (count==0){
                count++;
                maxCountNum=nums[i];
            }
            if (nums[i]==maxCountNum){
                count++;
            }else {
                count--;
            }
        }
        return maxCountNum;
    }
    public static void main(String[] args) {
        int[] nums={3,2,3};
        int i = new MajorityElement().majorityElement(nums);
    }
}
