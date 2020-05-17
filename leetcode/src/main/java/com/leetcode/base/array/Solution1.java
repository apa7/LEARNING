package com.leetcode.base.array;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * Created by apa7 on 2020/5/17.
 */
public class Solution1 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[idx] != nums[i]) {
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {1, 1, 1, 2, 2, 5, 6, 6};
        int i = s.removeDuplicates(arr);
        System.out.println(arr);
        System.out.println(i);
    }

}
