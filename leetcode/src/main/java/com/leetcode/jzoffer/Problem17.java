package com.leetcode.jzoffer;

import java.util.Arrays;

/**
 * 面试题17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * 考虑大数问题
 * Created by apa7 on 2020/5/18.
 */
public class Problem17 {

    public int[] printNumbers(int n) {
        int[] arr = new int[9];
        int pow = 1;
        for (int i = 1; i <= n; i++) {
            int target = pow * 10;
            arr = Arrays.copyOf(arr, target - 1);
            for (int j = pow; j < target; j++) {
                arr[j - 1] = j;
            }
            pow = target;
        }
        return arr;
    }

    public static void main(String[] args) {
        Problem17 p = new Problem17();
        int[] ints = p.printNumbers(8);
        System.out.println(ints);
    }

}