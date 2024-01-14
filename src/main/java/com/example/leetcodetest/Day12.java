package com.example.leetcodetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description:
 * 2352. 相等行列对
 * 2390. 从字符串中移除星号
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/14
 */
public class Day12 {
    /**
     * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
     * <p>
     * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
     */
    public static int equalPairs(int[][] grid) {
        //以 行 为key值构建哈希Map
        HashMap<List<Integer>, Integer> m = new HashMap<>();
        for (int[] s : grid) {
            List<Integer> list = new ArrayList<>();
            for (int i : s) {
                list.add(i);
            }
            m.put(list, m.getOrDefault(list, 0) + 1);
        }
        int n = grid.length;
        int result = 0;
        ////以 列 为key值查看是否在 哈希Map 中
        for (int column = 0; column < n; column++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(grid[i][column]);
            }
            if (m.containsKey(list)) {
                result += m.get(list);
            }
        }
        return result;
    }

    /**
     * 给你一个包含若干星号 * 的字符串 s 。
     * <p>
     * 在一步操作中，你可以：
     * <p>
     * 选中 s 中的一个星号。
     * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
     * 返回移除 所有 星号之后的字符串。
     * <p>
     * 注意：
     * <p>
     * 生成的输入保证总是可以执行题面中描述的操作。
     * 可以证明结果字符串是唯一的。
     */
/*    public  static String removeStars(String s) {
        int entity=-1;
        StringBuilder result=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*'){
                result.deleteCharAt(entity--);
            }else{
                result.append(s.charAt(i));
                entity++;
            }
        }
        return result.toString();
    }*/
    public static String removeStars(String s) {
        int n = s.length();
        int entity = 0;
        char[] result = new char[n];
        for (char c : s.toCharArray()) {
            if (c == '*') {
                entity--;   //这里是区别于上面的一个妙点
            } else {
                result[entity++] = c;
            }
        }
        return String.valueOf(result, 0, entity);
    }
}
