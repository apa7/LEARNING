package com.leetcode.problems;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * 通过次数31,175提交次数59,032
 * Created by apa7 on 2020/7/1.
 */
public class Problem718 {

    //方法1，dp, 二维数组
    public int findLength(int[] A, int[] B) {
        int len1 = A.length;
        int len2 = B.length;
        int[][] dp = new int[len1][len2];
        int res = 0;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
