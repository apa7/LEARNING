package com.leetcode.jindian;

/**
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 * Created by apa7 on 2020/6/3.
 */
public class Problem0101 {

    public boolean isUnique(String astr) {
        char[] arr = new char[100];
        char[] chars = astr.toCharArray();
        for (char c : chars) {
            if (arr[c] != '/') {
                arr[c] = '/';
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }

}