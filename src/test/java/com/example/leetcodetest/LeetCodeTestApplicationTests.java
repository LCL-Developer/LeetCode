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
import static com.example.leetcodetest.Day4.increasingTriplet;
import static com.example.leetcodetest.Day4.productExceptSelf;
import static com.example.leetcodetest.Day5.compress;
import static com.example.leetcodetest.Day5.moveZeroes;
import static com.example.leetcodetest.Day6.isSubsequence;
import static com.example.leetcodetest.Day7.findMaxAverage;
import static com.example.leetcodetest.Day9.largestAltitude;

@SpringBootTest
class LeetCodeTestApplicationTests {

    @Test
    void Day9test() {
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));

    }

    @Test
    void Day7test() {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));

    }

    @Test
    void Day6test() {
        isSubsequence("abc","ahbgdc");

    }

    @Test
    void Day5test() {
      /*  compress(new char[]{'a','b','b','b','c'});
        moveZeroes(new int[]{0,1,2,0,3,0,6});*/
    }

    @Test
    void Day4test() {
      /*  productExceptSelf(new int[]{1,2,3,4,5});*/
        System.out.println(increasingTriplet(new int[]{1, 2, 3}));
    }

    @Test
    void Day3test() {
        /*System.out.println(reverseVowels("hello"));*/
        //reverseWords(" hello world ");
        System.out.println(reverseWords("the sky is blue"));
    }

    @Test
    void Day2test() {
       /* int[] ints = {10, 9, 9, 4, 5};
        kidsWithCandies(ints,4);*/

        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }

    @Test
    void Day1test() {
        //System.out.println( mergeAlternately("awewa","wdw"));
        //System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcd(24, 35));//求最大公因数
    }


}
