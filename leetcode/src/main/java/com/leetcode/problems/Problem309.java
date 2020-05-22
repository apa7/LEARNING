package com.leetcode.problems;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * Created by apa7 on 2020/5/22.
 */
public class Problem309 {

    public int maxProfit(int[] prices) {
        int sell = 0; //卖出，上一天持有 + 剩余利润
        int hold = Integer.MIN_VALUE; //持有，上一天冻结或持有
        int rest = 0; //冻结，上一天卖出或冻结
        for (int price : prices) {
            int preSell = sell;
            sell = Math.max(sell, hold + price);
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, preSell);
        }
        return Math.max(rest, sell); //最后可能卖出或冻结
    }

    public static void main(String[] args) {
        Problem309 p = new Problem309();
        int i = p.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(i);
    }

}