package com.leetcode.jzoffer;

/**
 * Created by apa7 on 2020/6/25.
 */
public class Problem44 {

    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;
        while ( n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = 9 * start * digit;
        }
        long num = start + (n -1)/digit;
        String s = String.valueOf(num);
        int res = (s.charAt((n-1)%digit)) - '0';
        return res;
    }

    public static void main(String[] args) {
        Problem44 p = new Problem44();
        p.findNthDigit(
                1000000000);
    }
}
