package com.leetcode.jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * \面试题57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 * <p>
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 * Created by apa7 on 2020/6/2.
 */
public class Problem57 {

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int v = nums[j] + nums[i] - target;
            if (v > 0) {
                j--;
            } else if (v < 0) {
                //>0
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[2];
    }

    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (set.contains(num)) {
                return new int[]{target - num, num};
            }
            set.add(target - num);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Problem57 p = new Problem57();
        int[] arr = p.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(arr);
    }

}