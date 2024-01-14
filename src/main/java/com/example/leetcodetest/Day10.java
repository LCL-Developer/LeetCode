package com.example.leetcodetest;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Description:
 * 724. 寻找数组的中心下标
 * 2215. 找出两数组的不同
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/12
 */
public class Day10 {
    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * <p>
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * <p>
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     */
 /*   //错误案例 不适合用贪心 因为贪的不够纯（指向不单一）
    public static int pivotIndex(int[] nums) {
        int right=0,left=nums.length-1;
        int sumr=0,suml=0;
        while(right<left){
            if(sumr<suml){
                sumr+=nums[right++];
            }else{
                suml+=nums[left--];
            }
        }
        return suml==sumr? left:-1;
    }*/
    public static int pivotIndex(int[] nums) {
        //思路：左求和*2+中心索引值 = 总和
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
     * <p>
     * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
     * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
     * 注意：列表中的整数可以按 任意 顺序返回。
     */
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //stream 写法 （效率低）
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.asList(
                s1.stream().filter(a -> !s2.contains(a)).collect(Collectors.toList()),
                s2.stream().filter(a -> !s1.contains(a)).collect(Collectors.toList()));
    }

    //哈希表
}
