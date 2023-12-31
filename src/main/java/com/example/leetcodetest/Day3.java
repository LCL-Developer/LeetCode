package com.example.leetcodetest;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Description:
 * 345. 反转字符串中的元音字母
 * 151. 反转字符串中的单词
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2023/12/31
 */
public class Day3 {
    /**
     *  给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
     */
    public static String reverseVowels(String s) {
        char[] result=s.toCharArray();
        String condition="aeiouAEIOU";
        int slen = s.length();
        int pre =0;
        int after=slen-1;
        while(pre<after){
            while(pre<slen && condition.indexOf(result[pre])==-1){
                pre++;
            }
            while(after>0 && condition.indexOf(result[after])==-1){
                after--;
            }
            if(pre<after){
                char a=result[pre];
                result[pre]=result[after];
                result[after]=a;
                pre++;
                after--;
            }
        }
        return new String(result);
    }
    /**
     *  给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     */
/*    public static String reverseWords(String s) {
        //Api调用解决
        String[] s1 = s.split(" ");
        List<String> collect = Arrays.stream(s1).filter(a -> {
            return !a.isEmpty();
        }).collect(Collectors.toList());
        Collections.reverse(collect);
        String[] strings = collect.toArray(new String[collect.size()]);
        return String.join(" ",strings);
//       return  Arrays.stream(s1).filter(a -> {
//            return !a.isEmpty();
//        }).collect(Collectors.joining(" "));
    }*/

    public static String reverseWords(String s) {
        //双指针解决
        s=' '+s;
        int len=s.length();
        StringBuilder result=new StringBuilder();
        for(int left=len-1,right=len;left>=0;left--){
            char v=s.charAt(left);
            if(v==' '){
                if(left+1<right){
                    result.append(s,left+1,right);
                    result.append(' ');
                }
                right=left;
            }
        }
        return result.substring(0,result.length()-1);
    }
}
