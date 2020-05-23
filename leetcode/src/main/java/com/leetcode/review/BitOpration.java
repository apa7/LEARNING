package com.leetcode.review;

/**
 * Created by apa7 on 2020/5/23.
 */
public class BitOpration {

    public static void main(String[] args) {
        int i = 345 % 16;
        int j = 345 & (16 - 1);
        System.out.println(i == j);
    }

}
