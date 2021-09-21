package com.adk.leetcode.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class IsValid {
    public static  boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(map.get(aChar) == null && stack.isEmpty()) return false;//栈为空 前括号未入栈  不可能有后括号
            if(stack.isEmpty()) {
                stack.push(aChar);//栈为空 入一个栈 进下一个循环
                continue;
            }
            if(map.get(aChar) != null){ //说明是前括号 直接入栈
                stack.push(aChar);
            }
            else if(map.get(stack.peek()).equals(aChar)){
                stack.pop();//如果当前字符和之前的入栈的前括号的map相匹配 说明是一对 直接出栈
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
