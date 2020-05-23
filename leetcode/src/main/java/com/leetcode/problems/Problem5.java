package com.leetcode.problems;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * Created by apa7 on 2020/5/23.
 */
public class Problem5 {

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int maxLen = 1; //最小为1，是默认没有回文串的情况取第一个字符
        int start = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (j > i && valid(arr, i, j) && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 从两头向中间验证
     */
    public boolean valid(char[] arr, int start, int end) {
        while (start < end) {
            if (arr[start++] != arr[end--]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 优化
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int maxLen = 1; //最小为1，是默认没有回文串的情况取第一个字符
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - 1; j > 1; j--) {
                if (j > i && j - i + 1 > maxLen && valid(arr, i, j)) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }


    /**
     * 中心扩散.
     * 以特殊符号填充间隙
     * 从数组索引位置向两边取最大回文的步长
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        String str = fill(s.toCharArray());
        char[] arr = str.toCharArray();
        int len = arr.length;
        int maxLen = 0;
        int center = 0;
        for (int i = 1; i < len - 2; i++) {
            if (i < maxLen || len - i - 1 < maxLen) {
                break;
            }
            int palindLen = getPalindLen(arr, i);
            if (palindLen > maxLen) {
                center = i;
                maxLen = palindLen;
            }
        }
        return str.substring(center - maxLen, center + maxLen + 1).replace("|", "");
    }

    /**
     * 填充特殊字符
     * ab -> |a|b|
     * 长度一定为奇数
     */
    public String fill(char[] arr) {
        int len = arr.length;
        char[] r = new char[(len << 1) + 1];
        for (int i = 0; i < len; i++) {
            int n = i << 1;
            r[n] = '|';
            r[n + 1] = arr[i];
        }
        r[r.length - 1] = '|';
        return String.valueOf(r);
    }

    /**
     * 从中间向两头扩散，求满足回文的最大步长
     *
     * @param arr    数组
     * @param center 中间，所在数组索引
     */
    public int getPalindLen(char[] arr, int center) {
        int i = center - 1;
        int j = center + 1;
        int allowLen = 0;
        while (i >= 0 && j < arr.length) {
            if (arr[i--] == arr[j++]) {
                //记录最小失败步长
                allowLen = Math.max(allowLen, center - i - 1);
            } else {
                break;
            }
        }
        return allowLen;
    }

    public static void main(String[] args) {
        Problem5 p = new Problem5();
        String s = p.longestPalindrome("ab");
        System.out.println(s);
    }

}