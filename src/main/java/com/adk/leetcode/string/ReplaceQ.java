package com.adk.leetcode.string;

import java.util.Random;

public class ReplaceQ {
    public String modifyString(String s) {
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            for (int c = 0; c < 3 && ch[i] == '?'; c++) {
                boolean ok = true;
                if (i - 1 >= 0 && ch[i - 1] == c + 'a') ok = false;
                if (i + 1 < ch.length && ch[i + 1] == c + 'a') ok = false;
                if (ok) ch[i] = (char)(c + 'a');
            }
        }
        return String.valueOf(ch);
    }
}
