package com.adk.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

public class UnionFindSet {
    class UFS{
        private Map<Integer,Integer> father;
        private int numOfSet=0;
        public UFS(){
            father=new HashMap<>();
            numOfSet=0;
        }
        public int find(int x){
            int root = x;
            while(father.get(root) != null){
                root = father.get(root);
            }
            //路径压缩
            while(x != root){
                int original_father = father.get(x);
                father.put(x,root);
                x = original_father;
            }
            return root;
        }
        public void add(int x){
            if (!father.containsKey(x)) {
                father.put(x, null);
                numOfSet++;
            }
        }
        public void merge(int x,int y){
            int rootX=find(x);
            int rootY=find(y);

            if (rootX != rootY){
                father.put(rootX,rootY);
                numOfSet--;
            }
        }
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        public int getNumOfSet(){
            return numOfSet;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        UFS ufs=new UFS();
        for(int i=0;i<isConnected.length;i++){
            ufs.add(i);
            for(int j=0;j<i;j++){
                if(isConnected[i][j]==1){
                    ufs.merge(i,j);
                }
            }
        }
        return ufs.getNumOfSet();
    }
}
