package com.example.leetcodetest;

import java.util.*;

/**
 * Description:
 * 1207. 独一无二的出现次数
 * 1657. 确定两个字符串是否接近
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/13
 */
public class Day11 {
    /**
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     * <p>
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     */
 /*   public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> h=new HashMap<>();
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int a:arr){
            h.put(a,(h.get(a)==null?0:h.get(a))+1);
        }
        for(int a:arr){
            if(s.get(h.get(a))!=null&&s.get(h.get(a))!=a) return false;
            s.put(h.get(a),a);
        }
        return true;
    }*/
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> h = new HashMap<>();
        HashSet<Integer> s = new HashSet<>();
        for (int a : arr) {
            h.put(a, h.getOrDefault(a, 0) + 1);
        }
        for (int a : h.keySet()) {
            if (!s.add(h.get(a)))
                return false;
        }
        return true;
    }

    /**
     * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
     * <p>
     * 操作 1：交换任意两个 现有 字符。
     * 例如，abcde -> aecdb
     * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
     * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
     * 你可以根据需要对任意一个字符串多次使用这两种操作。
     * <p>
     * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
     */
  /*  public static boolean closeStrings(String word1, String word2) {
        //效率很低（错误案例）
        int len1 = word1.length(), len2 = word2.length();
        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();
        if (len1 != len2)
            return false;
        for (int i = 0; i < len1; i++) {
            h1.put(word1.charAt(i), h1.getOrDefault(word1.charAt(i), 0) + 1);
            h2.put(word2.charAt(i), h2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        HashMap<Integer,Integer> s=new HashMap<>();
        for (char c:h2.keySet()) {
            s.put(h2.get(c),s.getOrDefault(h2.get(c), 0) + 1);
        }
        for (char c:h1.keySet()) {
            if(h2.get(c)==null) return false;
            if(s.getOrDefault(h1.get(c),0)<=0) return false;
            s.put(h1.get(c),s.getOrDefault(h1.get(c), 0) - 1);
        }
        return true;
    }*/
    public static boolean closeStrings(String word1, String word2) {
        //长度相等 字符集相等 频率数组相等 （与上面代码思路一样）
        //妙用在于 new int[26] 没有再去增加 频率数组 而是利用 int[] 直接进行频控 这是HashMap 所达不到的
        int n1 = word1.length(), n2 = word2.length();
        if (n1 != n2)
            return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n1; i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] == 0 && cnt2[i] != 0 || cnt1[i] != 0 && cnt2[i] == 0)
                return false;
        }
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i])
                return false;
        }
        return true;
    }
}
