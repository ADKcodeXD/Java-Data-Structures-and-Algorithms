package com.adk.leetcode.string;

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 *  
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 *
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 *
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        if(needle.equals("")||haystack.equals(needle)){
            return 0;
        }
        if(needle.length()>haystack.length()||(haystack.equals("")&&!needle.equals(""))){
            return -1;
        }
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        boolean istrue=false;
        for (int i=0;i<chars1.length;i++){
            if(chars1[i]==chars2[0]){
                istrue=true;
                for (int j=i;j<chars1.length;j++){
                    for (int k=0;k<chars2.length;k++){
                        if (chars1[j]!=chars2[k]) {
                            istrue=false;
                            break;
                        }
                    }
                }
            }
            if(istrue){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr("mississippi","issipi");
    }
}
