package com.adk.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class FindLongestWord {
    public static String findLongestWord(String s, List<String> dictionary) {
        int length=s.length();
        int listLength=dictionary.size();
        int maxLength=0;
        List<String> strings=new ArrayList<>();
        for(int i=0;i<listLength;i++){
            String dictItem=dictionary.get(i);
            int dictlength=dictItem.length();
            if(dictlength<maxLength) continue;
            int k=0;
            for(int j=0; j<length&&k<dictlength;j++){
                if(s.charAt(j)==dictItem.charAt(k)){
                    k++;
                }
            }
            if (k!=dictItem.length()){
                continue;
            }else if(k>=maxLength){
                maxLength=k;
                strings.add(dictItem);
            }
        }
        String res="";
        for (String string : strings) {
            if(string.length()==maxLength){
                if(res.equals("")) res=string;
                else {
                    if (string.compareTo(res)<0){
                        res=string;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("ale");
        objects.add("apple");
        objects.add("monkey");
        objects.add("plea");
        System.out.println(findLongestWord("abpcplea", objects));
    }
}
