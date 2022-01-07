package com.adk.leetcode.string;

public class ReverseStringWord {
    public static String reverseWords(String s) {
        String trim = s.trim();
        String[] wordList=trim.split(" ");
        StringBuilder a=new StringBuilder();
        for(int i=wordList.length-1;i>=0;i--){
            if(wordList[i].length()!=0){
                a.append(wordList[i]);
            }
            if(i!=0 && wordList[i].length()!=0) a.append(" ");
        }
        return a.toString();
    }

    public static void main(String[] args) {
        reverseWords("  hello world!  ");
    }
}
