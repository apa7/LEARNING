package com.leetcode.problems;

/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * Created by apa7 on 2020/5/26.
 */
public class Problem9 {

    public boolean isPalindrome(int x) {
        if (x == 0) {      //0=0
            return true;
        }
        if (x < 0) {       //负数 -121!=121-
            return false;
        }
        if (x % 10 == 0) { //末尾为0, 10!=01
            return false;
        }
        int nx = x;
        try {
            int v = 0;
            while (x > 0) {
                v = v * 10 + x % 10; //高位
                x /= 10;             //低位
            }
            return v == nx;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Problem9 p = new Problem9();
        boolean r = p.isPalindrome(121);
        System.out.println(r);
    }

}