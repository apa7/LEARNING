package com.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出: 45
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10000
 * Created by apa7 on 2020/6/2.
 *
 * 1   1
 * 2   1+2  3
 * 3   1+2+3  6
 * 4   1+2+3+4  10
 */
public class Problem64 {

    public int sumNums(int n) {
        Set<Integer> set = new HashSet();
        boolean b = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Problem64 p = new Problem64();
        int i = p.sumNums(5);
        System.out.println(i);
    }

}