package com.adk.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class Yanghui {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> total=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }
                else {
                    row.add(total.get(i-1).get(j-1)+total.get(i-1).get(j));
                }
            }
            total.add(row);
        }
        return total;
    }
}
