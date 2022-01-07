package com.adk.leetcode.arrays;

public class FindMedium {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        int [] mynums=new int[length];
        int i=0,j=0,k=0;
        for(;i<length&&j<nums1.length&&k<nums2.length;){
            if(nums1[j]<nums2[k]){
                mynums[i++]=nums1[j++];
            }else{
                mynums[i++]=nums2[k++];
            }
        }
        if(j==nums1.length) {
            while(i<length){
                mynums[i++]=nums2[k++];
            }
        }
        else{
            while(i<length){
                mynums[i++]=nums1[j++];
            }
        }
        double mid=0;
        if(length%2!=0) {
            mid=mynums[length/2];
        }
        else{
            mid=(double) (mynums[length/2]+ mynums[(length/2)-1])/2;
        }
        return mid;
    }

    public static void main(String[] args) {
        FindMedium findMedium = new FindMedium();
        int [] a={1,2,5,7,9};
        int [] b={3,6,10,12,15};
        findMedium.findMedianSortedArrays(a,b);
    }
}
