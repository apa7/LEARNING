package com.leetcode.problems;

import java.util.Arrays;

/**
 * Created by apa7 on 2020/6/20.
 */
public class Problem189 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        nums = Arrays.copyOf(nums, nums.length << 1);
        k = k % nums.length;

    }

    public static void main(String[] args) {

    }
}
