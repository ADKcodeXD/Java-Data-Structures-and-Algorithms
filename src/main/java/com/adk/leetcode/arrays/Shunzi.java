package com.adk.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Shunzi {
    public boolean  isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int[] map=new int[hand.length];
        boolean flag=false;
        if(hand.length%groupSize==0){
            for(int i=0;i<hand.length-1;i++){
                if(map[i]==1) continue;
                map[i]++;
                int num=hand[i];
                int size=1;
                for(int j=i+1;j<hand.length;j++){
                    if(map[j]==1) continue;
                    flag=true;
                    if(hand[j]==num+1&&size<groupSize-1){
                        map[j]++;
                        size++;
                        num=hand[j];
                    }else if(hand[j]==num+1 && size==groupSize-1){
                        map[j]++;
                        size++;
                        break;
                    }
                }
                if(size!=groupSize) flag=false;
                if(!flag) break;
            }
        }else {
            return false;
        }
        return flag;
    }

    public static void main(String[] args) {
        Shunzi shunzi = new Shunzi();
        int []a={1,2,3,4,5,7};
        shunzi.isNStraightHand(a,2);
    }
}
