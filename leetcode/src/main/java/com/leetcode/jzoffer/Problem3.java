package com.leetcode.jzoffer;

/**
 * Created by apa7 on 2020/5/11.
 */
public class Problem3 {
    public int findRepeatNumber(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int numi = nums[i];
            arr[numi]++;
            if (arr[numi] > 1) {
                return numi;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int repeatNumber = new Problem3().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber);
    }

}