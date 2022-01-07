package com.adk.leetcode.string;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[-1].length();
    }
}
