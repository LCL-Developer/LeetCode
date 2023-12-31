package com.example.leetcodetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.leetcodetest.Day1.*;
import static com.example.leetcodetest.Day2.canPlaceFlowers;
import static com.example.leetcodetest.Day2.kidsWithCandies;
import static com.example.leetcodetest.Day3.reverseVowels;
import static com.example.leetcodetest.Day3.reverseWords;

@SpringBootTest
class LeetCodeTestApplicationTests {

    @Test
    void Day3test() {
        /*System.out.println(reverseVowels("hello"));*/
        //reverseWords(" hello world ");
        System.out.println( reverseWords("the sky is blue"));
    }

    @Test
    void Day2test() {
       /* int[] ints = {10, 9, 9, 4, 5};
        kidsWithCandies(ints,4);*/

        System.out.println(canPlaceFlowers(new int[]{1,0,0,0,0,1},2));
    }

    @Test
    void Day1test() {
        //System.out.println( mergeAlternately("awewa","wdw"));
        //System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcd(24, 35));//求最大公因数
    }


}
