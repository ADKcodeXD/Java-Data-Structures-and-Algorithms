package com.adk.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack=new LinkedList<>();
        while(head.next!=null){
            stack.push(head);
            head=head.next;
        }
        while(!stack.isEmpty()){
            head.next=stack.pop();
            head=head.next;
        }
        head.next=null;
        return head;
    }
    class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
