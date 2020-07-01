package com.leetcode.jzoffer;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 * Created by apa7 on 2020/7/1.
 */
public class Problem49 {

    public int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        int[] dp = new int[n];
        dp[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        for (int i = 1; i < n; i++) {
            int v = Math.min(dp[idx2] * 2, Math.min(dp[idx3] * 3, dp[idx5] * 5));
            dp[i] = v;
            if (v == dp[idx2] * 2) {
                idx2++;
            } else if (v == dp[idx3] * 3) {
                idx3++;
            } else if (v == dp[idx5] * 5) {
                idx5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int v = new Problem49().nthUglyNumber(10);
        System.out.println(v);
    }
}