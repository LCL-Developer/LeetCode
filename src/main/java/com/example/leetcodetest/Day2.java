package com.example.leetcodetest;

import java.util.*;

/**
 * Description:
 * 1431. 拥有最多糖果的孩子
 * 605. 种花问题
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2023/12/30
 */
public class Day2 {
    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies)
                .reduce((m, candie) -> {
                    return m < candie ? candie : m;
                })
                .getAsInt();
        List<Boolean> boolens = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            boolens.add(i, candies[i] + extraCandies >= max ? true : false);
        }
        return boolens;
    }

    /*
        static int  max = 0;
        public static boolean canPlaceFlowers(int[] flowerbed, int n) {
            Arrays.stream(flowerbed)
                    .reduce((old, iden) -> {
                        if (old + iden == 0) {
                            max++;
                            return 1;
                        }
                        if(old+iden==2){
                            max--;
                        }
                        return iden;
                    });
            return max>=n?true:false;
        }
    */

    /**
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = -1, r = 0;//滑动窗口，维护一个固定大小为3的窗口，l左边界，r 右边界，花种在中间
        while (r <= flowerbed.length) {
            int rv = r == flowerbed.length ? 0 : flowerbed[r];
            r++;
            if (rv == 1) {
                l = r;
            }
            if (r - l == 3) {
                n--;
                l += 2;
            }
        }
        return n <= 0;
    }
}
