package com.leetcode.jzoffer;

/**
 * 面试题16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * Created by apa7 on 2020/5/15.
 * <p>
 * <p>
 * 求x的n次方最简单的办法是循环将n乘起来，依次求x的1次，2次,.....,n-1,n 时间复杂度O(N)
 * 快速幂法 可将复杂度降低到O(logN),
 * 二分法和二进制两个角度解析快速幂法
 */
public class Problem16 {

    /**
     * 二分法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return 0;
    }

    /**
     * 二进制法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (x == 0) return 0;
        double v = 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (n != 0) {
            if ((n & 1) == 1) v *= x;
            x *= x;
            b = b >> 1;
            n /= 2;
        }
        return v;
    }

    public static void main(String[] args) {
        Problem16 p = new Problem16();
        double v = p.myPow2(2, 10);
        System.out.println(v);
    }

}