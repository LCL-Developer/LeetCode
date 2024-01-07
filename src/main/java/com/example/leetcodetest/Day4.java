package com.example.leetcodetest;

import java.util.Arrays;

/**
 * Description:
 * 238. 除自身以外数组的乘积
 * 334. 递增的三元子序列
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/6
 */
public class Day4 {
    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     *
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     *
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */
    public static int[] productExceptSelf(int[] nums) {
        int pre=1,after=1;
        int len=nums.length;
        int[] answer=new int[len];
        Arrays.fill(answer,1);
        for(int i=0,j=len-1;i<len;i++,j--){
            answer[i]*=pre;
            answer[j]*=after;
            pre*=nums[i];
            after*=nums[j];
        }
        return answer;
    }
    /**
     * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
     *
     * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
     */
/*    public static boolean increasingTriplet(int[] nums) {
        int a=0x7fffffff;
        int b=0x7fffffff;
        for(int x:nums){
            if(x<=a)a=x;
            else if (x<=b)b=x;
            else return true;
        }
        return false;
    }*/

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        //贪心 保持first和second最小
        int first=nums[0],second=Integer.MAX_VALUE;
        for(int x:nums){
            if(second<x){
                return true;
            }else if(first<x){
                second=x;
            }else{
                first=x;
            }
        }
        return false;
    }
    //上述做法的贪心思想是：为了找到递增的三元子序列，first 和 second 应该尽可能地小，此时找到递增的三元子序列的可能性更大。
}
