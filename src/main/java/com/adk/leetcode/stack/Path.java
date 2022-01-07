package com.adk.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Path {
    Deque<String> stack=new LinkedList<>();
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        for(int i=0;i<split.length;i++){
            if(split[i].equals(".")||split[i].equals("")){
                continue;
            }
            if(split[i].equals("..")){
                if(stack.size()>=1) {
                    stack.pop();
                }
            }else {
                stack.push(split[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        sb.append("/");
        while(stack.size()>1){
            String s = stack.pollLast();
            sb.append(s);
            sb.append("/");
        }
        String s = stack.pollLast();
        sb.append(s);

        return sb.toString();
    }
}
