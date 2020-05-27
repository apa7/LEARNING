package com.leetcode.problems;

/**
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= len <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 * Created by apa7 on 2020/5/27.
 */
public class Problem974 {

    public int subarraysDivByK(int[] A, int K) {
        int len = A.length;
        if (len == 0) {
            return 0;
        }
        int[] modArr = new int[K];
        modArr[0] = 1;
        int sum = 0;
        for (int v : A) {
            sum += v;
            //负数取模+K，避免负数索引越界的问题
            modArr[(sum % K + K) % K]++;
        }
        int result = 0;
        for (int i = 0; i < K; i++) {
            result += modArr[i] * (modArr[i] - 1) / 2;
        }
        return result;
    }

    /**
     * 排列组合个数
     * 阶乘+1
     */
    private int combination(int n) {
        if (n <= 1) {
            return 1;
        }
        int v = 1;
        while (n > 0) {
            v *= (n--);
        }
        return v + 1;
    }

    public static void main(String[] args) {
        Problem974 p = new Problem974();
        p.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        int c = p.combination(3);
        System.out.println(c);
    }

}