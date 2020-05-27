package com.leetcode.jzoffer;

/**
 * 面试题20. 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 * <p>
 * <p>
 * Created by apa7 on 2020/5/27.
 */
public class Problem20 {

    public boolean isNumber(String s) {
        try {
            if (s.endsWith("f") || s.endsWith("F") || s.endsWith("D") || s.endsWith("d")) {
                return false;
            }
            Double.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Problem20 p = new Problem20();
        boolean b = p.isNumber("+-5");
        System.out.println(b);
    }

}