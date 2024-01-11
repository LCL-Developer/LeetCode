package com.example.leetcodetest;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 1732. 找到最高海拔
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/11
 */
public class Day9 {
    /**
     * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
     *
     * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
     *
     * 如果不存在这样的子数组，请返回 0 。
     */
    public static int longestSubarray(int[] nums) {
        //与Day8中的 1004. 最大连续1的个数 III 该题解法一样
        //该代码具有普遍性
        // 滑动窗口 + 贪吃蛇 + 额度
        int k = 1, l = 0, r = 0;
        while (l < nums.length) {
            if (nums[l++] == 0)
                k--;
            if (k < 0 && nums[r++] == 0)
                k++;
        }
        return l - k - r;
    }
    /**
     * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
     *
     * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
     */
   /* public static int largestAltitude(int[] gain) {
        //你在代码中使用了max变量，但是Lambda表达式中使用的是局部变量，无法在Lambda表达式中修改。
        //为了解决这个问题，你可以将max变量声明为一个包含可修改状态的容器，例如使用AtomicInteger类来保存最大值。
        AtomicInteger max = new AtomicInteger(0);
        Arrays.stream(gain).reduce((a, b)->{
            max.set(Math.max(max.get(),a+b));
            return a+b;
        });
        return max.get();
    }*/
    public static int largestAltitude(int[] gain) {
        int max = 0, temp = 0;
        for (int i : gain) {
            max = Math.max(max, temp += i);
        }
        return max;
    }
}
