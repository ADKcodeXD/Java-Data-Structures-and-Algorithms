package com.adk.test;

import com.adk.leetcode.arrays.MaxArea;
import com.adk.leetcode.arrays.Search;
import com.adk.leetcode.dp.*;
import com.adk.leetcode.list.IsListNodePalindrome;
import com.adk.leetcode.list.SplitListToParts;
import com.adk.leetcode.node.ListNode;
import com.adk.leetcode.queue.OpenLock;
import com.adk.leetcode.recall.CombinationSum;
import com.adk.leetcode.recall.Permutation;
import com.adk.leetcode.search.SearchRange;
import com.adk.leetcode.stack.IsValid;
import com.adk.leetcode.stack.ValidateStackSequences;
import com.adk.leetcode.string.MinDistance;
import com.adk.leetcode.string.Word;
import com.adk.leetcode.tree.FindkBig;
import com.adk.leetcode.tree.Pathsum;
import com.adk.tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestClass {

    @Test
    public void test1(){
        int [] a={1,2,4,3};
        MaxArea.maxArea(a);
    }
    @Test
    public void test2(){
        int [] a={1,2,4,3,5};
        TotalOfLis.findNumberOfLIS(a);
    }
    @Test
    public void test3(){
        int [] a={-2,1};
        MaxSubArray.maxSubArray(a);
    }
    @Test
    public void test4(){
        int[] a={1,2,3,99,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        CanJumpII.jump(a);
    }
    @Test
    public void test231(){
        int[] a={2,3,5};
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(a,8);
    }
    @Test
    public void testTree(){
        TreeNode node6 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(7, null ,null );
        TreeNode node1 = new TreeNode(4, node3, node6);
        TreeNode node2 = new TreeNode(2, node5 ,node4);
        TreeNode root = new TreeNode(1, node1, node2);
        Pathsum pathsum = new Pathsum();
        pathsum.pathSum(root, 7);
    }
    @Test
    public void testTree2(){
        TreeNode node6 = new TreeNode(2, null, null);
        TreeNode node5 = new TreeNode(4, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(7, null ,null );
        TreeNode node1 = new TreeNode(1, null, node6);
        TreeNode node2 = new TreeNode(4, null ,null);
        TreeNode root = new TreeNode(3, node1, node2);
        FindkBig findkBig = new FindkBig();
        findkBig.kthLargest(root,1);

    }
    @Test
    public void testMaxsub(){
        int[] a={0,1};
        int[] b={-1,0,1};
        int[] c={0};
        int[] d={-1,-1,-2,-3,-4};
        int[] e={21578794,7897,-1,0};
        MaxProduct.maxProduct(a);
        MaxProduct.maxProduct(b);
        MaxProduct.maxProduct(c);
        MaxProduct.maxProduct(d);
        MaxProduct.maxProduct(e);
    }
    @Test
    public void teststring(){
        Permutation permutation = new Permutation();
        permutation.permutation("abc");
    }

    @Test
    public void testlist(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=null;
        l6.next=null;
        SplitListToParts splitListToParts = new SplitListToParts();
        splitListToParts.splitListToParts(l1,3);

    }
    @Test
    public void teststring222(){
        Search search = new Search();
        int [] a={-99999,-99998,-9999,-999,-99,-9,-1};
        search.search(a,8);
    }

    @Test
    public void  testr121232(){
        int [] a={1,2,3,0,2};
        MaxProfitIII maxProfitIII = new MaxProfitIII();
        maxProfitIII.maxProfit(a);
    }

    @Test
    public void test222(){
        OpenLock openLock = new OpenLock();
        String [] s=new String[5];
        s[0]="0201";
        s[1]="0101";
        s[2]="0102";
        s[3]="1212";
        s[4]="2002";
        openLock.openLock(s,"0202");

    }
    @Test
    public void  testr12122232(){
        String s="leetcode";
        List<String> wordDict =new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        Word word = new Word();
        word.wordBreak(s,wordDict);
    }

    @Test
    public void Stringmin(){
        String asds="sea";
        String asd2s="eat";
        MinDistance minDistance = new MinDistance();
        minDistance.minDistance(asds,asd2s);

    }
    @Test
    public void helloworld(){
        int[] a={5,7,7,8,8,10};
        SearchRange.searchRange(a, 8);
    }

}
