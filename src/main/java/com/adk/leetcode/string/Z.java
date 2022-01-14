package com.adk.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class Z {
    public static String  convert(String s, int numRows) {
        List<List<Character>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            res.add(new ArrayList<>());
        }
        int j=0;
        boolean reverse = false;
        for(int i=0;i<s.length();i++){
            if(j==numRows-1) reverse=true;
            if(j==0) reverse=false;
            res.get(j).add(s.charAt(i));
            if(!reverse)j++;else j--;
        }
        String a="";
        for(int i=0;i<numRows;i++){
            StringBuilder builder = new StringBuilder(res.get(i).size());
            for (Character character : res.get(i)) {
                builder.append(character);
            }
            a+=builder.toString();
        }
        return a;
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING",3);
    }
}
