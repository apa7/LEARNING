package com.leetcode.base.array;

import java.util.Arrays;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * Created by apa7 on 2020/5/17.
 */
public class Solution3 {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (len <= 1 || k == 0) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k);
        reverse(nums, k + 1, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        /*1, 2, 3, 4, 5, 6, 7
        7, 1, 2, 3, 4, 5, 6
        5, 6, 7, 1, 2, 3, 4*/
        Solution3 s3 = new Solution3();
        s3.rotate(arr, 4);
        System.out.println(arr);
    }

}