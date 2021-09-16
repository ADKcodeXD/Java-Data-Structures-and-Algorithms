package com.adk.leetcode.graph;

public class MatrixFindWord {
    public static boolean exist(char[][] board, String word) {
        if (word.length() <= 0) return true;
        else if (board.length == 0) return false;
        char[] words = word.toCharArray();
        int i=0,j=0;
        int row = board.length;
        int col = board[0].length;
        boolean res = false;
        for (i=0;i<row;i++){
            for (j=0;j<col;j++){
                if (dfs(board,i,j,words,0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, char[] words, int wordIndex) {
        if (i < 0 || j < 0 || i >= board.length || j >=board[0].length ) return false;
        if (board[i][j] != words[wordIndex] ) return false;//不等于当前字符 返回
        if (wordIndex ==words.length-1) return true;
        board[i][j]='\0';//表示该节点被探访过
        boolean res= (
                dfs(board, i - 1, j, words, wordIndex + 1) ||
                dfs(board, i + 1, j, words, wordIndex + 1) ||
                dfs(board, i, j - 1, words, wordIndex + 1) ||
                dfs(board, i, j + 1, words, wordIndex + 1));
        board[i][j]=words[wordIndex];//遍历回来后 把它变回原来的字符
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B'}, {'C', 'D'}};
        String word = "CDBA";
        System.out.println(exist(board, word));
    }
}
