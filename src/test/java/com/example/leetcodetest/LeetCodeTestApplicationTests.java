package com.example.leetcodetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.leetcodetest.Day1.*;
import static com.example.leetcodetest.Day10.pivotIndex;
import static com.example.leetcodetest.Day11.closeStrings;
import static com.example.leetcodetest.Day11.uniqueOccurrences;
import static com.example.leetcodetest.Day12.removeStars;
import static com.example.leetcodetest.Day13.decodeString;
import static com.example.leetcodetest.Day14.predictPartyVictory;
import static com.example.leetcodetest.Day15.deleteMiddle;
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
    void Day15test() {
        //创建链表，这里为了方便明了，没有去封装方法
        Day15.ListNode head = new Day15.ListNode(1,
                new Day15.ListNode(2,
                        new Day15.ListNode(3,
                                new Day15.ListNode(4,
                                        new Day15.ListNode(5,
                                                new Day15.ListNode(6,
                                                        new Day15.ListNode(7)))))));

        deleteMiddle(head);
    }

    @Test
    void Day14test() {
        System.out.println(predictPartyVictory("DDRRR"));
    }

    @Test
    void Day13test() {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        System.out.println(decodeString("3[a]2[bc]"));
    }

    @Test
    void Day12test() {
        System.out.println(removeStars("leet**cod*e"));
    }

    @Test
    void Day11test() {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        closeStrings("abc", "bca");
    }

    @Test
    void Day10test() {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    void Day9test() {
        System.out.println(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));

    }

    @Test
    void Day7test() {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));

    }

    @Test
    void Day6test() {
        isSubsequence("abc", "ahbgdc");

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
