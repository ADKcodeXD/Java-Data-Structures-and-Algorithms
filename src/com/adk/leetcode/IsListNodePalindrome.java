package com.adk.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class IsListNodePalindrome {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack=new LinkedList<>();
        if(head==null) return true;
        ListNode head2=head;
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        while(head2!=stack.peek()&&head2.next!=null){
            if(head2.val!=stack.pop().val){
                return false;
            }else{
                head2=head2.next;
            }
        }
        return true;
    }
     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(3);
//        ListNode l5=new ListNode(2);
//        ListNode l6=new ListNode(1);
        l1.next=l2;
        l2.next=null;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        l6.next=null;
        IsListNodePalindrome isListNodePalindrome = new IsListNodePalindrome();
        isListNodePalindrome.isPalindrome(l1);

    }
}
