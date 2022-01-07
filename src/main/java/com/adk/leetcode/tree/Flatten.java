package com.adk.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *示例 2：
 *
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 *
 * 输入的多级列表如下图所示：
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 */
public class Flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        if(head==null) return null;
        Deque<Node> stack=new LinkedList<>();//堆栈 用于存放每一个分支点
        Node first=head;
        while(head.next!=null || head.child!=null){//只要有next和孩子就一直走
            if(head.child!=null){
                stack.push(head);
                head=head.child;//有孩子优先走孩子节点 并把分支点推进栈
            }else{
                head=head.next;//没孩子走到next的尽头
            }
        }
        while (!stack.isEmpty()){
            Node node=stack.pop();
            if(node.child==head && node.next!=null){//node指向的child是head 说明head右边没东西
                head.next=node.next;//把node右边的东西全部扔到head的右边
                node.next.prev=head;
                node.next=head;
                head.prev=node;
                node.child=null;
            }else if(node.next==null){//node自己右边没东西
                node.next=node.child;//那就node的next指向自己孩子 孩子指回来
                node.child.prev=node;
                node.child=null;
            }else{//正常情况
                head.next=node.next; //node右边的全部扔到head右边
                node.next.prev=head;
                node.next=node.child;
                node.child.prev=node;
                node.child=null;
            }
            //每一轮保证head是当前这层的最后一个节点
            while (head.next!=null){
                head=head.next;
            }
        }
        return first;
    }
}
