package com.adk.leetcode.search;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer,Integer> map=new HashMap<>();
    Map<Integer,Integer> weight=new HashMap<>();
    int size=0;
    public LRUCache(int capacity) {
        this.size=capacity;
    }

    public int get(int key) {
        if(map.get(key)==null){
            return -1;
        }else {
            weight.put(key,weight.get(key)+1);
        }
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.size()>=size){

            map.remove(size);
        }
    }
}
