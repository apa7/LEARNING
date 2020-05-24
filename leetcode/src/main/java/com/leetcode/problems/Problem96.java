package com.leetcode.problems;


/**
 * 96. 不同的二叉搜索树
 * // 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * //
 * // 示例:
 * //
 * // 输入: 3
 * // 输出: 5
 * // 解释:
 * // 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * //
 * //1         3     3      2      1
 * // \       /     /      / \      \
 * //  3     2     1      1   3      2
 * // /     /       \                 \
 * //2     1         2                 3
 * Created by apa7 on 2020/5/23.
 */
public class Problem96 {

    /**
     * f1_0 = 1, f0_1 = 1, f1_1 = 1
     * <p>
     * f1 = f1_0 = 1
     * f2 = f1_0 + f0_1 = 1 + 1 = 2
     * f3 = f2_0 + f1_1 + f0_2 = 2 + 1 + 2 = 5
     * f4 = f3_0 + f2_1 + f1_2 + f0_3 = 5 + 2 + 2 + 5 =  14
     * f5 = f4_0 + f3_1 + f2_2 + f1_3 + f0_4
     * ...
     */
    public int numTrees(int n) {
        int r = 0;
        for (int i = 0; i < n; i++) {
            int l = f(i, n - 1 - i);
            r += l;
        }
        return r;
    }

    public int f(int left, int right) {
        /*if (left <= 2 && right <= 2 && left + right <= 3) {
            return left | right;
        } else if ((left | right) == 3) {
            return 5;
        }*/
        return f(left - 1, right) + f(left, right - 1);
    }

    public static void main(String[] args) {
        Problem96 p = new Problem96();
        //int r = p.f(2, 1);
        int r = p.numTrees(4);
        System.out.println(r);
    }

}