package com.leetcode.jzoffer;


import java.util.concurrent.Semaphore;

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 * Created by apa7 on 2020/6/9.
 */
public class Problem46 {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < chars.length; i++) {
            int union = 'a' + Integer.valueOf(String.valueOf(new char[]{chars[i - 1], chars[i]}));
            int k = 0;
            if (union >= 'a' + 10 && union <= 'z') {
                if (i != 1) {
                    k = dp[i - 2];
                } else {
                    k = 1;
                }
            }
            dp[i] = dp[i - 1] + k;
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        Problem46 p = new Problem46();
        p.translateNum(506);
        Semaphore s = new Semaphore(2);
    }

}