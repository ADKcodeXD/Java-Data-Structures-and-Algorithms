package com.adk.leetcode.arrays;

import java.util.HashMap;

public class Roma {
    public  static  int  RomanToInt(String m) {
        int[] values={1000,500,100,50,10,5,1};
        Character[] rom={'M','D','C','L','X','V','I'};
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<values.length;i++){
            map.put(rom[i],values[i]);
        }
        int max=0;
        for(int i=0;i<m.length();i++){
            if(i<m.length()-1&&map.get(m.charAt(i)) < map.get(m.charAt(i+1))){
                max-=map.get(m.charAt(i));
            }else {
                max+=map.get(m.charAt(i));
            }
        }
    return  max;

    }

    public static void main(String[] args) {
        RomanToInt("III");
    }
}
