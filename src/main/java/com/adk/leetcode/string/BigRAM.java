package com.adk.leetcode.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BigRAM {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> str=new ArrayList<>();
        boolean a = false,b=false;
        for(int i=0;i<s.length;i++){
            if(a&&b) {
                str.add(s[i]);
                a=false;b=false;
            }
            if(s[i].equals(first)){
                a=true;
                continue;
            }
            if(a &&s[i].equals(second)){
                b=true;
            }else {
                a=false;
            }
        }
        return str.toArray(new String[str.size()]);
    }
}
