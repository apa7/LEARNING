package com.leetcode.problems;

import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * Created by apa7 on 2020/6/27.
 */
public class Problem41 {


    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                //将正确的数覆盖到正确的索引，如值1覆盖到nums[0],值2覆盖到nums[1]...
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        Problem41 p = new Problem41();
        p.firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10});
    }

}
