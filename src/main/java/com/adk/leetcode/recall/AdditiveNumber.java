package com.adk.leetcode.recall;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        return dfs(num,0,0,0,0);
    }
    public boolean dfs(String num ,int index, int count ,int prevprev,int prev){
        if(index>=num.length()){
            return count>2;
            //乳沟count>2 ->== 3说明 前面三数字可以凑成 单纯这里只是处理数组越界的情况。
        }
        int current=0;
        for(int i=index;i<num.length();i++){
            char c = num.charAt(i);
            if(i>index&&num.charAt(index)=='0'){
                return false;
                //也就是 第一位是0  后面的就不能用
            }
            current=current*10+c-'0';
            if(count>=2){
                long sum = prevprev + prev;
                if(current > sum ){
                    return false;
                }else if(sum< current ) {
                    continue;//下一轮继续加
                }
            }
            if(dfs(num,i+1,count+1,prev,current)){
                return true;
            }
        }
        return false;
    }
}
