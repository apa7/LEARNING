package com.leetcode.jzoffer;

/**
 * 面试题14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * Created by apa7 on 2020/5/15.
 * <p>
 * 不同于上一题，需要取模，所以用贪心思想
 * 剪绳子数学问题其实就是尽可能多地切3的片段，我们可以以n>4来作为循环跳出点。
 */
public class Problem14_2 {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long result = 1;
        while (n > 4) {
            result *= 3;
            result = result % 1000000007;
            n -= 3;
        }
        return (int) (result * n % 1000000007);
    }


}