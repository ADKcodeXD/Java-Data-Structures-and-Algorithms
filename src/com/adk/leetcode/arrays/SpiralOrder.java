package com.adk.leetcode.arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class SpiralOrder {
    /**
     * 思路在于如何设计 边界情况
     * 抄的  首先top bottom left right 为当前的最边界
     * 走到边界时 就要进行方向的转换 默认从0开始
     * 而且在left<=right 、 top>=bottom 时一直进行
     * 每一轮循环都做一次判断 并且顺便做一次变量的自增 （++top） 这个思路很巧妙 在判断的同时将变量也进行了自增。
     * @param matrix
     * @return
     */
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while(true) {
            for(int i = left; i <= right; i++) res[x++] = matrix[top][i]; // left to right.
            if(++top > bottom) break;//判断++后的top是否大于bottom
            for(int i = top; i <= bottom; i++) res[x++] = matrix[i][right]; // top to bottom.
            if(left > --right) break;//做完一次right右边边界的循环后将边界值-- 并与left进行判断
            for(int i = right; i >= left; i--) res[x++] = matrix[bottom][i]; // right to left.
            if(top > --bottom) break;
            for(int i = bottom; i >= top; i--) res[x++] = matrix[i][left]; // bottom to top.
            if(++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mar={{1,2},{3,4}};
        spiralOrder(mar);
    }
}
