package com.leetcode.base.array;

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
        if (len <= 1 || k == 0) {
            return;
        }
        int currentIdx = 0;
        int pre = nums[currentIdx];
        for (int i = 0; i < len; i++) {
            int targetIdx = (currentIdx + k) % len;
            int temp = nums[targetIdx];
            nums[targetIdx] = pre;
            /*if (length % k == 0 && (i + 1) % (length / k) == 0) {
                targetIdx++;
                temp = nums[targetIdx];
            }*/
            pre = temp;
            currentIdx = targetIdx;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6,7,8};
        /*1, 2, 3, 4, 5, 6, 7
        7, 1, 2, 3, 4, 5, 6
        5, 6, 7, 1, 2, 3, 4*/
        Solution3 s3 = new Solution3();
        s3.rotate(arr,4);
        System.out.println(arr);
    }

}