package com.adk.leetcode.recall;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    List<String> res = new LinkedList<>();
    char [] c;
    public String[] permutation(String s) {
        c= s.toCharArray();
        backtrack(0);
        return res.toArray(new String[res.size()]);
    }
    public void backtrack(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        //每一层回溯都有一个set 判断当前的重复项
        HashSet<Character> set=new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);// 交换，将 c[i] 固定在第 x 位 a b c  一开始不需要交换 但是传入的i+1后 b 和 c就要进行交换（交换之后变为a c b）
            backtrack(x + 1);// 开启固定第 x + 1 位字符
            swap(i, x);// 恢复交换
        }
    }
    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
