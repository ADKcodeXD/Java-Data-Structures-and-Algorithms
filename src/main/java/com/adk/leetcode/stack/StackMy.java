package com.adk.leetcode.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackMy {
    Deque<Integer> stack=new LinkedList<>();
    int size=0;
    int top=-1;
    public int pop(){
        if(size<=0){
            return -1;
        }
        size--;
        top=size==0?-1:stack.peek();
        return stack.pop();
    }
    public void push(int a){
        stack.push(a);
        size++;
        top=a;
    }
    public int top(){
        return top;
    }

}
