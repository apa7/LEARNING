package com.leetcode.problems;

/**
 * 188. 买卖股票的最佳时机 IV
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,4,1], k = 2
 * 输出: 2
 * 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2:
 * <p>
 * 输入: [3,2,6,5,0,3], k = 2
 * 输出: 7
 * 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * Created by apa7 on 2020/5/22.
 */
public class Problem188 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length <= 1) {
            return 0;
        }
        int[][] p = new int[k][2]; //k, p[k][0] buy, p[k][1] sell
        for (int i = 0; i < p.length; i++) {
            p[i][0] = Integer.MIN_VALUE; // buyK
            p[i][1] = 0;                 // sellK
        }
        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    p[i][0] = Math.max(p[i][0], -price);
                } else {
                    p[i][0] = Math.max(p[i][0], p[i - 1][1] - price);
                }
                p[i][1] = Math.max(p[i][1], p[i][0] + price);
            }
        }
        return p[k - 1][1];
    }

    public static void main(String[] args) {
        Problem188 p = new Problem188();
        int i = p.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3});
        System.out.println(i);
    }

}