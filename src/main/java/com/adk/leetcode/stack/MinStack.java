package com.adk.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 */
public class MinStack {
    /** initialize your data structure here. */

    Deque<Integer> A;
    Deque<Integer> B;

    /**
     * 思路 只要保证B栈的元素是A栈元素中最小的元素就行了
     * 也即当B.peek>= input(x)
     * 即推进b
     */
    public MinStack() {
        A=new LinkedList<>();
        B=new LinkedList<>();
    }

    public void push(int x) {
        A.push(x);
        if(B.isEmpty()||B.peek()>=x)
            B.push(x);

    }

    public void pop() {
        if(A.isEmpty()) return;

        if(A.poll().equals(B.peek())){
            B.poll();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
