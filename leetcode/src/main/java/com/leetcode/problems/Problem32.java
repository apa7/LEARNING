package com.leetcode.problems;

import java.util.Stack;
import java.util.Vector;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * Created by apa7 on 2020/7/4.
 */
public class Problem32 {

    public int longestValidParentheses(String s) {
        //Stack<Integer> stack = new Stack<>();
        int[] stack = new int[s.length()];
        int stackTop = -1;
        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ')' && stackTop >= 0 && cs[stack[stackTop]] == '(') {
                dp[i] = 1;
                dp[stack[stackTop--]] = 1;
            } else {
                stack[++stackTop] = i;
            }
        }
        int res = 0;
        for (int j = 1; j < dp.length; j++) {
            if (dp[j] > 0) dp[j] += dp[j - 1];
            res = Math.max(res, dp[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        int r = new Problem32().longestValidParentheses("(");
        System.out.println(r);
    }
}