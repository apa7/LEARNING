package com.leetcode.jzoffer;

/**
 * 面试题56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * Created by apa7 on 2020/6/11.
 */
public class Problem56_1 {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int flag = sum & (-sum);

        //first为1，所以我们可以根据数组元素的二进制低位第一位是否为1，将数组分为2类，
        // 示例数组可以分为     低位第一位为0：[4,4,6]     低位第一位为1：[1]
        //此时再将两个数组两两异或就可以得到最终结果。
        int result = 0;
        for (int num : nums) {
            if ((num & flag) != 0) {
                result ^= num;
            }
        }
        return new int[]{result, result ^ sum};
    }

    public static void main(String[] args) {
        Problem56_1 p = new Problem56_1();
        int[] r = p.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
        System.out.println(r);
    }
}