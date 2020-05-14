package com.leetcode.jzoffer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 提示：
 * <p>
 * 0 <= n <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by apa7 on 2020/5/12.
 * <p>
 * 解题思路：
 * n=0, 1
 * n=1, 1
 * n=2, 2 1+1
 * n=3, 3 1+2
 * n=4, 5 2+3
 * ...
 * 实际就是斐波那契数列
 */
public class Problem10_2 {

    public int fib(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int f0 = 1;
        int f1 = 1;
        int f2 = 0;
        for (int i = 2; i <= n; i++) {
            f2 = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    public static void main(String[] args) {
        Problem10_2 s = new Problem10_2();
        int fib = s.fib(1);
        System.out.println(fib);

        new ReentrantLock(true);
    }

}