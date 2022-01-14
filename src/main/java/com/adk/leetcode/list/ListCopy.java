package com.adk.leetcode.list;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class ListCopy {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node p=head;
        Map<Integer,Node> map=new HashMap<>();
        while(p!=null){
            Node node = new Node(p.val);
            map.put(node.val,node);
            p=p.next;
        }
        p=head;
        while(p!=null){
            Node node = map.get(p.val);
            node.next=p.next;
            node.random=p.random;
            p=p.next;
        }
        return map.get(head.val);
    }
}
