package com.adk.leetcode;

import java.util.LinkedList;

/**
 * 使用两个栈实现的队列
 * 入队先入到A栈中
 * 然后再移除栈顶到B栈中，这时候B栈相当于是正序
 * 出队移除B栈栈顶，此时完成一个队列的出队行为。
 * 如果 A队不为空，说明未完成转移，需要转移 A队为空，说明没有元素
 * B队不为空说明已完成转移 直接移除栈顶即可出队。
 *
 */
class Cqueue {
    private LinkedList<Integer> A,B;
    public Cqueue() {
        A=new LinkedList<>();
        B=new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while (!A.isEmpty()){
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}

