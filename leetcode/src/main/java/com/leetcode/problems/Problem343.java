package com.leetcode.problems;

import com.leetcode.jzoffer.Problem14;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * Created by apa7 on 2020/5/15.
 */
public class Problem343 {

    //Problem14

    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n % 3;
        int b = n / 3;
        if (a == 0) {
            return (int) Math.pow(3, b);
        }
        if (a == 1) {
            // 3 * 1  -> 2 * 2
            return (int) Math.pow(3, b - 1) * 2 * 2;
        }
        return (int) Math.pow(3, b) * 2;
    }

}