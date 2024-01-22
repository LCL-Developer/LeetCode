package com.example.leetcodetest;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Description:
 * 735. 小行星碰撞
 * 394. 字符串解码
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/17
 */
public class Day13 {
    /**
     * 给定一个整数数组 asteroids，表示在同一行的小行星。
     * <p>
     * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
     * <p>
     * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：asteroids = [5,10,-5]
     * 输出：[5,10]
     * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
     */

    public static int[] asteroidCollision(int[] asteroids) {
        int stackTop = 0, i = 1;
        while (i < asteroids.length) {
            int first = 0;
            int tail = 0;
            if (stackTop >= 0 &&
                    (first = Math.abs(asteroids[stackTop])) +
                            (tail = Math.abs(asteroids[i]))
                            > Math.abs(asteroids[stackTop] + asteroids[i]) &&
                    asteroids[stackTop] > asteroids[i]) {
                if (tail > first) {
                    asteroids[stackTop--] = asteroids[i];
                } else if (tail < first) {
                    i++;
                } else {
                    i++;
                    stackTop--;
                }
            } else {
                // 同向
                asteroids[++stackTop] = asteroids[i++];
            }
        }
        return Arrays.copyOf(asteroids, stackTop + 1);
    }

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     */
    public static String decodeString(String s) {
        int i = 0, number = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        while (i < s.length()) {
            int c = s.charAt(i) - '0';
            if (c > 0 && c < 10) {
                int temp = i;
                while ('[' != (s.charAt(++i))) {
                    // 处理数字
                }
                number = Integer.valueOf(s.substring(temp, i));
                stack.push(number);
                stack.push(++i);
            } else if (']' == s.charAt(i)) {
                if (stack.set(1, stack.get(1) - 1) == 1) {
                    i++;
                    stack.poll();
                    stack.poll();
                    continue;
                } else {
                    // 回跳
                    i = stack.peek();
                }
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
