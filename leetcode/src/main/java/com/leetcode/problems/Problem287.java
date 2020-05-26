package com.leetcode.problems;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * Created by apa7 on 2020/5/26.
 */
public class Problem287 {

    Integer dumplicate = null;

    public int findDuplicate(int[] nums) {
        quilk(nums, 0, nums.length - 1);
        return dumplicate;
    }

    private void quilk(int[] nums, int L, int R) {
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        Problem287 p = new Problem287();
        int duplicate = p.findDuplicate(arr);
        System.out.println(duplicate);
    }

}