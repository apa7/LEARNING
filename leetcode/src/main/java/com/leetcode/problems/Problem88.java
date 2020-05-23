package com.leetcode.problems;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * Created by apa7 on 2020/5/23.
 */
public class Problem88 {

    /***
     * 当做插入排序
     * 从右往左对比，遇到大的，右移1位，遇到小的，放到当前位置。
     * 时间复杂度O(mn)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) {
            return;
        }
        for (int idx2 = 0; idx2 < n; idx2++) {
            int insertVal = nums2[idx2];
            int idx1 = m + idx2;
            while (idx1 > 0 && insertVal < nums1[idx1 - 1]) {
                nums1[idx1] = nums1[idx1 - 1];
                --idx1;
            }
            nums1[idx1] = insertVal;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*if (nums2.length == 0 || n == 0) {
            return;
        }*/
        int end1 = m - 1;
        int end2 = n - 1;
        int p = m + n - 1;
        while (end1 >= 0 && end2 >= 0) {
            nums1[p--] = nums1[end1] > nums2[end2] ? nums1[end1--] : nums2[end2--];
        }
        //处理nums1[0]<nums2[0]的情况
        for (int i = 0; i <= end2; i++) {
            nums1[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        Problem88 p = new Problem88();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        p.merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }


}