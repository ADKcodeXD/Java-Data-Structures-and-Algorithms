package com.adk.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MaxDepth {
    Deque<Character> stack =new LinkedList<>();
    public int maxDepth(String s) {
        int max=0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c=='(') {
                stack.push(c);
                if(stack.size()>max) max=stack.size();
            }
            else if(c==')'){
                if(!stack.isEmpty())stack.pop();
            }
        }
        return max;
    }
}
