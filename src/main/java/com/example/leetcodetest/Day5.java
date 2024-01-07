package com.example.leetcodetest;

/**
 * Description:
 *  443. 压缩字符串
 *  283. 移动零
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/7
 */
public class Day5 {
    /**
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     *
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     *
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     *
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     *
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     */
   /* public static int compress(char[] chars) {
        // 双指针问题 一个控制读取的位置 一个控制写入
        int p = 0, q = 0, n = chars.length;
        while (q < n) {
            char cur = chars[q];
            int cnt = 0;
            while(q < n && chars[q] == cur) {
                cnt ++;
                q ++;
            }
            chars[p++] = cur;
            if (cnt != 1) {
                // 将的到的数字挨个写入
                char[] counter = (cnt + "").toCharArray();
                for (char c : counter)
                    chars[p++] = c;
            }
        }
        return p;
    }*/
    public int compress(char[] chars) {
        int write=0;
        int left=0;
        int n=chars.length;
        for(int read=0;read<n;read++){
            if(read==n-1||chars[read]!=chars[read+1]){
                //将要压缩的字符写入
                chars[write++]=chars[read];
                //计算压缩的长度
                int num=read+1-left;
                //num>1处理
                /*if(num>1){
                    //将数字，一个一个输出为字符
                    //解法1：
                    char[] str=(num+"").toCharArray();
                    for(char c:str){
                        chars[write++]=c;
                    }
                }*/
                /*if(num>1){
                    //解法2：
                    String str = String.valueOf(num);
                    for(int i=0;i<str.length();i++){
                        chars[write++]=str.charAt(i);
                    }
                }*/
                if (num > 1) {
                    //解法3：
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }

                left=read+1;
            }
        }
        return write;
    }
    //反转
    private void reverse(char[] chars, int left, int right) {
        while(left<right){
            char a=chars[left];
            chars[left++]=chars[right];
            chars[right--]=a;
        }
    }
    /**
     *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */
    public void moveZeroes(int[] nums) {
        int write=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temporary=nums[i];
                nums[i]=nums[write];
                nums[write++]=temporary;
            }
        }
    }
}
