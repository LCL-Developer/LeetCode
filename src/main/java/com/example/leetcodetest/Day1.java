package com.example.leetcodetest;

/**
 * Description:
 * 1768. 交替合并字符串
 * 1071. 字符串的最大公因子
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2023/12/27
 */
public class Day1 {
    /**
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     */
/*    public static String mergeAlternately(String word1, String word2) {
        char[] char1=word1.toCharArray();
        char[] char2=word2.toCharArray();
        int len1 =char1.length;
        int len2 =char2.length;
        int min = Integer.compare(len1,len2)<0 ? len1:len2;
        char[] merge = new char[min*2];
        for(int i=0;i<min;i++){
            merge[i<<1] =char1[i];
            merge[(i<<1)+1]=char2[i];
        }
        StringBuilder result=new StringBuilder("");
        return result.append(String.valueOf(merge)).append(word1.substring(min)).append(word2.substring(min)).toString();
    }*/
    public static String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder result = new StringBuilder();
        while (i < len1 || j < len2) {
            if (i < len1)
                result.append(word1.charAt(i++));
            if (j < len2)
                result.append(word2.charAt(j++));
        }
        return result.toString();
    }

    /**
     * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
     */

    public static String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        String T = str1.substring(0, gcd(len1, len2));
        if (check(str1, T) && check(str2, T)) {
            return T;
        }
        return "";
    }
    //求解最大公约数（公因子）
    public static int gcd(int len1, int len2) {
        if (len2 == 0) {
            return len1;
        }
        return gcd(len2, len1 % len2);
    }
    //解决ABCDFE ABC 问题
    public static boolean check(String s, String t) {
        int lenx = s.length() / t.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lenx; i++) {
            builder.append(t);
        }
        return builder.toString().equals(s);
    }
}


