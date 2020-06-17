package com.leetcode.jzoffer;

/**
 * Created by apa7 on 2020/6/16.
 */
public class Problem39 {

    /**
     * 摩尔投票算法是基于这个事实：
     * 票数和：由于众数出现的次数超过数组长度的一半；若记 众数 的票数为 +1 ，非众数 的票数为 -1 ，则一定有所有数字的 票数和 > 0 。
     * 票数正负抵消：设数组 nums 中的众数为x，数组长度为n。
     * 若nums的前a个数字的票数和=0，则 数组后(n-a)个数字的 票数和一定仍>0 （即后 (n-a)个数字的众数仍为x）。
     */
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes = num == x ? votes + 1 : votes - 1;
        }
        return x;
    }

    public static void main(String[] args) {

    }

}