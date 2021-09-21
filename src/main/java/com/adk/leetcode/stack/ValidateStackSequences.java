package com.adk.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 */
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(popped.length==0&&pushed.length==0) return true;//直接返回 都是0
        if(popped.length!=pushed.length || popped.length==0 || pushed.length==0) return false;//一些边界情况返回false
        Deque<Integer> stack=new LinkedList<>();
        stack.add(pushed[0]);//先进一个
        int point=0;
        int k=1;
        while(point<popped.length){
            if(stack.isEmpty()){
                stack.push(pushed[k]);
                k++;//防止一些空栈的情况 且没入完栈
            }
            if( stack.peek().equals(popped[point]) ){
                stack.pop();
                point++;
            }else{
                if(k>=pushed.length) break;
                stack.push(pushed[k]);
                k++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int[] b={5,4,3,2,1};
        System.out.println(validateStackSequences(a, b));
    }
}
