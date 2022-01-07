package com.adk.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int pLength=p.length(),sLength=s.length();
        if(sLength<pLength){
            return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<>();
        int sCount[]=new int[26];
        int pCount[]=new int[26];
        for(int i=0;i<pLength;i++){
            ++pCount[p.charAt(i)-'a'];
        }
        //计算待匹配字符串中的字母数

        for(int i=0,j=pLength-1;j<sLength;i++,j++){
            for(int k=i;k<j+1;k++){
                ++sCount[s.charAt(k)-'a'];
            }
            if (Arrays.equals(sCount,pCount)){
                ans.add(i);
            }
            for(int k=i;k<j+1;k++){
                --sCount[s.charAt(k)-'a'];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        findAnagrams.findAnagrams("cbaebabacd"
                ,"abc");

    }
}
