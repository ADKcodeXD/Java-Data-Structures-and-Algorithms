package com.adk.leetcode.dp;

import java.util.PriorityQueue;

public class EatApple {
    public static int eatenApples(int[] apples, int[] days) {
        /**
         * apples[i] 存放每天长多少个苹果
         * days[i]存放这些苹果啥时候过期
         * 新建一个数组， 存放容量，过了时间 就将这个苹果从数组中削除。
         * 当数组为空，所经历的循环轮数 ，即为我能吃的天数
         * 其实思路是对的：但是不太了解如何使用堆这个工具来进行解题
         */
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        //这里的(a,b)->a[0]-b[0] 指的是 一个匿名函数  按照数组的第一个元素进行排序
        //a-b代表小根堆 b-a 代表大根堆  因此每次重新插入 可食用日期最短（最快过期的苹果 总是在堆顶）
        //从而可以做一个循环的算法
        int length=apples.length,time=0,ans=0;
        while(time<length || !q.isEmpty()){
            //如果时间还没到days尽头（结束产生苹果的那一天） 而且这一天会产生苹果 那就入队(时间-1)
            if(time<length && apples[time]>0)
                q.add(new int[]{time+days[time]-1,apples[time]});
            //time+day[time]-1 代表最后可食用的日期
            while(!q.isEmpty()&&q.peek()[0]<time) q.poll();
            //过期了的堆顶元素抛弃
            //没过期的拿出来 吃掉一个 然后重新入队
            if(!q.isEmpty()){
                int[] temp=q.poll();
                if(--temp[1]>0&&temp[0]>time){
                    q.add(temp);
                }
                ans++;
            }
            time++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] a={1,2,3,5,2};
        int [] b={3,2,1,4,2};
        eatenApples(a,b);
    }
}
