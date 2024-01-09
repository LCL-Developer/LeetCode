package com.example.leetcodetest;

/**
 * Description:
 * 392. 判断子序列
 * 11. 盛最多水的容器
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/8
 */
public class Day6 {
    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * <p>
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * <p>
     * 进阶：
     * <p>
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     */
    public static boolean isSubsequence(String s, String t) {
        //双指针
        int temporary = 0;
        int slen = s.length();
        int tlen = t.length();
        if (slen == 0) return true;
        for (int i = 0; i < tlen; i++) {
            if (s.charAt(temporary) == t.charAt(i)) temporary++;
            if (temporary >= slen) return true;
        }
        return false;
    }
    /*public static boolean isSubsequence(String s, String t) {
        //进阶，动态规划
        //解决 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        // 初始f
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        // 构造f
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < 26; i++) {
                if (t.charAt(j) == (i + 'a'))
                    f[j][i] = j;
                else
                    f[j][i] = f[j + 1][i];
            }
        }
        // 判断s是否为t子序列
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (f[temp][s.charAt(i) - 'a'] == m) {
                return false;
            }
            temp = f[temp][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }*/

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     */
    public static int maxArea(int[] height) {
        //贪心 双指针
        /*在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 −1 变短：
        若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
        若向内 移动长板 ，水槽的短板 min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
        因此，初始化双指针分列水槽左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。*/

        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
            //  (j-i)*height[i++]这个顺序不能错，先执行（j-i)再执行(height[i])再执行i++；
            //  如果写成height[i++]*(j-i)会出错
        }
        return res;
    }
}
