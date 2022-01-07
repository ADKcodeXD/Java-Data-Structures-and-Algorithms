package com.adk.leetcode.string;

/**
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 * 示例 2：
 *
 * 输入：S = "2-5g-3-J", K = 2
 * 输出："2-5G-3J"
 * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 *
 */
public class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String s, int k) {

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder temp=new StringBuilder();
        String replaceAfter = s.replace("-", "");
        if(replaceAfter.length()<=k){
            return replaceAfter.toUpperCase();
        }
        replaceAfter=replaceAfter.toUpperCase();
        int countFirst=replaceAfter.length()%k;
        char[] chars = replaceAfter.toCharArray();
        if(countFirst!=0){
            for(int i=0;i<countFirst;i++){
                temp.append(chars[i]);
            }
            stringBuilder.append(temp);
            stringBuilder.append("-");
            temp=new StringBuilder();
        }
        for(int i=countFirst;i<chars.length;i++){
            if(temp.length()==k){
                stringBuilder.append(temp);
                stringBuilder.append("-");
                temp=new StringBuilder();
            }
            temp.append(chars[i]);
        }
        if (temp.length()!=0){
            stringBuilder.append(temp.toString().toUpperCase());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = licenseKeyFormatting("2313sda-ioj-nwoiqroq-sndfjklanf-nf-fs-xx-s-a-q", 3);
        System.out.println(s);
    }
}
