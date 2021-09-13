package com.adk.leetcode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1;
        int col=matrix[0].length-1;
        if(target<matrix[0][0]||target>matrix[row][col]){
            return false;
        }else if(target==matrix[0][0]||target==matrix[row][col]){
            return true;
        }
        int index1=0;
        int index2=col;
        while (index1<=row && index2>=0){
            if(target>matrix[index1][index2]){
                index1++;
            }else if(target<matrix[index1][index2]){
                index2--;
            }else {
                return true;
            }
        }
        return false;
    }
}
