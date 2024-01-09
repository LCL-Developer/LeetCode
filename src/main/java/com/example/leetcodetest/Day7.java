package com.example.leetcodetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Description:
 * 1679. K 和数对的最大数目
 * 643. 子数组最大平均数 I
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/9
 */
public class Day7 {
    /**
     * 给你一个整数数组 nums 和一个整数 k 。
     * <p>
     * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
     * <p>
     * 返回你可以对数组执行的最大操作数。
     */
    public static int maxOperations(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        int num = 0;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
                j--;
                num++;
            }
        }
        return num;
    }
/*    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int result = 0;
        //统计每个数据出现的次数，key为数据，value为次数
        for (int num : nums) {
            // 获取求和的另一个数
            int x = k - num;
            // 从map获取x
            Integer i = map.get(x);
            // 是否有 另一个数据。且统计的数量大于0
            if (i != null && map.get(x) > 0) {
                result++;//结果+1
                map.put(x, map.get(x) - 1);// 数量减一
                continue;
            }
            //这个数没有被使用，统计数量+1
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        return result;
    }*/

    /**
     * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
     * <p>
     * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
     * <p>
     * 任何误差小于 10-5 的答案都将被视为正确答案。
     */
 /*   public static double findMaxAverage(int[] nums, int k) {
        double num=0,result=0;
        int first=0,end=0;
        while(end<nums.length){
            if(end<k){
                num+=nums[end++];
            }else{
                num=num-nums[first++]+nums[end++];
            }
            double a=num/k;
            result= a > result?a:result;
        }
        return result;
    }*/
    public static double findMaxAverage(int[] nums, int k) {
        //滑动窗口
        int num = 0;
        for (int i = 0; i < k; i++) {
            num += nums[i];
        }
        int result = num;
        for (int j = k; j < nums.length; j++) {
            num = num - nums[j - k] + nums[j];
            result = Math.max(num, result);
        }
        return 1.0 * result / k;
    }
}
