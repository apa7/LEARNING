package com.leetcode.jindian;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 面试题 08.13. 堆箱子
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 * <p>
 * 输入使用数组[wi, di, hi]表示每个箱子。
 * <p>
 * 示例1:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 * 输出：6
 * 示例2:
 * <p>
 * 输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 * 输出：10
 * 提示:
 * <p>
 * 箱子的数目不大于3000个。
 * Created by apa7 on 2020/6/24.
 */
public class Problem0813 {

    final int w = 0;
    final int d = 1;
    final int h = 2;

    public int pileBox(int[][] box) {
        Arrays.sort(box, (i, j) -> (i[w] != j[w] ? i[w] - j[w] : (i[d] != j[d] ? i[d] - j[d] : i[h] - j[h])));
        int[] dp = new int[box.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = box[i][h];
            for (int j = 0; j < i; j++) {
                if (box[i][w] > box[j][w] && box[i][d] > box[j][d] && box[i][h] > box[j][h]) {
                    dp[i] = Math.max(dp[i], box[i][h] + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

}