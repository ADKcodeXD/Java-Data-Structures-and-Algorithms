package com.adk.leetcode.queue;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 *
 */
public class OpenLock {
    public String plusOne(String s,int j){
        char[] chars = s.toCharArray();
        if(chars[j]=='9') chars[j]='0';
        else chars[j]+=1;
        return new String(chars);
    }
    public String minusOne(String s,int j){
        char[] chars = s.toCharArray();
        if(chars[j]=='0') chars[j]='9';
        else chars[j]-=1;
        return new String(chars);
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        Set<String> deads = new HashSet<>();
        deads.addAll(Arrays.asList(deadends));
        int step=0;
        queue.offer("0000");
        visited.add("0000");
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                String now = queue.poll();
                if(deads.contains(now))
                    continue;//存在死亡列表中 溜
                if(now.equals(target))
                    return step;//找到密码 直接溜
                for(int j=0;j<4;j++){
                    String up = plusOne(now, j);
                    if(!visited.contains(up)){
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(now, j);
                    if(!visited.contains(down)){
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
