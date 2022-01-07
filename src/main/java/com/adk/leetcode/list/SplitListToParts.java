package com.adk.leetcode.list;

import com.adk.leetcode.node.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 *
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 *
 * 返回一个由上述 k 部分组成的数组。
 *
 *  
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * 输出：[[1,2,3,4],[5,6,7],[8,9,10]]
 * 解释：
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
 *
 */
public class SplitListToParts {
    List<ListNode> res =new LinkedList<>();
    int cnt=0;
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode fast=head,slow=head;
        if(k==1) {
            res.add(head);
            return res.toArray(new ListNode[res.size()]);
        }
        int nullNum=0;
        int totalNum=0;
        int maxLength=0;
        int runtime=0;
        while (fast!=null){
            cnt++;
            fast=fast.next;
        }
        if(cnt<k){//如果链表长度小于要分割的次数
            totalNum=1;//每个链表默认的长度
            nullNum=k-cnt;//为空的链表数量为 cnt%k
            maxLength=totalNum;
            runtime=(cnt/totalNum)+nullNum;//一共要运行的次数
        }else {
            totalNum=cnt/k;//长度足够 比如链表长度5 分割4 5/4=1 每个链表长度为1
            nullNum=cnt%k;//多出的长度
            maxLength=totalNum+nullNum;//最长链表长度 最长那个长度加在第一个链表中
            runtime=k;//一共要运行的次数
        }
        for(int i=0;i<runtime;i++){
            ListNode headNew=slow;//新指针
            ListNode headFirst=headNew;//准备一个头指针 用于放入list
            for(int j=0;i==0?j<maxLength:j<totalNum;j++){//i==0?说明是第一个链表 需要最长 最长的话 需要执行maxlength 次
                if(slow==null) break;
                headNew=slow;//新指针遍历的指向下一个slow
                slow=slow.next;//slow指向下一个
            }
            if(slow==null){
                res.add(headFirst);
            }else{
                headNew.next=null;
                res.add(headFirst);
            }
        }
        return res.toArray(new ListNode[res.size()]);
    }
}
