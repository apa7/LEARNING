package com.leetcode.base.string;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * Created by apa7 on 2020/5/19.
 */
public class Solution2 {

    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String s = x + "";
        String flag = "";
        if (s.startsWith("-")) {
            flag = "-";
            s = s.substring(1);
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        try {
            return Integer.parseInt(flag + String.valueOf(chars));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        int reverse = s2.reverse(-1534236469);
        System.out.println(reverse);
    }

}