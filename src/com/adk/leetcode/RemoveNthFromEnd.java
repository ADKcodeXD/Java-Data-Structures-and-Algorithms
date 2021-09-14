package com.adk.leetcode;

import com.adk.leetcode.node.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 */
public class RemoveNthFromEnd {
    /**
     * 使用快慢指针 需要注意倒数最后一个和第一个的情况
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head,fast=head;
        if(head.next==null) return null;//一个元素的情况
        if(n==1){
            //倒数第一个元素
            while (fast.next!=null){
                slow=fast;
                fast=fast.next;
            }
            slow.next=null;
            return head;
        }
        for(int i=1;i<=n&&fast!=null;i++){
            fast=fast.next;
        }
        if(fast==null) {
            head=head.next;
            return head;
        }else {
            while (fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
        }
        return head;
    }
}
