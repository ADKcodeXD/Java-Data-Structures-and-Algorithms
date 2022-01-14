package com.adk.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class EscapePossible {
    int EDGE = (int)1e6, MAX = (int)1e5;
    long BASE = 131L;
    Set<Long> set = new HashSet<>();
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        for (int[] p : blocked) set.add(p[0] * BASE + p[1]);//计算哈希值 每一个点映射为一个唯一的哈希值
        int n=blocked.length;
        MAX=n*(n-1)/2;
        return check(source,target)&&check(target,source);
    }
    public boolean check(int [] s,int [] t){
        Set<Long> vis = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(s);//初始化队列
        vis.add(s[0]*BASE+s[1]);
        while( !queue.isEmpty() && vis.size()<=MAX){
            int[] position=queue.pollFirst();
            int x=position[0];int y=position[1];
            if(x==t[0]&&y==t[1]) return true;
            for(int[] di : dir) {
                int xDir=di[0]+x;int yDir=di[1]+y;
                if(xDir<0||xDir>=EDGE || yDir<0 || yDir>=EDGE) continue;
                long hash=xDir*BASE+yDir;
                if(set.contains(hash)) continue;//如果set里有这个hash值 说明当前坐标是障碍坐标
                if(vis.contains(hash)) continue;//如果vis里面有这个hash值 说明当前坐标已访问过
                queue.addLast(new int[]{xDir,yDir});
                vis.add(hash);
            }
        }
        return vis.size()>MAX;
    }


}
