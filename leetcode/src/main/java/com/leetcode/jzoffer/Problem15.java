package com.leetcode.jzoffer;

/**
 * 面试题15. 二进制中1的个数
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * Created by apa7 on 2020/5/15.
 */
public class Problem15 {

    // you need to treat n as an unsigned value

    /**
     * 巧用 n&(n−1)
     * (n−1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，此 11 右边的 00 都变成 11 。
     * n-1比n少了最后一位的1，所以差1位.
     * n&(n−1) 解析： 二进制数字 nn 最右边的 11 变成 00 ，其余不变。
     *
     *
     * 算法流程：
     * 初始化数量统计变量 resres 。
     * 循环消去最右边的 11 ：当 n = 0n=0 时跳出。
     * res += 1 ： 统计变量加 11 ；
     * n &= n - 1 ： 消去数字 nn 最右边的 11 。
     *
     *
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            n = n & (n - 1);
            c++;
        }
        return c;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Problem15 p = new Problem15();
        int i = p.hammingWeight(100);
        System.out.println(i);
    }

}