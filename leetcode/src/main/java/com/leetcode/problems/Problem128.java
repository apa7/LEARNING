package com.leetcode.problems;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * Created by apa7 on 2020/6/6.
 */
public class Problem128 {

    class Solution {

        public int longestConsecutive(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int[] arr = new int[1000];
            for (int num : nums) {
                if (num >= arr.length) {
                    arr = Arrays.copyOf(arr, arr.length << 1);
                }
                arr[num] = 1;
            }
            int max = 1;
            int count = 0;
            int pre = 0;
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                if (val != 0 && pre == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
                pre = arr[i];
            }
            return max;
        }


        public int longestConsecutive2(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int[] arr = new int[1000];
            for (int num : nums) {
                if (num >= arr.length) {
                    arr = Arrays.copyOf(arr, arr.length << 1);
                }
                arr[num] = 1;
            }
            int max = 1;
            int count = 0;
            int pre = 0;
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                if (val != 0 && pre == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 1;
                }
                pre = arr[i];
            }
            return max;
        }
    }

    public void test() {
        Solution s = new Solution();
        int r = s.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(r);
    }

    public static void main(String[] args) {
        Problem128 p = new Problem128();
        p.test();
    }

}