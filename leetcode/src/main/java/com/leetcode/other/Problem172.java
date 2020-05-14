package com.leetcode.other;

/**
 * 给定一个整数n, 返回n! 结果尾数中0的数量
 * 输入：3
 * 输出：0
 * 3! = 6 尾数没有0
 * 1 * 2 * 3
 * 输入：5
 * 输出：1
 * 3！= 120 尾数中有1个0
 * 1 * 2 * 3 * 4 * 5 =
 * <p>
 * <p>
 * 算法复杂度O(log n)
 * 也就是不用
 * Created by apa7 on 2020/5/13.
 * 题解:
 * 13
 * 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13
 * 5-9   1  1
 * 10-14 2  2
 * 15-19 3  3
 * 20-24 4  4
 * 25-29 6  5  5 * 5
 * <p>
 * 5 * 5 * 5  + 5
 * 1 + 1
 * 2
 * 3
 * 4
 * 5 +1 + 1
 * 6
 *
 * <p>
 * 每5个数必然有2个偶数，一个5因子
 * 101
 */
public class Problem172 {

//    2147483647

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }

    public long trailing(long n) {
        if (n < 5) {
            return 0;
        }
        long r = 1;
        for (int i = 1; i <= n; i++) {
            r = r * i;
        }
        return r;
    }

    public static void main(String[] args) {
        Problem172 p = new Problem172();
        long sum = p.trailingZeroes2(2147483647);
        System.out.println(sum);
    }

}