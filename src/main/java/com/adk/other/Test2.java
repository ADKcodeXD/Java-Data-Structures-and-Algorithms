package com.adk.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test2 {
    public static String reformat (String s) {
        if(s.length()==0) return "";
        if(s.length()%2!=0) return "";
        List<Character> numList=new ArrayList<>();
        List<Character> charList=new ArrayList<>();
        char[] char1 = s.toCharArray();
        for (char a:char1){
            if(a>='0'&&a<='9'){
                numList.add(a);
            }else {
                charList.add(a);
            }
        }
        if(numList.size()!=charList.size()){
            return "";
        }else {
            for(int i=0,j=0;i<char1.length;i++){
                if(i%2==0){
                    char1[i]=numList.get(j);
                }else {
                    char1[i]=charList.get(j);
                    j++;
                }
            }
        }
        return String.valueOf(char1);
    }
    public static String longestPrefix(String s) {
        Set<String> strings=new HashSet<>();
        for (int i=0;i<s.length();i++){
            strings.add(s.substring(0,i));
        }
        String prefix="";
        for (int i=s.length()-1;i>0;i--){
            String substring = s.substring(i, s.length());
            if(strings.contains(substring)){
                prefix=substring;
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(reformat("sahi42s254iok111"));
        String level = longestPrefix("ababab");
        System.out.println(level);
    }
}
