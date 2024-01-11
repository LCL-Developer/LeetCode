package com.example.leetcodetest;/**
 * Description:
 * 1456. 定长子串中元音的最大数目
 * 1004. 最大连续1的个数 III
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/10
 */public class Day8 {
    /**
     * 给你字符串 s 和整数 k 。
     *
     * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
     *
     * 英文中的 元音字母 为（a, e, i, o, u）。
     */
    public static int maxVowels(String s, int k) {
        int result=0;
        for(int i=0;i<k;i++){
            result+=isContain(s.charAt(i));
        }
        int max=result;
        int n=s.length();
        for(int i=k;i<n;i++){
            result+=isContain(s.charAt(i))-isContain(s.charAt(i-k));
            max=Math.max(max,result);
        }
        return max;
    }

    public static int isContain(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }
/*    public static int maxVowels(String s, int k) {
        //拿空间换时间，充分利用了数组特性实现查找O(1)
        int[] chars=new int[26];
        chars['a'-0x61]=1;
        chars['e'-0x61]=1;
        chars['i'-0x61]=1;
        chars['o'-0x61]=1;
        chars['u'-0x61]=1;
        char[] array = s.toCharArray();
        int temp=0;
        for (int i = 0; i < k; i++) {
            temp+=chars[array[i]-0x61];
        }
        int max=temp;

        for (int i = k; i < array.length; i++) {
            temp-=chars[array[i-k]-0x61];
            temp+=chars[array[i]-0x61];
            if (temp>max){
                max=temp;
            }
        }
        return max;
    }*/

    /**
     * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
     */
    public static int longestOnes(int[] A, int K) {
        //这个写法维护的是一个只能单调变长的窗口。这种窗口经常出现在寻求”最大窗口“的问题中：因为要求的是”最大“，所以我们没有必要缩短窗口，
        //于是代码就少了缩短窗口的部分；从另一个角度讲，本题里的K是消耗品，一旦透支，窗口就不能再增长了（也意味着如果K == 0还是有可能增长的）。
        //所以K所代表的”资源“，通常是滑窗维护逻辑的核心，能这么写有两个先决条件：
        // 固定一个左端点，K随窗口增大是单调变化的。据此我们可以推知长度为n的窗口如若已经”透支“（K < 0）了，那么长度大于n的也一定不符合条件；
        // K的变化与数组元素有简单的算术关系。向窗口纳入（A[r++]）或移除（A[l++]）一个数组元素，可以在O(1)内更新K。
        int l = 0, r = 0;
        while (r < A.length) {
            if (A[r++] == 0) K--;
            if (K < 0 && A[l++] == 0) K++;
        }
        return r - l;
    }
}
