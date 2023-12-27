package com.example.leetcodetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static com.example.leetcodetest.Day1.*;

@SpringBootTest
class LeetCodeTestApplicationTests {

    @Test
    void Day1test() {
        //System.out.println( mergeAlternately("awewa","wdw"));
       //System.out.println(gcdOfStrings("ABCABC","ABC"));
        System.out.println(gcd(24,35));//求最大公因数
    }


}
