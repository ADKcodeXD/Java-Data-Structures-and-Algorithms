package com.adk.leetcode.list;

import com.adk.leetcode.node.ListNode;

public class DeleteDouble {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=head,now=head;
        ListNode dummy=new ListNode(0,head);
        while(now.next!=null) {
            while (now.next!=null && now.val < now.next.val) {
                prev = now;
                now = now.next;
            }
            if(prev==now){
                //说明没动
                while(now.next!=null && now.val==now.next.val){
                    now=now.next;
                }
                if(now.next==null) return null;
                else {
                    now=now.next;
                    prev=now;
                    head=prev;
                }
            }else {
                boolean flag=true;
                while(now.next!=null ){
                    if( now.val==now.next.val){
                        now=now.next;
                        flag=false;
                    }else {
                        flag=true;
                        break;
                    }
                }
                if(now.next==null && flag) {
                    prev.next=now;
                    return head;
                }else if(now.next==null && !flag){
                    prev.next=null;
                    return head;
                } else{
                    now=now.next;
                    prev.next=now;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        ListNode x1 = new ListNode(2);
        ListNode x2 = new ListNode(2);
        ListNode x3 = new ListNode(2);
        ListNode x4 = new ListNode(2);
        x.next=x1;
        x1.next=x2;
        x2.next=x3;
        x3.next=x4;
        x4.next=null;
        DeleteDouble deleteDouble = new DeleteDouble();
        deleteDouble.deleteDuplicates(x);
    }
}
