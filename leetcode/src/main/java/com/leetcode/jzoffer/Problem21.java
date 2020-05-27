package com.leetcode.jzoffer;

/**
 * 面试题21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * 通过次数24,047提交次数37,690
 * Created by apa7 on 2020/5/27.
 */
public class Problem21 {

    public int[] exchange(int[] nums) {
        quilk(nums, 0, nums.length - 1);
        return nums;
    }

    public void quilk(int[] nums, int L, int R) {
        int left = L;
        int right = R;
        while (left < right) {
            while (left <= right && (nums[right] & 1) == 0) {
                right--;
            }
            while (left <= right && (nums[left] & 1) == 1) {
                left++;
            }
            if (left <= right) {
                swap(nums, left, right);
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        Problem21 p = new Problem21();
        int[] ex = p.exchange(new int[]{1, 2, 3, 4});
        System.out.println(ex);
    }

}