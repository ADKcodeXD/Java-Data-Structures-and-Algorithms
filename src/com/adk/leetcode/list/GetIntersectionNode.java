package com.adk.leetcode.list;

import com.adk.leetcode.node.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 *
 *
 *
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 *  
 *
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA,p2=headB;
        int cnt=0;
        while(p1!=null&p2!=null){
            if(p1==p2){
                return p1;
            }
            p1=p1.next;
            p2=p2.next;
            //如果走完了  没返回 说明不是等长的链表
            if(cnt<2 && p1==null){
                p1=headB;//走一遍B开头的链
                cnt++;
            }
            if(cnt<2 && p2==null){
                p2=headA;//走一遍A开头的链
                cnt++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        ListNode h6 = new ListNode(6);
        ListNode h7 = new ListNode(7);
        h1.next=h2;
        h2.next=h3;
        h3.next=h4;
        h5.next=h6;
        h6.next=h7;
        h7.next=h3;
        new GetIntersectionNode().getIntersectionNode(h1,h5);
    }
}
