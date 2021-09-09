package com.adk.leetcode;

import java.util.Stack;

public class ReversePrint {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        stack.empty();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int size=stack.size();
        int[] res=new int[size];
        for (int i=0;i<size;i++){
            res[i]=stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
