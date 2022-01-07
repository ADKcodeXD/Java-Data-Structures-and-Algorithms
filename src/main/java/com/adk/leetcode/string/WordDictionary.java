package com.adk.leetcode.string;

import java.util.LinkedList;
import java.util.List;

public class WordDictionary {
    List<String> dict;
    public WordDictionary() {
        dict=new LinkedList<>();
    }

    public void addWord(String word) {
        dict.add(word);
    }

    public boolean search(String word) {
        boolean res=false;
        if(dict.size()!=0){
            for(int i=0;i<dict.size();i++){
                String temp=dict.get(i);
                if(temp.length()!=word.length()) continue;
                for(int j=0;j<word.length();j++){
                    if(word.charAt(j)=='.') continue;
                    if(word.charAt(j)!=temp.charAt(j)) {
                        res=false;
                        break;
                    }
                    if(j==word.length()-1) res=true;
                }
                if(!res) continue;
                else break;
            }
        }
        return res;
    }
}

