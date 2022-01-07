package com.adk.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 */
public class ACGT {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        int length=10;
        if(s.length()<10){
            return list;
        }
        for(int i=0;i<s.length()-10;i++){
            String substring = s.substring(i, i + 10);
            if(!set.add(substring)){
                if(!list.contains(substring))
                    list.add(substring);
            }
        }
        return list;
    }
}
