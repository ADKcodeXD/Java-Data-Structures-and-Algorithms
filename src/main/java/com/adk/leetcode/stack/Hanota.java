package com.adk.leetcode.stack;

import java.util.LinkedList;
import java.util.List;

public class Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota2(A,B,C,A.size());
    }
    public void hanota2(List<Integer> A, List<Integer> B, List<Integer> C,int n) {
        if(n==1){
            C.add(A.remove(A.size()-1));
        }else {
            hanota2(A,C,B,n-1);
            hanota2(A,B,C,1);
            hanota2(B,A,C,n-1);
        }
    }
}
